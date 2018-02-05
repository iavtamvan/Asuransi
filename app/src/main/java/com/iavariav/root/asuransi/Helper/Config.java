package com.iavariav.root.asuransi.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.iavariav.root.asuransi.LoginActivity;

/**
 * Created by root on 1/25/18.
 */

public final class Config {
    public static final String BASE_URL = "";
    public static final String ERROR_NETWORK = "Periksa jaringan anda";
    public static final String ERROR_LOGIN = "Akun tidak terdaftar";

    public static final String ERROR_MSG_BERHASIL = "Register berhasil,silahkan melakukan login";
    public static final String ERROR_MSG_ERROR = "User telah ada dengan email ";

//    Shared
    public static final String SHARED_PREF_NAME = "ASURANSI";
    public static final String SHARED_NAMA = "NAMA";
    public static final String SHARED_ERROR = "ERROR";
    public static final String SHARED_RULE_LOGIN = "RULE";
    public static final String SHARED_STATUS_USER = "STATUS USER";
    public static final String SHARED_EMAIL = "EMAIL";
    public static final String SHARED_FULLNAME = "FULLNAME";
    public static final String SHARED_KTP = "KTP";
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

    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
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

}
