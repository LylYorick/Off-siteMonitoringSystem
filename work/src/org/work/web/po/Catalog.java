package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Catalog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String catname;
	private Set BOrgInformationhises = new HashSet(0);
	private Set BOrgInformations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catname, Set BOrgInformationhises,
			Set BOrgInformations) {
		this.catname = catname;
		this.BOrgInformationhises = BOrgInformationhises;
		this.BOrgInformations = BOrgInformations;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getCatname() {
		return this.catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}
	@JSON(serialize = false)
	public Set getBOrgInformationhises() {
		return this.BOrgInformationhises;
	}

	public void setBOrgInformationhises(Set BOrgInformationhises) {
		this.BOrgInformationhises = BOrgInformationhises;
	}

	@JSON(serialize = false)
	public Set getBOrgInformations() {
		return this.BOrgInformations;
	}

	public void setBOrgInformations(Set BOrgInformations) {
		this.BOrgInformations = BOrgInformations;
	}
	@JSON(serialize = false)
	public void getHibernateLazyInitializer(){
		
	}
}