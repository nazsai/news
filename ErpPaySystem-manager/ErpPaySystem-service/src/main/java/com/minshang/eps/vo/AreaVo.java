package com.minshang.eps.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域Vo
 * @author Administrator
 *
 */
public class AreaVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**区域id */
	private Integer areaid;
    /**地区名 */
    private String areaname;
    /**品牌id */
    private Integer brandid;
    /**品牌名 */
    private String brandname;
    
    private Integer industryid;
    
    private String industryname;
    /**操作人id */
    private Integer userid;
    /**操作人 */
    private String username;
    /**创建时间 */
    private Date createtime;

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
		this.industryname = industryname;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
    
    
}
