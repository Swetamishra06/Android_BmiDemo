package com.example.bmi_application
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class ThirdActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var back :Button
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    private val images = intArrayOf(
        R.drawable.under1,
        R.drawable.under2,
        R.drawable.under3,
        R.drawable.under4,
        R.drawable.under5
    )
    private val texts = arrayOf(
        "Dried fruit provides calories, antioxidants, and micronutrients",
        "Dairy milk has been used as a weight gainer or muscle builder for decades",
        "Cereals can be an excellent source of carbs, calories, and nutrients.",
        "Rice is a convenient, low cost carb source that can be part of a weight gain eating plan.",
        "Red meats, including beef or pork, are probably one of the most effective muscle-building foods available."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
back = findViewById(R.id.button2)
        textView = findViewById(R.id.textView8)
        imageView = findViewById(R.id.imageView8)
        updateImageAndText()

        findViewById<ImageView>(R.id.imageView9).setOnClickListener {
            currentImage = (currentImage + 1) % images.size
            updateImageAndText()
        }

        findViewById<ImageView>(R.id.imageView10).setOnClickListener {
            currentImage = (currentImage - 1 + images.size) % images.size
            updateImageAndText()
        }
        back.setOnClickListener(){
            var intent = Intent(this,MainActivity::class.java)
        }

    }

    private   fun updateImageAndText() {
        imageView.setImageResource(images[currentImage])
        textView.text = texts[currentImage]
    }
}

