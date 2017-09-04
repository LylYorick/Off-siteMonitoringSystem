package org.work.web.dao.judicialcule;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IJudicialculeDao extends IBaseDao{

	PaginaterList getJudicialSourceInfo(Map<String, Object> params, Integer page);

	int getJudiciaMaxId();

}
