/**
 * 
 */
package org.work.web.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.po.Privilege;
import org.work.web.po.Role;
import org.work.web.service.manage.IManageService;
import org.work.web.util.PaginaterList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @作者 aps-dux
 * @创建日期 2010-04-22
 * @版本 深圳V1.0
 */
@SuppressWarnings("serial")
public class RoleAction extends JsonBaseAction implements ModelDriven<Role> {
	private Role role = new Role();
	private IManageService manageService;
	private String rid;//角色ID
	private String prlgArr;//角色权限

	public void setManageService(IManageService manageService) {
		this.manageService = manageService;
	}

	public String getPrlgArr() {
		return prlgArr;
	}

	public void setPrlgArr(String prlgArr) {
		this.prlgArr = prlgArr;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		if(rid == null) return;
		role = manageService.findRoleById(rid);
		if(role == null){
			info("没有找到指定角色"+rid);
		}else{
			this.rid = rid;
		}
		this.rid = rid;
	}

	/**
	 * 金融机构用户维护显示列表
	 * @return
	 */
	public String list() {
		PaginaterList list = manageService.getAllRole(null,this.getPage());
		Long maxRecord = list.getPaginater().getMaxRowCount();
		this.setGridModel(list.getList());
		setPage(this.getPage());
		setRows(getRows());
		setTotal(list.getPaginater().getMaxPage());
		setRecord(maxRecord.intValue());
		setSidx("");
		setSord("asc");
		log("角色显示列表", Constants.LOG_TYPE_SELECT);
		return JSON;
	}

	/**
	 * 进入管理页面
	 * @return
	 */
	public String  manage() {
		return SUCCESS;
	}
	/**
	 * 进入新增页面
	 * @return
	 */
	public String  add() {
		return SUCCESS;
	}
	/**
	 * 保存角色
	 * @return
	 */
	public String  save() {
		manageService.saveOrUpdateRole(role);
		return OK;
	}	
	/**
	 * 修改角色
	 * @return
	 */
	public String  modify() {
		if(role == null)
			throw new ServiceException("没有找到指定的角色");		
		return SUCCESS;
	}
	/**
	 * 保存修改角色
	 * @return
	 */
	public String  update() {
		if(role == null)
			throw new ServiceException("没有找到指定的角色");
		Role updateRole = manageService.findRoleById(role.getRid());
		updateRole.setRname(role.getRname());
		updateRole.setRmark(role.getRmark());
		manageService.saveOrUpdateRole(updateRole);
		return OK;
	}
	/**
	 * 角色赋权
	 * @return
	 */
	public String  grant() {
		if (role == null) {
			throw new ServiceException("没有找到指定权限！");
		}		
		Role role = null;
		StringBuffer sb = new StringBuffer();
		role = manageService.findRoleById(rid);
		if (role == null) {
			throw new ServiceException("没有找到指定记录！");
		}
		Set<Privilege> ps = role.getTPubRoleprivileges();
		int i = 0;
		for(Privilege rp : ps){
			if (i++ > 0) {
				sb.append(",");
			}
			sb.append(String.format("{menudm:'%d'}", rp.getPid()));
		}
		ActionContext.getContext().getSession().put("havePrivileges", sb.toString());
			 
		return searchPrivileges();
	}
	/**
	 * 查询出所有权限信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String searchPrivileges(){
		List<Privilege> list = manageService.listPrivilege();
		if (list == null) {
			throw new ServiceException("数据异常，权限列表为空！");
		}
		String[] treestr = new String[list.size()];
		for(int i=0;i<list.size();i++){
			Privilege p = list.get(i);
			StringBuffer sb = new StringBuffer("");
			sb.append("\"");
			sb.append(p.getPid());
			sb.append("\",");
			
			sb.append("\"");
			sb.append((p.getParent().getPid()==9999?"-1":p.getParent().getPid()));
			sb.append("\",");
			
			sb.append("\"");
			sb.append(p.getPname());
			sb.append("\",");
			
			sb.append("\"");
			sb.append("#");//p.getMenuer()
			sb.append("\",");
			
			sb.append("\"");
			sb.append("\",");
			
			sb.append("\"");
			sb.append("\",");
			
			sb.append("\"");
			sb.append("\",");
			
			sb.append("\"");
			sb.append("\",");
			
			sb.append("false");
			
			treestr[i] = sb.toString();
		}
		ActionContext.getContext().getSession().put("treeItems", treestr);
		return SUCCESS;
	}
	/**
	 * 角色赋权插入
	 */
	public String privilegeInsert(){
		Privilege p;
		Set<Privilege> privileges = new HashSet<Privilege>();
		Role role = manageService.findRoleById(rid);
		if(this.getPrlgArr() == null || "".equals(this.getPrlgArr()))
			throw new ServiceException("您没有选择任何数据权限");
		String[] pid = this.getPrlgArr().split(";");
		for(int i=0;i<pid.length;i++){
			p = new Privilege();
			p = manageService.findPrivilegeById(Integer.parseInt(pid[i]));
			privileges.add(p);
		}
		role.setTPubRoleprivileges(privileges);
		manageService.saveOrUpdateRole(role);
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
	public Role getModel() {
		return role;
	}

}
