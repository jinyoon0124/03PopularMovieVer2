package com.example.jinyoon.a03popularmoviever2.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jin Yoon on 5/25/2016.
 */
public class Trailers {

    @SerializedName("key")
    @Expose
    private String trailerKey;

    @SerializedName("name")
    @Expose
    private String name;

    private final String TRAILER_URL= "https://www.youtube.com/watch?v=";

    public String getTrailerKey() {
        return TRAILER_URL+trailerKey;
    }

    public void setTrailerKey(String trailerKey) {
        this.trailerKey = trailerKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
