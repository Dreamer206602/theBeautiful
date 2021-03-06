package com.fantastic3.thebeautiful;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.fantastic3.thebeautiful.config.ServiceTimeCallback;
import com.fantastic3.thebeautiful.config.VideoNetAddress;
import com.fantastic3.thebeautiful.fragments.BaseFragment;
import com.fantastic3.thebeautiful.fragments.CommunityFragment;
import com.fantastic3.thebeautiful.fragments.DiscoverFragment;
import com.fantastic3.thebeautiful.fragments.LiveFragment;
import com.fantastic3.thebeautiful.fragments.MallFragment;
import com.fantastic3.thebeautiful.fragments.VideoFragment;
import com.fantastic3.thebeautiful.httpRequest.ApiClient;
import com.fantastic3.thebeautiful.httpRequest.HttpUtils;
import com.fantastic3.thebeautiful.utils.HttpRequest;
import com.fantastic3.thebeautiful.utils.L;
import com.fantastic3.thebeautiful.utils.StringMap;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    FrameLayout mainpaelFragment;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainpaelFragment = (FrameLayout) findViewById(R.id.main_panel);
        radioGroup = (RadioGroup) findViewById(R.id.main_botton_menu);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                BaseFragment baseFragment = null;
                switch (checkedId) {
                    case R.id.liveRadio:
                        //显示直播界面
                        baseFragment = LiveFragment.getInstance();
                        break;
                    case R.id.videoRadio:
                        //显示视频界面
                        baseFragment = VideoFragment.newInstance();
                        break;
                    case R.id.disvocerRadio:
                        // 显示发现界面
                        baseFragment = DiscoverFragment.newInstance();
                        break;
                    case R.id.communityRadio:
                        //显示社区界面
                        baseFragment = CommunityFragment.getInstance();
                        break;

                    case R.id.mallRadio:
                        //显示 商城界面
                        baseFragment = MallFragment.getInstance();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_panel, baseFragment).commit();


            }
        });
        LiveFragment liveFragment = new LiveFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_panel, liveFragment).commit();
    }


}
