package com.fantastic3.thebeautiful.bean;

/**
 * Created on 2015/11/11 19:55
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */

import java.util.List;

/**
 * 视频中的 关注的实体类
 */
public class VideoConcerned {
    public String message;
    public int status;

    public class data{
        public int hasConcern;
        public String picIp;
        public List<concernedvideos>recommend;

        public int getHasConcern() {
            return hasConcern;
        }

        public void setHasConcern(int hasConcern) {
            this.hasConcern = hasConcern;
        }

        public String getPicIp() {
            return picIp;
        }

        public void setPicIp(String picIp) {
            this.picIp = picIp;
        }

        public List<concernedvideos> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<concernedvideos> recommend) {
            this.recommend = recommend;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
