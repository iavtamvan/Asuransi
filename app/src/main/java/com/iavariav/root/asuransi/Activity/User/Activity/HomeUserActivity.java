package com.iavariav.root.asuransi.Activity.User.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.iavariav.root.asuransi.Activity.User.Activity.Fragment.BantuanNewsFragment;
import com.iavariav.root.asuransi.Activity.User.Activity.Fragment.BerandaMapsFragment;
import com.iavariav.root.asuransi.Activity.User.Activity.Fragment.LainnyaFragment;
import com.iavariav.root.asuransi.Activity.User.Activity.Fragment.MenuFragment;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;
import com.iavariav.root.asuransi.Service.Firebase.NotificationUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                        new BerandaMapsFragment())
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
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, Context.MODE_PRIVATE);
        final String regId = pref.getString("regId", null);

        SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String userID = sp.getString(String.valueOf(Config.SHARED_ID_USER), "");
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.updateTokenFcm(userID, regId)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.e(TAG, "response");
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonObject  = new JSONObject(response.body().string());
                                String message = jsonObject.optString("message");
                                Log.e(TAG, "sukses msg :" + regId);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(HomeUserActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });


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
                    fragment =  BerandaMapsFragment.newInstance();
                    getSupportActionBar().setTitle("Beranda");
                    break;
                case R.id.bottMenu:
                    fragment = MenuFragment.newInstance();
                    getSupportActionBar().setTitle("Menu");
                    break;
                case R.id.bottBantuan:
                    fragment = BantuanNewsFragment.newInstance();
                    getSupportActionBar().setTitle("Bantuan");
                    break;
                case R.id.bottAkun:
                    fragment = LainnyaFragment.newInstance();
                    getSupportActionBar().setTitle("Profil");
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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Tutup Aplikasi")
                .setMessage("Apakah anda ingin menutup aplikasi ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                    }

                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
