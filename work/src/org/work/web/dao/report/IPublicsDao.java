/**
 * 
 */
package org.work.web.dao.report;

import java.util.Map;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Publics;
import org.work.web.util.PaginaterList;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构协助公安机关、其他机关打击洗钱活动情况
 */
public interface IPublicsDao extends IBaseDao{
	public Publics getPublicsBySwitchId(Integer switchid);

	public PaginaterList getPublics(Map<String, Object> params, Integer page);
	
}
