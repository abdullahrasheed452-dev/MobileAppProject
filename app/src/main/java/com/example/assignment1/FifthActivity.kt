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
       
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fifthpage)

        
        findViewById<ImageView>(R.id.ivCamera).setOnClickListener {
            openCamera()
        }
    }

    override fun onResume() {
        super.onResume()
       
        handler.removeCallbacks(goToSixth)
        handler.postDelayed(goToSixth, 3000)
    }

    override fun onPause() {
        super.onPause()
        
        handler.removeCallbacks(goToSixth)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(goToSixth)
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(cameraIntent) 
    }
}
