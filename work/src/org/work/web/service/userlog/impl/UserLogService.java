/**
 * 
 */
package org.work.web.service.userlog.impl;

import java.util.Map;

import org.work.web.constants.Constants;
import org.work.web.dao.manage.ILogInfoDao;
import org.work.web.dao.para.IParaDao;
import org.work.web.po.LogInfo;
import org.work.web.service.userlog.IUserLogService;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public class UserLogService implements IUserLogService{

	private ILogInfoDao logInfoDao;
	private IParaDao paraDao;
	
	public void setParaDao(IParaDao paraDao) {
		this.paraDao = paraDao;
	}

	public void setLogInfoDao(ILogInfoDao logInfoDao) {
		this.logInfoDao = logInfoDao;
	}

	public void saveLogInfo(LogInfo logInfo) {
		logInfoDao.save(logInfo);
	}

	public PaginaterList findAllLog(Map<String, Object> params, Integer page) {
		return logInfoDao.findByCondition(params,page);
	}

	public Integer getReportEndDay(int reporttype) {
		return paraDao.getReportEndDay(reporttype);
	}

	public void updateEndDay(int quaterendday,int yearendday) {
		paraDao.updateEndDay(Integer.valueOf(Constants.REPORT_TYPE_YEAR), yearendday);
		paraDao.updateEndDay(Integer.valueOf(Constants.REPORT_TYPE_QUATER), quaterendday);
	}

}
