package com.minshang.eps.entity;

import java.util.Date;

public class Goodstype {
    private Integer goodstypeid;

    private String goodstypename;

    private String goodstypecode;

    private Integer parentgoodstypeid;

    private Integer createuser;

    private Date createtime;

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public String getGoodstypename() {
        return goodstypename;
    }

    public void setGoodstypename(String goodstypename) {
        this.goodstypename = goodstypename == null ? null : goodstypename.trim();
    }

    public String getGoodstypecode() {
        return goodstypecode;
    }

    public void setGoodstypecode(String goodstypecode) {
        this.goodstypecode = goodstypecode == null ? null : goodstypecode.trim();
    }

    public Integer getParentgoodstypeid() {
        return parentgoodstypeid;
    }

    public void setParentgoodstypeid(Integer parentgoodstypeid) {
        this.parentgoodstypeid = parentgoodstypeid;
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
}