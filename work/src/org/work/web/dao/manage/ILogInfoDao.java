/**
 * 
 */
package org.work.web.dao.manage;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;


/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface ILogInfoDao  extends IBaseDao{

	/**
	 * @param params
	 * @param page 根据查询条件显示日志信息
	 * @return
	 */
	PaginaterList findByCondition(Map<String, Object> params, Integer page);

}
