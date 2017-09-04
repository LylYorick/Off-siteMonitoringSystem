package org.work.web.dao.judicialcule.impl;

import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.judicialcule.IJudicialculeDao;
import org.work.web.exception.ServiceException;
import org.work.web.po.Judicialsource;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class JudicialculeDaoImpl extends BaseDaoHibernateImpl implements IJudicialculeDao{

	@Override
	public Class getModelClass() {
		return Judicialsource.class;
	}

	public int getJudiciaMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " from Judicialsource where jid like '%【"+ year +"】%' order by jid desc";
		Object obj = null;
		try{
			obj = getUniqueResult(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Integer index = 0;
		if(obj!=null){
			Judicialsource js = (Judicialsource)obj;
			String str = js.getJid();
			if(str.indexOf("】")!=-1){
			str = str.substring(str.indexOf("】")+1, str.indexOf("号"));
			index = Integer.parseInt(str)+1;
			}else throw new ServiceException("编号格式不正确");
		}else index = 1;
		return index;
	}

	public PaginaterList getJudicialSourceInfo(Map<String, Object> params,
			Integer page) {
		System.out.println("========= 查询线索来源（司法机关）信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Judicialsource");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and jid = ?", params.get("jid"));
			helper.append(" and unit = ?", params.get("unit"));
			helper.append(" and surveyname = ?", params.get("surveyname"));
			helper.append(" and date >= ?",params.get("starttime"));
			helper.append(" and date <= ?",params.get("endtime"));			
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
