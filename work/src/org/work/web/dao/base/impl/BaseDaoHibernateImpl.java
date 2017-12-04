package org.work.web.dao.base.impl;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.util.ArrayHelper;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.work.web.dao.base.IBaseDao;
import org.work.web.util.Paginater;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;



/**
 * @author fred.du
 *
 */
public abstract class BaseDaoHibernateImpl extends HibernateDaoSupport implements IBaseDao {
	private static final int PAGE_SIZE = 20;
	@SuppressWarnings("unchecked")
	abstract public Class getModelClass();
	
	
	public List findAll() {
		return this.getHibernateTemplate().loadAll(getModelClass());
	}


	public void deleteById(Serializable id) {
		this.getHibernateTemplate().delete(this.findById(id));
	}


	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}


	public void saveOrUpdate(Object entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}


	public Serializable save(Object entity) {
		return this.getHibernateTemplate().save(entity);
	}


	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}


	@Override
	public void merge(Object entity) {
		this.getHibernateTemplate().merge(entity);
	}


	public Object findById(Serializable id) {
		return findById(getModelClass(), id);
	}
	
	public Object findById(Class model, Serializable id) {
		if (id == null) {
			return null;
		}
		
		return this.getHibernateTemplate().get(model, id);
	}
	
	/**
	 * description: 查询.
	 * 
	 * @param hql
	 * @param params
	 * @param paramTypes
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected List getList(final StringBuffer hql, final List params, final List paramTypes) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery(hql.toString())
						.setParameters(params.toArray(), ArrayHelper.toTypeArray(paramTypes))
						.list();
			}
		});
	}
	
	protected Long execute(final String hql) {
		return (Long) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				int num = session.createQuery(hql).executeUpdate();
				return Long.parseLong(String.valueOf(num));
			}
		});
       }
	
	
	/**
	 * description: 查询.
	 * 
	 * @param hql
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected List getList(final String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	
	protected List getList(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	protected List getList(DetachedCriteria criteria, int firstResult, int maxResult) {
		return this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResult);
	}
	
	/**
	 * description: 查询.
	 * 
	 * @param helper
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected List getList(final QueryHelper helper) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return helper.list(session);
			}
		});
	}
	
	/**
	 * 加锁查询.
	 * 
	 * @param helper
	 * @param alias
	 * @param upgrade
	 * @return
	 */
	protected List getList(final QueryHelper helper, final String alias, final LockMode lockMode) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return helper.list(session, alias, lockMode);
			}
		});
	}

	/**
	 * description: 查询.
	 * 
	 * @param hql
	 * @param params
	 * @param paramTypes
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected Object getUniqueResult(final StringBuffer hql, final List params, final List paramTypes) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery(hql.toString())
						.setParameters(params.toArray(), ArrayHelper.toTypeArray(paramTypes))
						.setMaxResults(1)
						.uniqueResult();
			}
		});
	}
	
	/**
	 * description: 查询.
	 * 
	 * @param hql
	 * @param params
	 * @param paramTypes
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected Object getUniqueResult(final QueryHelper helper) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return helper.getUniqueResult(session);
			}
		});
	}
	
	/**
	 * description: 查询.
	 * 
	 * @param hql
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-12-03
	 */
	protected Object getUniqueResult(final String hql) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery(hql).setMaxResults(1).uniqueResult();
			}
		});
	}
	
	protected Object getUniqueResult(DetachedCriteria criteria) {
		List list = this.getHibernateTemplate().findByCriteria(criteria, 0, 1);
		
		return list.size() > 0 ? list.get(0) : null;
	}
	
	/**
	 * 获取一页数据.
	 * 
	 * @param helper
	 * @param page
	 * @return
	 */
	protected Paginater getPageData(QueryHelper helper, int page) {
		return getPageData(helper, String.valueOf(page));
	}
	/**
	 * 获取一页数据.
	 * 
	 * @param helper
	 * @param page
	 * @return
	 */
	protected PaginaterList getPaginaterList(QueryHelper helper, int page) {
		PaginaterList list = new PaginaterList();
		list.setPaginater(getPageData(helper, String.valueOf(page)));
		 
		return list;
	}
	/**
	 * 获取一页数据.
	 * 
	 * @param helper
	 * @param page
	 * @return
	 */
	protected Paginater getPageData(final QueryHelper helper, final String page) {
		return (Paginater) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Paginater paginater = new Paginater(helper.getRecordCount(), page, PAGE_SIZE);
				
				List list = helper.getQuery(session)
						.setMaxResults(paginater.getPageSize())
						.setFirstResult((int) paginater.getOffsetIndex())
						.list();
				paginater.setData(list);

				return paginater;
			}
		});
	}
	/**
	 * 获取一页数据.left join
	 * 
	 * @param helper
	 * @param page
	 * @return
	 */
	protected PaginaterList getPaginaterListJoin(QueryHelper helper, int page) {
		PaginaterList list = new PaginaterList();
		list.setPaginater(getPageDataJoin(helper, String.valueOf(page)));
		
		return list;
	}
	/**
	 * 获取一页数据.left join
	 * 
	 * @param helper
	 * @param page
	 * @return
	 */
	protected Paginater getPageDataJoin(final QueryHelper helper, final String page) {
		return (Paginater) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Paginater paginater = new Paginater(helper.getRecordCountByLeftJoin(), page, PAGE_SIZE);
				
				List list = helper.getQuery(session)
						.setMaxResults(paginater.getPageSize())
						.setFirstResult((int) paginater.getOffsetIndex())
						.list();
				paginater.setData(list);

				return paginater;
			}
		});
	}
	
	 public List executeSql(Session session,String sql){
		List list =  session.createSQLQuery(sql).list();
		return list;
	 }
}
