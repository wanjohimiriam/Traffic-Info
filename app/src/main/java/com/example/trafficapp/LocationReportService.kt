package com.example.trafficapp

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LocationReportService : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var database: DatabaseReference

    override fun onCreate() {
        super.onCreate()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        database = FirebaseDatabase.getInstance().reference
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        getLocationAndSubmitReport()
        return START_NOT_STICKY
    }

    private fun getLocationAndSubmitReport() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            stopSelf()
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                location?.let {
                    submitTrafficReport(it.latitude, it.longitude)
                } ?: Log.d("LocationReportService", "Location not available $location")
                stopSelf()
            }
            .addOnFailureListener { e ->
                Log.e("LocationReportService", "Error getting location", e)
                stopSelf()
            }
    }

    private fun submitTrafficReport(latitude: Double, longitude: Double) {
        val report = mutableMapOf<String, Double>()
        report["latitude"] = latitude
        report["longitude"] = longitude

        database.child("traffic_reports").push().setValue(report)
            .addOnSuccessListener { Log.d("LocationReportService", "Traffic report submitted successfully") }
            .addOnFailureListener { e -> Log.e("LocationReportService", "Failed to submit traffic report", e) }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
