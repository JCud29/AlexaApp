package com.example.echoassistant

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.echoassistant.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity;


        //listener on the alexa commands button to navigate to the alexa commands fragment
        binding.btnAlexaComs.setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_alexaCommands)
        }

        //navigates to the smart home fragment on the button bring pressed
        binding.btnSmartHome.setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_smartHome)
        }

        //onClickListener to navigate to the extra commands fragment on the button being pressed
        binding.btnExtraComs.setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_extraCommands)
        }

        //navigates to the settings activity on the settings button being pressed
        binding.btnSettings.setOnClickListener { view ->
            findNavController().navigate(R.id.action_FirstFragment_to_settingsActivity)
        }
    }

    override fun onResume(){
        super.onResume()
        val mainActivity = activity as MainActivity;
        binding.btnAlexaComs.textSize = mainActivity.fontSize;
        binding.btnSmartHome.textSize = mainActivity.fontSize;
        binding.btnExtraComs.textSize = mainActivity.fontSize;
        binding.btnSettings.textSize = mainActivity.fontSize;

        binding.btnAlexaComs.setTextColor(mainActivity.txtColour);
        binding.btnSmartHome.setTextColor(mainActivity.txtColour);
        binding.btnExtraComs.setTextColor(mainActivity.txtColour);
        binding.btnSettings.setTextColor(mainActivity.txtColour);

        binding.btnAlexaComs.setBackgroundColor(mainActivity.buttonCol);
        binding.btnSmartHome.setBackgroundColor(mainActivity.buttonCol);
        binding.btnExtraComs.setBackgroundColor(mainActivity.buttonCol);
        binding.btnSettings.setBackgroundColor(mainActivity.buttonCol);

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}