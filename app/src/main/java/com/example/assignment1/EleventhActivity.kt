package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EleventhActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    private val goToTwelfth = Runnable {
        startActivity(Intent(this, TwelfthActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.eleventhpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        handler.removeCallbacks(goToTwelfth)
        handler.postDelayed(goToTwelfth, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(goToTwelfth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToTwelfth)
    }
}
