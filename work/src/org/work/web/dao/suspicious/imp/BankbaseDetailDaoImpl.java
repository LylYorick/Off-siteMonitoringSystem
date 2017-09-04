/**
 * 
 */
package org.work.web.dao.suspicious.imp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.suspicious.IBankbaseDetailDao;
import org.work.web.po.Basedetail;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class BankbaseDetailDaoImpl extends BaseDaoHibernateImpl implements IBankbaseDetailDao {

	@Override
	public Class getModelClass() {
		return Basedetail.class;
	}

	public Object batchSaveBankBaseDetail(final List<Basedetail> basedetails) {

		return this.getHibernateTemplate().execute(new HibernateCallback() {		
			public Object doInHibernate(Session session) throws HibernateException, SQLException {  
				int count = basedetails.size();
				for (int i = 0; i < count; i++) {   
					session.save(basedetails.get(i));          
					if (i % 20 == 0) {   
						session.flush();   
						session.clear();   
					}   
				}                   
				return null;   
			}   
		}); 
	}

	public PaginaterList getBankBaseDetailInfoById(Map<String, Object> params,Integer page) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from Basedetail");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and BBankBase.id = ?",params.get("id"));			
		}
		return getPaginaterList(helper, page);
	}
	
}
