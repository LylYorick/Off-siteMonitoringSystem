package org.work.web.po;

/**
 * Innercontrol entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Innercontrol implements java.io.Serializable {

	// Fields

	private Long innerid;
	private Reportswitch reportswitch;
	private String iname;
	private String icontent;
	private String idept;
	private String itime;
	private String filenb;

	// Constructors

	/** default constructor */
	public Innercontrol() {
	}

	/** full constructor */
	public Innercontrol(Reportswitch reportswitch, String iname,
			String icontent, String idept, String itime, String filenb) {
		this.reportswitch = reportswitch;
		this.iname = iname;
		this.icontent = icontent;
		this.idept = idept;
		this.itime = itime;
		this.filenb = filenb;
	}

	// Property accessors

	public Long getInnerid() {
		return this.innerid;
	}

	public void setInnerid(Long innerid) {
		this.innerid = innerid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getIname() {
		return this.iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getIcontent() {
		return this.icontent;
	}

	public void setIcontent(String icontent) {
		this.icontent = icontent;
	}

	public String getIdept() {
		return this.idept;
	}

	public void setIdept(String idept) {
		this.idept = idept;
	}

	public String getItime() {
		return this.itime;
	}

	public void setItime(String itime) {
		this.itime = itime;
	}

	public String getFilenb() {
		return this.filenb;
	}

	public void setFilenb(String filenb) {
		this.filenb = filenb;
	}

}