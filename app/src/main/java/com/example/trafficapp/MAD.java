//package com.example.myapplication;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.example.myapplication.models.Property;
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//    private final List<Property> data;
//
//    public MyAdapter(List<Property> data) {
//        this.data = data;
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView title;
//        private final TextView description;
//
////        public MyViewHolder(@NonNull View itemView) {
////            super(itemView);
////            title = itemView.findViewById(R.id.tvTitle);
////            description = itemView.findViewById(R.id.tvDescription);
////        }
//
////        public void bind(Property property) {
////            title.setText(property.getTitle());
////            description.setText(property.getDescription());
////        }
//    }
//
//    @NonNull
//    @Override
////    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
////        return new MyViewHolder(v);
////    }
//
//    @Override
////    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
////        holder.bind(data.get(position));
////    }
//
//    @Override
////    public int getItemCount() {
////        return data.size();
////    }
//}
