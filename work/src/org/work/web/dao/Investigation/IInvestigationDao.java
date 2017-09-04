package org.work.web.dao.Investigation;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IInvestigationDao extends IBaseDao{

	int getCheckMaxId();

	PaginaterList getCheckRosterInfo(Map<String, Object> params, Integer page);

}
