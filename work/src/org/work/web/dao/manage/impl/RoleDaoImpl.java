package org.work.web.dao.manage.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.IRoleDao;
import org.work.web.po.Role;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;


public class RoleDaoImpl extends BaseDaoHibernateImpl implements IRoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Class getModelClass() {
		return Role.class;
	}

	@SuppressWarnings("unchecked")
	public PaginaterList findByCondition(Map params, int pageNumber) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Role r");
		if (null==params) {
			helper.append(" where 1 = 1");
		}
		return getPaginaterList(helper, pageNumber);
	}


}
