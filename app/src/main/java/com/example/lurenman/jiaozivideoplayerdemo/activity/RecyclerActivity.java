package com.example.lurenman.jiaozivideoplayerdemo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lurenman.jiaozivideoplayerdemo.R;
import com.example.lurenman.jiaozivideoplayerdemo.adapter.RecyclerAdapter;
import com.example.lurenman.jiaozivideoplayerdemo.animation.CustomAnimation;
import com.example.lurenman.jiaozivideoplayerdemo.contants.Contants;
import com.example.lurenman.jiaozivideoplayerdemo.contants.VideoConstant;
import com.example.lurenman.jiaozivideoplayerdemo.entity.RecyclerEntity;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;

/**
 * @author: baiyang.
 * Created on 2017/12/6.
 */

public class RecyclerActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private List<RecyclerEntity> mDataLists = new ArrayList<>();

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_recycler);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initVariables() {
        for (int i = 0; i < VideoConstant.videoUrls[0].length; i++) {
            RecyclerEntity recyclerEntity = new RecyclerEntity();
            recyclerEntity.setVideoUrls(VideoConstant.videoUrls[0][i]);
            recyclerEntity.setVideoTitles(VideoConstant.videoTitles[0][i]);
            recyclerEntity.setVideoThumbs(VideoConstant.videoThumbs[0][i]);
            mDataLists.add(recyclerEntity);
        }
        mRecyclerAdapter = new RecyclerAdapter(mDataLists);

        View headView = View.inflate(getApplicationContext(), R.layout.rv_header, null);
        mRecyclerAdapter.addHeaderView(headView);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.openLoadAnimation();//打开动画
        mRecyclerAdapter.isFirstOnly(false);//这个设置是否紧第一次加载动画，这里我设置false
        mRecyclerAdapter.openLoadAnimation(new CustomAnimation());
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                JZVideoPlayer jzvd = view.findViewById(R.id.jz_video);
                if (jzvd != null && JZUtils.dataSourceObjectsContainsUri(jzvd.dataSourceObjects, JZMediaManager.getCurrentDataSource())) {
                    JZVideoPlayer.releaseAllVideos();
                }
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
