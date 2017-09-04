package org.work.web.po;

import java.util.Date;

/**
 * Bulread entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Bulread implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer bulletinid;
	private String userid;
	private String isread;
	private Date time;

	// Constructors

	/** default constructor */
	public Bulread() {
	}

	/** full constructor */
	public Bulread(Integer bulletinid, String userid, String isread, Date time) {
		this.bulletinid = bulletinid;
		this.userid = userid;
		this.isread = isread;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBulletinid() {
		return this.bulletinid;
	}

	public void setBulletinid(Integer bulletinid) {
		this.bulletinid = bulletinid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIsread() {
		return this.isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}