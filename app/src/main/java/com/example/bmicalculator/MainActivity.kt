package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val weight= binding.weightEdit.text.toString().toFloatOrNull()
        val height= binding.heightEdit.text.toString().toFloatOrNull()

        if (weight !=null && height != null){
            val bmi= weight/(height/100).pow(2)
            val bmiReslut= String.format("%.2f",bmi)

            val bmiCategory = when{
                bmi< 18.5 -> "Under Weight"
                bmi< 25 -> "Normal Weight"
                bmi< 30 -> "Over Weight"
                else -> "obese"
            }
            binding.resultText.text = "BMI: $bmiReslut\nCategory: $bmiCategory"
        }else{
            binding.resultText.text = "Invalid Input"
        }
    }
}