/**
 * 
 */
package com.work.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.work.web.exception.ServiceException;

import com.work.test.DButils;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public abstract class ReportBase {
	public final static String ZEROFLAGYES="是";
	public final static Map rMap = new HashMap();
	static{
		rMap.put("A", 1);
		rMap.put("B", 2);
		rMap.put("C", 3);
		rMap.put("D", 4);
		rMap.put("E", 5);
		rMap.put("F", 6);
		rMap.put("G", 7);
		rMap.put("H", 8);
		rMap.put("I", 9);
		rMap.put("J", 10);
	}
	/**
	 * 根据excel文件名，查找对应的reportswitch表的id
	 * @param excelType
	 * @return
	 * @throws SQLException
	 */
	public Integer getSwitchId(ExcelType excelType) throws SQLException{
		Integer switchid = null;
		String source;
		if("F".equals(excelType.getSource().toUpperCase())){
			source = " and i.ishead='0'";
		}else {
			source = " and i.ishead='1'";
		}
		String sql="select r.switchid from B_ORG_INFORMATION as i,reportswitch as r where " +
		" r.oid=i.oid and i.bcatid='"+excelType.getOrgid()+"' and r.REPORTID="+rMap.get(excelType.getType().toUpperCase())+" and r.year="+excelType.getYear()+" and r.quater="+excelType.getQuater()+source;
		Connection connection=DButils.getConnection();
		ResultSet rs = DButils.executeQuery(connection, sql);
		while(rs.next()){
			switchid= rs.getInt(1);
		}
		if(switchid==null)
			throw new ServiceException("没有该报表记录，无法导入");
		DButils.closeConnection(connection);
		return switchid;
	}
	/**
	 * 如果是零报告，修改该记录为“已登记”
	 * @param switchid
	 */
	public void updateZero(Integer switchid){
		if(switchid==null)
			throw new ServiceException("没有该报表记录，无法更新零记录标识");
		String sql="update reportswitch set status=0 where switchid="+switchid+"";
		Connection connection=DButils.getConnection();
		DButils.executeSQL(connection, sql);
		DButils.closeConnection(connection);
	}
	/**
	 * 更新制表人和制表人联系电话
	 */
	public void updateUser(Integer switchid,String username,String tel,String isreport){
		if(switchid==null)
			throw new ServiceException("没有该报表记录，无法更新制表人及联系电话");
		String sql="update reportswitch set name='"+username+"',tel='"+tel+"', isreport='"+isreport+"' where switchid="+switchid+"";
		Connection connection=DButils.getConnection();
		DButils.executeSQL(connection, sql);
		DButils.closeConnection(connection);
	}
	/**
	 * 获取cell值
	 * @param cell
	 * @return
	 */
	public static String getValue(HSSFCell cell) {
		  String value = "";

		  switch (cell.getCellType()) {

		  case Cell.CELL_TYPE_NUMERIC: // 数值型

		   if (DateUtil.isCellDateFormatted(cell)) {

		    //如果是date类型则 ，获取该cell的date值

		    value = new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue())
		      .toString();

		   } else {// 纯数字
			    NumberFormat nf = NumberFormat.getNumberInstance();
				nf.setMinimumFractionDigits(0);
				nf.setMaximumFractionDigits(6);
				nf.setGroupingUsed(false);
				value = nf.format(cell.getNumericCellValue());
		   }

		   break;

		  /* 此行表示单元格的内容为string类型 */

		  case Cell.CELL_TYPE_STRING: // 字符串型   

		   value = cell.getStringCellValue().toString();

		   break;

		  case Cell.CELL_TYPE_FORMULA:// 公式型

		   //读公式计算值

		   value = String.valueOf(cell.getNumericCellValue());

		   if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串

		    value = cell.getStringCellValue().toString();

		   }
		   break;

		  case Cell.CELL_TYPE_BOOLEAN:// 布尔

		   value = " "

		   + cell.getBooleanCellValue();

		   break;

		  /* 此行表示该单元格值为空 */

		  case Cell.CELL_TYPE_BLANK: // 空值

		   value = "";

		   break;

		  case Cell.CELL_TYPE_ERROR: // 故障

		   value = "";

		   break;

		  default:

		   value = cell.getStringCellValue().toString();
		  }

		  return value;

		 }
}
