package com.example.echoassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.echoassistant.databinding.FragmentSmartHomeBinding
import com.google.android.material.snackbar.Snackbar

/*// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

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
    // TODO: Rename and change types of parameters
    /*private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

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

        binding.BtnSmartHomeToHome.setOnClickListener {
            findNavController().navigate(R.id.action_smartHome_to_FirstFragment)
        }

        binding.btnLightsOn.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, turn on the lights", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnLightsOff.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, turn off the lights", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTempUp.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, increase the temperature", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnTempDown.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, decrease the temperature", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnWhatTemp.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, what is the temperature?", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.btnLightsDim.setOnClickListener{view ->
            Snackbar.make(view, "Alexa, set the lights to 50 percent", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SmartHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SmartHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}