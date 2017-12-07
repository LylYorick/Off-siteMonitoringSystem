package org.work.web.web;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Archives;
import org.work.web.po.CatalogNew;
import org.work.web.po.CatalogNewId;
import org.work.web.po.Information;
import org.work.web.service.archives.ArchivesService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 档案管理功能
 * @author liyuelong
 *
 */
public class ArchivesAction extends JsonBaseAction implements ModelDriven<Archives>{
	private Archives archives = new Archives();
	private Integer oid;//金融机构ID
	private List gridModelhistory;//金融机构变更历史记录
	private String bfirstid;//一级类别id
	private String bsecondid;//二级类别idd
	private ArchivesService archivesService;
	private List<CatalogNew> catalogNewList;//机构类别list 用于存放前台界面的机类别选择
	private List<Archives> archivesList;//机构信息表
	public void setArchivesService(ArchivesService archivesService) {
		this.archivesService = archivesService;
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
        //这里是用来查询的查询条件
		List<CatalogNew> list = new ArrayList<CatalogNew>();
		CatalogNew ct = new CatalogNew();
		CatalogNewId catalogNewid = new CatalogNewId();
		ct.setId(catalogNewid);
		ct.setFirstCatname("所有");
		list.add(ct);
		list.addAll(this.archivesService.findAllFirstCatname());
		this.put("list", list);
		log("金融机构资料查询", Constants.LOG_TYPE_SELECT);
//		log("金融机构查询", "查询");
		return SUCCESS;
	}
	/**
	 * 查看金融机构档案明细
	 * @return
	 */
	public String view() {		
		if(archives == null)
			throw new ServiceException("没有找到指定的金融机构");		
		put("information", archives);
		log("查看金融机构明细", Constants.LOG_TYPE_SELECT);
		return SUCCESS;
	}
	
