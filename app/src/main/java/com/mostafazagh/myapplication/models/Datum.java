
package com.mostafazagh.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("trip_id")
    @Expose
    private Integer tripId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("get_user")
    @Expose
    private GetUser getUser;
    @SerializedName("get_trip")
    @Expose
    private GetTrip getTrip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public GetUser getGetUser() {
        return getUser;
    }

    public void setGetUser(GetUser getUser) {
        this.getUser = getUser;
    }

    public GetTrip getGetTrip() {
        return getTrip;
    }

    public void setGetTrip(GetTrip getTrip) {
        this.getTrip = getTrip;
    }

}
