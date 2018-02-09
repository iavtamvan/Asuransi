package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.LoginAkunFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.BantuanFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.BerandaFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.MapsBerandaFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.MenuFragment;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Service.NotificationUtils;


public class HomeUserActivity extends AppCompatActivity {
    FragmentManager fragmentManager =
            getSupportFragmentManager();
    private static final String TAG = HomeUserActivity.class.getSimpleName();
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle("Beranda");
        fragmentManager.beginTransaction()
                .replace(R.id.content,
                        new BerandaFragment())
                .commit();
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);
                    displayFirebaseRegId();
                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received
                    String message = intent.getStringExtra("message");
//                    txtMessage.setText(message);
                }
            }
        };
        displayFirebaseRegId();

    }

    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId)){
            Toast.makeText(HomeUserActivity.this, "Notifikasi Online", Toast.LENGTH_SHORT).show();
        }
//            txtRegId.setText("Firebase Reg Id: " + regId);
        else
            Toast.makeText(HomeUserActivity.this, "Notifikasi offline", Toast.LENGTH_SHORT).show();
//            txtRegId.setText("Firebase Reg Id is not received yet!");
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.bottBerranda:
                    fragment =  BerandaFragment.newInstance();
                    getSupportActionBar().setTitle("Beranda");
                    break;
                case R.id.bottMenu:
                    fragment = MenuFragment.newInstance();
                    getSupportActionBar().setTitle("Menu");
                    break;
                case R.id.bottBantuan:
                    fragment = BantuanFragment.newInstance();
                    getSupportActionBar().setTitle("Bantuan");
                    break;
                case R.id.bottAkun:
                    fragment = LoginAkunFragment.newInstance();
                    getSupportActionBar().setTitle("Akun");
                    break;
            }
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }
}
