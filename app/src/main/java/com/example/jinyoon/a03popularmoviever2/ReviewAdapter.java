package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinyoon.a03popularmoviever2.retrofit.Reviews;

import java.util.List;


public class ReviewAdapter
        extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{

    private Context mContext;
    private List<Reviews> mReviews;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextView;
        private View mView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            mTextView = (TextView) itemView.findViewById(R.id.detail_movie_review);
        }
    }

    public ReviewAdapter(Context context, List<Reviews> reviews) {
        mContext=context;
        mReviews=reviews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(mReviews.size()!=0){
            holder.mTextView.setText(String.format(
                    mContext.getString(R.string.review_content), mReviews.get(position).getContent(), mReviews.get(position).getAuthor()));
        }


    }

    @Override
    public int getItemCount() {
        if(mReviews!=null){
            return mReviews.size();
        }else{
            return 0;
        }    }
}
