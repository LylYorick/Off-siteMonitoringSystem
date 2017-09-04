package org.work.web.service.investigation.impl;

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
import org.work.web.dao.Investigation.IInvestigationDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.CheckRoster;
import org.work.web.service.investigation.IInvestigationService;
import org.work.web.util.PaginaterList;



public class InvestigationServiceImpl implements IInvestigationService{

	private static final Logger logger = Logger.getLogger(InvestigationServiceImpl.class);
	
	private IInvestigationDao investigationDao;
	
	
	public void setInvestigationDao(IInvestigationDao investigationDao) {
		this.investigationDao = investigationDao;
	}

	public PaginaterList getCheckRosterInfo(Map<String, Object> params,
			Integer page) {
		// TODO Auto-generated method stub
		return investigationDao.getCheckRosterInfo(params,page);
	}

	public void saveCheckRoster(CheckRoster checkroster, File checkFile,
			String checkFileFileName) {
		// TODO Auto-generated method stub
		logger.info("人行录入协查名单信息");
		String checkFileName = System.currentTimeMillis()  + "_rn_" + checkFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_CHECKDATA + "/" + checkFileName);		
		File newFile = new File(filename);
		try {
			if(checkFile==null)	
				throw new ServiceException("没有找到数据文件");			
			FileUtils.copyFile(checkFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(checkFile);
			//int maxId = investigationDao.getCheckMaxId();
			for(Map<String, String> map : list){
				CheckRoster cr = new CheckRoster();
				cr.setBackdate(checkroster.getBackdate());
				cr.setCheckid(checkroster.getCheckid());
				cr.setContent(checkroster.getContent());
				cr.setDescription(checkroster.getDescription());
				cr.setHandledby(checkroster.getHandledby());
				cr.setNote(checkroster.getNote());
				cr.setSenddate(checkroster.getSenddate());
				//cr.setSid("深反洗协【"+DateUtil.getCurrentYear()+"】"+maxId+"号");
				cr.setUnit(checkroster.getUnit());
				cr.setSubjectname(map.get("subname"));
				cr.setIdnumber(map.get("idnum"));
				investigationDao.save(cr);
				//maxId++;
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
				if(line.indexOf(",")==-1) throw new ServiceException("请用逗号分隔");
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
			// TODO: handle exception
			  throw new ServiceException("文件数据格式错误");
		  }finally{
			  LineIterator.closeQuietly(it);
		  }
		return list;
	}

	public CheckRoster findByCrid(Integer crid) {
		return (CheckRoster)investigationDao.findById(crid);
	}

	public void updateInvestigation(CheckRoster checkroster) {
		investigationDao.update(checkroster);
	}

	public void deleteByCrid(Integer crid) {
		investigationDao.deleteById(crid);
	}

}
