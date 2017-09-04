package org.work.web.po;

/**
 * Inneraudit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Inneraudit implements java.io.Serializable {

	// Fields

	private Long audid;
	private Reportswitch reportswitch;
	private String auddept;
	private String audprid;
	private String audcnt;
	private String audprbm;
	private String audmod;

	// Constructors

	/** default constructor */
	public Inneraudit() {
	}

	/** full constructor */
	public Inneraudit(Reportswitch reportswitch, String auddept,
			String audprid, String audcnt, String audprbm, String audmod) {
		this.reportswitch = reportswitch;
		this.auddept = auddept;
		this.audprid = audprid;
		this.audcnt = audcnt;
		this.audprbm = audprbm;
		this.audmod = audmod;
	}

	// Property accessors

	public Long getAudid() {
		return this.audid;
	}

	public void setAudid(Long audid) {
		this.audid = audid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getAuddept() {
		return this.auddept;
	}

	public void setAuddept(String auddept) {
		this.auddept = auddept;
	}

	public String getAudprid() {
		return this.audprid;
	}

	public void setAudprid(String audprid) {
		this.audprid = audprid;
	}

	public String getAudcnt() {
		return this.audcnt;
	}

	public void setAudcnt(String audcnt) {
		this.audcnt = audcnt;
	}

	public String getAudprbm() {
		return this.audprbm;
	}

	public void setAudprbm(String audprbm) {
		this.audprbm = audprbm;
	}

	public String getAudmod() {
		return this.audmod;
	}

	public void setAudmod(String audmod) {
		this.audmod = audmod;
	}

}