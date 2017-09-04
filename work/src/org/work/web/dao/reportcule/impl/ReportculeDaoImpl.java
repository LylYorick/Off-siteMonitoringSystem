package org.work.web.dao.reportcule.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.reportcule.IReportculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.ReportSource;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class ReportculeDaoImpl extends BaseDaoHibernateImpl implements IReportculeDao{

	@Override
	public Class getModelClass() {
		return ReportSource.class;
	}

	public int getReportMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " from ReportSource where rid like '%【"+ year +"】%' order by asid desc";
		Object obj = null;
		try{
			obj = getUniqueResult(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Integer index = 0;
		if(obj!=null){
			ReportSource rs = (ReportSource)obj;
			String str = rs.getRid();
			if(str.indexOf("】")!=-1){
			str = str.substring(str.indexOf("】")+1, str.indexOf("号"));
			index = Integer.parseInt(str)+1;
			}else throw new ServiceException("编号格式不正确");
		}else index = 1;
		return index;
	}

	public PaginaterList getReportSourceInfo(Map<String, Object> params,
			Integer page) {
		System.out.println("========= 查询线索来源（举报或者专报）信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from ReportSource");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and rid = ?", params.get("rid"));
			helper.append(" and unit = ?", params.get("unit"));
			helper.append(" and researchname = ?", params.get("researchname"));
			helper.append(" and date >= ?",params.get("starttime"));
			helper.append(" and date <= ?",params.get("endtime"));
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
