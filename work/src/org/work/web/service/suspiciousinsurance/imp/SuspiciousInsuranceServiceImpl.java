/**
 * 
 */
package org.work.web.service.suspiciousinsurance.imp;

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
import org.work.web.dao.suspiciousinsurance.IInsurancebaseDao;
import org.work.web.dao.suspiciousinsurance.IInsurancebaseDetailDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Insurancebase;
import org.work.web.po.Insurancedetail;
import org.work.web.service.suspiciousinsurance.ISuspiciousInsuranceService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.Parameter;
import org.work.web.util.XlsUtil;

public class SuspiciousInsuranceServiceImpl implements ISuspiciousInsuranceService{
	private static final Logger logger = Logger.getLogger(SuspiciousInsuranceServiceImpl.class);
	private IInsurancebaseDao insurancebaseDao;
	private IInsurancebaseDetailDao insurancebaseDetailDao;

	/**
	 * 由数据文件生成保险业可疑交易明细数据	 
	 * @param insurancebase
	 * @param file 数据文件，txt格式
	 * @return
	 * @throws IOException
	 */
	List<Insurancedetail> createInsuranceDetailFromFile(Insurancebase insurancebase,File file) throws IOException{
		List<Insurancedetail> list = new ArrayList();
		Insurancedetail insurancedetail;		
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
		while(iterator.hasNext())
		{
			HSSFRow row = (HSSFRow)iterator.next();
			if (row.getRowNum()>3) {
				if(getValue(row.getCell(0))=="")
					break;
					insurancedetail = new Insurancedetail();
					insurancedetail.setBInsuranceBase(insurancebase);
					insurancedetail.setTrandate(getValue(row.getCell(1)));						
					insurancedetail.setTranmethod(getValue(row.getCell(2)));
					insurancedetail.setBname(getValue(row.getCell(3)));
					insurancedetail.setIaccount(getValue(row.getCell(4)));
					insurancedetail.setCurrency(getValue(row.getCell(5)));		
					insurancedetail.setLamt("".equals(getValue(row.getCell(15)))?null:Double.valueOf(getValue(row.getCell(6))));//修改于2011-10-08
					insurancedetail.setFmat("".equals(getValue(row.getCell(15)))?null:Double.valueOf(getValue(row.getCell(7))));//修改于2011-10-08
					insurancedetail.setRorpmethod(getValue(row.getCell(8)));
					insurancedetail.setRorp(getValue(row.getCell(9)));
					insurancedetail.setAgname(getValue(row.getCell(10)));
					insurancedetail.setAgid(getValue(row.getCell(11)));
					insurancedetail.setRemark(getValue(row.getCell(12)));											
					
				list.add(insurancedetail);
			}
		}
		return list;
	}

