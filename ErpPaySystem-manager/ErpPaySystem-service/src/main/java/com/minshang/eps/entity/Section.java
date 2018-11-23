package com.minshang.eps.entity;

import java.io.Serializable;
import java.util.Date;

public class Section implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**部门id*/
    private Integer sectionid;
    
    /**部门名*/
    private String sectionname;
    /**组织id*/
    private Integer orgid;
    /**操作人*/
    private Integer createuser;
    /**操作时间*/
    private Date createtime;
    /**状态 0:正常；1：停用 **/
    private Byte state;

    public Integer getSectionid() {
        return sectionid;
    }

    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname == null ? null : sectionname.trim();
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}