package com.minshang.eps.vo;

import java.io.Serializable;
import java.util.Date;

public class ShopVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer shopid;
	
	private String shopname;
	
	private Integer brandid;
	 
	private String brandname;
	
	private Integer areaid;
	 
	private String areaname;
	
	private Byte shoptype;
	
	private Integer industryid;
	
	private String industryname;
	
	private Integer userid;
	
	private String username;
	
	private Date createtime;
	
	private Integer state;
	
	private Integer shopmoudleid;
	
	private String shopmoudlename;

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Byte getShoptype() {
		return shoptype;
	}

	public void setShoptype(Byte shoptype) {
		this.shoptype = shoptype;
	}

	public String getIndustryname() {
		return industryname;
	}

	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getShopmoudlename() {
		return shopmoudlename;
	}

	public void setShopmoudlename(String shopmoudlename) {
		this.shopmoudlename = shopmoudlename;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public Integer getIndustryid() {
		return industryid;
	}

	public void setIndustryid(Integer industryid) {
		this.industryid = industryid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getShopmoudleid() {
		return shopmoudleid;
	}

	public void setShopmoudleid(Integer shopmoudleid) {
		this.shopmoudleid = shopmoudleid;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
	
}
