package org.work.web.dao.archives.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.work.web.dao.archives.ArchivesDao;
import org.work.web.dao.archives.IArchivesHisDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.Informationhis;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class ArchivesHisDaoImpl extends BaseDaoHibernateImpl  implements IArchivesHisDao {

	@Override
	public PaginaterList getHistoryFinancial(Map<String, Object> params,
			Integer page) {
		// TODO 获取历史信息这里没实现 
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from org.work.web.po.ArchivesHis " );
		if (params != null) {
			queryHelper.append("where 1 = 1 ");			
			queryHelper.append("and archives.oid = ? ",params.get("oid"));
		}
	
		queryHelper.append("order by ooid desc ");
		return getPaginaterList(queryHelper, page);
	}

	@Override
	public Class getModelClass() {
		return ArchivesDao.class;
	}

}
