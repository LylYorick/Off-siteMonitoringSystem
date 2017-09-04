package org.work.web.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.ReportSource;
import org.work.web.service.reportcule.IReportCuleService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class ReportCuleAction extends JsonBaseAction implements ModelDriven<ReportSource>{

	private ReportSource reportsource = new ReportSource();
	private IReportCuleService reportCuleService;
	private File reportculeFile;
	private String reportculeFileFileName;
	private String starttime;
	private String endtime;
	private String rid;//案件总编号
	private String researchname;//调查名称
	private String unit;//来函单位
	private Integer rsid;
	
	public Integer getRsid() {
		return rsid;
	}

	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}
	
	@JSON(serialize = false)
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@JSON(serialize = false)
	public String getResearchname() {
		return researchname;
	}

	public void setResearchname(String researchname) {
		this.researchname = researchname;
	}

	@JSON(serialize = false)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public File getReportculeFile() {
		return reportculeFile;
	}

	public void setReportculeFile(File reportculeFile) {
		this.reportculeFile = reportculeFile;
	}

	public String getReportculeFileFileName() {
		return reportculeFileFileName;
	}

	public void setReportculeFileFileName(String reportculeFileFileName) {
		this.reportculeFileFileName = reportculeFileFileName;
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

	public void setReportCuleService(IReportCuleService reportCuleService) {
		this.reportCuleService = reportCuleService;
	}

	@Override
	public List getGridModel() {
		// TODO Auto-generated method stub
		return this.gridModel;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getRecords() {
		// TODO Auto-generated method stub
		return this.record;
	}

	@Override
	public Integer getRows() {
		// TODO Auto-generated method stub
		return this.rows;
	}

	@Override
	public String getSidx() {
		// TODO Auto-generated method stub
		return this.sidx;
	}

	@Override
	public String getSord() {
		// TODO Auto-generated method stub
		return this.sord;
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return this.total;
	}

	@JSON(serialize = false)
	public ReportSource getModel() {
		// TODO Auto-generated method stub
		return reportsource;
	}
	public String entry() {
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        session.remove("rid");
        session.remove("unit");
        session.remove("researchname");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	/**
	 * 线索来源举报或专报
	 * @return
	 */
	public String add() {
		return SUCCESS;
	}

	public String save() {
		reportCuleService.saveReportSource(reportsource,reportculeFile,reportculeFileFileName);
		info("添加成功...");
		log("保存线索来源举报或专报信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session = ac.getSession();
        if(rid!=null){
        	session.put("rid", rid);
        }
        if(unit!=null){
        	session.put("unit", unit);
        }
        if(researchname!=null){
        	session.put("researchname", researchname);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("rid", session.get("rid"));
		params.put("unit", session.get("unit"));
		params.put("researchname", session.get("researchname"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = reportCuleService.getReportSourceInfo(params,this.getPage());		
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
		if(rsid==null)
			throw new ServiceException("没有指定信息");
		ReportSource rs = reportCuleService.findByrsid(rsid);
		this.put("info", rs);
		return SUCCESS;
	}
	
	public String update(){
		reportCuleService.update(reportsource);
		return OK;
	}
	
	public String delete(){
		if(rsid==null)
			throw new ServiceException("没有指定信息");
		reportCuleService.deleteByRsid(rsid);
		return OK;
	}
}
