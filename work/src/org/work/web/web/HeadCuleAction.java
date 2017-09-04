package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Headofficesource;
import org.work.web.service.headcule.IHeadculeService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class HeadCuleAction extends JsonBaseAction implements ModelDriven<Headofficesource>{

	private IHeadculeService headculeService;
	private Headofficesource headofficesource = new Headofficesource();
	
	private Integer hosid;
	private String surveyname;//调查名称
	private String hid;//案件总编号
	private String source;//来源
	private String starttime;
	private String endtime;
	private File headculeFile;
	private String headculeFileFileName;
	public void setHeadculeService(IHeadculeService headculeService) {
		this.headculeService = headculeService;
	}

	public Integer getHosid() {
		return hosid;
	}

	public void setHosid(Integer hosid) {
		this.hosid = hosid;
	}

	@JSON(serialize = false)
	public String getSurveyname() {
		return surveyname;
	}

	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}

	@JSON(serialize = false)
	public String getHid() {
		return hid;
	}
	
	public void setHid(String hid) {
		this.hid = hid;
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

	public File getHeadculeFile() {
		return headculeFile;
	}

	public void setHeadculeFile(File headculeFile) {
		this.headculeFile = headculeFile;
	}

	public String getHeadculeFileFileName() {
		return headculeFileFileName;
	}

	public void setHeadculeFileFileName(String headculeFileFileName) {
		this.headculeFileFileName = headculeFileFileName;
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
	public Headofficesource getModel() {
		return headofficesource;
	}
	/**
	 * 线索来源（司法机关）
	 * @return
	 */
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        session.remove("hid");
        session.remove("source");
        session.remove("surveyname");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	
	public String add(){
		return SUCCESS;
	}
	
	public String save() {
		headculeService.saveHeadSource(headofficesource,headculeFile,headculeFileFileName);
		info("添加成功...");
		log("保存线索来源总行或兄弟行信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        if(hid!=null){
        	session.put("hid", hid);
        }
        if(source!=null){
        	session.put("source", source);
        }
        if(surveyname!=null){
        	session.put("surveyname", surveyname);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("hid", session.get("hid"));
		params.put("source", session.get("source"));
		params.put("surveyname", session.get("surveyname"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = headculeService.getHeadSourceInfo(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		//setSidx("");
		//setSord("asc");
		return JSON;
	}
	
	public String modify(){
		if(hosid==null)
			throw new ServiceException("没有指定信息");
		Headofficesource hs = headculeService.findById(hosid);
		this.put("info", hs);
		return SUCCESS;
	}
	
	public String update(){
		headculeService.update(headofficesource);
		return OK;
	}
	
	public String delete(){
		if(hosid==null)
			throw new ServiceException("没有指定信息");
		headculeService.deleteByRsid(hosid);
		return OK;
	}
}
