package com.minshang.eps.vo;

import java.util.Date;

/**
 * 角色vo
 * 
 * @author admin
 * 
 */
public class UserVo {

	/** userid */
	private Integer userid;
	/** 登陆名 */
	private String usercode;
	/** 姓名 */
	private String username;
	/** 密码 */
	private String password;
	/** 手机号 */
	private String phoneno;
	/** 性别(0男，1女) */
	private Byte sex;
	/** 创建时间 */
	private Date createtime;
	/** 修改时间 */
	private Date modifytime;
	/** 到期时间 */
	private Date expiretime;
	/** 状态（0，正常1，锁定） */
	private Byte state;
	/** 创建人 */
	private Long createuserid;
	/** 机构id */
	private Integer companyid;
	/** 机构名 */
	private String companyname;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Date getExpiretime() {
		return expiretime;
	}

	public void setExpiretime(Date expiretime) {
		this.expiretime = expiretime;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Long getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Long createuserid) {
		this.createuserid = createuserid;
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
		return "UserVo [userid=" + userid + ", usercode=" + usercode
				+ ", username=" + username + ", password=" + password
				+ ", phoneno=" + phoneno + ", sex=" + sex + ", createtime="
				+ createtime + ", modifytime=" + modifytime + ", expiretime="
				+ expiretime + ", state=" + state + ", createuserid="
				+ createuserid + ", companyid=" + companyid + ", companyname="
				+ companyname + "]";
	}

	public UserVo() {
		super();
	}

	public UserVo(Integer userid, String usercode, String username,
			String password, String phoneno, Byte sex, Date createtime,
			Date modifytime, Date expiretime, Byte state, Long createuserid,
			Integer companyid, String companyname) {
		super();
		this.userid = userid;
		this.usercode = usercode;
		this.username = username;
		this.password = password;
		this.phoneno = phoneno;
		this.sex = sex;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.expiretime = expiretime;
		this.state = state;
		this.createuserid = createuserid;
		this.companyid = companyid;
		this.companyname = companyname;
	}

}