	/**
	 * 金融机构信息列表
	 */
	public String list() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		Map<String, Object> params = new HashMap<String, Object>();
		if(getOid()==null || oid==9999){
			if(session.get("toid")==null || oid==9999)
				session.put("toid",null);
		}else{
			session.put("toid",oid);
		}
		if(getBfirstid()==null){
			if(session.get("bfirstid")==null)
			session.put("bfirstid",null);
		}else{
			session.put("bfirstid",bfirstid);
		}
		params.put("oid", session.get("toid"));
		params.put("bfirstid", session.get("bfirstid"));
		PaginaterList list = null;
		try {
			list = archivesService.getArchivesinformation(params,this.getPage());		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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
	/**
	 * 档案信息维护
	 * @return
	 */
	public String increase() {
		BankUser bankUser = getSessionUserCode();
		archives = bankUser.getArchives();
		//判断当前机构的机构类别是否为 “未分配”
		String bfirstid = archives.getCatalogNew().getId().getBfirstid();
		put("info", archives);
		List<CatalogNew> list = archivesService.findAllFirstCatname();
		this.put("list", list);
		if(Constants.UNCLASSIFIED.equals(bfirstid)){
			//如果是 则跳转到 分类界面
			return "toClassify";
		}
		return SUCCESS;
	}
	public String toClassify(){
		BankUser bankUser = getSessionUserCode();
		archives = bankUser.getArchives();
		put("info", archives);
		List<CatalogNew> list = archivesService.findAllFirstCatname();
		this.put("list", list);
		return SUCCESS;
	}
	
	public String doClassify(){
		BankUser bankUser = getSessionUserCode();
		Archives userArchives = bankUser.getArchives();
		//如果没更改机构类型
		if(userArchives.getCatalogNew().equals(archives.getCatalogNew())){
			this.addNaviButton("继续操作", "archives/archives_increase.shtml");
			return OK;
		}
		userArchives.setCatalogNew(archives.getCatalogNew());
		archivesService.updateArchivesCatalog(userArchives);
		bankUser.setArchives(userArchives);
		this.addNaviButton("继续操作", "archives/archives_increase.shtml");
		return OK;
	}
	/**
	 * 保存金融机构的所有信息
	 * @return
	 */
	public String save() {
		BankUser bankUser = getSessionUserCode();
		Archives archives1 = new Archives();
		Archives arch = new Archives();
		archives1 = bankUser.getArchives();//原
		archives.setBupdatetime(DateUtil.formatDateTime());
		archives.setBupdateuser(bankUser.getBuname());
       archivesService.updateInformation(archives1,archives);
       //金融机构不允许在这个界面修改自己的行业 所以可以直接复制
       archives.setCatalogNew(archives1.getCatalogNew());
       bankUser.setArchives(archives);
		log("金融机构用户保存金融机构信息",Constants.LOG_TYPE_UPDATE);
		return OK;
	}
	/**
	 * 人民银行用户添加机构
	 * @return
	 */
	public String baseadd(){
		List<CatalogNew> list = archivesService.findAllFirstCatname();
		this.put("list", list);
		return SUCCESS;
	}
	
	/**
	 * 人行用户后期维护新增金融机构，只新增金融机构代码和金融机构名称，具体的详细信息由相应金融机构用户维护
	 * @return
	 */
	public String basesave(){
		/*List iList = archivesService.findByBoid(archives.getBoid());
		if(iList.size()>0){
			throw new ServiceException("机构代码重复");
		}*/
		try {
			this.archivesService.addInformation(archives);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("后期维护新增金融机构，只新增金融机构代码和金融机构名称", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续操作", "archives/archives_baseadd.shtml");
		this.setSuccessMessage("机构的默认自评者账号为:" + archives.getOid() + "11;" + "机构的默认复评者账号为:"+ archives.getOid() + "12,密码统一为:888888" );
		//this.addActionMessage("新增机构信息完成，机构的默认自评者为:" + archives.getOid() + "11;" + "机构的默认复评者为:"+ archives.getOid() + "12");
		return OK;
	}
	
	
	public String findSecondCataName() throws Exception{
		try {
			catalogNewList = archivesService.findSecondCatname(bfirstid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return JSON;
	}
	public String findThirdCataName() throws Exception{
		try {
			catalogNewList = archivesService.findThirdCatname(bfirstid, bsecondid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return JSON;
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
	 * @throws Exception 
	 */
	public String history() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("oid", this.getOid());		
		PaginaterList list = null;
		try {
			list = 	archivesService.getHistoryFinancial(params,this.getPage());	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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
	 * 根据bfirstid获取机构信息
	 * @return
	 */
	public String findArchivesByBfirstid(){
		archivesList = archivesService.findArchivesByBfirstid(bfirstid);
		return JSON;
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
	public Archives getArchives() {
		return archives;
	}

	public void setArchives(Archives archives) {
		this.archives = archives;
	}

	@Override
	@JSON(serialize = false)
	public Archives getModel() {
		return this.archives;
	}
	
	@JSON(serialize = false)
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		if(oid == null) return;
		try {
			archives = archivesService.findByOid(oid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(archives == null){
			info("没有找到指定金融机构"+oid);
		}else{
			this.oid = oid;
		}
		this.oid = oid;
	}
	public List getGridModelhistory() {
		return gridModelhistory;
	}

	public void setGridModelhistory(List gridModelhistory) {
		this.gridModelhistory = gridModelhistory;
	}
	public String getBfirstid() {
		return bfirstid;
	}
	public void setBfirstid(String bfirstid) {
		this.bfirstid = bfirstid;
	}
	
	public String getBsecondid() {
		return bsecondid;
	}
	public void setBsecondid(String bsecondid) {
		this.bsecondid = bsecondid;
	}
	public List<CatalogNew> getCatalogNewList() {
		return catalogNewList;
	}
	public void setCatalogNewList(List<CatalogNew> catalogNewList) {
		this.catalogNewList = catalogNewList;
	}
	public List<Archives> getArchivesList() {
		return archivesList;
	}
	public void setArchivesList(List<Archives> archivesList) {
		this.archivesList = archivesList;
	}
	
	
	
}
