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
        //Get previous favorite items

        Set<String>favoriteList=getStringFromPreferences(context, FAVORITE_KEY);
        // Append new Favorite item

        if(favoriteList!=null && !favoriteList.contains(favoriteItem)){
            favoriteList.add(favoriteItem);
        }else if(favoriteList==null){
            favoriteList = new HashSet<>();
            favoriteList.add(favoriteItem);
        }
        // Save in Shared Preferences
        return putStringInPreferences(context,favoriteList, FAVORITE_KEY);
    }
//    public static Set<String> getFavoriteList(Context context){
//        Set<String> favoriteList = getStringFromPreferences(context, FAVORITE_KEY);
//        return convertStringToArray(favoriteList);
//    }

    private static boolean putStringInPreferences(Context context,Set<String> nick,String key){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putStringSet(key, nick);
        mEditor.commit();
        return true;
    }
//
//    private static String getStringFromPreferences(Context context,String defaultValue,String key){
//        SharedPreferences sharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(key, defaultValue);
//    }


    public static Set<String> getStringFromPreferences(Context context, String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getStringSet(key, null);
    }

//    private static String[] convertStringToArray(String str){
//        if(str!=null){
//            return str.split(",");
//        }else{
//            return null;
//        }
//    }
    public static void removeStringFromPreferences(Context context){
        mSharedPreferences = context.getSharedPreferences(FAVORITE_KEY, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putStringSet(FAVORITE_KEY,null);
        mEditor.commit();

    }


}
