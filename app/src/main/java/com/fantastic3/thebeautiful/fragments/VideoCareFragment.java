package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.VideoConcerned;
import com.fantastic3.thebeautiful.bean.concernedvideos;
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
 * 关注的Fragment
 */
public class VideoCareFragment extends BaseFragment {


    private Gson gson;
    private ListView mListView;

    public VideoCareFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_care, container, false);
        mListView = (ListView) ret.findViewById(R.id.video_frg_care_frg_listView);
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
        RequestParams postParams = new RequestParams(VideoNetAddress.VIDEO_THE_CONCERNED_URL);
        postParams.addHeader("Content-Length", "122");
        postParams.addHeader("Content-Type", "application/x-www-form-urlencoded");
        postParams.addHeader("Host", "app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");


        postParams.addBodyParameter("uid", " ");
        postParams.addBodyParameter("versionId", "100023");
        postParams.addBodyParameter("isSubscribe","0");
        postParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        postParams.addBodyParameter("pageNum", "1");
        postParams.addBodyParameter("operatorUid", " ");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("care=" + s);
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

    private void ParserJson(String s) {
        gson = new Gson();

        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject object = jsonObject.getJSONObject("data");
            final String picIp = object.getString("picIp");

            VideoConcerned.data data = gson.fromJson(object.toString(), VideoConcerned.data.class);
            List<concernedvideos> recommend = data.getRecommend();

            mListView.setAdapter(new CommonAdapter<concernedvideos>(getContext(),
                    recommend,R.layout.video_frg_care_frg_list) {
                @Override
                public void convert(MyViewHolder holder, concernedvideos concernedvideos) {

                    ImageView img_head = holder.getView(R.id.video_frg_care_frg_myPic);
                    RelativeLayout relativeLayout2 = holder.getView(R.id.video_frg_care_relative2);

                    String head_img_url=picIp+concernedvideos.getUserInfo().getHead_img_url();
                    x.image().bind(img_head,head_img_url);

                    holder.setText(R.id.video_frg_care_frg_tv_nickName, concernedvideos.getUserInfo().getNickname())
                    .setText(R.id.video_frg_care_frg_tv_level,concernedvideos.getUserInfo().getLevel());

                   if(concernedvideos.getVideos().size()==2){
                       ImageView img_one = holder.getView(R.id.video_frg_care_frg_pic);
                        String img_urlOne=picIp+concernedvideos.getVideos().get(0).getPic();
                       x.image().bind(img_one, img_urlOne);

                       holder.setText(R.id.video_frg_care_frg_tv_duration, TimeUtils.formatDuration2(concernedvideos.getVideos().get(0).getDuration()))
                       .setText(R.id.video_frg_care_frg_tv_title,concernedvideos.getVideos().get(0).getTitle());


                       //TODO 第二个 RelativeLayout
                       ImageView img_two = holder.getView(R.id.video_frg_care_frg_pic2);
                       String img_urlTwo=picIp+concernedvideos.getVideos().get(1).getPic();
                       x.image().bind(img_two,img_urlTwo);


                       holder.setText(R.id.video_frg_care_frg_tv_duration2, TimeUtils.formatDuration2(concernedvideos.getVideos().get(1).getDuration()))
                               .setText(R.id.video_frg_care_frg_tv_title2,concernedvideos.getVideos().get(1).getTitle());

                   }else{
                       relativeLayout2.setVisibility(View.GONE);
                       ImageView img_one = holder.getView(R.id.video_frg_care_frg_pic);
                       String img_urlOne=picIp+concernedvideos.getVideos().get(0).getPic();
                       x.image().bind(img_one, img_urlOne);

                       holder.setText(R.id.video_frg_care_frg_tv_duration, TimeUtils.formatDuration2(concernedvideos.getVideos().get(0).getDuration()))
                               .setText(R.id.video_frg_care_frg_tv_title,concernedvideos.getVideos().get(0).getTitle());

                   }





                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}

