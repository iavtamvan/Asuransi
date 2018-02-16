package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.iavariav.root.asuransi.R;

public class PendaftaranNasabahKeAgenUserActivity extends AppCompatActivity {

    private EditText edtNasabahAgenNoAgen;
    private EditText edtNasabahAgenNoPerusahaan;
    private EditText edtNasabahAgenNamaAgen;
    private EditText edtNasabahAgenAlamat;
    private EditText edtNasabahAgenPosisiLatLong;
    private EditText edtNasabahAgenTelepon;
    private LinearLayout containerCheckBox;

    private String[] dataCheckBox = {"Jiwa", "Kendaraan", "Kesehatan", "Property"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_nasabah_ke_agen_user);
        initView();
        getDataCheckBox();

    }

    private void getDataCheckBox() {

        for (int i = 0; i < dataCheckBox.length; i++) {
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row_checkbox_daftar_agen, null);
            final CheckBox cbNasabahAgenJiwa = (CheckBox) view.findViewById(R.id.cbNasabahAgen);
            cbNasabahAgenJiwa.setText(String.valueOf(dataCheckBox));

            containerCheckBox.addView(view);
        }


    }

    private void initView() {
        edtNasabahAgenNoAgen = (EditText) findViewById(R.id.edtNasabahAgenNoAgen);
        edtNasabahAgenNoPerusahaan = (EditText) findViewById(R.id.edtNasabahAgenNoPerusahaan);
        edtNasabahAgenNamaAgen = (EditText) findViewById(R.id.edtNasabahAgenNamaAgen);
        edtNasabahAgenAlamat = (EditText) findViewById(R.id.edtNasabahAgenAlamat);
        edtNasabahAgenPosisiLatLong = (EditText) findViewById(R.id.edtNasabahAgenPosisiLatLong);
        edtNasabahAgenTelepon = (EditText) findViewById(R.id.edtNasabahAgenTelepon);
        containerCheckBox = (LinearLayout) findViewById(R.id.containerCheckBox);
    }
}
