package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * AssessIndex entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AssessIndex implements java.io.Serializable {

	// Fields

	private Integer acsid;
	private String ascproject;
	private String ascdesc;
	private String ascadd;
	private String asccut;
	private String ascremark;
	private String ascfiled;
	private Integer ascpid;
	private Set assesses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AssessIndex() {
	}

	/** full constructor */
	public AssessIndex(String ascproject, String ascdesc, String ascadd,
			String asccut, String ascremark, String ascfiled, Integer ascpid,
			Set assesses) {
		this.ascproject = ascproject;
		this.ascdesc = ascdesc;
		this.ascadd = ascadd;
		this.asccut = asccut;
		this.ascremark = ascremark;
		this.ascfiled = ascfiled;
		this.ascpid = ascpid;
		this.assesses = assesses;
	}

	// Property accessors

	public Integer getAcsid() {
		return this.acsid;
	}

	public void setAcsid(Integer acsid) {
		this.acsid = acsid;
	}

	public String getAscproject() {
		return this.ascproject;
	}

	public void setAscproject(String ascproject) {
		this.ascproject = ascproject;
	}

	public String getAscdesc() {
		return this.ascdesc;
	}

	public void setAscdesc(String ascdesc) {
		this.ascdesc = ascdesc;
	}

	public String getAscadd() {
		return this.ascadd;
	}

	public void setAscadd(String ascadd) {
		this.ascadd = ascadd;
	}

	public String getAsccut() {
		return this.asccut;
	}

	public void setAsccut(String asccut) {
		this.asccut = asccut;
	}

	public String getAscremark() {
		return this.ascremark;
	}

	public void setAscremark(String ascremark) {
		this.ascremark = ascremark;
	}

	public String getAscfiled() {
		return this.ascfiled;
	}

	public void setAscfiled(String ascfiled) {
		this.ascfiled = ascfiled;
	}

	public Integer getAscpid() {
		return this.ascpid;
	}

	public void setAscpid(Integer ascpid) {
		this.ascpid = ascpid;
	}

	@JSON(serialize = false)
	public Set getAssesses() {
		return this.assesses;
	}

	public void setAssesses(Set assesses) {
		this.assesses = assesses;
	}

}