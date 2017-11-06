/**
 * 
 */
package org.work.web.web;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Tai;
import org.work.web.service.financial.IFinancialService;
import org.work.web.util.DateUtil;
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
public class FinancialAction extends JsonBaseAction implements ModelDriven<Information>{
	private Information information = new Information();
	private IFinancialService financialService;
	private int cid;//机构类别ID
	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别
	private String downloadString;//导出excel文件名
	
	private String taireason;//台账事由
	private Integer taidi;//id
	
	private List gridModel;//金融机构显示Json
	private List gridModelhistory;//金融机构变更历史记录
	
	private String fileName; 
	
	private Set<Information> informationSet;
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	public Set<Information> getInformationSet() {
		return informationSet;
	}

	public void setInformationSet(Set<Information> informationSet) {
		this.informationSet = informationSet;
	}

	public String findInformation() {
		Catalog catalog = financialService.findByCatalogId(cid);
/*		CatalogComparator catalogComparator = new CatalogComparator();
		informationSet = new TreeSet<Information>(catalogComparator);
		if(catalog!=null){
			if(catalog.getBOrgInformations()!=null&&catalog.getBOrgInformations().size()!=0){
				for(Iterator<Information> iterator = catalog.getBOrgInformations().iterator();iterator.hasNext();){
					Information tmp = iterator.next();
					informationSet.add(tmp);
				}
			}
		}
*/		informationSet=catalog.getBOrgInformations();
		return JSON;
	}
	public String entry() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("toid",null);
        session.put("tbid",null);
		List<Catalog> list = this.financialService.findByCatalog();
		Catalog ct = new Catalog();
		ct.setBid(null);
		ct.setCatname("所有");
		list.add(ct);
		this.put("list", list);
		log("金融机构资料查询", Constants.LOG_TYPE_SELECT);
//		log("金融机构查询", "查询");
		return SUCCESS;
	}
	
	/**
	 * 档案管理查询
	 * @return
	 */
	public String entrance() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("toid",null);
        session.put("tbid",null);
		List<Catalog> list = this.financialService.findByCatalog();
		Catalog ct = new Catalog();
		ct.setBid(null);
		ct.setCatname("所有");
		list.add(ct);
		this.put("list", list);
		log("金融机构资料查询", Constants.LOG_TYPE_SELECT);
