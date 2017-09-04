package org.work.web.dao.manage.impl;

import java.util.List;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.ICatalogDao;
import org.work.web.po.Catalog;
import org.work.web.util.QueryHelper;

public class CatalogDaoImpl extends BaseDaoHibernateImpl implements ICatalogDao {

	@Override
	public Class getModelClass() {
		return Catalog.class;
	}

	public List<Catalog> findAllSort() {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Catalog order by bid");
		return getList(helper);
	}


}
