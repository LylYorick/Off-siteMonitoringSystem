package org.work.web.dao.activecule;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IActiveculeDao extends IBaseDao{

	int getActiveMaxId();

	PaginaterList getActiveSourceInfo(Map<String, Object> params, Integer page);


}
