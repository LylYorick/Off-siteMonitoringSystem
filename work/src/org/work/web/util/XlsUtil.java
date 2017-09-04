package org.work.web.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.work.web.util.StringUtil;
import org.work.web.util.Global;
import org.work.web.util.Parameter;

public class XlsUtil {

	// 黑色、20号、居中、粗体
	public jxl.write.WritableFont font5 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 20, WritableFont.BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);

	public jxl.write.WritableCellFormat black_bold_20 = new jxl.write.WritableCellFormat(
			font5);
	// 黑色、10号、居中
	public jxl.write.WritableFont font6 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);

	public jxl.write.WritableCellFormat black_10 = new jxl.write.WritableCellFormat(
			font6);

	public jxl.write.WritableCellFormat black_102 = new jxl.write.WritableCellFormat(
			font6);

	public jxl.write.WritableCellFormat black_103 = new jxl.write.WritableCellFormat(
			font6);

	public jxl.write.WritableCellFormat black_104 = new jxl.write.WritableCellFormat(
			font6);

	public jxl.write.WritableCellFormat black_105 = new jxl.write.WritableCellFormat(
			font6);

	// 红色、10号、居中
	public jxl.write.WritableFont font61 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);

	public jxl.write.WritableCellFormat black_101 = new jxl.write.WritableCellFormat(
			font61);

	// 粗体、黑色、14号
	public jxl.write.WritableFont font7 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 14, WritableFont.BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);

	public jxl.write.WritableCellFormat black_bold_14 = new jxl.write.WritableCellFormat(
			font7);

	// 黑色、10号、居中、粗体
	public jxl.write.WritableFont font11 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 10, WritableFont.BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);

	public jxl.write.WritableCellFormat black_bold_10 = new jxl.write.WritableCellFormat(
			font11);

	// 黑色、10号、居左
	public jxl.write.WritableFont font8 = new jxl.write.WritableFont(
			WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
			jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);

	public jxl.write.WritableCellFormat black_10_left = new jxl.write.WritableCellFormat(
			font8);

	public jxl.write.WritableCellFormat black_10_right = new jxl.write.WritableCellFormat(
			font8);

	public XlsUtil() {
		setValue();
	}

	public XlsUtil(String ulfilename) {

		this.ulfilename = ulfilename;

	}

	public List uploadXls() {
		List resultlist = new ArrayList();
		try {
			if (excelfile == null)
				System.out.println("没有获取文件！");
			else {
				Workbook workbook = Workbook.getWorkbook(new File(ulfilename));
				Sheet sheet = workbook.getSheet(0);
				for (int rownum = 1; rownum < sheet.getRows(); rownum++) {
					Cell[] cells = sheet.getRow(rownum);
					List rowlist = new ArrayList();
					for (int cellnum = 0; cellnum < cells.length; cellnum++) {
						rowlist.add(cells[cellnum].getContents());
					}
					resultlist.add(rowlist);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}		

		return resultlist;
	}

	@SuppressWarnings("deprecation")
	public void setValue() {
		try {

			black_bold_20.setAlignment(jxl.format.Alignment.CENTRE);
			black_bold_20.setWrap(true);

			black_10.setAlignment(jxl.format.Alignment.CENTRE);
			black_10.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));
			
			black_101.setAlignment(jxl.format.Alignment.CENTRE);
			black_101.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));	

			black_102.setAlignment(jxl.format.Alignment.CENTRE);
			black_102.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));	
			black_102.setBackground(jxl.format.Colour.ROSE);//设置背景颜色

			black_103.setAlignment(jxl.format.Alignment.CENTRE);
			black_103.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));	
			black_103.setBackground(jxl.format.Colour.TAN);//设置背景颜色

			black_104.setAlignment(jxl.format.Alignment.CENTRE);
			black_104.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));	
			black_104.setBackground(jxl.format.Colour.GOLD);//设置背景颜色

			black_105.setAlignment(jxl.format.Alignment.CENTRE);
			black_105.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));	
			black_105.setBackground(jxl.format.Colour.GRAY_25);//设置背景颜色

			black_bold_14.setAlignment(jxl.format.Alignment.CENTRE);
			black_bold_14.setWrap(true);

			black_bold_10.setAlignment(jxl.format.Alignment.CENTRE);
			black_bold_10.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));
			black_bold_10.setWrap(true);

			black_10_left.setAlignment(jxl.format.Alignment.LEFT);
			black_10_left.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));
			black_10_right.setAlignment(jxl.format.Alignment.RIGHT);
			black_10_right.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle
					.getStyle(Global.boder_style));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成报表（不含图片）
	 * 
	 * @param currentTime
	 *            当前时间
	 * @param path
	 *            文件路径
	 * @param title
	 *            报表标题
	 * @param condition
	 *            生成条件
	 * @param author
	 *            制表人
	 * @param map
	 *            自定义map包含列名(DolumnName->List<String>)、列数(ColumnCount->int)、
	 *            数据(DataContent->List<List<String>>)
	 * @return xls filename
	 */
	public String build(String currentTime, String path, String title,
			String condition, String author, Map<String, ?> map) {
		String filename = "";
		int columnCount = 0;
		List<?> columnName = null;
		List<?> dataContent = null;

		try {
			// 从map中获取报表信息
			if (map != null && map.containsKey("ColumnName")
					&& map.containsKey("ColumnCount")
					&& map.containsKey("DataContent")) {

				if (map.get("ColumnName") != null
						&& map.get("ColumnCount") != null
						&& map.get("DataContent") != null) {

					columnCount = ((Integer) map.get("ColumnCount")).intValue();// 获取列数
					columnName = (List<?>) map.get("ColumnName"); // List<String>
					// 获取列名
					dataContent = (List<Parameter>) map.get("DataContent");// List<List>
					// 获取数据
				}
			} else {
				return "";// error
			}
			if (columnCount < 1 || dataContent.size() < 1) {
				return "";// error
			}

			// 创建文件

			// 文件名处理
			filename = StringUtil.replace(currentTime, '\\', ' ');
			filename = StringUtil.replace(filename, '/', ' ');
			filename = StringUtil.replace(filename, ':', ' ');
			filename = StringUtil.replace(filename, '*', ' ');
			filename = StringUtil.replace(filename, '?', ' ');
			filename = StringUtil.replace(filename, '"', ' ');
			filename = StringUtil.replace(filename, '<', ' ');
			filename = StringUtil.replace(filename, '>', ' ');
			filename = StringUtil.replace(filename, '|', ' ');
			filename = StringUtil.replace(filename, " ", "");
			Random r = new Random();
			filename += "_" + r.nextInt(1000) + r.nextInt(1000);

			filename = filename + ".xls";
			String file_path = path + filename;
			WritableWorkbook book = Workbook
			.createWorkbook(new File(file_path));

			int page = 1;
			WritableSheet sheet = book.createSheet("第" + page + "页", page - 1);
			int length = 15;

			for (int i = 0; i < length; i++) {
				sheet.setColumnView(i, 17); // 设置单元格的宽度
			}

			int row = 0;
			int column = 1;

			// 设置标题
			column = (columnCount / 2) - 1;
			row = 1;

			Label tit = new Label(column, row, title, black_bold_20);

			if (columnCount > 2 && columnCount % 2 == 1)
				sheet.mergeCells(column, row, column + 2, row + 1);
			else if (columnCount < 6)
				sheet.mergeCells(column, row, column + 1, row + 1);
			else if (columnCount >= 6) {
				tit = new Label(column - 1, row, title, black_bold_20);
				sheet.mergeCells(column - 1, row, column + 2, row + 1);
			}

			sheet.addCell(tit);

			row += 3;
			column = 0;

			// 设置条件
			Label con = new Label(column, row, condition, black_bold_14);
			sheet.mergeCells(column, row, columnCount - 1, row + 5);
			sheet.addCell(con);
			row += 7;

			// 填充列标题
			String cn = "";
			Label label = null;

			for (int i = 0; i < columnCount; i++) {
				cn = (String) columnName.get(i);
				label = new Label(column++, row, cn, black_10);
				sheet.addCell(label);

			}
			// 填充数据
			column = 0;
			row++;
			for (int i = 0; i < dataContent.size(); i++) {// rows

				// EXECL的最大行数为65536行，所以每当达到极限时要换域
				if (i % 65000 == 0 && i != 0) {
					page++;
					row = 0;
					sheet = book.createSheet("第" + page + "页", page - 1);
				}
				Parameter p = new Parameter();
				p = (Parameter) dataContent.get(i);
				int flagnum = p.getList().size() - 1;
				if(((String)p.getList().get(flagnum)).equals("0")){//掉话用红色标记
					for (int j = 0; j < p.getList().size(); j++) {// columns
						cn = (String) p.getList().get(j);
						label = new Label(column++, row, cn, black_101);
						sheet.addCell(label);
					}
				}else{
					for (int j = 0; j < p.getList().size(); j++) {// columns
						cn = (String) p.getList().get(j);
						label = new Label(column++, row, cn, black_10);
						sheet.addCell(label);
					}					
				}
				column = 0;
				row++;
			}

			// 填充表尾 时间/制表人
			row += 2;
			column = columnCount - 2;
			cn = author;
			label = new Label(column, row, "制表人   ：" + cn, black_10_left);
			sheet.addCell(label);
			sheet.mergeCells(column, row, column + 1, row);

			row++;
			label = new Label(column, row, "制表时间 ："
					+ (currentTime.contains("_") ? currentTime.substring(
							currentTime.indexOf("_") + 1, currentTime.length())
							: currentTime), black_10_left);
			sheet.addCell(label);
			sheet.mergeCells(column, row, column + 1, row);
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
			filename = "";
		}
		return filename;
	}

	/**
	 * 
	 * @param currentTime
	 * @param path
	 * @param title
	 * @param condition
	 * @param author
	 * @param map 存放具体是数据，具体的用法见后面的main()函数测试
	 * @param map2 要合并单元格的项,格式为存储2个List，一个存名称:nameList，另一个存合并的单元格个数:countList
	 * @return
	 */
	public String build(String currentTime, String path, String title,
			String condition, String author, Map<String, ?> map,Map<String,?> map2) {
		String filename = "";
		int columnCount = 0;

		List<?> columnName = null;
		List<?> dataContent = null;

		List<?> nameList = null;
		List<?> countList = null;

		try {
			// 从map中获取报表信息
			if (map != null && map.containsKey("ColumnName")
					&& map.containsKey("ColumnCount")
					&& map.containsKey("DataContent")) {

				if (map.get("ColumnName") != null
						&& map.get("ColumnCount") != null
						&& map.get("DataContent") != null) {

					columnCount = ((Integer) map.get("ColumnCount")).intValue();// 获取列数
					// 获取列名
					columnName = (List<?>) map.get("ColumnName"); // List<String>
					// 获取数据				
					dataContent = (List<Parameter>) map.get("DataContent");// List<List>					
				}
			} else {
				return "";// error
			}

			//获取要合并的名称和列数   begin
			if (map2 != null && map2.containsKey("nameList")
					&& map2.containsKey("countList")) {

				if (map2.get("nameList") != null
						&& map2.get("countList") != null ) {

					countList = (List<?>) map2.get("countList");// 获取列数
					nameList = (List<?>) map2.get("nameList"); // List<String>
					// 获取列名					
				}
			}
			//获取要合并的名称和列数   end

			if (columnCount < 1 || dataContent.size() < 1) {
				return "";// error
			}
			// 创建文件

			// 文件名处理
			filename = StringUtil.replace(currentTime, '\\', ' ');
			filename = StringUtil.replace(filename, '/', ' ');
			filename = StringUtil.replace(filename, ':', ' ');
			filename = StringUtil.replace(filename, '*', ' ');
			filename = StringUtil.replace(filename, '?', ' ');
			filename = StringUtil.replace(filename, '"', ' ');
			filename = StringUtil.replace(filename, '<', ' ');
			filename = StringUtil.replace(filename, '>', ' ');
			filename = StringUtil.replace(filename, '|', ' ');
			filename = StringUtil.replace(filename, " ", "");
			Random r = new Random();
			filename += "_" + r.nextInt(1000) + r.nextInt(1000);
			filename = filename + ".xls";
			String file_path = path + filename;
			WritableWorkbook book = Workbook
			.createWorkbook(new File(file_path));			
			int page = 1;
			WritableSheet sheet = book.createSheet("第" + page + "页", page - 1);
			int length = 15;
			for (int i = 0; i < length; i++) {
				sheet.setColumnView(i, 17); // 设置单元格的宽度
			}
			int row = 0;
			int column = 1;
			// 设置标题
			column = (columnCount / 2) - 1;
			row = 1;
			Label tit = new Label(column, row, title, black_bold_20);
			if (columnCount > 2 && columnCount % 2 == 1)
				sheet.mergeCells(column, row, column + 2, row + 1);
			else if (columnCount < 6)
				sheet.mergeCells(column, row, column + 1, row + 1);
			else if (columnCount >= 6) {
				tit = new Label(column - 1, row, title, black_bold_20);
				sheet.mergeCells(column - 1, row, column + 2, row + 1);
			}
			sheet.addCell(tit);
			row += 3;
			column = 0;

			//填充要合并的项
			if(nameList!=null&&nameList.size()>0){
				int total = 0;
				int nameListSize = nameList.size();
				for(int i=0;i<nameListSize;i++){
					int counts = Integer.parseInt(countList.get(i).toString());
					String names = nameList.get(i).toString();
					int endColumn = total + counts - 1;					
					Label hb = new Label(total, row, names, black_102);
					sheet.mergeCells(total, row, endColumn, row+1);
					sheet.addCell(hb);
					total += counts;					
				}
			}
			//填充要合并的项end

			row += 2;

			// 填充列标题
			String cn = "";
			Label label = null;
			for (int i = 0; i < columnCount; i++) {
				cn = (String) columnName.get(i);
				label = new Label(column++, row, cn, black_103);
				sheet.addCell(label);
			}

			// 填充数据
			column = 0;
			row++;
			int dataContentSize = dataContent.size();
			for (int i = 0; i < dataContentSize; i++) {// rows
				// EXECL的最大行数为65536行，所以每当达到极限时要换域
				if (i % 65000 == 0 && i != 0) {
					page++;
					row = 0;
					sheet = book.createSheet("第" + page + "页", page - 1);
				}
				Parameter p = new Parameter();
				p = (Parameter) dataContent.get(i);
				int flagnum = p.getList().size() - 1;
				int plistSize = p.getList().size();
				for (int j = 0; j < plistSize; j++) {// columns
					cn = (String) p.getList().get(j);
					label = new Label(column++, row, cn, black_10);
					sheet.addCell(label);
				}			
				column = 0;
				row++;
			}

			// 填充表尾 时间/制表人
			row += 2;
			column = columnCount - 2;
			cn = author;
			label = new Label(column, row, "制表人   ：" + cn, black_10_left);
			sheet.addCell(label);
			sheet.mergeCells(column, row, column + 1, row);
			row++;
			label = new Label(column, row, "制表时间 ："
					+ (currentTime.contains("_") ? currentTime.substring(
							currentTime.indexOf("_") + 1, currentTime.length())
							: currentTime), black_10_left);
			sheet.addCell(label);
			sheet.mergeCells(column, row, column + 1, row);
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
			filename = "";
		}
		return filename;
	}

	public static void main(String args[]) {

		// 测试数据
		Map map = new HashMap();
		List headlist = new ArrayList();
		List valueList = new ArrayList();
		int columnCount = 0;
		headlist.add("序号");
		headlist.add("号码");
		headlist.add("姓名");
		headlist.add("部门");
		headlist.add("ffdfdfd");
		headlist.add("fdfdsfds");
		columnCount = headlist.size();
		
		List tmpList2 = new ArrayList();
		Parameter parameter = new Parameter();
		
		tmpList2.add("1");
		tmpList2.add("2");
		tmpList2.add("3");
		tmpList2.add("4");
		tmpList2.add("5");
		tmpList2.add("6");
		
		parameter.setList(tmpList2);
		
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		
		valueList.add(parameter);
		valueList.add(parameter);
		
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		valueList.add(parameter);
		
		map.put("ColumnName", headlist);
		map.put("DataContent", valueList);
		map.put("ColumnCount", columnCount);
		
		List nameList = new ArrayList();
		nameList.add("用户列表1");
		nameList.add("用户列表2");
		nameList.add("用户列表2");
		List countList = new ArrayList();
		countList.add("2");
		countList.add("2");
		countList.add("2");
		Map map2 = new HashMap();
		map2.put("nameList", nameList);
		map2.put("countList", countList);
		
		System.out.println("生成excel测试===");
		
		new XlsUtil().build("2009-7-17","D:/","报表测试",	"****************条件*********************","张三", map,map2);
		
		System.out.println("生成excel测试22222222222");
	}

	private String ulfilename = "";
	private File excelfile;

}
