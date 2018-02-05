package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.LoginAkunFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.BantuanFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.BerandaFragment;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.Fragment.MenuFragment;
import com.iavariav.root.asuransi.R;


public class HomeUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportActionBar().setTitle("Beranda");
        android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, BerandaFragment.newInstance());
        fragmentTransaction.commit();

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

}
