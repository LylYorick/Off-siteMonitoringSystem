package org.work.web.po;

/**
 * Tai entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Tai implements java.io.Serializable {

	// Fields

	private Integer taidi;
	private String taidate;
	private String taireason;
	private String taiauthor;
	private Information BOrgInformation;

	// Constructors

	/** default constructor */
	public Tai() {
	}


	// Property accessors

	public Information getBOrgInformation() {
		return BOrgInformation;
	}


	public void setBOrgInformation(Information orgInformation) {
		BOrgInformation = orgInformation;
	}


	public String getTaiauthor() {
		return taiauthor;
	}


	public void setTaiauthor(String taiauthor) {
		this.taiauthor = taiauthor;
	}


	/**
	 * @param taidi
	 * @param taidate
	 * @param taireason
	 * @param taiauthor
	 * @param orgInformation
	 */
	public Tai(Integer taidi, String taidate, String taireason,
			String taiauthor, Information orgInformation) {
		super();
		this.taidi = taidi;
		this.taidate = taidate;
		this.taireason = taireason;
		this.taiauthor = taiauthor;
		BOrgInformation = orgInformation;
	}


	public Integer getTaidi() {
		return this.taidi;
	}

	public void setTaidi(Integer taidi) {
		this.taidi = taidi;
	}

	public String getTaidate() {
		return this.taidate;
	}

	public void setTaidate(String taidate) {
		this.taidate = taidate;
	}

	public String getTaireason() {
		return this.taireason;
	}

	public void setTaireason(String taireason) {
		this.taireason = taireason;
	}

}