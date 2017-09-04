/**
 * 
 */
package org.work.web.dao.information.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.information.IInformationDao;
import org.work.web.dao.information.IInformationTaiDao;
import org.work.web.po.Information;
import org.work.web.po.Tai;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class InformationTaiDaoImpl extends BaseDaoHibernateImpl implements IInformationTaiDao {

	@Override
	public Class getModelClass() {
		return Tai.class;
	}

	public PaginaterList getInformationTai(Map<String, Object> params,
			Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Tai" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append("and BOrgInformation.oid = ?",params.get("oid"));
			queryHelper.append("order by taidate desc");
		}
		return getPaginaterList(queryHelper, page);
	}


}
