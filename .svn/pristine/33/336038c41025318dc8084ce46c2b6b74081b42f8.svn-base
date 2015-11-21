package com.fantastic3.thebeautiful.adapters.commentAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by wswenyue on 2015/9/22.
 */
public class MyViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context context;

    private MyViewHolder(Context context, ViewGroup parent, int layoutId, int postion) {
        this.mPosition = postion;
        this.mViews = new SparseArray<>();
        this.context = context;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }


    public static MyViewHolder geHolder(Context context, View convertView, ViewGroup parent,
                                        int layoutId, int position) {

        if (convertView == null) {
            return new MyViewHolder(context, parent, layoutId, position);
        } else {
            MyViewHolder holder = (MyViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public MyViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置imageView
     *
     * @param viewId
     * @param resId
     * @return
     */
    public MyViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 设置imageView
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public MyViewHolder setImageResource(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }


    public MyViewHolder setImageResource(int viewId, String urlPath) {
        //TODO 需要异步加载图片，这里添加方法
        ImageView view = getView(viewId);
//        Picasso.with(context).load(urlPath).error(R.drawable.logo).into(view);
        return this;
    }

}
