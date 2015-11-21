package com.fantastic3.thebeautiful.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.MallFooterGoods;
import com.fantastic3.thebeautiful.bean.ProductLists;
import com.fantastic3.thebeautiful.config.MallNetAddress;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created on 2015/11/13 10:41
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class MallFooterView extends FrameLayout {

    private Gson gson;
    private ListView mListView;
    private TextView tvTitle;

    public MallFooterView(Context context) {
       super(context);
        initView(context);

    }

    public MallFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);



    }

    public MallFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    /**
     *初始化  控件
     */
    private void initView(Context context) {

        View ret = LayoutInflater.from(context).inflate(R.layout.mall_footer_view, this, true);
        mListView= (ListView) ret.findViewById(R.id.mall_frg_footer_listView);
        tvTitle= (TextView) ret.findViewById(R.id.mall_frg_footer_tv_title);

        getServerJson();

    }


    /**
     * 获得服务器的json数据
     */
    public void getServerJson() {

        RequestParams requestParams=new RequestParams(MallNetAddress.MALL_FRG_SPECIAL_GOODS);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("Mall_special_goods"+s);
                parserJson(s);
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
     * 解析 json 的数据
     * @param s
     */
    private void parserJson(String s) {

        gson=new Gson();

        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONObject data = jsonObject.getJSONObject("data");
            String picIp = data.getString("picIp");

            JSONObject products = data.getJSONObject("products");

            MallFooterGoods.data.products products1 =
                    gson.fromJson(products.toString(), MallFooterGoods.data.products.class);

            /**
             * 精选单品
             */
            String title = products1.title;
            tvTitle.setText(title);


            List<ProductLists> list = products1.list;

            mListView.setAdapter(new CommonAdapter<ProductLists>(getContext(),
                    list,R.layout.mall_frg_footer_listview_detail) {
                @Override
                public void convert(MyViewHolder holder, ProductLists productLists) {

                    ImageView img = holder.getView(R.id.mall_frg_footer_listView_detail_iv);
                    x.image().bind(img,productLists.getP_img());

                    holder.setText(R.id.mall_frg_footer_listView_detail_tv_now_desc,productLists.getP_desc())
                    .setText(R.id.mall_frg_footer_listView_detail_tv_now_price,productLists.getP_now_price())
                    .setText(R.id.mall_frg_footer_listView_detail_tv_old_price,productLists.getP_old_price());

                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
