package org.work.web.service.investigation;

import java.io.File;
import java.util.Map;

import org.work.web.po.CheckRoster;
import org.work.web.util.PaginaterList;

public interface IInvestigationService {

	void saveCheckRoster(CheckRoster checkroster, File checkFile,String checkFileFileName);

	PaginaterList getCheckRosterInfo(Map<String, Object> params, Integer page);

	CheckRoster findByCrid(Integer crid);

	void updateInvestigation(CheckRoster checkroster);

	void deleteByCrid(Integer crid);

}
