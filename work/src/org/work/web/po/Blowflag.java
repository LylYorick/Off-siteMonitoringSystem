package org.work.web.po;

/**
 * Blowflag entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Blowflag implements java.io.Serializable {

	// Fields

	private Integer dzbid;
	private Reportswitch reportswitch;
	private Integer dz1;
	private Integer dz2;
	private Double dz3;
	private Integer dz4;
	private Double dz5;
	private Integer dz6;
	private Double dz7;
	private Integer dz8;
	private Double dz9;

	// Constructors

	/** default constructor */
	public Blowflag() {
	}

	/** full constructor */
	public Blowflag(Reportswitch reportswitch, Integer dz1, Integer dz2,
			Double dz3, Integer dz4, Double dz5, Integer dz6, Double dz7,
			Integer dz8, Double dz9) {
		this.reportswitch = reportswitch;
		this.dz1 = dz1;
		this.dz2 = dz2;
		this.dz3 = dz3;
		this.dz4 = dz4;
		this.dz5 = dz5;
		this.dz6 = dz6;
		this.dz7 = dz7;
		this.dz8 = dz8;
		this.dz9 = dz9;
	}

	// Property accessors

	public Integer getDzbid() {
		return this.dzbid;
	}

	public void setDzbid(Integer dzbid) {
		this.dzbid = dzbid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public Integer getDz1() {
		return this.dz1;
	}

	public void setDz1(Integer dz1) {
		this.dz1 = dz1;
	}

	public Integer getDz2() {
		return this.dz2;
	}

	public void setDz2(Integer dz2) {
		this.dz2 = dz2;
	}

	public Double getDz3() {
		return this.dz3;
	}

	public void setDz3(Double dz3) {
		this.dz3 = dz3;
	}

	public Integer getDz4() {
		return this.dz4;
	}

	public void setDz4(Integer dz4) {
		this.dz4 = dz4;
	}

	public Double getDz5() {
		return this.dz5;
	}

	public void setDz5(Double dz5) {
		this.dz5 = dz5;
	}

	public Integer getDz6() {
		return this.dz6;
	}

	public void setDz6(Integer dz6) {
		this.dz6 = dz6;
	}

	public Double getDz7() {
		return this.dz7;
	}

	public void setDz7(Double dz7) {
		this.dz7 = dz7;
	}

	public Integer getDz8() {
		return this.dz8;
	}

	public void setDz8(Integer dz8) {
		this.dz8 = dz8;
	}

	public Double getDz9() {
		return this.dz9;
	}

	public void setDz9(Double dz9) {
		this.dz9 = dz9;
	}

}