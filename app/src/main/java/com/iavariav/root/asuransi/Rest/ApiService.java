package com.iavariav.root.asuransi.Rest;

import com.iavariav.root.asuransi.Model.LoginModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by idn on 8/12/2017.
 */

public interface ApiService {
    @GET("artikel.php")
    Call<ResponseBody> getNews();

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("name") String name,
                                @Field("username") String username,
                                @Field("ktp") String ktp,
                                @Field("email") String email,
                                @Field("password1") String password1,
                                @Field("password2") String password2);
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("email") String email,
                                      @Field("password") String password);
    @FormUrlEncoded
    @POST("daftarAsuransi.php")
    Call<ResponseBody> postPendaftaranAgenUser(@Field("id_user") String id,
                                      @Field("nomer_verif") String noVeriv,
                                               @Field("nama") String nama,
                                               @Field("tempat_lahir") String tempatlahir,
                                               @Field("tanggal_lahir") String tgllahir,
                                               @Field("jenis_kelamin") String jk,
                                               @Field("alamat") String alamat,
                                               @Field("agama") String agama,
                                               @Field("no_telp") String nohp,
                                               @Field("pekerjaan") String pekerjaan,
                                               @Field("kewarganegaraan") String kewarganegaraan,
                                               @Field("status_kawin") String statuskawin,
                                               @Field("id_jns_asuransi") String idjnsasuransi);


//    @Multipart
//    @POST("upload.php")
//    Call<Result> postIMmage(@Part MultipartBody.Part image);


}
