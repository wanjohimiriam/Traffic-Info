package com.example.trafficapp;

import android.content.Context;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView; // Optional import if you prefer ShapeableImageView
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final List<News> data;
    private final int[] imageIds = { // Hardcoded image resource IDs
            R.drawable.road_closed,
            R.drawable.accident_road,
            R.drawable.heavy_traffic,
            R.drawable.maintainance_road,
    };

    public MyAdapter(List<News> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return data.size(); // Only show data from API in this case
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News currentItem = data.get(position);

        // Set image based on condition in currentItem
        int imageIndex = -1; // Initialize to -1 for no image by default
        String condition = currentItem.getCondition(); // Assuming 'condition' is a property in News

        if (condition.equals("Closed")) {
            imageIndex = 0;
        } else if (condition.equals("Accident")) {
            imageIndex = 1;
        } else if (condition.equals("Heavy Traffic")) {
            imageIndex = 2;
        } else if (condition.equals("Maintenance Works")) {
            imageIndex = 3;
        }

        if (imageIndex != -1) {
            holder.titleImage.setImageResource(imageIds[imageIndex]);
        } else {
            // Handle case where no matching condition is found (optional)
            holder.titleImage.setImageResource(R.drawable.heavy_traffic); // Replace with your default image resource ID
        }

        holder.streetName.setText(currentItem.getStreetName());
        holder.locality.setText(currentItem.getLocality());
        holder.condition.setText(currentItem.getCondition());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView titleImage; // Use ImageView or ShapeableImageView based on preference
        private final TextView streetName, locality, condition;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.tittle_image);
            streetName = itemView.findViewById(R.id.tv_Heading); // Corrected resource ID reference
            locality = itemView.findViewById(R.id.tv_Heading2);
            condition = itemView.findViewById(R.id.tv_Heading3);
        }
    }
}