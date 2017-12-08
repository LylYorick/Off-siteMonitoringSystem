/**
 * 
 */
package org.work.web.dao.archives.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.archives.ArchivesDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.Archives;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 liyuelong
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class ArchivesDaoImpl extends BaseDaoHibernateImpl implements ArchivesDao {

	@Override
	public Class getModelClass() {
		return Archives.class;
	}

	/**
	 * 查询金融机构信息
	 */
	public PaginaterList getArchivesFinancial(Map<String, Object> params, Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Archives" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append("and oid = ?",params.get("oid"));
			queryHelper.append("and BOrgCatalog.bid = ?",params.get("bid"));
		}
		queryHelper.append(" order by bname asc");
		return getPaginaterList(queryHelper, page);
		
	}
	
	/**
	 * 查询金融机构信息,不分页
	 */
	public List<Archives> getArchivesFinancialAll(Map<String, Object> params) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Archives" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append("and oid = ?",params.get("oid"));
			queryHelper.append("and BOrgCatalog.bid = ?",params.get("bid"));
		}
		queryHelper.append(" order by bname asc");
		return getList(queryHelper);
		
	}


	@Override
	public PaginaterList getArchivesinformation(Map<String, Object> params,
			Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Archives" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append("and oid = ?",params.get("oid"));
			queryHelper.append("and catalogNew.id.bfirstid = ?",params.get("bfirstid"));
		}
		queryHelper.append(" order by bname asc");
		return getPaginaterList(queryHelper, page);
	}

	@Override
	public List findArchivesByBfirstid(String bfirstid) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Archives" );
		queryHelper.append("where catalogNew.id.bfirstid = ?",bfirstid);
		return getList(queryHelper);
	}



}
