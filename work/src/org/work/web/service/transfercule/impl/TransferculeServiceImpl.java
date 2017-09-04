package org.work.web.service.transfercule.impl;

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
import org.work.web.dao.transfercule.ITransferculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Transfersource;
import org.work.web.service.transfercule.ITransferculeService;
import org.work.web.util.PaginaterList;

public class TransferculeServiceImpl implements ITransferculeService{
	
	private static final Logger logger = Logger.getLogger(TransferculeServiceImpl.class);
	private ITransferculeDao transferculeDao;

	public void setTransferculeDao(ITransferculeDao transferculeDao) {
		this.transferculeDao = transferculeDao;
	}

	public Transfersource findById(Integer tsid) {
		return (Transfersource)transferculeDao.findById(tsid);
	}

	public void update(Transfersource transfersource) {
		transferculeDao.update(transfersource);
	}

	public PaginaterList getTransferSourceInfo(Map<String, Object> params,
			Integer page) {
		return transferculeDao.getTransferSourceInfo(params,page);
	}

	public void saveTransferSource(Transfersource transfersource,
			File transfersourceFile, String transfersourceFileFileName) {
		logger.info("人行录入线索来源总行或兄弟行信息");
		if(transfersourceFile==null) 
			throw new ServiceException("没有找到数据文件");
		String FileName = System.currentTimeMillis()  + "_rn_" + transfersourceFileFileName;
		String filename = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INFOR_TRANSFERSOURCEDATA + "/" + FileName);		
		File newFile = new File(filename);
		try {
			FileUtils.copyFile(transfersourceFile, newFile);
			List<Map<String, String>> list = ParseTXTFile(transfersourceFile);
			for(Map<String, String> map : list){
				Transfersource ts = new Transfersource();
				ts.setTransfersymbol(transfersource.getTransfersymbol());
				ts.setDealresult(transfersource.getDealresult());
				ts.setHandledby(transfersource.getHandledby());
				ts.setHandledperson(transfersource.getHandledperson());
				ts.setIsplacedonfile(transfersource.getIsplacedonfile());
				ts.setNotes(transfersource.getNotes());
				ts.setReceivingunit(transfersource.getReceivingunit());
				ts.setSourcecase(transfersource.getSourcecase());
				ts.setTransferamout(transfersource.getTransferamout());
				ts.setTransferdate(transfersource.getTransferdate());
				ts.setSubjectname((map.get("subname")));
				ts.setIdnumber(map.get("idnum"));
				transferculeDao.save(ts);//保存信息
			}
		} catch (Exception e) {			
			logger.error(e);
			throw new ServiceException("保存异常");
		}		
	}

	public void deleteById(Integer tsid) {
		transferculeDao.deleteById(tsid);
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
