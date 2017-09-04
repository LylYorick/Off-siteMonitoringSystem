/**
 * 
 */
package org.work.web.dao.information.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.information.IInformationHisDao;
import org.work.web.po.Informationhis;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class InformationHisDaoImpl extends BaseDaoHibernateImpl implements IInformationHisDao {

	@Override
	public Class getModelClass() {
		return Informationhis.class;
	}
	

	/**
	 * 查看金融机构的变更历史
	 */
	public PaginaterList getHistoryFinancial(Map<String, Object> params,Integer page) {
		QueryHelper queryHelper = new QueryHelper(getSession());
		queryHelper.append("from Informationhis " );
		if (params != null) {
			queryHelper.append("where 1 = 1");			
			queryHelper.append("and BOrgInformation.oid = ?",params.get("oid"));
		}
		queryHelper.append(" order by ooid desc");
		return getPaginaterList(queryHelper, page);
	}

}
