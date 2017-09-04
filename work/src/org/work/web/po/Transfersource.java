package org.work.web.po;

/**
 * Transfersource entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Transfersource implements java.io.Serializable {

	// Fields

	private Integer tsid;
	private String tid;
	private String transfersymbol;
	private String subjectname;
	private String idnumber;
	private String sourcecase;
	private Double transferamout;
	private String transferdate;
	private String handledby;
	private String receivingunit;
	private String handledperson;
	private String isplacedonfile;
	private String dealresult;
	private String notes;

	// Constructors

	/** default constructor */
	public Transfersource() {
	}

	/** full constructor */
	public Transfersource(String tid, String transfersymbol,
			String subjectname, String sourcecase, Double transferamout,
			String transferdate, String handledby, String receivingunit,
			String handledperson, String isplacedonfile, String dealresult,
			String notes ,String idnumber) {
		this.tid = tid;
		this.transfersymbol = transfersymbol;
		this.subjectname = subjectname;
		this.sourcecase = sourcecase;
		this.transferamout = transferamout;
		this.transferdate = transferdate;
		this.handledby = handledby;
		this.receivingunit = receivingunit;
		this.handledperson = handledperson;
		this.isplacedonfile = isplacedonfile;
		this.dealresult = dealresult;
		this.notes = notes;
		this.idnumber = idnumber;
	}

	// Property accessors

	public Integer getTsid() {
		return this.tsid;
	}

	public void setTsid(Integer tsid) {
		this.tsid = tsid;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTransfersymbol() {
		return this.transfersymbol;
	}

	public void setTransfersymbol(String transfersymbol) {
		this.transfersymbol = transfersymbol;
	}

	public String getSubjectname() {
		return this.subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSourcecase() {
		return this.sourcecase;
	}

	public void setSourcecase(String sourcecase) {
		this.sourcecase = sourcecase;
	}

	public Double getTransferamout() {
		return this.transferamout;
	}

	public void setTransferamout(Double transferamout) {
		this.transferamout = transferamout;
	}

	public String getTransferdate() {
		return this.transferdate;
	}

	public void setTransferdate(String transferdate) {
		this.transferdate = transferdate;
	}

	public String getHandledby() {
		return this.handledby;
	}

	public void setHandledby(String handledby) {
		this.handledby = handledby;
	}

	public String getReceivingunit() {
		return this.receivingunit;
	}

	public void setReceivingunit(String receivingunit) {
		this.receivingunit = receivingunit;
	}

	public String getHandledperson() {
		return this.handledperson;
	}

	public void setHandledperson(String handledperson) {
		this.handledperson = handledperson;
	}

	public String getIsplacedonfile() {
		return this.isplacedonfile;
	}

	public void setIsplacedonfile(String isplacedonfile) {
		this.isplacedonfile = isplacedonfile;
	}

	public String getDealresult() {
		return this.dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

}