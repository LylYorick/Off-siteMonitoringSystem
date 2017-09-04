package org.work.web.po;

/**
 * Activesource entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ActiveSource implements java.io.Serializable {

	// Fields

	private Integer asid;
	private String aid;
	private String totalid;
	private String surveyname;
	private Integer involvenum;
	private String source;
	private String date;
	private String sponsor;
	private String amountSituation;
	private String isinvolved;
	private String letterid;
	private String antisponsor;
	private String paymentletterid;
	private String investigation;
	private String approvalno;
	private String finaname;
	private Integer finannum;
	private String sendresearch;
	private Integer accountnum;
	private String feedbackdate;
	private String feedbackno;
	private String dealresult;
	private String recordeno;
	private String notes;
	private String subjectname;
	private String idnumber;
	
	// Constructors

	/** default constructor */
	public ActiveSource() {
	}

	/** full constructor */
	public ActiveSource(String aid, String totalid, String surveyname,
			Integer involvenum, String source, String date, String sponsor,
			String amountSituation, String isinvolved, String letterid,
			String antisponsor, String paymentletterid, String investigation,
			String approvalno, String finaname, Integer finannum,
			String sendresearch, Integer accountnum, String feedbackdate,
			String feedbackno, String dealresult, String recordeno, String notes,
			String subjectname,String idnumber) {
		this.aid = aid;
		this.totalid = totalid;
		this.surveyname = surveyname;
		this.involvenum = involvenum;
		this.source = source;
		this.date = date;
		this.sponsor = sponsor;
		this.amountSituation = amountSituation;
		this.isinvolved = isinvolved;
		this.letterid = letterid;
		this.antisponsor = antisponsor;
		this.paymentletterid = paymentletterid;
		this.investigation = investigation;
		this.approvalno = approvalno;
		this.finaname = finaname;
		this.finannum = finannum;
		this.sendresearch = sendresearch;
		this.accountnum = accountnum;
		this.feedbackdate = feedbackdate;
		this.feedbackno = feedbackno;
		this.dealresult = dealresult;
		this.recordeno = recordeno;
		this.notes = notes;
		this.subjectname = subjectname;
		this.idnumber = idnumber;
	}

	// Property accessors

	public Integer getAsid() {
		return this.asid;
	}

	public void setAsid(Integer asid) {
		this.asid = asid;
	}

	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getTotalid() {
		return this.totalid;
	}

	public void setTotalid(String totalid) {
		this.totalid = totalid;
	}

	public String getSurveyname() {
		return this.surveyname;
	}

	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}

	public Integer getInvolvenum() {
		return this.involvenum;
	}

	public void setInvolvenum(Integer involvenum) {
		this.involvenum = involvenum;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public String getLetterid() {
		return this.letterid;
	}

	public void setLetterid(String letterid) {
		this.letterid = letterid;
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

	public String getApprovalno() {
		return this.approvalno;
	}

	public void setApprovalno(String approvalno) {
		this.approvalno = approvalno;
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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