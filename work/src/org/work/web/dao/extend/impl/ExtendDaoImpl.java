/**
 * 
 */
package org.work.web.dao.extend.impl;

import java.util.List;
import java.util.Map;

import org.work.web.dao.base.impl.BaseDaoHibernateImpl;
import org.work.web.dao.extend.IExtendDao;
import org.work.web.util.DateUtil;
import org.work.web.util.Paginater;
import org.work.web.util.PaginaterList;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 深圳V1.0
 */
public class ExtendDaoImpl extends BaseDaoHibernateImpl implements IExtendDao {

	@Override
	public Class getModelClass() {
		return null;
	}
	
	public List getReportStatus(Map<String, Object> params) {
		String sql1="";
		if(params.get("bid")!=null)
			sql1+=" and b.bid="+params.get("bid");
		if(params.get("oid")!=null)
			sql1+=" and b.oid="+params.get("oid");
		String sql2=" where 1=1";
		if(params.get("year")!=null && !"".equals(params.get("year"))){
			sql2+=" and year="+params.get("year");
		}else{
			sql2+=" and year="+DateUtil.getCurrentYear();
		}
		sql2+=" and quater in ("+params.get("quater")+",0)";
		String sql = "select b.bname,max(r.r1),max(r.r2),max(r.r3),max(r.r4),max(r.r5),max(r.r6),max(r.r7),max(r.r8),max(r.r9),max(r.r10)" +
				"from (select oid, case when reportid=1 then status end r1," +
				"case when reportid=2 then status end r2," +
				"case when reportid=3 then status end r3," +
				"case when reportid=4 then status end r4," +
				"case when reportid=5 then status end r5," +
				"case when reportid=6 then status end r6," +
				"case when reportid=7 then status end r7," +
				"case when reportid=8 then status end r8," +
				"case when reportid=9 then status end r9," +
				"case when reportid=10 then status end r10" +
				" from reportswitch "+sql2+" group by oid,reportid,status" +
				" ) as r,b_org_information as b,b_org_catalog as c where r.oid=b.oid and b.bid=c.bid"+sql1+" group by r.oid,b.bname";
		List list = getSession().createSQLQuery(sql).list();
		/*helper.append("select BOrgInformation.oid, case when reportid=6 then status end as r6," +
		"case when reportid=7 then status end as r7," +
		"case when reportid=8 then status end as r8," +
		"case when reportid=9 then status end as r9," +
		"case when reportid=10 then status end as r10" +
		" from Reportswitch group by BOrgInformation.oid,report.reportid,status");*/
		return list;
	}
	public PaginaterList getReportImport(Map<String, Object> params,int page) {
		String sqlplus="where 1=1";
		String sqloid="";
		if(params.get("year")!=null && !"".equals(params.get("year"))){
			sqlplus+=" and rs.year="+params.get("year");
		}else{
			sqlplus+=" and rs.year="+DateUtil.getCurrentYear();
		}
		sqlplus+=" and quater in ("+params.get("quater")+",0)";
		if(params.get("oid")!=null && !"".equals(params.get("oid"))){
			sqloid+=" and b.oid="+params.get("oid");
		}
		if(params.get("bid")!=null && !"".equals(params.get("bid"))){
			sqloid+=" and c.bid="+params.get("bid");
		}
		String sql = "select"
			+ " r.*,r1.*,r2.*,r3.* "
			+ "from"
			+ "(                 "
			+ " select "
			+ " b.oid,b.bid,c.catname,b.bname"
			+ " from"
			+ " b_org_catalog as c,b_org_information as b"
			+ " where c.bid=b.bid"+sqloid
			+ " ) as r"
			+ " left join"
			+ " ("
			+ " select j.oid,"
			+ " sum(sb.n1),"
			+ " sum(sb.n2),"
			+ " sum(sb.n3),                             "
			+ " sum(sb.n4),"
			+ " sum(sb.n1+sb.n2+sb.n3+sb.n4),"
			+ " sum(sb.n25+sb.n26+sb.n27+sb.n28),"
			+ " sum(sb.n29+sb.n30+sb.n31+sb.n32),"
			+ " sum(sb.n33+sb.n34+sb.n35+sb.n36),"
			+ " sum(sb.n37+sb.n38+sb.n39+sb.n40),"
			+ " sum(sb.n41+sb.n42+sb.n43+sb.n44),"
			+ " sum(sb.n45+sb.n46+sb.n47+sb.n48),"
			+ " sum(sb.n25+sb.n26+sb.n27+sb.n28+sb.n29+sb.n30+sb.n31+sb.n32+sb.n33+sb.n34+sb.n35+sb.n36+sb.n37+sb.n38+sb.n39+sb.n40+sb.n41+sb.n42+sb.n43+sb.n44+sb.n45+sb.n46+sb.n47+sb.n48),"
			+ " sum(sb.n49),"
			+ " sum(sb.n50),"
			+ " sum(sb.n51),"
			+ " sum(sb.n52),"
			+ " sum(sb.n81+sb.n82+sb.n83+sb.n84),"
			+ " sum(sb.n85+sb.n86+sb.n87+sb.n88),"
			+ " sum(sb.n89+sb.n90+sb.n91+sb.n92),"
			+ " sum(sb.n93+sb.n94+sb.n95+sb.n96),"
			+ " sum(sb.n97+sb.n98+sb.n99+sb.n100),"
			+ " sum(sb.n101+sb.n102+sb.n103+sb.n104),"
			+ " sum(sb.n105+sb.n106+sb.n107+sb.n108),"
			+ " sum(sb.n81+sb.n82+sb.n83+sb.n84+sb.n85+sb.n86+sb.n87+sb.n88+sb.n89+sb.n90+sb.n91+sb.n92+sb.n93+sb.n94+sb.n95+sb.n96+sb.n97+sb.n98+sb.n99+sb.n100+sb.n101+sb.n102+sb.n103+sb.n104+sb.n105+sb.n106+sb.n107+sb.n108)"
			+ "  from identity_sb as sb,"
			+ " (select rs.* from reportswitch as rs "+sqlplus+" and rs.reportid=6) as j where sb.switchid=j.switchid group by j.oid"
			+ " ) as r1 on r.oid=r1.oid"
			+ " left join"
			+ " ("
			+ " select j.oid,"
			+ " sum(sb.r1),"
			+ " sum(sb.r11),"
			+ " sum(sb.r21),"
			+ " sum(sb.r31),"
			+ " sum(sb.r41),"
			+ " sum(sb.r51),"
			+ " sum(sb.r6),"
			+ " sum(sb.r16),"
			+ " sum(sb.r26),"
			+ " sum(sb.r36),"
			+ " sum(sb.r46),"
			+ " sum(sb.r56),"
			+ " sum(sb.r3),"
			+ " sum(sb.r13),"
			+ " sum(sb.r23),"
			+ " sum(sb.r33),"
			+ " sum(sb.r43),"
			+ " sum(sb.r53),"
			+ " sum(sb.r8),"
			+ " sum(sb.r18),"
			+ " sum(sb.r28),"
			+ " sum(sb.r38),"
			+ " sum(sb.r48),"
			+ " sum(sb.r58)"
			+ "  from identity_rsb as sb,"
			+ " (select rs.* from reportswitch as rs "+sqlplus+" and rs.reportid=7) as j where sb.switchid=j.switchid group by j.oid"
			+ " ) as r2 on r.oid=r2.oid"
			+ " left join "
			+ " ("
			+ " select j.oid,"
			+ " sum(sb.pp1),"
			+ " sum(sb.pp2),"
			+ " sum(sb.pp3),"
			+ " sum(sb.pp4)"
			+ "  from identity_ky as sb,"
			+ " (select rs.* from reportswitch as rs "+sqlplus+" and rs.reportid=8) as j where sb.switchid=j.switchid group by j.oid"
			+ " ) as r3" + " on  r.oid=r3.oid";
		List listm = getSession().createSQLQuery(sql).list();
		PaginaterList list = new PaginaterList();
		Paginater paginater = new Paginater(listm.size(), page, 20);
		List listresult = getSession().createSQLQuery(sql)
		.setMaxResults(paginater.getPageSize())
		.setFirstResult((int) paginater.getOffsetIndex())
		.list();
		paginater.setData(listresult);
		list.setPaginater(paginater);
		return list;
	}

