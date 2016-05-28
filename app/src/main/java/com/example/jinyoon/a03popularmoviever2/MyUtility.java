package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.SharedPreferences;


public class MyUtility {

    private static String FAVORITE_KEY = "favorite";
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;

    public static boolean addFavoriteItem(Context context, String favoriteItem){
        //Get previous favorite items
        String favoriteList = getStringFromPreferences(context,null, FAVORITE_KEY);
        // Append new Favorite item
        if(favoriteList!=null){
            favoriteList = favoriteList+","+favoriteItem;
        }else{
            favoriteList = favoriteItem;
        }
        // Save in Shared Preferences
        return putStringInPreferences(context,favoriteList, FAVORITE_KEY);
    }
    public static String[] getFavoriteList(Context context){
        String favoriteList = getStringFromPreferences(context,null,FAVORITE_KEY);
        return convertStringToArray(favoriteList);
    }
    private static boolean putStringInPreferences(Context context,String nick,String key){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, nick);
        mEditor.commit();
        return true;
    }
    private static String getStringFromPreferences(Context context,String defaultValue,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, defaultValue);
    }

    private static String[] convertStringToArray(String str){
        if(str!=null){
            return str.split(",");
        }else{
            return null;
        }
    }
    public static void removeStringFromPreferences(Context context){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putString(FAVORITE_KEY,"");
        mEditor.commit();

    }


}
