package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourteenthActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToFifteenth = Runnable {
        startActivity(Intent(this, FifteenthActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fourteenthpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(goToFifteenth, 3000L)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(goToFifteenth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToFifteenth)
    }
}
