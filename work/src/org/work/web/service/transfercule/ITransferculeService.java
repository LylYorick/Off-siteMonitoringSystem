package org.work.web.service.transfercule;

import java.io.File;
import java.util.Map;

import org.work.web.po.Transfersource;
import org.work.web.util.PaginaterList;

public interface ITransferculeService {

	Transfersource findById(Integer tsid);

	void update(Transfersource transfersource);

	PaginaterList getTransferSourceInfo(Map<String, Object> params, Integer page);

	void saveTransferSource(Transfersource transfersource, File transfersourceFile, String transfersourceFileFileName);

	void deleteById(Integer tsid);

}
