package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jinyoon.a03popularmoviever2.retrofit.Results;
import com.example.jinyoon.a03popularmoviever2.retrofit.Trailers;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context mContext;

    private List<Results> mResults;
    private final String DETAILFRAGMENT_TAG="DFTAG";


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        private View mView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.poster_image_view);
         }

    }

    public RecyclerViewAdapter(Context context, List<Results> results) {
        //super(context, results);
        mContext=context;
        mResults=results;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poster_item_list, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mView.setOnClickListener(new View.OnClickListener() {
            Results results = mResults.get(position);

            @Override
            public void onClick(View v) {
                if(MainActivity.mTwoPane){
                    Bundle args = new Bundle();
                    args.putSerializable("OBJECT_EXTRA", results);

                    DetailActivityFragment fragment = new DetailActivityFragment();
                    fragment.setArguments(args);

                    ((MainActivity) mContext).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_detail_container, fragment, DETAILFRAGMENT_TAG)
                        .commit();
                }else{
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("OBJECT_EXTRA", results);
                    mContext.startActivity(intent);
                }
            }
        });

        Picasso
                .with(mContext)
                .load(mResults.get(position).getPosterPath())
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        if(mResults!=null){
            return mResults.size();
        }else{
            return 0;
        }
    }


}
