/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IIdentitySbDao;
import org.work.web.po.Indentitysb;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class IdentitySbDaoImpl extends BaseDaoHibernateImpl implements IIdentitySbDao {

	@Override
	public Class getModelClass() {
		return Indentitysb.class;
	}
	
	public Indentitysb getIndentitysbBySwitchid(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Indentitysb");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Indentitysb) this.getUniqueResult(helper);
	}
	
}
