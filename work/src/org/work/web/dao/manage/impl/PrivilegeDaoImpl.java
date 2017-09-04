package org.work.web.dao.manage.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.IPrivilegeDao;
import org.work.web.po.Privilege;
import org.work.web.util.QueryHelper;


public class PrivilegeDaoImpl extends BaseDaoHibernateImpl implements IPrivilegeDao {

	@SuppressWarnings("unchecked")
	@Override
	public Class getModelClass() {
		return Privilege.class;
	}

	@SuppressWarnings("unchecked")
	public List findByCondition(Map params, int pageNumber) {
		QueryHelper helper = new QueryHelper();
		helper.append("from Privilege p");
		if (null==params) {
			helper.append(" where 1 = 1");
		}
		else{
			if(params.get("parentId").toString().equals("-1")){
				helper.append(" where p.parent is null");
			}else{
				helper.append("where p.parent.pid="+params.get("parentId").toString());
			}
			
		}
		return getPaginaterList(helper, pageNumber);
	}

	@SuppressWarnings("unchecked")
	public List findByCon(String hql) {
		return this.getList(hql);
	}

}
