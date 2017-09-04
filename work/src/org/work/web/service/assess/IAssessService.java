/**
 * 
 */
package org.work.web.service.assess;

import java.util.List;
import java.util.Map;

import org.work.web.po.Assess;
import org.work.web.po.AssessIndex;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IAssessService {

	public PaginaterList getAssessIndex(Map<String, Object> params,Integer page);
	
	public List<AssessIndex> getAssessIndex();
	
	public List getAssessIndex(Map<String, Object> params);
	
	public void saveAssessIndex(AssessIndex assessIndex);
	
	public AssessIndex getAssessIndexByID(Integer acsid);

	public List getAssessIndexByPID(Integer pid);
	
	public PaginaterList getInformationAssess(Map<String, Object> params,Integer page);

	public void saveAssess(Assess result);

	public List getAssessView(Map<String, Object> params);
	
	public List getAssessIndex2(Map<String, Object> params);/**added by liuxz at 2017-02-24*/
	
	public List<AssessIndex> getAssessIndex2();/**added by liuxz at 2017-02-28*/
	
	public List getSelfEvalueScore(Map<String, Object> params);/**added by liuxz at 2017-03-01*/
	
	public List getAssessIndexByPID2(Integer pid,String ascfield);/**added by liuxz at 2017-03-01*/
}
