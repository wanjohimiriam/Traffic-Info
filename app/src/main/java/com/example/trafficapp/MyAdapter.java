package com.example.trafficapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<News> newsList;

    public MyAdapter(ArrayList<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News currentItem = newsList.get(position);
        holder.titleImage.setImageResource(currentItem.getItemImage());
        holder.tvHeading.setText(currentItem.getHeading());
        holder.tvHeading2.setText(currentItem.getHeadingtwo());
        holder.tvHeading3.setText(currentItem.getHeadingthree());
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView titleImage;
        TextView tvHeading, tvHeading2, tvHeading3;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.tittle_image);
            tvHeading = itemView.findViewById(R.id.tv_Heading);
            tvHeading2 = itemView.findViewById(R.id.tv_Heading2);
            tvHeading3 = itemView.findViewById(R.id.tv_Heading3);
        }
    }
}
