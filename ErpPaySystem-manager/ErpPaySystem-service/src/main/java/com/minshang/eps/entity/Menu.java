package com.minshang.eps.entity;

import java.util.Date;

public class Menu {
    private Integer menuid;

    private Integer dishesdepotid;

    private String menuname;

    private Integer createuser;

    private Date createtime;

    private Date taketime;

    private Byte state;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getDishesdepotid() {
        return dishesdepotid;
    }

    public void setDishesdepotid(Integer dishesdepotid) {
        this.dishesdepotid = dishesdepotid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getTaketime() {
        return taketime;
    }

    public void setTaketime(Date taketime) {
        this.taketime = taketime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}