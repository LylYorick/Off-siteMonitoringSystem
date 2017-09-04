/**
 * 
 */
package org.work.web.dao.assess.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.assess.IAssessDao;
import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.po.Assess;
import org.work.web.po.AssessIndex;
import org.work.web.po.Information;
import org.work.web.util.Paginater;
import org.work.web.util.PaginaterList;
import org.work.web.util.QueryHelper;

/**
 * @作者 aps-dux
 * @创建日期
 * @{date}
 * @版本 深圳V1.0
 */
public class AssessDaoImpl extends BaseDaoHibernateImpl implements IAssessDao {

	@Override
	public Class getModelClass() {
		return Assess.class;
	}

	public PaginaterList getInformationAssess(Map<String, Object> params,
			Integer page) {
		String sqlplus = "";
		if(params.get("bid")!=null && !"".equals(params.get("bid"))){
			sqlplus+=" and informatio0_.bid="+params.get("bid");
		}
		if(params.get("oid")!=null && !"".equals(params.get("oid"))){
			sqlplus+=" and informatio0_.oid="+params.get("oid");
		}
		String level = "";
		if(params.get("level")!=null && !"".equals(params.get("level"))){
			level+=" where 1=1";
			level+=" and temp_.COL_4_0_='"+params.get("level")+"'";
		}
		String sqlorder = "";
		if ("score".equals(params.get("order"))) {
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null
					? ""
					: " order by sum(double(bassess1_.SCORE)) ";
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : (String) params
					.get("sord");
		} else {
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : " order by informatio0_.oid ";
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : (String) params
					.get("sord");
		}
		String sql = "select                                                                     "
				+ "        col_0_0_    ,col_1_0_  ,col_2_0_  ,col_3_0_ ,col_4_0_ ,col_5_0_ ,col_6_0_"
				+ "    from                                                                   "
				+ "        ( select                                                           "
				+ "            informatio0_.OID as col_0_0_,                                  "
				+ "            informatio0_.BNAME as col_1_0_,                                "
				+ "            bassess1_.YEAR as col_2_0_,                                    "
				+ "            sum(double(bassess1_.SCORE)) as col_3_0_,                      "
				+ "            case                                                           "
				+ "                when sum(double(bassess1_.SCORE))>=-10 then 'A'            "
				+ "                when sum(double(bassess1_.SCORE))>=-20 then 'B'             "
				+ "                when sum(double(bassess1_.SCORE))>=-40 then 'C'            "
				+ "                when sum(double(bassess1_.SCORE))<-40 then 'D'             "
				+ "            end as col_4_0_,                                                "
				+ "            sum(double(bassess1_.SELFEVALSCORE)) as col_5_0_,                      "
				+ "            case                                                           "
				+ "                when sum(double(bassess1_.SELFEVALSCORE))>=-10 then 'A'            "
				+ "                when sum(double(bassess1_.SELFEVALSCORE))>=-20 then 'B'             "
				+ "                when sum(double(bassess1_.SELFEVALSCORE))>=-40 then 'C'            "
				+ "                when sum(double(bassess1_.SELFEVALSCORE))<-40 then 'D'             "
				+ "            end as col_6_0_                                                "
				+ "        from                                                               "
				+ "            B_ORG_INFORMATION informatio0_                                 "
				+ "        left outer join                                                    "
				+ "            ASSESS bassess1_                                               "
				+ "                on informatio0_.OID=bassess1_.OID                          "
				+ "                and (                                                      "
				+ "                    bassess1_.YEAR='"+params.get("year")
				+ "'                    )                                                      "
				+ "                    where                                                  "
				+ "                        1=1                                                "
				+sqlplus
				+ "                    group by                                               "
				+ "                        informatio0_.OID ,                                 "
				+ "                        informatio0_.BNAME ,                               "
				+ "                        bassess1_.YEAR"+sqlorder+" ) as temp_ "+level;
		List listm = getSession().createSQLQuery(sql).list();
		PaginaterList list = new PaginaterList();
		Paginater paginater = new Paginater(listm.size(), page, 20);
		List listresult = getSession().createSQLQuery(sql).setMaxResults(
				paginater.getPageSize()).setFirstResult(
				(int) paginater.getOffsetIndex()).list();
		paginater.setData(listresult);
		list.setPaginater(paginater);
		return list;
	}
	
