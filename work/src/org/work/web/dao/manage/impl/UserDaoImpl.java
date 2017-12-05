package org.work.web.dao.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.MatchMode;
import org.work.web.constants.Constants;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.manage.IUserDao;
import org.work.web.po.BankUser;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;


public class UserDaoImpl extends BaseDaoHibernateImpl implements IUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public Class getModelClass() {
		return BankUser.class;
	}

	@SuppressWarnings("unchecked")
	public List findBy(Map params) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from BankUser u");
		
		if (null==params) {
			helper.append(" where 1 = 1");
		}
		else {
			helper.append(" where 1 = 1");
			helper.append(" and buname=?",params.get("username"));
			helper.append(" and bupswd=?",params.get("password"));
		}
		
		return getList(helper);
	}
	@SuppressWarnings("unchecked")
	public PaginaterList findByCondition(Map params, int pageNumber) {
		QueryHelper helper = new QueryHelper(getSession());
		helper.append("from BankUser u");
		
		if (null==params) {
			helper.append(" where 1 = 1");
		}
		else {
			helper.append("where 1 = 1");
			helper.append(" and brname like ?",(String)params.get("brname"),MatchMode.ANYWHERE);
			helper.append(" and buid=?",params.get("buid"));
			helper.append(" and bumark like ?",(String)params.get("bumark"),MatchMode.ANYWHERE);
			helper.append(" and archives.oid=?",params.get("oid"));
			System.out.println(params.get("bfirstid"));
		if(params.get("bfirstid")!=null && params.get("bfirstid").equals(0)){
			
			}else{
				helper.append(" and archives.id.bfirstid=?",params.get("bfirstid"));
			}
		}
		
		return getPaginaterList(helper, pageNumber);
	}
	@Override
	public Serializable save(Object entity) {
		BankUser user = (BankUser) entity;
		user.setBuid(getNextUserCode());
		user.setBupswd(Constants.DEFAULT_PASSWORD);
		return super.save(entity);
	}
	
	private synchronized String getNextUserCode() {
		String prefix = Constants.USER_ID_PREFIX;
		String maxCode = getMaxCodeWithPrefix(prefix);
		
		if (maxCode == null) {
			return prefix + Constants.START_USER_ID;
		}
		
		long maxSn = Long.parseLong(maxCode.substring(prefix.length()), 10);
		maxSn += 1;
		
		return prefix + StringUtils.leftPad(String.valueOf(maxSn), 5, '0');
	}
	
	private String getMaxCodeWithPrefix(String prefix) {
		return (String) this.getUniqueResult("select max(buid) from BankUser where buid like '" + prefix + "%'");
	}
}
