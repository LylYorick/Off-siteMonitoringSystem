package org.work.web.dao.reportcule;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IReportculeDao extends IBaseDao{

	int getReportMaxId();

	PaginaterList getReportSourceInfo(Map<String, Object> params, Integer page);

}
