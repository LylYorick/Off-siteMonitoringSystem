/**
 * 
 */
package org.work.web.dao.report;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IReportDao extends IBaseDao{
	public PaginaterList getReport(Map<String, Object> params, Integer page);
	public List getReporAccountGroupBy(Map<String, Object> params);
}
