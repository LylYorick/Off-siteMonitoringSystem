/**
 * 
 */
package org.work.web.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Upload;
import org.work.web.service.document.IDocumentService;
import org.work.web.service.financial.IFinancialService;
import org.work.web.util.PaginaterList;
import org.work.web.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class DocumentAction extends JsonBaseAction implements ModelDriven<Upload> {
	private Upload upload = new Upload();
	private Integer uid;
	private String uids;
	private List uploads= new ArrayList();
	private File[] documentFile;
	private String[] documentFileFileName;
	private String[] documentFileContentType;
	private IDocumentService documentService;
	private IFinancialService financialService;

	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别ID
	private String starttime;//开始时间
	private String endtime;//截止时间
	private String filename;//资料名称

	private String upDownFileName;//上传下载的文件名称

	public void setDocumentService(IDocumentService documentService) {
		this.documentService = documentService;
	}
	@JSON(serialize = false)
	public File[] getDocumentFile() {
		return documentFile;
	}

	@JSON(serialize = false)
	public String getUids() {
		return uids;
	}
	public void setUids(String uids) {
		this.uids = uids;
	}
	public void setDocumentFile(File[] documentFile) {
		this.documentFile = documentFile;
	}
	@JSON(serialize = false)
	public String[] getDocumentFileFileName() {
		return documentFileFileName;
	}

	public void setDocumentFileFileName(String[] documentFileFileName) {
		this.documentFileFileName = documentFileFileName;
	}
	@JSON(serialize = false)
	public String[] getDocumentFileContentType() {
		return documentFileContentType;
	}

	public void setDocumentFileContentType(String[] documentFileContentType) {
		this.documentFileContentType = documentFileContentType;
	}

	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		if(uid == null) return;
		upload = documentService.getDocumentByID(uid);
		if(uid == null){
			info("没有找到上报资料:"+uid);
		}else{
			this.uid = uid;
		}
		this.uid = uid;
	}
	public String entry() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		List<Catalog> list = this.financialService.findByCatalog();
		session.put("oid", null);
		session.put("bid", null);
		session.put("filename", null);
		session.put("starttime",null);
		session.put("endtime",null);	
		this.put("list", list);
		return SUCCESS;
	}

	public String add() {
		return SUCCESS;
	}

	public String save() {
		BankUser bankUser = getSessionUserCode();
		Information infomation = bankUser.getInformation();
		String oid = infomation.getOid().toString();
		Upload fileItem;
		String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_DOCUMENT+"/"+ oid);
		path = StringUtil.replace(path, '\\', '/');			
		System.out.println("----path: "+path);
		documentService.uploadDocument(infomation,documentFile,documentFileFileName,path,bankUser.getBuname());
		log("新增资料上报", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续上报", "document/document_add.shtml");
		this.addNaviButton("返回", "document/document_manage.shtml");
		return OK;
	}
	/**
	 * 
	 * @return 获取下载文件中文名
	 */
	@JSON(serialize = false)
	public String getDownloadChineseFileName() {  
		String downloadChineseFileName = this.getUpDownFileName();
		try {  
			downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");  
		} catch (UnsupportedEncodingException e) {  
			e.printStackTrace();  
		}   
		return downloadChineseFileName;  
	}
	/**
	 * 获取上报资料文件名
	 * @return
	 */
	@JSON(serialize = false)
	public String getDownloadFileName() {  
		String downloadChineseFileName = "上报资料.zip";
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
			String tempString = Constants.DIR_DOCUMENT+"/"+System.currentTimeMillis()+".zip";
			FileOutputStream fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath(tempString));
		    ZipOutputStream zos = new ZipOutputStream(fos);
			for (Iterator iterator = uploads.iterator(); iterator.hasNext();) {
				Upload upload = (Upload) iterator.next();
				String downloadString = Constants.DIR_DOCUMENT+"/"+ upload.getBOrgInformation().getOid()+"/";
				String filepath = downloadString+upload.getFilename();
			    ZipEntry z = new ZipEntry(upload.getFilename());
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
 		    zos.close();
			input = ServletActionContext.getServletContext().getResourceAsStream(tempString);
		}catch (Exception e) {
			info("没有找到文件");
		}
		log("下载资料", Constants.LOG_TYPE_DOWNLOAD);
		return input;
	}
	public String download(){
		String[] _uids = uids.split(",");
		for(int i =0 ;i<_uids.length;i++){
			Upload upload = documentService.findById(Integer.valueOf(_uids[i]));
			if(upload == null)
				throw new ServiceException("没有找到对应的文件Upload");
			if(getSessionUserInformation()==null){
				documentService.updateDocument(upload);
			}
			uploads.add(upload);
		}
		return SUCCESS;
	}
	/**
	 * 查询资料（人民银行用户）
	 */
	public String list(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if(oid==null || oid==9999){
			if(session.get("oid")==null || "9999".equals(String.valueOf(oid)))
				session.put("oid",null);
		}else {
	        session.put("oid", oid);
		}
		if(bid!=null)
	        session.put("bid", bid);
		if(filename!=null && !"".equals(filename)){
	        session.put("filename", filename);
		}
		if(starttime!=null && !"".equals(starttime)){
	        session.put("starttime", starttime);
		}
		if(endtime!=null && !"".equals(endtime)){
	        session.put("endtime", endtime);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", getSessionUserInformation()==null?session.get("oid"):getSessionUserInformation());
		params.put("filename", session.get("filename"));
		params.put("bid",session.get("bid"));
		params.put("starttime",session.get("starttime"));
		params.put("endtime",session.get("endtime"));		
		PaginaterList list = documentService.findAllUpload(params,this.getPage());		
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

    /**
	 * 
	 * @return 返回输入流
	 */
	@JSON(serialize = false)
	public InputStream getDownloadXls() {	

		BankUser bankUser = getSessionUserCode();
		InputStream input=null;
		info("开始下载");
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("oid", this.getOid());
			params.put("filename", this.getFilename());
			params.put("starttime",this.getStarttime());
			params.put("endtime",this.getEndtime());	
			String realpath = ServletActionContext.getServletContext().getRealPath("/");
			String path = realpath+Constants.DIR_DOCUMENT_XLS;
			String downloadString = documentService.buildXls(bankUser.getBuname(),path,params);
			this.setUpDownFileName(downloadString);	    	
			downloadString = Constants.DIR_DOCUMENT_XLS + downloadString;
			downloadString = StringUtil.replace(downloadString, '\\', '/');	    	
			input = ServletActionContext.getServletContext().getResourceAsStream("/"+downloadString);
		}catch (Exception e) {
			info("没有找到文件");
		}
		return input;
	}
	public String downloadxls(){
		return SUCCESS;
	}
	public String manage(){  
		log("查询上报资料", Constants.LOG_TYPE_SELECT);
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		session.put("oid", null);
		session.put("filename", null);
		session.put("starttime",null);
		session.put("endtime",null);
		return SUCCESS;
	}
	/**
	 * 删除资料
	 * @return
	 */
	public String delete(){
		upload = documentService.findById(this.getUid());
		if(upload == null)
			throw new ServiceException("没有找到对应的上传资料");    			
		String path = ServletActionContext.getServletContext().getRealPath(Constants.DIR_DOCUMENT+"/"+ upload.getBOrgInformation().getOid());
		path = StringUtil.replace(path, '\\', '/');	
		path = path + "/" + upload.getFilename();
		System.out.println(" 要删除的文件 ：： "+path);
		documentService.deleteDocument(upload,path);
		log("金融机构用户删除上报的资料",Constants.LOG_TYPE_DELETE);

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
	public Upload getModel() {
		return upload;
	}
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUpDownFileName() {
		return upDownFileName;
	}
	public void setUpDownFileName(String upDownFileName) {
		this.upDownFileName = upDownFileName;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}

}
