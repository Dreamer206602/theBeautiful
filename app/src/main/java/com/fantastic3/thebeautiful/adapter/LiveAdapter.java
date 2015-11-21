package com.fantastic3.thebeautiful.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.bean.BaseLive;
import com.fantastic3.thebeautiful.fragments.LiveFragment;
import com.fantastic3.thebeautiful.widgets.CircleImage;

import org.xutils.x;

import java.util.List;

/**
 * TheBeautiful
 * Created by meluo
 * on 2015/11/11.
 */
public class LiveAdapter extends BaseAdapter {
    private Context context;
    private List<BaseLive> list;

    public LiveAdapter(Context context, List<BaseLive> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //两种布局
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public boolean isEnabled(int position) {
        if(list.get(position).getLivetype()==1){
            return false;
        }
        return true;
    }

    //根据position获取布局的类型
    @Override
    public int getItemViewType(int position) {
        return list.get(position).getLivetype();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        switch (type) {
            case 0:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.live_item, parent, false);

                }
                ViewHolder viewHolder = (ViewHolder) convertView.getTag();
                if (viewHolder == null) {
                    viewHolder = new ViewHolder();
                    viewHolder.anchors_head = (ImageView) convertView.findViewById(R.id.anchors_head);
                    viewHolder.anchors_name = (TextView) convertView.findViewById(R.id.anchors_name);
                    viewHolder.can_play = (ImageView) convertView.findViewById(R.id.can_play);
                    viewHolder.imge_v = (ImageView) convertView.findViewById(R.id.image_v);
                    viewHolder.live_content = (TextView) convertView.findViewById(R.id.live_content);
                    viewHolder.live_img = (ImageView) convertView.findViewById(R.id.live_img);
                    viewHolder.live_state_img = (ImageView) convertView.findViewById(R.id.live_state_img);
                    viewHolder.watch_num = (TextView) convertView.findViewById(R.id.watch_num);
                    convertView.setTag(viewHolder);
                }
                BaseLive baseLive = list.get(position);
                viewHolder.live_content.setText(baseLive.getTitle());
                viewHolder.watch_num.setText(baseLive.getWatchNum() + "");
                viewHolder.anchors_name.setText(baseLive.getUserInfo().getNickname());
                x.image().bind(viewHolder.live_img, LiveFragment.picIp + baseLive.getPic());
                x.image().bind(viewHolder.anchors_head,LiveFragment.picIp+baseLive.getUserInfo().getHead_img_url());
               if(baseLive.getDisable()==1){
                   viewHolder.can_play.setImageResource(R.drawable.btn_videolist_locked);
               }else if(baseLive.getDisable()==0){
                   viewHolder.can_play.setImageResource(R.drawable.btn_play_live);
               }


                break;
            case 1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.live_item_time, parent, false);
                }
                ViewHolderTime viewHolderTime = (ViewHolderTime) convertView.getTag();
                if (viewHolderTime == null) {
                    viewHolderTime = new ViewHolderTime();
                    viewHolderTime.textView = (TextView) convertView.findViewById(R.id.nowDate);
                    convertView.setTag(viewHolderTime);
                }
                viewHolderTime.textView.setText(list.get(position).getContent());
                break;
        }
        return convertView;
    }

    static class ViewHolder {
        private ImageView live_state_img;
        private ImageView anchors_head;
        private ImageView imge_v;
        private TextView anchors_name;
        private TextView watch_num;
        private ImageView live_img;
        private TextView live_content;
        private ImageView can_play;
    }

    static class ViewHolderTime {
        private TextView textView;
    }

}
