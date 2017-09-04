/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Identityrsb;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构客户身份识别情况(重新识别客户)
 */
public interface IIdentityRsbDao extends IBaseDao{
	public Identityrsb getIndentityrsbBySwitchid(Integer switchid);
}
