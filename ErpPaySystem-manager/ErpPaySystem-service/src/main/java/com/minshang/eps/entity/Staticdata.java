package com.minshang.eps.entity;

public class Staticdata {
    private Integer staticdataid;

    private Integer statictypeid;

    private String staticdataname;

    private Integer staticdatavalue;

    public Integer getStaticdataid() {
        return staticdataid;
    }

    public void setStaticdataid(Integer staticdataid) {
        this.staticdataid = staticdataid;
    }

    public Integer getStatictypeid() {
        return statictypeid;
    }

    public void setStatictypeid(Integer statictypeid) {
        this.statictypeid = statictypeid;
    }

    public String getStaticdataname() {
        return staticdataname;
    }

    public void setStaticdataname(String staticdataname) {
        this.staticdataname = staticdataname == null ? null : staticdataname.trim();
    }

    public Integer getStaticdatavalue() {
        return staticdatavalue;
    }

    public void setStaticdatavalue(Integer staticdatavalue) {
        this.staticdatavalue = staticdatavalue;
    }
}