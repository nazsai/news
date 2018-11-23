package com.minshang.eps.entity;

import java.util.Date;

public class Shopmoudle {
    private Integer shopmoudleid;

    private String shopmoudlename;

    private Integer createuser;

    private Date createdate;

    private Date modifytime;

    public Integer getShopmoudleid() {
        return shopmoudleid;
    }

    public void setShopmoudleid(Integer shopmoudleid) {
        this.shopmoudleid = shopmoudleid;
    }

    public String getShopmoudlename() {
        return shopmoudlename;
    }

    public void setShopmoudlename(String shopmoudlename) {
        this.shopmoudlename = shopmoudlename == null ? null : shopmoudlename.trim();
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}