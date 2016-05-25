package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinyoon.a03popularmoviever2.retrofit.Results;
import com.example.jinyoon.a03popularmoviever2.retrofit.Trailers;

import java.util.List;

/**
 * Created by Jin Yoon on 5/25/2016.
 */
public class TrailerAdapter
        extends RecyclerView.Adapter<TrailerAdapter.ViewHolder>{

    private Context mContext;
    private List<Trailers> mTrailers;
    private final String LOG_TAG = this.getClass().getSimpleName();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView trailerTextView;
        private View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            trailerTextView = (TextView) itemView.findViewById(R.id.trailer_view_listitem);
        }
    }

    public TrailerAdapter(Context context, List<Trailers> trailers) {
        mContext=context;
        mTrailers=trailers;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_layout, parent, false);

        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mTrailers.get(position).getTrailerKey())));
            }
        });
        if(mTrailers.size()!=0) {
//            holder.trailerTextView.setText(mTrailers.get(position).getTrailerKey());
            holder.trailerTextView.setText(mTrailers.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        if(mTrailers!=null){
            return mTrailers.size();
        }else{
            return 0;
        }    }




//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if(convertView!=null){
//            convertView=inflater.inflate(R.layout.trailer_layout, parent, false);
//            TextView trailerTextView = (TextView) convertView.findViewById(R.id.trailer_view_listitem);
//        }else{
//            Log.v(LOG_TAG, "convertView null");
//        }
//
//
//        return convertView;
//    }

}
