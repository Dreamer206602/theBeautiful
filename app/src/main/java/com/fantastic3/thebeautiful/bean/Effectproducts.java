package com.fantastic3.thebeautiful.bean;

import java.util.List;

/**
 * Created on 2015/11/12 17:49
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class Effectproducts {

    /**
     * desc : 17款套装卖疯了
     * products : {"list":[{"num_iid":"161506585","p_desc":"【双11超值套装】全效美肤膜法礼包新版（可使用 双11套装预售券）超值面膜套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/11/11/FhTk67nx89qi7YmKs8lyrFoNJWEF.jpg","p_is_global":0,"p_now_price":"198.00","p_old_price":"400","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=35xv145qs0kua&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161516003","p_desc":"【双11超值套装】小蜜坊 活机爱唇套装（可使用 双11套装预售券）超值唇部护理套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/21/FkQYpWPPnvAhhkQf5aq2cVz9FIqk.jpg","p_is_global":0,"p_now_price":"98.00","p_old_price":"138","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=26v9u0mfxcn5u&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161562936","p_desc":"【双11超值套装】柏氏 裸妆无暇套装（可使用 双11套装预售券）超值柏氏套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/22/FskJOmJVkER43ZTj9WcnMUi_H3-E.jpg","p_is_global":0,"p_now_price":"161.00","p_old_price":"268","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=2x7ry5m1xf276&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161554660","p_desc":"【双11超值套装】滋源茶籽控油去屑洗护套装（可使用 双11套装预售券）超值洗发套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/21/FjQzPTG_qRfSqiNr_tM-uvBRUyUP.jpg","p_is_global":0,"p_now_price":"98.00","p_old_price":"122","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=2xbhuhmhvt44i&from=wsc&kdtfrom=wsc","sort":0}]}
     * title : 双11套装榜
     * url : http://wap.koudaitong.com/v2/showcase/feature?alias=x2c0jm0v
     */

    private String desc;
    private ProductsEntity products;
    private String title;
    private String url;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public ProductsEntity getProducts() {
        return products;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public static class ProductsEntity {
        /**
         * list : [{"num_iid":"161506585","p_desc":"【双11超值套装】全效美肤膜法礼包新版（可使用 双11套装预售券）超值面膜套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/11/11/FhTk67nx89qi7YmKs8lyrFoNJWEF.jpg","p_is_global":0,"p_now_price":"198.00","p_old_price":"400","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=35xv145qs0kua&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161516003","p_desc":"【双11超值套装】小蜜坊 活机爱唇套装（可使用 双11套装预售券）超值唇部护理套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/21/FkQYpWPPnvAhhkQf5aq2cVz9FIqk.jpg","p_is_global":0,"p_now_price":"98.00","p_old_price":"138","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=26v9u0mfxcn5u&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161562936","p_desc":"【双11超值套装】柏氏 裸妆无暇套装（可使用 双11套装预售券）超值柏氏套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/22/FskJOmJVkER43ZTj9WcnMUi_H3-E.jpg","p_is_global":0,"p_now_price":"161.00","p_old_price":"268","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=2x7ry5m1xf276&from=wsc&kdtfrom=wsc","sort":0},{"num_iid":"161554660","p_desc":"【双11超值套装】滋源茶籽控油去屑洗护套装（可使用 双11套装预售券）超值洗发套装","p_img":"https://dn-kdt-img.qbox.me/upload_files/2015/10/21/FjQzPTG_qRfSqiNr_tM-uvBRUyUP.jpg","p_is_global":0,"p_now_price":"98.00","p_old_price":"122","p_url":"http://shop225914.koudaitong.com/v2/showcase/goods?alias=2xbhuhmhvt44i&from=wsc&kdtfrom=wsc","sort":0}]
         */

        private List<ListEntity> list;

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity {
            /**
             * num_iid : 161506585
             * p_desc : 【双11超值套装】全效美肤膜法礼包新版（可使用 双11套装预售券）超值面膜套装
             * p_img : https://dn-kdt-img.qbox.me/upload_files/2015/11/11/FhTk67nx89qi7YmKs8lyrFoNJWEF.jpg
             * p_is_global : 0
             * p_now_price : 198.00
             * p_old_price : 400
             * p_url : http://shop225914.koudaitong.com/v2/showcase/goods?alias=35xv145qs0kua&from=wsc&kdtfrom=wsc
             * sort : 0
             */

            private String num_iid;
            private String p_desc;
            private String p_img;
            private int p_is_global;
            private String p_now_price;
            private String p_old_price;
            private String p_url;
            private int sort;

            public void setNum_iid(String num_iid) {
                this.num_iid = num_iid;
            }

            public void setP_desc(String p_desc) {
                this.p_desc = p_desc;
            }

            public void setP_img(String p_img) {
                this.p_img = p_img;
            }

            public void setP_is_global(int p_is_global) {
                this.p_is_global = p_is_global;
            }

            public void setP_now_price(String p_now_price) {
                this.p_now_price = p_now_price;
            }

            public void setP_old_price(String p_old_price) {
                this.p_old_price = p_old_price;
            }

            public void setP_url(String p_url) {
                this.p_url = p_url;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getNum_iid() {
                return num_iid;
            }

            public String getP_desc() {
                return p_desc;
            }

            public String getP_img() {
                return p_img;
            }

            public int getP_is_global() {
                return p_is_global;
            }

            public String getP_now_price() {
                return p_now_price;
            }

            public String getP_old_price() {
                return p_old_price;
            }

            public String getP_url() {
                return p_url;
            }

            public int getSort() {
                return sort;
            }
        }
    }
}
