package com.fantastic3.thebeautiful.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.fantastic3.thebeautiful.bean.Topic;

import java.util.List;


/**
 * Created by
 * Author: wswenyue
 * Email: wswenyue@163.com
 * GitHub: https://github.com/wswenyue
 * Date: 2015/11/13
 */
public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter<CommunityRecyclerViewHolder> {

    private List<Topic> topicList;

    public CommunityRecyclerViewAdapter(List<Topic> topicList) {
        this.topicList = topicList;
    }

    /**
     * 根据ViewType来创建、加载特定的布局，然后将创建好的布局
     * 交给ViewHolder，创建新的ViewHolder对象，并且返回
     * 因为RecyclerView，在ViewHolder为null的情况下，才会调用这个方法
     * 如果ViewHolder，以及存在，那么不会进入这个方法
     * holder的创建，不处理数据
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public CommunityRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommunityRecyclerViewHolder ret = null;

        return null;
    }

    /**
     * 显示指定位置的数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CommunityRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return topicList != null ? topicList.size() : 0;
    }
}

