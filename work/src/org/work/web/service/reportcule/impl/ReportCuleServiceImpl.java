package org.work.web.service.reportcule.impl;

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
import org.work.web.dao.reportcule.IReportculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.ReportSource;

import org.work.web.service.reportcule.IReportCuleService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

public class ReportCuleServiceImpl implements IReportCuleService{

	private static final Logger logger = Logger.getLogger(ReportCuleServiceImpl.class);
	private IReportculeDao reportculeDao;
	public void setReportculeDao(IReportculeDao reportculeDao) {
		this.reportculeDao = reportculeDao;
	}

	public PaginaterList getReportSourceInfo(Map<String, Object> params,
			Integer page) {
		return reportculeDao.getReportSourceInfo(params,page);
	}

	public void saveReportSource(ReportSource reportsource,File reportculeFile, String reportculeFileFileName) {
		logger.info("人行录入线索来源举报或者专报信息");
		if(reportculeFile==null) 
			throw new ServiceException("没有找到数据文件");
		String FileName = System.currentTimeMillis()  + "_rn_" + reportculeFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_REPORTSOURCEDATA + "/" + FileName);		
		File newFile = new File(filename);
		try {
			FileUtils.copyFile(reportculeFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(reportculeFile);
			int maxId = reportculeDao.getReportMaxId();
			for(Map<String, String> map : list){
				ReportSource rs = new ReportSource();
				rs.setAccountnum(reportsource.getAccountnum());
				rs.setAmountSituation(reportsource.getAmountSituation());
				rs.setAntisponsor(reportsource.getAntisponsor());
				rs.setDate(reportsource.getDate());
				rs.setDealresult(reportsource.getDealresult());
				rs.setFeedbackdate(reportsource.getFeedbackdate());
				rs.setFeedbackno(reportsource.getFeedbackno());
				rs.setFinaname(reportsource.getFinaname());
				rs.setFinannum(reportsource.getFinannum());
				rs.setInvestigation(reportsource.getInvestigation());
				rs.setInvolvenum(reportsource.getInvolvenum());
				rs.setIsinvolved(reportsource.getIsinvolved());
				rs.setNote(reportsource.getNote());
				rs.setPaymentletterid(reportsource.getPaymentletterid());
				rs.setRecordeno(reportsource.getRecordeno());
				rs.setResearchname(reportsource.getResearchname());
				rs.setSendresearch(reportsource.getSendresearch());
				rs.setSponsor(reportsource.getSponsor());
				//rs.setTotalid(reportsource.getTotalid());
				rs.setUnit(reportsource.getUnit());
				rs.setSubjectname((map.get("subname")));
				rs.setIdnumber(map.get("idnum"));
				rs.setRid("深反洗举【"+DateUtil.getCurrentYear()+"】"+maxId+"号");
				reportculeDao.save(rs);//保存信息
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

	public ReportSource findByrsid(Integer rsid) {
		Object object = reportculeDao.findById(rsid);
		if(object==null)
			throw new ServiceException("此记录不存在");
		else return (ReportSource) object;
	}

	public void update(ReportSource reportsource) {
		reportculeDao.saveOrUpdate(reportsource);
	}

	public void deleteByRsid(Integer rsid) {
		reportculeDao.deleteById(rsid);
	}
	
	
}
