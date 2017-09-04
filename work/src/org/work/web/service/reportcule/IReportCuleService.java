package org.work.web.service.reportcule;

import java.io.File;
import java.util.Map;

import org.work.web.po.ReportSource;
import org.work.web.util.PaginaterList;

public interface IReportCuleService {

	void saveReportSource(ReportSource reportsource, File reportculeFile,String reportculeFileFileName);

	PaginaterList getReportSourceInfo(Map<String, Object> params, Integer page);

	ReportSource findByrsid(Integer rsid);

	void update(ReportSource reportsource);

	void deleteByRsid(Integer rsid);

}
