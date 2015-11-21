package com.fantastic3.thebeautiful.bean;

/**
 * Created on 2015/11/14 10:18
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */
public class BaseMeiren {


    /**
     * message : 成功
     * status : 0
     */

    private String message;
    private int status;



    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
