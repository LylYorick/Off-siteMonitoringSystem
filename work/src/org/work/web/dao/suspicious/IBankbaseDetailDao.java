/**
 * 
 */
package org.work.web.dao.suspicious;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;
import org.work.web.po.Basedetail;

public interface IBankbaseDetailDao extends IBaseDao{
	
	Object batchSaveBankBaseDetail(List<Basedetail> basedetails);

	PaginaterList getBankBaseDetailInfoById(Map<String, Object> params,Integer page);
}
