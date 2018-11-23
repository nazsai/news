package com.minshang.eps.entity;

import java.util.Date;

public class Organization {
    private Integer orgid;

    private String orgname;

    private Byte orgtype;

    private Byte orglv;

    private Integer parentorgid;

    private Integer industryid;

    private Byte shoptype;

    private Integer shopmoudle;

    private String telphoneno;

    private String address;

    private Integer userid;

    private Integer createuser;

    private Date createtime;

    private Date modifytime;

    private String activationkey;

    private Byte state;

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public Byte getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(Byte orgtype) {
        this.orgtype = orgtype;
    }

    public Byte getOrglv() {
        return orglv;
    }

    public void setOrglv(Byte orglv) {
        this.orglv = orglv;
    }

    public Integer getParentorgid() {
        return parentorgid;
    }

    public void setParentorgid(Integer parentorgid) {
        this.parentorgid = parentorgid;
    }

    public Integer getIndustryid() {
        return industryid;
    }

    public void setIndustryid(Integer industryid) {
        this.industryid = industryid;
    }

    public Byte getShoptype() {
        return shoptype;
    }

    public void setShoptype(Byte shoptype) {
        this.shoptype = shoptype;
    }

    public Integer getShopmoudle() {
        return shopmoudle;
    }

    public void setShopmoudle(Integer shopmoudle) {
        this.shopmoudle = shopmoudle;
    }

    public String getTelphoneno() {
        return telphoneno;
    }

    public void setTelphoneno(String telphoneno) {
        this.telphoneno = telphoneno == null ? null : telphoneno.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey == null ? null : activationkey.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}