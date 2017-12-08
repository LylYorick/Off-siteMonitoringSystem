/**
 * 
 */
package org.work.web.dao.archives;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Archives;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface ArchivesDao   extends IBaseDao{

	public PaginaterList getArchivesFinancial(Map<String, Object> params, Integer page);
	
	public List<Archives> getArchivesFinancialAll(Map<String, Object> params);

	PaginaterList getArchivesinformation(Map<String, Object> params,Integer page);
	List findArchivesByBfirstid(String bfirstid);
}
