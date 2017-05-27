package com.mezorn.burtgel_2017;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import java.net.InetAddress;

/**
 * Created by manlai on 5/25/17.
 */

public class Utils extends Storage {
   /* {
        "id": 2010101001101,
            "code": 39534608,
            "role": 1,
            "aimag": "архангай",
            "sumduureg": "батцэнгэл",
            "bagkhoroo": "1-р баг, улаанчулуу",
            "heseg_id": 11,
            "heseg_name": "11-р хэсэг",
            "heseg_in_bagkhoroo": 1,
            "fullname": "",
            "phone": "",
            "token": "c68d3f3b7a81cf0e8b92df9bc27c88158626bc2d"
    }*/

    static String TAG = "Util";
    static String KEY_TOKEN= "token";
    static String KEY_ID = "id";
    static String KEY_CODE = "code";
    static String KEY_ROLE = "role";
    static String KEY_AIMAG="aimag";
    static String KEY_SUMDUUREG = "sumduureg";
    static String KEY_BAGKHOROO = "bagkhoroo";
    static String KEY_HESEG_ID = "heseh_id";
    static String KEY_HESEG_NAME = "heseg_name";
    static String KEY_HESEG_IN_BAGKHOROO = "heseg_in_bagkhoroo";
    static String KEY_FULLNAME = "fullname";
    static String KEY_PHONE = "phone";

    public static String getID(Context context) {
        return getInfo(KEY_ID, context);
    }
    public static void setID(Context context, String id) {

        setInfo(KEY_ID, context, id);
    }

    public static String getRole(Context context) {
        return getInfo(KEY_ROLE, context);
    }
    public static void setRole(Context context, String role) {
       setInfo(KEY_ROLE, context, role);
    }



    public static String getCode(Context context) {
        return getInfo(KEY_CODE, context);
    }
    public static void setCode(Context context, String code) {
        setInfo(KEY_CODE, context, code);
    }

    public static String getAimag(Context context) {
        return getInfo(KEY_AIMAG, context);
    }
    public static void setAimag(Context context, String aimag) {
        setInfo(KEY_AIMAG, context, aimag);
    }

    public static String getSumduureg(Context context) {
        return getInfo(KEY_SUMDUUREG, context);
    }
    public static void setSumduureg(Context context, String value) {
        setInfo(KEY_SUMDUUREG, context, value);
    }

    public static String getBagkhoroo(Context context) {
        return getInfo(KEY_BAGKHOROO, context);    }

    public static void setBagkhoroo(Context context, String value) {
        setInfo(KEY_BAGKHOROO, context, value);
    }

    public static String getHesegId(Context context) {
        return getInfo(KEY_HESEG_ID, context);    }

    public static void setHesegId(Context context, String value) {
        setInfo(KEY_HESEG_ID, context, value);
    }

    public static String getHesegName(Context context) {
        return getInfo(KEY_HESEG_NAME, context);
    }
    public static void setHesegName(Context context, String value) {
        setInfo(KEY_HESEG_NAME, context, value);
    }

    public static String getHeseginBagkhoroo(Context context) {
        return getInfo(KEY_HESEG_IN_BAGKHOROO, context);
    }
    public static void setHeseginBagkhoroo(Context context, String value) {
        setInfo(KEY_HESEG_IN_BAGKHOROO, context, value);
    }

    public static String getFullname(Context context) {
        return getInfo(KEY_FULLNAME, context);    }
    public static void setFullname(Context context, String value) {
        setInfo(KEY_FULLNAME, context, value);
    }

    public static String getPhone(Context context) {
        return getInfo(KEY_PHONE, context);
    }
    public static void setPhone(Context context, String value) {
        setInfo(KEY_PHONE, context, value);
    }

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
