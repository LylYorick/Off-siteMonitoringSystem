package org.work.web.service.archives;

import java.util.List;
import java.util.Map;

import org.work.web.po.Archives;
import org.work.web.po.Catalog;
import org.work.web.util.PaginaterList;

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
	/**
	 * 查看金融机构的变更历史
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getHistoryFinancial(Map<String, Object> params, Integer page);

}
