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
 * 内控制度
 */
public interface IInnerControlDao extends IBaseDao{
	public PaginaterList getInnerControl(Map<String, Object> params, Integer page);
}
