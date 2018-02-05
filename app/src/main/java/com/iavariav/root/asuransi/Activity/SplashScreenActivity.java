package com.iavariav.root.asuransi.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.iavariav.root.asuransi.Activity.Agen.HomeAgenActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.HomeUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.LoginActivity;
import com.iavariav.root.asuransi.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int splash = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
//                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
//                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent

                SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String email = sp.getString(Config.SHARED_EMAIL,"");
                String rulename = sp.getString(Config.SHARED_RULE_LOGIN,"");
                if(email.equalsIgnoreCase("") || TextUtils.isEmpty(email)) {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else if (rulename.equalsIgnoreCase("RL_AGN")){
                    Intent intent = new Intent(SplashScreenActivity.this, HomeAgenActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashScreenActivity.this, HomeUserActivity.class);
                    startActivity(intent);
                }
                //jeda selesai Splashscreen
                finish();
            }

        }, splash);

    }
}