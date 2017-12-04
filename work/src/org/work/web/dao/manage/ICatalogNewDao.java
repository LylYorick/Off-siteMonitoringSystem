package org.work.web.dao.manage;

import java.util.*;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Catalog;
import org.work.web.po.CatalogNew;

public interface ICatalogNewDao extends IBaseDao{

	/**
	 * @return 查找排序
	 */
	List<CatalogNew> findAllSort();
	
	/**
	 * 查询全部的一级机构类别
	 * @return
	 */
	List<CatalogNew> findAllFirstCatname();
	
	List<CatalogNew> findAllFirstCatname2();
	
	/**
	 * 通过金融机构的一级类别查询二级类别
	 * @param bfirstid
	 * @return
	 */
	List<CatalogNew> findSecondCatname(String bfirstid);
	
	/**
	 * 查询二级金融机构三级类别
	 * @return
	 */
	List<CatalogNew> findThirdCatname(String bfirstid,String bscondid);	
}
