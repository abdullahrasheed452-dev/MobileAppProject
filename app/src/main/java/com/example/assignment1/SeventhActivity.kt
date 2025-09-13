package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeventhActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToEighth = Runnable {
        startActivity(Intent(this, EighthActivity::class.java))
        // No finish(): Back from 8th returns to 7th
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.seventhpage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        // Reset and start fresh timer every time we show this screen
        handler.removeCallbacks(goToEighth)
        handler.postDelayed(goToEighth, 3000) // 6 seconds
    }

    override fun onPause() {
        super.onPause()
        // Stop timer when leaving this screen (navigating away / screen off)
        handler.removeCallbacks(goToEighth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToEighth)
    }
}
