package com.fantastic3.thebeautiful.activites;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.MediaController;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.fragments.PlayerInfoFragment;
import com.fantastic3.thebeautiful.widgets.video.MyFullVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by
 * Author: wswenyue
 * Email: wswenyue@163.com
 * GitHub: https://github.com/wswenyue
 * Date: 2015/11/10
 */

/**
 * 视频播放页面
 */
public class PlayerActivity extends BaseActivity implements MediaPlayer.OnPreparedListener {

    @Bind(R.id.aty_player_info_tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.aty_player_info_view_pager)
    ViewPager mViewPager;
    private MyFullVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ButterKnife.bind(this);

        initTab();

        String urlPath = "http://106.120.150.129/videos/other/20151012/57/b4/4ad6be3fa86bcbecd70f574097e18673.mp4";
        player(urlPath);
    }

    /**
     * 初始化Tablayout，ViewPager等
     */
    private void initTab() {
        final String[] mTabs = new String[]{"详情 评论", "推荐商品"};
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new PlayerInfoFragment();
            }

            @Override
            public int getCount() {
                return mTabs.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTabs[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void player(String urlPath) {


//        Cache cache = new FileCache(new File(getExternalCacheDir(), VIDEO_CACHE_NAME));
//        HttpUrlSource source = new HttpUrlSource(VIDEO_URL);
//        proxyCache = new HttpProxyCache(source, cache);
//        videoView.setVideoPath(proxyCache.getUrl());
//        videoView.start();

        mVideoView = (MyFullVideoView) findViewById(R.id.video_view);
        mVideoView.setVideoURI(Uri.parse(urlPath));
        mVideoView.setOnPreparedListener(this);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
    }


    /**
     * 准备好播放视频
     *
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        //TODO 隐藏加载中图标
    }
}
