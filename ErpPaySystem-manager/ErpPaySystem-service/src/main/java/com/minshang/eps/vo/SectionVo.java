package com.minshang.eps.vo;

import java.util.Date;

public class SectionVo {
	/** 部门id */
	private Integer sectionid;
	/** 部门名 */
	private String sectionname;
	/** 组织id */
	private Integer orgid;
	/** 操作人 */
	private Integer createuser;
	/** 操作时间 */
	private Date createtime;
	/** 状态 0:正常；1：停用 **/
	private Byte state;
	/** 公司id */
	private Integer companyid;
	/** 公司名 */
	private String companyname;

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
		this.sectionname = sectionname;
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

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Override
	public String toString() {
		return "SectionVo [sectionid=" + sectionid + ", sectionname="
				+ sectionname + ", orgid=" + orgid + ", createuser="
				+ createuser + ", createtime=" + createtime + ", state="
				+ state + ", companyid=" + companyid + ", companyname="
				+ companyname + "]";
	}

	public SectionVo() {
		super();
	}

	public SectionVo(Integer sectionid, String sectionname, Integer orgid,
			Integer createuser, Date createtime, Byte state, Integer companyid,
			String companyname) {
		super();
		this.sectionid = sectionid;
		this.sectionname = sectionname;
		this.orgid = orgid;
		this.createuser = createuser;
		this.createtime = createtime;
		this.state = state;
		this.companyid = companyid;
		this.companyname = companyname;
	}

}
