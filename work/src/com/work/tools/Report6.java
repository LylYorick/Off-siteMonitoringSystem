/**
 * 
 */
package com.work.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.work.test.DButils;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class Report6 extends ReportBase implements ExcelReport {

	public void insertInto(File xls,ExcelType excelType) throws SQLException {
		Integer switchid= getSwitchId(excelType);
		Connection connection=DButils.getConnection();
		String sql;
		String isreport="";
		HSSFWorkbook hssfworkbook = null;
		try {
			hssfworkbook =new HSSFWorkbook(new FileInputStream(xls));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);
		if(ZEROFLAGYES.equals(hssfsheet.getRow(2).getCell(7).getStringCellValue())){
			updateZero(switchid);
			sql="delete from IDENTITY_RSB where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			gs.setTableName("IDENTITY_RSB");
			for (int k = 7; k <= 20; k++)
			{
				HSSFRow hssfrow = hssfsheet.getRow(k);
				for (int j = 1; j < 6; j++)
				{
					HSSFCell hssfcell = hssfrow.getCell((short) j);
					int index = (k-7)*5+j;
					double value = "".equals(hssfcell.toString())?0:hssfcell.getNumericCellValue();
					gs.add("r"+index, Integer.valueOf((int)value));
				}
			}
			gs.add("switchid", switchid);
			/*sql ="select max(rkid) from IDENTITY_RSB";
			ResultSet rs= DButils.executeQuery(connection, sql);
			int id=1;
			while(rs.next()){
				id=rs.getInt(1)+1;
			}
			gs.add("rkid", Integer.valueOf(id));*/
			sql="delete from IDENTITY_RSB where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			DButils.executeSQL(connection, gs.getInsertSql());
			isreport="1";
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
