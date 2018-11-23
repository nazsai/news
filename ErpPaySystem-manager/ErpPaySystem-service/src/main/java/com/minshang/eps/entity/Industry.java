package com.minshang.eps.entity;


/**
 * 	业态表
 * @author Administrator
 *
 */
public class Industry {
    private Integer industryid;

    private String industryname;

    public Integer getIndustryid() {
        return industryid;
    }

    public void setIndustryid(Integer industryid) {
        this.industryid = industryid;
    }

    public String getIndustryname() {
        return industryname;
    }

    public void setIndustryname(String industryname) {
        this.industryname = industryname == null ? null : industryname.trim();
    }
}