package org.work.web.dao.Investigation.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.Investigation.IInvestigationDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.CheckRoster;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class InvestigationDaoImpl  extends BaseDaoHibernateImpl  implements IInvestigationDao{

	@Override
	public Class getModelClass() {
		// TODO Auto-generated method stub
		return CheckRoster.class;
	}

	public int getCheckMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " select count(*) from CheckRoster c where c.sid like '%"+ year +"%'";
		System.out.println("hql :: "+hql);
		List result = null;
		try{
			result = this.getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		//String indexstr = "0";
		Integer index = 0;
		if(result!=null&&result.size()>0){
			System.out.println(result.get(0));
			index = Integer.parseInt(String.valueOf(result.get(0)))+1;
		}else index = 1;
		System.out.println("========== index :: "+index);
		return index;
	}

	public PaginaterList getCheckRosterInfo(Map<String, Object> params,
			Integer page) {
		// TODO Auto-generated method stub
		System.out.println("========= 查询协查名单信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from CheckRoster");
		if(params!=null){
			System.out.println("********params :: "+params.get("checkid") +" lineid ::  "+params.get("unit"));
			helper.append(" where 1=1");
			helper.append(" and checkid = ?",params.get("checkid"));
			helper.append(" and unit = ?", params.get("unit"));
			helper.append(" and senddate >= ?",params.get("starttime"));
			helper.append(" and senddate <= ?",params.get("endtime"));			
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
