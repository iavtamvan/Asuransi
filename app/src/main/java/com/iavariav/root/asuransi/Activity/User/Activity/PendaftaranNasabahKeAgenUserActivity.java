package com.iavariav.root.asuransi.Activity.User.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.iavariav.root.asuransi.R;

import java.util.ArrayList;

public class PendaftaranNasabahKeAgenUserActivity extends AppCompatActivity {

    private EditText edtNasabahAgenNoAgen;
    private EditText edtNasabahAgenNoPerusahaan;
    private EditText edtNasabahAgenNamaAgen;
    private EditText edtNasabahAgenAlamat;
    private EditText edtNasabahAgenPosisiLatLong;
    private EditText edtNasabahAgenTelepon;
    private LinearLayout containerCheckBox;

    private ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_nasabah_ke_agen_user);
        initView();

        list.add("Jiwa");
        list.add("Kendaraan");
        list.add("Kesehatan");
        list.add("Property");

        getDataCheckBox();

    }

    private void getDataCheckBox() {

        for (int i = 0; i < list.size(); i++) {
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row_checkbox_daftar_agen, null);
            final CheckBox cbNasabahAgenJiwa = (CheckBox) view.findViewById(R.id.cbNasabahAgen);
            cbNasabahAgenJiwa.setText(list.get(i).toString().trim());
            cbNasabahAgenJiwa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Toast.makeText(PendaftaranNasabahKeAgenUserActivity.this, compoundButton.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
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
