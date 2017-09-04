/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.ISusreportDao;
import org.work.web.po.Susreport;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class SusReportDaoImpl extends BaseDaoHibernateImpl implements ISusreportDao {

	@Override
	public Class getModelClass() {
		return Susreport.class;
	}
	
	public Susreport getSusreportBySwitchId(Integer switchid) {
		QueryHelper helper = new QueryHelper(this.getSession());
		helper.append("from Susreport");
		if(switchid != null){
			helper.append(" where reportswitch.switchid = ?",switchid);
		}
		return (Susreport) this.getUniqueResult(helper);
	}
	
}
