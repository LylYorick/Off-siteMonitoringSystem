package org.work.web.po;

/**
 * Innerauditflag entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Innerauditflag implements java.io.Serializable {

	// Fields

	private Integer iaid;
	private Reportswitch reportswitch;
	private String ia1;
	private String ia2;
	private String ia3;
	private String ia4;
	private String ia5;
	private String ia6;

	// Constructors

	/** default constructor */
	public Innerauditflag() {
	}

	/** full constructor */
	public Innerauditflag(Reportswitch reportswitch, String ia1, String ia2,
			String ia3, String ia4, String ia5, String ia6) {
		this.reportswitch = reportswitch;
		this.ia1 = ia1;
		this.ia2 = ia2;
		this.ia3 = ia3;
		this.ia4 = ia4;
		this.ia5 = ia5;
		this.ia6 = ia6;
	}

	// Property accessors

	public Integer getIaid() {
		return this.iaid;
	}

	public void setIaid(Integer iaid) {
		this.iaid = iaid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public String getIa1() {
		return this.ia1;
	}

	public void setIa1(String ia1) {
		this.ia1 = ia1;
	}

	public String getIa2() {
		return this.ia2;
	}

	public void setIa2(String ia2) {
		this.ia2 = ia2;
	}

	public String getIa3() {
		return this.ia3;
	}

	public void setIa3(String ia3) {
		this.ia3 = ia3;
	}

	public String getIa4() {
		return this.ia4;
	}

	public void setIa4(String ia4) {
		this.ia4 = ia4;
	}

	public String getIa5() {
		return this.ia5;
	}

	public void setIa5(String ia5) {
		this.ia5 = ia5;
	}

	public String getIa6() {
		return this.ia6;
	}

	public void setIa6(String ia6) {
		this.ia6 = ia6;
	}

}