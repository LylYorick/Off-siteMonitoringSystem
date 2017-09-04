package org.work.web.service.judicialcule;

import java.io.File;
import java.util.Map;

import org.work.web.po.Judicialsource;
import org.work.web.util.PaginaterList;

public interface IJudicialculeService {

	PaginaterList getJudicialSourceInfo(Map<String, Object> params, Integer page);

	Judicialsource findByjsid(Integer jsid);

	void update(Judicialsource judicialsource);

	void deleteByRsid(Integer jsid);

	void saveJudicialSource(Judicialsource judicialsource, File judicialculeFile, String judicialculeFileFileName);

}
