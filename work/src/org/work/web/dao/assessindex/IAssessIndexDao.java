/**
 * 
 */
package org.work.web.dao.assessindex;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IAssessIndexDao extends IBaseDao{

	public PaginaterList getAllAssessIndex(Map<String, Object> params, Integer page);
	
	public List getAllAssessIndex();
	
	public List getAllAssessIndex(Map<String, Object> params);
	
	public List findByPid(Integer pid);

	public List getAllAssessIndexInAssess(Map<String, Object> params);
	
	public List getAllAssessIndex2(Map<String, Object> params);/**added by liuxz at 2017-02-24*/
	
	public List getAllAssessIndex2();/**added by liuxz at 2017-02-24*/
	
	public List findByPid2(Integer pid,String ascfield);/**added by liuxz at 2017-03-01*/
}
