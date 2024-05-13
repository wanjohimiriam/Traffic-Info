package com.example.trafficapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<News> newsList;

    private ProgressBar progressBar;

    private RecyclerView.LayoutManager manager;

    private RecyclerView.Adapter<MyAdapter.MyViewHolder> myAdapter;

    private RecyclerView newRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newRecyclerView = findViewById(R.id.recyclerview);
        manager = new LinearLayoutManager(this);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        // Set layout manager
        newRecyclerView.setLayoutManager(manager);

        // Initialize adapter
        myAdapter = new MyAdapter(new ArrayList<>());
        newsList = new ArrayList<>();
        // Pass an empty list for now

        // Set adapter
        newRecyclerView.setAdapter(myAdapter);
//        newRecyclerView = findViewById(R.id.recyclerview);
//        newRecyclerView.setLayoutManager(manager);
//        newRecyclerView.setAdapter(myAdapter);
//        newRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        Log.d(TAG, "onCreate");
        getAllData();

    }
    public void getAllData() {

        progressBar.setVisibility(View.VISIBLE);
        ApiService.getService().getAllData().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // Data is successfully received, update UI
                        myAdapter = new MyAdapter(response.body()); // Pass actual data
                        newRecyclerView.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();
                        Log.d(TAG, "Data received: " + response.body().toString());
                        progressBar.setVisibility(View.GONE);
                    } else {
                        // Response body is null, handle this case
                        Log.e(TAG, "Response body is null");
                    }
                } else {
                    // Request was not successful (e.g., 404, 500, etc.), handle this case
                    Log.e(TAG, "Failed to fetch data: " + response.code());
                    Toast.makeText(MainActivity.this, "Not Loaded", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                String errorMessage = t.getMessage();
                if (errorMessage == null) {
                    errorMessage = "Unknown error";
                }
                Log.e(TAG, "Failed to fetch data: " + errorMessage);
                t.printStackTrace();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}