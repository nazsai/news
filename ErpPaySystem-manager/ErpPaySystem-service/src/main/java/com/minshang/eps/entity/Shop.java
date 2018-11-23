package com.minshang.eps.entity;

import java.util.Date;

public class Shop {
    private Integer shopid;

    private String shopname;

    private Integer brandid;

    private Byte shoptype;

    private Byte shopmoudle;

    private String telphoneno;

    private Integer addid;

    private String address;

    private Integer userid;

    private Integer createuser;

    private Date createtime;

    private String activationkey;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public Byte getShoptype() {
        return shoptype;
    }

    public void setShoptype(Byte shoptype) {
        this.shoptype = shoptype;
    }

    public Byte getShopmoudle() {
        return shopmoudle;
    }

    public void setShopmoudle(Byte shopmoudle) {
        this.shopmoudle = shopmoudle;
    }

    public String getTelphoneno() {
        return telphoneno;
    }

    public void setTelphoneno(String telphoneno) {
        this.telphoneno = telphoneno == null ? null : telphoneno.trim();
    }

    public Integer getAddid() {
        return addid;
    }

    public void setAddid(Integer addid) {
        this.addid = addid;
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

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey == null ? null : activationkey.trim();
    }
}