package com.minshang.eps.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 品牌Vo
 * @author Administrator
 *
 */
public class BrandVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**品牌id */
	private Integer brandid;
	/**业态id */
    private Integer industryid;
    /**业态名称 */
    private String industryname;
    /**品牌名 */
    private String brandname;
    /**创建者id */
    private Integer createuser;
    /**创建者名 */
    private String username;
    /**创建时间 */
    private Date createtime;
    /**修改时间 */
    private Date modifytime;
    /**状态 */
    private Byte state;
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
	public String getIndustryname() {
		return industryname;
	}
	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Integer getCreateuser() {
		return createuser;
	}
	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
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
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public Byte getState() {
		return state;
	}
	public void setState(Byte state) {
		this.state = state;
	}
    
    
    
	
}
