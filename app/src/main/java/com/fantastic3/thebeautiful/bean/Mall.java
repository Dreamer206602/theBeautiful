package com.fantastic3.thebeautiful.bean;

/**
 * Created on 2015/11/12 17:00
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */

import java.util.List;

/**
 * 这是商城有关的实体类
 */
public class Mall {
    public String message;
    public int status;

    public class data{

        /**
         * picIp : http://res.app.dameiren.com/
         * right_url : http://wap.koudaitong.com/v2/feature/qmq7u24t
         * searchcontent : ￥20抵￥50预售券 仅剩...
         * searchurl : http://wap.koudaitong.com/v2/showcase/feature?alias=u17505
         * servertime : 1447312055
         * shopping_url : http://wap.koudaitong.com/v2/trade/cart?spm=f27361337
         */

        private String picIp;
        private String right_url;
        private String searchcontent;
        private String searchurl;
        private int servertime;
        private String shopping_url;

        public void setPicIp(String picIp) {
            this.picIp = picIp;
        }

        public void setRight_url(String right_url) {
            this.right_url = right_url;
        }

        public void setSearchcontent(String searchcontent) {
            this.searchcontent = searchcontent;
        }

        public void setSearchurl(String searchurl) {
            this.searchurl = searchurl;
        }

        public void setServertime(int servertime) {
            this.servertime = servertime;
        }

        public void setShopping_url(String shopping_url) {
            this.shopping_url = shopping_url;
        }

        public String getPicIp() {
            return picIp;
        }

        public String getRight_url() {
            return right_url;
        }

        public String getSearchcontent() {
            return searchcontent;
        }

        public String getSearchurl() {
            return searchurl;
        }

        public int getServertime() {
            return servertime;
        }

        public String getShopping_url() {
            return shopping_url;
        }

        public class activity{
            /**
             * bottom_left_icon : group1/M00/08/6D/CgpFY1Y_hEeAE9HHAAAgKmt-mAo538.jpg
             * bottom_left_img : group1/M00/08/7A/CgpFY1ZAo9CAd_9dAABj6imVvCE836.jpg
             * bottom_left_url : http://wap.koudaitong.com/v2/showcase/feature?alias=k1h66q2w
             * bottom_right_icon : group1/M00/08/6D/CgpFY1Y_iMCAMbFmAAAiXHJnTrc116.jpg
             * bottom_right_img : group1/M00/08/7A/CgpFY1ZAo8SABnvtAABm_jLKJ7Y178.jpg
             * bottom_right_url : http://wap.koudaitong.com/v2/showcase/feature?alias=1gdo813gb
             * left_icon : group1/M00/08/9C/CgpFY1ZCXtyAYMbaAAAFlEi-kKo524.png
             * left_img : group1/M00/08/C8/CgpFY1ZEIGCAeg8aAAA__xbsEOY770.png
             * left_lasttime : 6745
             * left_url : http://wap.koudaitong.com/v2/showcase/feature?alias=15dbvdfu5
             * top_icon : group1/M00/08/6C/CgpFY1Y_f_KAa59IAAAfKlTmW-s653.jpg
             * top_img : group1/M00/08/6C/CgpFY1Y_gWyAM73jAAC4_g1s0Ow447.jpg
             * top_url : http://wap.koudaitong.com/v2/goods/36a7inig1etf6
             */
            private String bottom_left_icon;
            private String bottom_left_img;
            private String bottom_left_url;
            private String bottom_right_icon;
            private String bottom_right_img;
            private String bottom_right_url;
            private String left_icon;
            private String left_img;
            private String left_lasttime;
            private String left_url;
            private String top_icon;
            private String top_img;
            private String top_url;

            public void setBottom_left_icon(String bottom_left_icon) {
                this.bottom_left_icon = bottom_left_icon;
            }

            public void setBottom_left_img(String bottom_left_img) {
                this.bottom_left_img = bottom_left_img;
            }

            public void setBottom_left_url(String bottom_left_url) {
                this.bottom_left_url = bottom_left_url;
            }

            public void setBottom_right_icon(String bottom_right_icon) {
                this.bottom_right_icon = bottom_right_icon;
            }

            public void setBottom_right_img(String bottom_right_img) {
                this.bottom_right_img = bottom_right_img;
            }

            public void setBottom_right_url(String bottom_right_url) {
                this.bottom_right_url = bottom_right_url;
            }

            public void setLeft_icon(String left_icon) {
                this.left_icon = left_icon;
            }

            public void setLeft_img(String left_img) {
                this.left_img = left_img;
            }

            public void setLeft_lasttime(String left_lasttime) {
                this.left_lasttime = left_lasttime;
            }

            public void setLeft_url(String left_url) {
                this.left_url = left_url;
            }

            public void setTop_icon(String top_icon) {
                this.top_icon = top_icon;
            }

            public void setTop_img(String top_img) {
                this.top_img = top_img;
            }

            public void setTop_url(String top_url) {
                this.top_url = top_url;
            }

            public String getBottom_left_icon() {
                return bottom_left_icon;
            }

            public String getBottom_left_img() {
                return bottom_left_img;
            }

            public String getBottom_left_url() {
                return bottom_left_url;
            }

            public String getBottom_right_icon() {
                return bottom_right_icon;
            }

            public String getBottom_right_img() {
                return bottom_right_img;
            }

            public String getBottom_right_url() {
                return bottom_right_url;
            }

            public String getLeft_icon() {
                return left_icon;
            }

            public String getLeft_img() {
                return left_img;
            }

            public String getLeft_lasttime() {
                return left_lasttime;
            }

            public String getLeft_url() {
                return left_url;
            }

            public String getTop_icon() {
                return top_icon;
            }

            public String getTop_img() {
                return top_img;
            }

            public String getTop_url() {
                return top_url;
            }
        }

        public List<MallBanners> banners;
        public class chosen{
            public String title;
            public String url;
            public List<ChosenList>list;
        }

        public List<Effectproducts>effectproducts;

        public List<Navigation>navigation;


    }

}
