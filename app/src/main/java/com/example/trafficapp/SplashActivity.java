package com.example.trafficapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button btnEnterApp = findViewById(R.id.splash_button);
        btnEnterApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish(); // Finish the splash activity
            }
        });
    }
}
