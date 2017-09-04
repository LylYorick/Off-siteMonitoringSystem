/**
 * 
 */
package org.work.web.dao.report.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.report.IReportTypeDao;
import org.work.web.po.Report;

/* 
 * @author ThinkPad 
 * date : Jul 21, 2010 9:34:43 AM 
 */
public class ReportTypeDaoImpl extends BaseDaoHibernateImpl implements IReportTypeDao {

	@Override
	public Class getModelClass() {
		return Report.class;
	}
}
