package com.iavariav.root.asuransi.Activity.User.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iavariav.root.asuransi.R;

public class EditProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
