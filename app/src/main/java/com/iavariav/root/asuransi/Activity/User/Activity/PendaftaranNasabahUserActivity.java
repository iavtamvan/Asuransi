package com.iavariav.root.asuransi.Activity.User.Activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranNasabahUserActivity extends AppCompatActivity {

    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;
    private int random;
    private String idJenisKelamin;
    private String idStatusKawin;
    private String idStatusKewarganegaraan;
    private String dataBundle;
    private String spNamaLengkap;
    private String spIdUser;
    private Random r;

    private Button btnPendaftaranAgenSubmit;
    private LinearLayout containerTanggal;
    private TextView tvTanggalLahir;
    private EditText edtPendaftaranAgenUserNomorVerivikasi;
    private EditText edtPendaftaranAgenUserNamaLengkap;
    private RadioButton rbPendaftaranAgenUserLakiLaki;
    private RadioButton rbPendaftaranAgenUserPerempuan;
    private TextView tvPendaftaranAgenUserTanggalLahir;
    private EditText edtPendaftaranAgenUserNoHp;
    private EditText edtPendaftaranAgenUserAlamat;
    private EditText edtPendaftaranAgenUserTempatLahir;
    private TextView tvPendaftaranAgenSyaratdanKetentuan;

    private Spinner spinnerAGAMA;
    private static final String[] agamaItem = {"Ketuk untuk memilih agama", "Islam", "Kristen Protestan", "Katolik", "Hindu", "Buddha", "Kong Hu Cu"};
    private EditText edtPendaftaranAgenUserPekerjaan;
    private RadioButton rbPendaftaranAgenUserKawin;
    private RadioButton rbPendaftaranAgenUserBelumKawin;
    private RadioButton rbPendaftaranAgenUserCerai;
    private RadioButton rbPendaftaranAgenUserWNI;
    private RadioButton rbPendaftaranAgenUserWNA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_agen);
        initView();

        r = new Random();
        random = r.nextInt(20 - 7 + 98 - 5 - 3 / 6) + 65 + 31192;
        edtPendaftaranAgenUserNomorVerivikasi.setText("ASPIN" + String.valueOf(random));
        edtPendaftaranAgenUserNomorVerivikasi.setFocusable(false);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        dataBundle = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI);
        Toast.makeText(this, "Bundle daftar nasabah asuransi : " + dataBundle, Toast.LENGTH_SHORT).show();

        SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        spNamaLengkap = sp.getString(Config.SHARED_FULLNAME, "");
        spIdUser = sp.getString(Config.SHARED_ID_USER, "");

        edtPendaftaranAgenUserNamaLengkap.setText(spNamaLengkap);
        edtPendaftaranAgenUserNamaLengkap.setFocusable(false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PendaftaranNasabahUserActivity.this,
                android.R.layout.simple_spinner_item, agamaItem);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAGAMA.setAdapter(adapter);
        btnPendaftaranAgenSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(PendaftaranNasabahUserActivity.this, "Loading", "Harap tunggu...", false, false);
                ApiService apiService = Client.getInstanceRetrofit();
                apiService.postPendaftaranAgenUser(
                        spIdUser,
                        edtPendaftaranAgenUserNomorVerivikasi.getText().toString().trim(),
                        edtPendaftaranAgenUserNamaLengkap.getText().toString().trim(),
                        edtPendaftaranAgenUserTempatLahir.getText().toString().trim(),
                        tvTanggalLahir.getText().toString().trim(),
                        idJenisKelamin,
                        edtPendaftaranAgenUserAlamat.getText().toString().trim(),
                        spinnerAGAMA.getSelectedItem().toString().trim(),
                        edtPendaftaranAgenUserNoHp.getText().toString().trim(),
                        edtPendaftaranAgenUserPekerjaan.getText().toString().trim(),
                        idStatusKewarganegaraan,
                        idStatusKawin,
                        dataBundle

                ).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                loading.dismiss();
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                String error_msg = jsonObject.optString("error_msg");
                                String tampil_nomer_verif = jsonObject.optString("tampil_nomer_verif");
                                Toast.makeText(PendaftaranNasabahUserActivity.this, "" + error_msg + tampil_nomer_verif, Toast.LENGTH_SHORT).show();
                                r = new Random();
                                random = r.nextInt(20 - 7 + 98 - 5 - 3 / 6) + 65 + 31192;
                                edtPendaftaranAgenUserNomorVerivikasi.setText("ASPIN" + String.valueOf(random));
                                edtPendaftaranAgenUserNamaLengkap.setText("");
                                tvTanggalLahir.setText("Tanggal Lahir");
                                edtPendaftaranAgenUserNoHp.setText("");
                                edtPendaftaranAgenUserAlamat.setText("");
                                rbPendaftaranAgenUserLakiLaki.setChecked(false);
                                rbPendaftaranAgenUserPerempuan.setChecked(false);
                                edtPendaftaranAgenUserPekerjaan.setText("");
                                rbPendaftaranAgenUserKawin.setChecked(false);
                                rbPendaftaranAgenUserBelumKawin.setChecked(false);
                                rbPendaftaranAgenUserCerai.setChecked(false);
                                rbPendaftaranAgenUserWNA.setChecked(false);
                                rbPendaftaranAgenUserWNI.setChecked(false);
                                edtPendaftaranAgenUserTempatLahir.setText("");

                                AlertDialog.Builder builder = new AlertDialog.Builder(PendaftaranNasabahUserActivity.this);
                                LayoutInflater inflater = LayoutInflater.from(PendaftaranNasabahUserActivity.this);
