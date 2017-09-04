/**
 * 
 */
package org.work.web.dao.information;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public interface IInformationHisDao   extends IBaseDao{

	PaginaterList getHistoryFinancial(Map<String, Object> params, Integer page);

}
