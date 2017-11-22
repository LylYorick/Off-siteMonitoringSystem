/**
 * 
 */
package org.work.web.service.manage.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.work.web.dao.manage.IPrivilegeDao;
import org.work.web.dao.manage.IRoleDao;
import org.work.web.dao.manage.IUserDao;
import org.work.web.po.BankUser;
import org.work.web.po.Privilege;
import org.work.web.po.Role;
import org.work.web.service.manage.IManageService;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class ManageServiceImpl implements IManageService{
	private static final Logger logger = Logger.getLogger(ManageServiceImpl.class);

	private IUserDao userDao;
	private IRoleDao roleDao;
	private IPrivilegeDao privilegeDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setPrivilegeDao(IPrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	public BankUser findById(String userid) {
		logger.info("findById(String userid)开始执行，userid="+userid);
		BankUser user = (BankUser)userDao.findById(userid);
		return user;
	}

	public List findBy(Map<String, String> params) {
		logger.info("findBy(Map params)开始执行了，params="+params);
		return userDao.findBy(params);
	}

	public PaginaterList getUserInformation(Map<String, Object> params, Integer page) {
		logger.info("getUserInformation(Map params)开始执行了，params="+params);
		return userDao.findByCondition(params, page);
	}

	public PaginaterList getAllRole(Map<String, Object> params, Integer page) {
		logger.info("getAllRole(Map<String, Object> params, Integer page)开始执行了");
		return roleDao.findByCondition(params, page);
	}

	public void saveOrUpdateRole(Role role) {
		logger.info("saveRole(Role role)开始执行了");
		roleDao.saveOrUpdate(role);
	}

	public Role findRoleById(String rid) {
		logger.info("findRoleById(String rid)开始执行了");
		return (Role) roleDao.findById(rid);
	}

	public List<Privilege> listPrivilege() {
		logger.info("listPrivilege()开始执行了");
		return privilegeDao.findAll();
	}
	public Privilege findPrivilegeById(int parseInt) {
		logger.info("findPrivilegeById(int parseInt)开始执行");
		return (Privilege)privilegeDao.findById(parseInt);
	}

	public void saveUser(BankUser bankUser) {
		logger.info("saveUser(BankUser bankUser)开始执行了");
		userDao.save(bankUser);
	}
	public void updateUser(BankUser bankUser) {
		logger.info("updateUser(BankUser bankUser)开始执行了");
		userDao.update(bankUser);
	}
	
}
