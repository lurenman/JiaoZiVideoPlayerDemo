package com.example.lurenman.jiaozivideoplayerdemo.adapter;

import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lurenman.jiaozivideoplayerdemo.R;
import com.example.lurenman.jiaozivideoplayerdemo.contants.Contants;
import com.example.lurenman.jiaozivideoplayerdemo.entity.RecyclerEntity;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author: baiyang.
 * Created on 2017/12/6.
 */

public class RecyclerAdapter extends BaseQuickAdapter<RecyclerEntity, BaseViewHolder> {
    public RecyclerAdapter(@Nullable List<RecyclerEntity> data) {
         super(R.layout.rv_item,data);
    }
    public RecyclerAdapter(@Nullable List<RecyclerEntity> data,int state) {
        super(R.layout.rv_item_tiny,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, RecyclerEntity item) {
        JZVideoPlayerStandard jzVideoPlayer = (JZVideoPlayerStandard) helper.getView(R.id.jz_video);
        jzVideoPlayer.setUp(item.getVideoUrls(), JZVideoPlayer.SCREEN_WINDOW_LIST, item.getVideoTitles());
        Glide.with(mContext).load(item.getVideoThumbs()).into(jzVideoPlayer.thumbImageView);

    }
}
