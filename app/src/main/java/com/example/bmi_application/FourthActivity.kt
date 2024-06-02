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
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class FourthActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var back : Button
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    private val images = intArrayOf(
            R.drawable.obese1,
            R.drawable.obese2,
            R.drawable.obese3,
            R.drawable.obese4,
            R.drawable.obese5
    )
    private val texts = arrayOf(
            "Various studies correlate a higher fruit consumption with lower weight, most likely because they contain lots of fiber. Fiber helps you stay full. ",
            "Vegetables contain lots of vitamins, minerals and fiber, which again helps you stay full with fewer calories",
            "whole grains contain carbs, does not matter they are bad for you. Many studies find they can actually help promote weight loss long-term..",
            "Any fish is good for you, but fatty fish is even better.",
            "Legumes and beans are one of the best plant-based sources of protein you can eat. "
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
back = findViewById(R.id.button2)
        textView = findViewById(R.id.textView10)
        imageView = findViewById(R.id.imageView15)
        updateImageAndText()

        findViewById<ImageView>(R.id.imageView17).setOnClickListener {
            currentImage = (currentImage + 1) % images.size
            updateImageAndText()
        }

        findViewById<ImageView>(R.id.imageView16).setOnClickListener {
            currentImage = (currentImage - 1 + images.size) % images.size
            updateImageAndText()
        }

       back.setOnClickListener(){
           var intent = Intent(this,MainActivity::class.java)
           startActivity(intent)
       }

    }

    private   fun updateImageAndText() {
        imageView.setImageResource(images[currentImage])
        textView.text = texts[currentImage]
    }
}