	public PaginaterList _getInformationAssess(Map<String, Object> params,
			Integer page) {
		String sqlplus = "";
		if(params.get("bid")!=null && !"".equals(params.get("bid"))){
			sqlplus+=" and informatio0_.bid="+params.get("bid");
		}
		if(params.get("oid")!=null && !"".equals(params.get("oid"))){
			sqlplus+=" and informatio0_.oid="+params.get("oid");
		}
		String sqlorder = "";
		if ("score".equals(params.get("order"))) {
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null
					? ""
					: " order by sum(double(a.score)) ";
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : (String) params
					.get("sord");
		} else {
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : " order by i.oid ";
			sqlorder += "".equals(params.get("order"))
					|| params.get("order") == null ? "" : (String) params
					.get("sord");
		}
		String sql = "select                                                                     "
				+ "        *                                                                  "
				+ "    from                                                                   "
				+ "        ( select                                                           "
				+ "            rownumber() over() as rownumber_,                              "
				+ "            informatio0_.OID as col_0_0_,                                  "
				+ "            informatio0_.BNAME as col_1_0_,                                "
				+ "            bassess1_.YEAR as col_2_0_,                                    "
				+ "            sum(double(bassess1_.SCORE)) as col_3_0_,                      "
				+ "            case                                                           "
				+ "                when sum(double(bassess1_.SCORE))>=-10 then 'A'            "
				+ "                when sum(double(bassess1_.SCORE))>-20 then 'B'             "
				+ "                when sum(double(bassess1_.SCORE))>=-40 then 'C'            "
				+ "                when sum(double(bassess1_.SCORE))<-40 then 'D'             "
				+ "            end as col_4_0_                                                "
				+ "        from                                                               "
				+ "            B_ORG_INFORMATION informatio0_                                 "
				+ "        left outer join                                                    "
				+ "            ASSESS bassess1_                                               "
				+ "                on informatio0_.OID=bassess1_.OID                          "
				+ "                and (                                                      "
				+ "                    bassess1_.YEAR="+params.get("year")
				+ "                    )                                                      "
				+ "                    where                                                  "
				+ "                        1=1                                                "
				+sqlplus
				+ "                    group by                                               "
				+ "                        informatio0_.OID ,                                 "
				+ "                        informatio0_.BNAME ,                               "
				+ "                        bassess1_.YEAR"+sqlorder+" ) as temp_ where temp_.COL_4_0_='"+params.get("level")+"'";
		List listm = getSession().createSQLQuery(sql).list();
		PaginaterList list = new PaginaterList();
		Paginater paginater = new Paginater(listm.size(), page, 20);
		List listresult = getSession().createSQLQuery(sql).setMaxResults(
				paginater.getPageSize()).setFirstResult(
				(int) paginater.getOffsetIndex()).list();
		paginater.setData(listresult);
		list.setPaginater(paginater);
		return list;
	}
	public PaginaterList OK(Map<String, Object> params,
			Integer page){
		QueryHelper helper = new QueryHelper(getSession());
		helper.append(" select i.oid,i.bname,a.year,sum(double(a.score)) as x,case  when sum(double(a.score))>=-10 then 'A'  when sum(double(a.score))>-20 then 'B'  when sum(double(a.score))>=-40 then 'C'  when sum(double(a.score))<-40 then 'D' end as xxx from Information i left join i.BAssess a" );
		if (params != null) {
			helper.append(" with a.year = ?",params.get("year"));
			helper.append(" and a.assessindex.acsid in (?)",(Integer[])params.get("ascid"));
			helper.append(" where 1 = 1");
			helper.append(" and i.oid = ?",params.get("oid"));
			helper.append(" and i.BOrgCatalog.bid = ?",params.get("bid"));
		}
		helper.append(" group by i.oid,i.bname,a.year");
		if("score".equals(params.get("order"))){
			helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by sum(double(a.score)) ");
			helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		}else{
			helper.append("".equals(params.get("order"))||params.get("order")==null?"":" order by i.oid ");
			helper.append("".equals(params.get("order"))||params.get("order")==null?"":(String)params.get("sord"));
		}
		return getPaginaterListJoin(helper, page);
	}

	public void deleteById(String year, Information orgInformation,AssessIndex assessIndex) {
		QueryHelper queryHelper = new QueryHelper(this.getSession());
		queryHelper.append("from Assess a where year =?",year);
		queryHelper.append(" and  BOrgInformation.oid=?",orgInformation.getOid());
		queryHelper.append(" and  assessindex.acsid=?",assessIndex.getAcsid());
		List list = getList(queryHelper);
		if (list.size()>0) {
			this.delete(list.get(0));
		}
	}

	/**added by liuxz at 2017-03-02*/
	public List getSelfEvalueScore(Map<String, Object> params) {
		QueryHelper queryHelper = new QueryHelper(this.getSession());
		queryHelper.append("select sum(double(a.selevalscore)) from Assess a where year =?",params.get("year"));
		queryHelper.append(" and  BOrgInformation.oid=?",params.get("oid"));
		queryHelper.append(" and  assessindex.ascfiled like ?","b%");
		
		return getList(queryHelper);
	}
}
