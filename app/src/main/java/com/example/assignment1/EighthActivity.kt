package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EighthActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToNinth = Runnable {
        startActivity(Intent(this, NinthActivity::class.java))
        
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.eightpage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        
        findViewById<ImageView>(R.id.viiiCamera1)?.setOnClickListener { openCamera() }
        findViewById<ImageView>(R.id.viiiCamera2)?.setOnClickListener { openCamera() }
    }

    override fun onResume() {
        super.onResume()
        handler.removeCallbacks(goToNinth)
        handler.postDelayed(goToNinth, 3000) 
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(goToNinth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToNinth)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        

            startActivity(intent) 
        }
    }

