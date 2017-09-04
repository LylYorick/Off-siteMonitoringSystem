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
public class Report2 extends ReportBase implements ExcelReport {

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
			sql="delete from ACTIVE where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			/**
			 * 修改主表
			 */
			sql="delete from ACTIVE where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			Iterator iterator = hssfsheet.rowIterator();
			int id;
			ResultSet rs;
			int i=0;
			while(iterator.hasNext())
			{
				HSSFRow row = (HSSFRow)iterator.next();
				if(row.getRowNum()>5 && (row.getCell(0)==null || "".equals(row.getCell(0).toString())))
					break;
				if (row.getRowNum()>5) {
					gs = new GenInsertScript();
					if(i==24)
					{
						System.out.println("aa");
					}
					gs.setTableName("ACTIVE");
					gs.add("ACTDATE", "".equals(row.getCell(0).getStringCellValue().trim())?"无":row.getCell(0).getStringCellValue().trim());
					gs.add("ACTCNT", "".equals(row.getCell(1).getStringCellValue().trim())?"无":row.getCell(1).getStringCellValue().trim());
					double value = "".equals(row.getCell(2).toString())?0:row.getCell(2).getNumericCellValue();
					gs.add("ACTNUM", String.valueOf(Integer.valueOf((int)value)));
					gs.add("ACTMTD","".equals(row.getCell(3).getStringCellValue().trim())?"无":row.getCell(3).getStringCellValue().trim());
					value = "".equals(row.getCell(4).toString())?0:row.getCell(4).getNumericCellValue();
					gs.add("ACTDATANUM", String.valueOf(Integer.valueOf((int)value)));
					gs.add("switchid", switchid);
					/*sql ="select max(PROID) from ACTIVE";
					rs = DButils.executeQuery(connection, sql);
					id=1;
					while(rs.next()){
						id=rs.getInt(1)+1;
					}
					gs.add("PROID", Integer.valueOf(id));*/
					DButils.executeSQL(connection, gs.getInsertSql());
					System.out.println(i+++":"+row.getCell(0).getStringCellValue().trim());
					isreport="1";
				}
			}
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
