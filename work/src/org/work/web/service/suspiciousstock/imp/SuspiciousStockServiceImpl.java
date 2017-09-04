/**
 * 
 */
package org.work.web.service.suspiciousstock.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.ServletActionContext;
import org.work.web.constants.Constants;
import org.work.web.dao.suspiciousstock.IStockbaseDao;
import org.work.web.dao.suspiciousstock.IStockbaseDetailDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Stockbase;
import org.work.web.po.Stockdetail;
import org.work.web.service.suspiciousstock.ISuspiciousStockService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.Parameter;
import org.work.web.util.XlsUtil;

public class SuspiciousStockServiceImpl implements ISuspiciousStockService{
	private static final Logger logger = Logger.getLogger(SuspiciousStockServiceImpl.class);
	private IStockbaseDao stockbaseDao;
	private IStockbaseDetailDao stockbaseDetailDao;

	/**
	 * 由数据文件生成证券业可疑交易明细数据	 
	 
	 * @param stockbase
	 * @param file 数据文件，txt格式
	 * @return
	 * @throws IOException
	 */
	List<Stockdetail> createStockDetailFromFile(Stockbase stockbase,File file) throws IOException{
		List<Stockdetail> list = new ArrayList();
		Stockdetail stockdetail;		
		HSSFWorkbook hssfworkbook = null;
		try {
			hssfworkbook =new HSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HSSFSheet hssfsheet = hssfworkbook.getSheetAt(0);
		Iterator iterator = hssfsheet.rowIterator();
		int i = 0;
		while(iterator.hasNext())
		{
			HSSFRow row = (HSSFRow)iterator.next();
			if (row.getRowNum()>3) {
				if("".equals(row.getCell(0)) || null==row.getCell(0) ){
					break;
				}else{
					if ("".equals(getValue(row.getCell(0))) || "填表人及联系电话".equals(getValue(row.getCell(0)))) {
						break;
					}
				}
					stockdetail = new Stockdetail();
					stockdetail.setBStockBase(stockbase);
					stockdetail.setBname(getValue(row.getCell(1)));						
					stockdetail.setStockaccount(getValue(row.getCell(2)));
					stockdetail.setMoneyaccount(getValue(row.getCell(3)));
					stockdetail.setPayaccount(getValue(row.getCell(4)));
					stockdetail.setTrandate(getValue(row.getCell(5)));
					stockdetail.setTranmethod(getValue(row.getCell(6)));
					stockdetail.setTtype(getValue(row.getCell(7)));
					stockdetail.setTid(getValue(row.getCell(8)));
					stockdetail.setCurrency(getValue(row.getCell(9)));
					stockdetail.setLamt("".equals(getValue(row.getCell(10)))?null:Double.valueOf(getValue(row.getCell(10))));
					stockdetail.setFmat("".equals(getValue(row.getCell(11)))?null:Double.valueOf(getValue(row.getCell(11))));
					stockdetail.setRorp(getValue(row.getCell(12)));
					stockdetail.setRorpmtd(getValue(row.getCell(13)));
					stockdetail.setAgname(getValue(row.getCell(14)));
					stockdetail.setAgid(getValue(row.getCell(15)));
					stockdetail.setRemark(getValue(row.getCell(16)));											
					list.add(stockdetail);
					System.out.println(i+++":"+getValue(row.getCell(10)));
	}
	}
		return list;
	}


	public void saveStockData(Stockbase stockbase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,
			String username) {
		logger.info("金融机构用户录入证券业重点可疑交易信息");		
		System.out.println(suspiciousFileFileName + "  ::::   "+suspiciousdataFileFileName);		
		String datafimename = System.currentTimeMillis()  + "_rn_" + suspiciousdataFileFileName;
		String suspiciousfilename = System.currentTimeMillis()  + "_rn_" + suspiciousFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUS + "/" + suspiciousfilename);
		String filenamedata = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUSDATA + "/" + datafimename);		
		File newFile = new File(filename);
		File dataFile = new File(filenamedata);		
		System.out.println(datafimename + "  ======   "+suspiciousfilename);
		try {
			String bmininame = stockbase.getBOrgInformation().getBmininame()==null?"":stockbase.getBOrgInformation().getBmininame();
			//生成线索ID
			int maxIndex = stockbaseDao.getBaseMaxIndex(bmininame+DateUtil.formatDate(), stockbase.getBOrgInformation().getOid().toString());
			String lineid = bmininame+DateUtil.formatDate()+maxIndex;
			stockbase.setLineid(lineid);
			stockbase.setCfile(suspiciousfilename);//补充附件文件名
			stockbase.setUpdatetime(DateUtil.formatDateTime());
			stockbase.setUpdateuser(username);


			FileUtils.copyFile(suspiciousFile, newFile);
			FileUtils.copyFile(suspiciousdataFile, dataFile);
			stockbaseDao.save(stockbase);//保存基本信息			
			stockbaseDetailDao.batchSaveStockBaseDetail(this.createStockDetailFromFile(stockbase, dataFile));//保存明细信息
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存证券业可疑信息异常");
		}		
	}

	public PaginaterList getStockBaseInfo(Map<String, Object> params,Integer page) {
		logger.info("查询证券业可疑交易信息");		
		return stockbaseDao.getStockBaseInfo(params,page);
	}

	public Stockbase findById(Integer id) {
		logger.info("查看证券业可疑交易信息");
		return (Stockbase)stockbaseDao.findById(id);
	}

	public String buildXlsStock(String username, String path,Map<String, Object> params) {		
		logger.info("导出证券业可疑交易信息到excel");				
		String filename = "";
		Map map = new HashMap();
		Map map2 = new HashMap();		

		List headlist = new ArrayList();
		List valueList = new ArrayList();
		int columnCount = 0;		

		headlist.add("金融机构名称");
		headlist.add("报送时间");
		headlist.add("线索编号");
		headlist.add("客户姓名");
		headlist.add("本币累计金额");
		headlist.add("外币累计金额");

		columnCount = headlist.size();

		List<Stockbase> stockbases = stockbaseDao.getStockBaseInfoAll(params);

		for(Stockbase info : stockbases){
			List tmpList2 = new ArrayList();
			Parameter parameter = new Parameter();

			tmpList2.add(info.getBOrgInformation().getBname());			
			tmpList2.add(info.getUpdatetime());
			tmpList2.add(info.getLineid());			
			tmpList2.add(info.getCname());
			tmpList2.add(info.getClamt().toString());			
			tmpList2.add(info.getCfamt().toString());			

			parameter.setList(tmpList2);			
			valueList.add(parameter);
		}

		map.put("ColumnName", headlist);
		map.put("DataContent", valueList);
		map.put("ColumnCount", columnCount);

		List nameList = new ArrayList();
		nameList.add("证券业可疑交易信息");		
		List countList = new ArrayList();
		countList.add("6");		

		map2.put("nameList", nameList);
		map2.put("countList", countList);

		XlsUtil xls = new XlsUtil();		
		filename = xls.build(DateUtil.formatDateTime(), path, "证券业可疑交易信息", "", username, map, map2);		
		System.out.println("-------------  filename ::  "+filename);		

		return filename;
	}

	public PaginaterList getStockBaseDetailInfoById(Map<String, Object> params,Integer page) {
		logger.info("查询证券业可疑交易明细信息");		
		return stockbaseDetailDao.getStockBaseDetailInfoById(params,page);
	}

	public void addStockDetail(Stockdetail stockdetail) {
		logger.info("保存证券业可疑交易明细信息");
		try{
			stockbaseDetailDao.save(stockdetail);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("保存证券业可疑交易明细信息异常");
		}
	}

	public Stockdetail findDetailByDid(Long did) {
		logger.info("查看证券业可疑交易明细信息");
		return (Stockdetail) stockbaseDetailDao.findById(did);
	}

	public void updateStockDetail(Stockdetail stockdetail) {
		logger.info("修改证券业可疑交易明细信息");
		try{
			stockbaseDetailDao.saveOrUpdate(stockdetail);		
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("修改证券业可疑交易明细信息异常");
		}
	}

	public void deleteStockdetailById(Long did) {
		logger.info("删除证券业可疑交易明细信息");
		try{
			stockbaseDetailDao.deleteById(did);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("删除证券业可疑交易明细信息异常");
		}
	}


	public void setStockbaseDao(IStockbaseDao stockbaseDao) {
		this.stockbaseDao = stockbaseDao;
	}


	public void setStockbaseDetailDao(IStockbaseDetailDao stockbaseDetailDao) {
		this.stockbaseDetailDao = stockbaseDetailDao;
	}
	public static String getValue(HSSFCell cell) {
		  String value = "";

		  switch (cell.getCellType()) {

		  case Cell.CELL_TYPE_NUMERIC: // 数值型

		   if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {

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
