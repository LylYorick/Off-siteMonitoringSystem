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
public class Report8 extends ReportBase implements ExcelReport {

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
			sql="delete from SUSREPORT where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			sql="delete from SUSREPORTFLAG where switchid="+switchid;
			DButils.executeSQL(connection, sql);
		}else{
			GenInsertScript gs = new GenInsertScript();
			/**
			 * 修改标注表
			 */
			gs.setTableName("SUSREPORTFLAG");
			double value = "".equals(hssfsheet.getRow(5).getCell(2).toString())?0:hssfsheet.getRow(5).getCell(2).getNumericCellValue();
			gs.add("sbz1", Integer.valueOf((int)value));
			value = "".equals(hssfsheet.getRow(5).getCell(4).toString())?0:hssfsheet.getRow(5).getCell(4).getNumericCellValue();
			gs.add("sbz2", Double.valueOf(value));
			value = "".equals(hssfsheet.getRow(6).getCell(2).toString())?0:hssfsheet.getRow(6).getCell(2).getNumericCellValue();
			gs.add("sbz3", Integer.valueOf((int)value));
			value = "".equals(hssfsheet.getRow(6).getCell(4).toString())?0:hssfsheet.getRow(6).getCell(4).getNumericCellValue();
			gs.add("sbz4", Double.valueOf(value));
			gs.add("switchid", switchid);
			/*sql ="select max(sbzid) from SUSREPORTFLAG";
			ResultSet rs= DButils.executeQuery(connection, sql);
			int id=1;
			while(rs.next()){
				id=rs.getInt(1)+1;
			}
			gs.add("sbzid", Integer.valueOf(id));*/
			sql="delete from SUSREPORTFLAG where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			DButils.executeSQL(connection, gs.getInsertSql());
			/**
			 * 修改主表
			 */
			gs = new GenInsertScript();
			gs.setTableName("SUSREPORT");
			for (int k = 10; k <= 11; k++)
			{
				HSSFRow hssfrow = hssfsheet.getRow(k);
				for (int j = 1; j < 10; j++)
				{
					HSSFCell hssfcell = hssfrow.getCell((short) j);
					if(j==9){
						gs.add("sp"+(k-9)*9, getValue(hssfcell));
					}else{
						int index = (k-10)*9+j;
						try{
							value = "".equals(hssfcell.toString())?0:hssfcell.getNumericCellValue();
							if (String.valueOf(value).lastIndexOf(".00")>0){
								gs.add("sp"+index, Integer.valueOf((int)value));
							}else{
								gs.add("sp"+index, Double.valueOf(value));
							}
						}catch(Exception e){
							gs.add("sp"+index, hssfcell.getStringCellValue());
						}
					}
				}
			}
			gs.add("switchid", switchid);
			/*sql ="select max(spid) from SUSREPORT";
			rs= DButils.executeQuery(connection, sql);
			id=1;
			while(rs.next()){
				id=rs.getInt(1)+1;
			}
			gs.add("spid", Integer.valueOf(id));*/
			sql="delete from SUSREPORT where switchid="+switchid;
			DButils.executeSQL(connection, sql);
			DButils.executeSQL(connection, gs.getInsertSql());
			isreport="1";
		}
		updateUser(switchid, hssfsheet.getRow(3).getCell(1).getStringCellValue(), getValue(hssfsheet.getRow(3).getCell(3)),isreport);
		DButils.closeConnection(connection);
	}
}
