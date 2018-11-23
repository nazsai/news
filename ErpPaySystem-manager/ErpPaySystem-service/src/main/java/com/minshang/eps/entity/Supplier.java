package com.minshang.eps.entity;

import java.util.Date;

public class Supplier {
    private Integer supplierid;

    private String suppliercode;

    private String suppliername;

    private String username;

    private String telphoneno;

    private Byte closetype;

    private String remark;

    private Integer createuser;

    private Date createtime;

    private Byte suppliertype;

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode == null ? null : suppliercode.trim();
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTelphoneno() {
        return telphoneno;
    }

    public void setTelphoneno(String telphoneno) {
        this.telphoneno = telphoneno == null ? null : telphoneno.trim();
    }

    public Byte getClosetype() {
        return closetype;
    }

    public void setClosetype(Byte closetype) {
        this.closetype = closetype;
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

    public Byte getSuppliertype() {
        return suppliertype;
    }

    public void setSuppliertype(Byte suppliertype) {
        this.suppliertype = suppliertype;
    }
}