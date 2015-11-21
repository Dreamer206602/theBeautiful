package com.fantastic3.thebeautiful.fragments;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.activites.MallFooterActivity;
import com.fantastic3.thebeautiful.adapters.commentAdapter.CommonAdapter;
import com.fantastic3.thebeautiful.adapters.commentAdapter.MyViewHolder;
import com.fantastic3.thebeautiful.bean.Mall;
import com.fantastic3.thebeautiful.bean.MallBanners;
import com.fantastic3.thebeautiful.bean.MallFooterGoods;
import com.fantastic3.thebeautiful.bean.Navigation;
import com.fantastic3.thebeautiful.bean.ProductLists;
import com.fantastic3.thebeautiful.config.Cfig;
import com.fantastic3.thebeautiful.config.MallNetAddress;
import com.fantastic3.thebeautiful.widgets.CarouselView;
import com.fantastic3.thebeautiful.widgets.MallFooterView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 商城部分的Fragmet
 */
public class MallFragment extends BaseFragment implements View.OnClickListener {

    private Gson gson;
    private ListView mListView;
    private FloatingActionButton fab_gotop;

    static MallFragment mallFragment;


    public MallFragment() {
    }

    public static MallFragment getInstance() {
        if (mallFragment == null) {
            mallFragment = new MallFragment();
        }
        return mallFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_mall, container, false);
        mListView = (ListView) ret.findViewById(R.id.mall_frg_listView);
        fab_gotop= (FloatingActionButton) ret.findViewById(R.id.mall_frg_FAB_gotop);

        fab_gotop.setOnClickListener(this);

        return ret;
    }

    @Override
    public void onResume() {
        super.onResume();

        getServerJson();
        getServerFooterListViewJson();
    }

    /**
     * 获取脚布局的ListView的json数据
     */
    private void getServerFooterListViewJson() {
        RequestParams requestParams = new RequestParams(MallNetAddress.MALL_FRG_SPECIAL_GOODS);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("Mall_special_goods" + s);
                parserFooterListViewJson(s);
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
     * 解析 脚布局的LIstView的json 的数据
     *
     * @param s
     */
    private void parserFooterListViewJson(String s) {

        gson = new Gson();

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject data = jsonObject.getJSONObject("data");
            String picIp = data.getString("picIp");
            JSONObject products = data.getJSONObject("products");

            MallFooterGoods.data.products products1 =
                    gson.fromJson(products.toString(), MallFooterGoods.data.products.class);

            /**
             * 精选单品
             */
            final String title = products1.title;

            final List<ProductLists> list = products1.list;

            mListView.setAdapter(new CommonAdapter<ProductLists>(getContext(),
                    list, R.layout.mall_frg_footer_listview_detail) {
                @Override
                public void convert(MyViewHolder holder, ProductLists productLists) {


                    holder.setText(R.id.mall_frg_footer_tv_title,title);


                    ImageView img = holder.getView(R.id.mall_frg_footer_listView_detail_iv);
                    TextView tvOldPrice = holder.getView(R.id.mall_frg_footer_listView_detail_tv_old_price);

                    //设置中划线
                    tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
                    x.image().bind(img, productLists.getP_img());

                    holder.setText(R.id.mall_frg_footer_listView_detail_tv_now_desc, productLists.getP_desc())
                            .setText(R.id.mall_frg_footer_listView_detail_tv_now_price, productLists.getP_now_price())
                            .setText(R.id.mall_frg_footer_listView_detail_tv_old_price, productLists.getP_old_price());

                }
            });


          mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Intent intent = new Intent(getContext(), MallFooterActivity.class);
                  intent.putExtra(Cfig.MALL_FOOTER_LISTERVIEW_DETAIL, list.get(position).getP_url());
                  startActivity(intent);
              }
          });
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    /**
     * 获得服务器的json的数据
     */
    private void getServerJson() {

        RequestParams requestParams = new RequestParams(MallNetAddress.MALL_FRG_URL);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("Mall=" + s);
               // parserJson(s);
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
     *
     * @param s
     */
    private void parserJson(String s) {

        gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(s);
            final JSONObject object = jsonObject.getJSONObject("data");
            final String picIp = object.getString("picIp");
            final Mall.data data = gson.fromJson(object.toString(), Mall.data.class);


            final List<Navigation> navigations = data.navigation;
            final List<MallBanners> banners = data.banners;



            mListView.setAdapter(new CommonAdapter<MallBanners>(getContext(),
                    data.banners, R.layout.mall_frg_main) {
                @Override
                public void convert(MyViewHolder holder, MallBanners mallBanners) {
                    RelativeLayout relativeLayout = holder.getView(R.id.mall_frg_relativeLayout1);


                    ImageView iv_myMall = holder.getView(R.id.mall_frg_iv_MyMall);
                    String imgUrl_myMall = picIp + data.navigation.get(0).getImg();
                    x.image().bind(iv_myMall, imgUrl_myMall);
                    holder.setText(R.id.mall_frg_tv_MyMall, data.navigation.get(0).getName());

                    ImageView iv_shoppingGuide = holder.getView(R.id.mall_frg_iv_ShoppingGuide);
                    String imgUrl_shoppingGuide = picIp + data.navigation.get(1).getImg();
                    x.image().bind(iv_shoppingGuide, imgUrl_shoppingGuide);
                    holder.setText(R.id.mall_frg_tv_ShoppingGuide, data.navigation.get(1).getName());


                    ImageView iv_MainVenue = holder.getView(R.id.mall_frg_iv_MainVenue);
                    String imgUrl_MainVenue = picIp + data.navigation.get(2).getImg();
                    x.image().bind(iv_MainVenue, imgUrl_MainVenue);
                    holder.setText(R.id.mall_frg_tv_MainVenue, data.navigation.get(2).getName());


                    ImageView iv_Overseas = holder.getView(R.id.mall_frg_iv_OverSeas);
                    String imgUrl_Overseas = picIp + data.navigation.get(3).getImg();
                    x.image().bind(iv_Overseas, imgUrl_Overseas);
                    holder.setText(R.id.mall_frg_tv_OverSeas, data.navigation.get(3).getName());


                    ImageView iv_Brand = holder.getView(R.id.mall_frg_iv_Brand);
                    String imgUrl_Brand = picIp + data.navigation.get(4).getImg();
                    x.image().bind(iv_Brand, imgUrl_Brand);
                    holder.setText(R.id.mall_frg_tv_Brand, data.navigation.get(4).getName());
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        mListView.setSelection(0);

    }
}
