package com.example.assignment1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeventeenthActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToEighteenth = Runnable {
        startActivity(Intent(this, EighteenthActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.seventeenthpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.btnGallery).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                type = "image/*"
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(goToEighteenth, 4000L)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(goToEighteenth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToEighteenth)
    }
}
