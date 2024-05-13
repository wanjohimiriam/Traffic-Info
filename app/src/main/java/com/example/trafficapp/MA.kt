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


// mainactivity java

//private ArrayList<News> newArrayList;
//////    private int[] imageId;
//////    private String[] heading;
//////    private String[] headingtwo;
//////    private String[] headingthree;


//        newRecyclerView.setHasFixedSize(true);
//
//        newArrayList = new ArrayList<>();
//getUserData();
//}

//    private void getUserData() {
//        for (int i = 0; i < imageId.length; i++) {
//            News news = new News(imageId[i], heading[i], headingtwo[i], headingthree[i]);
//            newArrayList.add(news);
//        }
//        newRecyclerView.setAdapter(new MyAdapter(newArrayList));
//    }



//        imageId = new int[]{
//                R.drawable.road_closed,
//                R.drawable.accident_road,
//                R.drawable.heavy_traffic,
//                R.drawable.road_closed,
//                R.drawable.maintainance_road,
//                R.drawable.accident_road,
//                R.drawable.heavy_traffic,
//                R.drawable.road_closed,
//                R.drawable.maintainance_road
//        };
//
//        heading = new String[]{
//                "Kawangware Road",
//                "Thika Road",
//                "Chania Road",
//                "Makuyu Street",
//                "Ruiru Bypass",
//                "Maimahio Road",
//                "Mombasa Road",
//                "Chania Road",
//                "Eldoret Road"
//        };
//
//        headingtwo = new String[]{
//                "Nairobi Road",
//                "Kiambu",
//                "Murang'a",
//                "Murang'a",
//                "Kiambu",
//                "Machakos",
//                "Mombasa",
//                "Murang'a",
//                "Eldoret"
//        };
//
//        headingthree = new String[]{
//                "Road Closed",
//                "Accident",
//                "Heavy Traffic",
//                "Road Closed",
//                "Maintainance",
//                "Accident",
//                "Heavy Traffic",
//                "Road Closed",
//                "Maintainance"
//        };
//


//package com.example.trafficapp;
//
//import static android.content.ContentValues.TAG;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class MainActivity extends AppCompatActivity {
//    private List<News> newsList;
//
//    private RecyclerView.LayoutManager manager;
//
//    private RecyclerView.Adapter<MyAdapter.MyViewHolder> myAdapter;
//
//    private RecyclerView newRecyclerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        newRecyclerView = findViewById(R.id.recyclerview);
//        manager = new LinearLayoutManager(this);
//
//        // Set layout manager
//        newRecyclerView.setLayoutManager(manager);
//
//        // Initialize adapter
//        myAdapter = new MyAdapter(new ArrayList<>());
//        newsList = new ArrayList<>();
//        // Pass an empty list for now
//
//        // Set adapter
//        newRecyclerView.setAdapter(myAdapter);
////        newRecyclerView = findViewById(R.id.recyclerview);
////        newRecyclerView.setLayoutManager(manager);
////        newRecyclerView.setAdapter(myAdapter);
////        newRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//
//        Log.d(TAG, "onCreate");
//        getAllData();
//
//    }
//    public void getAllData() {
//        ApiService.getService().getAllData().enqueue(new Callback<List<News>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
//                if (response.isSuccessful()) {
//                    newsList.clear(); // Clear existing data
//                    assert response.body() != null;
//                    newsList.addAll(response.body()); // Add new data to the list
//                    myAdapter.notifyDataSetChanged();
////                    newRecyclerView = findViewById(R.id.recyclerview);
////                    myAdapter = new MyAdapter(response.body());
////                    newRecyclerView.setLayoutManager(manager);
////                    newRecyclerView.setAdapter(myAdapter);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Not Loaded", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<News>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//    }
//}

