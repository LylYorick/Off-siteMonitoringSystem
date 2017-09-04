/**
 * 
 */
package org.work.web.dao.para;

/**
 * @作者 ThinkPad
 * @创建日期 Oct 13, 2010
 * @版本 work V1.0
 */
public interface IParaDao {

	Integer getReportEndDay(int reporttype);
	
	void updateEndDay(int reporttype,int endday);
}
