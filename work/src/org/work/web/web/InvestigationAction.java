package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;

import org.work.web.po.CheckRoster;

import org.work.web.service.investigation.IInvestigationService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class InvestigationAction extends JsonBaseAction implements ModelDriven<CheckRoster>{

	private CheckRoster checkroster = new CheckRoster();
	private IInvestigationService investigationService;
	
	
	private Integer crid;//主键
	private String checkid;//协查函号
	private String unit;//协查单位
	private String starttime;
	private String endtime;
	private File checkFile;
	private String checkFileFileName;
	
	
	public Integer getCrid() {
		return crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	@JSON(serialize = false)
	public String getCheckid() {
		return checkid;
	}

	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	
	@JSON(serialize = false)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public File getCheckFile() {
		return checkFile;
	}

	public void setCheckFile(File checkFile) {
		this.checkFile = checkFile;
	}

	public String getCheckFileFileName() {
		return checkFileFileName;
	}

	public void setCheckFileFileName(String checkFileFileName) {
		this.checkFileFileName = checkFileFileName;
	}

	public void setInvestigationService(IInvestigationService investigationService) {
		this.investigationService = investigationService;
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
	public CheckRoster getModel() {
		// TODO Auto-generated method stub
		return checkroster;
	}

	
	/**
	 * 查询进入
	 * @return
	 */
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        session.remove("checkid");
        session.remove("unit");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	/**
	 * 协查名单
	 * @return
	 */
	public String add() {
		return SUCCESS;
	}

	public String save() {
		investigationService.saveCheckRoster(checkroster,checkFile,checkFileFileName);
		info("添加成功...");
		log("保存协查名单信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        if(unit!=null){
        	session.put("unit", unit);
        }
        if(checkid!=null){
        	session.put("checkid", checkid);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("checkid", session.get("checkid"));
		params.put("unit", session.get("unit"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = investigationService.getCheckRosterInfo(params,this.getPage());		
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
		if(crid==null)
			throw new ServiceException("没有指定信息");
		CheckRoster cr = investigationService.findByCrid(crid);
		this.put("info", cr);
		return SUCCESS;
	}

	public String update(){
		investigationService.updateInvestigation(checkroster);
		return OK;
	}
	
	public String delete(){
		if(crid==null)
			throw new ServiceException("没有指定信息");
		investigationService.deleteByCrid(crid);
		return OK;
	}
}
