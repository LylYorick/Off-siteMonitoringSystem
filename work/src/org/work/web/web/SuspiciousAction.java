/**
 * 
 */
package org.work.web.web;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.BankUser;
import org.work.web.po.Bankbase;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.suspicious.ISuspiciousService;
import org.work.web.util.CatalogComparator;
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
public class SuspiciousAction extends JsonBaseAction implements ModelDriven<Bankbase>{
	private Bankbase bankbase = new Bankbase();
	private ISuspiciousService suspiciousService;
	private IFinancialService financialService;
	
	private File suspiciousFile;
	private String suspiciousFileFileName;
	private String suspiciousFileContentType;
	private File suspiciousdataFile;
	private String suspiciousdataFileFileName;
	private String suspiciousdataFileContentType;
	private String orgname;
	
	private String downloadString;//导出excel文件名
	private String fileName;
	private Integer oid;//金融机构ID
	private String cname;//主体名称
	private String ccid;//证件号码
	private String lineid;//线索编号
	private String starttime;
	private String endtime;
	private Integer id;
	
	private List gridModelBankDetail;//银行业明细数据json
	
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public File getSuspiciousFile() {
		return suspiciousFile;
	}

	public void setSuspiciousFile(File suspiciousFile) {
		this.suspiciousFile = suspiciousFile;
	}

	public String getSuspiciousFileFileName() {
		return suspiciousFileFileName;
	}

	public void setSuspiciousFileFileName(String suspiciousFileFileName) {
		this.suspiciousFileFileName = suspiciousFileFileName;
	}

	public String getSuspiciousFileContentType() {
		return suspiciousFileContentType;
	}

	public void setSuspiciousFileContentType(String suspiciousFileContentType) {
		this.suspiciousFileContentType = suspiciousFileContentType;
	}

	public File getSuspiciousdataFile() {
		return suspiciousdataFile;
	}

	public void setSuspiciousdataFile(File suspiciousdataFile) {
		this.suspiciousdataFile = suspiciousdataFile;
	}

	public String getSuspiciousdataFileFileName() {
		return suspiciousdataFileFileName;
	}

	public void setSuspiciousdataFileFileName(String suspiciousdataFileFileName) {
		this.suspiciousdataFileFileName = suspiciousdataFileFileName;
	}

	public String getSuspiciousdataFileContentType() {
		return suspiciousdataFileContentType;
	}

	public void setSuspiciousdataFileContentType(
			String suspiciousdataFileContentType) {
		this.suspiciousdataFileContentType = suspiciousdataFileContentType;
	}

