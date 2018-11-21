package com.mostafazagh.myapplication.API;

import com.mostafazagh.myapplication.models.Myreservations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface endpoints {
    @GET("my-reservations")
    Call<Myreservations> getUsers(@Header("Authorization") String auth);
}
