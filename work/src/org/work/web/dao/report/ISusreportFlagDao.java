/**
 * 
 */
package org.work.web.dao.report;

import org.work.web.dao.base.IBaseDao;
import org.work.web.po.Susreportflag;

/* 
 * @author ThinkPad 
 * date : Jul 20, 2010 11:29:06 AM 
 * 金融机构可疑交易报告情况统计表标注
 */
public interface ISusreportFlagDao extends IBaseDao{
	public Susreportflag getSusreportFlagBySwitchId(Integer switchid);
}
