package com.example.echoassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.echoassistant.databinding.FragmentAlexaCommandsBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [AlexaCommands.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlexaCommands : Fragment() {
    private var _binding: FragmentAlexaCommandsBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentAlexaCommandsBinding.inflate(inflater, container, false)
        return binding.root    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //stores an instance of the main activity
        val mainActivity = activity as MainActivity;

        //back button to return to the first fragment
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_alexaCommands_to_FirstFragment)
        }

        //listener for the daily brief button to display snack bar and calls the main activitys speak command
        binding.btnDailyBreif.setOnClickListener {
            mainActivity.speak("Alexa, what is on my schedule today?")
            Snackbar.make(view, "Alexa, what is on my schedule today?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //onClickListener function to speak the date command using the main activity function
        binding.btnDate.setOnClickListener {
            mainActivity.speak("Alexa, what is the date?")
            Snackbar.make(view, "Alexa, what is the date?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //onClickListener to speak the command on the button being pressed
        binding.btnTime.setOnClickListener {
            mainActivity.speak("Alexa, what is the time?")
            Snackbar.make(view, "Alexa, what is the time?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //listener for the weather button being pressed
        binding.btnWeather.setOnClickListener {
            mainActivity.speak("Alexa, what is the weather like?")
            Snackbar.make(view, "Alexa, what is the weather like?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //onClickListener to speak the relevant command on the button being pressed
        binding.btnNotifications.setOnClickListener {
            mainActivity.speak("Alexa, what are my notifications?")
            Snackbar.make(view, "Alexa, what are my notifications?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //speaks the news command on the new button being pressed
        binding.btnNews.setOnClickListener {
            mainActivity.speak("Alexa, what is the news?")
            Snackbar.make(view, "Alexa, what is the news?", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    //sets all the buttons font size
    private fun setBtnTextSize(textSize: Float){
        binding.btnDailyBreif.textSize = textSize;
        binding.btnWeather.textSize = textSize;
        binding.btnTime.textSize = textSize;
        binding.btnDate.textSize = textSize;
        binding.btnNotifications.textSize = textSize;
        binding.btnNews.textSize = textSize;
        binding.btnBack.textSize = textSize;
    }

    //sets the background colour of all of the buttons on this fragment
    private fun setBtnColour(buttonColour: Int) {
        binding.btnDailyBreif.setBackgroundColor(buttonColour);
        binding.btnWeather.setBackgroundColor(buttonColour);
        binding.btnTime.setBackgroundColor(buttonColour);
        binding.btnDate.setBackgroundColor(buttonColour);
        binding.btnNotifications.setBackgroundColor(buttonColour);
        binding.btnNews.setBackgroundColor(buttonColour);
        binding.btnBack.setBackgroundColor(buttonColour);
    }

    //sets the text colour on the buttons of this fragment
    private fun setTextColour(textColour: Int){
        binding.btnDailyBreif.setTextColor(textColour);
        binding.btnWeather.setTextColor(textColour);
        binding.btnTime.setTextColor(textColour);
        binding.btnDate.setTextColor(textColour);
        binding.btnNotifications.setTextColor(textColour);
        binding.btnNews.setTextColor(textColour);
        binding.btnBack.setTextColor(textColour);
    }

    //when this fragments is opened/re-opened the settings are refreshed
    override fun onResume(){
        super.onResume()
        val mainActivity = activity as MainActivity;
        setBtnTextSize(mainActivity.fontSize);
        setBtnColour(mainActivity.buttonCol)
        setTextColour(mainActivity.txtColour)

    }

}