package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viewpagerindicator.TabPageIndicator;

import com.fantastic3.thebeautiful.R;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 直播的Fragment
 */
public class VideoFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private static VideoFragment videoFragment;
    private String[] TAB_NAMES;
    private TabPageIndicator mIndicator;
    private ViewPager mPager;
    public VideoFragment() {
    }

    public static VideoFragment newInstance(){

        if(videoFragment==null){
            videoFragment=new VideoFragment();
        }
        return videoFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        TAB_NAMES=getActivity().getResources().getStringArray(R.array.TABLE_NAMES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_video, container, false);
        mIndicator= (TabPageIndicator) ret.findViewById(R.id.video_frg_indicator);
        mPager= (ViewPager) ret.findViewById(R.id.video_frg_viewPager);
        return ret;
    }


    @Override
    public void onResume() {
        super.onResume();
        initEvent();
    }

    /**
     * 处理事件
     */
    private void initEvent() {
        /**
         * ViewPager设置适配器
         */
       TabAdapter adapter=new TabAdapter(getChildFragmentManager());
        mPager.setAdapter(adapter);

        //TabIndicator和ViewPager进行绑定
        mIndicator.setViewPager(mPager);
        /**
         * TabPageIndicator设置监听
         */
        mIndicator.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

       // FragmentFactory.createFragment(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * ViewPager所需要的适配器
     */
    class TabAdapter extends FragmentPagerAdapter{

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return TAB_NAMES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_NAMES[position];
        }

        @Override
        public Fragment getItem(int position) {
           Fragment  ret=null;
            ret=  FragmentFactory.createFragment(position);

            return ret;
        }


    }



}
