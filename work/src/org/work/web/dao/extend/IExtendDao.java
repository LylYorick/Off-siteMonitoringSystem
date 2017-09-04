/**
 * 
 */
package org.work.web.dao.extend;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IExtendDao extends IBaseDao{

	List getReportStatus(Map<String, Object> params);

	PaginaterList getReportImport(Map<String, Object> params,int page);

	/**
	 * 可疑交易报告报表
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getReportSuspicous(Map<String, Object> params,int page);

	PaginaterList getReportImportB(Map<String, Object> params, Integer page);
	
}
