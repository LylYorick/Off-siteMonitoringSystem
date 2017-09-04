/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IIdentityKyDao;
import org.work.web.po.Identityky;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class IdentityKyDaoImpl extends BaseDaoHibernateImpl implements IIdentityKyDao {

	@Override
	public Class getModelClass() {
		return Identityky.class;
	}
	
	public Identityky getIdentitykyBySwitchid(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Identityky");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Identityky) this.getUniqueResult(helper);
	}
	
}
