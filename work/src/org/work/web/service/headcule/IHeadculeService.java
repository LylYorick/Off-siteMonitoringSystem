package org.work.web.service.headcule;

import java.io.File;
import java.util.Map;

import org.work.web.po.Headofficesource;
import org.work.web.util.PaginaterList;

public interface IHeadculeService {

	
	void saveHeadSource(Headofficesource headofficesource, File headculeFile, String headculeFileFileName);

	PaginaterList getHeadSourceInfo(Map<String, Object> params, Integer page);

	Headofficesource findById(Integer hosid);

	void update(Headofficesource headofficesource);

	void deleteByRsid(Integer hosid);

}
