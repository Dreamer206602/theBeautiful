package com.fantastic3.thebeautiful.bean;

/**
 * Created on 2015/11/13 11:19
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class ProductLists {


    /**
     * p_desc : 资生堂 洗颜专科 泡沫美白洁面乳洗面奶120g/2支 台湾版 赠起泡网
     * p_img : https://dn-kdt-img.qbox.me/upload_files/2014/12/23/670aeb93673d573f0aa81dc8b3fad726.jpg
     * p_is_global : 0
     * p_now_price : 46.00
     * p_old_price : 96.00
     * p_url : http://shop225914.koudaitong.com/v2/showcase/goods?alias=17mxjk369&from=wsc&kdtfrom=wsc
     * sort : 0
     */

    private String p_desc;
    private String p_img;
    private int p_is_global;
    private String p_now_price;
    private String p_old_price;
    private String p_url;
    private int sort;

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