	public PaginaterList getReportSuspicous(Map<String, Object> params, int page) {
		String sqlplus="where 1=1";
		String sqloid="";
		if(params.get("year")!=null && !"".equals(params.get("year"))){
			sqlplus+=" and rs.year="+params.get("year");
		}else{
			sqlplus+=" and rs.year="+DateUtil.getCurrentYear();
		}
		sqlplus+=" and quater in ("+params.get("quater")+",0)";
		if(params.get("oid")!=null && !"".equals(params.get("oid"))){
			sqloid+=" and b.oid="+params.get("oid");
		}
		if(params.get("bid")!=null && !"".equals(params.get("bid"))){
			sqloid+=" and c.bid="+params.get("bid");
		}
		String sql = "select r.*,rr.*,rs2.* from(select  b.oid,b.bid,c.catname,b.bname from b_org_catalog as c,b_org_information as b where c.bid=b.bid"+sqloid+") as r left join" +
				"" +
				" (select s.*,rs.oid from susreport as s,(select rs.* from reportswitch as rs "+sqlplus+" and rs.reportid=9) as rs where s.switchid=rs.switchid) as rr" +
				" on r.oid=rr.oid left join" +
				" (" +
				" select" +
				" rs1.oid,sum(rs1.r1),sum(rs1.r2),sum(rs1.r3)" +
				" from" +
				" (" +
				" select" +
				" rs.oid,case when xp5='公安机关' then count(xp5) end as r1,case when xp5!='公安机关' then count(xp5) end as r2,count(xp5) as r3" +
				" from " +
				" publics as p,(select rs.* from reportswitch as rs "+sqlplus+" and rs.reportid=10) as rs where p.switchid=rs.switchid group by rs.oid,p.xp5" +
				" ) as rs1 group by rs1.oid" +
				" ) as rs2 on rs2.oid=r.oid";
		List listm = getSession().createSQLQuery(sql).list();
		PaginaterList list = new PaginaterList();
		Paginater paginater = new Paginater(listm.size(), page, 20);
		List listresult = getSession().createSQLQuery(sql)
		.setMaxResults(paginater.getPageSize())
		.setFirstResult((int) paginater.getOffsetIndex())
		.list();
		paginater.setData(listresult);
		list.setPaginater(paginater);
		return list;
	}

