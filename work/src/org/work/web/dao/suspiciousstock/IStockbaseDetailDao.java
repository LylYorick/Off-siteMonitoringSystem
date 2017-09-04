/**
 * 
 */
package org.work.web.dao.suspiciousstock;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;
import org.work.web.po.Stockdetail;

public interface IStockbaseDetailDao extends IBaseDao{
	
	Object batchSaveStockBaseDetail(List<Stockdetail> basedetails);

	PaginaterList getStockBaseDetailInfoById(Map<String, Object> params,Integer page);
}
