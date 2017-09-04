/**
 * 
 */
package org.work.web.dao.suspiciousinsurance;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Insurancebase;
import org.work.web.util.PaginaterList;

public interface IInsurancebaseDao extends IBaseDao{
	
	int getBaseMaxIndex(String lineid,String oid);

	PaginaterList getInsuranceBaseInfo(Map<String, Object> params, Integer page);

	List<Insurancebase> getInsuranceBaseInfoAll(Map<String, Object> params);

}
