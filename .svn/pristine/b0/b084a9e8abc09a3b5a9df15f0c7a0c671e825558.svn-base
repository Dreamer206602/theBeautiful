package com.fantastic3.thebeautiful.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/11.
 */
public class CarouselPageAdapter extends PagerAdapter {
    private ImageView []imageViews;

    public CarouselPageAdapter(ImageView[] imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        if(imageViews!=null){
            return imageViews.length;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews[position]);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews[position]);

        return imageViews[position];
    }
}
