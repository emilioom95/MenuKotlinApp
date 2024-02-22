package com.examples.menukotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.examples.menukotlinapp.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFactorial.setOnClickListener {
            factorial()
        }
    }

    fun factorial(){
        val num = Integer.parseInt(binding.number1.text.toString())
        var factorial: Long = 1
        for (i in 1..num) {
            // factorial = factorial * i;
            factorial *= i.toLong()
        }
       binding.result.setText(factorial.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}