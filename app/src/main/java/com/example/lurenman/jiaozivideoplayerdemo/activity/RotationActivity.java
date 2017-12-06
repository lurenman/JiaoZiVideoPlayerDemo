package com.example.lurenman.jiaozivideoplayerdemo.activity;

import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.lurenman.jiaozivideoplayerdemo.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author: baiyang.
 * Created on 2017/12/5.
 */

public class RotationActivity extends BaseActivity implements View.OnClickListener {
    private JZVideoPlayerStandard mJZVideoPlayer;
    private Button mBtnRotation, mBtnFillParent, mBtnFillCrop, mBtnOriginal;
    private final String videoUrl = "http://ic.snssdk.com/neihan/video/playback/1512442775.06/?video_id=d7e1736ddaed45cc9c12fa626dc0312f&quality=360p&line=1&is_gif=0&device_platform=android";
    private final String imgUrl = "http://p1.pstatp.com/large/485c000eeb3c3fdc7fef.webp";

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_rotation);
        mJZVideoPlayer = (JZVideoPlayerStandard) findViewById(R.id.jz_video);
    }

    @Override
    protected void initVariables() {
        mJZVideoPlayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "旋转使用");
        Glide.with(this).load(imgUrl).centerCrop().into(mJZVideoPlayer.thumbImageView);
       // mJZVideoPlayer.videoRotation = 180;这个是设置屏幕初始的旋转角度
        mBtnRotation = findViewById(R.id.rotation_to_90);
        mBtnFillParent = findViewById(R.id.video_image_display_fill_parent);
        mBtnFillCrop = findViewById(R.id.video_image_display_fill_crop);
        mBtnOriginal = findViewById(R.id.video_image_diaplay_original);
        mBtnRotation.setOnClickListener(this);
        mBtnFillParent.setOnClickListener(this);
        mBtnFillCrop.setOnClickListener(this);
        mBtnOriginal.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rotation_to_90:
                JZVideoPlayer.setTextureViewRotation(90);

                break;
            case R.id.video_image_display_fill_parent:
                JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);

                break;
            case R.id.video_image_display_fill_crop:
                JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP);

                break;
            case R.id.video_image_diaplay_original:
                JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
        JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER);//恢复默认值
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
