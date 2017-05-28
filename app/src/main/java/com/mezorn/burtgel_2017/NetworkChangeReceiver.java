package com.mezorn.burtgel_2017;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by manlai on 5/29/17.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        //  Log.v("network status", "Receieved notification about network status");
        if(Utils.isNetworkAvailable(context)){

                Log.i("Internet bainuu?", String.valueOf(Utils.isConnected()));

        }else{
            Log.i("Internet ", "baihgui ");
        }

    }
}