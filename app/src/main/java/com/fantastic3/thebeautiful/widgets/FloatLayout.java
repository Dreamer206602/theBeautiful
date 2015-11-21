package com.fantastic3.thebeautiful.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/12.
 */
public class FloatLayout extends ViewGroup {

    private List<List<View>> mAllChildViews=new ArrayList<>();
    private List<Integer> mLineHeight=new ArrayList<>();
    public FloatLayout(Context context) {
        super(context);
    }

    public FloatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //测量自己的宽高和子控件的宽和高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int width = 0;
        int height = 0;
        int lineWidth = 0;
        int lineHeight = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if(lineWidth+childWidth>sizeWidth){//换行的情况
                width=Math.max(width,lineHeight);
                lineWidth=childWidth;
                height+=lineHeight;
                lineHeight=childHeight;
            }else{//不换行
                lineHeight+=childHeight;
                lineHeight=Math.max(lineHeight,childHeight);
            }
           if(i==childCount-1){
               width=Math.max(width,lineWidth);
               height+=lineHeight;
           }
        }
        setMeasuredDimension(modeWidth==MeasureSpec.EXACTLY?sizeWidth:width,modeHeight==MeasureSpec.EXACTLY?sizeHeight:height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllChildViews.clear();
        mLineHeight.clear();
        int width=getWidth();
       int lineWidth=0;
        int lineHeight=0;
        List<View> lineViews=new ArrayList<>();
        int childCount =getChildCount();
        for(int i =0;i < childCount;i++){
            View child = getChildAt(i);
            MarginLayoutParams lp =(MarginLayoutParams)child.getLayoutParams();
            int childWidth =child.getMeasuredWidth();
            int childHeight =child.getMeasuredHeight();
            //如果需要换行  
            if(childWidth+lineWidth+lp.leftMargin+lp.rightMargin>width){
                //记录LineHeight  
              mLineHeight.add(lineHeight);
               //记录当前行的Views  
                mAllChildViews.add(lineViews);
                //重置行的宽高  
                lineWidth=0;
                lineHeight =childHeight +lp.topMargin +lp.bottomMargin;
                //重置view的集合  
                lineViews = new ArrayList();
                }
            lineWidth +=childWidth+lp.leftMargin+lp.rightMargin;
            lineHeight = Math.max(lineHeight,childHeight+lp.topMargin+lp.bottomMargin);
            lineViews.add(child);
            }
        //处理最后一行  
        mLineHeight.add(lineHeight);
         mAllChildViews.add(lineViews);

        //设置子View的位置  
      int left =0;
        int top = 0;
        //获取行数  
        int lineCount = mAllChildViews.size();
        for(int i = 0; i<lineCount;i++){
            //当前行的views和高度  
            lineViews =mAllChildViews.get(i);
            lineHeight =mLineHeight.get(i);
            for(int j = 0;j<lineViews.size();j++){
                View child = lineViews.get(j);
                //判断是否显示  
                if(child.getVisibility() == View.GONE){
                    continue;
                    }
                MarginLayoutParams lp =(MarginLayoutParams)child.getLayoutParams();
                int cLeft =left + lp.leftMargin;
                int cTop =top+lp.topMargin;
                int cRight =cLeft +child.getMeasuredWidth();
                int cBottom =cTop +child.getMeasuredHeight();
                //进行子View进行布局  
                child.layout(cLeft,cTop,cRight,cBottom);
                left+=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
                }
            left=0;
            top+=lineHeight;
            }

    }
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return super.generateLayoutParams(p);
    }
}
