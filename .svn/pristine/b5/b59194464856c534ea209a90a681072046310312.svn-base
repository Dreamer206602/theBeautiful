package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.VideoHot;
import com.fantastic3.thebeautiful.bean.hotvideos;
import com.fantastic3.thebeautiful.config.VideoNetAddress;
import com.fantastic3.thebeautiful.httpRequest.HttpUtils;
import com.fantastic3.thebeautiful.utils.TimeUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 热门的fragment
 */
public class VideoHotFragment extends BaseFragment {

    private Gson gson;
    private ListView mListView;
    public VideoHotFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_hot, container, false);
        mListView= (ListView) ret.findViewById(R.id.hot_frg_listView);
        return ret;
    }


    @Override
    public void onResume() {
        super.onResume();
        getServerJson();
    }

    /**
     * 获得服务器的json的数据
     */
    private void getServerJson() {
        RequestParams postParams=new RequestParams(VideoNetAddress.VIDEO_THE_HOT_URL);
        postParams.addHeader("Content-Length","113");
        postParams.addHeader("Content-Type","application/x-www-form-urlencoded");
        postParams.addHeader("Host","app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");


        postParams.addBodyParameter("versionId","100023");
        postParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        postParams.addBodyParameter("orderBy","2");
        postParams.addBodyParameter("pageNum","1");
        postParams.addBodyParameter("operatorUid", " ");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //System.out.println("hot=" + s);
                ParserJson(s);
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

    /**
     * 解析json的数据
     */
    private void ParserJson(String s){
        gson=new Gson();

        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject json = jsonObject.getJSONObject("data");
            final String picIp = json.getString("picIp");
            VideoHot.data data = gson.fromJson(json.toString(), VideoHot.data.class);
            List<hotvideos> videos = data.videos;
            mListView.setAdapter(new CommonAdapter<hotvideos>(getContext(),
                    videos,
                    R.layout.video_frg_hot_frg_list) {
                @Override
                public void convert(MyViewHolder holder, hotvideos carevideos) {
                    ImageView imgView = holder.getView(R.id.video_frg_hot_frg_pic);
                    String imgUrl=picIp+carevideos.getPic();
                    x.image().bind(imgView,imgUrl);

                    holder.setText(R.id.video_frg_hot_frg_tv_title,carevideos.getTitle())
                    .setText(R.id.video_frg_hot_frg_tv_duration, TimeUtils.formatDuration2(carevideos.getDuration()))
                    .setText(R.id.video_frg_hot_frg_tv_nickName, carevideos.getUserInfo().getNickname())
                    .setText(R.id.video_frg_hot_frg_tv_watchNum,carevideos.getWatchNum()+"");
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }







}
