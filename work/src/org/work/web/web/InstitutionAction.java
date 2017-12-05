package org.work.web.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.CatalogNew;
import org.work.web.po.CatalogNewId;
import org.work.web.po.Information;
import org.work.web.po.Institution;
import org.work.web.po.Upload;
import org.work.web.service.archives.ArchivesService;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.institution.IInstitutionService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;

public class InstitutionAction  extends JsonBaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InstitutionAction.class);
	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别ID
	private String starttime;//开始时间
	private String endtime;//截止时间
	
	private String ins_ids;//下载传过来的
	private List<Institution> institutions = new ArrayList<Institution>();
	
	private IInstitutionService institutionService;
	private IFinancialService financialService;
	private ArchivesService archivesService;
	private File[] institutionFile;
	private String[] institutionFileFileName;
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
	public File[] getInstitutionFile() {
		return institutionFile;
	}

	public void setInstitutionFile(File[] institutionFile) {
		this.institutionFile = institutionFile;
	}

	@JSON(serialize = false)
	public String[] getInstitutionFileFileName() {
		return institutionFileFileName;
	}

	public void setInstitutionFileFileName(String[] institutionFileFileName) {
		this.institutionFileFileName = institutionFileFileName;
	}
	
	@JSON(serialize = false)
	public IFinancialService getFinancialService() {
		return financialService;
	}
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}
	@JSON(serialize = false)
	public IInstitutionService getInstitutionService() {
		return institutionService;
	}

	public void setInstitutionService(IInstitutionService institutionService) {
		this.institutionService = institutionService;
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
	public String getIns_ids() {
		return ins_ids;
	}

	public void setIns_ids(String ins_ids) {
		this.ins_ids = ins_ids;
	}

	@JSON(serialize = false)
	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
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
		params.put("oid",  getSessionUserInformation()==null?session.get("oid"):getSessionUserInformation());
		params.put("bid", session.get("bid"));	
		params.put("starttime",session.get("starttime"));
		params.put("endtime",session.get("endtime"));		
		PaginaterList list =  institutionService.findInstitutionMsg(params, this.getPage());
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
	public String institutionBankManager(){
		logger.info("金融机构制度管理（人行端）");
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        //这里是用来查询的查询条件
 		List<CatalogNew> list = new ArrayList<CatalogNew>();
 		CatalogNew ct = new CatalogNew();
 		CatalogNewId catalogNewid = new CatalogNewId();
 		ct.setId(catalogNewid);
 		ct.setFirstCatname("所有");
 		list.add(ct);
 		list.addAll(archivesService.findAllFirstCatname());
		session.put("oid", null);
		session.put("bid", null);
		session.put("starttime",null);
		session.put("endtime",null);	
		this.put("list", list);
		return SUCCESS;
	}
	
	/**
	 *金融机构制度管理（机构端）
	 */
	public String institutionManager(){
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
	public String institutionAdd(){
		logger.info("金融机构制度管理-上传制度");
		return SUCCESS;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save() {
		BankUser bankUser = getSessionUserCode();
		Information infomation = bankUser.getInformation();
		String oid = infomation.getOid().toString();
		String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INSTITUTION+"/"+ oid);
		path = StringUtil.replace(path, '\\', '/');			
		System.out.println("----path: "+path);
		institutionService.uploadInstitution(infomation,institutionFile,institutionFileFileName,path,bankUser.getBuname());
		log("新增制度上报", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续上报", "institution/institution_institutionAdd.shtml");
		this.addNaviButton("返回", "institution/institution_institutionManager.shtml");
		return OK;
	}
	
	public String download(){
		String[] ins_id = ins_ids.split(",");
		for(int i =0 ;i<ins_id.length;i++){
			Institution institution = institutionService.findById(Integer.valueOf(ins_id[i]));
			if(institution == null)
				throw new ServiceException("没有找到对应的文件Upload");
			
			institutionService.updateCnt(institution);
			
			institutions.add(institution);
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
			for (Iterator iterator = institutions.iterator(); iterator.hasNext();) {
				Institution institution = (Institution) iterator.next();
				String downloadString = Constants.DIR_INSTITUTION+"/"+ institution.getBOrgInformation().getOid()+"/";
				String[] fileNames = institution.getFile_name().split(";");
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
		String[] ins_id = ins_ids.split(",");
		for(int i =0 ;i<ins_id.length;i++){
			Institution institution = institutionService.findById(Integer.valueOf(ins_id[i]));
			if(institution == null){
				this.setErrorMsg("没有找到对应的制度资料");
				return JSON;
			}
			
			String time =institution.getUp_time();
			String  newtime =DateUtil.addDayFromCurrentDate(-7);
			if(newtime.compareTo(time)>0){//若7天前的日期大于文件录入日期，则不可删除
				//throw new ServiceException("7天后不能删除制度文档，只能重新上传");
				this.setErrorMsg("7天后不能删除制度文档，只能重新上传");
				return JSON;
			}
			
			String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_INSTITUTION+"/"+ institution.getBOrgInformation().getOid());
			path = StringUtil.replace(path, '\\', '/');	
			String[] fileNames = institution.getFile_name().split(";");
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
 			institutionService.delete(institution);
		}
		log("金融机构用户删除制度信息",Constants.LOG_TYPE_DELETE);
		this.setErrorMsg("删除文件成功");
		return JSON;
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
