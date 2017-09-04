package org.work.web.dao.manage;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;


public interface IPrivilegeDao extends IBaseDao {
	/**
	 * 查询.
	 * @param params 可空
	 * @param pageNumber 页码
	 * 
	 * @return (PaginaterList)
	 */
	@SuppressWarnings("unchecked")
	public List findByCondition(Map params, int pageNumber);
	
	public List findByCon(final String hql);
}
