package com.fantastic3.thebeautiful.httpRequest;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/11.
 */
public class HttpUtils {
    //通过POST请求获取系统时间的请求
    public static <T> void  Post(final RequestParams requestParams,final Callback.CommonCallback<T> callback){
        ApiClient.getServiceTime(new ServiceTimeCallback() {
                                     @Override
                                     public void getTime(String time) {
                                         requestParams.addBodyParameter("reqTime",time);
                                         x.http().post(requestParams,callback);
                                     }
                                 }
        );
    }

    //GET方式在获取系统时间的前提下获取
    public static  void Get(final RequestParams requestParams,final Callback.CommonCallback callback){
        ApiClient.getServiceTime(new ServiceTimeCallback() {
            @Override
            public void getTime(String time) {
                requestParams.addQueryStringParameter("reqTime",time);
                x.http().get(requestParams,callback);
            }
        });
    }
}
