package com.iavariav.root.asuransi.Activity.User.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private LinearLayout div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();

        getdataHistory();

    }
    private void getdataHistory() {
        ApiService apiService = Client.getInstanceRetrofit();
        Call<ResponseBody> call = apiService.getHistory();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObject.optJSONArray("history");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.optJSONObject(i);
                            String ID_NASABAH = object.optString("ID_NASABAH");
                            String ID_USER = object.optString("ID_USER");
                            String NO_VERIF_NASABAH = object.optString("NO_VERIF_NASABAH");
                            String NSB_NAME = object.optString("NSB_NAME");
                            String NSB_JENIS_KELAMIN = object.optString("NSB_JENIS_KELAMIN");
                            String NSB_TMP_LAHIR = object.optString("NSB_TMP_LAHIR");
                            String NSB_TGL_LAHIR = object.optString("NSB_TGL_LAHIR");
                            String NSB_AGAMA = object.optString("NSB_AGAMA");
                            String NSB_STASUS_KAWIN = object.optString("NSB_STASUS_KAWIN");
                            String NSB_PEKERJAAN = object.optString("NSB_PEKERJAAN");
                            String NSB_KEWARGANEGARA = object.optString("NSB_KEWARGANEGARA");
                            String NSB_TELP = object.optString("NSB_TELP");
                            String NSB_ALAMAT = object.optString("NSB_ALAMAT");



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

            }
        });
    }

    private void initView() {
        div = (LinearLayout) findViewById(R.id.div);
    }
}