//                                final View dialView = inflater.inflate(R.layout.dialog_pilih_aksi, null);
                                builder.setTitle("Asuransi Pintar");
                                builder.setMessage(error_msg + ", akan dihubungi oleh agen 1x24 jam.");
                                builder.setNegativeButton("Tutup", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        startActivity(new Intent(getApplicationContext(), HomeUserActivity.class));
                                    }
                                });
                                builder.show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                            Toast.makeText(PendaftaranNasabahUserActivity.this, Config.ERROR_DATA_IN_USED, Toast.LENGTH_SHORT).show();
//                            try {
//                                JSONObject jsonObject = new JSONObject(response.body().string());
//                                String error_msg = jsonObject.optString("error_msg");
//                                Toast.makeText(PendaftaranNasabahUserActivity.this, "" + error_msg, Toast.LENGTH_SHORT).show();
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(PendaftaranNasabahUserActivity.this, Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
//                AlertDialog alert = new AlertDialog.Builder(PendaftaranNasabahUserActivity.this).create();
//                alert.setIcon(R.mipmap.ic_launcher);
//                alert.setTitle("Notifikasi !!!");
//                alert.setMessage("Pendaftaran Asuransi jiwa anda telah terkirim dan akan segera kami proses. Untuk selanjutnya agen akan segera menghubungi anda ");
//                alert.setButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        edtPendaftaranAgenNamaLengkap.setText("");
//                        edtPendaftaranAgenNoTelp.setText("");
//                        edtPendaftaranAgenNoKtp.setText("");
//                        edtPendaftaranAgenAlamat.setText("");
//                        edtPendaftaranAgenEmail.setText("");
//                        edtPendaftaranAgenTTL.setText("");
//
//                    }
//                });
//
//
//                alert.show();
            }
        });

        containerTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });


    }

