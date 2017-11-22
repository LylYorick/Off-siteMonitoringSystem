package org.work.web.web;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Archives;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Archives;
import org.work.web.service.archives.ArchivesService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

import com.google.gson.Gson;
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
	
	private ArchivesService archivesService;
	
	
	public ArchivesService getArchivesService() {
		return archivesService;
	}

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
		List<Catalog> list = this.archivesService.findByCatalog();
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
	 * 保存金融机构的所有信息
	 * @return
	 */
	public String save() {
		BankUser bankUser = getSessionUserCode();
		Archives archives1 = new Archives();
		Archives arch = new Archives();
		archives1 = bankUser.getArchives();//原
		try {
			BeanUtils.copyProperties(arch,archives1);//新
			BeanUtils.copyProperties(archives1, archives);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		
		archives1.setBupdatetime(DateUtil.formatDateTime());
		archives1.setBupdateuser(bankUser.getBuname());
		
       archivesService.updateInformation(arch,archives1);
		log("金融机构用户保存金融机构信息",Constants.LOG_TYPE_UPDATE);
		return OK;
	}
	/**
	 * 人民银行用户添加机构
	 * @return
	 */
	public String baseadd(){
		List<Catalog> list = archivesService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	
	/**
	 * 人行用户后期维护新增金融机构，只新增金融机构代码和金融机构名称，具体的详细信息由相应金融机构用户维护
	 * @return
	 */
	public String basesave(){
		List iList = archivesService.findByBoid(archives.getBoid());
		if(iList.size()>0){
			throw new ServiceException("机构代码重复");
		}
		try {
			this.archivesService.addInformation(archives);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("后期维护新增金融机构，只新增金融机构代码和金融机构名称", Constants.LOG_TYPE_ADD);
		this.addNaviButton("继续操作", "archives/archives_baseadd.shtml");
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
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("oid", this.getOid());		
//		PaginaterList list = financialService.getHistoryFinancial(params,this.getPage());	
//		Long maxRecord = list.getPaginater().getMaxRowCount();
//		this.setGridModelhistory(list.getList());		
//		setPage(this.getPage());
//		setRows(getRows());
//		setTotal(list.getPaginater().getMaxPage());
//		setRecord(maxRecord.intValue());
//		setSidx("");
//		setSord("asc");
//		log("查看金融机构变更历史", Constants.LOG_TYPE_SELECT);
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


	
	public Archives getArchives() {
		return archives;
	}

	public void setArchives(Archives archives) {
		this.archives = archives;
	}

	@Override
	public Archives getModel() {
		return this.archives;
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
	/**
	 * 档案信息维护
	 * @return
	 */
	public String increase() {
		BankUser bankUser = getSessionUserCode();
		archives = bankUser.getArchives();
		put("info", archives);
		return SUCCESS;
	}
}
