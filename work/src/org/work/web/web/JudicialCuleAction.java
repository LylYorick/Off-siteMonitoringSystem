package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Judicialsource;
import org.work.web.service.judicialcule.IJudicialculeService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class JudicialCuleAction extends JsonBaseAction implements ModelDriven<Judicialsource>{

	private IJudicialculeService judicialculeService;
	private Judicialsource judicialsource = new Judicialsource();
	private File judicialculeFile;
	private String judicialculeFileFileName;
	private String surveyname;//调查名称
	private String jid;//案件总编号
	private String unit;//来函单位
	private String starttime;
	private String endtime;
	private Integer jsid;
	
	public Integer getJsid() {
		return jsid;
	}

	public void setJsid(Integer jsid) {
		this.jsid = jsid;
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

	public File getJudicialculeFile() {
		return judicialculeFile;
	}

	public void setJudicialculeFile(File judicialculeFile) {
		this.judicialculeFile = judicialculeFile;
	}

	public String getJudicialculeFileFileName() {
		return judicialculeFileFileName;
	}

	public void setJudicialculeFileFileName(String judicialculeFileFileName) {
		this.judicialculeFileFileName = judicialculeFileFileName;
	}

	public void setJudicialculeService(IJudicialculeService judicialculeService) {
		this.judicialculeService = judicialculeService;
	}

	@JSON(serialize = false)
	public String getSurveyname() {
		return surveyname;
	}

	public void setSurveyname(String surveyname) {
		this.surveyname = surveyname;
	}
	
	@JSON(serialize = false)
	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	public Judicialsource getModel() {
		// TODO Auto-generated method stub
		return judicialsource;
	}

	
	/**
	 * 线索来源（司法机关）
	 * @return
	 */
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        session.remove("jid");
        session.remove("unit");
        session.remove("surveyname");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	
	public String add(){
		return SUCCESS;
	}
	
	public String save() {
		
		judicialculeService.saveJudicialSource(judicialsource,judicialculeFile,judicialculeFileFileName);
		info("添加成功...");
		log("保存线索来源司法机关信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        if(jid!=null){
        	session.put("jid", jid);
        }
        if(unit!=null){
        	session.put("unit", unit);
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
		params.put("jid", session.get("jid"));
		params.put("unit", session.get("unit"));
		params.put("surveyname", session.get("surveyname"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = judicialculeService.getJudicialSourceInfo(params,this.getPage());		
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
		if(jsid==null)
			throw new ServiceException("没有指定信息");
		Judicialsource js = judicialculeService.findByjsid(jsid);
		this.put("info", js);
		return SUCCESS;
	}
	
	public String update(){
		judicialculeService.update(judicialsource);
		return OK;
	}
	
	public String delete(){
		if(jsid==null)
			throw new ServiceException("没有指定信息");
		judicialculeService.deleteByRsid(jsid);
		return OK;
	}
}
