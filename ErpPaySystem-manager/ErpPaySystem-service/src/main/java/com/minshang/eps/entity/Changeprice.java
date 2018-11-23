package com.minshang.eps.entity;

import java.util.Date;

public class Changeprice {
    private Integer changepriceid;

    private Integer menuid;

    private Integer dishesid;

    private Double orgprice;

    private Double price;

    private Double orgmemberprice;

    private String remark;

    private Integer createuser;

    private Date createtime;

    private Date starttime;

    public Integer getChangepriceid() {
        return changepriceid;
    }

    public void setChangepriceid(Integer changepriceid) {
        this.changepriceid = changepriceid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getDishesid() {
        return dishesid;
    }

    public void setDishesid(Integer dishesid) {
        this.dishesid = dishesid;
    }

    public Double getOrgprice() {
        return orgprice;
    }

    public void setOrgprice(Double orgprice) {
        this.orgprice = orgprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOrgmemberprice() {
        return orgmemberprice;
    }

    public void setOrgmemberprice(Double orgmemberprice) {
        this.orgmemberprice = orgmemberprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
}