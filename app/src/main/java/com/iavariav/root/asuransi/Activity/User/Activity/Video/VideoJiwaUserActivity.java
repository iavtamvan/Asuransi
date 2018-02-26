package com.iavariav.root.asuransi.Activity.User.Activity.Video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.iavariav.root.asuransi.Activity.User.Activity.PendaftaranNasabahUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.Model.VideoModel;
import com.iavariav.root.asuransi.R;
import com.iavariav.root.asuransi.Rest.ApiService;
import com.iavariav.root.asuransi.Rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoJiwaUserActivity extends AppCompatActivity {
    String dataBundle;

    VideoView simpleVideoView;
    MediaController mediaControls;

    ArrayList<VideoModel> videoModels;


    private Button btnDaftar;
    private TextView tvStatus;
    private TextView tvVideoAsuransiNama;
    private TextView tvVideoAsuransiSize;
    private TextView tvVideoAsuransiLink;
    private TextView tvVideoAsuransiCreated;
    private TextView tvVideoAsuransiUpdated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiwa);
        initView();

        videoModels = new ArrayList<>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        dataBundle = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI);

        if (dataBundle.contains(dataBundle)) {
            if (mediaControls == null) {
                // create an object of media controller class
                mediaControls = new MediaController(VideoJiwaUserActivity.this);
                mediaControls.setAnchorView(simpleVideoView);
            }

            getVideoDataOnline();

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI, dataBundle);
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }

    private void getVideoDataOnline() {
        ApiService apiService  = Client.getInstanceRetrofit();
        Call<ArrayList<VideoModel>> call = apiService.getVideo();
        call.enqueue(new Callback<ArrayList<VideoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<VideoModel>> call, Response<ArrayList<VideoModel>> response) {
                videoModels = response.body();
                for (VideoModel s : videoModels) {
                    if (s.getVDJNASURANSI() !=null && s.getVDJNASURANSI().contains(dataBundle)){
                        String videoNama = s.getVDNAME();
                        String videoSize = s.getVDSIZE();
                        String videoLink = s.getVDLINK();
                        String videoCreated = s.getVDCREATEDAT();
                        String videoUpdate = s.getVDUPDATEDAT();

                        // set the media controller for video view
                        simpleVideoView.setMediaController(mediaControls);
                        // set the uri for the video view
                        simpleVideoView.setVideoURI(Uri.parse(videoLink));
                        // start a video
                        simpleVideoView.start();


                        // implement on completion listener on video view
                        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.stop();

                            }
                        });
                        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                Toast.makeText(getApplicationContext(), "Oops Video tidak ada...!!!", Toast.LENGTH_LONG).show();
                                return false;
                            }
                        });
                        tvVideoAsuransiNama.setText(videoNama);
                        tvVideoAsuransiSize.setText(videoSize);
                        tvVideoAsuransiLink.setText(videoLink);
                        tvVideoAsuransiCreated.setText(videoCreated);
                        tvVideoAsuransiUpdated.setText(videoUpdate);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<VideoModel>> call, Throwable t) {
                Toast.makeText(VideoJiwaUserActivity.this, Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        tvStatus = (TextView) findViewById(R.id.tv_status);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

        tvVideoAsuransiNama = (TextView) findViewById(R.id.tvVideoAsuransiNama);
        tvVideoAsuransiSize = (TextView) findViewById(R.id.tvVideoAsuransiSize);
        tvVideoAsuransiLink = (TextView) findViewById(R.id.tvVideoAsuransiLink);
        tvVideoAsuransiCreated = (TextView) findViewById(R.id.tvVideoAsuransiCreated);
        tvVideoAsuransiUpdated = (TextView) findViewById(R.id.tvVideoAsuransiUpdated);
    }
}
