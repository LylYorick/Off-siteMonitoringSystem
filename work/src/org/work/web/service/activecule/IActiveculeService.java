package org.work.web.service.activecule;

import java.io.File;
import java.util.Map;

import org.work.web.po.ActiveSource;
import org.work.web.util.PaginaterList;

public interface IActiveculeService {

	void saveActiveSource(ActiveSource activesource, File activeculeFile,String activeculeFileFileName);

	PaginaterList getActiveSourceInfo(Map<String, Object> params, Integer page);

	ActiveSource findByAsId(Integer asid);

	void update(ActiveSource activesource);

	void delete(Integer asid);

}
