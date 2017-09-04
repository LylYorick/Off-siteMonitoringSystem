package org.work.web.service.information.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


import org.work.web.constants.Constants;

import org.work.web.dao.information.IInformationSurDao;
import org.work.web.exception.ServiceException;

import org.work.web.po.Inquiryarchives;

import org.work.web.service.information.IInformationService;

import org.work.web.util.PaginaterList;


public class InformationServiceImpl implements IInformationService{
	private static final Logger logger = Logger.getLogger(InformationServiceImpl.class);
	
	private IInformationSurDao informationSurDao;
	
	public void setInformationSurDao(IInformationSurDao informationSurDao) {
		this.informationSurDao = informationSurDao;
	}

	public PaginaterList getInquiryArchivesInfo(Map<String, Object> params,
			Integer page) {
		return informationSurDao.getInquiryArchivesInfo(params,page);
	}

	public void saveSurvey(Inquiryarchives inquiryarchives, File surveyFile,
			String surveyFileFileName) {
		logger.info("人行录入调查档案信息");	
		String surveyFileName = System.currentTimeMillis()  + "_rn_" + surveyFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_SURVEYDATA + "/" + surveyFileName);		
		File newFile = new File(filename);
		try {
			if(surveyFile==null) throw new ServiceException("没有找到数据文件");
				FileUtils.copyFile(surveyFile, newFile);
				List<Map<String, String>> list = ParseTXTFile(surveyFile);
				for(Map<String, String> map : list){
					Inquiryarchives ia = new Inquiryarchives();
					ia.setApprovalid(inquiryarchives.getApprovalid());
					ia.setDate(inquiryarchives.getDate());
					ia.setFeedbacktime(inquiryarchives.getFeedbacktime());
					ia.setLetterid(inquiryarchives.getLetterid());
					ia.setLettertime(inquiryarchives.getLettertime());
					ia.setOrgname(inquiryarchives.getOrgname());
					ia.setRealtime(inquiryarchives.getRealtime());
					ia.setSubjectname(map.get("subname"));
					ia.setIdnumber(map.get("idnum"));
					informationSurDao.save(ia);
				}
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存异常");
		}	
	}

	public List<Map<String,String>> ParseTXTFile(File file)throws IOException{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		LineIterator it = FileUtils.lineIterator(file);
		try {
			int count = 0;
			while (it.hasNext()) {
				count++;
				String line = it.nextLine();
				if(line.indexOf(",")==-1) 
					throw new ServiceException("请用逗号分隔");
				String[] strs = line.split(",");
				if(strs.length!=2){
					throw new ServiceException("数据内容为：主体名称 主体账号");
				}
				if(strs[0].length()>20||strs[0].length()==0){
					throw new ServiceException("主体长度不正确");
				}
				Map<String, String> map = new HashMap<String, String>();
				map.put("subname",strs[0]);
				map.put("idnum",strs[1]);
				list.add(map);
			}
			System.out.println("行数 :: "+count); 
		  }catch (Exception e) {			
			  throw new ServiceException("文件数据格式错误");
		  }finally{
			  LineIterator.closeQuietly(it);
		  }
		return list;
	}
	
	public void updateSurvey(Inquiryarchives inquiryarchives) {
		this.informationSurDao.update(inquiryarchives);
	}

	public Inquiryarchives findByIaid(Integer iaid) {
		return (Inquiryarchives) informationSurDao.findById(iaid);
	}

	public void deletesurvey(Integer iaid) {
		this.informationSurDao.deleteById(iaid);
	}
}
