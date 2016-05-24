package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinyoon.a03popularmoviever2.retrofit.Results;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    private Results mResults;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        //ButterKnife.bind(this, rootView);
        //View toolbarView = inflater.inflate(R.layout.collapsing_toolbar_layout,null);

        ImageView backdropImageView = (ImageView) rootView.findViewById(R.id.backdrop);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);

        TextView titleTextView = (TextView) rootView.findViewById(R.id.detail_movie_title);
        TextView synopsisTextView = (TextView) rootView.findViewById(R.id.detail_movie_synopsis);
        TextView ratingTextView = (TextView) rootView.findViewById(R.id.detail_movie_rating);
        TextView dateTextView = (TextView) rootView.findViewById(R.id.detail_movie_date);

                Intent intent = getActivity().getIntent();
        if(intent!=null && intent.hasExtra("OBJECT_EXTRA")){
            mResults = (Results) intent.getSerializableExtra("OBJECT_EXTRA");

            Picasso.with(getContext())
                    .load(mResults.getBackdropPath())
                    .into(backdropImageView);

            titleTextView.setText(mResults.getTitle());
            synopsisTextView.setText(mResults.getOverview());
            ratingTextView.setText(String.format(getString(R.string.user_rating),mResults.getVoteAverage()));
            dateTextView.setText(String.format(getString(R.string.release_date),mResults.getReleaseDate()));
            //collapsingToolbarInflater();
            collapsingToolbar.setTitle(mResults.getTitle());

        }
        return rootView;
    }
/*
    public void collapsingToolbarInflater(){




    }*/


}
