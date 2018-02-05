package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.iavariav.root.asuransi.R;

public class DetailUserActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.keluar) {
//            SharedPref sharedPref = new SharedPref(this);
//            sharedPref.deleteUser();
//            sharedPref.savePrefBoolean(SharedPref.status_login,false);
//            finish();
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
