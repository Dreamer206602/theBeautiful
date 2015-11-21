package com.fantastic3.thebeautiful.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.bean.BaseMeiren;
import com.fantastic3.thebeautiful.bean.MallFooterGoods;
import com.fantastic3.thebeautiful.bean.MallHeadInfo;
import com.fantastic3.thebeautiful.bean.MallSpecialGoods;

import java.util.List;

/**
 * Created on 2015/11/14 10:31
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class MallAdapter extends BaseAdapter {

    private Context context;
    private List<BaseMeiren> list;
    private LayoutInflater mInflater;

    public static final int ITEM_HEAD = 0;
    public static final int ITEM_FOOTER = 1;

    public MallAdapter(Context context, List<BaseMeiren> list) {
        this.context = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }


    /**
     * 有两种布局
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int ret = 0;
        BaseMeiren baseMeiren = list.get(position);

        if (baseMeiren instanceof MallHeadInfo) {
            ret = ITEM_HEAD;
        } else if (baseMeiren instanceof MallSpecialGoods) {
            ret = ITEM_FOOTER;
        }
        return ret;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (list != null) {
            ret = list.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret=null;
        //1.获得数据
        BaseMeiren baseMeiren = list.get(position);
        if(baseMeiren instanceof  MallHeadInfo){
            ret=bindMallHead(position,convertView,parent);
        }else if(baseMeiren instanceof MallSpecialGoods){
            ret=bindMallFooter(position,convertView,parent);
        }
        return ret;
    }

    private View bindMallHead(int position, View convertView, ViewGroup parent) {

        return null;
    }

    /**
     * 加载  商城的 ListView的Footer的内容
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private View bindMallFooter(int position, View convertView, ViewGroup parent) {
        View ret=null;
        if(convertView!=null){
            ret=convertView;
        }else{
            ret= mInflater.inflate(R.layout.mall_special_goods, parent, false);
        }

        //2.ViewHolder
        MallSpecialViewHolder holder = (MallSpecialViewHolder) ret.getTag();

        if(holder==null){
            holder=new MallSpecialViewHolder();
            holder.ivPic= (ImageView) ret.findViewById(R.id.mall_frg_footer_listView_detail_iv);

            holder.tvTitle= (TextView) ret.findViewById(R.id.mall_frg_footer_tv_title);

            holder.tvDesc= (TextView) ret.findViewById(R.id.mall_frg_footer_listView_detail_tv_now_desc);
            holder.tvNewPrice= (TextView) ret.findViewById(R.id.mall_frg_footer_listView_detail_tv_now_price);
            holder.tvOldPrice= (TextView) ret.findViewById(R.id.mall_frg_footer_listView_detail_tv_old_price);
            ret.setTag(holder);

        }

        //3.获取数据，加载内容
        MallSpecialGoods specialGoods = (MallSpecialGoods) list.get(position);
        //specialGoods.data.products;







        return ret;
    }

    private static class MallSpecialViewHolder{
        public TextView tvTitle,tvDesc,tvNewPrice,tvOldPrice;
        public ImageView ivPic;

    }
}
