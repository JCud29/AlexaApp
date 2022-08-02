package com.example.echoassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartFragmentCallback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.Settings_content,MainSettings()).commit()
        }
        else{
            title = savedInstanceState.getCharSequence(Title)
        }

        setupToolbar()
    }


    //sets the tool bar settings
    private fun setupToolbar() {
        supportActionBar?.setTitle(R.string.title_activity_settings)
    }

    //load the root preference which contains the options
    class MainSettings: PreferenceFragmentCompat(){
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }

    }

    //creates a fragment for the activity
    //(Dev Planet, 2019)
    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        val argument = pref?.extras
        val fragment = pref?.fragment?.let { supportFragmentManager.fragmentFactory.instantiate(classLoader, it)
            .apply {
                arguments = argument
                setTargetFragment(caller, 0)
            }
        }
        fragment?.let{
            supportFragmentManager.beginTransaction().replace(R.id.Settings_content, it).addToBackStack(null).commit()
        }
        title = pref?.title
        return true
    }

    companion object {
        private val Title = SettingsActivity::getTitle.toString()
    }
}

//References
//Dev Planet (Producer), & Dev Planet (Director). (2019, 25 Dec). Android Preferences Settings Screen | Android Jetpack Preferences. [Video/DVD] YouTube.
// https://www.youtube.com/watch?v=-F29CMk48RA&ab_channel=DevPlanet