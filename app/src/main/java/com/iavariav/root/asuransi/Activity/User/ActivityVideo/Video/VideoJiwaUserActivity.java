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

import com.iavariav.root.asuransi.Activity.User.ActivityVideo.PendaftaranAgenUserActivity;
import com.iavariav.root.asuransi.R;

public class VideoJiwaUserActivity extends AppCompatActivity {

    VideoView simpleVideoView;
    MediaController mediaControls;

    private Button btnDaftar;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiwa);

        initView();


        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

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
//                Toast.makeText(getApplicationContext(), "Thank You...!!!", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VideoJiwaUserActivity.this, PendaftaranAgenUserActivity.class));
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
    }
}