	public String entry() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Catalog catalog = financialService.findByCatalogId(1);
		CatalogComparator catalogComparator = new CatalogComparator();
		Set<Information> informationSet = new TreeSet<Information>(catalogComparator);
		if(getSessionUserInformation()==null){
		for(Iterator<Information> iterator = catalog.getBOrgInformations().iterator();iterator.hasNext();){
			Information tmp = iterator.next();
			informationSet.add(tmp);
		}
		}else{
			informationSet.add(getSessionUserCode().getInformation());
		}
        session.put("oid", null);
        session.put("cname", null);
        session.put("ccid", null);
        session.put("lineid", null);
        session.put("starttime", null);
        session.put("endtime", null);
		put("informationSet", informationSet);
		return SUCCESS;
	}

	public String add() {
		BankUser bankUser = getSessionUserCode();
		Information information = bankUser.getInformation();
		this.put("info", information);
		return SUCCESS;
	}
	
	public String bankdetailadd(){
		BankUser bankUser = getSessionUserCode();
		Information information = bankUser.getInformation();
		this.put("info", information);
		return SUCCESS;
	}

	/**
	 * 保存银行业可疑交易信息
	 * @return
	 */
	public String save() {		
		BankUser bankUser = getSessionUserCode();		
		bankbase.setBOrgInformation(bankUser.getInformation());
		suspiciousService.saveBankData(bankbase,suspiciousFile,suspiciousdataFile,suspiciousFileFileName,suspiciousdataFileFileName,bankUser.getBuname());		
		info("添加成功...");
		log("保存银行业可疑交易信息，包括明细数据", Constants.LOG_TYPE_ADD);
		return OK;
	}
	
	public String bankview() {		
		Bankbase bankbase = suspiciousService.findById(id);
		if(bankbase == null)
			throw new ServiceException("没有找到指定的可疑交易信息");		
		put("bankbase", bankbase);
		put("id", this.getId());
		this.setId(this.getId());
		log("查看银行业可疑交易明细", Constants.LOG_TYPE_SELECT);
		return SUCCESS;
	}
	
	public String banklist() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Map<String, Object> params = new HashMap<String, Object>();
		if(oid!=null){
	        session.put("oid", oid);
		}
		if(cname!=null){
	        session.put("cname", cname);
		}
		if(ccid!=null){
	        session.put("ccid", ccid);
		}
		if(lineid!=null){
	        session.put("lineid", lineid);
		}
		if(starttime!=null){
	        session.put("starttime", starttime);
		}
		if(endtime!=null){
	        session.put("endtime", endtime);
		}
		params.put("oid", getSessionUserInformation()==null?session.get("oid"):getSessionUserInformation());
		params.put("cname", session.get("cname"));
		params.put("ccid", session.get("ccid"));	
		params.put("lineid", session.get("lineid"));	
		params.put("starttime", session.get("starttime"));	
		params.put("endtime", session.get("endtime"));	
		PaginaterList list = suspiciousService.getBankBaseInfo(params,this.getPage());		
		System.out.println(list.size());
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
//		log("查询银行业可疑交易信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	
	public String bankdetaillist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", this.getId());
		PaginaterList list = suspiciousService.getBankBaseDetailInfoById(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelBankDetail(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查询银行业可疑交易明细信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	
	/**
	 * 导出excel，下载
	 * @return
	 */
	@JSON(serialize = false)
    public InputStream getDownloadXlsBank() {	
		
    	InputStream input=null;
    	info("开始下载EXCEL");
    	try{
	    	input = ServletActionContext.getServletContext().getResourceAsStream("/"+downloadString);
    	}catch (Exception e) {
    		info("没有找到文件");
		}
		return input;
    }
	/**
	 * 
	 * @return 获取下载文件中文名
	 */
	@JSON(serialize = false)
	public String getDownloadChineseFileName() {  
        String downloadChineseFileName = this.getFileName();
        try {  
            downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
  
        return downloadChineseFileName;  
    }
	/**
	 * 导出excel
	 * @return
	 */
    public String downloadbank(){
    	BankUser bankUser = getSessionUserCode();
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", bankUser.getInformation().getOid());
		params.put("cname", this.getCname());
		params.put("ccid", this.getCcid());	
		params.put("lineid", this.getLineid());	
		params.put("starttime", this.getStarttime());	
		params.put("endtime", this.getEndtime());
		String realpath = ServletActionContext.getServletContext().getRealPath("/");
		String path = realpath+Constants.DIR_SUSPICIOUS_XLS;
		System.out.println("***** path :: "+path);
    	downloadString = suspiciousService.buildXlsBank(bankUser.getBuname(),path,params);
    	if(downloadString==""){
    		throw new ServiceException("没有数据需要导出EXCEL");
    	}
    	this.setFileName(downloadString);	    	
    	downloadString = Constants.DIR_SUSPICIOUS_XLS + downloadString;
    	downloadString = StringUtil.replace(downloadString, '\\', '/');
    	this.setDownloadString(downloadString);
    	return SUCCESS;
    }
    
    /**
	 * 获取补充文件文件名
	 * @return
	 */
	@JSON(serialize = false)
	public String getDownloadFileName() {  
		String downloadChineseFileName = bankbase.getCfile();
		downloadChineseFileName = downloadChineseFileName.substring(downloadChineseFileName.indexOf("_rn_")+4);        
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
		if(id==null)
			throw new ServiceException("没有找到对应的补充文件");
		InputStream input=null;
		info("开始下载");
		try{
			String downloadString = Constants.DIR_SUSPICIOUS + "/";
			String filepath = downloadString+bankbase.getCfile();	    		    	
			input = ServletActionContext.getServletContext().getResourceAsStream(filepath);
		}catch (Exception e) {
			info("没有找到文件");
		}
		return input;
	}
	public String download(){
		System.out.println("this.getId() :: "+this.getId());
		bankbase = suspiciousService.findById(this.getId());
		if(bankbase == null)
			throw new ServiceException("没有找到相应的补充文件");
		return SUCCESS;
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
	public Bankbase getModel() {
		return bankbase;
	}

	public void setSuspiciousService(ISuspiciousService suspiciousService) {
		this.suspiciousService = suspiciousService;
	}

	@JSON(serialize = false)
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@JSON(serialize = false)
	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	@JSON(serialize = false)
	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDownloadString() {
		return downloadString;
	}

	public void setDownloadString(String downloadString) {
		this.downloadString = downloadString;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List getGridModelBankDetail() {
		return gridModelBankDetail;
	}

	public void setGridModelBankDetail(List gridModelBankDetail) {
		this.gridModelBankDetail = gridModelBankDetail;
	}

	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

}
