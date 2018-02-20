package com.iavariav.root.asuransi.Activity.User.Activity.Video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.iavariav.root.asuransi.Activity.User.Activity.PendaftaranNasabahUserActivity;
import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

public class VideoJiwaUserActivity extends AppCompatActivity {
    String dataBundle;

    VideoView simpleVideoView;
    MediaController mediaControls;



    private ImageView btnDaftar;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiwa);
        initView();

        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();
        dataBundle = bundle.getString(Config.BUNDLE_ID_JENIS_ASURANSI);
        Toast.makeText(this, "bundle : " + dataBundle, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "bundle : " + dataBundle, Toast.LENGTH_SHORT).show();

        if (dataBundle.contains("1")){
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
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI, "1");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        if (dataBundle.contains("2")){
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
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI, "2");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        if (dataBundle.contains("3")){
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
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI, "3");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        if (dataBundle.contains("4")){
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
                    bundle.putString(Config.BUNDLE_ID_JENIS_ASURANSI, "4");
                    Intent intent = new Intent(getApplicationContext(), PendaftaranNasabahUserActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }

    private void initView() {
        btnDaftar = (ImageView) findViewById(R.id.btn_daftar);
        tvStatus = (TextView) findViewById(R.id.tv_status);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

    }
}
