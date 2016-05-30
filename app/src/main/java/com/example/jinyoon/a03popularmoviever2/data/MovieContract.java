//package com.example.jinyoon.a03popularmoviever2.data;//package com.example.jinyoon.popularmovie.data;
//import android.content.ContentResolver;
//
//import android.content.ContentUris;
//import android.net.Uri;
//import android.provider.BaseColumns;
//
///**
// * Created by Jin Yoon on 5/17/2016.
// */
//public class MovieContract {
//
//    public static final String CONTENT_AUTHORITY = "com.example.jinyoon.popularmovie";
//    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
//    public static final String PATH_MOVIE = "movie";
//
//    public static final class MovieEntry implements BaseColumns{
//
//        public static final String TABLE_NAME = "movie";
//        public static final String COLUMN_MOVIE_ID = "movie_id";
//        public static final String COLUMN_TITLE = "title";
//        public static final String COLUMN_POSTER_IMAGE = "poster";
//        public static final String COLUMN_SYNOPSIS = "synopsis";
//        public static final String COLUMN_USER_RATING = "rating";
//        public static final String COLUMN_RELEASE_DATE = "date";
//
//        public static final Uri CONTENT_URI =
//                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();
//        public static final String CONTENT_TYPE =
//                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
//        public static final String CONTENT_ITEM_TYPE =
//                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
//
//        public static Uri buildMovieUri(long id) {
//            return ContentUris.withAppendedId(CONTENT_URI, id);
//        }
//
//
//
//
//
//
//
//
//    }
//
//
//
//
//}
