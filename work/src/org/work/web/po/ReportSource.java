package org.work.web.po;

/**
 * Reportsource entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ReportSource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */

	private Integer rsid;
	private String rid;
	private String totalid;
	private String unit;
	private String date;
	private String sponsor;
	private String researchname;
	private Integer involvenum;
	private String amountSituation;
	private String isinvolved;
	private String antisponsor;
	private String paymentletterid;
	private String investigation;
	private String finaname;
	private Integer finannum;
	private String sendresearch;
	private Integer accountnum;
	private String feedbackdate;
	private String feedbackno;
	private String dealresult;
	private String recordeno;
	private String note;
	private String subjectname;
	private String idnumber;

	// Constructors

	/** default constructor */
	public ReportSource() {
	}

	/** full constructor */
	public ReportSource(String rid, String totalid, String unit, String date,
			String sponsor, String researchname, Integer involvenum,
			String amountSituation, String isinvolved, String antisponsor,
			String paymentletterid, String investigation, String finaname,
			Integer finannum, String sendresearch, Integer accountnum,
			String feedbackdate, String feedbackno, String dealresult,
			String recordeno, String note , String subjectname, String idnumber) {
		this.rid = rid;
		this.totalid = totalid;
		this.unit = unit;
		this.date = date;
		this.sponsor = sponsor;
		this.researchname = researchname;
		this.involvenum = involvenum;
		this.amountSituation = amountSituation;
		this.isinvolved = isinvolved;
		this.antisponsor = antisponsor;
		this.paymentletterid = paymentletterid;
		this.investigation = investigation;
		this.finaname = finaname;
		this.finannum = finannum;
		this.sendresearch = sendresearch;
		this.accountnum = accountnum;
		this.feedbackdate = feedbackdate;
		this.feedbackno = feedbackno;
		this.dealresult = dealresult;
		this.recordeno = recordeno;
		this.note = note;
		this.subjectname = subjectname;
		this.idnumber = idnumber;
	}

	// Property accessors

	public Integer getRsid() {
		return this.rsid;
	}

	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getTotalid() {
		return this.totalid;
	}

	public void setTotalid(String totalid) {
		this.totalid = totalid;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getResearchname() {
		return this.researchname;
	}

	public void setResearchname(String researchname) {
		this.researchname = researchname;
	}

	public Integer getInvolvenum() {
		return this.involvenum;
	}

	public void setInvolvenum(Integer involvenum) {
		this.involvenum = involvenum;
	}

	public String getAmountSituation() {
		return this.amountSituation;
	}

	public void setAmountSituation(String amountSituation) {
		this.amountSituation = amountSituation;
	}

	public String getIsinvolved() {
		return this.isinvolved;
	}

	public void setIsinvolved(String isinvolved) {
		this.isinvolved = isinvolved;
	}

	public String getAntisponsor() {
		return this.antisponsor;
	}

	public void setAntisponsor(String antisponsor) {
		this.antisponsor = antisponsor;
	}

	public String getPaymentletterid() {
		return this.paymentletterid;
	}

	public void setPaymentletterid(String paymentletterid) {
		this.paymentletterid = paymentletterid;
	}

	public String getInvestigation() {
		return this.investigation;
	}

	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}

	public String getFinaname() {
		return this.finaname;
	}

	public void setFinaname(String finaname) {
		this.finaname = finaname;
	}

	public Integer getFinannum() {
		return this.finannum;
	}

	public void setFinannum(Integer finannum) {
		this.finannum = finannum;
	}

	public String getSendresearch() {
		return this.sendresearch;
	}

	public void setSendresearch(String sendresearch) {
		this.sendresearch = sendresearch;
	}

	public Integer getAccountnum() {
		return this.accountnum;
	}

	public void setAccountnum(Integer accountnum) {
		this.accountnum = accountnum;
	}

	public String getFeedbackdate() {
		return this.feedbackdate;
	}

	public void setFeedbackdate(String feedbackdate) {
		this.feedbackdate = feedbackdate;
	}

	public String getFeedbackno() {
		return this.feedbackno;
	}

	public void setFeedbackno(String feedbackno) {
		this.feedbackno = feedbackno;
	}

	public String getDealresult() {
		return this.dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	public String getRecordeno() {
		return this.recordeno;
	}

	public void setRecordeno(String recordeno) {
		this.recordeno = recordeno;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

}