package com.example.lurenman.jiaozivideoplayerdemo.activity;

import com.bumptech.glide.Glide;
import com.example.lurenman.jiaozivideoplayerdemo.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author: baiyang.
 * Created on 2017/12/5.
 */

public class FirstActivity extends BaseActivity {
    private JZVideoPlayerStandard mJZVideoPlayer;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_first);
        mJZVideoPlayer = (JZVideoPlayerStandard) findViewById(R.id.jz_video);
    }

    //http://v3-nh.ixigua.com/4a7ff39d5f9a70151b4fb7ad5b237b52/5a260b96/video/m/220e106673c47a8401b82717625b5776f5411527cd9000008fbd1654204/
//http://ic.snssdk.com/neihan/video/playback/1512442775.06/?video_id=d7e1736ddaed45cc9c12fa626dc0312f&quality=360p&line=1&is_gif=0&device_platform=android
    @Override
    protected void initVariables() {
        mJZVideoPlayer.setUp("http://ic.snssdk.com/neihan/video/playback/1512442775.06/?video_id=d7e1736ddaed45cc9c12fa626dc0312f&quality=360p&line=1&is_gif=0&device_platform=android", JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "初步使用");
        Glide.with(this).load("http://p1.pstatp.com/large/485c000eeb3c3fdc7fef.webp").centerCrop().into(mJZVideoPlayer.thumbImageView);
    }

    @Override
    protected void loadData() {

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

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
