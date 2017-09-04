/**
 * 
 */
package org.work.web.service.suspiciousstock;

import java.io.File;
import java.util.Map;

import org.work.web.po.Stockbase;
import org.work.web.po.Stockdetail;
import org.work.web.util.PaginaterList;

public interface ISuspiciousStockService {

	void saveStockData(Stockbase stockbase, File suspiciousFile,File suspiciousdataFile, String suspiciousFileFileName,String suspiciousdataFileFileName,String username);

	PaginaterList getStockBaseInfo(Map<String, Object> params, Integer page);

	Stockbase findById(Integer id);

	String buildXlsStock(String buname, String path, Map<String, Object> params);

	PaginaterList getStockBaseDetailInfoById(Map<String, Object> params,Integer page);

	void addStockDetail(Stockdetail basedetail);

	Stockdetail findDetailByDid(Long did);

	void updateStockDetail(Stockdetail basedetail);

	void deleteStockdetailById(Long did);
	
}