	public PaginaterList getReportImportB(Map<String, Object> params,
			Integer page) {
		String sqlplus="";
		if(params.get("year")!=null && !"".equals(params.get("year"))){
			sqlplus+=" and year(b.updatetime)="+params.get("year");
			if(params.get("quater")!=null && !"".equals(params.get("quater"))){
				sqlplus+=" and b.updatetime between "+DateUtil.getQuaterPeriod((String)params.get("year"),(String)params.get("quater"));
			}
		}else{
			sqlplus+=" and year(b.updatetime)="+DateUtil.getCurrentYear();
		}
		if(params.get("oid")!=null && !"".equals(params.get("oid"))){
			sqlplus+=" and b.oid="+params.get("oid");
		}
		String sql = "select c.bname,sum(clnum),sum(clamt),sum(cfnum),sum(cfamt) from b_bank_base as b,b_org_information as c  where b.oid=c.oid "+sqlplus+" group by c.bname";
		List listm = getSession().createSQLQuery(sql).list();
		PaginaterList list = new PaginaterList();
		Paginater paginater = new Paginater(listm.size()+1, page, 20);
		List listresult = getSession().createSQLQuery(sql)
		.setMaxResults(paginater.getPageSize())
		.setFirstResult((int) paginater.getOffsetIndex())
		.list();
		paginater.setData(listresult);
		list.setPaginater(paginater);
		return list;
	}

}
