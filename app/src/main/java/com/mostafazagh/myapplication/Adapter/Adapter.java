package com.mostafazagh.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.mostafazagh.myapplication.R;
import com.mostafazagh.myapplication.models.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Datum> coursesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, from,to,createdat,tripat;
        public ImageView imageView;
        public MyViewHolder(View view) {
            super(view);
            username = view.findViewById(R.id.username);
            from = view.findViewById(R.id.from);
            to = view.findViewById(R.id.to);
            createdat = view.findViewById(R.id.createdat);
            tripat = view.findViewById(R.id.tripat);
            imageView = view.findViewById(R.id.profile_image);
        }
    }


    public Adapter(List<Datum> courseModelList) {
        this.coursesList = courseModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Datum course = coursesList.get(position);
        holder.username.setText(course.getGetUser().getUsername());
        holder.from.setText(course.getGetTrip().getFromAddress());
        holder.to.setText(course.getGetTrip().getToAddress());
        holder.createdat.setText("Created at :"+course.getGetTrip().getCreatedAt());
        holder.tripat.setText("Trip date :"+course.getGetTrip().getTripDate());
        if(!course.getGetUser().getPhoto().isEmpty()){
        Picasso.get()
                .load(course.getGetUser().getPhoto())
                .placeholder(R.drawable.user)
                .error(R.drawable.user)
                .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }
}