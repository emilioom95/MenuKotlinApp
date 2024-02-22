package com.examples.menukotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.examples.menukotlinapp.databinding.FragmentSecondBinding
import com.examples.menukotlinapp.databinding.FragmentThirdBinding
import java.lang.Double

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCalcular.setOnClickListener {
            calcular()
        }
    }

    fun calcular(){
        try {
            val peso = Double.parseDouble(binding.number1.text.toString())
            val altura = Double.parseDouble(binding.number2.text.toString())

            val resultado = peso/(altura*altura)
            val resultadoFormat = String.format("%.2f", resultado).toDouble()

            binding.result.setText(resultadoFormat.toString())
        }catch (e : Exception){
            binding.result.setText("")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}