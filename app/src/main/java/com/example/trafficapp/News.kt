package com.example.trafficapp

class News(var id: Int, var streetName: String, var locality: String, var condition: String) {
    private val ItemImage = 0

}






//package com.example.trafficapp
//
//import android.Manifest
//import android.content.ContentValues.TAG
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class SplashActivity : AppCompatActivity() {
//
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//    private lateinit var database: DatabaseReference
//
//    companion object {
//        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        database = FirebaseDatabase.getInstance().reference
//
//        val btnEnterApp = findViewById<Button>(R.id.splash_button)
//        btnEnterApp.setOnClickListener {
//            if (checkLocationPermission()) {
//                getLastLocationAndSubmitReport()
//                Log.e(TAG, "submit traffic report",)
//            } else {
//                requestLocationPermission()
//            }
//            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//            finish() // Finish the splash activity
//        }
//    }
//
//    private fun checkLocationPermission(): Boolean {
//        return ContextCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_FINE_LOCATION
//        ) == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun requestLocationPermission() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
//            LOCATION_PERMISSION_REQUEST_CODE
//        )
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getLastLocationAndSubmitReport()
//            }
//        }
//    }
//
//    private fun getLastLocationAndSubmitReport() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location ->
//                location?.let {
//                    val latitude = it.latitude
//                    val longitude = it.longitude
//                    submitTrafficReport(latitude, longitude)
//                    Log.e(TAG, "Latitude: $latitude, Longitude: $longitude")
//                    startMainActivity()
//                }
//            }
//    }
//
//    private fun submitTrafficReport(latitude: Double, longitude: Double) {
//        val report = mapOf(
//            "latitude" to latitude,
//            "longitude" to longitude
//        )
//        database.child("traffic_reports").push().setValue(report)
//            .addOnSuccessListener {
//                Log.d(TAG, "Traffic report submitted successfully")
//            }
//            .addOnFailureListener { e ->
//                Log.e(TAG, "Failed to submit traffic report", e)
//            }
//    }
//
//    private fun startMainActivity() {
//        startActivity(Intent(this, MainActivity::class.java))
//        finish() // Finish the splash activity
//    }
//}
