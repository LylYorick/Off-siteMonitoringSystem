package org.work.web.po;

/**
 * Publics entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Publics implements java.io.Serializable {

	// Fields

	private Integer xpid;
	private Reportswitch reportswitch;
	private String xp1;
	private String xp2;
	private String xp3;
	private String xp4;
	private String xp5;

	// Constructors

	/** default constructor */
	public Publics() {
	}

	/** full constructor */
	public Publics(Reportswitch reportswitch, String xp1, String xp2,
			String xp3, String xp4, String xp5) {
		this.reportswitch = reportswitch;
		this.xp1 = xp1;
		this.xp2 = xp2;
		this.xp3 = xp3;
		this.xp4 = xp4;
		this.xp5 = xp5;
	}

	// Property accessors

	public Integer getXpid() {
		return this.xpid;
	}

	public void setXpid(Integer xpid) {
		this.xpid = xpid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getXp1() {
		return this.xp1;
	}

	public void setXp1(String xp1) {
		this.xp1 = xp1;
	}

	public String getXp2() {
		return this.xp2;
	}

	public void setXp2(String xp2) {
		this.xp2 = xp2;
	}

	public String getXp3() {
		return this.xp3;
	}

	public void setXp3(String xp3) {
		this.xp3 = xp3;
	}

	public String getXp4() {
		return this.xp4;
	}

	public void setXp4(String xp4) {
		this.xp4 = xp4;
	}

	public String getXp5() {
		return this.xp5;
	}

	public void setXp5(String xp5) {
		this.xp5 = xp5;
	}

}