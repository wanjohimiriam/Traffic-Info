//package com.example.trafficapp
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MA : AppCompatActivity() {
//
//    private lateinit var newRecyclerView: RecyclerView
//    private lateinit var newArrayList: ArrayList<N>
//    private lateinit var  imageId: Array<Int>
//    private lateinit var heading: Array<String>
//    private lateinit var headingtwo: Array<String>
//    private lateinit var headingthree: Array<String>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        imageId = arrayOf(
//            R.drawable.road_closed,
//            R.drawable.accident_road,
//            R.drawable.heavy_traffic,
//            R.drawable.road_closed,
//            R.drawable.maintainance_road,
//            R.drawable.accident_road,
//            R.drawable.heavy_traffic,
//            R.drawable.road_closed,
//            R.drawable.maintainance_road,
//        )
//
//        heading = arrayOf(
//            "Kawangware Road",
//            "Thika Road",
//            "Chania Road",
//            "Makuyu Street",
//            "Ruiru Bypass",
//            "Maimahio Road",
//            "Mombasa Road",
//            "Chania Road",
//            "Eldoret Road",
//        )
//        headingtwo = arrayOf(
//            "Nairobi Road",
//            "Kiambu",
//            "Murang'a",
//            "Murang'a",
//            "Kiambu",
//            "Machakos",
//            "Mombasa",
//            "Murang'a",
//            "Eldoret",
//        )
//        headingthree = arrayOf(
//            "Road Closed",
//            "Accident",
//            "Heavy Traffic",
//            "Road Closed",
//            "Maintainance",
//            "Accident",
//            "Heavy Traffic",
//            "Road Closed",
//            "Maintainance",
//        )
//
//    newRecyclerView = findViewById(R.id.recyclerview)
//    newRecyclerView.layoutManager= LinearLayoutManager(this)
//    newRecyclerView.setHasFixedSize(true)
//
//    newArrayList= arrayListOf<N>()
//    getUserData()
//    }
//
//    private fun getUserData() {
//        for (i in imageId.indices)
//        {
//            val news = N(imageId[i],heading[i], headingtwo[i], headingthree[i] )
//
//            newArrayList.add(news)
//        }
//        newRecyclerView.adapter = MAD(newArrayList)
//    }
//
//
//}