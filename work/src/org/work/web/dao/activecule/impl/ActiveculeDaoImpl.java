package org.work.web.dao.activecule.impl;

import java.util.Map;

import org.work.web.dao.activecule.IActiveculeDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.ActiveSource;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class ActiveculeDaoImpl extends BaseDaoHibernateImpl implements IActiveculeDao{

	@Override
	public Class getModelClass() {
		return ActiveSource.class;
	}

	public int getActiveMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " from ActiveSource where aid like '%【"+ year +"】%' order by asid desc";
		Object obj = null;
		try{
			obj = getUniqueResult(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Integer index = 0;
		if(obj!=null){
			ActiveSource as = (ActiveSource)obj;
			String str = as.getAid();
			str = str.substring(str.indexOf("】")+1, str.indexOf("号"));
			index = Integer.parseInt(str)+1;
		}else index = 1;
		return index;
	}

	public PaginaterList getActiveSourceInfo(Map<String, Object> params,
			Integer page) {
		System.out.println("========= 查询线索来源（主动信息）（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from ActiveSource");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and aid = ?",params.get("aid"));
			helper.append(" and surveyname = ?",params.get("surveyname"));
			helper.append(" and source = ?",params.get("source"));
			helper.append(" and date >= ?",params.get("starttime"));
			helper.append(" and date <= ?",params.get("endtime"));
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
