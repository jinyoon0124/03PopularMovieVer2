package com.example.jinyoon.a03popularmoviever2.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jin Yoon on 5/25/2016.
 */
public class TrailerInfo {

    @SerializedName("results")
    @Expose
    private List<Trailers> trailers = new ArrayList<>();


    public List<Trailers> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailers> trailers) {
        this.trailers = trailers;
    }
}
