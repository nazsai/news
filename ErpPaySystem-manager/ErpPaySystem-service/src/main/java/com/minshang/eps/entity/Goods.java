package com.minshang.eps.entity;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private String goodscode;

    private Integer goodstypeid;

    private String size;

    private Integer unitid;

    private Integer minstore;

    private Integer maxstore;

    private Byte state;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode == null ? null : goodscode.trim();
    }

    public Integer getGoodstypeid() {
        return goodstypeid;
    }

    public void setGoodstypeid(Integer goodstypeid) {
        this.goodstypeid = goodstypeid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getMinstore() {
        return minstore;
    }

    public void setMinstore(Integer minstore) {
        this.minstore = minstore;
    }

    public Integer getMaxstore() {
        return maxstore;
    }

    public void setMaxstore(Integer maxstore) {
        this.maxstore = maxstore;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}