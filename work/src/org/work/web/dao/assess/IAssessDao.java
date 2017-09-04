/**
 * 
 */
package org.work.web.dao.assess;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Assess;
import org.work.web.po.AssessIndex;
import org.work.web.po.Information;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IAssessDao extends IBaseDao{
	
	public PaginaterList getInformationAssess(Map<String, Object> params,Integer page);

	/**
	 * @param year
	 * @param orgInformation
	 * @return
	 */
	public void deleteById(String year, Information orgInformation,AssessIndex assessIndex);
	
	public List getSelfEvalueScore(Map<String, Object> params);/**added by liuxz at 2017-03-01*/
	
}
