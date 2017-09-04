package org.work.web.po;

import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bulletin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Bulletin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String date;
	private Date time;
	private String title;
	private Clob content;
	private String userid;
    private Set<Bulread> bulread = new HashSet<Bulread>();
	// Constructors

	public Set<Bulread> getBulread() {
		return bulread;
	}

	public void setBulread(Set<Bulread> bulread) {
		this.bulread = bulread;
	}

	/** default constructor */
	public Bulletin() {
	}

	/** full constructor */
	public Bulletin(String date, Date time, String title, Clob content,
			String userid) {
		this.date = date;
		this.time = time;
		this.title = title;
		this.content = content;
		this.userid = userid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Clob getContent() {
		return this.content;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}