package org.work.web.po;

/**
 * upload entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Upload implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Information BOrgInformation;
	private String filename;
	private String updatetime;
	private String updateuser;
	private Integer cnt;

	// Constructors

	/** default constructor */
	public Upload() {
	}

	/** full constructor */
	public Upload(Information BOrgInformation, String filename,
			String updatetime, String updateuser,Integer cnt) {
		this.BOrgInformation = BOrgInformation;
		this.filename = filename;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.cnt = cnt;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Information getBOrgInformation() {
		return this.BOrgInformation;
	}

	public void setBOrgInformation(Information BOrgInformation) {
		this.BOrgInformation = BOrgInformation;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuser() {
		return this.updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	

}