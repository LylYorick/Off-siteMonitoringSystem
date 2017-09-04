/**
 * 
 */
package org.work.web.dao.suspiciousstock;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Stockbase;
import org.work.web.util.PaginaterList;

public interface IStockbaseDao extends IBaseDao{
	
	int getBaseMaxIndex(String lineid,String oid);

	PaginaterList getStockBaseInfo(Map<String, Object> params, Integer page);

	List<Stockbase> getStockBaseInfoAll(Map<String, Object> params);

}
