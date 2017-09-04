/**
 * 
 */
package org.work.web.service.financial;

import java.util.List;
import java.util.Map;

import org.work.web.po.Catalog;
import org.work.web.po.Information;
import org.work.web.po.Tai;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IFinancialService {

	/**
	 * @param cid
	 * @return Catalog
	 */
	Catalog findByCatalogId(int cid);

	Information findByOid(Integer oid);

	/**
	 * 查询所有金融机构类别
	 * @return
	 */
	List<Catalog> findByCatalog();

	/**
	 * 人民银行用户增加金融机构的基本信息，只增加金融机构ID与金融机构名称
	 * @param information
	 */
	void addInformation(Information information);

	/**
	 * 金融机构用户保存自己的信息
	 * @param information
	 */
	void updateInformation(Information information);

	/**
	 * 金融机构用户保存自己的信息
	 * @param information
	 * @param information2
	 */
	void updateInformation(Information information, Information information2);

	/**
	 * 根据条件查询金融机构的信息
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getInformationFinancial(Map<String, Object> params,Integer page);

	/**
	 * 查看金融机构的变更历史
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList getHistoryFinancial(Map<String, Object> params, Integer page);

	/**
	 * 
	 * @param username
	 * @return
	 */
	String buildXls(String username,String path,Map<String, Object> params);

	/**
	 * @param params
	 * @param page
	 * @return
	 */
	PaginaterList findTai(Map<String, Object> params, Integer page);

	/**
	 * @param tai
	 */
	void saveTai(Tai tai);

	/**
	 * @param taidi
	 * @return
	 */
	Tai findTai(Integer taidi);

	/**
	 * @param information
	 * @return
	 */
	List findByBoid(String information);
}
