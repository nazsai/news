package com.minshang.eps.entity;

import java.util.Date;

public class Loginlog {
    private Integer loginid;

    private String usercode;

    private String ipaddr;

    private Date logindate;

    private Date logoutdate;

    private Byte state;

    private String errorcode;

    private String loginsource;

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public Date getLogoutdate() {
        return logoutdate;
    }

    public void setLogoutdate(Date logoutdate) {
        this.logoutdate = logoutdate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode == null ? null : errorcode.trim();
    }

    public String getLoginsource() {
        return loginsource;
    }

    public void setLoginsource(String loginsource) {
        this.loginsource = loginsource == null ? null : loginsource.trim();
    }
}