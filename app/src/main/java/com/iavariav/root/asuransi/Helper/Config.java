package com.iavariav.root.asuransi.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.iavariav.root.asuransi.Activity.LoginActivity;

/**
 * Created by root on 1/25/18.
 */

public final class Config {
    public static final String BASE_URL = "";
    public static final String ERROR_NETWORK = "Periksa jaringan anda";
    public static final String ERROR_LOGIN = "Akun tidak terdaftar";
    public static final String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
    public static final String FACEBOOK_PAGE_ID = "YourPageName";

//    bundle
    public static final String BUNDLE_ID_JENIS_ASURANSI_JIWA= "jiwa";
    public static final String BUNDLE_ID_JENIS_ASURANSI_KENDARAAN = "kendaraan";
    public static final String BUNDLE_ID_JENIS_ASURANSI_KESEHATAN = "kesehatan";
    public static final String BUNDLE_ID_JENIS_ASURANSI_PROPERTY = "property";
    public static final String BUNDLE_ID_JENIS_ASURANSI = "jenisasuransi";
//    selesai bundle

//    permission
    public static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1;
//    permisson selesai

//    firebase
// global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";
//    firebase selesai


//    login
    public static final String ERROR_MSG_LOGIN_BERHASIL = "Register berhasil,silahkan melakukan login";
    public static final String ERROR_MSG_LOGIN_ERROR = "User telah ada dengan email ";
//    login selesai

//    error data
    public static final String ERROR_DATA_IN_USED = "Maaf data sudah ada";
//    error data selesai

//    maps
    public static final int ZOOM_TO_LEVEL = 15;
    public static final int RADIOUS_TO_LEVEL = 100;
//    maps selesai



//    Shared
    public static final String SHARED_PREF_NAME = "ASURANSI";
    public static final int SHARED_ID_USER=0;
    public static final String SHARED_NAMA = "NAMA";
    public static final String SHARED_ERROR = "ERROR";
    public static final String SHARED_RULE_LOGIN = "RULE";
    public static final String SHARED_STATUS_USER = "STATUS USER";
    public static final String SHARED_EMAIL = "EMAIL";
    public static final String SHARED_FULLNAME = "FULLNAME";
    public static final String SHARED_KTP = "KTP";
    public static final String SHARED_IMAGE = "IMAGE";

    public static final String SHARED_LAT = "LAT";
    public static final String SHARED_LONG = "LONG";
//    Shared Selesai

//    Bundle
    public static final String BUNDLE_ID_ARTIKEL = "ID_ARTIKEL";
    public static final String BUNDLE_ART_ISI = "ART_ISI";
    public static final String BUNDLE_ART_GAMBAR = "ART_GAMBAR";
    public static final String BUNDLE_ART_CREATED_BY = "ART_CREATED_BY";
    public static final String BUNDLE_ART_CREATED_AT = "ART_CREATED_AT";
//    Bundle Selesai


//    Model
    public static final String ID_ARTIKEL = "ID_ARTIKEL";
    public static final String ART_ISI = "ART_ISI";
    public static final String ART_GAMBAR = "ART_GAMBAR";
    public static final String ART_CREATED_BY = "ART_CREATED_BY";
    public static final String ART_CREATED_AT = "ART_CREATED_AT";
//    Model Selesai


    public static final int PICK_FILE_REQUEST = 1;

    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(String.valueOf(Config.SHARED_ID_USER), "");
        editor.putString(Config.SHARED_NAMA   , "");
        editor.putString(Config.SHARED_ERROR    , "");
        editor.putString(Config.SHARED_RULE_LOGIN  , "");
        editor.putString(Config.SHARED_STATUS_USER , "");
        editor.putString(Config.SHARED_EMAIL  , "");
        editor.putString(Config.SHARED_FULLNAME     , "");
        editor.putString(Config.SHARED_KTP     , "");
        //Saving the sharedpreferences
        editor.commit();

        //Starting login activity
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        context.startActivity(intent);

    }
    public static String formatDMY(int year, int month, int date) {
        String formattedDate = "";

        if(date < 10)   {
            formattedDate += Integer.toString(year);
        }
        else {
            formattedDate += Integer.toString(year);
        }
        formattedDate += "-";

        if(month < 10) {
            formattedDate += "0" + Integer.toString(month);
        }
        else {
            formattedDate += Integer.toString(month);
        }
        formattedDate += "-";

        formattedDate += Integer.toString(date);

        return formattedDate;
    }

}
