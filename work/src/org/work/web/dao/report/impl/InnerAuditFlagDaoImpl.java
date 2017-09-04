/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IInnerAuditFlagDao;
import org.work.web.po.Innerauditflag;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class InnerAuditFlagDaoImpl extends BaseDaoHibernateImpl implements IInnerAuditFlagDao {

	@Override
	public Class getModelClass() {
		return Innerauditflag.class;
	}
	public Innerauditflag getInnerauditFlagBySwitchId(Integer valueOf) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Innerauditflag");
		if(valueOf != null){
			helper.append(" where reportswitch.switchid = ?",valueOf);
		}
		return (Innerauditflag) this.getUniqueResult(helper);
	}
	
}
