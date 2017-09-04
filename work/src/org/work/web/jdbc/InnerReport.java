/**
 * 
 */
package org.work.web.jdbc;

import java.util.List;

/**
 * @作者 ThinkPad
 * @创建日期 Sep 21, 2010
 * @版本 work V1.0
 */
public class InnerReport {

	public List getReport1() {
		String sql = "select"
				+ "r.*,r1.*,r2.*,r3.* "
				+ "from"
				+ "(                 "
				+ "select "
				+ "b.oid,b.bid,c.catname,b.bname"
				+ "from"
				+ "b_org_catalog as c,b_org_information as b"
				+ "where c.bid=b.bid"
				+ ") as r"
				+ "left join"
				+ "("
				+ "select j.oid,"
				+ "sum(sb.n1),"
				+ "sum(sb.n2),"
				+ "sum(sb.n3),                             "
				+ "sum(sb.n4),"
				+ "sum(sb.n1+sb.n2+sb.n3+sb.n4),"
				+ "sum(sb.n25+sb.n26+sb.n27+sb.n28),"
				+ "sum(sb.n29+sb.n30+sb.n31+sb.n32),"
				+ "sum(sb.n33+sb.n34+sb.n35+sb.n36),"
				+ "sum(sb.n37+sb.n38+sb.n39+sb.n40),"
				+ "sum(sb.n41+sb.n42+sb.n43+sb.n44),"
				+ "sum(sb.n45+sb.n46+sb.n47+sb.n48),"
				+ "sum(sb.n25+sb.n26+sb.n27+sb.n28+sb.n29+sb.n30+sb.n31+sb.n32+sb.n33+sb.n34+sb.n35+sb.n36+sb.n37+sb.n38+sb.n39+sb.n40+sb.n41+sb.n42+sb.n43+sb.n44+sb.n45+sb.n46+sb.n47+sb.n48),"
				+ "sum(sb.n49),"
				+ "sum(sb.n50),"
				+ "sum(sb.n51),"
				+ "sum(sb.n52),"
				+ "sum(sb.n81+sb.n82+sb.n83+sb.n84),"
				+ "sum(sb.n85+sb.n86+sb.n87+sb.n88),"
				+ "sum(sb.n89+sb.n90+sb.n91+sb.n92),"
				+ "sum(sb.n93+sb.n94+sb.n95+sb.n96),"
				+ "sum(sb.n97+sb.n98+sb.n99+sb.n100),"
				+ "sum(sb.n101+sb.n102+sb.n103+sb.n104),"
				+ "sum(sb.n105+sb.n106+sb.n107+sb.n108),"
				+ "sum(sb.n81+sb.n82+sb.n83+sb.n84+sb.n85+sb.n86+sb.n87+sb.n88+sb.n89+sb.n90+sb.n91+sb.n92+sb.n93+sb.n94+sb.n95+sb.n96+sb.n97+sb.n98+sb.n99+sb.n100+sb.n101+sb.n102+sb.n103+sb.n104+sb.n105+sb.n106+sb.n107+sb.n108)"
				+ " from identity_sb as sb,"
				+ "(select rs.* from reportswitch as rs where rs.year=2010 and rs.quater>2 and rs.quater<4 and rs.reportid=6) as j where sb.switchid=j.switchid group by j.oid"
				+ ") as r1 on r.oid=r1.oid"
				+ "left join"
				+ "("
				+ "select j.oid,"
				+ "sum(sb.r1),"
				+ "sum(sb.r11),"
				+ "sum(sb.r21),"
				+ "sum(sb.r31),"
				+ "sum(sb.r41),"
				+ "sum(sb.r51),"
				+ "sum(sb.r6),"
				+ "sum(sb.r16),"
				+ "sum(sb.r26),"
				+ "sum(sb.r36),"
				+ "sum(sb.r46),"
				+ "sum(sb.r56),"
				+ "sum(sb.r3),"
				+ "sum(sb.r13),"
				+ "sum(sb.r23),"
				+ "sum(sb.r33),"
				+ "sum(sb.r43),"
				+ "sum(sb.r53),"
				+ "sum(sb.r8),"
				+ "sum(sb.r18),"
				+ "sum(sb.r28),"
				+ "sum(sb.r38),"
				+ "sum(sb.r48),"
				+ "sum(sb.r58)"
				+ " from identity_rsb as sb,"
				+ "(select rs.* from reportswitch as rs where rs.year=2010 and rs.quater>2 and rs.quater<4 and rs.reportid=7) as j where sb.switchid=j.switchid group by j.oid"
				+ ") as r2 on r.oid=r2.oid"
				+ "left join "
				+ "("
				+ "select j.oid,"
				+ "sum(sb.pp1),"
				+ "sum(sb.pp2),"
				+ "sum(sb.pp3),"
				+ "sum(sb.pp4)"
				+ " from identity_ky as sb,"
				+ "(select rs.* from reportswitch as rs where rs.year=2010 and rs.quater>2 and rs.quater<4 and rs.reportid=7) as j where sb.switchid=j.switchid group by j.oid"
				+ ") as r3" + " on  r.oid=r3.oid";
		return null;
	}
}
