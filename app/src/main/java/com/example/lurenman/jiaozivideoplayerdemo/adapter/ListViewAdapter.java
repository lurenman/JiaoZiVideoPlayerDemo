package com.example.lurenman.jiaozivideoplayerdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.lurenman.jiaozivideoplayerdemo.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author: baiyang.
 * Created on 2017/12/5.
 */

public class ListViewAdapter extends BaseAdapter {
    private static final String TAG = "ListViewAdapter";
    private Context mContext;
    private String[] videoUrls;
    private String[] videoTitles;
    private String[] videoThumbs;

    public ListViewAdapter(Context mContext, String[] videoUrls, String[] videoTitles, String[] videoThumbs) {
        this.mContext = mContext;
        this.videoUrls = videoUrls;
        this.videoTitles = videoTitles;
        this.videoThumbs = videoThumbs;
    }

    @Override
    public int getCount() {
        return null == videoUrls ? 0 : videoUrls.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_item, parent, false);
            viewHolder.jzVideoPlayer = (JZVideoPlayerStandard) convertView.findViewById(R.id.jz_video);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jzVideoPlayer.setUp(
                videoUrls[position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                videoTitles[position]);
        Glide.with(mContext).load(videoThumbs[position]).into(viewHolder.jzVideoPlayer.thumbImageView);
        viewHolder.jzVideoPlayer.positionInList = position;
        return convertView;
    }

    private class ViewHolder {
       private JZVideoPlayerStandard jzVideoPlayer;
    }
}
