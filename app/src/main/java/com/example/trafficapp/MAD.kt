//package com.example.trafficapp
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.imageview.ShapeableImageView
//
//class MAD (private val newsList: ArrayList<N>):
//    RecyclerView.Adapter<MAD.MyViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
//        parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return newsList.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//       val currentitem = newsList[position]
//        holder.titleimage.setImageResource(currentitem.itemImage)
//        holder.tvHeading.text= currentitem.heading
//        holder.tvHeading2.text= currentitem.headingtwo
//        holder.tvHeading3.text= currentitem.headingthree
//
//    }
//
//    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
//
//        val titleimage :ShapeableImageView = itemView.findViewById(R.id.tittle_image)
//        val tvHeading : TextView = itemView.findViewById(R.id.tv_Heading)
//        val tvHeading2 : TextView = itemView.findViewById(R.id.tv_Heading2)
//        val tvHeading3 : TextView = itemView.findViewById(R.id.tv_Heading3)
//
//    }
//
//}