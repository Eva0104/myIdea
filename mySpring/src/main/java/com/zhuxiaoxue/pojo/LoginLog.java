package com.zhuxiaoxue.pojo;

import java.sql.Timestamp;

public class LoginLog {
    private Integer id;
    private Timestamp loginlog;
    private String ip;
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLoginlog() {
        return loginlog;
    }

    public void setLoginlog(Timestamp loginlog) {
        this.loginlog = loginlog;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public LoginLog() {
    }

    public LoginLog(String ip, Integer userid) {
        this.ip = ip;
        this.userid = userid;
    }
}
