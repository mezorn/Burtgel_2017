package com.mezorn.burtgel_2017;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by manlai on 5/25/17.
 */

public class Storage {

    static String PREF_NAME = "pref";

    protected static String getInfo(String key, Context context){
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        String val = pref.getString(key, null);
        if(val == null){
            val = "null";
        }
        Log.v("getInfo: ", val);
        return pref.getString(key, null);

    }

    protected static void setInfo(String key, Context context, String info) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();
        if (info != null) {
            editor.putString(key, info);
        } else {
            editor.remove(key);
        }
        editor.commit();
    }

    protected static int getItem(String key, Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        int val = pref.getInt(key, 0);
//        Log.v("getItem:", val+"");
        return val;
    }

    protected static void setItem(String key, Context context, int item) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, item);
        editor.commit();
    }

    protected static boolean getBool(String key, Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        boolean val = pref.getBoolean(key, false);
//        Log.v("getBool:", val+"");
        return val;
    }

    protected static void setBool(String key, Context context, boolean bool) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, bool);
        editor.commit();
    }

    Gson gson;

    protected static Gson getGson() {
        return new Gson();
    }
}
