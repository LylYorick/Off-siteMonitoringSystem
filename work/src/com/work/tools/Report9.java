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
public class Report9 extends ReportBase implements ExcelReport {

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
			sql="delete from Publics where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			sql="delete from Blowflag where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			/**
			 * 修改标注表
			 */
			gs.setTableName("Blowflag");
			double value = hssfsheet.getRow(5).getCell(2).getNumericCellValue();
			gs.add("dz1", Integer.valueOf((int)value));
			value = hssfsheet.getRow(6).getCell(2).getNumericCellValue();
			gs.add("dz2", Integer.valueOf((int)value));
			value = hssfsheet.getRow(6).getCell(4).getNumericCellValue();
			gs.add("dz3", Double.valueOf(value));
			value = hssfsheet.getRow(7).getCell(2).getNumericCellValue();
			gs.add("dz4", Integer.valueOf((int)value));
			value = hssfsheet.getRow(7).getCell(4).getNumericCellValue();
			gs.add("dz5", Double.valueOf(value));
			value = hssfsheet.getRow(8).getCell(2).getNumericCellValue();
			gs.add("dz6", Integer.valueOf((int)value));
			value = hssfsheet.getRow(8).getCell(4).getNumericCellValue();
			gs.add("dz7", Double.valueOf(value));
			value = hssfsheet.getRow(9).getCell(2).getNumericCellValue();
			gs.add("dz8", Integer.valueOf((int)value));
			value = hssfsheet.getRow(9).getCell(4).getNumericCellValue();
			gs.add("dz9", Double.valueOf(value));
			gs.add("switchid", switchid);
			/*sql ="select max(dzbid) from Blowflag";
			ResultSet rs= DButils.executeQuery(connection, sql);
			int id=1;
			while(rs.next()){
				id=rs.getInt(1)+1;
			}
			gs.add("dzbid", Integer.valueOf(id));*/
			sql="delete from Blowflag where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			DButils.executeSQL(connection, gs.getInsertSql());
			/**
			 * 修改主表
			 */
			sql="delete from Publics where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			Iterator iterator = hssfsheet.rowIterator();
			while(iterator.hasNext())
			{
				HSSFRow row = (HSSFRow)iterator.next();
				if(row.getRowNum()>11 && (row.getCell(0)==null || "".equals(row.getCell(0).toString())))
					break;
				if (row.getRowNum()>11) {
					gs = new GenInsertScript();
					gs.setTableName("Publics");
					gs.add("xp1", "".equals(row.getCell(0).getStringCellValue().trim())?"无":row.getCell(0).getStringCellValue().trim());
					gs.add("xp2", "".equals(getValue(row.getCell(1)))?"无":getValue(row.getCell(1)));
					gs.add("xp3", "".equals(row.getCell(2).getStringCellValue().trim())?"无":row.getCell(2).getStringCellValue().trim());
					gs.add("xp4","".equals(row.getCell(3).getStringCellValue().trim())?"无":row.getCell(3).getStringCellValue().trim());
					gs.add("xp5", !"公安机关".equals(row.getCell(4).getStringCellValue().trim())&&!"其他机关".equals(row.getCell(4).getStringCellValue().trim())?"其他机关":row.getCell(4).getStringCellValue().trim());
					gs.add("switchid", switchid);
					/*sql ="select max(xpid) from Publics";
					rs= DButils.executeQuery(connection, sql);
					id=1;
					while(rs.next()){
						id=rs.getInt(1)+1;
					}
					gs.add("xpid", Integer.valueOf(id));*/
					DButils.executeSQL(connection, gs.getInsertSql());
					isreport="1";
				}
			}
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
