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
import com.fantastic3.thebeautiful.bean.VideoNewest;
import com.fantastic3.thebeautiful.bean.thenewvideos;
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
 * 最新的Fragment
 */
public class VideoNewestFragment extends BaseFragment {


    private Gson gson;
    private ListView mListView;

    public VideoNewestFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_the_new, container, false);
        mListView = (ListView) ret.findViewById(R.id.theNew_frg_listView);
        return ret;
    }

    @Override
    public void onResume() {
        super.onResume();
        getServerJson();
    }

    /**
     * 获得服务器的json数据
     */
    private void getServerJson() {
        RequestParams postParams=new RequestParams(VideoNetAddress.VIDEO_THE_NEWEST_URL);
        postParams.addHeader("Content-Length","113");
        postParams.addHeader("Content-Type","application/x-www-form-urlencoded");
        postParams.addHeader("Host","app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");
        postParams.addBodyParameter("versionId", "100023");
        postParams.addBodyParameter("orderBy","1");

        postParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        postParams.addBodyParameter("pageNum","1");
        postParams.addBodyParameter("operatorUid"," ");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("new=" + s.toString());
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
     * 解析Json的数据
     */
    private void ParserJson(String s)  {

        gson=new Gson();
        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject json=jsonObject.getJSONObject("data");
            final String picIp = json.getString("picIp");
            VideoNewest.data data = gson.fromJson(json.toString(), VideoNewest.data.class);
            List<thenewvideos> videos = data.videos;

            mListView.setAdapter(new CommonAdapter<thenewvideos>(getContext(),
                    videos,
                    R.layout.video_frg_newest_frg_list
                    ) {
                @Override
                public void convert(MyViewHolder holder, thenewvideos videos) {
                    String imgUrl=picIp+videos.getPic();
                    ImageView imageView = holder.getView(R.id.video_frg_new_frg_img);
                    x.image().bind(imageView, imgUrl);

                    holder.setText(R.id.video_frg_new_tv_title,videos.getTitle())
                            .setText(R.id.video_frg_new_frg_tv_content,videos.getContent())
                            .setText(R.id.video_frg_new_frg_tv_nickName,videos.getUserInfo().getNickname())
                            .setText(R.id.video_frg_new_frg_tv_watchNum,videos.getWatchNum()+"")
                            .setText(R.id.video_frg_new_frg_tv_duration, TimeUtils.formatDuration2(videos.getDuration()))
                            ;


                }
            });






        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}





