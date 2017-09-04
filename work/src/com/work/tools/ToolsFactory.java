/**
 * 
 */
package com.work.tools;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 23, 2010
 * @版本 work V1.0
 */
public class ToolsFactory {

	private static ToolsFactory toolsFactory = new ToolsFactory();
	public static ToolsFactory getInstance(){
		if(toolsFactory==null)
			return new ToolsFactory();
		return toolsFactory;
	}
	private ToolsFactory(){};
	/**
	 * @param exceltype
	 * @return 报表工厂，根据type判断文件导入到哪张报表
	 */
	public ExcelReport getReport(ExcelType exceltype) {
		if ("F".equals(exceltype.getType().toUpperCase())) {
			return new Report5();
		}else if ("G".equals(exceltype.getType().toUpperCase())) {
			return new Report6();
		}else if ("H".equals(exceltype.getType().toUpperCase())) {
			return new Report7();
		}else if ("I".equals(exceltype.getType().toUpperCase())) {
			return new Report8();
		}else if ("J".equals(exceltype.getType().toUpperCase())) {
			return new Report9();
		}else if ("A".equals(exceltype.getType().toUpperCase())) {
			return new Report0();
		}else if ("B".equals(exceltype.getType().toUpperCase())) {
			return new Report1();
		}else if ("C".equals(exceltype.getType().toUpperCase())) {
			return new Report2();
		}else if ("D".equals(exceltype.getType().toUpperCase())) {
			return new Report3();
		}else if ("E".equals(exceltype.getType().toUpperCase())) {
			return new Report4();
		}
		return null;
	}

}
