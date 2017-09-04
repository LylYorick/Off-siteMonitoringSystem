/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Innerauditflag;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构反洗钱工作内部审计情况标注
 */
public interface IInnerAuditFlagDao extends IBaseDao{

	/**
	 * @param valueOf
	 * @return
	 */
	Innerauditflag getInnerauditFlagBySwitchId(Integer valueOf);
}
