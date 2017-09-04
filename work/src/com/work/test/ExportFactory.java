/**
 * 
 */
package com.work.test;

import org.work.web.exception.ServiceException;

import com.work.quater.Quater;
import com.work.year.Year;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 16, 2010
 * @版本 work V1.0
 */
public class ExportFactory {

	/*
	 * 报表生成工厂
	 */
	private ExportFactory(){};
	public static void ExportXml(String year,String quater,String pathString){
		if(year==null || quater==null || pathString==null)
			throw new ServiceException("没有正确参数，不能到处报文");
		BaseExport baseExport;
		if("0".equals(quater)){
			baseExport = new Year();
		}else{
			baseExport = new Quater();
		}
		baseExport.setPathString(pathString);
		baseExport.setQuaterString(quater);
		baseExport.setYearString(year);
		baseExport.export();
	}
}
