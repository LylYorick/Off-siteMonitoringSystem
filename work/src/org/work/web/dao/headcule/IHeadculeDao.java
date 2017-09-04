package org.work.web.dao.headcule;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IHeadculeDao extends IBaseDao{

	PaginaterList getHeadSourceInfo(Map<String, Object> params, Integer page);

	int getHeadMaxId();

}
