package org.work.web.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * Title: BaseDAO
 * Description: 
 * 
 * Copyright: Copyright (c) 2007
 * Company: flink
 * 
 * @author fred.du
 * @version 1.0
 * @since 2007-11-25
 */
public interface IBaseDao{
	/**
	 * description: 保存对象.
	 * 
	 * @param object
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-25
	 */
	public Serializable save(Object entity);
	
	/**
	 * description: 保存对象.
	 * 
	 * @param object
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-25
	 */
	public void saveOrUpdate(Object entity);

	/**
	 * description: 更新对象.
	 * 
	 * @param object
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-26
	 */
	public void update(Object entity);

	/**
	 * description: 删除对象.
	 * 
	 * @param object
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-26
	 */
	public void delete(Object entity);
	
	/**
	 * description: 删除对象.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-26
	 */
	public void deleteById(Serializable id);
	
	/**
	 * description: 查找对象.
	 * 
	 * @param id
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-27
	 */
	public Object findById(Serializable id);
	
	/**
	 * description: 查找对象.
	 * 
	 * @return
	 * 
	 * @author fred.du
	 * @since 2007-11-27
	 */
	public List findAll();
}
