package com.iavariav.root.asuransi.Rest;

import com.iavariav.root.asuransi.Model.CallCenterModel;
import com.iavariav.root.asuransi.Model.GetAgenModel;
import com.iavariav.root.asuransi.Model.LoginModel;
import com.iavariav.root.asuransi.Model.VideoModel;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by idn on 8/12/2017.
 */

public interface ApiService {
    @GET("artikel.php")
    Call<ResponseBody> getNews();
    @GET("getVideo.php")
    Call<ArrayList<VideoModel>> getVideo();
    @GET("callcenter.php")
    Call<ArrayList<CallCenterModel>> getCallCenter();
    @GET("get_all_agen.php")
    Call<ArrayList<GetAgenModel>> getAgenAll();
    @GET("getHistoryNasabah.php")
    Call<ResponseBody> getHistory();

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
    @POST("update_location_user.php")
    Call<ResponseBody> updateLoctionUser(@Field("id_user") String idUser,
                                         @Field("lat") Double email,
                                      @Field("lng") Double password);
    @FormUrlEncoded
    @POST("update_fcm_token.php")
    Call<ResponseBody> updateTokenFcm(@Field("id_user") String idUser,
                                      @Field("new_token") String password);
    @FormUrlEncoded
    @POST("updateProfilUser.php")
    Call<ResponseBody> updateProfile(@Field("id_user") String idUser,
                                      @Field("new_name") String new_name,
                                      @Field("new_email") String new_email,
                                      @Field("new_no_ktp") String new_no_ktp,
                                      @Field("new_no_tlp") String new_no_tlp,
                                      @Field("new_img_avatar") String new_img_avatar);
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
                                               @Field("id_jns_asuransi") String idjnsasuransi,
                                               @Field("lat") Double lat,
                                               @Field("lng") Double lng);


    @Multipart
    @POST("upload.php")
    Call<Result> postIMmage(@Part MultipartBody.Part image);


}
