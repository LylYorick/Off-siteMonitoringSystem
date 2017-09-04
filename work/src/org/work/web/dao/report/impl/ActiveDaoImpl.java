/**
 * 
 */
package org.work.web.dao.report.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IActiveDao;
import org.work.web.po.Active;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class ActiveDaoImpl extends BaseDaoHibernateImpl implements IActiveDao {

	@Override
	public Class getModelClass() {
		return Active.class;
	}
	
	public PaginaterList getActive(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Active");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and reportswitch.switchid=?",params.get("switchid"));
		}
		return getPaginaterList(helper, page);
	}
}
