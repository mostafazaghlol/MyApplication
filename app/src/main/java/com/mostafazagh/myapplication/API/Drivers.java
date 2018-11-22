package com.mostafazagh.myapplication.API;

import com.mostafazagh.myapplication.models.GetDriversV2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Drivers {
    @POST("search-trips")
    Call<GetDriversV2> getUsers(@Header("from_lng") String fromlng,
                                @Header("from_lat") String fromlat,
                                @Header("to_lng") String tolng,
                                @Header("to_lat") String tolat,
                                @Header("trip_date") String date);
}
