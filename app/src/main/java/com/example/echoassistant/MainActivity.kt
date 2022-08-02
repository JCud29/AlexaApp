package com.example.echoassistant


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.echoassistant.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    //variable to store text to speech instance
    private lateinit var speech: TextToSpeech
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //vars to store the current setting
    var fontSize: Float = 14.0f;
    var buttonCol = Color.parseColor("#ff0000");
    var txtColour = Color.parseColor("#0000ff");

    //vars to store pre-defined colours used to set the settings
    private var blue = Color.parseColor("#0006F0");
    private var purple = Color.parseColor("#FF6200EE");
    private var white = Color.parseColor("#FFFFFF");
    private var black = Color.parseColor("#000000");
    private var orange = Color.parseColor("#F09500");
    private var skyBlue = Color.parseColor("#00E8F0");
    private var green = Color.parseColor("#00B00F");
    private var red = Color.parseColor("#E60F00");



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        //setContentView(R.layout.activity_main)

        //creates the instance of the text to speech
        //sets up text to speech with the speech rate and lang required for alexa
        //(Android Text To Speech - Kotlin Example. 2021)
        speech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
            if(it==TextToSpeech.SUCCESS){

                var result = speech.setLanguage(Locale.ENGLISH);
                speech.setSpeechRate(0.7f);
                if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "ERROR: Language not support on this device");
                }
            } else {
                Log.e("TTS", "ERROR: Text To Speech setup failed");
            }

        })

    }

    //functions to store the settings within the vars
    //(Bersyte, 2021)
    fun getSettings(){
        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val darkModeToggle = settings.getBoolean("DarkMode", false);
        val highConToggle = settings.getBoolean("HighContrast", false);
        //check for dark mode
        if (darkModeToggle) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        //check for high contrast to resolve conflict
        if (highConToggle){
            buttonCol = Color.parseColor("#08FF00");
            txtColour = Color.parseColor("#04006E");
        }
        else{
            //sets the button colour var
            when (settings.getString("BtnColor", "Purple")) {
                "Purple" -> buttonCol = purple;
                "Blue" -> buttonCol = blue;
                "Sky Blue" -> buttonCol = skyBlue;
                "Red" -> buttonCol = red;
                "Orange" -> buttonCol = orange;
                "Green" -> buttonCol = green;
                "Black" -> buttonCol = black;
                "White" -> buttonCol = white;
            }
            //sets the text colour var
            when (settings.getString("txtColour", "White")) {
                "Purple" -> txtColour = purple;
                "Blue" -> txtColour = blue;
                "Sky Blue" -> txtColour = skyBlue;
                "Red" -> txtColour = red;
                "Orange" -> txtColour = orange;
                "Green" -> txtColour = green;
                "Black" -> txtColour = black;
                "White" -> txtColour = white;
            }
        }
        //sets the fonts size
        when (settings.getString("FontSize", "14pt")) {
            "10pt" -> fontSize = 10.0f;
            "12pt" -> fontSize = 12.0f;
            "14pt" -> fontSize = 14.0f;
            "16pt" -> fontSize = 16.0f;
            "18pt" -> fontSize = 18.0f;
            "20pt" -> fontSize = 20.0f;
            "22pt" -> fontSize = 22.0f;
        }


    }

    //refreshes the settings when the app is returned to the main activity
    override fun onResume() {
        super.onResume()
        getSettings();

        //var btnAlexa: Button = findViewById(R.id.btnAlexaComs);
        //btnAlexa.setTextSize(fontSize);
    }

    //function to speak a command which is the parameter
    fun speak(command: String) {
        speech.speak(command, TextToSpeech.QUEUE_ADD, null)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //navigates to the settings from app bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menuID = item.itemId
        if(menuID==R.id.action_settings){
            NavToSettings()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun NavToSettings(){
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    //once the activity is close the speech instance destroyed
    public override fun onDestroy() {
        // Shutdown TTS
        if (speech != null) {
            speech!!.stop()
            speech!!.shutdown()
        }
        super.onDestroy()
    }


}

//References
//Android Text To Speech - Kotlin Example. (2021, ). https://www.tutorialkart.com/kotlin-android/android-text-to-speech-kotlin-example/
//
//Bersyte (Producer), & Bersyte (Director). (2021, 27 Apr). Android Implementing Preferences Settings Screen with Kotlin. [Video/DVD] Youtube.
// https://www.youtube.com/watch?v=e09sAKgMPBA&ab_channel=Bersyte
