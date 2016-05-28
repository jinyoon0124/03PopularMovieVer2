package com.example.jinyoon.a03popularmoviever2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jinyoon.a03popularmoviever2.retrofit.MovieInfo;
import com.example.jinyoon.a03popularmoviever2.retrofit.Results;
import com.example.jinyoon.a03popularmoviever2.retrofit.TMDBService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    final String BASE_URL = "http://api.themoviedb.org";
    private MovieInfo mMovieInfo;
    private List<Results> mResults;
    private Call<MovieInfo> call;
    private String mode;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mResultAdapter;
    private boolean mFavorite;


    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.movie_fragment, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.poster_view);
        updatePoster();

        return rootView;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_refresh:
                updatePoster();
                break;

            case R.id.action_remove:
                MyUtility.removeStringFromPreferences(getContext());
                Toast.makeText(getContext(), "All Favorite Removed!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void updatePoster(){
        SharedPreferences spr = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mode=spr.getString(getString(R.string.pref_general_key), getString(R.string.pref_general_default));
        mFavorite=spr.getBoolean(getString(R.string.pref_favorite_key), false);
        if(mFavorite){
            getFavoriteInfo();

        }else{
            getMovieInfo();
        }
    }

    private void getMovieInfo() {
        Toast.makeText(getContext(),"GETMOVIEINFO CALLED", Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService.TMDBAPI tmdbapi = retrofit.create(TMDBService.TMDBAPI.class);
        call = tmdbapi.getInfo(mode, BuildConfig.MOVIE_API_KEY);

        call.enqueue(new Callback<MovieInfo>() {
            @Override
            public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                mMovieInfo = response.body();
                mResults=mMovieInfo.getResults();
                mResultAdapter= new RecyclerViewAdapter(getContext(),mResults);
                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
                mRecyclerView.setAdapter(mResultAdapter);
            }
            @Override
            public void onFailure(Call<MovieInfo> call, Throwable t) {

            }
        });
    }

    private void getFavoriteInfo(){
        Toast.makeText(getContext(),"FAVORITE SELECTED", Toast.LENGTH_SHORT).show();
        getMovieInfo();

    }
}
