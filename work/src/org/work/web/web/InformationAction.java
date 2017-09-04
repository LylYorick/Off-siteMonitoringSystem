/**
 * 
 */
package org.work.web.web;

//import java.io.File;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Inquiryarchives;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.information.IInformationService;
import org.work.web.util.PaginaterList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;


/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class InformationAction extends JsonBaseAction implements ModelDriven<Inquiryarchives>{
	
	private Inquiryarchives inquiryarchives = new Inquiryarchives();
	private IInformationService informationService;
	private IFinancialService financialService;
	
	private String oid;//机构ID
	private String starttime;
	private String endtime;
	private String approvalid;//审批表编号
	private String subjectname;//主体名称
	private String letterid;//函号
	private String iaid;
	private File surveyFile;
	private String surveyFileFileName;
	
	@JSON(serialize = false)
	public String getApprovalid() {
		return approvalid;
	}

	public void setApprovalid(String approvalid) {
		this.approvalid = approvalid;
	}

	@JSON(serialize = false)
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@JSON(serialize = false)
	public String getLetterid() {
		return letterid;
	}

	public void setLetterid(String letterid) {
		this.letterid = letterid;
	}
	
	@JSON(serialize = false)
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public File getSurveyFile() {
		return surveyFile;
	}

	public void setSurveyFile(File surveyFile) {
		this.surveyFile = surveyFile;
	}

	public String getSurveyFileFileName() {
		return surveyFileFileName;
	}

	public void setSurveyFileFileName(String surveyFileFileName) {
		this.surveyFileFileName = surveyFileFileName;
	}

	public void setInformationService(IInformationService informationService) {
		this.informationService = informationService;
	}

	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

	public String getIaid() {
		return iaid;
	}

	public void setIaid(String iaid) {
		this.iaid = iaid;
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

	/**
	 * 查询进入
	 * @return
	 */
	public String surveyentry() {
		ActionContext ac = ActionContext.getContext();
        Map session = ac.getSession();
        session.remove("approvalid");
        session.remove("subjectname");
        session.remove("letterid");
        session.remove("starttime");
        session.remove("endtime");
		return SUCCESS;
	}
	/**
	 * 调查档案
	 * @return
	 */
	public String surveyadd() {
		
		List<Catalog> list = financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}

	public String surveysave() {
		Information info = financialService.findByOid(Integer.parseInt(oid));
		if(info==null) 
			throw new ServiceException("没有找到对应的金融机构名称");
		inquiryarchives.setOrgname(info.getBname());
		informationService.saveSurvey(inquiryarchives,surveyFile,surveyFileFileName);
		info("添加成功...");
		log("保存调查档案信息", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String surveylist() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        if(approvalid!=null){
        	session.put("approvalid", approvalid);
        }
        if(subjectname!=null){
        	session.put("subjectname", subjectname);
        }
        if(letterid!=null){
        	session.put("letterid", letterid);
        }
        if(starttime!=null){
        	session.put("starttime", starttime);
        }
        if(endtime!=null){
        	session.put("endtime", endtime);
        }
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));
		params.put("approvalid",session.get("approvalid"));
		params.put("subjectname", session.get("subjectname"));
		params.put("letterid", session.get("letterid"));
		params.put("order",getSidx());
		params.put("sord",getSord());
		PaginaterList list = informationService.getInquiryArchivesInfo(params,this.getPage());		
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
	
	public String surveymodify(){
		if(iaid == null) 
			throw new ServiceException("没有指定信息!");
		Inquiryarchives inquiryarchives = informationService.findByIaid(Integer.parseInt(iaid));
		List<Catalog> list = financialService.findByCatalog();
		this.put("list", list);
		this.put("info", inquiryarchives);
		return SUCCESS;
	}
	
	public String surveyupdate(){
		Information info = financialService.findByOid(Integer.parseInt(oid));
		inquiryarchives.setOrgname(info.getBname());
		informationService.updateSurvey(inquiryarchives);
		return OK;
	}
	
	
	public String surveydelete(){
		if(iaid == null) 
			throw new ServiceException("没有指定信息!");
		informationService.deletesurvey(Integer.parseInt(iaid));
		return OK;
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
	public Inquiryarchives getModel() {
		// TODO Auto-generated method stub
		return inquiryarchives;
	}



}
