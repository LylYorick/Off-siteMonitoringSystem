package org.work.web.dao.transfercule.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.transfercule.ITransferculeDao;
import org.work.web.po.Transfersource;
import org.work.web.util.DateUtil;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class TransferculeDaoImpl extends BaseDaoHibernateImpl implements ITransferculeDao{

	@Override
	public Class getModelClass() {
		return Transfersource.class;
	}

	public int getTransferMaxId() {
		String year = DateUtil.getCurrentYear();
		String hql = " select count(*) from Transfersource t where t.tid like '%"+ year +"%'";
		List result = null;
		try{
			result = getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Integer index = 0;
		if(result!=null&&result.size()>0){
			index = Integer.parseInt(String.valueOf(result.get(0)))+1;
		}else index = 1;
		return index;
	}

	public PaginaterList getTransferSourceInfo(Map<String, Object> params,
			Integer page) {
		System.out.println("========= 查询线索移交信息（人行用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Transfersource");
		if(params!=null){
			helper.append(" where 1=1");
			helper.append(" and transfersymbol = ?", params.get("transfersymbol"));
			helper.append(" and subjectname = ?", params.get("subjectname"));
			helper.append(" and isplacedonfile = ?", params.get("isplacedonfile"));
			helper.append(" and receivingunit = ?", params.get("receivingunit"));
			helper.append(" and transferdate >= ?",params.get("starttime"));
			helper.append(" and transferdate <= ?",params.get("endtime"));			
		}
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by "+(String)params.get("order"));
		helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		return getPaginaterList(helper, page);
	}

}
