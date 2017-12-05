package org.work.web.dao.reportForm.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.reportForm.IReportFormDao;
import org.work.web.po.ReportForm;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class ReportFormDaoImpl extends BaseDaoHibernateImpl implements IReportFormDao {

	@Override
	public PaginaterList getReportFormInfo(Map<String, Object> params,
			Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from ReportForm" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append(" and BOrgInformation.oid = ?",params.get("oid"));
			queryHelper.append(" and BOrgInformation.BOrgCatalog.bid = ?",params.get("bid"));
			queryHelper.append(" and up_time>=?",params.get("starttime"));
			queryHelper.append(" and up_time<=?",params.get("endtime"));	
		}
		/*queryHelper.append(" order by up_time desc");*/
		PaginaterList s =new  PaginaterList();
		try{
		s = getPaginaterList(queryHelper, page);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public Class getModelClass() {
		// TODO Auto-generated method stub
		return ReportForm.class;
	}


}
