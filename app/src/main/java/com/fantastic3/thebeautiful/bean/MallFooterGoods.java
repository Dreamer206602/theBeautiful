package com.fantastic3.thebeautiful.bean;

/**
 * Created on 2015/11/13 11:15
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */

import java.util.List;

/**
 * 商城的底部的   实体类
 */
public class MallFooterGoods extends BaseMeiren{



    public class data{
        public  String out_url;
        public String  picIp;

        public class products{
            public String title;
            public List<ProductLists>list;
        }
    }
}
