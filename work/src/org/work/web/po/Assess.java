package org.work.web.po;

/**
 * Assess entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Assess implements java.io.Serializable {

	// Fields

	private Integer assessid;
	private AssessIndex assessindex;
	private Information BOrgInformation;
	private String score;
	private String year;
	private String remark;
	private String selevalscore;
	private String selevalremark;
	

	// Constructors

	/** default constructor */
	public Assess() {
	}

	/** full constructor */
	public Assess(AssessIndex assessindex, Information BOrgInformation,
			String score, String year, String remark) {
		this.assessindex = assessindex;
		this.BOrgInformation = BOrgInformation;
		this.score = score;
		this.year = year;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAssessid() {
		return this.assessid;
	}

	public void setAssessid(Integer assessid) {
		this.assessid = assessid;
	}

	public AssessIndex getAssessindex() {
		return this.assessindex;
	}

	public void setAssessindex(AssessIndex assessindex) {
		this.assessindex = assessindex;
	}

	public Information getBOrgInformation() {
		return this.BOrgInformation;
	}

	public void setBOrgInformation(Information BOrgInformation) {
		this.BOrgInformation = BOrgInformation;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSelevalscore() {
		return selevalscore;
	}

	public void setSelevalscore(String selevalscore) {
		this.selevalscore = selevalscore;
	}

	public String getSelevalremark() {
		return selevalremark;
	}

	public void setSelevalremark(String selevalremark) {
		this.selevalremark = selevalremark;
	}

	@Override
	public String toString() {
		return "Assess [assessid=" + assessid + ", assessindex=" + assessindex
				+ ", BOrgInformation=" + BOrgInformation + ", score=" + score
				+ ", year=" + year + ", remark=" + remark + ", selevalscore="
				+ selevalscore + ", selevalremark=" + selevalremark + "]";
	}

}