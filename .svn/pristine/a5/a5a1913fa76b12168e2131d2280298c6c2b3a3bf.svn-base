package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.DiscoverHot;
import com.fantastic3.thebeautiful.bean.lecturelists;
import com.fantastic3.thebeautiful.config.DiscoverNetAddress;
import com.fantastic3.thebeautiful.config.VideoNetAddress;
import com.fantastic3.thebeautiful.httpRequest.HttpUtils;
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
public class DiscoverHotFragment extends BaseFragment {


    private Gson gson;
    private ListView  mListView;
    public DiscoverHotFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_discover_hot, container, false);
        mListView= (ListView) ret.findViewById(R.id.discover_frg_hot_frg_listView);
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
        RequestParams postParams=new RequestParams(DiscoverNetAddress.DISCOVER_THE_HOT_URL);
        postParams.addHeader("Content-Length","129");
        postParams.addHeader("Content-Type","application/x-www-form-urlencoded");
        postParams.addHeader("Host","app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");


        postParams.addBodyParameter("uid", " ");
        postParams.addBodyParameter("versionId","100023");
        postParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        postParams.addBodyParameter("orderBy","2");
        postParams.addBodyParameter("pageNum","1");
        postParams.addBodyParameter("pageSize","3");
        postParams.addBodyParameter("operatorUid", " ");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("DiscoverHot=" + s);
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
     * @param s
     */
    private void ParserJson(String s) {
        gson=new Gson();

        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject object = jsonObject.getJSONObject("data");


            DiscoverHot.data data = gson.fromJson(object.toString(), DiscoverHot.data.class);
            final String picIp = data.picIp;

            List<lecturelists> lectureLists = data.lectureList;

            mListView.setAdapter(new CommonAdapter<lecturelists>(
                    getContext(),
                    lectureLists,
                    R.layout.discover_frg_hot_frg_list
            ) {
                @Override
                public void convert(MyViewHolder holder, lecturelists lecturelists) {
                    ImageView img = holder.getView(R.id.discover_frg_hot_frg_pic);

                    String img_url=picIp+lecturelists.getPic().get(0);
                    x.image().bind(img, img_url);

                    holder.setText(R.id.discover_frg_hot_frg_tv_title,lecturelists.getTitle())
                    .setText(R.id.discover_frg_hot_frg_tv_nickName,lecturelists.getUserInfo().getNickname())
                    .setText(R.id.discover_frg_hot_frg_tv_watchNum,lecturelists.getReadNum()+"");


                }
            });



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
