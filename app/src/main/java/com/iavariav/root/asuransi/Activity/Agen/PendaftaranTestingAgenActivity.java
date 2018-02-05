package com.iavariav.root.asuransi.Activity.Agen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iavariav.root.asuransi.R;

public class PendaftaranTestingAgenActivity extends AppCompatActivity {

    private EditText edtPendaftaranAgenNamaLengkap;
    private EditText edtPendaftaranAgenNoKtp;
    private EditText edtPendaftaranAgenNoTelp;
    private EditText edtPendaftaranAgenEmail;
    private EditText edtPendaftaranAgenAlamat;
    private EditText edtPendaftaranAgenTTL;
    private TextView tvPendaftaranAgenSyaratdanKetentuan;
    private Button btnPendaftaranAgenSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_agen);
        initView();
        btnPendaftaranAgenSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validasi()) {
                    return;
                }

                AlertDialog alert = new AlertDialog.Builder(PendaftaranTestingAgenActivity.this).create();
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setTitle("Notifikasi !!!");
                alert.setMessage("Pendaftaran Asuransi jiwa anda telah terkirim dan akan segera kami proses. Untuk selanjutnya agen akan segera menghubungi anda ");
                alert.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edtPendaftaranAgenNamaLengkap.setText("");
                        edtPendaftaranAgenNoTelp.setText("");
                        edtPendaftaranAgenNoKtp.setText("");
                        edtPendaftaranAgenAlamat.setText("");
                        edtPendaftaranAgenEmail.setText("");
                        edtPendaftaranAgenTTL.setText("");

                    }
                });




                alert.show();
            }
        });


    }

    private boolean validasi() {
        if (edtPendaftaranAgenNamaLengkap.getText().toString().isEmpty()) {
            edtPendaftaranAgenNamaLengkap.requestFocus();
            edtPendaftaranAgenNamaLengkap.setError("Masukkan nama");
            return false;
        }
        if (edtPendaftaranAgenNoKtp.getText().toString().isEmpty()) {
            edtPendaftaranAgenNoKtp.requestFocus();
            edtPendaftaranAgenNoKtp.setError("Masukan No.KTP");
            return false;
        }

        if (edtPendaftaranAgenNoTelp.getText().toString().isEmpty()) {
            edtPendaftaranAgenNoTelp.requestFocus();
            edtPendaftaranAgenNoTelp.setError("Masukan No.Telepon");
            return false;
        }

        if (edtPendaftaranAgenEmail.getText().toString().isEmpty()) {
            edtPendaftaranAgenEmail.requestFocus();
            edtPendaftaranAgenEmail.setError("Masukan E-Mail");
            return false;
        }

        if (edtPendaftaranAgenAlamat.getText().toString().isEmpty()) {
            edtPendaftaranAgenAlamat.requestFocus();
            edtPendaftaranAgenAlamat.setError("Masukan Alamat");
            return false;
        }

        if (edtPendaftaranAgenTTL.getText().toString().isEmpty()) {
            edtPendaftaranAgenTTL.requestFocus();
            edtPendaftaranAgenTTL.setError("Masukan TTL");
            return false;
        }

        return true;
    }

    private void initView() {
        edtPendaftaranAgenNamaLengkap = (EditText) findViewById(R.id.edtPendaftaranAgenNamaLengkap);
        edtPendaftaranAgenNoKtp = (EditText) findViewById(R.id.edtPendaftaranAgenNoKtp);
        edtPendaftaranAgenNoTelp = (EditText) findViewById(R.id.edtPendaftaranAgenNoTelp);
        edtPendaftaranAgenEmail = (EditText) findViewById(R.id.edtPendaftaranAgenEmail);
        edtPendaftaranAgenAlamat = (EditText) findViewById(R.id.edtPendaftaranAgenAlamat);
        edtPendaftaranAgenTTL = (EditText) findViewById(R.id.edtPendaftaranAgenTTL);
        tvPendaftaranAgenSyaratdanKetentuan = (TextView) findViewById(R.id.tvPendaftaranAgenSyaratdanKetentuan);
        btnPendaftaranAgenSubmit = (Button) findViewById(R.id.btnPendaftaranAgenSubmit);
    }
}
