package com.minshang.eps.entity;

import java.util.Date;

public class Dishesdepot {
    private Integer dishesdepotid;

    private String dishesdepotname;

    private Integer orgid;

    private Integer createuser;

    private Date createtime;

    private Byte state;
    
    private String username;
    
    private String orgname;

    public Integer getDishesdepotid() {
        return dishesdepotid;
    }

    public void setDishesdepotid(Integer dishesdepotid) {
        this.dishesdepotid = dishesdepotid;
    }

    public String getDishesdepotname() {
        return dishesdepotname;
    }

    public void setDishesdepotname(String dishesdepotname) {
        this.dishesdepotname = dishesdepotname == null ? null : dishesdepotname.trim();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
}