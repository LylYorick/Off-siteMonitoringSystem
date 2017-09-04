/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.ISusreportFlagDao;
import org.work.web.po.Susreportflag;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class SusReportFlagDaoImpl extends BaseDaoHibernateImpl implements ISusreportFlagDao {

	@Override
	public Class getModelClass() {
		return Susreportflag.class;
	}
	
	public Susreportflag getSusreportFlagBySwitchId(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Susreportflag");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Susreportflag) this.getUniqueResult(helper);
	}
	
}
