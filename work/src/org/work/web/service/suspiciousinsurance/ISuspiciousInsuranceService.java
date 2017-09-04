/**
 * 
 */
package org.work.web.service.suspiciousinsurance;

import java.io.File;
import java.util.Map;

import org.work.web.po.Insurancebase;
import org.work.web.po.Insurancedetail;
import org.work.web.util.PaginaterList;

public interface ISuspiciousInsuranceService {

	void saveInsuranceData(Insurancebase stockbase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,String username);

	PaginaterList getInsuranceBaseInfo(Map<String, Object> params, Integer page);

	Insurancebase findById(Integer id);

	String buildXlsInsurance(String buname, String path, Map<String, Object> params);

	PaginaterList getInsuranceBaseDetailInfoById(Map<String, Object> params,Integer page);

	void addInsuranceDetail(Insurancedetail basedetail);

	Insurancedetail findDetailByDid(Long did);

	void updateInsuranceDetail(Insurancedetail basedetail);

	void deleteInsurancedetailById(Long did);
	
}
