package com.fantastic3.thebeautiful.activites;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapter.CommunityRecyclerViewAdapter;
import com.fantastic3.thebeautiful.bean.Topic;
import com.fantastic3.thebeautiful.utils.T;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 社区
 */
public class CommunityActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.aty_community_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeLayout;
    private boolean isRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        ButterKnife.bind(this);
        initPullToRefresh();
        initRecyclerView();
    }

    /**
     * 下拉刷新
     */
    private void initPullToRefresh() {
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeColors(android.R.color.white,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);


    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        mRecyclerView.setAdapter(new CommunityRecyclerViewAdapter(new ArrayList<Topic>()));
    }


    /**
     * 点击我 的事件处理
     *
     * @param view
     */
    public void btnBottomMe(View view) {
        T.showLongToast(this, "点击我，拉出侧滑菜单。。。");
    }

    /**
     * 发话题
     *
     * @param view
     */
    public void btnBottomWrite(View view) {
        T.showLongToast(this, "我要发话题，跳转到话题编辑界面");
    }

    /**
     * 顶部返回按钮事件
     *
     * @param view
     */
    public void btnTopBarBack(View view) {
        finish();
    }

    /**
     * 顶部搜索按钮
     *
     * @param view
     */
    public void btnTopBarSearch(View view) {
        T.showLongToast(this, "跳转到搜索。。。");
    }


    /**
     * 下拉回调
     */
    @Override
    public void onRefresh() {
        if (!isRefresh) {
            isRefresh = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    mSwipeLayout.setRefreshing(false);
                    //TODO 加载数据更新
                    isRefresh = false;
                }
            }, 3000);
        }
    }
}
