/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IIdentityRsbDao;
import org.work.web.po.Identityrsb;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class IdentityRsbDaoImpl extends BaseDaoHibernateImpl implements IIdentityRsbDao {

	@Override
	public Class getModelClass() {
		return Identityrsb.class;
	}
	
	public Identityrsb getIndentityrsbBySwitchid(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Identityrsb");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Identityrsb) this.getUniqueResult(helper);
	}
	
}
