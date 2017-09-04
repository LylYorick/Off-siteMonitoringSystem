/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Indentitysb;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构客户身份识别情况（识别客户）
 */
public interface IIdentitySbDao extends IBaseDao{
	public Indentitysb getIndentitysbBySwitchid(Integer switchid);
}
