package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.DiscoverConcerned;
import com.fantastic3.thebeautiful.bean.Recommends;
import com.fantastic3.thebeautiful.bean.VideoConcerned;
import com.fantastic3.thebeautiful.bean.concernedvideos;
import com.fantastic3.thebeautiful.config.DiscoverNetAddress;
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
public class DiscoverConcernedFragment extends BaseFragment {


    private Gson gson;
    private ListView  mListView;

    public DiscoverConcernedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret= inflater.inflate(R.layout.fragment_discover_concerned, container, false);
        mListView= (ListView) ret.findViewById(R.id.discover_frg_concerned_frg_listView);
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
        RequestParams postParams = new RequestParams(DiscoverNetAddress.DISCOVER_THE_CONCERNED_URL);
        postParams.addHeader("Content-Length", "119");
        postParams.addHeader("Content-Type", "application/x-www-form-urlencoded");
        postParams.addHeader("Host", "app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");


        postParams.addBodyParameter("uid", " ");
        postParams.addBodyParameter("versionId", "100023");
        postParams.addBodyParameter("deviceId", "1EE6175C02AE8917FE93CC8BC4847701");
        postParams.addBodyParameter("pageNum", "1");
        postParams.addBodyParameter("operatorUid", " ");
        postParams.addBodyParameter("pageSize","3");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("discoverConcerned=" + s);
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

            DiscoverConcerned.data data = gson.fromJson(object.toString(), DiscoverConcerned.data.class);
            List<Recommends> recommend = data.recommend;

            mListView.setAdapter(new CommonAdapter<Recommends>(getContext(),
                    recommend,R.layout.discover_frg_concerned_frg_list) {
                @Override
                public void convert(MyViewHolder holder, Recommends recommends) {

                    ImageView img_head = holder.getView(R.id.discover_frg_concerned_frg_myPic);
                    RelativeLayout relativeLayout2 = holder.getView(R.id.discover_frg_concerned_relative2);

                    String head_img_url=picIp+recommends.getUserInfo().getHead_img_url();
                    x.image().bind(img_head,head_img_url);

                    holder.setText(R.id.discover_frg_concerned_frg_tv_nickName, recommends.getUserInfo().getNickname())
                            .setText(R.id.discover_frg_concerned_frg_tv_level,recommends.getUserInfo().getLevel());

                    if(recommends.getLectures().size()==2){
                        ImageView img_one = holder.getView(R.id.discover_frg_concerned_frg_pic);
                        String img_urlOne=picIp+recommends.getLectures().get(0).getPic().get(0);
                        x.image().bind(img_one, img_urlOne);

                        holder.setText(R.id.discover_frg_concerned_frg_tv_title, recommends.getLectures().get(0).getTitle());


                        //TODO 第二个 RelativeLayout
                        ImageView img_two = holder.getView(R.id.discover_frg_concerned_frg_pic2);
                        String img_urlTwo=picIp+recommends.getLectures().get(1).getPic().get(0);
                        x.image().bind(img_two, img_urlTwo);

                        holder.setText(R.id.discover_frg_concerned_frg_tv_title2, recommends.getLectures().get(1).getTitle());

                    }else{
                        relativeLayout2.setVisibility(View.GONE);
                        ImageView img_one = holder.getView(R.id.discover_frg_concerned_frg_pic);
                        String img_urlOne=picIp+recommends.getLectures().get(0).getPic().get(0);
                        x.image().bind(img_one, img_urlOne);

                        holder.setText(R.id.discover_frg_concerned_frg_tv_title, recommends.getLectures().get(0).getTitle());

                    }





                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