//    private boolean validasi() {
//        if (edtPendaftaranAgenNamaLengkap.getText().toString().isEmpty()) {
//            edtPendaftaranAgenNamaLengkap.requestFocus();
//            edtPendaftaranAgenNamaLengkap.setError("Masukkan nama");
//            return false;
//        }
//        if (edtPendaftaranAgenNoKtp.getText().toString().isEmpty()) {
//            edtPendaftaranAgenNoKtp.requestFocus();
//            edtPendaftaranAgenNoKtp.setError("Masukan No.KTP");
//            return false;
//        }
//
//        if (edtPendaftaranAgenNoTelp.getText().toString().isEmpty()) {
//            edtPendaftaranAgenNoTelp.requestFocus();
//            edtPendaftaranAgenNoTelp.setError("Masukan No.Telepon");
//            return false;
//        }
//
//        if (edtPendaftaranAgenEmail.getText().toString().isEmpty()) {
//            edtPendaftaranAgenEmail.requestFocus();
//            edtPendaftaranAgenEmail.setError("Masukan E-Mail");
//            return false;
//        }
//
//        if (edtPendaftaranAgenAlamat.getText().toString().isEmpty()) {
//            edtPendaftaranAgenAlamat.requestFocus();
//            edtPendaftaranAgenAlamat.setError("Masukan Alamat");
//            return false;
//        }
//
//        if (edtPendaftaranAgenTTL.getText().toString().isEmpty()) {
//            edtPendaftaranAgenTTL.requestFocus();
//            edtPendaftaranAgenTTL.setError("Masukan TTL");
//            return false;
//        }
//
//        return true;
//    }

    private void showDateDialog() {
        final Calendar c = Calendar.getInstance();
        mSelectedYear = c.get(Calendar.YEAR);
        mSelectedMonth = c.get(Calendar.MONTH);
        mSelectedDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(PendaftaranNasabahUserActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvTanggalLahir.setText(Config.formatDMY(year, (monthOfYear + 1), dayOfMonth));

                    }
                }, mSelectedYear, mSelectedMonth, mSelectedDay);
        datePickerDialog.show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbPendaftaranAgenUserLakiLaki:
                if (checked) {
                    idJenisKelamin = "1";
                }
                break;
            case R.id.rbPendaftaranAgenUserPerempuan:
                if (checked) {
                    idJenisKelamin = "0";
                }
                break;
        }
    }

    public void onRadioButtonClickedStatusKawin(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbPendaftaranAgenUserKawin:
                if (checked) {
                    idStatusKawin = "Kawin";
                }
                break;
            case R.id.rbPendaftaranAgenUserBelumKawin:
                if (checked) {
                    idStatusKawin = "Belum Kawin";
                }
                break;
            case R.id.rbPendaftaranAgenUserCerai:
                if (checked) {
                    idStatusKawin = "Cerai";
                }
                break;
        }
    }

    public void onRadioButtonClickedKewarganegaraan(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbPendaftaranAgenUserWNI:
                if (checked) {
                    idStatusKewarganegaraan = "WNI";
                }
                break;
            case R.id.rbPendaftaranAgenUserWNA:
                if (checked) {
                    idStatusKewarganegaraan = "WNA";
                }
                break;
        }
    }

    private void initView() {
        btnPendaftaranAgenSubmit = (Button) findViewById(R.id.btnPendaftaranAgenSubmit);
        containerTanggal = (LinearLayout) findViewById(R.id.containerTanggal);
        tvTanggalLahir = (TextView) findViewById(R.id.tvPendaftaranAgenUserTanggalLahir);
        edtPendaftaranAgenUserNomorVerivikasi = (EditText) findViewById(R.id.edtPendaftaranAgenUserNomorVerivikasi);
        edtPendaftaranAgenUserNamaLengkap = (EditText) findViewById(R.id.edtPendaftaranAgenUserNamaLengkap);
        rbPendaftaranAgenUserLakiLaki = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserLakiLaki);
        rbPendaftaranAgenUserPerempuan = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserPerempuan);
        tvPendaftaranAgenUserTanggalLahir = (TextView) findViewById(R.id.tvPendaftaranAgenUserTanggalLahir);
        edtPendaftaranAgenUserNoHp = (EditText) findViewById(R.id.edtPendaftaranAgenUserNoHp);
        edtPendaftaranAgenUserAlamat = (EditText) findViewById(R.id.edtPendaftaranAgenUserAlamat);
        edtPendaftaranAgenUserTempatLahir = (EditText) findViewById(R.id.edtPendaftaranAgenUserTempatLahir);
        tvPendaftaranAgenSyaratdanKetentuan = (TextView) findViewById(R.id.tvPendaftaranAgenSyaratdanKetentuan);
        spinnerAGAMA = (Spinner) findViewById(R.id.spinnerAGAMA);
        edtPendaftaranAgenUserPekerjaan = (EditText) findViewById(R.id.edtPendaftaranAgenUserPekerjaan);
        rbPendaftaranAgenUserKawin = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserKawin);
        rbPendaftaranAgenUserBelumKawin = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserBelumKawin);
        rbPendaftaranAgenUserCerai = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserCerai);
        rbPendaftaranAgenUserWNI = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserWNI);
        rbPendaftaranAgenUserWNA = (RadioButton) findViewById(R.id.rbPendaftaranAgenUserWNA);
    }
}
