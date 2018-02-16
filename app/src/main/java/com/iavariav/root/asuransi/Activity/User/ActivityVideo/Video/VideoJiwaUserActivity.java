package com.iavariav.root.asuransi.Activity.User.ActivityVideo.Video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.iavariav.root.asuransi.Activity.User.ActivityVideo.PendaftaranNasabahUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

public class VideoJiwaUserActivity extends AppCompatActivity {
    String idJiwa, idKendaraan, idKesehatan, idProperty;

    VideoView simpleVideoView;
    MediaController mediaControls;



    private Button btnDaftar;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiwa);
        initView();

        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();
        idJiwa = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI_JIWA);
        idKendaraan = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI_KENDARAAN);
        idKesehatan = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI_KESEHATAN);
        idProperty = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI_PROPERTY);
        Toast.makeText(this, "Bundle : > " + idJiwa + idKendaraan + idKesehatan + idProperty, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Bundle : > " + idJiwa + idKendaraan + idKesehatan + idProperty, Toast.LENGTH_SHORT).show();

        if (idJiwa.contains("1")){
            if (mediaControls == null) {
                // create an object of media controller class
                mediaControls = new MediaController(VideoJiwaUserActivity.this);
                mediaControls.setAnchorView(simpleVideoView);
            }
            // set the media controller for video view
            simpleVideoView.setMediaController(mediaControls);
            // set the uri for the video view
            simpleVideoView.setVideoURI(Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4"));
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

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_JIWA, "1");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(intent);
                    startActivity(intent);
                }
            });
        }
        if (idKendaraan.contains("2")){
            if (mediaControls == null) {
                // create an object of media controller class
                mediaControls = new MediaController(VideoJiwaUserActivity.this);
                mediaControls.setAnchorView(simpleVideoView);
            }
            // set the media controller for video view
            simpleVideoView.setMediaController(mediaControls);
            // set the uri for the video view
            simpleVideoView.setVideoURI(Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4"));
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

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_KENDARAAN, "2");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(intent);
                    startActivity(intent);
                }
            });
        }
        if (idKesehatan.contains("3")){
            if (mediaControls == null) {
                // create an object of media controller class
                mediaControls = new MediaController(VideoJiwaUserActivity.this);
                mediaControls.setAnchorView(simpleVideoView);
            }
            // set the media controller for video view
            simpleVideoView.setMediaController(mediaControls);
            // set the uri for the video view
            simpleVideoView.setVideoURI(Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4"));
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

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_KESEHATAN, "3");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(intent);
                    startActivity(intent);
                }
            });
        }
        if (idProperty.contains("4")){
            if (mediaControls == null) {
                // create an object of media controller class
                mediaControls = new MediaController(VideoJiwaUserActivity.this);
                mediaControls.setAnchorView(simpleVideoView);
            }
            // set the media controller for video view
            simpleVideoView.setMediaController(mediaControls);
            // set the uri for the video view
            simpleVideoView.setVideoURI(Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4"));
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

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI_PROPERTY, "4");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(intent);
                    startActivity(intent);
                }
            });
        }



















        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VideoJiwaUserActivity.this, PendaftaranNasabahUserActivity.class));
//                if(pref.getSudahLogin()){
//                    Toast.makeText(VideoJiwaUserActivity.this, "Asuransi", Toast.LENGTH_SHORT).show();
//                }else{
//                    tvStatus.setVisibility(View.VISIBLE);
//                    btnDaftar.setEnabled(false);
//                }
            }
        });
    }

    private void initView() {
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        tvStatus = (TextView) findViewById(R.id.tv_status);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

    }
}
