package org.work.web.dao.information;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

public interface IInformationSurDao extends IBaseDao{

	/**
	 * 
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getInquiryArchivesInfo(Map<String, Object> params,Integer page);

	//int getActiveMaxId();

	//PaginaterList getActiveSourceInfo(Map<String, Object> params, Integer page);

	//PaginaterList getReportSourceInfo(Map<String, Object> params, Integer page);

	//int getResourceMaxId();

}
