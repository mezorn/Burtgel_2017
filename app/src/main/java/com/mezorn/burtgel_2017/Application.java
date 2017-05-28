package com.mezorn.burtgel_2017;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.google.gson.Gson;


/**
 * Created by manlai on 5/25/17.
 */

public class Application extends android.app.Application {

    public static final String TAG = Application.class.getSimpleName();
    private static Application instance;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        MultiDex.install(this);
    }

    Gson gson;

    protected Gson getGson() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }




    public static synchronized Application getInstance(){ return instance; }

}
