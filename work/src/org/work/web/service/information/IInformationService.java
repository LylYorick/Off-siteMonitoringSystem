package org.work.web.service.information;

import java.io.File;
import java.util.Map;

import org.work.web.po.Inquiryarchives;
import org.work.web.util.PaginaterList;

public interface IInformationService {

	/**
	 * a
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getInquiryArchivesInfo(Map<String, Object> params,Integer page);

	void saveSurvey(Inquiryarchives inquiryarchives, File surveyFile,String surveyFileFileName);


	//void saveActiveSource(ActiveSource activesource, File activeculeFile,String activeculeFileFileName);

	//PaginaterList getActiveSourceInfo(Map<String, Object> params, Integer page);

	//void saveReportSource(ReportSource reportsource, File reportculeFile,String reportculeFileFileName);

	//PaginaterList getReportSourceInfo(Map<String, Object> params, Integer page);

	void updateSurvey(Inquiryarchives inquiryarchives);

	Inquiryarchives findByIaid(Integer iaid);

	void deletesurvey(Integer parseInt);

}
