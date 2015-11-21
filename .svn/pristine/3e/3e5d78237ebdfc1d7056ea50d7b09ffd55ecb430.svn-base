package com.fantastic3.thebeautiful.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.activites.SearchActivity;
import com.fantastic3.thebeautiful.adapter.LiveAdapter;
import com.fantastic3.thebeautiful.bean.BaseLive;
import com.fantastic3.thebeautiful.bean.LiveCarousel;
import com.fantastic3.thebeautiful.config.LiveNetAddress;
import com.fantastic3.thebeautiful.httpRequest.HttpUtils;
import com.fantastic3.thebeautiful.utils.TimeUtils;
import com.fantastic3.thebeautiful.widgets.CarouselView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;


/**
 * 这是直播的Fragment
 */
public class LiveFragment extends BaseFragment {
    static LiveFragment liveFragment;
    private ImageView personalView;
    private ListView liveList;
    private ImageView liveSearch;
    public static String picIp;
    private boolean flag = false;
    private List<BaseLive> list;

    LiveAdapter adapter;
    public LiveFragment() {
    }

    public static LiveFragment getInstance() {
        if (liveFragment == null) {
            liveFragment = new LiveFragment();
        }
        return liveFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        personalView = (ImageView) view.findViewById(R.id.personalView);

        CarouselView<LiveCarousel> head=new CarouselView<LiveCarousel>(getActivity(), LiveNetAddress.LIVE_CAROUSEL_URL, "pic", new CarouselView.ParseJsonCallback<LiveCarousel>() {
          //将网络返回的json数据解析成对象 并返回解析结果
            @Override
            public List<LiveCarousel> parseJson(JSONObject jsonObject) {
                if(jsonObject!=null){
                    try {
                        String  message=jsonObject.getString("message");
                        JSONObject json=jsonObject.getJSONObject("data");
                        JSONArray jsonArray=json.getJSONArray("banners");
                        TypeToken<List<LiveCarousel>> typeToken=new TypeToken<List<LiveCarousel>>(){};
                        List<LiveCarousel> liveCarousels=new Gson().fromJson(jsonArray.toString(),typeToken.getType());
                        return liveCarousels;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                return null;
            }
        });
        head.setBaseUrl("http://res.app.dameiren.com/");
        head.setOnPagerItemClickListener(new CarouselView.OnPagerItemClickEvent() {
            @Override
            public void OnPagerItemClick(List list, int position) {
               //TODO 当点击滚动图片的时候触发该事件 list 是广告列表 ，postion 是点击的第几张图片

            }
        });
        liveList = (ListView) view.findViewById(R.id.liveList);
        liveList.addHeaderView(head);
        liveSearch = (ImageView) view.findViewById(R.id.live_search_view);
        list = new ArrayList<>();
        initClickListener();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter=new LiveAdapter(getActivity(),list);
        liveList.setAdapter(adapter);
        loadData();


    }

    /**
     * 为控件注册事件
     */
    private void initClickListener() {
        //点击个人按钮时候 弹出左侧侧边栏
        personalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点击 list里面的item 事件
        liveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
        //点击搜索框时候的事件
        liveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void loadData() {
        RequestParams requestParams = new RequestParams(LiveNetAddress.LIVE_LIST);
        requestParams.addHeader("Content-Type", "application/x-www-form-urlencoded");
        requestParams.addHeader("Host", "app.dameiren.com");
        requestParams.addHeader("Connection", "Keep-Alive");
        requestParams.addBodyParameter("uid", " ");
        requestParams.addBodyParameter("versionId", "100023");
        requestParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        requestParams.addBodyParameter("pageNum", "1");
        requestParams.addBodyParameter("operatorUid", " ");

        HttpUtils.Post(requestParams, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject jsonObject) {

                try {
                    String message = jsonObject.getString("message");
                    if ("成功".equals(message)) {

                        JSONObject json = jsonObject.getJSONObject("data");
                        picIp = json.getString("picIp");
                        JSONObject obj = json.getJSONObject("videos");
                        JSONArray todays = obj.optJSONArray("today");
                        TypeToken<List<BaseLive>> token = new TypeToken<List<BaseLive>>() {
                        };
                        if (todays != null) {
                            BaseLive baseLive = new BaseLive();
                            baseLive.setLivetype(1);
                            baseLive.setContent(TimeUtils.getNowDate());
                            list.add(baseLive);
                            List<BaseLive> baseLives = new Gson().fromJson(todays.toString(), token.getType());
                            list.addAll(baseLives);
                        }
                        JSONArray tomorrows = obj.optJSONArray("tomorrow");
                        if (tomorrows != null) {
                            if (!flag) {//判断是否是第一次加载 不是 那就添加昨天的时间
                                BaseLive baseLive = new BaseLive();
                                baseLive.setLivetype(1);
                                baseLive.setContent(TimeUtils.getTomorrowDate());
                                list.add(baseLive);
                            }
                            List<BaseLive> baseLives = new Gson().fromJson(tomorrows.toString(), token.getType());
                            list.addAll(baseLives);
                        }
                        adapter.notifyDataSetChanged();
                        flag = true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
