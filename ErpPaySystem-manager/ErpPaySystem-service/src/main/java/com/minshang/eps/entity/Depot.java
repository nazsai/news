package com.minshang.eps.entity;

import java.util.Date;

public class Depot {
    private Integer depotid;

    private String depotcode;

    private String depotname;

    private Integer createuser;

    private Date createtime;

    private Byte depotype;

    public Integer getDepotid() {
        return depotid;
    }

    public void setDepotid(Integer depotid) {
        this.depotid = depotid;
    }

    public String getDepotcode() {
        return depotcode;
    }

    public void setDepotcode(String depotcode) {
        this.depotcode = depotcode == null ? null : depotcode.trim();
    }

    public String getDepotname() {
        return depotname;
    }

    public void setDepotname(String depotname) {
        this.depotname = depotname == null ? null : depotname.trim();
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

    public Byte getDepotype() {
        return depotype;
    }

    public void setDepotype(Byte depotype) {
        this.depotype = depotype;
    }
}