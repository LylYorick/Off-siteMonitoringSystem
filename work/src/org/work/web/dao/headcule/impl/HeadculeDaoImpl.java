package org.work.web.dao.headcule.impl;

import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.headcule.IHeadculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Headofficesource;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class HeadculeDaoImpl extends BaseDaoHibernateImpl implements IHeadculeDao{

	@Override
	public Class getModelClass() {
		return Headofficesource.class;
	}

	public int getHeadMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " from Headofficesource  where hid like '%【"+ year +"】%' order by hid desc";
		Object obj = null;
		try{
			obj = getUniqueResult(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Integer index = 0;
		if(obj!=null){
			Headofficesource hs = (Headofficesource)obj;
			String str = hs.getHid();
			if(str.indexOf("】")!=-1){
			str = str.substring(str.indexOf("】")+1, str.indexOf("号"));
			index = Integer.parseInt(str)+1;
			}else throw new ServiceException("编号格式不正确");
		}else index = 1;
		return index;
	}

	public PaginaterList getHeadSourceInfo(Map<String, Object> params,
			Integer page) {
		System.out.println("========= 查询线索来源（总行或兄弟行）信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Headofficesource");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and hid like ?", (String)params.get("hid"),MatchMode.ANYWHERE);
			helper.append(" and source = ?", params.get("source"));
			helper.append(" and surveyname = ?", params.get("surveyname"));
			helper.append(" and date >= ?",params.get("starttime"));
			helper.append(" and date <= ?",params.get("endtime"));			
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
