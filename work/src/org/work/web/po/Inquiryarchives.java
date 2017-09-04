package org.work.web.po;

/**
 * Inquiryarchives entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Inquiryarchives implements java.io.Serializable {

	// Fields

	private Integer iaid;
	private String orgname;
	private String date;
	private String approvalid;
	private String letterid;
	private String lettertime;
	private String feedbacktime;
	private String realtime;
	private String subjectname;
	private String idnumber;

	// Constructors

	/** default constructor */
	public Inquiryarchives() {
	}

	/** full constructor */
	public Inquiryarchives(String orgname, String date,
			String approvalid, String letterid, String lettertime,
			String feedbacktime, String realtime, String subjectname,
			String idnumber) {
		this.orgname = orgname;
		this.date = date;
		this.approvalid = approvalid;
		this.letterid = letterid;
		this.lettertime = lettertime;
		this.feedbacktime = feedbacktime;
		this.realtime = realtime;
		this.subjectname = subjectname;
		this.idnumber = idnumber;
	}

	// Property accessors

	public Integer getIaid() {
		return this.iaid;
	}

	public void setIaid(Integer iaid) {
		this.iaid = iaid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getApprovalid() {
		return this.approvalid;
	}

	public void setApprovalid(String approvalid) {
		this.approvalid = approvalid;
	}

	public String getLetterid() {
		return this.letterid;
	}

	public void setLetterid(String letterid) {
		this.letterid = letterid;
	}

	public String getLettertime() {
		return this.lettertime;
	}

	public void setLettertime(String lettertime) {
		this.lettertime = lettertime;
	}

	public String getFeedbacktime() {
		return this.feedbacktime;
	}

	public void setFeedbacktime(String feedbacktime) {
		this.feedbacktime = feedbacktime;
	}

	public String getRealtime() {
		return this.realtime;
	}

	public void setRealtime(String realtime) {
		this.realtime = realtime;
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