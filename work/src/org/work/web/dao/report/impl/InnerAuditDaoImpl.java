/**
 * 
 */
package org.work.web.dao.report.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IInnerAuditDao;
import org.work.web.po.Inneraudit;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class InnerAuditDaoImpl extends BaseDaoHibernateImpl implements IInnerAuditDao {

	@Override
	public Class getModelClass() {
		return Inneraudit.class;
	}
	
	public PaginaterList getInnerAudit(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Inneraudit");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and reportswitch.switchid=?",params.get("switchid"));
		}
		return getPaginaterList(helper, page);
	}
}
