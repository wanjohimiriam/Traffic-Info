package com.example.trafficapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.trafficapp.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val btnEnterApp = findViewById<Button>(R.id.splash_button)

        btnEnterApp.setOnClickListener {
            // Handle button click
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish() // Finish the splash activity
        }
    }
}