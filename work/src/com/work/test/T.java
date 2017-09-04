/**
 * 
 */
package com.work.test;

import org.work.web.util.DateUtil;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public class T {

	public static void main(String[] args) {
		/*String test= "111||222||333";
		String[] tStrings= test.split("\\|\\|");
		System.out.println(tStrings[1]);
		String a = "深反洗主【2010】111111110号";
		a = a.substring(a.indexOf("】")+1, a.indexOf("号"));
		System.out.println(a);
		System.out.println(a.indexOf("】"));
		System.out.println(a.lastIndexOf("】"));
		System.out.println(a.indexOf("号"));*/
		/*BaseExport baseExport = new Year();
		baseExport.setPathString("c:"+"\\"+"temp.xml");
		baseExport.setQuaterString("3");
		baseExport.setYearString("2010");
		baseExport.export();*/
		ExportFactory.ExportXml(DateUtil.getCurrentYear(), "0", "c:"+"\\"+"temp.xml");
	}
}
