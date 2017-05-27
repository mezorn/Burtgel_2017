package com.mezorn.burtgel_2017;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import java.net.InetAddress;

/**
 * Created by manlai on 5/25/17.
 */

public class Utils extends Storage {
    static String TAG = "Util";
    static String KEY_TOKEN= "token";

    public static String getToken(Context context) {
        return getInfo(KEY_TOKEN, context);
    }

    public static void setToken(Context context, String token) {
        if (token != null) {
            Log.v(TAG, "setToken:" + token.toString());
        } else {
            Log.v(TAG, "setToken:" + token);
        }
        setInfo(KEY_TOKEN, context, token);
    }


    public static boolean isConnected(){
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name

            if (ipAddr.equals("")) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
