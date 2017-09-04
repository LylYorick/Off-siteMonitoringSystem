package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.ActiveSource;

import org.work.web.service.activecule.IActiveculeService;

import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class ActiveculeAction extends JsonBaseAction implements ModelDriven<ActiveSource>{

	private ActiveSource activesource = new ActiveSource();
	private IActiveculeService activeculeService;
	
	private String starttime;
	private String endtime;
	private Integer asid;//主键
	private String aid;//案件总编号
	private String surveyname;//调查名称
	private String source;//来源
	private File activeculeFile;
	private String activeculeFileFileName;	
	
	public Integer getAsid() {
		return asid;
	}

	public void setAsid(Integer asid) {
		this.asid = asid;
	}

	@JSON(serialize = false)
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	@JSON(serialize = false)
	public String getSurveyname() {
		return surveyname;
	}

	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}
	
	@JSON(serialize = false)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@JSON(serialize = false)
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@JSON(serialize = false)
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public File getActiveculeFile() {
		return activeculeFile;
	}

	public void setActiveculeFile(File activeculeFile) {
		this.activeculeFile = activeculeFile;
	}

	public String getActiveculeFileFileName() {
		return activeculeFileFileName;
	}

	public void setActiveculeFileFileName(String activeculeFileFileName) {
		this.activeculeFileFileName = activeculeFileFileName;
	}

	public void setActiveculeService(IActiveculeService activeculeService) {
		this.activeculeService = activeculeService;
	}

	@Override
	public List getGridModel() {
		
		return this.gridModel;
	}

	@Override
	public Integer getPage() {
		
		return this.page;
	}

	@Override
	public Integer getRecords() {
		
		return this.record;
	}

	@Override
	public Integer getRows() {
		
		return this.rows;
	}

	@Override
	public String getSidx() {
		
		return this.sidx;
	}

	@Override
	public String getSord() {
		
		return this.sord;
	}

	@Override
	public Long getTotal() {
		
		return this.total;
	}
	
	@JSON(serialize = false)
	public ActiveSource getModel() {
		return activesource;
	}
	
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        session.remove("aid");
        session.remove("surveyname");
        session.remove("source");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	/**
	 * 线索来源主动调查
	 * @return
	 */
	public String add() {
		return SUCCESS;
	}

	public String save() {
		activeculeService.saveActiveSource(activesource,activeculeFile,activeculeFileFileName);
		info("添加成功...");
		log("保存线索之主动调查信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        if(aid!=null){
        	session.put("aid", aid);
        }
        if(surveyname!=null){
        	session.put("surveyname", surveyname);
        }
        if(source!=null){
        	session.put("source", source);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("aid", session.get("aid"));
		params.put("surveyname", session.get("surveyname"));
		params.put("source", session.get("source"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = activeculeService.getActiveSourceInfo(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		return JSON;
	}
	
	public String modify(){
		if(asid==null)
			throw new ServiceException("没有指定信息");
		ActiveSource aSource = activeculeService.findByAsId(asid);
		this.put("info", aSource);
		return SUCCESS;
	}
	
	public String update(){
		activeculeService.update(activesource);
		log("修改线索之主动调查信息", Constants.LOG_TYPE_UPDATE);
		return OK;
	}
	
	public String delete(){
		if(asid==null)
			throw new ServiceException("没有指定信息");
		activeculeService.delete(asid);
		log("删除线索之主动调查信息", Constants.LOG_TYPE_DELETE);
		return OK;
	}
}
