package com.example.trafficapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trafficapp.MyAdapter.MyViewHolder

// Optional import if you prefer ShapeableImageView
class MyAdapter(private val data: List<News>) : RecyclerView.Adapter<MyViewHolder>() {
    private val imageIds = intArrayOf( // Hardcoded image resource IDs
        R.drawable.road_closed,
        R.drawable.accident_road,
        R.drawable.heavy_traffic,
        R.drawable.maintainance_road
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size // Only show data from API in this case
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = data[position]

        // Set image based on condition in currentItem
        var imageIndex = -1 // Initialize to -1 for no image by default
        val condition = currentItem.condition // Assuming 'condition' is a property in News
        if (condition == "Closed") {
            imageIndex = 0
        } else if (condition == "Accident") {
            imageIndex = 1
        } else if (condition == "Heavy Traffic") {
            imageIndex = 2
        } else if (condition == "Maintenance Works") {
            imageIndex = 3
        }
        if (imageIndex != -1) {
            holder.titleImage.setImageResource(imageIds[imageIndex])
        } else {
            // Handle case where no matching condition is found (optional)
            holder.titleImage.setImageResource(R.drawable.heavy_traffic) // Replace with your default image resource ID
        }
        holder.streetName.text = currentItem.streetName
        holder.locality.text = currentItem.locality
        holder.condition.text = currentItem.condition
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage // Use ImageView or ShapeableImageView based on preference
                : ImageView
        val streetName: TextView
        val locality: TextView
        val condition: TextView

        init {
            titleImage = itemView.findViewById(R.id.tittle_image)
            streetName = itemView.findViewById(R.id.tv_Heading) // Corrected resource ID reference
            locality = itemView.findViewById(R.id.tv_Heading2)
            condition = itemView.findViewById(R.id.tv_Heading3)
        }
    }
}