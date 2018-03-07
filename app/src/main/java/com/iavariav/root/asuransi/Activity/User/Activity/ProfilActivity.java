package com.iavariav.root.asuransi.Activity.User.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilActivity extends AppCompatActivity {

    private CircleImageView ciFoto;
    private TextView tvProfilNamaLengkap;
    private TextView tvprofilStatusUser;
    private TextView tvprofilLogout;
    private TextView tvProfilNoHp;
    private TextView tvProfilNIK;
    private TextView tvProfilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initView();

        SharedPreferences sp = getApplicationContext().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        tvProfilNamaLengkap.setText(sp.getString(Config.SHARED_FULLNAME, ""));
        tvprofilStatusUser.setText(sp.getString(Config.SHARED_STATUS_USER, ""));
        tvProfilNoHp.setText("083838191709");
        tvProfilNIK.setText(sp.getString(Config.SHARED_KTP, ""));
        tvProfilEmail.setText(sp.getString(Config.SHARED_EMAIL, ""));
        ciFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EditProfilActivity.class);
                startActivity(intent);
            }
        });

        tvprofilLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Config.forceLogout(getApplicationContext());
            }
        });
    }

    private void initView() {
        ciFoto = (CircleImageView) findViewById(R.id.ciFoto);
        tvProfilNamaLengkap = (TextView) findViewById(R.id.tvProfilNamaLengkap);
        tvprofilStatusUser = (TextView) findViewById(R.id.tvprofilStatusUser);
        tvprofilLogout = (TextView) findViewById(R.id.tvprofilLogout);
        tvProfilNoHp = (TextView) findViewById(R.id.tvProfilNoHp);
        tvProfilNIK = (TextView) findViewById(R.id.tvProfilNIK);
        tvProfilEmail = (TextView) findViewById(R.id.tvProfilEmail);
    }
}
