package org.work.web.dao.manage;

import java.util.*;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Catalog;

public interface ICatalogDao extends IBaseDao{

	/**
	 * @return 查找排序
	 */
	List<Catalog> findAllSort();
	
}
