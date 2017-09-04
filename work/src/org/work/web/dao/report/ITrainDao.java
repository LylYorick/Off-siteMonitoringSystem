/**
 * 
 */
package org.work.web.dao.report;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.util.PaginaterList;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构反洗钱培训活动情况
 */
public interface ITrainDao extends IBaseDao{
	public PaginaterList getTrain(Map<String, Object> params, Integer page);
}
