/**
 * 
 */
package org.work.web.dao.suspicious.imp;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.suspicious.ISuspiciousDao;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class SuspiciousDaoImpl extends BaseDaoHibernateImpl implements ISuspiciousDao {

	@Override
	public Class getModelClass() {
		return Upload.class;
	}
	
	public PaginaterList findByOId(Map<String, Object> params,Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Upload");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and filename = ?",params.get("filename"));
			helper.append(" and BOrgInformation.oid = ?",params.get("oid"));
		}
		return getPaginaterList(helper, page);
	}

	public PaginaterList findAllUpload(Map<String, Object> params, Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Upload");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and BOrgInformation.oid = ?",params.get("oid"));
			helper.append(" and ( updatetime between ?",params.get("starttime"));
			helper.append(" and ? )",params.get("endtime"));			
			helper.append(" and filename like ?",(String)params.get("filename"),MatchMode.ANYWHERE);			
		}
		return getPaginaterList(helper, page);
	}
	
	public List<Upload> getAllUpload(Map<String, Object> params) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Upload");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and BOrgInformation.oid = ?",params.get("oid"));
			helper.append(" and ( updatetime between ?",params.get("starttime"));
			helper.append(" and ? )",params.get("endtime"));			
			helper.append(" and filename like ?",(String)params.get("filename"),MatchMode.ANYWHERE);			
		}
		return getList(helper);
	}

}
