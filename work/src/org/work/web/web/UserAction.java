/**
 * 
 */
package org.work.web.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.BankUser;
import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Role;
import org.work.web.service.financial.IFinancialService;
import org.work.web.service.manage.IManageService;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class UserAction extends JsonBaseAction implements ModelDriven<BankUser> {
	private BankUser bankUser = new BankUser();
	private IManageService manageService;
	private IFinancialService financialService;

	private Integer oid;//金融机构ID
	private Integer bid;//金融机构类别
	private String buname;//用户名称
	private String bumark;//角色ID
	private String buid;//用户ID
	private String selectedRoles;//用户选择的角色
	private String oldpswd;//原始密码
	private String newpswd;//新密码
	
	public void setFinancialService(IFinancialService financialService) {
		this.financialService = financialService;
	}

	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}

	public String getOldpswd() {
		return oldpswd;
	}

	public void setOldpswd(String oldpswd) {
		this.oldpswd = oldpswd;
	}

	public String getNewpswd() {
		return newpswd;
	}

	public void setNewpswd(String newpswd) {
		this.newpswd = newpswd;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBuname() {
		return buname;
	}

	public void setBuname(String buname) {
		this.buname = buname;
	}


	public String getBumark() {
		return bumark;
	}

	public void setBumark(String bumark) {
		this.bumark = bumark;
	}

	public String getBuid() {
		return buid;
	}

	public void setBuid(String buid) {
		if(buid == null) return;
		bankUser = manageService.findById(buid.toString());
		if(bankUser == null){
			info("没有找到指定角色"+buid);
		}else{
			this.buid = buid;
		}
		this.buid = buid;
	}

	public String getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(String selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	/**
	 * 密码修改
	 * @return
	 */
	public String changepwd(){
		return SUCCESS;
	}
	/**
	 * 密码修改保存
	 * @return
	 */
	public String pwdupdate(){
		if(!this.getOldpswd().equals(getSessionUserCode().getBupswd())){
			this.addFieldError("oldpswd","原密码输入错误");
			return INPUT;
		}else{
			BankUser bUser = manageService.findById(getSessionUserCode().getBuid());
			bUser.setBupswd(getNewpswd());
			try{
				manageService.updateUser(bUser);
			}catch (Exception e) {
				e.printStackTrace();
				return INPUT;
			}
		}
		log("用户修改密码", Constants.LOG_TYPE_UPDATE);
		return OK;
	}
	/**
	 * 金融机构用户维护显示列表
	 * @return
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
		if(getBuname()==null || "".equals(buname)){
			if(session.get("tbuname")==null || "".equals(buname))
				session.put("tbuname", null);
		}else{
			session.put("tbuname",buname);
		}
		if(getBumark()==null || "".equals(bumark)){
			if(session.get("tbumark")==null|| "".equals(bumark))
				session.put("tbumark", null);
		}else{
			session.put("tbumark",bumark);
		}
		params.put("oid", session.get("toid"));
		params.put("bid", session.get("tbid"));
		params.put("brname", session.get("tbuname"));	
		params.put("bumark", session.get("tbumark"));	
		List<Map> result = new ArrayList<Map>();
		PaginaterList list = manageService.getUserInformation(params,this.getPage());
		Map<String,Object> item;
		Set<Role> roleSet;
		for(Iterator<BankUser> iterator = list.getList().iterator();iterator.hasNext();){
			BankUser bankUser = iterator.next();
			String roleString = "";//用户所属角色:[role] [role1]...
			item = new HashMap<String,Object>();
			item.put("buid", bankUser.getBuid());
			item.put("buname", bankUser.getBuname());
			item.put("btel", bankUser.getBtel());
			item.put("bmail", bankUser.getBmail());
			item.put("brname", bankUser.getBrname());
			item.put("loadtime", bankUser.getLoadtime());
			item.put("bumark", bankUser.getBumark());
			item.put("bname", bankUser.getInformation()==null?Constants.USER_ORG:bankUser.getInformation().getBname());
			roleSet = bankUser.getTPubRoleusers();
			for(Iterator<Role> it = roleSet.iterator();it.hasNext();){
				Role ritem = it.next();
				roleString+="["+ritem.getRname()+"]\r";
			}
			item.put("rname", roleString);
			result.add(item);
		}
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(result);
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("用户信息显示列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}
	/**
	 * 进入新增页面
	 * @return
	 */
	public String  add() {
		List<Catalog> list = financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}
	/**
	 * 保存用户
	 * @return
	 */
	public String  save() {
		Map map = new HashMap();
		map.put("username", bankUser.getBuname());
		List list = manageService.findBy(map);
		if(list.size()>0){
			throw new ServiceException("用户名重复");
		}
		bankUser.setBuupdatetime(DateUtil.formatDateTime());
		bankUser.setBuauthor(getSessionUserCode().getBuname());
		bankUser.setBustatus(Constants.USER_STATUS_NORMAL);
		if(this.getOid()==0){
			bankUser.setInformation(null);
		}else{
			Information information = financialService.findByOid(oid);
			bankUser.setInformation(information);
		}
		manageService.saveUser(bankUser);
		this.addNaviButton("继续添加", "user/user_add.shtml");
		this.addNaviButton("返回", "user/user_manage.shtml");
		return OK;
	}
	/**
	 * 修改用户
	 * @return
	 */
	public String  modify() {
		if(bankUser == null)
			throw new ServiceException("没有找到指定的用户");	
		List<Catalog> list = financialService.findByCatalog();
		this.put("list", list);
		return SUCCESS;
	}	
	/**
	 * 保存修改用户
	 * @return
	 */
	public String  update() {
		if(bankUser == null)
			throw new ServiceException("没有找到指定的用户");
		BankUser updateUser = manageService.findById(bankUser.getBuid());
		if(this.getOid()==0){
			updateUser.setInformation(null);
		}else{
			Information information = financialService.findByOid(oid);
			updateUser.setInformation(information);
		}
		updateUser.setBuname(bankUser.getBuname());
		updateUser.setBrname(bankUser.getBrname());
		updateUser.setBtel(bankUser.getBtel());
		updateUser.setBmail(bankUser.getBmail());
		updateUser.setBumark(bankUser.getBumark());
		updateUser.setBustatus(bankUser.getBustatus());
		updateUser.setBuupdatetime(DateUtil.formatDateTime());
		updateUser.setBuauthor(getSessionUserCode().getBuname());
		manageService.updateUser(updateUser);
		info("用户保存成功");
		this.addNaviButton("继续操作", "user/user_manage.shtml");
		return OK;
	}
	/**
	 * 用户角色选择
	 * @return
	 */
	public String grant(){
		//该用户已经拥有的角色
		Set roles = bankUser.getTPubRoleusers();
		if(null!=roles)
			put("haveRoles",roles);
		
		 //查询所有角色
		PaginaterList paginaterList = manageService.getAllRole(null, page);
		List rolelist = paginaterList.getList();
		Iterator it = roles.iterator();
		while(it.hasNext()){
			rolelist.remove(it.next());
		}
		put("residualRoles",rolelist);
		return SUCCESS;
	}
	/**
	 * 用户角色保存
	 * @return
	 */
	public String bankuserGrantRoleSave(){
		Set<Role> roles = new HashSet<Role>(10);
		String[] roleids = null;
		if(null!=selectedRoles){
			roleids = selectedRoles.split(",");
		}
		for(int i=0;i<roleids.length;i++){
			Role role = manageService.findRoleById(roleids[i].trim());
			roles.add(role);
		}
		bankUser.setTPubRoleusers(roles);
		manageService.updateUser(bankUser);
		this.addNaviButton("继续操作", "user/user_manage.shtml");
		return OK;
	}
	/**
	 * 进入管理页面
	 * @return
	 */
	public String  manage() {
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("toid",null);
        session.put("tbid",null);
        session.put("tbuname",null);
        session.put("tbumark",null);
		List<Catalog> list = financialService.findByCatalog();
		Catalog ct = new Catalog();
		ct.setBid(0);
		ct.setCatname("人民银行深圳市中支");
		list.add(ct);
		this.put("list", list);
		return SUCCESS;
	}
	public String reset(){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			if("".equals(buid) || buid==null){
				out.print("重置密码失败");
			}else{
				BankUser bUser = manageService.findById(this.getBuid());
				bUser.setBupswd(Constants.DEFAULT_PASSWORD);
				manageService.updateUser(bUser);
				out.print("重置密码成功");
			}
			 out.flush();   
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
	public BankUser getModel() {
		return bankUser;
	}

}