//		log("金融机构查询", "查询");
		return SUCCESS;
	}
	
	public String add() {
		BankUser bankUser = getSessionUserCode();
		information = bankUser.getInformation();
		put("info", information);
		return SUCCESS;
	}



	/**
	 * 保存金融机构的所有信息
	 * @return
	 */
	public String save() {
		BankUser bankUser = getSessionUserCode();
		Information info1 = new Information();
		Information info = new Information();
		info1 = bankUser.getInformation();//原
		
		try {
			BeanUtils.copyProperties(info,info1);//新
			BeanUtils.copyProperties(info1, information);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		info1.setBupdatetime(DateUtil.formatDateTime());
		info1.setBupdateuser(bankUser.getBuname());
		info1.setIsneed("1");
		financialService.updateInformation(info,info1);
		log("金融机构用户保存金融机构信息",Constants.LOG_TYPE_UPDATE);
		return OK;
	}
	/**
	 * 取得所有的金融机构类别
	 * @return
	 */
	public String baseadd(){
		List<Catalog> list = this.financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	/**
	 * 人行用户后期维护新增金融机构，只新增金融机构代码和金融机构名称，具体的详细信息由相应金融机构用户维护
	 * @return
	 */
	public String basesave(){
		List iList = financialService.findByBoid(information.getBoid());
		if(iList.size()>0){
			throw new ServiceException("机构代码重复");
		}

		this.financialService.addInformation(information);
		System.out.println("金融机构类别id" + information.getBoid());
	
		log("后期维护新增金融机构，只新增金融机构代码和金融机构名称", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续操作", "financial/financial_baseadd.shtml");
		return OK;
	}
	/**
	 * 金融机构信息列表
	 */
	public String list() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Map<String, Object> params = new HashMap<String, Object>();

		if(getOid()==null || oid==9999){
			if(session.get("toid")==null || oid==9999)
				session.put("toid",null);
		}else{
			session.put("toid",oid);
		}
		if(getBid()==null){
			if(session.get("tbid")==null)
			session.put("tbid",null);
		}else{
			session.put("tbid",bid);
		}

		params.put("oid", session.get("toid"));
		params.put("bid", session.get("tbid"));		
		PaginaterList list = financialService.getInformationFinancial(params,this.getPage());		
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("人民银行用户查询金融机构信息", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	public String tailist(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", this.getOid());	
		PaginaterList list = financialService.findTai(params,this.getPage());
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
	public String taientry(){
		if(this.oid==null)
			throw new ServiceException("没有找到指定金融机构");
		put("oid", oid);
		return SUCCESS;
	}
	public String taiadd(){
		return SUCCESS;
	}
	public String taisave(){
		Integer taioid = this.getOid();
		System.out.println(this.getTaireason());
		System.out.println(taioid);
		Information information = financialService.findByOid(this.getOid());
		if(information==null)
			throw new ServiceException("找不到该机构信息");
		Tai tai = new Tai();
		tai.setTaiauthor(getSessionUserCode().getBuname());
		tai.setTaidate(DateUtil.getCurrentPrettyDateTime());
		tai.setTaireason(this.getTaireason());
		tai.setBOrgInformation(information);
		financialService.saveTai(tai);

		this.addNaviButton("继续操作", "financial/financial_taiadd.shtml?oid="+this.getOid());
		this.addNaviButton("返回", "financial/financial_taientry.shtml?oid="+this.getOid());
		return OK;
	}
	public String taimodify(){
		if(this.getTaidi()==null)
			throw new ServiceException("没有找到台账");
		Tai tai = financialService.findTai(this.getTaidi());
		put("tai", tai);
		return SUCCESS;
	}
	public String taimodifysave(){
		System.out.println(this.getTaireason());
		Tai tai = financialService.findTai(this.getTaidi());
		if(tai==null)
			throw new ServiceException("找不到该机构信息");
		tai.setTaiauthor(getSessionUserCode().getBuname());
		tai.setTaidate(DateUtil.getCurrentPrettyDateTime());
		tai.setTaireason(this.getTaireason());
		financialService.saveTai(tai);
		return OK;
	}
	public String historyentry(){
		if(this.oid==null)
			throw new ServiceException("没有找到指定金融机构");
		put("oid", oid);
		return SUCCESS;
	}
	/**
	 * 查看金融机构的变更历史
	 * @return
	 */
	public String history() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", this.getOid());		
		PaginaterList list = financialService.getHistoryFinancial(params,this.getPage());	
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModelhistory(list.getList());		
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("查看金融机构变更历史", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**
	 * 查看金融机构明细
	 * @return
	 */
	public String view() {		
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");		
		put("information", information);
		log("查看金融机构明细", Constants.LOG_TYPE_SELECT);
		return SUCCESS;
	}
	/**
	 * 查看金融机构档案明细
	 * @return
	 */
	public String sight() {		
		if(information == null)
			throw new ServiceException("没有找到指定的金融机构");		
		put("information", information);
		log("查看金融机构明细", Constants.LOG_TYPE_SELECT);
		return SUCCESS;
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
	 * 
	 * @return 返回输入流
	 */
	@JSON(serialize = false)
    public InputStream getDownloadXls() {	
		
    	InputStream input=null;
    	info("开始下载EXCEL");
    	try{
	    	input = ServletActionContext.getServletContext().getResourceAsStream("/"+downloadString);
    	}catch (Exception e) {
    		info("没有找到文件");
		}
		return input;
    }
    public String download(){
		BankUser bankUser = getSessionUserCode();
		Map<String, Object> params = new HashMap<String, Object>();
		if(this.getOid()!=9999){
			params.put("oid", this.getOid());
		}
		params.put("bid", this.getBid());	
		String realpath = ServletActionContext.getServletContext().getRealPath("/");
		String path = realpath+Constants.DIR_FINANCIAL;
    	downloadString = financialService.buildXls(bankUser.getBuname(),path,params);
    	if(downloadString==""){
    		throw new ServiceException("没有数据需要导出EXCEL");
    	}
    	this.setFileName(downloadString);	    	
    	downloadString = Constants.DIR_FINANCIAL + downloadString;
    	downloadString = StringUtil.replace(downloadString, '\\', '/');
    	this.setDownloadString(downloadString);
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
	@JSON(serialize = false)
	public Information getModel() {
		return information;
	}
	@JSON(serialize = false)
	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	@Override
	public void setGridModel(List gridModel) {
		this.gridModel = gridModel;
	}
	@JSON(serialize = false)
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		if(oid == null) return;
		information = financialService.findByOid(oid);
		if(information == null){
			info("没有找到指定金融机构"+oid);
		}else{
			this.oid = oid;
		}
		this.oid = oid;
	}

	@JSON(serialize = false)
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public List getGridModelhistory() {
		return gridModelhistory;
	}

	public void setGridModelhistory(List gridModelhistory) {
		this.gridModelhistory = gridModelhistory;
	}
	@JSON(serialize = false)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@JSON(serialize = false)
	public String getDownloadString() {
		return downloadString;
	}

	public void setDownloadString(String downloadString) {
		this.downloadString = downloadString;
	}

	@JSON(serialize = false)
	public String getTaireason() {
		return taireason;
	}

	public void setTaireason(String taireason) {
		this.taireason = taireason;
	}

	@JSON(serialize = false)
	public Integer getTaidi() {
		return taidi;
	}

	public void setTaidi(Integer taidi) {
		this.taidi = taidi;
	}

}
