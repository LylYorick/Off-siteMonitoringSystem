package org.work.web.po;

/**
 * Susreportflag entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Susreportflag implements java.io.Serializable {

	// Fields

	private Integer sbzid;
	private Reportswitch reportswitch;
	private Integer sbz1;
	private Double sbz2;
	private Integer sbz3;
	private Double sbz4;

	// Constructors

	/** default constructor */
	public Susreportflag() {
	}

	/** full constructor */
	public Susreportflag(Reportswitch reportswitch, Integer sbz1, Double sbz2,
			Integer sbz3, Double sbz4) {
		this.reportswitch = reportswitch;
		this.sbz1 = sbz1;
		this.sbz2 = sbz2;
		this.sbz3 = sbz3;
		this.sbz4 = sbz4;
	}

	// Property accessors

	public Integer getSbzid() {
		return this.sbzid;
	}

	public void setSbzid(Integer sbzid) {
		this.sbzid = sbzid;
	}

	public Reportswitch getReportswitch() {
		return this.reportswitch;
	}

	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}

	public Integer getSbz1() {
		return this.sbz1;
	}

	public void setSbz1(Integer sbz1) {
		this.sbz1 = sbz1;
	}

	public Double getSbz2() {
		return this.sbz2;
	}

	public void setSbz2(Double sbz2) {
		this.sbz2 = sbz2;
	}

	public Integer getSbz3() {
		return this.sbz3;
	}

	public void setSbz3(Integer sbz3) {
		this.sbz3 = sbz3;
	}

	public Double getSbz4() {
		return this.sbz4;
	}

	public void setSbz4(Double sbz4) {
		this.sbz4 = sbz4;
	}

}