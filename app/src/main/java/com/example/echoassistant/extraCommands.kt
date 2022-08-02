package com.example.echoassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.echoassistant.databinding.FragmentExtraCommandsBinding
import com.example.echoassistant.databinding.FragmentSmartHomeBinding
import com.google.android.material.snackbar.Snackbar


class extraCommands : Fragment() {
    private var _binding: FragmentExtraCommandsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExtraCommandsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity;

        //back button to return to the first fragment
        binding.btnExtraToHome.setOnClickListener {
            findNavController().navigate(R.id.action_extraCommands_to_FirstFragment)
        }

        //onclicklisteners for each of the buttons
        //listener is used to call the speak function to speak the commands
        //and display the snack bar of the command
        binding.btnPlay.setOnClickListener{
            mainActivity.speak("Alexa, play music")
            Snackbar.make(view, "Alexa, play music", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnPause.setOnClickListener{
            mainActivity.speak("Alexa, pause")
            Snackbar.make(view, "Alexa, pause", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTimer.setOnClickListener{
            mainActivity.speak("Alexa, set a timer for 5 minutes")
            Snackbar.make(view, "Alexa, set a timer for 5 minutes", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTimerLeft.setOnClickListener{
            mainActivity.speak("Alexa, how long left on the timer")
            Snackbar.make(view, "Alexa, how long left on the timer", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTimerCancel.setOnClickListener{
            mainActivity.speak("Alexa, cancel the timer")
            Snackbar.make(view, "Alexa, cancel the timer", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnShopping.setOnClickListener{
            mainActivity.speak("Alexa, what's on my shopping list")
            Snackbar.make(view, "Alexa, what's on my shopping list", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    //sets the font size for this fragment
    private fun setBtnTextSize(textSize: Float){
        binding.btnPlay.textSize = textSize;
        binding.btnPause.textSize = textSize;
        binding.btnTimer.textSize = textSize;
        binding.btnTimerLeft.textSize = textSize;
        binding.btnTimerCancel.textSize = textSize;
        binding.btnShopping.textSize = textSize;
        binding.btnExtraToHome.textSize = textSize;
    }

    //this function set the background colour of all the buttons
    private fun setBtnColour(buttonColour: Int) {
        binding.btnPlay.setBackgroundColor(buttonColour);
        binding.btnPause.setBackgroundColor(buttonColour);
        binding.btnTimer.setBackgroundColor(buttonColour);
        binding.btnTimerLeft.setBackgroundColor(buttonColour);
        binding.btnTimerCancel.setBackgroundColor(buttonColour);
        binding.btnShopping.setBackgroundColor(buttonColour);
        binding.btnExtraToHome.setBackgroundColor(buttonColour);
    }

    //this function is used to set the text colour of the buttons
    private fun setTextColour(textColour: Int){
        binding.btnPlay.setTextColor(textColour);
        binding.btnPause.setTextColor(textColour);
        binding.btnTimer.setTextColor(textColour);
        binding.btnTimerLeft.setTextColor(textColour);
        binding.btnTimerCancel.setTextColor(textColour);
        binding.btnShopping.setTextColor(textColour);
        binding.btnExtraToHome.setTextColor(textColour);
    }

    //on this fragment being opened the setting are refreshed based off the vars in the main activity
    override fun onResume(){
        super.onResume()
        val mainActivity = activity as MainActivity;
        setBtnTextSize(mainActivity.fontSize);
        setBtnColour(mainActivity.buttonCol);
        setTextColour(mainActivity.txtColour);

    }

}