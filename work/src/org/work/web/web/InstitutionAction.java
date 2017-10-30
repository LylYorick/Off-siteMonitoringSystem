package org.work.web.web;

import java.util.List;

import org.apache.log4j.Logger;

public class InstitutionAction  extends JsonBaseAction{

	
	private static final Logger logger = Logger.getLogger(InstitutionAction.class);
	@Override
	public List getGridModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSidx() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 *金融机构制度管理（人行端）
	 */
	public String institutionBankManager(){
		logger.info("***");
		
		logger.info("金融机构制度管理（人行端）");
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理（机构端）
	 */
	public String institutionManager(){
		logger.info("***");
		
		logger.info("金融机构制度管理（人行端）");
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理-上传制度
	 */
	public String institutionAdd(){
		logger.info("***");
		
		logger.info("金融机构制度管理-上传制度");
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理-修改制度
	 */
	public String institutionModify(){
		logger.info("***");
		
		logger.info("金融机构制度管理-修改制度");
		return SUCCESS;
	}
}
