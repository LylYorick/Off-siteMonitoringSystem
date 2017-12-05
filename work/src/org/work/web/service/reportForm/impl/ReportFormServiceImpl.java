package org.work.web.service.reportForm.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.work.web.dao.reportForm.IReportFormDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.Information;
import org.work.web.po.ReportForm;
import org.work.web.service.reportForm.IReportFormService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

public class ReportFormServiceImpl  implements IReportFormService {
	
	private static final Logger logger = Logger.getLogger(ReportFormServiceImpl.class);

	private IReportFormDao reportFormDao;
	
	public IReportFormDao getReportFormDao() {
		return reportFormDao;
	}


	public void setReportFormDao(IReportFormDao reportFormDao) {
		this.reportFormDao = reportFormDao;
	}

	@Override
	public PaginaterList findReportFormMsg(Map<String, Object> params,
			Integer page) {
		return reportFormDao.getReportFormInfo(params, page);
	}
	
	@Override
	public void uploadReportForm(Archives archives, File[] ReportFormFile,String[] ReportFormFileFileName, String path, String buname) {
		logger.info("金融机构用户保存制度资料信息");
		ReportForm fileItem;
		fileItem = new ReportForm();	
		String fileNames ="";
		for(int i = 0;i<ReportFormFile.length;i++){
			String filename1 = System.currentTimeMillis()  + "_rn_" + ReportFormFileFileName[i];//把文件加个前缀，应对文件名重复的情况
			String filename = path +"/"+ filename1;
			logger.info(filename1);
			File newFile = new File(filename);
			try {
				FileUtils.copyFile(ReportFormFile[i], newFile);
			} catch (IOException e) {
				e.printStackTrace()	;
				logger.error(e.getMessage());
				throw new ServiceException("保存文件异常");
			}
			logger.info("保存成功");
			fileNames += filename1 +";";
		}
		if(!"".equals(fileNames)){
			fileNames =fileNames.substring(0, fileNames.length()-1);
		}
		fileItem.setBOrgArchives(archives);
		fileItem.setUp_time(DateUtil.formatDateTime());
		fileItem.setFile_name(fileNames);
		fileItem.setFile_url(path);
		fileItem.setFile_type("1");//暂时写死
		fileItem.setUp_user(buname);
		fileItem.setCnt(0);
		reportFormDao.save(fileItem);	
	}

	@Override
	public ReportForm findById(Integer ins_id) {		
		return (ReportForm)reportFormDao.findById(ins_id);
	}
	
	@Override
	public void delete(ReportForm reportForm){
		 reportFormDao.delete(reportForm);
	}
	
	@Override
	public void updateCnt(ReportForm reportForm){
		logger.info("下载资料次数增加");
		reportForm.setCnt(reportForm.getCnt()+1);
		reportFormDao.saveOrUpdate(reportForm);
	}
}
