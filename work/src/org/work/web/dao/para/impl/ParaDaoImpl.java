/**
 * 
 */
package org.work.web.dao.para.impl;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.para.IParaDao;
import org.work.web.po.Report;

/**
 * @作者 ThinkPad
 * @创建日期 Oct 13, 2010
 * @版本 work V1.0
 */
public class ParaDaoImpl  extends BaseDaoHibernateImpl implements IParaDao {

	@Override
	public Class getModelClass() {
		return Report.class;
	}
	public Integer getReportEndDay(int reporttype) {
		return (Integer)getUniqueResult("select endday from Report where prtype="+reporttype);
	}

	public void updateEndDay(int reporttype,int endday) {
		String sql = "update Report set endday="+endday+" where prtype="+reporttype;
		this.execute(sql);
	}

	
}
