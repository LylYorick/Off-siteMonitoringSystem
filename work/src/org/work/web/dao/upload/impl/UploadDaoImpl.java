/**
 * 
 */
package org.work.web.dao.upload.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.upload.IUploadDao;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class UploadDaoImpl extends BaseDaoHibernateImpl implements IUploadDao {

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
			helper.append(" and BOrgInformation.BOrgCatalog.bid = ?",params.get("bid"));
			helper.append(" and updatetime>=?",params.get("starttime"));
			helper.append(" and updatetime<=?",params.get("endtime"));		
			helper.append(" and filename like ?",(String)params.get("filename"),MatchMode.ANYWHERE);			
		}
		helper.append(" order by updatetime desc");
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
