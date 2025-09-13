package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FifthActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val goToSixth = Runnable {
        startActivity(Intent(this, SixthActivity::class.java))
        // Do NOT call finish() so Back on 6th returns to 5th
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fifthpage)

        // Camera icon click -> open camera app
        findViewById<ImageView>(R.id.ivCamera).setOnClickListener {
            openCamera()
        }
    }

    override fun onResume() {
        super.onResume()
        // Reset (cancel any pending) and start a fresh 6s timer every time we show this screen
        handler.removeCallbacks(goToSixth)
        handler.postDelayed(goToSixth, 3000)
    }

    override fun onPause() {
        super.onPause()
        // Stop timer when leaving this screen (e.g., going to 6th or camera app)
        handler.removeCallbacks(goToSixth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToSixth)
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(cameraIntent) // just opens the camera; no result handling here
    }
}
