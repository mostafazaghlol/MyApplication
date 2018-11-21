
package com.mostafazagh.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTrip {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("from_lng")
    @Expose
    private String fromLng;
    @SerializedName("from_lat")
    @Expose
    private String fromLat;
    @SerializedName("to_lng")
    @Expose
    private String toLng;
    @SerializedName("to_lat")
    @Expose
    private String toLat;
    @SerializedName("trip_date")
    @Expose
    private String tripDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("from_address")
    @Expose
    private String fromAddress;
    @SerializedName("to_address")
    @Expose
    private String toAddress;

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

    public String getFromLng() {
        return fromLng;
    }

    public void setFromLng(String fromLng) {
        this.fromLng = fromLng;
    }

    public String getFromLat() {
        return fromLat;
    }

    public void setFromLat(String fromLat) {
        this.fromLat = fromLat;
    }

    public String getToLng() {
        return toLng;
    }

    public void setToLng(String toLng) {
        this.toLng = toLng;
    }

    public String getToLat() {
        return toLat;
    }

    public void setToLat(String toLat) {
        this.toLat = toLat;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
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

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
