package com.iavariav.root.asuransi.Activity.User.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.MapsInitializer;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.Model.CompanyModel;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;
import com.iavariav.root.asuransi.Service.ServiceMaps.GPSTracker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranNasabahKeAgenUserActivity extends AppCompatActivity {

    private EditText edtNasabahAgenNoAgen;
    private EditText edtNasabahAgenNoPerusahaan;
    private EditText edtNasabahAgenNamaAgen;
    private EditText edtNasabahAgenAlamat;
    private EditText edtNasabahAgenPosisiLatLong;
    private EditText edtNasabahAgenTelepon;
    private LinearLayout containerCheckBox;

    private ArrayList<String> list = new ArrayList<String>();
    private Spinner spnCompany;
    private EditText edtNasabahAgenAgama;
    private EditText edtNasabahAgenWilayah;
    private RadioButton rbNasabahAgenUserJiwa;
    private RadioButton rbNasabahAgenUserKendaraan;
    private RadioButton rbNasabahAgenUserKesehatan;
    private RadioButton rbNasabahAgenUserProperty;

    private String idAsuransi;
    private String idUser;
    private List<String> dataCompany;
    private ArrayList<CompanyModel> companyModels;


    private Button btnNasabahAgenUserDaftar;
    private Random r;
    private int random;
    private String idCompanyReal;
    private String idProdukCompany;
    private static final String[] agamaItem = {"Ketuk untuk memilih agama", "Islam", "Kristen Protestan", "Katolik", "Hindu", "Buddha", "Kong Hu Cu"};
    private Spinner spinnerAGAMA;


    GPSTracker gpsTracker;
    private double Lat, Long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_nasabah_ke_agen_user);
        initView();

        list.add("Jiwa");
        list.add("Kendaraan");
        list.add("Kesehatan");
        list.add("Property");

        dataCompany = new ArrayList<>();
        companyModels = new ArrayList<>();

        gpsTracker = new GPSTracker(PendaftaranNasabahKeAgenUserActivity.this);
        if (gpsTracker.canGetLocation()) {
            Lat = gpsTracker.getLatitude();
            Long = gpsTracker.getLongitude();
            MapsInitializer.initialize(PendaftaranNasabahKeAgenUserActivity.this);
        }
        else {
            gpsTracker.showSettingsAlert();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PendaftaranNasabahKeAgenUserActivity.this,
                android.R.layout.simple_spinner_item, agamaItem);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAGAMA.setAdapter(adapter);


        r = new Random();
        random = r.nextInt(20 - 7 + 98 - 5 - 3 / 6 * 332) + 65 + 31192;
        edtNasabahAgenNoAgen.setText("ASPIN" + random);

        SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, MODE_PRIVATE);
        idUser = sp.getString(String.valueOf(Config.SHARED_ID_USER), "");

        Toast.makeText(this, "" + idUser, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + idUser, Toast.LENGTH_SHORT).show();
//        getDataCheckBox();

        getdataCompany();

        btnNasabahAgenUserDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(PendaftaranNasabahKeAgenUserActivity.this, "Loading", "Harap tunggu...", false, false);

                ApiService apiService = Client.getInstanceRetrofit();
                apiService.postPendaftaranNasabahLoker(idUser, String.valueOf(random), idProdukCompany,
                        edtNasabahAgenNamaAgen.getText().toString().trim(),
                        edtNasabahAgenAlamat.getText().toString().trim(),
                        spinnerAGAMA.getSelectedItem().toString().trim(),
                        edtNasabahAgenTelepon.getText().toString().trim(),
                        edtNasabahAgenWilayah.getText().toString().trim(),
                        idAsuransi, Lat, Long)
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    try {
                                        JSONObject object = new JSONObject(response.body().string());
                                        String curl = object.optString("curl");
                                        Toast.makeText(PendaftaranNasabahKeAgenUserActivity.this, "" + curl, Toast.LENGTH_SHORT).show();
                                        loading.dismiss();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(), HomeUserActivity.class));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                loading.dismiss();
                                Toast.makeText(PendaftaranNasabahKeAgenUserActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    private void getdataCompany() {
        ApiService apiService = Client.getInstanceRetrofit();
        Call<ArrayList<CompanyModel>> call = apiService.getCompany();
        call.enqueue(new Callback<ArrayList<CompanyModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CompanyModel>> call, Response<ArrayList<CompanyModel>> response) {
                companyModels = response.body();
                for (int i = 0; i < companyModels.size(); i++) {
                    dataCompany.add(companyModels.get(i).getCOMNAME());
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(PendaftaranNasabahKeAgenUserActivity.this,
                            R.layout.support_simple_spinner_dropdown_item, dataCompany);
                    spnCompany.setAdapter(adapter);

                    spnCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            for (CompanyModel s : companyModels) {
                                if (s.getCOMNAME() != null && s.getCOMNAME().contains(spnCompany.getSelectedItem().toString().trim())) {
                                    idProdukCompany = s.getIDCOMPANY();
                                    Toast.makeText(PendaftaranNasabahKeAgenUserActivity.this, "" + idProdukCompany, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CompanyModel>> call, Throwable t) {
                Toast.makeText(PendaftaranNasabahKeAgenUserActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
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
        spnCompany = (Spinner) findViewById(R.id.spnCompany);
        edtNasabahAgenAgama = (EditText) findViewById(R.id.edtNasabahAgenAgama);
        edtNasabahAgenWilayah = (EditText) findViewById(R.id.edtNasabahAgenWilayah);
        rbNasabahAgenUserJiwa = (RadioButton) findViewById(R.id.rbNasabahAgenUserJiwa);
        rbNasabahAgenUserKendaraan = (RadioButton) findViewById(R.id.rbNasabahAgenUserKendaraan);
        rbNasabahAgenUserKesehatan = (RadioButton) findViewById(R.id.rbNasabahAgenUserKesehatan);
        rbNasabahAgenUserProperty = (RadioButton) findViewById(R.id.rbNasabahAgenUserProperty);
        btnNasabahAgenUserDaftar = (Button) findViewById(R.id.btnNasabahAgenUserDaftar);
        spinnerAGAMA = (Spinner) findViewById(R.id.spinnerAGAMA);
    }

    public void onRadioGrupClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbNasabahAgenUserJiwa:
                if (checked) {
                    idAsuransi = "1";
                    Toast.makeText(this, "" + idAsuransi, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbNasabahAgenUserKendaraan:
                if (checked) {
                    idAsuransi = "2";
                    Toast.makeText(this, "" + idAsuransi, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbNasabahAgenUserKesehatan:
                if (checked) {
                    idAsuransi = "3";
                    Toast.makeText(this, "" + idAsuransi, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbNasabahAgenUserProperty:
                if (checked) {
                    idAsuransi = "4";
                    Toast.makeText(this, "" + idAsuransi, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
