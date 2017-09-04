/**
 * 
 */
package org.work.web.dao.suspicious;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Upload;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface ISuspiciousDao extends IBaseDao{

	PaginaterList findByOId(Map<String, Object> params,Integer page);
	
	PaginaterList findAllUpload(Map<String, Object> params,Integer page);

	List<Upload> getAllUpload(Map<String, Object> params);

}
