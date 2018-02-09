package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.LoginActivity;
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

public class PendaftaranAgenUserActivity extends AppCompatActivity {

    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;
    private int random;
    private String idJenis;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_agen);
        initView();

        r = new Random();
        random = r.nextInt(20 - 7+ 98 -5 -3/6) + 65 + 31192;
        edtPendaftaranAgenUserNomorVerivikasi.setText("ASPIN"+String.valueOf(random));
        edtPendaftaranAgenUserNomorVerivikasi.setFocusable(false);
        btnPendaftaranAgenSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(PendaftaranAgenUserActivity.this, "Loading", "Harap tunggu...", false, false);
                ApiService apiService  = Client.getInstanceRetrofit();
                apiService.postPendaftaranAgenUser(
                        "21",
                        edtPendaftaranAgenUserNomorVerivikasi.getText().toString().trim(),
                        edtPendaftaranAgenUserNamaLengkap.getText().toString().trim(),
                        idJenis,
                        tvTanggalLahir.getText().toString().trim(),
                        edtPendaftaranAgenUserNoHp.getText().toString().trim(),
                        edtPendaftaranAgenUserAlamat.getText().toString().trim(),
                        "1"

                ).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                loading.dismiss();
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                String error_msg = jsonObject.optString("error_msg");
                                String tampil_nomer_verif = jsonObject.optString("tampil_nomer_verif");
                                Toast.makeText(PendaftaranAgenUserActivity.this, "" + error_msg + tampil_nomer_verif, Toast.LENGTH_SHORT).show();
                                r = new Random();
                                random = r.nextInt(20 - 7+ 98 -5 -3/6) + 65 + 31192;
                                edtPendaftaranAgenUserNomorVerivikasi.setText("ASPIN"+String.valueOf(random));
                                edtPendaftaranAgenUserNamaLengkap.setText("");
                                tvTanggalLahir.setText("Tanggal Lahir");
                                edtPendaftaranAgenUserNoHp.setText("");
                                edtPendaftaranAgenUserAlamat.setText("");
                                rbPendaftaranAgenUserLakiLaki.setChecked(false);
                                rbPendaftaranAgenUserPerempuan.setChecked(false);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        else {
                            loading.dismiss();
                            Toast.makeText(PendaftaranAgenUserActivity.this, Config.ERROR_DATA_IN_USED, Toast.LENGTH_SHORT).show();
//                            try {
//                                JSONObject jsonObject = new JSONObject(response.body().string());
//                                String error_msg = jsonObject.optString("error_msg");
//                                Toast.makeText(PendaftaranAgenUserActivity.this, "" + error_msg, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(PendaftaranAgenUserActivity.this,  Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });



//                AlertDialog alert = new AlertDialog.Builder(PendaftaranAgenUserActivity.this).create();
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(PendaftaranAgenUserActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvTanggalLahir.setText(Config.formatDMY(year, (monthOfYear + 1), dayOfMonth));

                    }
                }, mSelectedYear, mSelectedMonth, mSelectedDay);
        datePickerDialog.show();
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
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.rbPendaftaranAgenUserLakiLaki :
                if (checked){
                    idJenis = "1";
                }
                break;
            case R.id.rbPendaftaranAgenUserPerempuan :
                if (checked){
                    idJenis = "0";
                }
                break;
        }
    }
}
