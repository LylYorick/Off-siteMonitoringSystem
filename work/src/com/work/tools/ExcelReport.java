/**
 * 
 */
package com.work.tools;

import java.io.File;
import java.sql.SQLException;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public interface ExcelReport {

	/**
	 *  解析xls，导入到相应报表
	 * @param xls
	 */
	public void insertInto(File xls, ExcelType excelType) throws SQLException ;

}
