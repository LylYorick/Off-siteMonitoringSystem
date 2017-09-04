/**
 * 
 */
package org.work.web.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Active;
import org.work.web.po.Blowflag;
import org.work.web.po.Catalog;
import org.work.web.po.Identityky;
import org.work.web.po.Identityrsb;
import org.work.web.po.Indentitysb;
import org.work.web.po.Inneraudit;
import org.work.web.po.Innerauditflag;
import org.work.web.po.Innercontrol;
import org.work.web.po.Organdpost;
import org.work.web.po.Publics;
import org.work.web.po.Report;
import org.work.web.po.Reportswitch;
import org.work.web.po.Susreport;
import org.work.web.po.Susreportflag;
import org.work.web.po.Train;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.report.IReportService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import com.opensymphony.xwork2.ActionContext;
import com.work.test.ExportFactory;
import com.work.tools.ExcelTools;
import com.work.tools.ExcelType;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class ReportAction extends JsonBaseAction {
	private IReportService reportService;
	private IFinancialService financialService;
	private String id;//具体报表ID,公用此属性传递
	private String reportid;
	private String switchid;
	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别
	private String reportstatus;//报表状态
	private String reportyear;//报表年份
	private String reportquater;//报表季度
	private String xmltype;//年报 or 季报

	private Innercontrol innercontrol;//内控制度建设情况
	private Indentitysb indentitysb;//金融机构客户身份识别情况（识别客户）
	private Identityrsb identityrsb;//金融机构客户身份识别情况(重新识别客户)
	private Identityky identityky;//金融机构客户身份识别情况(涉及可疑交易识别情况)
	private Susreport susreport;//金融机构可疑交易报告情况统计表
	private Susreportflag susreportflag;//金融机构可疑交易报告情况统计表
	private Publics publics;//金融机构协助公安机关、其他机关打击洗钱活动情况;
	private Blowflag blowflag;//打击洗钱活动情况标注
	private Organdpost organdpost;//金融机构反洗钱机构和岗位设立情况
	private Active active;//金融机构反洗钱宣传活动情况
	private Train train;//金融机构反洗钱培训活动情况
	private Inneraudit inneraudit;//金融机构反洗钱工作内部审计情况
	private Innerauditflag innerauditflag;//金融机构反洗钱工作内部审计情况标注

	private File importFile;
	private String importFileFileName;
	private String importFileContentType;
	
	@JSON(serialize = false)
	public File getImportFile() {
		return importFile;
	}

	public void setImportFile(File importFile) {
		this.importFile = importFile;
	}

	public String getImportFileFileName() {
		return importFileFileName;
	}

	public void setImportFileFileName(String importFileFileName) {
		this.importFileFileName = importFileFileName;
	}

	@JSON(serialize = false)
	public String getImportFileContentType() {
		return importFileContentType;
	}

	public void setImportFileContentType(String importFileContentType) {
		this.importFileContentType = importFileContentType;
	}

	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}
	
	public String getXmltype() {
		return xmltype;
	}

	public void setXmltype(String xmltype) {
		this.xmltype = xmltype;
	}

	public String getReportquater() {
		return reportquater;
	}

	public void setReportquater(String reportquater) {
		this.reportquater = reportquater;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Inneraudit getInneraudit() {
		return inneraudit;
	}

	public void setInneraudit(Inneraudit inneraudit) {
		this.inneraudit = inneraudit;
	}

	public Innerauditflag getInnerauditflag() {
		return innerauditflag;
	}

	public void setInnerauditflag(Innerauditflag innerauditflag) {
		this.innerauditflag = innerauditflag;
	}

	public Organdpost getOrgandpost() {
		return organdpost;
	}

	public void setOrgandpost(Organdpost organdpost) {
		this.organdpost = organdpost;
	}

	public Publics getPublics() {
		return publics;
	}

	public void setPublics(Publics publics) {
		this.publics = publics;
	}

	public Blowflag getBlowflag() {
		return blowflag;
	}

	public void setBlowflag(Blowflag blowflag) {
		this.blowflag = blowflag;
	}

	public Susreportflag getSusreportflag() {
		return susreportflag;
	}

	public void setSusreportflag(Susreportflag susreportflag) {
		this.susreportflag = susreportflag;
	}

	public Identityky getIdentityky() {
		return identityky;
	}

	public void setIdentityky(Identityky identityky) {
		this.identityky = identityky;
	}

	public Susreport getSusreport() {
		return susreport;
	}

	public void setSusreport(Susreport susreport) {
		this.susreport = susreport;
	}

	public Identityrsb getIdentityrsb() {
		return identityrsb;
	}

	public void setIdentityrsb(Identityrsb identityrsb) {
		this.identityrsb = identityrsb;
	}

	public Indentitysb getIndentitysb() {
		return indentitysb;
	}

	public void setIndentitysb(Indentitysb indentitysb) {
		this.indentitysb = indentitysb;
	}

	public Innercontrol getInnercontrol() {
		return innercontrol;
	}

	public void setInnercontrol(Innercontrol innercontrol) {
		this.innercontrol = innercontrol;
	}

	public void setReportService(IReportService reportService) {
		this.reportService = reportService;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	
	public String getSwitchid() {
		return switchid;
	}

	public void setSwitchid(String switchid) {
		this.switchid = switchid;
	}

	public String getReportstatus() {
		return reportstatus;
	}

	public void setReportstatus(String reportstatus) {
		this.reportstatus = reportstatus;
	}

	public String getReportyear() {
		return reportyear;
	}

	public void setReportyear(String reportyear) {
		this.reportyear = reportyear;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String manage(){
		List<Catalog> list = this.financialService.findByCatalog();
		List<Report> reportList = reportService.getAllReport();
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Integer[] quater={0,DateUtil.getSeason(getEndday())};
        session.put("reportquater", quater);
        session.put("reportid", null);
        session.put("bid", null);
        session.put("reportstatus", null);
        session.put("reportyear", null);
		put("reportList", reportList);
		this.put("list", list);
		return SUCCESS;
	}
	/**
	 * _p No.参数保存的时候,出现丢失参数的情况，需要保存到session中TODO://不是很好的方法
	 * @return
	 */
	public String list() {
		Map<String, Object> params = new HashMap<String, Object>();
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		if(reportid==null){
			if(session.get("reportid")==null)
				session.put("reportid",null);
		}else {
	        session.put("reportid", reportid);
		}
		if(bid==null || bid==9999){
			if(session.get("bid")==null || "9999".equals(String.valueOf(bid)))
				session.put("bid",null);
		}else {
	        session.put("bid", bid);
		}
		if(reportstatus==null || "9999".equals(reportstatus)){
			if(session.get("reportstatus")==null || "9999".equals(String.valueOf(reportstatus)))
				session.put("reportstatus",null);
		}else{
	        session.put("reportstatus", reportstatus);
		}
		if(reportquater!=null && !"".equals(reportquater)){
	        Integer[] quater={0,Integer.valueOf(reportquater)};
	        session.put("reportquater", quater);
		}
		if(reportyear!=null && !"".equals(reportyear)){
	        session.put("reportyear", reportyear);
		}
		/**
		 * 如果参数不是本用户的所在机构，强制设置为本机构
		 */
		
		params.put("oid", getSessionUserInformation()==null?this.getOid():getSessionUserInformation());
		params.put("reportid",session.get("reportid"));
		params.put("bid",session.get("bid"));
		params.put("reportyear",session.get("reportyear"));
		params.put("reportquater",session.get("reportquater"));
		params.put("reportstatus",session.get("reportstatus"));
		params.put("order",this.getSidx());
		params.put("sord",this.getSord());
		PaginaterList list = reportService.getReport(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Reportswitch> iterator = list.getList().iterator(); iterator.hasNext();) {
			Reportswitch reportswitch=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", reportswitch.getSwitchid());
			item.put("year", reportswitch.getYear());
			item.put("rname", reportswitch.getReport().getRptname());
			item.put("quater", reportswitch.getQuater());
			item.put("reportid", reportswitch.getReport().getReportid());
			item.put("isreport", reportswitch.getIsreport());
			item.put("type", Constants.REPORT_TYPE.get(reportswitch.getReport().getPrtype().toString()));
			item.put("status", Constants.REPORT_STATUS.get(String.valueOf(reportswitch.getStatus())));
			item.put("bname", reportswitch.getBOrgInformation().getBname());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("查询报表上报情况", Constants.LOG_TYPE_SELECT);
		return JSON;
	}

	public String fill() {
		int reportid = 0;
		Reportswitch reportswitch = reportService.getreportSwitchById(Integer.valueOf(switchid));
		if(reportswitch==null)
			throw new ServiceException("没有您需要上报的报表");
		
		put("reportswitch",reportswitch);
		put("user",getSessionUserCode());
		try {
			reportid = Integer.parseInt(this.reportid);
		} catch (Exception e) {
			throw new ServiceException("请输入正确的参数");
		}
		if(reportswitch.getReport().getReportid()!=reportid){
			throw new ServiceException("请不要随意修改参数");
		}
		switch (reportid) {
			case 1 :
				return "innercontrol";
			case 2 :
				return "organization";
			case 3 :
				return "active";
			case 4 :
				return "train";
			case 5 :
				innerauditflag = reportService.getInnerauditFlagBySwitchId(Integer.valueOf(switchid));
				return "inneraudit";
			case 6 :
				indentitysb = reportService.getIdentitySbBySwitchId(Integer.valueOf(switchid));
				return "identitysb";
			case 7 :
				identityrsb = reportService.getIdentityRsbBySwitchId(Integer.valueOf(switchid));
				return "identityrsb";
			case 8 :
				identityky = reportService.getIdentityKyBySwitchId(Integer.valueOf(switchid));
				return "identityky";
			case 9 :
				susreport = reportService.getSusreportBySwitchId(Integer.valueOf(switchid));
				susreportflag = reportService.getSusreportFlagBySwitchId(Integer.valueOf(switchid));
				return "susreport";
			case 10:
				blowflag = reportService.getBlowflagBySwitchId(Integer.valueOf(switchid));
				return "publics";
			default :
				throw new ServiceException("请输入正确的参数");
		}
	}

	/**
	 * 内控制度显示列表
	 * @return
	 */
	public String innerlist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getInnerControl(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Innercontrol> iterator = list.getList().iterator(); iterator.hasNext();) {
			Innercontrol innercontrol=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", innercontrol.getInnerid());
			item.put("name", innercontrol.getIname());
			item.put("content", innercontrol.getIcontent());
			item.put("dept", innercontrol.getIdept());
			item.put("time", innercontrol.getItime());
			item.put("filenb", innercontrol.getFilenb());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查询报表上报情况", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**
	 *   金融机构反洗钱机构和岗位设立情况列表
	 * @return
	 */
	public String orglist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getOrgandPost(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Organdpost> iterator = list.getList().iterator(); iterator.hasNext();) {
			Organdpost organdpost=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("oopid", organdpost.getOopid());
			item.put("orgname", organdpost.getOrgname());
			item.put("leadname", organdpost.getLeadname());
			item.put("leadpos", organdpost.getLeadpos());
			item.put("leadtel", organdpost.getLeadtel());
			item.put("deptlead", organdpost.getDeptlead());
			item.put("deptleadtel", organdpost.getDeptleadtel());
			item.put("ftnum", organdpost.getFtnum());
			item.put("ptnum", organdpost.getPtnum());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("金融机构反洗钱机构和岗位设立情况列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**
	 *   金融机构反洗钱宣传活动情况列表
	 * @return
	 */
	public String activelist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getActive(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Active> iterator = list.getList().iterator(); iterator.hasNext();) {
			Active active=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("proid", active.getProid());
			item.put("actdate", active.getActdate());
			item.put("actcnt", active.getActcnt());
			item.put("actnum", active.getActnum());
			item.put("actmtd", active.getActmtd());
			item.put("actdatanum", active.getActdatanum());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("金融机构反洗钱宣传活动情况列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**
	 *   金融机构反洗钱培训活动情况列表
	 * @return
	 */
	public String trainlist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getTrain(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Train> iterator = list.getList().iterator(); iterator.hasNext();) {
			Train train=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("trdid", train.getTrdid());
			item.put("trdate", train.getTrdate());
			item.put("trcnt", train.getTrcnt());
			item.put("trobjt", train.getTrobjt());
			item.put("trnum", train.getTrnum());
			item.put("trmethod", train.getTrmethod());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("金融机构反洗钱培训活动情况列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	public String entry(){
		List<Report> reportList = reportService.getAllReport();
		put("reportList", reportList);
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Integer[] quater={0,DateUtil.getSeason(getEndday())};
        session.put("reportquater", quater);
        session.put("reportid", null);
        session.put("reportid", null);
        session.put("bid", null);
        session.put("reportstatus", null);
        session.put("reportyear", null);
		return SUCCESS;
	}
	/**
	 * 内控制度录入
	 * @return
	 */
	public String innercontrol() {
		_check();
		_checkup();
		return SUCCESS;
	}
	/**
	 * 内控制度录入保存
	 * @return
	 */
	public String innercontrolsave() {
		_check();
		reportService.saveInnerControl(innercontrol);
		info("保存金融机构反洗钱内控制度建设情况统计表成功...");
		this.addNaviButton("继续添加", "report/report_innercontrol.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 内控制度修改
	 * @return
	 */
	public String innercontrolmodify() {
		_checkup();
		innercontrol = reportService.getInnerControlById(Long.valueOf(id));
		if(innercontrol==null)
			throw new ServiceException("请输入正确的参数");
		if(!innercontrol.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("innercontrol", innercontrol);
		return SUCCESS;
	}
	/**
	 * 内控制度修改保存
	 * @return
	 */
	public String innercontrolupdate() {
		reportService.updateInnerControl(innercontrol);
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=1&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		info("修改金融机构反洗钱内控制度建设情况统计表成功...");
		return OK;
	}
	/**
	 * 内控制度导入
	 * @return
	 */
	public String innercontrolimport() {
		return SUCCESS;
	}
	public String innercontrolImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		if(!"A".equals(eto.getType()))
			throw new ServiceException("您导入的报表不是该类型报表，请检查文件名");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 机构和岗位导入
	 * @return
	 */
	public String organdpostimport() {
		return SUCCESS;
	}
	public String organdpostImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 宣传活动导入
	 * @return
	 */
	public String activeimport() {
		return SUCCESS;
	}
	public String activeImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 培训导入
	 * @return
	 */
	public String trainimport() {
		return SUCCESS;
	}
	public String trainImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 内控制度导入
	 * @return
	 */
	public String innerauditimport() {
		return SUCCESS;
	}
	public String innerauditImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 协助公安导入
	 * @return
	 */
	public String publicsimport() {
		return SUCCESS;
	}
	public String publicsImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 身份识别
	 * @return
	 */
	public String identitysbImport() {
		return SUCCESS;
	}
	public String identitysbImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 身份重新识别
	 * @return
	 */
	public String identityrsbImport() {
		return SUCCESS;
	}
	public String identityrsbImportsave(){
		_checkup();
		ExcelType eto = new ExcelType(this.getImportFileFileName().split("\\.")[0]);
		if(!eto.getOrgid().equals(getSessionUserCode().getInformation().getBcatid()))
			throw new ServiceException("您不能上传该机构报表");
		ExcelTools et = new ExcelTools();
		try {
			et.insertByPage(this.getImportFile(), eto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OK;
	}
	/**
	 * 金融机构客户身份识别情况（识别客户）修改保存
	 * @return
	 */
	public String identitysbsave() {
		_checkup();
		reportService.saveOrupdateIndentitySb(indentitysb);
		info("修改金融机构客户身份识别情况（识别客户）表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}	
	/**
	 * 金融机构客户身份识别情况（重新识别客户）修改保存
	 * @return
	 */
	public String identityrsbsave() {
		_checkup();
		_check();
		reportService.saveOrupdateIdentityRsb(identityrsb);
		info("修改金融机构客户身份识别情况（重新识别客户）表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}	
	/**
	 * 金融机构可疑交易报告情况统计表
	 * @return
	 */
	public String susreportsave() {
		_checkup();
		reportService.saveOrupdateSusreport(susreport);
		info("修改金融机构可疑交易报告情况统计表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构可疑交易报告情况统计表标注
	 * @return
	 */
	public String susreportflagsave() {
		_checkup();
		reportService.saveOrupdateSusreportflag(susreportflag);
		info("修改金融机构可疑交易报告情况统计标注表成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=9&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况列表
	 * @return
	 */
	public String publicslist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getPublics(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Publics> iterator = list.getList().iterator(); iterator.hasNext();) {
			Publics publics=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("xp1", publics.getXp1());
			item.put("xp2", publics.getXp2());
			item.put("xp3", publics.getXp3());
			item.put("xp4", publics.getXp4());
			item.put("xp5", publics.getXp5());
			item.put("xpid", publics.getXpid());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("查询金融机构协助公安机关、其他机关打击洗钱活动情况列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}

	/**
	 * 金融机构反洗钱工作内部审计情况列表
	 * @return
	 */
	public String innerauditlist(){
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getInneraudit(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		for (Iterator<Inneraudit> iterator = list.getList().iterator(); iterator.hasNext();) {
			Inneraudit inneraudit=iterator.next();
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("audid", inneraudit.getAudid());
			item.put("auddept", inneraudit.getAuddept());
			item.put("audprid", inneraudit.getAudprid());
			item.put("audcnt", inneraudit.getAudcnt());
			item.put("audprbm", inneraudit.getAudprbm());
			item.put("audmod", inneraudit.getAudmod());
			result.add(item);
		}
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		log("查询金金融机构反洗钱工作内部审计情况", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**************************************************************************************/
	/**
	 * 金融机构反洗钱工作内部审计情况
	 * @return
	 */
	public String innerauditsave() {
		_check();
		reportService.saveOrupdateInneraudit(inneraudit);
		info("修改金融机构反洗钱工作内部审计情况成功...");
		this.addNaviButton("继续添加", "report/report_inneraudit.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}

	/**
	 * 金融机构反洗钱工作内部审计情况录入
	 * @return
	 */
	public String inneraudit() {
		_check();
		return SUCCESS;
	}
	/**
	 * 金融机构反洗钱工作内部审计情况修改
	 * @return
	 */
	public String  innerauditmodify() {
		inneraudit = reportService.getInnerauditById(Long.valueOf(id));
		if(inneraudit==null)
			throw new ServiceException("请输入正确的参数");
		if(!inneraudit.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("inneraudit", inneraudit);
		return SUCCESS;
	}
	/**
	 * 金融机构反洗钱工作内部审计情况更新
	 * @return
	 */
	public String  innerauditupdate() {
		reportService.updateInneraudit(inneraudit);
		info("修改金融机构反洗钱工作内部审计情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=5&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构反洗钱工作内部审计情况删除
	 * @return
	 */
	public String  innerauditdel() {
		
		reportService.deleteInneraudit(Long.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构反洗钱工作内部审计情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=5&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构反洗钱工作内部审计情况标注
	 * @return
	 */
	public String innerauditflagsave() {
		_check();
		reportService.saveOrupdateInnerauditFlag(innerauditflag);
		info("修改金融机构反洗钱工作内部审计情况标注成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=5&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/*********************************************************************************************************/
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况
	 * @return
	 */
	public String publicssave() {
		_check();
		reportService.saveOrupdatePublics(publics);
		info("修改金融机构协助公安机关、其他机关打击洗钱活动情况成功...");
		this.addNaviButton("继续添加", "report/report_publics.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}

	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况录入
	 * @return
	 */
	public String publics() {
		_checkup();
		_check();
		return SUCCESS;
	}
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况修改
	 * @return
	 */
	public String  publicsmodify() {
		_checkup();
		publics = reportService.getPublicsById(Integer.valueOf(id));
		if(publics==null)
			throw new ServiceException("请输入正确的参数");
		if(!publics.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("publics", publics);
		return SUCCESS;
	}
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况更新
	 * @return
	 */
	public String  publicsupdate() {
		reportService.updatePublics(publics);
		info("修改金融机构协助公安机关、其他机关打击洗钱活动情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=10&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况删除
	 * @return
	 */
	public String  publicsdel() {
		_checkup();
		reportService.deletePublics(Integer.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构客户身份识别情况(涉及可疑交易识别情况)表成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=10&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构协助公安机关、其他机关打击洗钱活动情况标注
	 * @return
	 */
	public String blowflagsave() {
		_checkup();
		reportService.saveOrupdateBlowflag(blowflag);
		info("修改金金融机构协助公安机关、其他机关打击洗钱活动情况标注成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=10&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构客户身份识别情况(涉及可疑交易识别情况)修改保存
	 * @return
	 */
	public String identitykysave() {
		_checkup();
		reportService.saveOrupdateIdentityKy(identityky);
		info("修改金融机构客户身份识别情况(涉及可疑交易识别情况)表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String innercontroldel() {
		_checkup();
		reportService.deleteInnerControl(Long.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构客户身份识别情况(涉及可疑交易识别情况)表成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=1&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zero() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getInnerControl(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构客户身份识别情况(涉及可疑交易识别情况)表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zeroo() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getOrgandPost(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构反洗钱机构和岗位设立情况表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zeroa() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getActive(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构反洗钱宣传活动情况表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zerot() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getTrain(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构反洗钱宣传活动情况表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zeroia() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getInneraudit(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.deleteInnerauditFlag(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构反洗钱工作内部审计表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zerosb() {
		_checkup();
		reportService.deleteIdentitySb(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构客户身份识别情况(识别客户)表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zerorsb() {
		_checkup();
		reportService.deleteIdentityRsb(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构客户身份识别情况(重新识别客户)表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zeroky() {
		_checkup();
		reportService.deleteIdentityKy(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构客户身份识别情况(涉及可疑交易识别情况)表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zerosus() {
		_checkup();
		reportService.deleteSusreport(Integer.valueOf(switchid));
		reportService.deleteSusreportFlag(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构可疑交易报告情况统计表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String zeropb() {
		_checkup();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("switchid", this.getSwitchid());
		PaginaterList list = reportService.getPublics(params,this.getPage());
		if(list.getList().size()>0)
			throw new ServiceException("请先删除已上传数据!");
		reportService.deletePublicsFlag(Integer.valueOf(switchid));
		reportService.updateZeroReport(Integer.valueOf(switchid));
		info("零报告金融机构反洗钱工作内部审计表成功...");
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String organization() {
		_check();
		return SUCCESS;
	}
	public String organizationsave() {
		_check();
		reportService.saveOrupdateOrgandPost(organdpost);
		info("修改金融机构反洗钱机构和岗位设立情况成功...");
		this.addNaviButton("继续添加", "report/report_organization.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构反洗钱机构和岗位设立情况修改
	 * @return
	 */
	public String  organizationmodify() {
		organdpost = reportService.getOrgandpostById(Long.valueOf(id));
		if(organdpost==null)
			throw new ServiceException("请输入正确的参数");
		if(!organdpost.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("organdpost", organdpost);
		return SUCCESS;
	}
	/**
	 * 金融机构反洗钱机构和岗位设立情况更新
	 * @return
	 */
	public String  organizationupdate() {
		reportService.updateOrgandPost(organdpost);
		info("修改金融机构反洗钱机构和岗位设立情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=2&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String  organizationdel() {
		reportService.deleteOrgandPost(Long.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构反洗钱机构和岗位设立情况表成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=2&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	
	/*************************************************************************/
	public String active() {
		_check();
		return SUCCESS;
	}
	public String activesave() {
		_check();
		reportService.saveOrupdateActive(active);
		info("修改金融机构反洗钱宣传活动情况成功...");
		this.addNaviButton("继续添加", "report/report_active.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构反洗钱宣传活动情况修改
	 * @return
	 */
	public String  activemodify() {
		active = reportService.getActiveById(Long.valueOf(id));
		if(active==null)
			throw new ServiceException("请输入正确的参数");
		if(!active.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("active", active);
		return SUCCESS;
	}
	/**
	 * 金融机构反洗钱宣传活动情况更新
	 * @return
	 */
	public String  activeupdate() {
		reportService.updateActive(active);
		info("修改金融机构反洗钱宣传活动情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=3&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String  activedel() {
		reportService.deleteActive(Long.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构反洗钱宣传活动情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=3&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/*************************************************************************/	
	public String train() {
		_check();
		return SUCCESS;
	}
	public String trainsave() {
		_check();
		reportService.saveOrupdateTrain(train);
		info("新增金融机构反洗钱培训活动情况成功...");
		this.addNaviButton("继续添加", "report/report_train.shtml?switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	/**
	 * 金融机构反洗钱培训活动情况修改
	 * @return
	 */
	public String  trainmodify() {
		train = reportService.getTrainById(Long.valueOf(id));
		if(train==null)
			throw new ServiceException("请输入正确的参数");
		if(!train.getReportswitch().getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
		put("train", train);
		return SUCCESS;
	}
	/**
	 * 金融机构反洗钱培训活动情况更新
	 * @return
	 */
	public String  trainupdate() {
		reportService.updateTrain(train);
		info("修改金融机构反洗钱培训活动情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=4&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String  traindel() {
		reportService.deleteTrain(Long.valueOf(id),Integer.valueOf(switchid));
		info("删除金融机构反洗钱培训活动情况成功...");
		this.addNaviButton("继续操作", "report/report_fill.shtml?reportid=4&switchid="+switchid);
		this.addNaviButton("返回", "report/report_entry.shtml");
		return OK;
	}
	public String excel(){
		if(getSessionUserInformation()!=null)
			throw new ServiceException("您没有导出报文的权限!");
		File file=new File(ExcelTools._fileMenu);
		List list = (List) FileUtils.listFiles(file, new String[] { "xls","XLS" }, false);
		put("list", list);
		return SUCCESS;
	}
	public String excelInsert(){
		try {
			ExcelTools.insert();
		} catch (SQLException e) {
			throw new ServiceException("导入错误，请检查excel文件");
		}
		return OK;
	}
	public String export(){
		if(getSessionUserInformation()!=null)
			throw new ServiceException("您没有导出报文的权限!");

		return SUCCESS;
	}
	public String exportxml() {
		return SUCCESS;
	}
	public String updateuser(){
		String name = ServletActionContext.getRequest().getParameter("name");
		String tel = ServletActionContext.getRequest().getParameter("tel");
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			if("".equals(name) || name==null || "".equals(tel) || tel==null){
				out.print("保存失败");
			}else{
				reportService.updateSwitch(name,tel,Integer.valueOf(switchid));
				out.print("保存成功");
			}
			 out.flush();   
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@JSON(serialize = false)
	public String getDownloadChineseFileName() {  
		String quater = "1".equals(this.getXmltype())?"0":this.getReportquater();
		String downloadChineseFileName = Constants.PBC_SHENZHENCODE+this.getReportyear()+quater+"000"+".xml";
		try {  
			downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "UTF-8");  
		} catch (UnsupportedEncodingException e) {  
			e.printStackTrace();  
		}        
		return downloadChineseFileName;  
	}
	/**
	 * 
	 * @return 返回输入流
	 */
	@JSON(serialize = false)
	public InputStream getXmlFile() {
		
		InputStream input=null;
		info("开始下载");
		try{
			String quater = "1".equals(this.getXmltype())?"0":this.getReportquater();
			String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_REPORT);
			ExportFactory.ExportXml(this.getReportyear(), quater, path+"\\"+"temp.xml");
			/*Xstm xstm = new Xstm();
			xstm.setPathString(path+"\\"+"temp.xml");
			xstm.setQuaterString(this.getReportquater());
			xstm.setYearString(DateUtil.getCurrentYear());
			xstm.quaterReport();*/
			String downloadString = Constants.DIR_REPORT;
			String filepath = downloadString+"\\temp.xml";	    		    	
			input = ServletActionContext.getServletContext().getResourceAsStream(filepath);
		}catch (Exception e) {
			info("没有找到文件");
		}
		return input;
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
		
		return this.record;
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

	/*
	 * 判断权限
	 */
	public void _check(){
		Reportswitch reportswitch = reportService.getreportSwitchById(Integer.valueOf(switchid));
		if(reportswitch==null)
			throw new ServiceException("没有您需要上报的报表");
		if(!reportswitch.getBOrgInformation().getOid().equals(getSessionUserInformation()))
			throw new ServiceException("您没有此报表修改权限");
	}
	/*
	 * 判断是否上报
	 */
	public void _checkup(){
		Reportswitch reportswitch = reportService.getreportSwitchById(Integer.valueOf(switchid));
		if(!Constants.REPORT_STATUS_TOUPLOAD.equals(reportswitch.getStatus()))
			throw new ServiceException("只能修改[待上报]的数据报表");
		
	}
}
