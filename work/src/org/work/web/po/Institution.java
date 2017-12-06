package org.work.web.po;

public class Institution implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ins_id;
	private Archives archives;
	private String up_time;
	private String file_url;//
	private String file_name;
	private String file_type;
	private String up_user;
	private int cnt;
	
	/** default constructor */
	public Institution() {
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIns_id() {
		return ins_id;
	}
	public void setIns_id(Integer ins_id) {
		this.ins_id = ins_id;
	}
	
	public Archives getArchives() {
		return archives;
	}
	public void setArchives(Archives archives) {
		this.archives = archives;
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
