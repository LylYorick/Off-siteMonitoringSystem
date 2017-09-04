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
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.work.test.DButils;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class Report0 extends ReportBase implements ExcelReport {

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
			sql="delete from INNERCONTROL where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			/**
			 * 修改主表
			 */
			sql="delete from INNERCONTROL where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			Iterator iterator = hssfsheet.rowIterator();
			int id;
			ResultSet rs;
			while(iterator.hasNext())
			{
				HSSFRow row = (HSSFRow)iterator.next();
				if(row.getRowNum()>5 && (row.getCell(0)==null || "".equals(row.getCell(0).toString())))
					break;
				if (row.getRowNum()>5) {
					gs = new GenInsertScript();
					gs.setTableName("INNERCONTROL");
					gs.add("INAME", "".equals(row.getCell(0).getStringCellValue().trim())?"无":row.getCell(0).getStringCellValue().trim());
					gs.add("ICONTENT", "".equals(row.getCell(1).getStringCellValue().trim())?"无":row.getCell(1).getStringCellValue().trim());
					gs.add("IDEPT", "".equals(row.getCell(2).getStringCellValue().trim())?"无":row.getCell(2).getStringCellValue().trim());
					gs.add("ITIME", String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(3).getDateCellValue())));
					gs.add("FILENB", "".equals(row.getCell(4).getStringCellValue().trim())?"无":row.getCell(4).getStringCellValue().trim());
					gs.add("switchid", switchid);
					/*sql ="select max(innerid) from INNERCONTROL";
					rs = DButils.executeQuery(connection, sql);
					id=1;
					while(rs.next()){
						id=rs.getInt(1)+1;
					}
					gs.add("innerid", Integer.valueOf(id));*/
					DButils.executeSQL(connection, gs.getInsertSql());
					isreport="1";
				}
			}
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
