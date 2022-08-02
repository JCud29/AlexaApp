package com.example.echoassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.echoassistant.databinding.FragmentSmartHomeBinding
import com.google.android.material.snackbar.Snackbar


/**
 * A simple [Fragment] subclass.
 * Use the [SmartHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class SmartHome : Fragment() {
    private var _binding: FragmentSmartHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSmartHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity;

        //onClickListener to return to the first fragment(home) on the back button being pressed
        binding.BtnSmartHomeToHome.setOnClickListener {
            findNavController().navigate(R.id.action_smartHome_to_FirstFragment)
        }

        //onClickListeners for each button to display a snack bar and speak the command using the main activity function
        binding.btnLightsOn.setOnClickListener{
            mainActivity.speak("Alexa, turn on the lights")
            Snackbar.make(view, "Alexa, turn on the lights", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnLightsOff.setOnClickListener{
            mainActivity.speak("Alexa, turn off the lights")
            Snackbar.make(view, "Alexa, turn off the lights", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTempUp.setOnClickListener{
            mainActivity.speak("Alexa, increase the temperature")
            Snackbar.make(view, "Alexa, increase the temperature", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTempDown.setOnClickListener{
            mainActivity.speak("Alexa, decrease the temperature")
            Snackbar.make(view, "Alexa, decrease the temperature", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnWhatTemp.setOnClickListener{
            mainActivity.speak("Alexa, what is the temperature?")
            Snackbar.make(view, "Alexa, what is the temperature?", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnLightsDim.setOnClickListener{
            mainActivity.speak("Alexa, set the lights to 50 percent")
            Snackbar.make(view, "Alexa, set the lights to 50 percent", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }

    //sets the font size for all the buttons
    private fun setBtnTextSize(textSize: Float){
        binding.btnLightsOn.textSize = textSize;
        binding.btnLightsOff.textSize = textSize;
        binding.btnTempUp.textSize = textSize;
        binding.btnTempDown.textSize = textSize;
        binding.btnWhatTemp.textSize = textSize;
        binding.btnLightsDim.textSize = textSize;
        binding.BtnSmartHomeToHome.textSize = textSize;
    }

    //function to set the button colour of all the buttons on the fragment
    private fun setBtnColour(buttonColour: Int) {
        binding.btnLightsOn.setBackgroundColor(buttonColour);
        binding.btnLightsOff.setBackgroundColor(buttonColour);
        binding.btnTempUp.setBackgroundColor(buttonColour);
        binding.btnTempDown.setBackgroundColor(buttonColour);
        binding.btnWhatTemp.setBackgroundColor(buttonColour);
        binding.btnLightsDim.setBackgroundColor(buttonColour);
        binding.BtnSmartHomeToHome.setBackgroundColor(buttonColour);
    }

    //sets the text colour of the buttons within this fragment
    private fun setTextColour(textColour: Int){
        binding.btnLightsOn.setTextColor(textColour);
        binding.btnLightsOff.setTextColor(textColour);
        binding.btnTempUp.setTextColor(textColour);
        binding.btnTempDown.setTextColor(textColour);
        binding.btnWhatTemp.setTextColor(textColour);
        binding.btnLightsDim.setTextColor(textColour);
        binding.BtnSmartHomeToHome.setTextColor(textColour);
    }

    //called when the fragment is re-opened to refresh the settings
    override fun onResume(){
        super.onResume()
        val mainActivity = activity as MainActivity;
        setBtnTextSize(mainActivity.fontSize);
        setBtnColour(mainActivity.buttonCol)
        setTextColour(mainActivity.txtColour)

    }
}