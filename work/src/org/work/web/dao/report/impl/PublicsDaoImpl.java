/**
 * 
 */
package org.work.web.dao.report.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IPublicsDao;
import org.work.web.po.Publics;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class PublicsDaoImpl extends BaseDaoHibernateImpl implements IPublicsDao {

	@Override
	public Class getModelClass() {
		return Publics.class;
	}
	
	public Publics getPublicsBySwitchId(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Publics");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Publics) this.getUniqueResult(helper);
	}

	public PaginaterList getPublics(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Publics");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and reportswitch.switchid=?",params.get("switchid"));
		}
		return getPaginaterList(helper, page);
	}
	
}
