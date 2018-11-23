package com.minshang.eps.entity;

public class Statictype {
    private Integer statictypeid;

    private String statictypename;

    public Integer getStatictypeid() {
        return statictypeid;
    }

    public void setStatictypeid(Integer statictypeid) {
        this.statictypeid = statictypeid;
    }

    public String getStatictypename() {
        return statictypename;
    }

    public void setStatictypename(String statictypename) {
        this.statictypename = statictypename == null ? null : statictypename.trim();
    }
}