package org.work.web.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.CatalogNew;
import org.work.web.po.CatalogNewId;
import org.work.web.po.Information;
import org.work.web.po.ReportForm;
import org.work.web.service.archives.ArchivesService;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.reportForm.IReportFormService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;

public class ReportFormAction  extends JsonBaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReportFormAction.class);
	private Integer oid;//金融机构ID
	private String bfirstid;//一级类别id
	private Integer bid;//金融机构类别ID
	private String starttime;//开始时间
	private String endtime;//截止时间
	
	private String fes_ids;//下载传过来的
	private List<ReportForm> reportForms = new ArrayList<ReportForm>();
	
	private IReportFormService reportFormService;
	private IFinancialService financialService;
	private ArchivesService archivesService;
	private File[] reportFormFile;
	private String[] reportFormFileFileName;
	private String errorMsg;
	public void setArchivesService(ArchivesService archivesService) {
		this.archivesService = archivesService;
	}
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@JSON(serialize = false)
	public File[] getReportFormFile() {
		return reportFormFile;
	}

	public void setReportFormFile(File[] reportFormFile) {
		this.reportFormFile = reportFormFile;
	}

	@JSON(serialize = false)
	public String[] getReportFormFileFileName() {
		return reportFormFileFileName;
	}

	public void setReportFormFileFileName(String[] reportFormFileFileName) {
		this.reportFormFileFileName = reportFormFileFileName;
	}
	
	@JSON(serialize = false)
	public IFinancialService getFinancialService() {
		return financialService;
	}
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}
	@JSON(serialize = false)
	public IReportFormService getReportFormService() {
		return reportFormService;
	}

	public void setReportFormService(IReportFormService reportFormService) {
		this.reportFormService = reportFormService;
	}
	
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getOid() {
		return oid;
	}
	
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	@JSON(serialize = false)
	public String getFes_ids() {
		return fes_ids;
	}

	public void setFes_ids(String fes_ids) {
		this.fes_ids = fes_ids;
	}

	@JSON(serialize = false)
	public List<ReportForm> getReportForms() {
		return reportForms;
	}

	public void setReportForms(List<ReportForm> reportForms) {
		this.reportForms = reportForms;
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
	
	public String list(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Map<String, Object> params = new HashMap<String, Object>();
	    if(oid==null || oid==9999){
			if(session.get("oid")==null || "9999".equals(String.valueOf(oid)))
				session.put("oid",null);
		}else {
	        session.put("oid", oid);
		}
		if(bid!=null)
	        session.put("bid", bid);
		if(starttime!=null && !"".equals(starttime)){
	        session.put("starttime", starttime);
		}
		if(endtime!=null && !"".equals(endtime)){
	        session.put("endtime", endtime);
		}
		if(getBfirstid()==null){
			if(session.get("bfirstid")==null)
			session.put("bfirstid",null);
		}else{
			session.put("bfirstid",bfirstid);
		}
		params.put("oid",  getSessionUserInformation()==null?session.get("oid"):getSessionUserInformation());
		params.put("bid", session.get("bid"));	
		params.put("starttime",session.get("starttime"));
		params.put("endtime",session.get("endtime"));	
		params.put("bfirstid", session.get("bfirstid"));
		PaginaterList list =  reportFormService.findReportFormMsg(params, this.getPage());
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		return  JSON;
	}
	
	
	
	/**
	 *金融机构制度管理（人行端）
	 */
	public String reportFormBankManager(){
		logger.info("金融机构制度管理（人行端）");
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
     
		session.put("oid", null);
		session.put("bid", null);
		session.put("starttime",null);
		session.put("endtime",null);	
		//这里是用来查询的查询条件
		List<CatalogNew> list = new ArrayList<CatalogNew>();
		CatalogNew ct = new CatalogNew();
		CatalogNewId catalogNewid = new CatalogNewId();
		ct.setId(catalogNewid);
		ct.setFirstCatname("所有");
		list.add(ct);
		list.addAll(this.archivesService.findAllFirstCatname());
		this.put("list", list);
		this.put("list", list);
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理（机构端）
	 */
	public String reportFormManager(){
		logger.info("金融机构制度管理（机构端）");
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        List<Catalog> list = new  ArrayList<Catalog>();
        try{
        	list = this.financialService.findByCatalog();
        }catch(Exception e){
        	e.printStackTrace();
        }
		session.put("oid", null);
		session.put("bid", null);
		session.put("starttime",null);
		session.put("endtime",null);	
		this.put("list", list);
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理-上传制度
	 */
	public String reportFormAdd(){
		logger.info("报表管理-上传制度");
		return SUCCESS;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save() {
		BankUser bankUser = getSessionUserCode();
		Archives archives = bankUser.getArchives();
		String oid = archives.getOid()+"";
		String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_REPORT_FORM+"/"+ oid);
		path = StringUtil.replace(path, '\\', '/');			
		System.out.println("----path: "+path);
		reportFormService.uploadReportForm(archives,reportFormFile,reportFormFileFileName,path,bankUser.getBuname());
		log("新增制度上报", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续上报", "reportForm/reportForm_reportFormAdd.shtml");
		this.addNaviButton("返回", "reportForm/reportForm_reportFormManager.shtml");
		return OK;
	}
	
	public String download(){
		String[] fes_id = fes_ids.split(",");
		for(int i =0 ;i<fes_id.length;i++){
			ReportForm reportForm = reportFormService.findById(Integer.valueOf(fes_id[i]));
			if(reportForm == null)
				throw new ServiceException("没有找到对应的文件Upload");
			
			reportFormService.updateCnt(reportForm);
			
			reportForms.add(reportForm);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 获取上报资料文件名
	 * @return
	 */
	@JSON(serialize = false)
	public String getDownloadFileName() {  
		String downloadChineseFileName = "制度资料.zip";
		try {  
			downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");  
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
	public InputStream getDownloadFile() {
		InputStream input=null;
		info("开始下载");
		try{
			String tempString = Constants.DIR_INSTITUTION+"/"+System.currentTimeMillis()+".zip";
			FileOutputStream fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath(tempString));
		    ZipOutputStream zos = new ZipOutputStream(fos);
			for (Iterator iterator = reportForms.iterator(); iterator.hasNext();) {
				ReportForm reportForm = (ReportForm) iterator.next();
				String downloadString = Constants.DIR_INSTITUTION+"/"+ reportForm.getBOrgInformation().getOid()+"/";
				String[] fileNames = reportForm.getFile_name().split(";");
				for(String fileName : fileNames){
					String filepath = downloadString+fileName;
				    ZipEntry z = new ZipEntry(fileName);
				    zos.putNextEntry(z);
				    zos.setEncoding("gbk");
				    File file= new File(ServletActionContext.getServletContext().getRealPath(filepath));
				    try{
					    byte[] t = FileUtils.readFileToByteArray(file);
			 		    zos.write(t);
				    }catch (Exception e) {
				    	e.printStackTrace();
					}
				}
				
			}
 		    zos.close();
			input = ServletActionContext.getServletContext().getResourceAsStream(tempString);
			(new File(ServletActionContext.getServletContext().getRealPath(tempString))).delete();//删除生成的临时zip包
		}catch (Exception e) {
			info("没有找到文件");
		}
	
		log("下载资料", Constants.LOG_TYPE_DOWNLOAD);
		return input;
	}
	
	/**
	 * 删除资料
	 * @return
	 */
	public String delete(){
		String[] fes_id = fes_ids.split(",");
		for(int i =0 ;i<fes_id.length;i++){
			ReportForm reportForm = reportFormService.findById(Integer.valueOf(fes_id[i]));
			if(reportForm == null){
				this.setErrorMsg("没有找到对应的制度资料");
				return JSON;
			}
			
			String time =reportForm.getUp_time();
			String  newtime =DateUtil.addDayFromCurrentDate(-7);
			if(newtime.compareTo(time)>0){//若7天前的日期大于文件录入日期，则不可删除
				//throw new ServiceException("7天后不能删除制度文档，只能重新上传");
				this.setErrorMsg("7天后不能删除制度文档，只能重新上传");
				return JSON;
			}
			
			String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INSTITUTION+"/"+ reportForm.getBOrgInformation().getOid());
			path = StringUtil.replace(path, '\\', '/');	
			String[] fileNames = reportForm.getFile_name().split(";");
 			for(String fileName : fileNames){
 				String newPath = path + "/" + fileName;
 				System.out.println(" 要删除的文件 ：： "+newPath);
 				
 				File delFile = new File(newPath);
 				try {
 					FileUtils.forceDelete(delFile);
 				} catch (IOException e) {
 					logger.error(e.getMessage());
 					this.setErrorMsg("删除文件异常");
 					return JSON;
 				}
 			}
 			reportFormService.delete(reportForm);
		}
		log("金融机构用户删除制度信息",Constants.LOG_TYPE_DELETE);
		this.setErrorMsg("删除文件成功");
		return JSON;
	}
	
	
	public String getBfirstid() {
		return bfirstid;
	}
	public void setBfirstid(String bfirstid) {
		this.bfirstid = bfirstid;
	}
	/**
	 *金融机构制度管理-修改制度
	 */
	public String reportFormModify(){
		logger.info("***");
		
		logger.info("金融机构制度管理-修改制度");
		return SUCCESS;
	}
}
