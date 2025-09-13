package com.example.assignment1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FifteenthActivity : AppCompatActivity() {

    private lateinit var avatar: ImageView
    private lateinit var changePhoto: TextView
    private lateinit var btnDone: TextView

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let { avatar.setImageURI(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fifteenthpage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        avatar = findViewById(R.id.avatar)
        changePhoto = findViewById(R.id.changePhoto)
        btnDone = findViewById(R.id.btnDone)

        changePhoto.setOnClickListener {
            pickImage.launch("image/*")
        }

        btnDone.setOnClickListener {
            startActivity(Intent(this, SixteenthActivity::class.java))

        }
    }
}