	public void saveInsuranceData(Insurancebase insurancebase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,
			String username) {
		logger.info("金融机构用户录入保险业重点可疑交易信息");		
		System.out.println(suspiciousFileFileName + "  ::::   "+suspiciousdataFileFileName);		
		String datafimename = System.currentTimeMillis()  + "_rn_" + suspiciousdataFileFileName;
		String suspiciousfilename = System.currentTimeMillis()  + "_rn_" + suspiciousFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUS + "/" + suspiciousfilename);
		String filenamedata = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUSDATA + "/" + datafimename);		
		File newFile = new File(filename);
		File dataFile = new File(filenamedata);		
		System.out.println(datafimename + "  ======   "+suspiciousfilename);
		try {
			String bmininame = insurancebase.getBOrgInformation().getBmininame()==null?"":insurancebase.getBOrgInformation().getBmininame();
			//生成线索ID
			int maxIndex = insurancebaseDao.getBaseMaxIndex(bmininame+DateUtil.formatDate(), insurancebase.getBOrgInformation().getOid().toString());
			String lineid = bmininame+DateUtil.formatDate()+maxIndex;
			insurancebase.setLineid(lineid);
			insurancebase.setCfile(suspiciousfilename);//补充附件文件名
			insurancebase.setUpdatetime(DateUtil.formatDateTime());
			insurancebase.setUpdateuser(username);

			FileUtils.copyFile(suspiciousFile, newFile);
			FileUtils.copyFile(suspiciousdataFile, dataFile);
			insurancebaseDao.save(insurancebase);//保存基本信息			
			insurancebaseDetailDao.batchSaveInsuranceBaseDetail(this.createInsuranceDetailFromFile(insurancebase, dataFile));//保存明细信息
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存保险业可疑信息异常");
		}		
	}

	public PaginaterList getInsuranceBaseInfo(Map<String, Object> params,Integer page) {
		logger.info("查询保险业可疑交易信息");		
		return insurancebaseDao.getInsuranceBaseInfo(params,page);
	}

	public Insurancebase findById(Integer id) {
		logger.info("查看保险业可疑交易信息");
		return (Insurancebase)insurancebaseDao.findById(id);
	}

	public String buildXlsInsurance(String username, String path,Map<String, Object> params) {		
		logger.info("导出保险业可疑交易信息到excel");				
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

		List<Insurancebase> insurancebases = insurancebaseDao.getInsuranceBaseInfoAll(params);

		for(Insurancebase info : insurancebases){
			List tmpList2 = new ArrayList();
			Parameter parameter = new Parameter();

			tmpList2.add(info.getBOrgInformation().getBname());			
			tmpList2.add(info.getUpdatetime());
			tmpList2.add(info.getLineid());			
			tmpList2.add(info.getCname());
//			tmpList2.add(info.getClamt().toString());			
			tmpList2.add(info.getCfamt().toString());			

			parameter.setList(tmpList2);			
			valueList.add(parameter);
		}

		map.put("ColumnName", headlist);
		map.put("DataContent", valueList);
		map.put("ColumnCount", columnCount);

		List nameList = new ArrayList();
		nameList.add("保险业可疑交易信息");		
		List countList = new ArrayList();
		countList.add("6");		

		map2.put("nameList", nameList);
		map2.put("countList", countList);

		XlsUtil xls = new XlsUtil();		
		filename = xls.build(DateUtil.formatDateTime(), path, "保险业可疑交易信息", "", username, map, map2);		
		System.out.println("-------------  filename ::  "+filename);		

		return filename;
	}

	public PaginaterList getInsuranceBaseDetailInfoById(Map<String, Object> params,Integer page) {
		logger.info("查询保险业可疑交易明细信息");		
		return insurancebaseDetailDao.getInsuranceBaseDetailInfoById(params,page);
	}

	public void addInsuranceDetail(Insurancedetail insurancedetail) {
		logger.info("保存保险业可疑交易明细信息");
		try{
			insurancebaseDetailDao.save(insurancedetail);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("保存保险业可疑交易明细信息异常");
		}
	}

	public Insurancedetail findDetailByDid(Long did) {
		logger.info("查看保险业可疑交易明细信息");
		return (Insurancedetail) insurancebaseDetailDao.findById(did);
	}

	public void updateInsuranceDetail(Insurancedetail insurancedetail) {
		logger.info("修改保险业可疑交易明细信息");
		try{
			insurancebaseDetailDao.saveOrUpdate(insurancedetail);		
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("修改保险业可疑交易明细信息异常");
		}
	}

	public void deleteInsurancedetailById(Long did) {
		logger.info("删除保险业可疑交易明细信息");
		try{
			insurancebaseDetailDao.deleteById(did);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("删除保险业可疑交易明细信息异常");
		}
	}

	public void setInsurancebaseDao(IInsurancebaseDao insurancebaseDao) {
		this.insurancebaseDao = insurancebaseDao;
	}


	public void setInsurancebaseDetailDao(IInsurancebaseDetailDao insurancebaseDetailDao) {
		this.insurancebaseDetailDao = insurancebaseDetailDao;
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
