package com.fantastic3.thebeautiful.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.bean.discoverNewestLectureLists;

import org.w3c.dom.Text;
import org.xutils.x;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created on 2015/11/12 11:18
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class DiscoverTheNewestAdapter extends BaseAdapter{

    private Context context;
    private String  picIp= "http://res.app.dameiren.com/";
    private List<discoverNewestLectureLists>lectureLists;
    private LayoutInflater mInflater;
    final int ITEM_ONE=0;
    final int ITEM_TWO=1;

    public DiscoverTheNewestAdapter(Context context, List<discoverNewestLectureLists> lectureLists) {
        this.context = context;
        this.lectureLists = lectureLists;
        mInflater=LayoutInflater.from(context);

    }

    /**
     * 两种布局
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return lectureLists.get(position).getLevelType();
    }

    @Override
    public boolean isEnabled(int position) {
        if(lectureLists.get(position).getLevelType()==1){
            return false;
        }
        return true;
    }

    @Override
    public int getCount() {
        return lectureLists.size();
    }

    @Override
    public Object getItem(int position) {
        return lectureLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        View ret=null;
        switch (type){
            case 0:
                ret=bindDiscoverTheNewestItemOne(position, convertView, parent);
                break;

            case 1:
                ret=bindDiscoverTheNewestItemTwo(position, convertView, parent);
                break;
        }
        return ret;
    }

    /**
     * 绑定第二个布局
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private View bindDiscoverTheNewestItemTwo(int position, View convertView, ViewGroup parent) {
        View ret=null;

        if (convertView != null) {
            ret=convertView;
        }else{
            ret=mInflater.inflate(R.layout.discover_frg_newest_frg_item_two,parent,false);
        }

        //2.ViewHolder
        NewestTwoViewHolder holder= (NewestTwoViewHolder) ret.getTag();

        if(holder==null){
            holder=new NewestTwoViewHolder();

            holder.ivPic=new ImageView[3];
            holder.tvTitle=new TextView[3];
            holder.tvNickName=new TextView[3];
            holder.tvWatchNum=new TextView[3];

            for (int i = 0; i <3 ; i++) {

                holder.ivPic[i]= (ImageView) findView(ret,"discover_frg_newest_frg_pic"+i);
                holder.tvTitle[i]= (TextView) findView(ret,"discover_frg_newest_frg_tv_title"+i);
                holder.tvNickName[i]= (TextView) findView(ret,"discover_frg_newest_frg_tv_nickName"+i);
                holder.tvWatchNum[i]= (TextView) findView(ret,"discover_frg_newest_frg_tv_watchNum"+i);
            }
            ret.setTag(holder);
        }

        //3.获得数据显示内容
        discoverNewestLectureLists discoverNewestLectureLists = lectureLists.get(position);
        for (int i = 0; i <lectureLists.size() ; i++) {

           x.image().bind(holder.ivPic[i],picIp+lectureLists.get(i).getPic());


            
        }



        return ret;
    }

    /**
     * 绑定第一个布局
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private View bindDiscoverTheNewestItemOne(int position, View convertView, ViewGroup parent) {
       View ret=null;
        if(convertView!=null){
            ret=convertView;
        }else{
            ret=mInflater.inflate(R.layout.discover_frg_newest_frg_item_one,parent,false);
        }
        //2.ViewHolder
        NewestOneViewHolder  holder = (NewestOneViewHolder) ret.getTag();

        if (holder == null) {
            holder=new NewestOneViewHolder();
            holder.ivPic= (ImageView) ret.findViewById(R.id.discover_frg_newest_frg_item_one_img);
            holder.tvTitle= (TextView) ret.findViewById(R.id.discover_frg_newest_frg_item_one_tv_title);
            holder.tvNickName= (TextView) ret.findViewById(R.id.discover_frg_newest_frg_item_one_tv_nickName);
            holder.tvWatchNum= (TextView) ret.findViewById(R.id.discover_frg_newest_frg_item_one_tv_watchNum);

            ret.setTag(holder);
        }

        //3.获得数据，设置内容
        discoverNewestLectureLists discoverNewestLectureLists = lectureLists.get(position);
        String imgUrl = picIp + discoverNewestLectureLists.getPic().get(0);
        x.image().bind(holder.ivPic,imgUrl);

        holder.tvTitle.setText(discoverNewestLectureLists.getTitle());
        holder.tvNickName.setText(discoverNewestLectureLists.getUserInfo().getNickname());
        holder.tvWatchNum.setText(discoverNewestLectureLists.getReadNum()+"");

        return ret;
    }


    /**
     * 第一个布局的ViewHolder
     */
    public static class  NewestOneViewHolder{
        public ImageView ivPic;
        public TextView tvTitle,tvNickName,tvWatchNum;

    }


    /**
     * 第二个布局的ViewHolder
     */
    public static class  NewestTwoViewHolder{
        public ImageView[] ivPic;
        public TextView[] tvTitle;
        public TextView[] tvNickName;
        public TextView[] tvWatchNum;

    }






    /**
     * 通过类的反射，来获取指定的 R.id.xxxx
     * @param container
     * @param filedName
     * @return
     */
    public static View findView(View container,String filedName){
        View ret=null;

        if (container != null && filedName!=null) {
            Class<R.id>idClass=R.id.class;
            try {
                Field field = idClass.getDeclaredField(filedName);

                int id = field.getInt(idClass);
                //通过静态常量，，，获取int值，来查找View
                ret=container.findViewById(id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return  ret;
    }






}
