package com.iavariav.root.asuransi.Activity.User.Activity.Fragment;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.iavariav.root.asuransi.Activity.User.Activity.NewsDetailUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.Model.CallCenterModel;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BantuanNewsFragment extends Fragment {

    private TextView tvKontakNewsWeb;
    private TextView tvKontakNewsFacebook;
    private TextView tvKontakNewsIG;
    private LinearLayout nav1, div;
    private ImageView img;
    private TextView tvTitle;
    private TextView tvNews;
    private CardView cv2;
    private LinearLayout nav2;
    private ImageView img2;
    private TextView tvTitle2;
    private TextView tvNews2;

    private ArrayList<CallCenterModel> callCenterModels;
    private TextView tvKontakNewsGooglePlus;
    private ImageView btnWebsite;
    private ImageView btnInstagram;
    private ImageView btnFb;
    private ImageView btnGmail;

    private String email;


    public static BantuanNewsFragment newInstance() {
        BantuanNewsFragment fragment = new BantuanNewsFragment();
        return fragment;
    }

    public BantuanNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bantuan, container, false);
        callCenterModels = new ArrayList<>();
        initView(view);
        getdatanews();
        getKontak();

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailto = "mailto:" + email +
//                        "?cc=" + "alice@example.com" +
                        "&subject=" + Uri.encode("Feedback") +
                        "&body=" + Uri.encode("Coba");

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available

                }
            }
        });

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/iavariav")));
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + tvKontakNewsFacebook.getText().toString().trim())));
                } catch (Exception e) {
                   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/iavariav")));
                }
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/iav_ariav/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/iav_ariav/")));
                }
            }
        });

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://can.web.id/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return view;
    }

    private void getKontak() {
        ApiService apiService = Client.getInstanceRetrofit();
        Call<ArrayList<CallCenterModel>> call = apiService.getCallCenter();
        call.enqueue(new Callback<ArrayList<CallCenterModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CallCenterModel>> call, Response<ArrayList<CallCenterModel>> response) {
                callCenterModels = response.body();
                for (int i = 0; i < callCenterModels.size(); i++) {
                    tvKontakNewsWeb.setText("Asuransi.co.id");
                    tvKontakNewsIG.setText("@asuransi");
                    tvKontakNewsGooglePlus.setText(callCenterModels.get(i).getCCEMAIL());
                    email = callCenterModels.get(i).getCCEMAIL();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CallCenterModel>> call, Throwable t) {

            }
        });
    }

    private void getdatanews() {
        ApiService apiService = Client.getInstanceRetrofit();
        Call<ResponseBody> call = apiService.getNews();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
//                        String artikel = jsonObject.optString("Artikel");
//                        Toast.makeText(getActivity(), "Artikel Masuk " + artikel, Toast.LENGTH_SHORT).show();
                        JSONArray jsonArray = jsonObject.optJSONArray("Artikel");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.optJSONObject(i);
                            String id_artikel = object.optString(Config.ID_ARTIKEL);
                            final String art_isi = object.optString(Config.ART_ISI);
                            String art_gambar = object.optString(Config.ART_GAMBAR);
                            String art_created_by = object.optString(Config.ART_CREATED_BY);
                            String art_created_at = object.optString(Config.ART_CREATED_AT);
                            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View addView = layoutInflater.inflate(R.layout.row_news, null);
//                            final TextView judul = addView.findViewById(R.id.tvJudulNews);
//                            judul.setText();
                            final TextView tvpenerbit = addView.findViewById(R.id.tvPenerbitNews);
                            tvpenerbit.setText(art_created_by);

                            final TextView tvtanggal = addView.findViewById(R.id.tvTanggalNews);
                            tvtanggal.setText(art_created_at);

                            final TextView tvisi = addView.findViewById(R.id.tvIsiNews);
                            tvisi.setText(art_isi + " ....");

                            final ImageView ivBantuanNews = addView.findViewById(R.id.ivBantuanNews);

                            Glide.with(getActivity()).load(art_gambar)
                                    .crossFade()
                                    .error(R.drawable.newspaper)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(ivBantuanNews);

                            final CardView cvKlik = addView.findViewById(R.id.cv);
                            cvKlik.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Bundle bundle1 = new Bundle();
                                    bundle1.putString(Config.BUNDLE_ART_CREATED_BY, tvpenerbit.getText().toString().trim());
                                    bundle1.putString(Config.BUNDLE_ART_CREATED_AT, tvtanggal.getText().toString().trim());
                                    bundle1.putString(Config.BUNDLE_ART_ISI, art_isi);
                                    Intent intent1 = new Intent(getActivity(), NewsDetailUserActivity.class);
                                    intent1.putExtras(bundle1);
                                    startActivity(intent1);
                                }
                            });


                            div.addView(addView);

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
                Toast.makeText(getActivity(), Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initView(View view) {
        tvKontakNewsWeb = (TextView) view.findViewById(R.id.tvKontakNewsWeb);
        tvKontakNewsFacebook = (TextView) view.findViewById(R.id.tvKontakNewsFacebook);
        tvKontakNewsIG = (TextView) view.findViewById(R.id.tvKontakNewsIG);
        div = (LinearLayout) view.findViewById(R.id.div);
        tvKontakNewsGooglePlus = (TextView) view.findViewById(R.id.tvKontakNewsGooglePlus);
        btnWebsite = (ImageView) view.findViewById(R.id.btnWebsite);
        btnInstagram = (ImageView) view.findViewById(R.id.btnInstagram);
        btnFb = (ImageView) view.findViewById(R.id.btnFb);
        btnGmail = (ImageView) view.findViewById(R.id.btnGmail);
    }
}
