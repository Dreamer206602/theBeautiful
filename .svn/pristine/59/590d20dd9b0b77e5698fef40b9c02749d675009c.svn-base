package com.fantastic3.thebeautiful.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapter.CarouselPageAdapter;
import com.fantastic3.thebeautiful.httpRequest.HttpUtils;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.lang.reflect.Field;
import java.util.List;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/11.
 */
//图片轮播 的组件
public class CarouselView<T> extends FrameLayout {
    private Context context;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private String url;
    private List<T> list;
    private String keyImag;//网络请求图片的地址关键字
    private String baseUrl;//设置ImageView 基地址
    private ImageView[] imageViews;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            viewPager.setCurrentItem(msg.arg1);
        }
    };
    private ImageView[] navImages;
    private OnPagerItemClickEvent onPagerItemClickListener;
    private boolean can;
    private int finalI;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private ParseJsonCallback<T> parseJsonCallback;

    public CarouselView(Context context, AttributeSet attrs, String url, String keyImag, ParseJsonCallback<T> parseJsonCallback) {
        super(context, attrs);
        this.context = context;
        this.keyImag = keyImag;
        this.url = url;
        this.parseJsonCallback = parseJsonCallback;
        initView();

    }

    public CarouselView(Context context, String url, String keyImag, ParseJsonCallback<T> parseJsonCallback) {
        super(context);
        this.context = context;
        this.keyImag = keyImag;
        this.url = url;
        this.parseJsonCallback = parseJsonCallback;
        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.carousel_view, this, true);
        viewPager = (ViewPager) findViewById(R.id.carouselPager);
        linearLayout = (LinearLayout) findViewById(R.id.nav_panel);
        loaData();
    }

    private void loaData() {
        RequestParams requestParams = new RequestParams(url);
        requestParams.addHeader("Host", "p.bokecc.com");
        requestParams.addHeader("Connection", "Keep-Alive");
        requestParams.addHeader("User-Agent", "Dalvik/1.6.0 (Linux; Android 4.4.4; Genymotion Build/KTU84P)");
        //versionId=100023&channelcode=dmr_wandoujia&deviceId=567C86BF401A7F59C1F12CF75E8E37E2&operatorUid=&reqTime=1447056687588
        requestParams.addBodyParameter("versionId", "100023");
        requestParams.addBodyParameter("channelcode", "dmr_wandoujia");
        requestParams.addBodyParameter("deviceId", "567C86BF401A7F59C1F12CF75E8E37E2");
        requestParams.addBodyParameter("operatorUid", "  ");
        HttpUtils.Post(requestParams, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                list = parseJsonCallback.parseJson(jsonObject);
                loadImage();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                parseJsonCallback.parseJson(null);
            }

            @Override
            public void onCancelled(CancelledException e) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    private void loadImage() {
        imageViews = new ImageView[list.size()];
        navImages = new ImageView[list.size()];
        for (int i = 0; i < list.size(); i++) {
            navImages[i] = new ImageView(context);
            navImages[i].setImageResource(R.drawable.circle_imag);
            navImages[i].setPadding(10, 0, 0, 0);
            linearLayout.addView(navImages[i]);
            imageViews[i] = new ImageView(context);
            imageViews[i].setMaxWidth(LayoutParams.MATCH_PARENT);
            imageViews[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            String weburl = getImageUrl(list.get(i));
            if (baseUrl != null) {
                weburl = baseUrl + weburl;
            }
            if (weburl != null) {
                x.image().bind(imageViews[i], weburl);
            }
        }
        can = true;
        canAddListener();
        navImages[0].setImageResource(R.drawable.circle_imag_b);
        CarouselPageAdapter adapter = new CarouselPageAdapter(imageViews);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setNavImage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        new Thread(new myThread()).start();
    }

    public void setNavImage(int position){
        for(int i=0;i<list.size();i++){
            navImages[i].setImageResource(R.drawable.circle_imag);
        }
        navImages[position].setImageResource(R.drawable.circle_imag_b);
    }

    //通过反射机制 获取数值
    private String getImageUrl(Object object) {
        Class tClass = object.getClass();
        try {
            Field declaredField = tClass.getDeclaredField(keyImag);
            declaredField.setAccessible(true);
            String str = (String) declaredField.get(object);
            return str;

        } catch (Exception e) {
        }
        return null;
    }
    class myThread implements Runnable{

        @Override
        public void run() {
            int i=0;
            while (true){

                Message message=Message.obtain();
                message.arg1=i%list.size();
                handler.sendMessage(message);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
    public void setOnPagerItemClickListener(OnPagerItemClickEvent onPagerItemClickListener){
        this.onPagerItemClickListener = onPagerItemClickListener;
    }

    public void canAddListener(){
        if(onPagerItemClickListener!=null&&can){
            for(int i=0;i<imageViews.length;i++){
                imageViews[i].setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int postion=0;
                        for(int i=0;i<list.size();i++){
                            if(imageViews[i]==v){
                                postion=i;
                                break;
                            }
                        }
                       onPagerItemClickListener.OnPagerItemClick(list,postion);
                    }
                });
            }
        }
    }
    public interface ParseJsonCallback<T> {
        public List<T> parseJson(JSONObject jsonObject);
    }
    public interface OnPagerItemClickEvent<T>{
        public void OnPagerItemClick(List<T> list,int position);
    }


}
