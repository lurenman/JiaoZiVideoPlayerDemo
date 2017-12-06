package com.example.lurenman.jiaozivideoplayerdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lurenman.jiaozivideoplayerdemo.activity.FirstActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.ListViewActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.OrientationActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.RecyclerActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.RotationActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.TinyListViewActivity;
import com.example.lurenman.jiaozivideoplayerdemo.activity.TinyRecyclerActivity;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    private Button bt_first;
    private Context mContext;
    private Button bt_orientation;
    private Button bt_Rotation;
    private Button bt_ListView;
    private Button bt_RecyleView;
    private Button bt_TinyListView;
    private Button bt_TinyRecyleView;
    private Button bt_Fullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        initViews();
        initEvents();
    }

    private void initViews() {
        bt_first = (Button) findViewById(R.id.bt_first);
        bt_orientation = (Button) findViewById(R.id.bt_orientation);
        bt_Rotation = (Button) findViewById(R.id.bt_Rotation);
        bt_ListView = (Button) findViewById(R.id.bt_ListView);
        bt_RecyleView = (Button) findViewById(R.id.bt_RecyleView);
        bt_TinyListView = (Button) findViewById(R.id.bt_TinyListView);
        bt_TinyRecyleView = (Button) findViewById(R.id.bt_TinyRecyleView);
        bt_Fullscreen = (Button) findViewById(R.id.bt_Fullscreen);
    }

    private void initEvents() {
        bt_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FirstActivity.class);
                startActivity(intent);
            }
        });
        bt_orientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrientationActivity.class);
                startActivity(intent);
            }
        });
        bt_Rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RotationActivity.class);
                startActivity(intent);
            }
        });
        bt_ListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ListViewActivity.class);
                startActivity(intent);
            }
        });
        bt_RecyleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        bt_TinyListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TinyListViewActivity.class);
                startActivity(intent);
            }
        });
        bt_TinyRecyleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TinyRecyclerActivity.class);
                startActivity(intent);
//                Intent intent = new Intent(MainActivity.this, TinyRecyclerActivity1.class);
//                startActivity(intent);
            }
        });
        bt_Fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JZVideoPlayerStandard.startFullscreen(mContext, JZVideoPlayerStandard.class,"http://ic.snssdk.com/neihan/video/playback/1512442775.06/?video_id=d7e1736ddaed45cc9c12fa626dc0312f&quality=360p&line=1&is_gif=0&device_platform=android", "全屏展示");
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
