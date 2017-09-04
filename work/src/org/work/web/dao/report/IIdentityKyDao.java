/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Identityky;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构客户身份识别情况(涉及可疑交易识别情况)
 */
public interface IIdentityKyDao extends IBaseDao{
	public Identityky getIdentitykyBySwitchid(Integer switchid);
}
