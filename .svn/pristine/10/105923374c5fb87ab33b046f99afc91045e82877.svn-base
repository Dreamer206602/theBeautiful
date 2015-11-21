package com.fantastic3.thebeautiful.widgets.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by
 * Author: wswenyue
 * Email: wswenyue@163.com
 * GitHub: https://github.com/wswenyue
 * Date: 2015/11/11
 */
public class MyFullVideoView extends VideoView {
    public MyFullVideoView(Context context) {
        super(context);
    }

    public MyFullVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFullVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
