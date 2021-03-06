package com.example.jinyoon.a03popularmoviever2.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jin Yoon on 5/18/2016.
 */
public final class TMDBService {

    public TMDBService() {
        super();
    }

    public interface TMDBAPI{
        @GET("/3/movie/{mode}")
        Call<MovieInfo> getInfo(
                @Path("mode") String mode,
                @Query("api_key") String api_key
        );

        @GET("/3/movie/{id}/reviews")
        Call<ReviewInfo> getReview(
                @Path("id") int id,
                @Query("api_key") String api_key
        );

        @GET("/3/movie/{id}/videos")
        Call<TrailerInfo> getTrailer(
                @Path("id") int id,
                @Query("api_key") String api_key
        );
    }
}
