/**
 * 
 */
package org.work.web.service.suspicious;

import java.io.File;
import java.util.Map;

import org.work.web.po.Bankbase;
import org.work.web.po.Basedetail;
import org.work.web.util.PaginaterList;

public interface ISuspiciousService {

	void saveBankData(Bankbase bankbase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,String username);

	PaginaterList getBankBaseInfo(Map<String, Object> params, Integer page);

	Bankbase findById(Integer id);

	String buildXlsBank(String buname, String path, Map<String, Object> params);

	PaginaterList getBankBaseDetailInfoById(Map<String, Object> params,Integer page);

	void addBankDetail(Basedetail basedetail);

	Basedetail findDetailByDid(Long did);

	void updateBankDetail(Basedetail basedetail);

	void deleteBasedetailById(Long did);
	
}
