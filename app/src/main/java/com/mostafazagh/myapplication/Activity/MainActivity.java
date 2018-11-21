package com.mostafazagh.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mostafazagh.myapplication.API.endpoints;
import com.mostafazagh.myapplication.Adapter.Adapter;
import com.mostafazagh.myapplication.R;
import com.mostafazagh.myapplication.models.Datum;
import com.mostafazagh.myapplication.models.Myreservations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Myreservations> {
    static final String Base_Url = "http://shareme.entlq.net/api/v1/";
    public ProgressBar progressBar;
    public Myreservations myreservations;
    public List<Datum> data;
    public RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_circular1);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endpoints gerritAPI = retrofit.create(endpoints.class);
        String aut = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIzLCJpc3MiOiJodHRwOi8vb29zc3JyLmNvbS9hcGkvdjEvbG9naW4iLCJpYXQiOjE1Mzc2NDAzOTUsImV4cCI6MTY1NzY0MDM5NSwibmJmIjoxNTM3NjQwMzk1LCJqdGkiOiJqaGhHczN3dXczaUhETXdXIn0.voEycuiM60aP60v53R_hsErW47b8Vr501hjwb1m_BZ4";
        Call<Myreservations> call = gerritAPI.getUsers(aut);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Myreservations> call, Response<Myreservations> response) {
        progressBar.setVisibility(View.INVISIBLE);
        data = new ArrayList();
        data = response.body().getData();
        recyclerView = (RecyclerView) findViewById(R.id.ss);
        adapter = new Adapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<Myreservations> call, Throwable t) {

    }
}
