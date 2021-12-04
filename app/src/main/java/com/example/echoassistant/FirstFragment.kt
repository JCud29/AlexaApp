package com.example.echoassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.BtnDailyBrief.setOnClickListener { view ->
            Snackbar.make(view, "Alexa, what's on my schedule today?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.BtnDate.setOnClickListener { view ->
            Snackbar.make(view, "Alexa, what's the date?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        binding.BtnTime.setOnClickListener { view ->
            Snackbar.make(view, "Alexa, what's the time?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        binding.BtnWeatherReport.setOnClickListener { view ->
            Snackbar.make(view, "Alexa, what's the weather like?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        binding.BtnNotifications.setOnClickListener { view ->
            Snackbar.make(view, "Alexa, what are my notifications?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}