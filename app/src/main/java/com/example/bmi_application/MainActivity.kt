package com.example.bmi_application
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button4)
        val input1 = findViewById<EditText>(R.id.editTextNumber)
        val input2 = findViewById<EditText>(R.id.editText3)
        val result = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            calculate()
        }
    }

    fun calculate() {
        val input1Text = findViewById<EditText>(R.id.editTextNumber).text.toString()
        val weight = input1Text.toDouble()
        val input2Text = findViewById<EditText>(R.id.editText3).text.toString()
        val height = input2Text.toDouble()
        val bmi = weight / (height * height)
        val formattedBmi = "%.2f".format(bmi)

        val resultText = when {
            bmi < 18.5 -> {
                setActionForunderweight()
                "You are Underweight. Your Calculated BMI is: $formattedBmi"
            }

            bmi < 24.9 -> {
                "Congratulations! You are normal Weighted. Your Calculated BMI is: $formattedBmi"
            }

            bmi < 29.9 -> {
                setActionForover()
                "You are Overweighted. Your Calculated BMI is: $formattedBmi"
            }

            else -> {
                setActionForobese()
                "You are Obese. Your Calculated BMI is: $formattedBmi"
            }
        }

        findViewById<TextView>(R.id.textView).text = resultText
    }

    private fun setActionForobese() {
        val button2 = findViewById<Button>(R.id.button)
        button2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button2.setTextColor(Color.parseColor("#FF0E0E0E"))
        button2.setOnClickListener() {
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setActionForunderweight() {
        val button3 = findViewById<Button>(R.id.button)
        button3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button3.setTextColor(Color.parseColor("#FF0E0E0E"))
        button3.setOnClickListener() {
            var intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setActionForover() {
        val button4 = findViewById<Button>(R.id.button)
        button4.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button4.setTextColor(Color.parseColor("#FF0E0E0E"))
        button4.setOnClickListener() {
            var intent = Intent(this,FourthActivity::class.java)
            startActivity(intent)
        }


    }


}