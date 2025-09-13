package com.example.assignment1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.secondpage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCreateAccount = findViewById<TextView>(R.id.btnCreateAccount)
        btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        // Open camera on click
        val loginCam = findViewById<ImageView>(R.id.ivCamera)
        loginCam.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivity(cameraIntent)
            } catch (e: ActivityNotFoundException) {
                // Optionally show a toast/log if no camera app is found
            }
        }
    }
}
