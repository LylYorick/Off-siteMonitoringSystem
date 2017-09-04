package org.work.web.service.headcule.impl;

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
import org.work.web.dao.headcule.IHeadculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Headofficesource;
import org.work.web.service.headcule.IHeadculeService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;


public class HeadculeServiceImpl implements IHeadculeService{

	private static final Logger logger = Logger.getLogger(HeadculeServiceImpl.class);
	private IHeadculeDao headculeDao;
	public void setHeadculeDao(IHeadculeDao headculeDao) {
		this.headculeDao = headculeDao;
	}
	public void deleteByRsid(Integer hosid) {
		headculeDao.deleteById(hosid);
		
	}
	public Headofficesource findById(Integer hosid) {
		return (Headofficesource)headculeDao.findById(hosid);
	}
	public PaginaterList getHeadSourceInfo(Map<String, Object> params,
			Integer page) {
		
		return headculeDao.getHeadSourceInfo(params,page);
	}
	public void saveHeadSource(Headofficesource headofficesource, File headculeFile, String headculeFileFileName) {
		logger.info("人行录入线索来源总行或兄弟行信息");
		if(headculeFile==null) 
			throw new ServiceException("没有找到数据文件");
		String FileName = System.currentTimeMillis()  + "_rn_" + headculeFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_HEADOFFICESOURCEDATA + "/" + FileName);		
		File newFile = new File(filename);
		try {
			FileUtils.copyFile(headculeFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(headculeFile);
			int maxId = headculeDao.getHeadMaxId();
			for(Map<String, String> map : list){
				Headofficesource hs = new Headofficesource();
				hs.setAccountnum(headofficesource.getAccountnum());
				hs.setAmountSituation(headofficesource.getAmountSituation());
				hs.setAntisponsor(headofficesource.getAntisponsor());
				hs.setApprovalno(headofficesource.getApprovalno());
				hs.setDate(headofficesource.getDate());
				hs.setDealresult(headofficesource.getDealresult());
				hs.setFeedbackdate(headofficesource.getFeedbackdate());
				hs.setFeedbackno(headofficesource.getFeedbackno());
				hs.setFinaname(headofficesource.getFinaname());
				hs.setFinannum(headofficesource.getFinannum());
				hs.setInvestigation(headofficesource.getInvestigation());
				hs.setInvolvenum(headofficesource.getInvolvenum());
				hs.setIsinvolved(headofficesource.getIsinvolved());
				hs.setLetterid(headofficesource.getLetterid());
				hs.setNotes(headofficesource.getNotes());
				hs.setPaymentletterid(headofficesource.getPaymentletterid());
				hs.setRecordeno(headofficesource.getRecordeno());
				hs.setSendresearch(headofficesource.getSendresearch());
				hs.setSource(headofficesource.getSource());
				hs.setSponsor(headofficesource.getSponsor());
				hs.setSurveyname(headofficesource.getSurveyname());
				//hs.setTotalid(headofficesource.getTotalid());
				hs.setSubjectname((map.get("subname")));
				hs.setIdnumber(map.get("idnum"));
				hs.setHid("深反洗总【"+DateUtil.getCurrentYear()+"】"+maxId+"号");
				headculeDao.save(hs);//保存信息
				maxId++;
			}
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存异常");
		}	
	}
	public void update(Headofficesource headofficesource) {
		headculeDao.update(headofficesource);
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
		  }catch (Exception e) {
			  throw new ServiceException("文件数据格式错误");
		  }finally{
			  LineIterator.closeQuietly(it);
		  }
		return list;
	}
	
}
