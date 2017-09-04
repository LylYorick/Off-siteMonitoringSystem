package org.work.web.dao.information.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.information.IInformationSurDao;
import org.work.web.po.Inquiryarchives;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class InformationSurDaoImpl extends BaseDaoHibernateImpl implements IInformationSurDao{

	@Override
	public Class getModelClass() {
		// TODO Auto-generated method stub
		return Inquiryarchives.class;
	}

	public PaginaterList getInquiryArchivesInfo(Map<String, Object> params,
			Integer page) {
		// TODO Auto-generated method stub
		System.out.println("========= 查询调查档案信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Inquiryarchives");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and approvalid = ?",params.get("approvalid"));
			helper.append(" and subjectname =?",params.get("subjectname"));
			helper.append(" and letterid =?",params.get("letterid"));
			helper.append(" and date >= ?",params.get("starttime"));
			helper.append(" and date <= ?",params.get("endtime"));			
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}
}
