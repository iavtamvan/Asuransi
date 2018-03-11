package com.iavariav.root.asuransi.Activity.User.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iavariav.root.asuransi.Activity.LoginActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;
import com.iavariav.root.asuransi.Rest.Result;
import com.iavariav.root.asuransi.Rest.RetroClient;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {

    private Bitmap bitmapFotoProfile;
    private String imagePath, h, idUser;
    private CircleImageView cvEditProfil;
    private EditText edtEditProfilNama;
    private EditText edtTanggalLahir;
    private EditText edtEmail;
    private EditText edtTlp;
    private EditText edtNoKTp;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();

        if (ContextCompat.checkSelfPermission(EditProfilActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(EditProfilActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(EditProfilActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        Config.MY_PERMISSIONS_REQUEST_FINE_LOCATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        idUser = sp.getString(String.valueOf(Config.SHARED_ID_USER), "");
        Glide.with(getApplicationContext()).load(sp.getString(Config.SHARED_IMAGE, "")).error(R.drawable.aspin).into(cvEditProfil);


        cvEditProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooserGalerry();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                uploadImage();
                postData();

            }
        });
    }

    private void postData() {
        ApiService apiService  = Client.getInstanceRetrofit();
        apiService.updateProfile(
                String.valueOf(idUser),
//                "24",
                edtEditProfilNama.getText().toString().trim(),
                edtEmail.getText().toString().trim(),
                edtNoKTp.getText().toString().trim(),
                edtTlp.getText().toString().trim(),
                h

        ).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject object  = new JSONObject(response.body().string());
                        String messeage = object.optString("message");
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditProfilActivity.this, "" + messeage, Toast.LENGTH_SHORT).show();
                        Log.e("Response : ", messeage);
//                        JSONObject object1 = object.optJSONObject("user_data");
//                        String nama = object1.optString("U_NAME");
//                        String email = object1.optString("U_EMAIL");
//                        String fullname = object1.optString("U_FULLNAME");
//                        String ktp = object1.optString("U_KTP");
//                        String avatar = object1.optString("U_AVATAR");
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
                Toast.makeText(EditProfilActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //gallery
    private void showFileChooserGalerry() {
        Intent qq = new Intent(Intent.ACTION_PICK);
        qq.setType("image/*");
        startActivityForResult(Intent.createChooser(qq, "Pilih Foto"), 100);
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Pilih Foto"), Config.PICK_FILE_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode ==100 && resultCode == Activity.RESULT_OK){
            if (data == null){
                Toast.makeText(this, "Gambar Tidak Ada", Toast.LENGTH_SHORT).show();
                return;

            }
//            else {
//                Toast.makeText(this, "Gambar Ada", Toast.LENGTH_SHORT).show();
//            }
            Uri selectImageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor c =getContentResolver().query(selectImageUri, filePathColumn, null, null, null);
            if (c !=null){
                c.moveToFirst();

                int columnIndex = c.getColumnIndex(filePathColumn[0]);
                imagePath = c.getString(columnIndex);

//                Glide.with(this).load(new File(imagePath)).into(cvEditProfil);
                Picasso.with(this).load(new File(imagePath)).into(cvEditProfil);
                h = new File(imagePath).getName();

                //Creating a shared preference
                SharedPreferences sharedPreferences = EditProfilActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                //Creating editor to store values to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Adding values to editor
                editor.putString(Config.SHARED_IMAGE, "http://suci.can.web.id/images/img/"+h);
                editor.commit();
                uploadImage();
//                Toast.makeText(this, "Mbuh", Toast.LENGTH_SHORT).show();
                c.close();

//                te.setVisibility(View.GONE);
//                imageVi.setVisibility(View.VISIBLE);
            }else {
//                te.setVisibility(View.VISIBLE);
//                imageVi.setVisibility(View.GONE);
                Toast.makeText(this, "Gambar Tidak Ada", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadImage() {

        final ProgressDialog p  ;
        p = new ProgressDialog(this);
        p.setMessage("Proses Upload Foto");
        p.show();

        ApiService s = RetroClient.getService();


        File f = new File(imagePath);

        Toast.makeText(EditProfilActivity.this, "Gambar " + h, Toast.LENGTH_SHORT).show();

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), f);

        final MultipartBody.Part part = MultipartBody.Part.createFormData("uploaded_file", f.getName(), requestFile);
        Call<Result> resultCAll = s.postIMmage(part);
        resultCAll.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                p.dismiss();
                if (response.isSuccessful()){
                    if (response.body().getResult().equals("success")){
                        Toast.makeText(EditProfilActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(EditProfilActivity.this, "Upload Gambar Gagal", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(EditProfilActivity.this, "Upload Gambar Gagal", Toast.LENGTH_SHORT).show();
                }

                imagePath = "";

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(EditProfilActivity.this, "Gagal Upload Fail", Toast.LENGTH_SHORT).show();
                p.dismiss();



            }
        });
    }

    private void initView() {
        cvEditProfil = (CircleImageView) findViewById(R.id.cvEditProfil);
        edtEditProfilNama = (EditText) findViewById(R.id.edtEditProfilNama);
        edtTanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtTlp = (EditText) findViewById(R.id.edt_tlp);
        edtNoKTp = (EditText) findViewById(R.id.edtNoKTp);
        btnSave = (Button) findViewById(R.id.btn_save);
    }
}
