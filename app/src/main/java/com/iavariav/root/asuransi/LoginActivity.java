package com.iavariav.root.asuransi;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iavariav.root.asuransi.Activity.Agen.HomeAgenActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.HomeUserActivity;
import com.iavariav.root.asuransi.Activity.User.ActivityVideo.RegistrasiUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ImageView ivAsuransiLogo;
    private EditText edtLoginUsername;
    private EditText edtLoginPassword;
    private Button btnLoginLogin;
    private TextView tvLoginBelumPunyaAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        if (ContextCompat.checkSelfPermission(LoginActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(LoginActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(LoginActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        Config.MY_PERMISSIONS_REQUEST_FINE_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(LoginActivity.this, "Loading", "Harap tunggu...", false, false);

                ApiService apiService = Client.getInstanceRetrofit();
                apiService.login(
                        edtLoginUsername.getText().toString().trim(),
                        edtLoginPassword.getText().toString().trim()
                ).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonObject  = new JSONObject(response.body().string());
                                String nama = jsonObject.optString("nama");
                                String rule = jsonObject.optString("rule_login");
                                String statususer = jsonObject.optString("status_user");
                                String email = jsonObject.optString("email");
                                String fulllname = jsonObject.optString("fullname");
                                String ktp = jsonObject.optString("ktp");
                                String error_msg = jsonObject.optString("error_msg");

                                if (rule.equals("RL_AGN")){
                                    startActivity(new Intent(LoginActivity.this, HomeUserActivity.class));
                                    //Creating a shared preference
                                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                    //Creating editor to store values to shared preferences
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    //Adding values to editor
                                    editor.putString(Config.SHARED_NAMA            , nama);
                                    editor.putString(Config.SHARED_RULE_LOGIN            , rule);
                                    editor.putString(Config.SHARED_STATUS_USER          , statususer);
                                    editor.putString(Config.SHARED_EMAIL         , email);
                                    editor.putString(Config.SHARED_FULLNAME          , fulllname);
                                    editor.putString(Config.SHARED_KTP          , ktp);
                                    //Saving values to editor
                                    editor.commit();
                                    loading.dismiss();
                                    startActivity(new Intent(getApplicationContext(), HomeAgenActivity.class));
                                } else if (rule.equals("RL_USER")){
                                    startActivity(new Intent(LoginActivity.this, HomeAgenActivity.class));
                                    //Creating a shared preference
                                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                    //Creating editor to store values to shared preferences
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    //Adding values to editor
                                    editor.putString(Config.SHARED_NAMA            , nama);
                                    editor.putString(Config.SHARED_RULE_LOGIN            , rule);
                                    editor.putString(Config.SHARED_STATUS_USER          , statususer);
                                    editor.putString(Config.SHARED_EMAIL         , email);
                                    editor.putString(Config.SHARED_FULLNAME          , fulllname);
                                    editor.putString(Config.SHARED_KTP          , ktp);
                                    //Saving values to editor
                                    editor.commit();
                                    loading.dismiss();
                                    startActivity(new Intent(getApplicationContext(), HomeUserActivity.class));
                                }
                                else {
                                    loading.dismiss();
                                    Toast.makeText(LoginActivity.this, Config.ERROR_LOGIN, Toast.LENGTH_SHORT).show();
                                }


                                Toast.makeText(LoginActivity.this, fulllname, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(LoginActivity.this, Config.ERROR_LOGIN, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        tvLoginBelumPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegistrasiUserActivity.class));
            }
        });
    }

    private void initView() {
        ivAsuransiLogo = (ImageView) findViewById(R.id.ivAsuransiLogo);
        edtLoginUsername = (EditText) findViewById(R.id.edtLoginUsername);
        edtLoginPassword = (EditText) findViewById(R.id.edtLoginPassword);
        btnLoginLogin = (Button) findViewById(R.id.btnLoginLogin);
        tvLoginBelumPunyaAkun = (TextView) findViewById(R.id.tvLoginBelumPunyaAkun);
    }
}
