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

class NinthActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToTenth = Runnable {
        startActivity(Intent(this, TenthActivity::class.java))
        // Do NOT call finish(): back from 10th returns to 9th
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ninthpage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Camera button
        findViewById<ImageView>(R.id.cameraIcon)?.setOnClickListener {
            openCamera()
        }
    }

    override fun onResume() {
        super.onResume()
        handler.removeCallbacks(goToTenth)
        handler.postDelayed(goToTenth, 3000) // 3 seconds
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(goToTenth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToTenth)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(intent) // launches the system camera
        }
    }

