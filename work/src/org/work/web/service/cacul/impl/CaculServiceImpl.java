/**
 * 
 */
package org.work.web.service.cacul.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.extend.IExtendDao;
import org.work.web.service.cacul.ICaculService;
import org.work.web.util.PaginaterList;

/**
 * @作者 ThinkPad
 * @创建日期 Oct 11, 2010
 * @版本 work V1.0
 */
public class CaculServiceImpl implements ICaculService{

	private IExtendDao extendDao;
	
	public void setExtendDao(IExtendDao extendDao) {
		this.extendDao = extendDao;
	}

	public List getReportstatus(Map<String, Object> params) {
		return extendDao.getReportStatus(params);
	}
	public PaginaterList getReportImport(Map<String, Object> params,int page) {
		return extendDao.getReportImport(params,page);
	}
	public PaginaterList getReportSusreport(Map<String, Object> params,int page) {
		return extendDao.getReportSuspicous(params,page);
	}

	public PaginaterList getReportImportB(Map<String, Object> params,
			Integer page) {
		return extendDao.getReportImportB(params,page);
	}

}
