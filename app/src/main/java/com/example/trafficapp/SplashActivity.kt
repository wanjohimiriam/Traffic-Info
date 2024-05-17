package com.example.trafficapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SplashActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "SplashActivity"
        const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        database = FirebaseDatabase.getInstance().reference

        findViewById<Button>(R.id.splash_button).setOnClickListener {
            if (checkLocationPermission()) {
                getLocationAndSubmitReport()
            } else {
                requestLocationPermission()

            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }

    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocationAndSubmitReport()
            }
            else{
                Toast.makeText(
                    applicationContext,
                    "Permisiona not Enabled.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun getLocationAndSubmitReport() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                location?.let {
                    submitTrafficReport(it.latitude, it.longitude)
                } ?: Log.d(TAG, "Location not available $location")
            }
            .addOnFailureListener { e -> Log.e(TAG, "Error getting location", e) }
    }

    private fun submitTrafficReport(latitude: Double, longitude: Double) {
        val report = mutableMapOf<String, Double>()
        report["latitude"] = latitude
        report["longitude"] = longitude

        database.child("traffic_reports").push().setValue(report)
            .addOnSuccessListener { Log.d(TAG, "Traffic report submitted successfully") }
            .addOnFailureListener { e -> Log.e(TAG, "Failed to submit traffic report", e) }
    }
}