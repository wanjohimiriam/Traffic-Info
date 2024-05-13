package com.example.trafficapp;

import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public ShapeableImageView item_image;
    private final List<News> data;
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
        return data.size();
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News currentItem = data.get(position);
//        holder.titleImage.setImageResource(currentItem.getItemImage());
        holder.streetName.setText(currentItem.getStreetName());
        holder.locality.setText(currentItem.getLocality());
        holder.condition.setText(currentItem.getCondition());
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView titleImage;
        TextView streetName, locality, condition;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            titleImage = itemView.findViewById(R.id.tittle_image);
            streetName = itemView.findViewById(R.id.tv_Heading);
            locality = itemView.findViewById(R.id.tv_Heading2);
            condition = itemView.findViewById(R.id.tv_Heading3);
        }
    }
}
