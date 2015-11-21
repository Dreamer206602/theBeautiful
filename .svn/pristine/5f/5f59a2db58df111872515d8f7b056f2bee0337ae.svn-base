package com.fantastic3.thebeautiful.httpRequest;

/**
 * Created by
 * Author: wswenyue
 * Email: wswenyue@163.com
 * GitHub: https://github.com/wswenyue
 * Date: 2015/11/10
 */

import com.fantastic3.thebeautiful.config.LiveNetAddress;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * 这里放置一些常用的请求地址
 * 比如说通用的请求，baseUrl等
 */
public class ApiClient {

    private static String ret;
    public static void getServiceTime(final ServiceTimeCallback callback) {
        ret = null;
        RequestParams requestParams = new RequestParams(LiveNetAddress.GET_SERVICE_TIME);
        requestParams.addHeader("Host", "p.bokecc.com");
        requestParams.addHeader("Connection", "Keep-Alive");
        requestParams.addHeader("User-Agent", "Dalvik/1.6.0 (Linux; Android 4.4.4; Genymotion Build/KTU84P)");
        x.http().get(requestParams, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                if (jsonObject != null) {
                    try {
                        JSONObject json = jsonObject.getJSONObject("system");
                        ret = json.getString("time");
                       callback.getTime(ret);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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





