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
 * 发现的Fragment
 */
public class DiscoverFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    private String[] TAB_NAMES;
    private ViewPager mViewPager;
    private TabPageIndicator mIndicator;
    private static DiscoverFragment discoverFragment;

    public static DiscoverFragment newInstance(){
        if (discoverFragment == null) {
            discoverFragment=new DiscoverFragment();
        }
        return  discoverFragment;
    }

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAB_NAMES=getActivity().getResources().getStringArray(R.array.TABLE_NAMES);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_discover, container, false);

        mIndicator= (TabPageIndicator) ret.findViewById(R.id.discover_frg_indicator);
        mViewPager= (ViewPager) ret.findViewById(R.id.discover_frg_viewPager);

        return ret;
    }

    @Override
    public void onResume() {
        super.onResume();

        mViewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager()));

        mIndicator.setViewPager(mViewPager);

        mIndicator.setOnPageChangeListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class TabPagerAdapter extends FragmentPagerAdapter{

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment ret=null;
            ret=FragmentFactory.createFragment2(position);
            return ret;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_NAMES[position];
        }

        @Override
        public int getCount() {
            return TAB_NAMES.length;
        }
    }


}
