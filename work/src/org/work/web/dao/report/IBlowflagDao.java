/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Blowflag;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构协助公安机关、其他机关打击洗钱活动情况标注
 */
public interface IBlowflagDao extends IBaseDao{
	public Blowflag getBlowflagBySwitchId(Integer switchid);
}
