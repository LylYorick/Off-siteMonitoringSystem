/**
 * 
 */
package org.work.web.dao.suspicious;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Bankbase;
import org.work.web.util.PaginaterList;

public interface IBankbaseDao extends IBaseDao{
	
	int getBaseMaxIndex(String lineid,String oid);

	PaginaterList getBankBaseInfo(Map<String, Object> params, Integer page);

	List<Bankbase> getBankBaseInfoAll(Map<String, Object> params);

}
