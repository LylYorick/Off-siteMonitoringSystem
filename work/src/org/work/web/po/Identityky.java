package org.work.web.po;

/**
 * Identityky entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Identityky implements java.io.Serializable {

	// Fields

	private Integer ppid;
	private Reportswitch reportswitch;
	private Integer pp1;
	private Integer pp2;
	private Integer pp3;
	private Integer pp4;

	// Constructors

	/** default constructor */
	public Identityky() {
	}

	/** full constructor */
	public Identityky(Reportswitch reportswitch, Integer pp1, Integer pp2,
			Integer pp3, Integer pp4) {
		this.reportswitch = reportswitch;
		this.pp1 = pp1;
		this.pp2 = pp2;
		this.pp3 = pp3;
		this.pp4 = pp4;
	}

	// Property accessors

	public Integer getPpid() {
		return this.ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public Integer getPp1() {
		return this.pp1;
	}

	public void setPp1(Integer pp1) {
		this.pp1 = pp1;
	}

	public Integer getPp2() {
		return this.pp2;
	}

	public void setPp2(Integer pp2) {
		this.pp2 = pp2;
	}

	public Integer getPp3() {
		return this.pp3;
	}

	public void setPp3(Integer pp3) {
		this.pp3 = pp3;
	}

	public Integer getPp4() {
		return this.pp4;
	}

	public void setPp4(Integer pp4) {
		this.pp4 = pp4;
	}

}