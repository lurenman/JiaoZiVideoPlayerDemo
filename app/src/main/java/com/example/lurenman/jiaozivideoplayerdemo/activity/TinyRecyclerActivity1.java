package com.example.lurenman.jiaozivideoplayerdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lurenman.jiaozivideoplayerdemo.R;
import com.example.lurenman.jiaozivideoplayerdemo.adapter.AdapterRecyclerViewVideo;

import cn.jzvd.JZVideoPlayer;

/**
 * @author: baiyang.
 * Created on 2017/12/6.
 */

public class TinyRecyclerActivity1 extends BaseActivity {

    private RecyclerView mRecyclerView;
    AdapterRecyclerViewVideo adapterVideoList;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_tint_recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initVariables() {


        adapterVideoList = new AdapterRecyclerViewVideo(this);
        mRecyclerView.setAdapter(adapterVideoList);
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                JZVideoPlayer.onChildViewAttachedToWindow(view, R.id.jz_video);
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                JZVideoPlayer.onChildViewDetachedFromWindow(view);
            }
        });
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
    }

}
