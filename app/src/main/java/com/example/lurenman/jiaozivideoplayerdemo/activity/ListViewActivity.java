package com.example.lurenman.jiaozivideoplayerdemo.activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.example.lurenman.jiaozivideoplayerdemo.R;
import com.example.lurenman.jiaozivideoplayerdemo.adapter.ListViewAdapter;
import com.example.lurenman.jiaozivideoplayerdemo.contants.VideoConstant;

import cn.jzvd.JZVideoPlayer;

/**
 * @author: baiyang.
 * Created on 2017/12/5.
 */

public class ListViewActivity extends BaseActivity {

    private ListView lv_list;
    private ListViewAdapter mListViewAdapter;
    private SensorManager sensorManager;
    private JZVideoPlayer.JZAutoFullscreenListener sensorEventListener;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_listview);
        lv_list = (ListView) findViewById(R.id.lv_list);

    }

    @Override
    protected void initVariables() {
       mListViewAdapter=new ListViewAdapter(this,
               VideoConstant.videoUrls[0],
               VideoConstant.videoTitles[0],
               VideoConstant.videoThumbs[0]);
        View headView = View.inflate(getApplicationContext(), R.layout.lv_header, null);
        //这个添加头尾部对这个有点影响
        lv_list.addHeaderView(headView);
        lv_list.setAdapter(mListViewAdapter);
//        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        sensorEventListener = new JZVideoPlayer.JZAutoFullscreenListener();
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        lv_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //如果不添加头部就这个
                //JZVideoPlayer.onScrollReleaseAllVideos(view, firstVisibleItem, visibleItemCount, totalItemCount);
                //添加头部firstVisibleItem-1看情况而定
                JZVideoPlayer.onScrollReleaseAllVideos(view, firstVisibleItem-1, visibleItemCount, totalItemCount);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
//        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
     //   sensorManager.unregisterListener(sensorEventListener);
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
    protected void loadData() {

    }

}
