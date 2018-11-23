package com.minshang.eps.entity;

public class Practice {
    private Integer practiceid;

    private String practicename;

    private Byte addpricetype;

    private Double proportion;

    private Double fixprice;

    public Integer getPracticeid() {
        return practiceid;
    }

    public void setPracticeid(Integer practiceid) {
        this.practiceid = practiceid;
    }

    public String getPracticename() {
        return practicename;
    }

    public void setPracticename(String practicename) {
        this.practicename = practicename == null ? null : practicename.trim();
    }

    public Byte getAddpricetype() {
        return addpricetype;
    }

    public void setAddpricetype(Byte addpricetype) {
        this.addpricetype = addpricetype;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Double getFixprice() {
        return fixprice;
    }

    public void setFixprice(Double fixprice) {
        this.fixprice = fixprice;
    }
}