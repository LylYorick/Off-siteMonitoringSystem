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
public class Report5 extends ReportBase implements ExcelReport {

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
			sql="delete from IDENTITY_SB where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			gs.setTableName("IDENTITY_SB");
			for (int k = 6; k <= 32; k++)
			{
				HSSFRow hssfrow = hssfsheet.getRow(k);
				for (int j = 3; j < 7; j++)
				{
					HSSFCell hssfcell = hssfrow.getCell((short) j);
					int index = (k-6)*4+(j-3)+1;
					double value = "".equals(hssfcell.toString())?0:hssfcell.getNumericCellValue();
					gs.add("n"+index, Integer.valueOf((int)value));
				}
			}
			gs.add("switchid", switchid);
			/*sql ="select max(kid) from IDENTITY_SB";
			ResultSet rs= DButils.executeQuery(connection, sql);
			int id=1;
			while(rs.next()){
				id=rs.getInt(1)+1;
			}
			gs.add("kid", Integer.valueOf(id));*/
			sql="delete from IDENTITY_SB where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			DButils.executeSQL(connection, gs.getInsertSql());
			isreport="1";
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
