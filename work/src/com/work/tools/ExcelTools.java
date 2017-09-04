/**
 * 
 */
package com.work.tools;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.work.web.exception.ServiceException;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class ExcelTools {
	private static final Logger logger = Logger.getLogger(ExcelTools.class);

	public final static String _fileMenu="e:\\excel";
//	public final static String _fileMenu="G:\\offsite\\OK";
	private String fileMenu;
	
	public String getFileMenu() {
		return fileMenu;
	}
	public void setFileMenu(String fileMenu) {
		this.fileMenu = fileMenu;
	}
	/*
	 * 遍历目录
	 */
	private Map traversal(){
		if(fileMenu==null || "".equals(fileMenu))
			fileMenu=_fileMenu;
		File file=new File(fileMenu);
		Map map = new HashMap();
		List list = (List) FileUtils.listFiles(file, new String[] { "xls","XLS" }, false);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			File files = (File) iterator.next();
			ExcelType excelType = new ExcelType(files.getName().split("\\.")[0]);
			map.put(excelType, files);
		}
		if(map.size()==0)
			throw new ServiceException("No File");
		return map;
	}
	public static void insert() throws SQLException{
		ExcelTools excelTools= new ExcelTools();
		Map map = excelTools.traversal();
		int i=0;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry  entry = (Entry) iterator.next();
			ExcelType exceltype = (ExcelType) entry.getKey();
			File xls = (File) entry.getValue();
			i++;
			logger.info("正在处理文件："+i+":->"+xls.getName());
			try{
			ExcelReport report = ToolsFactory.getInstance().getReport(exceltype);
			report.insertInto(xls,exceltype);
			}catch (Exception e) {
				throw new ServiceException(xls.getName()+"：格式错误，请检查后再上传");
			}
		}
		logger.info("处理完成");
	}

	/**
	 * 页面导入
	 * @throws SQLException
	 */
	public static void insertByPage(File file,ExcelType type) throws SQLException{
		ExcelReport report = ToolsFactory.getInstance().getReport(type);
		report.insertInto(file,type);
		logger.info("处理完成");
	}
	/*
	 * 金融机构客户身份识别情况（识别客户）
	 */
	public static void main(String[] args) throws SQLException {
		ExcelTools excelTools= new ExcelTools();
		Map map = excelTools.traversal();
		int i=0;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry  entry = (Entry) iterator.next();
			ExcelType exceltype = (ExcelType) entry.getKey();
			File xls = (File) entry.getValue();
			i++;
			logger.info("正在处理文件："+i+":->"+xls.getName());
			ExcelReport report = ToolsFactory.getInstance().getReport(exceltype);
//			report.insertInto(xls,exceltype);
		}
		logger.info("处理完成");
		/*
		ExcelTools excelTools= new ExcelTools();
		Map map = excelTools.traversal();
		int i=0;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry  entry = (Entry) iterator.next();
			ExcelType exceltype = (ExcelType) entry.getKey();
			File xls = (File) entry.getValue();
			if("J".equals(exceltype.getType().toUpperCase())){
			i++;
			ExcelReport report = ToolsFactory.getInstance().getReport(exceltype);
//			report.insertInto(xls,exceltype);
			System.out.println(exceltype.getOrgid());
			}
		}*/
	}
}
