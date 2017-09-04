/**
 * 
 */
package org.work.web.dao.information.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.information.IInformationDao;
import org.work.web.po.Information;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class InformationDaoImpl extends BaseDaoHibernateImpl implements IInformationDao {

	@Override
	public Class getModelClass() {
		return Information.class;
	}

	/**
	 * 查询金融机构信息
	 */
	public PaginaterList getInformationFinancial(Map<String, Object> params, Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Information" );
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
	public List<Information> getInformationFinancialAll(Map<String, Object> params) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Information" );
		if (params != null) {
			queryHelper.append("where 1 = 1");
			queryHelper.append("and oid = ?",params.get("oid"));
			queryHelper.append("and BOrgCatalog.bid = ?",params.get("bid"));
		}
		queryHelper.append(" order by bname asc");
		return getList(queryHelper);
		
	}

	public List findByBoid(String information) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Information where boid=?",information );
		return getList(queryHelper);
	}


}
