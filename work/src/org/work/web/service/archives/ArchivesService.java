package org.work.web.service.archives;

import java.util.List;

import org.work.web.po.Archives;
import org.work.web.po.Catalog;

public interface ArchivesService {
	/**
	 * 查询所有金融机构类别
	 * @return
	 */
	List<Catalog> findByCatalog();
	Archives findByOid(Integer oid);
	void updateInformation(Archives information, Archives information2);
	List findByBoid(String information);
	void addInformation(Archives information);
}
