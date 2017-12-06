package com.example.lurenman.jiaozivideoplayerdemo.activity;

import android.content.pm.ActivityInfo;

import com.bumptech.glide.Glide;
import com.example.lurenman.jiaozivideoplayerdemo.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author: baiyang.
 * Created on 2017/12/5.
 */

public class OrientationActivity extends BaseActivity {
    private JZVideoPlayerStandard mJZVideoPlayer;
    private final String videoUrl="http://ic.snssdk.com/neihan/video/playback/1512442775.06/?video_id=d7e1736ddaed45cc9c12fa626dc0312f&quality=360p&line=1&is_gif=0&device_platform=android";
    private final String imgUrl="http://p1.pstatp.com/large/485c000eeb3c3fdc7fef.webp";
    @Override
    protected void initViews() {
        setContentView(R.layout.activity_orientation);
        mJZVideoPlayer = (JZVideoPlayerStandard) findViewById(R.id.jz_video);

    }

    @Override
    protected void initVariables() {
        mJZVideoPlayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "横屏使用");
        Glide.with(this).load(imgUrl).centerCrop().into(mJZVideoPlayer.thumbImageView);
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;//充满全屏时候设置
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;//正常的时候设置横屏
    }

    @Override
    protected void loadData() {

    }
    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();

        //回归状态
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }
}
