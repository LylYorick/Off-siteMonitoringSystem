/**
 * 
 */
package org.work.web.dao.suspiciousinsurance.imp;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.MatchMode;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.suspiciousinsurance.IInsurancebaseDao;
import org.work.web.po.Insurancebase;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

public class InsurancebaseDaoImpl extends BaseDaoHibernateImpl implements IInsurancebaseDao {

	@Override
	public Class getModelClass() {
		return Insurancebase.class;
	}	

	public int getBaseMaxIndex(String lineid,String oid) {
		String hql = " select max(b.lineid) from Insurancebase b where b.lineid like '%"+lineid+"%' and BOrgInformation.oid = "+oid + " group by b.lineid";
		System.out.println("hql :: "+hql);
		List<String> result = null;
		try{
			result = this.getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		String indexstr = "0";
		int index = 0;
		if(result!=null&&result.size()>0){
			indexstr = result.get(0);
			indexstr = indexstr.substring((indexstr.indexOf("-", 7))+3);
			System.out.println("*********** indexstr :: "+indexstr);
		}
		try{
			index = Integer.parseInt(indexstr)+1;
		}catch(NumberFormatException e){
			e.printStackTrace();
			index = 1;
		}
		System.out.println("========== index :: "+index);
		return index;
	}

	public PaginaterList getInsuranceBaseInfo(Map<String, Object> params,Integer page) {
		System.out.println("========= 查询保险业可疑交易信息（金融机构用户操作） ============");
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Insurancebase");
		if(params!=null){
			System.out.println("********params :: "+params.get("oid") +" lineid ::  "+params.get("lineid"));
			helper.append(" where 1=1");
			helper.append(" and BOrgInformation.oid = ?",params.get("oid"));
			helper.append(" and cname = ?",params.get("cname"));
			helper.append(" and ccid = ?",params.get("ccid"));			
			helper.append(" and updatetime >= ?",params.get("starttime"));
			helper.append(" and updatetime <= ?",params.get("endtime"));			
			helper.append(" and lineid like ?",(String)params.get("lineid"),MatchMode.ANYWHERE);			
		}
		return getPaginaterList(helper, page);
	}

	public List<Insurancebase> getInsuranceBaseInfoAll(Map<String, Object> params) {
		System.out.println("========= 查询保险业可疑交易信息,不分页（金融机构用户操作） ============");
		System.out.println("********params :: "+params.get("oid") +" lineid ::  "+params.get("lineid"));
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" from Insurancebase");
		if(params!=null){			
			helper.append(" where 1=1");
			helper.append(" and BOrgInformation.oid = ?",params.get("oid"));
			helper.append(" and cname = ?",params.get("cname"));
			helper.append(" and ccid = ?",params.get("ccid"));			
			helper.append(" and updatetime >= ?",params.get("starttime"));
			helper.append(" and updatetime <= ?",params.get("endtime"));			
			helper.append(" and lineid like ?",(String)params.get("lineid"),MatchMode.ANYWHERE);			
		}
		return getList(helper);
	}

}
