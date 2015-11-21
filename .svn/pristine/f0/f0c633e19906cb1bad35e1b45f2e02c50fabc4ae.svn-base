package com.fantastic3.thebeautiful.adapters.commentAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.List;

/**
 * Created by wswenyue on 2015/9/22.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        this.mDatas = datas;
        this.layoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder = MyViewHolder.geHolder(mContext, convertView,
                parent, layoutId, position);
        convert(holder, getItem(position));
        return holder.getmConvertView();
    }

    public abstract void convert(MyViewHolder holder, T t);

    /**
     * 更新数据，该方法会清空所有的数据，然后添加
     *
     * @param data 新数据
     */
    public void updata(List<T> data) {
        updata(data, false);
    }

    /**
     * 更新数据
     *
     * @param data   数据
     * @param isMore 是否是加载更多
     */
    public void updata(List<T> data, boolean isMore) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("不能传入一个空对象数据. this data must be not Null and empty");
        }
        if (isMore) {
            mDatas.addAll(data);
        } else {
            if (!mDatas.isEmpty()) {
                mDatas.clear();
            }
            mDatas.addAll(data);
        }
        notifyDataSetChanged();
    }
}
