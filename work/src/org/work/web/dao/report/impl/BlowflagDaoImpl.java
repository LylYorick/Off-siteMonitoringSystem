/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IBlowflagDao;
import org.work.web.po.Blowflag;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class BlowflagDaoImpl extends BaseDaoHibernateImpl implements IBlowflagDao {

	@Override
	public Class getModelClass() {
		return Blowflag.class;
	}
	
	public Blowflag getBlowflagBySwitchId(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Blowflag");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Blowflag) this.getUniqueResult(helper);
	}
	
}
