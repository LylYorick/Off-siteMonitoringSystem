package org.work.web.po;

/**
 * Innerflag entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Innerflag implements java.io.Serializable {

	// Fields

	private Integer ibid;
	private Reportswitch reportswitch;
	private String dscpt;

	// Constructors

	/** default constructor */
	public Innerflag() {
	}

	/** full constructor */
	public Innerflag(Reportswitch reportswitch, String dscpt) {
		this.reportswitch = reportswitch;
		this.dscpt = dscpt;
	}

	// Property accessors

	public Integer getIbid() {
		return this.ibid;
	}

	public void setIbid(Integer ibid) {
		this.ibid = ibid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getDscpt() {
		return this.dscpt;
	}

	public void setDscpt(String dscpt) {
		this.dscpt = dscpt;
	}

}