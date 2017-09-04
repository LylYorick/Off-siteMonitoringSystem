/**
 * 
 */
package org.work.web.dao.report.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IReportDao;
import org.work.web.po.Reportswitch;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class ReportDaoImpl extends BaseDaoHibernateImpl implements IReportDao {

	@Override
	public Class getModelClass() {
		return Reportswitch.class;
	}
	
	public PaginaterList getReport(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Reportswitch");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and report.reportid=?",params.get("reportid"));
			helper.append(" and BOrgInformation.oid=?",params.get("oid"));
			helper.append(" and BOrgInformation.BOrgCatalog.bid =?",params.get("bid"));
			helper.append(" and status=?",params.get("reportstatus"));
			helper.append(" and year=?",params.get("reportyear"));
			helper.append(" and quater in (?)",(Integer[])params.get("reportquater"));
		}
		helper.append(" order by BOrgInformation.oid,report.prtype,report.reportid");
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" , "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}
	public List getReporAccountGroupBy(Map<String, Object> params){
		String sql1 ="select max(rr.a),max(rr.b) from (select case when c.prtype=1 then count(oid) end as a," +
				" case when c.prtype=2 then count(oid) end as b" +
				" from REPORTSWITCH as r,report as c" +
				" where r.reportid=c.reportid and status=1 and isreport is null" +
				" and (r.year="+params.get("year")+" or r.quater="+params.get("quater")+
				") group by c.prtype) as rr";
		return getSession().createSQLQuery(sql1).list();
	}
}
