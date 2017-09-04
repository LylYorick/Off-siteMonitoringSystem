/**
 * 
 */
package org.work.web.service.userlog;

import java.util.Map;

import org.work.web.po.LogInfo;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public interface IUserLogService {

	public void saveLogInfo(LogInfo logInfo);

	/**
	 * @param params 查询日志
	 * @param page
	 * @return
	 */
	public PaginaterList findAllLog(Map<String, Object> params, Integer page);
	
	Integer getReportEndDay(int reporttype);
	
	void updateEndDay(int quaterendday,int yearendday);
}
