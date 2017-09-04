/**
 * 
 */
package org.work.web.service.manage;

import java.util.List;
import java.util.Map;

import org.work.web.po.BankUser;
import org.work.web.po.Privilege;
import org.work.web.po.Role;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IManageService {

	public BankUser findById(String userid);
	/**
	 * 登录时判断用户存在,暂时不改了
	 * @param params
	 * @return
	 */
	public List findBy(Map<String, String> params);

	/**
	 * 查询系统用户信息
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getUserInformation(Map<String, Object> params, Integer page);
	/**
	 * @return 获取系统的所有角色
	 */
	public PaginaterList getAllRole(Map<String, Object> params, Integer page);
	/**
	 * @param role
	 * 保存角色
	 */
	public void saveOrUpdateRole(Role role);
	/**
	 * @param rid根据角色ID查询角色
	 * @return
	 */
	public Role findRoleById(String rid);
	/**
	 * @return查找所有权限数据
	 */
	public List<Privilege> listPrivilege();
	/**
	 * 根据权限ID查询权限
	 * @param parseInt
	 * @return
	 */
	public Privilege findPrivilegeById(int parseInt);
	/**
	 * @param bankUser
	 * 新增用户
	 */
	public void saveUser(BankUser bankUser);
	/**
	 * @param bankUser
	 * 更新用户
	 */
	public void updateUser(BankUser bankUser);
}
