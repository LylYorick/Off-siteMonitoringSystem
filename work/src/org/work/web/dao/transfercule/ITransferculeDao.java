package org.work.web.dao.transfercule;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface ITransferculeDao extends IBaseDao{

	int getTransferMaxId();

	PaginaterList getTransferSourceInfo(Map<String, Object> params, Integer page);

}
