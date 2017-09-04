/**
 * 
 */
package com.work.tools;

import org.work.web.exception.ServiceException;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class ExcelType {

	private String orgid;
	private String type;
	private String year;
	private String quater;
	private String source;
	private ExcelType(){};
	public ExcelType(String filename){
		if (filename.length()!=25) {
			throw new ServiceException(filename+"：文件名长度不是25位");
		}
		orgid=filename.substring(0,15);
		type=filename.substring(15,16);
		year=filename.substring(16,20);
		quater=filename.substring(20,21);
		source=filename.substring(21,22);
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuater() {
		return quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
