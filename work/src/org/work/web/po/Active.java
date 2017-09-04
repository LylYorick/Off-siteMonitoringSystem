package org.work.web.po;

/**
 * Active entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Active implements java.io.Serializable {

	// Fields

	private Long proid;
	private Reportswitch reportswitch;
	private String actdate;
	private String actcnt;
	private String actnum;
	private String actmtd;
	private String actdatanum;

	// Constructors

	/** default constructor */
	public Active() {
	}

	/** full constructor */
	public Active(Reportswitch reportswitch, String actdate, String actcnt,
			String actnum, String actmtd, String actdatanum) {
		this.reportswitch = reportswitch;
		this.actdate = actdate;
		this.actcnt = actcnt;
		this.actnum = actnum;
		this.actmtd = actmtd;
		this.actdatanum = actdatanum;
	}

	// Property accessors

	public Long getProid() {
		return this.proid;
	}

	public void setProid(Long proid) {
		this.proid = proid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getActdate() {
		return this.actdate;
	}

	public void setActdate(String actdate) {
		this.actdate = actdate;
	}

	public String getActcnt() {
		return this.actcnt;
	}

	public void setActcnt(String actcnt) {
		this.actcnt = actcnt;
	}

	public String getActnum() {
		return this.actnum;
	}

	public void setActnum(String actnum) {
		this.actnum = actnum;
	}

	public String getActmtd() {
		return this.actmtd;
	}

	public void setActmtd(String actmtd) {
		this.actmtd = actmtd;
	}

	public String getActdatanum() {
		return this.actdatanum;
	}

	public void setActdatanum(String actdatanum) {
		this.actdatanum = actdatanum;
	}

}