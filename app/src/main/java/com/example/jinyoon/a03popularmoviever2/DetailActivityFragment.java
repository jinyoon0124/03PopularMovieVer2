package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinyoon.a03popularmoviever2.retrofit.MovieInfo;
import com.example.jinyoon.a03popularmoviever2.retrofit.Results;
import com.example.jinyoon.a03popularmoviever2.retrofit.ReviewInfo;
import com.example.jinyoon.a03popularmoviever2.retrofit.Reviews;
import com.example.jinyoon.a03popularmoviever2.retrofit.TMDBService;
import com.example.jinyoon.a03popularmoviever2.retrofit.TrailerInfo;
import com.example.jinyoon.a03popularmoviever2.retrofit.Trailers;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    private Results mResults;
    final String BASE_URL = "http://api.themoviedb.org";
    private Call<ReviewInfo> reviewInfoCall;
    private ReviewInfo mReviewInfo;
    private List<Reviews> mReviews;
    int id;
    private RecyclerView mRecyclerView;
    private ReviewAdapter mReviewAdapter;
    private TextView mTitleView;

    private Call<TrailerInfo> trailerInfoCall;
    private TrailerInfo mTrailerInfo;
    private List<Trailers> mTrailers;
    private RecyclerView mTrailerView;
    private TrailerAdapter mTrailerAdapter;
    private TextView mTrailerTitleTextView;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.review_view);
        mTrailerView = (RecyclerView) rootView.findViewById(R.id.trailer_view);
        ImageView backdropImageView = (ImageView) rootView.findViewById(R.id.backdrop);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);

        TextView titleTextView = (TextView) rootView.findViewById(R.id.detail_movie_title);
        TextView synopsisTextView = (TextView) rootView.findViewById(R.id.detail_movie_synopsis);
        TextView ratingTextView = (TextView) rootView.findViewById(R.id.detail_movie_rating);
        TextView dateTextView = (TextView) rootView.findViewById(R.id.detail_movie_date);
        mTitleView = (TextView) rootView.findViewById(R.id.review_title);
        mTrailerTitleTextView = (TextView) rootView.findViewById(R.id.trailer_title);

        Intent intent = getActivity().getIntent();
        if(intent!=null && intent.hasExtra("OBJECT_EXTRA")){
            mResults = (Results) intent.getSerializableExtra("OBJECT_EXTRA");
            id=mResults.getId();
            Picasso.with(getContext())
                    .load(mResults.getBackdropPath())
                    .into(backdropImageView);

            titleTextView.setText(mResults.getTitle());
            synopsisTextView.setText(mResults.getOverview());
            ratingTextView.setText(String.format(getString(R.string.user_rating),mResults.getVoteAverage()));
            dateTextView.setText(String.format(getString(R.string.release_date),mResults.getReleaseDate()));
            collapsingToolbar.setTitle(mResults.getTitle());

            getReview();
            getTrailer();

        }
        return rootView;
    }

    public void getReview(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService.TMDBAPI tmdbapi = retrofit.create(TMDBService.TMDBAPI.class);
        reviewInfoCall = tmdbapi.getReview(id, BuildConfig.MOVIE_API_KEY);

        reviewInfoCall.enqueue(new Callback<ReviewInfo>() {
            @Override
            public void onResponse(Call<ReviewInfo> call, Response<ReviewInfo> response) {
                mReviewInfo = response.body();
                mReviews=mReviewInfo.getReviews();
                mReviewAdapter= new ReviewAdapter(getContext(),mReviews);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                mRecyclerView.setAdapter(mReviewAdapter);
                mTitleView.setText(String.format(
                        getString(R.string.review_title), mReviews.size()));

            }

            @Override
            public void onFailure(Call<ReviewInfo> call, Throwable t) {

            }
        });
    }

    public void getTrailer(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService.TMDBAPI tmdbapi = retrofit.create(TMDBService.TMDBAPI.class);
        trailerInfoCall = tmdbapi.getTrailer(id, BuildConfig.MOVIE_API_KEY);

        trailerInfoCall.enqueue(new Callback<TrailerInfo>() {
            @Override
            public void onResponse(Call<TrailerInfo> call, Response<TrailerInfo> response) {
                mTrailerInfo= response.body();
                mTrailers=mTrailerInfo.getTrailers();

                mTrailerAdapter = new TrailerAdapter(getActivity(), mTrailers);
                mTrailerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                mTrailerView.setAdapter(mTrailerAdapter);
                mTrailerTitleTextView.setText(String.format(
                        getString(R.string.trailer_title), mTrailers.size()));

            }

            @Override
            public void onFailure(Call<TrailerInfo> call, Throwable t) {

            }
        });
    }



}
