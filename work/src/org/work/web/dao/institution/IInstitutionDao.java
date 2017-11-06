package org.work.web.dao.institution;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IInstitutionDao  extends IBaseDao{
	
	PaginaterList getInstitutionInfo(Map<String, Object> params, Integer page);
}
