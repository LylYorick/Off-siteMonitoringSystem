/**
 * 
 */
package org.work.web.service.assess.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.assess.IAssessDao;
import org.work.web.dao.assessindex.IAssessIndexDao;
import org.work.web.po.Assess;
import org.work.web.po.AssessIndex;
import org.work.web.service.assess.IAssessService;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class AssessServiceImpl implements IAssessService{
	private IAssessDao assessDao;

	private IAssessIndexDao assessIndexDao;

	public void setAssessDao(IAssessDao assessDao) {
		this.assessDao = assessDao;
	}

	public void setAssessIndexDao(IAssessIndexDao assessIndexDao) {
		this.assessIndexDao = assessIndexDao;
	}
	
	public List<AssessIndex> getAssessIndex() {
		return assessIndexDao.getAllAssessIndex();
	}
	
	public PaginaterList getAssessIndex(Map<String, Object> params,Integer page) {
		return assessIndexDao.getAllAssessIndex(params,page);
	}
	public void saveAssessIndex(AssessIndex assessIndex) {
		assessIndexDao.saveOrUpdate(assessIndex);
	}

	public AssessIndex getAssessIndexByID(Integer acsid) {
		return (AssessIndex) assessIndexDao.findById(acsid);
	}

	public List getAssessIndexByPID(Integer pid) {
		return assessIndexDao.findByPid(pid);
	}
	public PaginaterList getInformationAssess(Map<String, Object> params,Integer page){
		return assessDao.getInformationAssess(params,page);
	}

	public void saveAssess(Assess result) {
		assessDao.deleteById(result.getYear(),result.getBOrgInformation(),result.getAssessindex());
		assessDao.saveOrUpdate(result);
	}

	public List getAssessView(Map<String, Object> params) {
		return assessIndexDao.getAllAssessIndexInAssess(params);
	}

	public List getAssessIndex(Map<String, Object> params) {
		return assessIndexDao.getAllAssessIndex(params);
	}
	
	/**added by liuxz at 2017-02-24*/
	public List getAssessIndex2(Map<String, Object> params) {
		return assessIndexDao.getAllAssessIndex2(params);
	}

	/**added by liuxz at 2017-02-28*/
	public List<AssessIndex> getAssessIndex2() {
		return assessIndexDao.getAllAssessIndex2();
	}

	/**added by liuxz at 2017-03-01*/
	public List getSelfEvalueScore(Map<String, Object> params) {
		
		return assessDao.getSelfEvalueScore(params);
	}
	/**added by liuxz at 2017-03-01*/
	public List getAssessIndexByPID2(Integer pid,String ascfield) {
		return assessIndexDao.findByPid2(pid,ascfield);
	}
}
