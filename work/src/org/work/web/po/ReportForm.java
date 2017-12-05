package org.work.web.po;

public class ReportForm implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ref_id;
	private Information BOrgInformation;
	private String up_time;
	private String file_url;//
	private String file_name;
	private String file_type;
	private String up_user;
	private int cnt;
	/** full constructor */
	public ReportForm(Information bOrgInformation, String up_time,
			String file_url, String file_name, String file_type,
			String up_user, int cnt) {
		BOrgInformation = bOrgInformation;
		this.up_time = up_time;
		this.file_url = file_url;
		this.file_name = file_name;
		this.file_type = file_type;
		this.up_user = up_user;
		this.cnt = cnt;
	}
	/** default constructor */
	public ReportForm() {
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getRef_id() {
		return ref_id;
	}
	public void setRef_id(Integer ref_id) {
		this.ref_id = ref_id;
	}
	public Information getBOrgInformation() {
		return BOrgInformation;
	}
	public void setBOrgInformation(Information bOrgInformation) {
		BOrgInformation = bOrgInformation;
	}
	public String getUp_time() {
		return up_time;
	}
	public void setUp_time(String up_time) {
		this.up_time = up_time;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getUp_user() {
		return up_user;
	}
	public void setUp_user(String up_user) {
		this.up_user = up_user;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
