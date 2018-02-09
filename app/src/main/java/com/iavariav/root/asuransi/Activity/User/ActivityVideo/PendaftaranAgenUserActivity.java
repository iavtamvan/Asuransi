package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.app.DatePickerDialog;
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
import com.iavariav.root.asuransi.R;

import java.util.Calendar;
import java.util.Random;

public class PendaftaranAgenUserActivity extends AppCompatActivity {

    private Button btnPendaftaranAgenSubmit;
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;
    private LinearLayout containerTanggal;
    private TextView tvTanggalLahir;

    private Random r;
    private EditText edtPendaftaranAgenUserNomorVerivikasi;
    private EditText edtPendaftaranAgenUserNamaLengkap;
    private RadioButton rbPendaftaranAgenUserLakiLaki;
    private RadioButton rbPendaftaranAgenUserPerempuan;
    private TextView tvPendaftaranAgenUserTanggalLahir;
    private EditText edtPendaftaranAgenUserPendaftaranAgenNoHp;
    private EditText edtPendaftaranAgenUserAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_agen);
        initView();

        r = new Random();
        int random = r.nextInt(20 - 7+ 98) + 65 + 11192;
        edtPendaftaranAgenUserNomorVerivikasi.setText("ASPIN"+String.valueOf(random));
        edtPendaftaranAgenUserNomorVerivikasi.setEnabled(false);
        btnPendaftaranAgenSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
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
        edtPendaftaranAgenUserPendaftaranAgenNoHp = (EditText) findViewById(R.id.edtPendaftaranAgenUserPendaftaranAgenNoHp);
        edtPendaftaranAgenUserAlamat = (EditText) findViewById(R.id.edtPendaftaranAgenUserAlamat);
    }

}
