package com.minshang.eps.entity;

public class Error {
    private String errorcode;

    private String errorlvl;

    private String errormsg;

    private String remark;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode == null ? null : errorcode.trim();
    }

    public String getErrorlvl() {
        return errorlvl;
    }

    public void setErrorlvl(String errorlvl) {
        this.errorlvl = errorlvl == null ? null : errorlvl.trim();
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}