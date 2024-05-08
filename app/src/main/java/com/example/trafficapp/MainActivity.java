package com.example.trafficapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newRecyclerView;
    private ArrayList<News> newArrayList;
    private int[] imageId;
    private String[] heading;
    private String[] headingtwo;
    private String[] headingthree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageId = new int[]{
                R.drawable.road_closed,
                R.drawable.accident_road,
                R.drawable.heavy_traffic,
                R.drawable.road_closed,
                R.drawable.maintainance_road,
                R.drawable.accident_road,
                R.drawable.heavy_traffic,
                R.drawable.road_closed,
                R.drawable.maintainance_road
        };

        heading = new String[]{
                "Kawangware Road",
                "Thika Road",
                "Chania Road",
                "Makuyu Street",
                "Ruiru Bypass",
                "Maimahio Road",
                "Mombasa Road",
                "Chania Road",
                "Eldoret Road"
        };

        headingtwo = new String[]{
                "Nairobi Road",
                "Kiambu",
                "Murang'a",
                "Murang'a",
                "Kiambu",
                "Machakos",
                "Mombasa",
                "Murang'a",
                "Eldoret"
        };

        headingthree = new String[]{
                "Road Closed",
                "Accident",
                "Heavy Traffic",
                "Road Closed",
                "Maintainance",
                "Accident",
                "Heavy Traffic",
                "Road Closed",
                "Maintainance"
        };

        newRecyclerView = findViewById(R.id.recyclerview);
        newRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newRecyclerView.setHasFixedSize(true);

        newArrayList = new ArrayList<>();
        getUserData();
    }

    private void getUserData() {
        for (int i = 0; i < imageId.length; i++) {
            News news = new News(imageId[i], heading[i], headingtwo[i], headingthree[i]);
            newArrayList.add(news);
        }
        newRecyclerView.setAdapter(new MyAdapter(newArrayList));
    }
}
