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

class SecondActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var imageView1: ImageView
    lateinit var textView: TextView
lateinit var imageView: ImageView
lateinit var back : Button
    private val images = intArrayOf(
        R.drawable.ob1,
        R.drawable.ob2,
        R.drawable.ob3,
        R.drawable.ob4,
        R.drawable.ob5
    )
    private val texts = arrayOf(
        "Swap refined sources for whole grains",
        "Avoid red meat and opt for lean meat",
        "Junk food is touted to be one of the prime causes of obesity.",
        "Sugary food does not good to the body",
        "Obesity could be a side effect of certain medication too"
    )


          override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_second)
              back = findViewById(R.id.button2)
            imageView1 = findViewById(R.id.imageView3)
            textView = findViewById(R.id.textView7)
              imageView = findViewById(R.id.ob1)
           updateImageAndText()

            findViewById<ImageView>(R.id.imageView3).setOnClickListener {
                currentImage = (currentImage + 1) % images.size
                updateImageAndText()
            }

            findViewById<ImageView>(R.id.imageView4).setOnClickListener {
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



