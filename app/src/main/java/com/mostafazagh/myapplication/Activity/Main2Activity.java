package com.mostafazagh.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mostafazagh.myapplication.API.Drivers;
import com.mostafazagh.myapplication.API.endpoints;
import com.mostafazagh.myapplication.Adapter.Adapter;
import com.mostafazagh.myapplication.Adapter.Adapter2;
import com.mostafazagh.myapplication.R;
import com.mostafazagh.myapplication.models.Datum;
import com.mostafazagh.myapplication.models.DatumDrivers;
import com.mostafazagh.myapplication.models.GetDriversV2;
import com.mostafazagh.myapplication.models.Myreservations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements Callback<GetDriversV2> {
    static final String Base_Url = "http://shareme.entlq.net/api/v1/";
    public ProgressBar progressBar;
    public GetDriversV2 getDriversV2;
    public List<DatumDrivers> data;
    public RecyclerView recyclerView;
    private Adapter2 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar = findViewById(R.id.progressBar);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Drivers gerritAPI = retrofit.create(Drivers.class);

        Call<GetDriversV2> call = gerritAPI.getUsers("24.454545","15.7454555","27.1454545","26.545454","2018-11-30 10:05:10");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<GetDriversV2> call, Response<GetDriversV2> response) {
        Log.e("mr",response.body().getStatus().toString());

                progressBar.setVisibility(View.INVISIBLE);
        data = new ArrayList();
        data = response.body().getData();
        recyclerView = (RecyclerView) findViewById(R.id.xxs);
        adapter = new Adapter2(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<GetDriversV2> call, Throwable t) {

    }

    public void openChat(View view) {
    }
}
