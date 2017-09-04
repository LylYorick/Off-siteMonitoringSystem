package org.work.web.service.activecule.impl;

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
import org.work.web.dao.activecule.IActiveculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.ActiveSource;
import org.work.web.service.activecule.IActiveculeService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

public class ActiveculeServiceImpl implements IActiveculeService{

	private static final Logger logger = Logger.getLogger(ActiveculeServiceImpl.class);
	private IActiveculeDao activeculeDao;
	public void setActiveculeDao(IActiveculeDao activeculeDao) {
		this.activeculeDao = activeculeDao;
	}

	public PaginaterList getActiveSourceInfo(Map<String, Object> params,
			Integer page) {
		
		return activeculeDao.getActiveSourceInfo(params,page);
	}

	public void saveActiveSource(ActiveSource activesource,
			File activeculeFile, String activeculeFileFileName) {
		logger.info("人行录入线索来源主动调查信息");
		String FileName = System.currentTimeMillis()  + "_rn_" + activeculeFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_ACTIVESOURCEDATA + "/" + FileName);		
		File newFile = new File(filename);
		try {
			if(activeculeFile==null) 
				throw new ServiceException("没有找到数据文件");
			FileUtils.copyFile(activeculeFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(activeculeFile);
			int maxId = activeculeDao.getActiveMaxId();
			for(Map<String, String> map : list){
				ActiveSource as = new ActiveSource();
				as.setAccountnum(activesource.getAccountnum());
				as.setAntisponsor(activesource.getAntisponsor());
				as.setFeedbackdate(activesource.getFeedbackdate());
				as.setDate(activesource.getFeedbackdate());
				as.setApprovalno(activesource.getApprovalno());
				as.setDealresult(activesource.getDealresult());
				as.setFeedbackno(activesource.getFeedbackno());
				as.setFinaname(activesource.getFinaname());
				as.setFinannum(activesource.getFinannum());
				as.setInvestigation(activesource.getInvestigation());
				as.setAmountSituation(activesource.getAmountSituation());
				as.setInvolvenum(activesource.getInvolvenum());
				as.setIsinvolved(activesource.getIsinvolved());
				as.setSurveyname(activesource.getSurveyname());
				//as.setTotalid(activesource.getTotalid());
				as.setSource(activesource.getSource());
				as.setSponsor(activesource.getSponsor());
				as.setLetterid(activesource.getLetterid());
				as.setPaymentletterid(activesource.getPaymentletterid());
				as.setSendresearch(activesource.getSendresearch());
				as.setRecordeno(activesource.getRecordeno());
				as.setNotes(activesource.getNotes());
				as.setAid("深反洗主【"+DateUtil.getCurrentYear()+"】"+maxId+"号");
				as.setSubjectname(map.get("subname"));
				as.setIdnumber(map.get("idnum"));
				activeculeDao.save(as);
				maxId++;
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

	public ActiveSource findByAsId(Integer asid) {
		return (ActiveSource)activeculeDao.findById(asid);
	}

	public void update(ActiveSource activesource) {
		activeculeDao.update(activesource);
	}

	public void delete(Integer asid) {
		activeculeDao.deleteById(asid);
	}

}
