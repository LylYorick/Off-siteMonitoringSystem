/**
 * 
 */
package org.work.web.dao.information;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Information;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IInformationDao   extends IBaseDao{

	public PaginaterList getInformationFinancial(Map<String, Object> params, Integer page);
	
	public List<Information> getInformationFinancialAll(Map<String, Object> params);

	/**
	 * @param information
	 * @return
	 */
	public List findByBoid(String information);

}
