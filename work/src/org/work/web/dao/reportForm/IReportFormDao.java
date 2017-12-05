package org.work.web.dao.reportForm;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IReportFormDao  extends IBaseDao{
	
	PaginaterList getReportFormInfo(Map<String, Object> params, Integer page);
}
