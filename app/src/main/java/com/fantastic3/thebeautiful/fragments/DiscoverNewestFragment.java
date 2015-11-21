package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapter.DiscoverTheNewestAdapter;
import com.fantastic3.thebeautiful.bean.DiscoverNewest;
import com.fantastic3.thebeautiful.bean.discoverNewestLectureLists;
import com.fantastic3.thebeautiful.config.DiscoverNetAddress;
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
public class DiscoverNewestFragment extends BaseFragment {


    private Gson gson;
    private ListView mListView;
    public DiscoverNewestFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_discover_newest, container, false);
              mListView= (ListView) ret.findViewById(R.id.discover_frg_newest_frg_listView);
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
        RequestParams postParams=new RequestParams(DiscoverNetAddress.DISCOVER_THE_NEWEST_URL);
        postParams.addHeader("Content-Length","129");
        postParams.addHeader("Content-Type","application/x-www-form-urlencoded");
        postParams.addHeader("Host","app.dameiren.com");
        postParams.addHeader("Connection", "Keep-Alive");


        postParams.addBodyParameter("uid", " ");
        postParams.addBodyParameter("orderBy","1");
        postParams.addBodyParameter("versionId","100023");
        postParams.addBodyParameter("deviceId", "1EE6175C02AE8917FE93CC8BC4847701");
        postParams.addBodyParameter("pageNum","1");
        postParams.addBodyParameter("pageSize","3");
        postParams.addBodyParameter("operatorUid", " ");

        HttpUtils.Post(postParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("DiscoverNewest=" + s);
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

            DiscoverNewest.data data = gson.fromJson(object.toString(), DiscoverNewest.data.class);
            List<discoverNewestLectureLists> lectureList = data.getLectureList();

            DiscoverTheNewestAdapter adapter=new DiscoverTheNewestAdapter(getContext(),lectureList);
            mListView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
