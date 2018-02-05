package com.iavariav.root.asuransi.Activity.User.ActivityVideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.iavariav.root.asuransi.Helper.Config;
import com.iavariav.root.asuransi.R;

public class NewsDetailUserActivity extends AppCompatActivity {


    private ImageView thumbnaildetail;
    private TextView titledetail;
    private TextView detailnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        titledetail.setText(bundle.getString(Config.BUNDLE_ART_CREATED_BY));
        detailnews.setText(bundle.getString(Config.BUNDLE_ART_ISI));
    }

    private void initView() {
        thumbnaildetail = (ImageView) findViewById(R.id.thumbnaildetail);
        titledetail = (TextView) findViewById(R.id.titledetail);
        detailnews = (TextView) findViewById(R.id.detailnews);
    }
}