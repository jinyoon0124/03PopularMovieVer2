package com.example.jinyoon.a03popularmoviever2;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;


public class MyUtility {

    private static String FAVORITE_KEY = "favorite";
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;


    public static boolean addFavoriteItem(Context context, String favoriteItem){
        Set<String>favoriteList=getStringFromPreferences(context, FAVORITE_KEY);

        if(favoriteList!=null && !favoriteList.contains(favoriteItem)){
            favoriteList.add(favoriteItem);
        }else if(favoriteList==null){
            favoriteList = new HashSet<>();
            favoriteList.add(favoriteItem);
        }

        return putStringInPreferences(context,favoriteList, FAVORITE_KEY);
    }

    private static boolean putStringInPreferences(Context context,Set<String> nick,String key){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putStringSet(key, nick);
        mEditor.commit();
        return true;
    }

    public static Set<String> getStringFromPreferences(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getStringSet(key, null);
    }

    public static void clearStringFromPreferences(Context context){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putStringSet(FAVORITE_KEY,null);
        mEditor.commit();
    }

    public static boolean removeStringFromPreferences(Context context, String favoriteItem){
        Set<String>favoriteList=getStringFromPreferences(context, FAVORITE_KEY);

        if(favoriteList!=null && favoriteList.contains(favoriteItem)){
            favoriteList.remove(favoriteItem);
        }
        return putStringInPreferences(context,favoriteList, FAVORITE_KEY);
    }



}
