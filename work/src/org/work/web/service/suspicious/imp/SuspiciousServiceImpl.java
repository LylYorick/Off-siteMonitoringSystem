/**
 * 
 */
package org.work.web.service.suspicious.imp;

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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts2.ServletActionContext;
import org.work.web.constants.Constants;
import org.work.web.dao.suspicious.IBankbaseDao;
import org.work.web.dao.suspicious.IBankbaseDetailDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Bankbase;
import org.work.web.po.Basedetail;
import org.work.web.service.suspicious.ISuspiciousService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.Parameter;
import org.work.web.util.XlsUtil;

public class SuspiciousServiceImpl implements ISuspiciousService{
	private static final Logger logger = Logger.getLogger(SuspiciousServiceImpl.class);
	private IBankbaseDao bankbaseDao;
	private IBankbaseDetailDao bankbaseDetailDao;

	/**
	 * 由数据文件生成银行业可疑交易明细数据	 
	 * @param bname 金融机构名称
	 * @param bankbase
	 * @param file 数据文件，txt格式
	 * @return
	 * @throws IOException
	 */
	List<Basedetail> createBaseDetailFromFile(Bankbase bankbase,File file) throws IOException{
		List<Basedetail> list = new ArrayList();
		Basedetail basedetail = new Basedetail();		
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
			if (row.getRowNum()>2) {
				if("".equals(row.getCell(0)) || null==row.getCell(0) ){
					break;
				}else{
					if ("".equals(getValue(row.getCell(0))) || "填表人及联系电话".equals(getValue(row.getCell(0)))) {
						break;
					}
				}
				System.out.println("---"+row.getCell(0));
				basedetail = new Basedetail();
				basedetail.setBBankBase(bankbase);
				basedetail.setBname(bankbase.getBOrgInformation().getBname());	
				basedetail.setLamt("".equals(getValue(row.getCell(15)))?null:Double.valueOf(getValue(row.getCell(15))));
				basedetail.setFmat("".equals(getValue(row.getCell(16)))?null:Double.valueOf(getValue(row.getCell(16))));
				basedetail.setAccount(getValue(row.getCell(2)));						
				basedetail.setTrandate(getValue(row.getCell(3)));
				basedetail.setTranmethod(getValue(row.getCell(4)));
				basedetail.setFid(getValue(row.getCell(5)));
				basedetail.setRorp(getValue(row.getCell(6)));
				basedetail.setUse(getValue(row.getCell(7)));
				basedetail.setOoname(getValue(row.getCell(8)));
				basedetail.setOoid(getValue(row.getCell(9)));
				basedetail.setOtaccount(getValue(row.getCell(10)));
				basedetail.setOttype(getValue(row.getCell(11)));
				basedetail.setOtid(getValue(row.getCell(12)));
				basedetail.setOtname(getValue(row.getCell(13)));
				basedetail.setCurrency(getValue(row.getCell(14)));
				basedetail.setTid(getValue(row.getCell(17)));
				basedetail.setAgname(getValue(row.getCell(18)));
				basedetail.setAgid(getValue(row.getCell(19)));
				basedetail.setRemark(getValue(row.getCell(20)));
				list.add(basedetail);
			}
		}

		return list;
	}

	public void setBankbaseDao(IBankbaseDao bankbaseDao) {
		this.bankbaseDao = bankbaseDao;
	}
	public void setBankbaseDetailDao(IBankbaseDetailDao bankbaseDetailDao) {
		this.bankbaseDetailDao = bankbaseDetailDao;
	}

	public void saveBankData(Bankbase bankbase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,
			String username) {
		logger.info("金融机构用户录入重点可疑交易信息");		
//		System.out.println(suspiciousFileFileName + "  ::::   "+suspiciousdataFileFileName);		
		String datafimename = System.currentTimeMillis()  + "_rn_" + suspiciousdataFileFileName;
		String filenamedata = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUSDATA + "/" + datafimename);
		String suspiciousfilename = System.currentTimeMillis()  + "_rn_" + suspiciousFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_SUSPICIOUS + "/" + suspiciousfilename);
		File newFile = new File(filename);
		File dataFile = new File(filenamedata);		
//		System.out.println(datafimename + "  ======   "+suspiciousfilename);
		try {
			String bmininame = bankbase.getBOrgInformation().getBmininame()==null?"":bankbase.getBOrgInformation().getBmininame();
			//生成线索ID
			int maxIndex = bankbaseDao.getBaseMaxIndex(bmininame+DateUtil.formatDate(), bankbase.getBOrgInformation().getOid().toString());
			String lineid = bmininame+DateUtil.formatDate()+maxIndex;
			bankbase.setLineid(lineid);
			bankbase.setUpdatetime(DateUtil.formatDateTime());
			bankbase.setUpdateuser(username);

			if(suspiciousFile!=null){
				FileUtils.copyFile(suspiciousFile, newFile);
				bankbase.setCfile(suspiciousfilename);//补充附件文件名
			}
			FileUtils.copyFile(suspiciousdataFile, dataFile);
			bankbaseDao.save(bankbase);//保存基本信息			
			bankbaseDetailDao.batchSaveBankBaseDetail(this.createBaseDetailFromFile(bankbase, dataFile));//保存明细信息
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存异常");
		}		
	}

	public PaginaterList getBankBaseInfo(Map<String, Object> params,Integer page) {
		logger.info("查询银行业可疑交易信息");		
		return bankbaseDao.getBankBaseInfo(params,page);
	}

	public Bankbase findById(Integer id) {
		logger.info("查看银行业可疑交易信息明细");
		return (Bankbase)bankbaseDao.findById(id);
	}

	public String buildXlsBank(String username, String path,Map<String, Object> params) {		
		logger.info("导出金融机构银行业可疑交易信息到excel");				
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

		List<Bankbase> bankbases = bankbaseDao.getBankBaseInfoAll(params);

		for(Bankbase info : bankbases){
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
		nameList.add("银行业可疑交易信息");		
		List countList = new ArrayList();
		countList.add("6");		

		map2.put("nameList", nameList);
		map2.put("countList", countList);

		XlsUtil xls = new XlsUtil();		
		filename = xls.build(DateUtil.formatDateTime(), path, "银行业可疑交易信息", "", username, map, map2);		
		System.out.println("-------------  filename ::  "+filename);		

		return filename;
	}

	public PaginaterList getBankBaseDetailInfoById(Map<String, Object> params,Integer page) {
		logger.info("查询银行业可疑交易明细信息");		
		return bankbaseDetailDao.getBankBaseDetailInfoById(params,page);
	}

	public void addBankDetail(Basedetail basedetail) {
		logger.info("保存银行业可疑交易明细信息");
		try{
			bankbaseDetailDao.save(basedetail);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("保存银行业可疑交易明细信息异常");
		}
	}

	public Basedetail findDetailByDid(Long did) {
		logger.info("查看银行业可疑交易明细信息");
		return (Basedetail) bankbaseDetailDao.findById(did);
	}

	public void updateBankDetail(Basedetail basedetail) {
		logger.info("修改银行业可疑交易明细信息");
		try{
			bankbaseDetailDao.saveOrUpdate(basedetail);		
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("修改银行业可疑交易明细信息异常");
		}
	}

	public void deleteBasedetailById(Long did) {
		logger.info("删除银行业可疑交易明细信息");
		try{
			bankbaseDetailDao.deleteById(did);
		}catch(Exception e){
			logger.info(e);
			throw new ServiceException("删除银行业可疑交易明细信息异常");
		}
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
