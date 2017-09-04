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
 * 金融机构反洗钱工作内部审计情况
 */
public interface IInnerAuditDao extends IBaseDao{
	public PaginaterList getInnerAudit(Map<String, Object> params, Integer page);
}
