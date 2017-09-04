/**
 * 
 */
package org.work.web.dao.manage.impl;

import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.ILogInfoDao;
import org.work.web.po.LogInfo;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class LogInfoDaoImpl extends BaseDaoHibernateImpl implements ILogInfoDao {

	@Override
	public Class getModelClass() {
		return LogInfo.class;
	}

	public PaginaterList findByCondition(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from LogInfo");
		if(params!=null){
			helper.append("where 1=1");
			helper.append(" and operatorname like ?",(String)params.get("operatorname"),MatchMode.ANYWHERE);
		}
		helper.append("order by logid desc");
		return getPaginaterList(helper, page);
	}

}
