package com.fantastic3.thebeautiful.bean;

import java.util.List;

/**
 * Created on 2015/11/14 10:20
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class MallSpecialGoods extends BaseMeiren {

    public class data {

        /**
         * out_url : http://wap.koudaitong.com/v2/feature/qmq7u24t
         * picIp : http://res.app.dameiren.com/
         * servertime : 1447467505
         */

        public String out_url;
        public String picIp;
        public int servertime;

        public class products{
            public String title;
            public List<ProductLists>list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProductLists> getList() {
                return list;
            }

            public void setList(List<ProductLists> list) {
                this.list = list;
            }
        }


        public void setOut_url(String out_url) {
            this.out_url = out_url;
        }

        public void setPicIp(String picIp) {
            this.picIp = picIp;
        }

        public void setServertime(int servertime) {
            this.servertime = servertime;
        }

        public String getOut_url() {
            return out_url;
        }

        public String getPicIp() {
            return picIp;
        }

        public int getServertime() {
            return servertime;
        }
    }

}
