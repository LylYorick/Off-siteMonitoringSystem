package org.work.web.dao.manage;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;


public interface IRoleDao extends IBaseDao {
	/**
	 * 查询.
	 * @param params 可空
	 * @param pageNumber 页码
	 * 
	 * @return (PaginaterList)
	 */
	@SuppressWarnings("unchecked")
	public PaginaterList findByCondition(Map params, int pageNumber);
}
