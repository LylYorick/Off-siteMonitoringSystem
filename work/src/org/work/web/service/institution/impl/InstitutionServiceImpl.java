package org.work.web.service.institution.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.work.web.dao.institution.IInstitutionDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Information;
import org.work.web.po.Institution;
import org.work.web.service.institution.IInstitutionService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

public class InstitutionServiceImpl  implements IInstitutionService {
	
	private static final Logger logger = Logger.getLogger(InstitutionServiceImpl.class);

	private IInstitutionDao institutionDao;
	
	public IInstitutionDao getInstitutionDao() {
		return institutionDao;
	}


	public void setInstitutionDao(IInstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}

	@Override
	public PaginaterList findInstitutionMsg(Map<String, Object> params,
			Integer page) {
		return institutionDao.getInstitutionInfo(params, page);
	}
	
	@Override
	public void uploadInstitution(Information infomation, File[] InstitutionFile,String[] InstitutionFileFileName, String path, String buname) {
		logger.info("金融机构用户保存制度资料信息");
		Institution fileItem;
		fileItem = new Institution();	
		String fileNames ="";
		for(int i = 0;i<InstitutionFile.length;i++){
			String filename1 = System.currentTimeMillis()  + "_rn_" + InstitutionFileFileName[i];//把文件加个前缀，应对文件名重复的情况
			String filename = path +"/"+ filename1;
			logger.info(filename1);
			File newFile = new File(filename);
			try {
				FileUtils.copyFile(InstitutionFile[i], newFile);
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
		fileItem.setBOrgInformation(infomation);
		fileItem.setUp_time(DateUtil.formatDateTime());
		fileItem.setFile_name(fileNames);
		fileItem.setFile_url(path);
		fileItem.setFile_type("1");//暂时写死
		fileItem.setUp_user(buname);
		fileItem.setCnt(0);
		institutionDao.save(fileItem);	
	}

	@Override
	public Institution findById(Integer ins_id) {		
		return (Institution)institutionDao.findById(ins_id);
	}
	
	@Override
	public void delete(Institution institution){
		 institutionDao.delete(institution);
	}
	
	@Override
	public void updateCnt(Institution institution){
		logger.info("下载资料次数增加");
		institution.setCnt(institution.getCnt()+1);
		institutionDao.saveOrUpdate(institution);
	}
}
