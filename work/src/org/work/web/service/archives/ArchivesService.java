package org.work.web.service.archives;

import java.util.List;
import java.util.Map;

import org.work.web.po.Archives;
import org.work.web.po.Catalog;
import org.work.web.po.CatalogNew;
import org.work.web.util.PaginaterList;

public interface ArchivesService {
	/**
	 * 查询所有金融机构一级类别,不包括 未分配 类型
	 * @return
	 */
	List<CatalogNew> findAllFirstCatname();
	
	/**
	 * 通过金融机构的一级类别查询二级类别
	 * @return
	 */
	List<CatalogNew> findSecondCatname(String bfirstid);
	
	/**
	 * 查询二级金融机构三级类别
	 * @return
	 */
	List<CatalogNew> findThirdCatname(String bfirstid,String bscondid);
	List<CatalogNew> getAllCatalogNews();
	
	List findArchivesByBfirstid(String bfirstid);
	
	Archives findByOid(Integer oid);
	void updateInformation(Archives old, Archives fresh);
	void updateArchivesCatalog(Archives archives);
	
	void addInformation(Archives information);
	/**
	 * 查看金融机构的变更历史
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getHistoryFinancial(Map<String, Object> params, Integer page);
	
	CatalogNew findCatalogNewById(CatalogNew catalogNew);
	PaginaterList getArchivesinformation(Map<String, Object> params,Integer page);
	

}
