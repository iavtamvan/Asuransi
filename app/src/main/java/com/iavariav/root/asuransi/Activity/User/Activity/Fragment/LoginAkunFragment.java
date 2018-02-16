package com.iavariav.root.asuransi.Activity.User.Activity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iavariav.root.asuransi.Activity.User.Activity.RegistrasiUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginAkunFragment extends Fragment {
    private ImageView ivAsuransiLogo;
    private EditText edtLoginUsername;
    private EditText edtLoginPassword;
    private Button btnLoginLogin;
    private TextView tvLoginBelumPunyaAkun;

    public static LoginAkunFragment newInstance() {
        LoginAkunFragment fragment = new LoginAkunFragment();
        return fragment;
    }

    public LoginAkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        initView(view);
        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validasi()) {
                    return;
                }
                else {
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
                                    String fulllname = jsonObject.optString("fullname");
                                    Toast.makeText(getActivity(), fulllname, Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getActivity(), Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        tvLoginBelumPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegistrasiUserActivity.class));
            }
        });
        return view;
    }

    private boolean validasi() {

        if (edtLoginUsername.getText().toString().isEmpty()) {
            edtLoginUsername.requestFocus();
            edtLoginUsername.setError("Masukan Username");
            return false;
        }

        if (edtLoginPassword.getText().toString().isEmpty()) {
            edtLoginPassword.requestFocus();
            edtLoginPassword.setError("Masukan Username");
            return false;
        }

        return true;
    }

    private void initView(View view) {
        ivAsuransiLogo = (ImageView) view.findViewById(R.id.ivAsuransiLogo);
        edtLoginUsername = (EditText) view.findViewById(R.id.edtLoginUsername);
        edtLoginPassword = (EditText) view.findViewById(R.id.edtLoginPassword);
        btnLoginLogin = (Button) view.findViewById(R.id.btnLoginLogin);
        tvLoginBelumPunyaAkun = (TextView) view.findViewById(R.id.tvLoginBelumPunyaAkun);
    }
}
