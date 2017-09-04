package org.work.web.po;

/**
 * Checkroster entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CheckRoster implements java.io.Serializable {

	// Fields

	private Integer crid;
	private String sid;
	private String checkid;
	private String description;
	private String content;
	private String senddate;
	private String unit;
	private String handledby;
	private String backdate;
	private String note;
	private String subjectname;
	private String idnumber;

	// Constructors

	/** default constructor */
	public CheckRoster() {
	}

	/** full constructor */
	public CheckRoster(String sid, String checkid, String description,
			String content, String senddate, String unit, String handledby,
			String backdate, String note, String subjectname, String idnumber) {
		this.sid = sid;
		this.checkid = checkid;
		this.description = description;
		this.content = content;
		this.senddate = senddate;
		this.unit = unit;
		this.handledby = handledby;
		this.backdate = backdate;
		this.note = note;
		this.subjectname = subjectname;
		this.idnumber = idnumber;
	}

	// Property accessors

	public Integer getCrid() {
		return this.crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCheckid() {
		return this.checkid;
	}

	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSenddate() {
		return this.senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getHandledby() {
		return this.handledby;
	}

	public void setHandledby(String handledby) {
		this.handledby = handledby;
	}

	public String getBackdate() {
		return this.backdate;
	}

	public void setBackdate(String backdate) {
		this.backdate = backdate;
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