package org.work.web.dao.institution.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.institution.IInstitutionDao;
import org.work.web.po.Institution;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class InstitutionDaoImpl extends BaseDaoHibernateImpl implements IInstitutionDao {

	@Override
	public PaginaterList getInstitutionInfo(Map<String, Object> params,
			Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Institution" );
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
		return Institution.class;
	}


}
