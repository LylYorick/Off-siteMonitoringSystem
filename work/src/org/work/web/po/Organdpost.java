package org.work.web.po;

/**
 * Organdpost entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Organdpost implements java.io.Serializable {

	// Fields

	private Long oopid;
	private Reportswitch reportswitch;
	private String orgname;
	private String leadname;
	private String leadpos;
	private String leadtel;
	private String deptlead;
	private String deptleadtel;
	private String ftnum;
	private String ptnum;

	// Constructors

	/** default constructor */
	public Organdpost() {
	}

	/** minimal constructor */
	public Organdpost(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	/** full constructor */
	public Organdpost(Reportswitch reportswitch, String orgname,
			String leadname, String leadpos, String leadtel, String deptlead,
			String deptleadtel, String ftnum, String ptnum) {
		this.reportswitch = reportswitch;
		this.orgname = orgname;
		this.leadname = leadname;
		this.leadpos = leadpos;
		this.leadtel = leadtel;
		this.deptlead = deptlead;
		this.deptleadtel = deptleadtel;
		this.ftnum = ftnum;
		this.ptnum = ptnum;
	}

	// Property accessors

	public Long getOopid() {
		return this.oopid;
	}

	public void setOopid(Long oopid) {
		this.oopid = oopid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getLeadname() {
		return this.leadname;
	}

	public void setLeadname(String leadname) {
		this.leadname = leadname;
	}

	public String getLeadpos() {
		return this.leadpos;
	}

	public void setLeadpos(String leadpos) {
		this.leadpos = leadpos;
	}

	public String getLeadtel() {
		return this.leadtel;
	}

	public void setLeadtel(String leadtel) {
		this.leadtel = leadtel;
	}

	public String getDeptlead() {
		return this.deptlead;
	}

	public void setDeptlead(String deptlead) {
		this.deptlead = deptlead;
	}

	public String getDeptleadtel() {
		return this.deptleadtel;
	}

	public void setDeptleadtel(String deptleadtel) {
		this.deptleadtel = deptleadtel;
	}

	public String getFtnum() {
		return this.ftnum;
	}

	public void setFtnum(String ftnum) {
		this.ftnum = ftnum;
	}

	public String getPtnum() {
		return this.ptnum;
	}

	public void setPtnum(String ptnum) {
		this.ptnum = ptnum;
	}

}