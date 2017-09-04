/**
 * 
 */
package org.work.web.dao.suspiciousinsurance;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;
import org.work.web.po.Insurancedetail;

public interface IInsurancebaseDetailDao extends IBaseDao{
	
	Object batchSaveInsuranceBaseDetail(List<Insurancedetail> basedetails);

	PaginaterList getInsuranceBaseDetailInfoById(Map<String, Object> params,Integer page);
}
