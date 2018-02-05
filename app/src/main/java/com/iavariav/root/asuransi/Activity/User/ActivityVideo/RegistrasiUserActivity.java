package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiUserActivity extends AppCompatActivity {

    private ImageView ivAsuransiLogo;
    private EditText edtRegistrasiUsername;
    private EditText edtRegistrasiPassword;
    private EditText edtRegistrasiKonfrimasiPassword;
    private Button btnRegistrasiRegistrasi;
    private TextView tvRegistrasiAkun;
    private EditText edtRegistrasiNama;
    private EditText edtRegistrasiNikKtp;
    private EditText edtRegistrasiEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        initView();

        btnRegistrasiRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = Client.getInstanceRetrofit();
                apiService.register(edtRegistrasiNama.getText().toString().trim(),
                        edtRegistrasiUsername.getText().toString().trim(),
                        edtRegistrasiNikKtp.getText().toString().trim(),
                        edtRegistrasiEmail.getText().toString().trim(),
                        edtRegistrasiKonfrimasiPassword.getText().toString().trim(),
                        edtRegistrasiPassword.getText().toString().trim())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(RegistrasiUserActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.body().string());
                                        String error_msg = jsonObject.optString("error_msg");
                                        if (error_msg.contains(Config.ERROR_MSG_BERHASIL)){
                                            Toast.makeText(RegistrasiUserActivity.this, Config.ERROR_MSG_BERHASIL, Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                            finish();
                                        }
                                        else {
                                            Toast.makeText(RegistrasiUserActivity.this, Config.ERROR_MSG_ERROR + edtRegistrasiEmail.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(RegistrasiUserActivity.this, Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    private void initView() {
        ivAsuransiLogo = (ImageView) findViewById(R.id.ivAsuransiLogo);
        edtRegistrasiUsername = (EditText) findViewById(R.id.edtRegistrasiUsername);
        edtRegistrasiPassword = (EditText) findViewById(R.id.edtRegistrasiPassword);
        edtRegistrasiKonfrimasiPassword = (EditText) findViewById(R.id.edtRegistrasiKonfrimasiPassword);
        btnRegistrasiRegistrasi = (Button) findViewById(R.id.btnRegistrasiRegistrasi);
        tvRegistrasiAkun = (TextView) findViewById(R.id.tvRegistrasiAkun);
        edtRegistrasiNama = (EditText) findViewById(R.id.edtRegistrasiNama);
        edtRegistrasiNikKtp = (EditText) findViewById(R.id.edtRegistrasiNikKtp);
        edtRegistrasiEmail = (EditText) findViewById(R.id.edtRegistrasiEmail);
    }
}
