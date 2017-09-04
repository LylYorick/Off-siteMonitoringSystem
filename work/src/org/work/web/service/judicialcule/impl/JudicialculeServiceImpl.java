package org.work.web.service.judicialcule.impl;

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
import org.work.web.dao.judicialcule.IJudicialculeDao;
import org.work.web.exception.ServiceException;

import org.work.web.po.Judicialsource;
import org.work.web.service.judicialcule.IJudicialculeService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

public class JudicialculeServiceImpl implements IJudicialculeService{
	
	private static final Logger logger = Logger.getLogger(JudicialculeServiceImpl.class);
	private IJudicialculeDao judicialculeDao;

	public void setJudicialculeDao(IJudicialculeDao judicialculeDao) {
		this.judicialculeDao = judicialculeDao;
	}

	public void deleteByRsid(Integer jsid) {
		judicialculeDao.deleteById(jsid);
	}

	public Judicialsource findByjsid(Integer jsid) {
		Object obj = judicialculeDao.findById(jsid);
		if(obj==null)
			throw new ServiceException("此记录不存在");
		else return (Judicialsource)obj;
	}

	public PaginaterList getJudicialSourceInfo(Map<String, Object> params, Integer page) {
		return judicialculeDao.getJudicialSourceInfo(params,page);
	}

	public void saveJudicialSource(Judicialsource judicialsource, File judicialculeFile, String judicialculeFileFileName) {
		logger.info("人行录入线索来源司法机关信息");
		if(judicialculeFile==null) 
			throw new ServiceException("没有找到数据文件");
		String FileName = System.currentTimeMillis()  + "_rn_" + judicialculeFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_JUDICIALSOURCEDATA + "/" + FileName);		
		File newFile = new File(filename);
		try {
			FileUtils.copyFile(judicialculeFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(judicialculeFile);
			int maxId = judicialculeDao.getJudiciaMaxId();
			for(Map<String, String> map : list){
				Judicialsource js = new Judicialsource();
				js.setAccountnum(judicialsource.getAccountnum());
				js.setAmountSituation(judicialsource.getAmountSituation());
				js.setAntisponsor(judicialsource.getAntisponsor());
				js.setApprovalno(judicialsource.getApprovalno());
				js.setDate(judicialsource.getDate());
				js.setDealresult(judicialsource.getDealresult());
				js.setFeedbackdate(judicialsource.getFeedbackdate());
				js.setFeedbackno(judicialsource.getFeedbackno());
				js.setFinaname(judicialsource.getFinaname());
				js.setFinannum(judicialsource.getFinannum());
				js.setLetterid(judicialsource.getLetterid());
				js.setCasename(judicialsource.getCasename());
				js.setTypeofcrime(judicialsource.getTypeofcrime());
				js.setCluessource(judicialsource.getCluessource());
				js.setInvolvenum(judicialsource.getInvolvenum());
				js.setIsinvolved(judicialsource.getIsinvolved());
				js.setNotes(judicialsource.getNotes());
				js.setPaymentletterid(judicialsource.getPaymentletterid());
				js.setRecordeno(judicialsource.getRecordeno());
				js.setSurveyname(judicialsource.getSurveyname());
				js.setSendresearch(judicialsource.getSendresearch());
				js.setSponsor(judicialsource.getSponsor());
				//js.setTotalid(judicialsource.getTotalid());
				js.setUnit(judicialsource.getUnit());
				js.setSubjectname((map.get("subname")));
				js.setIdnumber(map.get("idnum"));
				js.setJid("深反洗司【"+DateUtil.getCurrentYear()+"】"+maxId+"号");
				judicialculeDao.save(js);//保存信息
				maxId++;
			}
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存异常");
		}	
	}

	public void update(Judicialsource judicialsource) {
		judicialculeDao.update(judicialsource);
		
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
	
}
