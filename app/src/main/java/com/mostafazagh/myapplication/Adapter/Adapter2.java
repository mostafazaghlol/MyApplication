package com.mostafazagh.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostafazagh.myapplication.R;
import com.mostafazagh.myapplication.models.DatumDrivers;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder> {

    private List<DatumDrivers> coursesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, from,to,createdat,tripat;
        public ImageView imageView;
        public Button pickMe,chat;
        public MyViewHolder(View view) {
            super(view);
            username = view.findViewById(R.id.usernameDriver);
            from = view.findViewById(R.id.fromDriver);
            to = view.findViewById(R.id.toDriver);
            createdat = view.findViewById(R.id.createdatDriver);
            tripat = view.findViewById(R.id.tripatDriver);
            imageView = view.findViewById(R.id.profile_imageDriver);
            pickMe = view.findViewById(R.id.pickMe);
            chat = view.findViewById(R.id.chat);
        }
    }


    public Adapter2(List<DatumDrivers> courseModelList) {
        this.coursesList = courseModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemdriver, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DatumDrivers course = coursesList.get(position);
        holder.username.setText(course.getGetUserV2().getUsername());
        holder.from.setText(course.getFromAddress());
        holder.to.setText(course.getToAddress());
        holder.createdat.setText("Created at :"+course.getCreatedAt());
        holder.tripat.setText("Trip date :"+course.getTripDate());
        if(!course.getGetUserV2().getPhoto().isEmpty()){
        Picasso.get()
                .load(course.getGetUserV2().getPhoto())
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