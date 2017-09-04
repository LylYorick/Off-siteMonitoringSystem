/**
 * 
 */
package com.work.year;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.work.web.constants.Constants;
import org.work.web.exception.ServiceException;
import org.work.web.util.BCConvert;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.work.test.BaseExport;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public class Year extends BaseExport{

	private List<Bank> banks;

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public void export() {
		init();
		try {
			Statement stmt = this.getConnection().createStatement();
			String sqlString = "SELECT S.SWITCHID,S.OID ,R.RPTNAME,R.REPORTID,S.NAME,S.TEL"
					+ " FROM REPORTSWITCH AS S , REPORT AS R"
					+ " WHERE S.YEAR="+getYearString()+" AND S.REPORTID=R.REPORTID AND R.PRTYPE=1 and s.tel is not null"
					+ " ORDER BY S.OID,R.REPORTID ASC";
			ResultSet rs = stmt.executeQuery(sqlString);
			int i = 0;
			Year banks = new Year();
			Bank bank = null;
			List<Bank> banklist = new ArrayList<Bank>();
			while (rs.next()) {
				String name = rs.getString(5);
				String tel = rs.getString(6);
				int total=0;
				int totalbz=0;
				if (i % 5 == 0) {
					bank = new Bank();
					sqlString = "select * from B_ORG_INFORMATION as b left join T_PUB_BANKUSER as p on b.oid=p.oid where b.oid = "+rs.getInt(2);
					Statement stmt1 = this.getConnection().createStatement();
					ResultSet rs1 = stmt1.executeQuery(sqlString);
					if(rs1.next()){
						ReportHead reportHead = new ReportHead();
						reportHead.setFinanceNumber(BCConvert.ToDBC(rs1.getString(3)));
						reportHead.setFinanceTypeCode(rs1.getString(7));
						reportHead.setPbcCode(Constants.PBC_SHENZHENCODE);
						reportHead.setPhone("".equals(tel)?rs1.getString(30):tel);
						reportHead.setSource("0".equals(rs1.getString(25))?"F":"Z");
						reportHead.setTbrq(getYearString()+"-"+Constants.REPORT_LAST_D.get(getQuaterString()));
						reportHead.setYear(getYearString());
						reportHead.setZbr("".equals(name)?rs1.getString(27):name);
						bank.setHead(reportHead);
					}
				}
				if(rs.getInt(4)==1){
					Report1 report1 = new Report1();
					List<Row1> rows = new ArrayList<Row1>();
					sqlString = "select * from INNERCONTROL where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					Biaozhu1 biaozhu = new Biaozhu1();
					biaozhu.setValue("01");//固定设置标注为"未建立"
					while (rs2.next()) {
						Row1 row1 = new Row1();
						row1.setXgwh(rs2.getString(6));
						row1.setZdbm(rs2.getString(4));
						row1.setZdmc(rs2.getString(2));
						row1.setZdsj(rs2.getString(5));
						row1.setZynr(rs2.getString(3));
						rows.add(row1);
						total++;
					}
					if(total==0){
						biaozhu.setValue("02");//固定设置标注为"未建立"
						Row1 row1 = new Row1();
						row1.setXgwh("");
						row1.setZdbm("");
						row1.setZdmc("");
						row1.setZdsj("");
						row1.setZynr("");
						rows.add(row1);
					}
					report1.setBiaozhu(biaozhu);
					report1.setRow(rows);
					bank.setReport1(report1);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==2){
					Report2 report2 = new Report2();
					List<Row2> rows = new ArrayList<Row2>();
					sqlString = "select * from ORGANDPOST where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row2 row2 = new Row2();
						row2.setBmfzrdh(rs2.getString(6));
						row2.setBmfzrxm(rs2.getString(5));
						row2.setJgmc(rs2.getString(1));
						row2.setJzrs(rs2.getString(8));
						row2.setUnitfzrdh(rs2.getString(4));
						row2.setUnitfzrxm(rs2.getString(2));
						row2.setUnitfzrzw(rs2.getString(3));
						row2.setZzrs(rs2.getString(7));
						rows.add(row2);
						total++;
					}
					if(total==0){
						Row2 row2 = new Row2();
						row2.setBmfzrdh("");
						row2.setBmfzrxm("");
						row2.setJgmc("");
						row2.setJzrs("");
						row2.setUnitfzrdh("");
						row2.setUnitfzrxm("");
						row2.setUnitfzrzw("");
						row2.setZzrs("");
						rows.add(row2);
					}
					report2.setRow(rows);
					bank.setReport2(report2);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==3){
					Report3 report3 = new Report3();
					List<Row3> rows = new ArrayList<Row3>();
					sqlString = "select * from ACTIVE where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row3 row3 = new Row3();
						row3.setCjrs(rs2.getString(4));
						row3.setFfclfs(rs2.getString(6));
						row3.setHdsj(rs2.getString(2));
						row3.setXcfs(rs2.getString(5));
						row3.setXcnr(rs2.getString(3));
						rows.add(row3);
						total++;
					}
					if(total==0){
						Row3 row3 = new Row3();
						row3.setCjrs("");
						row3.setFfclfs("");
						row3.setHdsj("");
						row3.setXcfs("");
						row3.setXcnr("");
						rows.add(row3);
					}
					report3.setRow(rows);
					bank.setReport3(report3);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==4){
					Report4 report4 = new Report4();
					List<Row4> rows = new ArrayList<Row4>();
					sqlString = "select * from TRAIN where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row4 row4 = new Row4();
						row4.setCjrs(rs2.getString(6));
						row4.setHdsj(rs2.getString(3));
						row4.setPxdx(rs2.getString(5));
						row4.setPxfs(rs2.getString(7));
						row4.setPxnr(rs2.getString(4));
						rows.add(row4);
						total++;
					}
					if(total==0){
						Row4 row4 = new Row4();
						row4.setCjrs("");
						row4.setHdsj("");
						row4.setPxdx("");
						row4.setPxfs("");
						row4.setPxnr("");
						rows.add(row4);
					}
					report4.setRow(rows);
					bank.setReport4(report4);
					rs2.close();
					stmt2.close();
				}

				if(rs.getInt(4)==5){
					Report5 report5 = new Report5();
					Biaozhu5 biaozhu = new Biaozhu5();
					List<Row5> rows = new ArrayList<Row5>();
					sqlString = "select * from INNERAUDITFLAG where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						biaozhu.setValue1(rs2.getString(3));
						biaozhu.setValue2(rs2.getString(4));
						biaozhu.setValue3(rs2.getString(5));
						biaozhu.setValue4(rs2.getString(6));
						biaozhu.setValue5(rs2.getString(7));
						biaozhu.setValue6(rs2.getString(8));
						biaozhu.setValue7("");//TODO://报文模板与xml报文规则doc不一致
						totalbz++;
					}
					if(totalbz==0){
						biaozhu.setValue1("0");
						biaozhu.setValue2("0");
						biaozhu.setValue3("0");
						biaozhu.setValue4("0");
						biaozhu.setValue5("0");
						biaozhu.setValue6("0");
						biaozhu.setValue7("0");
					}
					sqlString = "select * from INNERAUDIT where SWITCHID = "+rs.getInt(1);
					stmt2 = this.getConnection().createStatement();
					rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row5 row5 = new Row5();
						row5.setSjbmmc(rs2.getString(2));
						row5.setSjfxdzywt(rs2.getString(5));
						row5.setSjqx(rs2.getString(3));
						row5.setSjxmmcjzynr(rs2.getString(4));
						row5.setWtzgqk(rs2.getString(6));
						rows.add(row5);
						total++;
					}
					if(total==0){
						Row5 row5 = new Row5();
						row5.setSjbmmc("");
						row5.setSjfxdzywt("");
						row5.setSjqx("");
						row5.setSjxmmcjzynr("");
						row5.setWtzgqk("");
						rows.add(row5);
					}
					report5.setBiaozhu(biaozhu);
					report5.setRow(rows);
					bank.setReport5(report5);
					rs2.close();
					stmt2.close();
				}
				if (i % 5 == 4) {
					banklist.add(bank);
				}
				i++;
			}
			banks.setBanks(banklist);

			XStream xstream = new XStream(new DomDriver());
			xstream.alias("banks", Year.class);
			xstream.alias("bank", Bank.class);
			xstream.alias("row", Row1.class);
			xstream.alias("row", Row2.class);
			xstream.alias("row", Row3.class);
			xstream.alias("row", Row4.class);
			xstream.alias("row", Row5.class);
			xstream.addImplicitCollection(Year.class, "banks");
			xstream.addImplicitCollection(Report1.class, "row");
			xstream.addImplicitCollection(Report2.class, "row");
			xstream.addImplicitCollection(Report3.class, "row");
			xstream.addImplicitCollection(Report4.class, "row");
			xstream.addImplicitCollection(Report5.class, "row");
/*			String xml = xstream.toXML(banks);
			System.out.println(xml);*/
			StringWriter sw = new StringWriter();
			xstream.marshal(banks, new CompactWriter(sw));
			String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+sw.toString();
//			outputStream = new FileOutputStream(this.getPathString());
			File file = new File(this.getPathString());
			try {
				FileUtils.writeStringToFile(file, xml,"utf-8");
			} catch (IOException e) {
				throw new ServiceException("生成文件错误");
			}
//			xstream.toXML(banks, outputStream);
			System.out.println("----报文生成成功----");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
	}


class Bank{
	private ReportHead head;
	private Report1 report1;
	private Report2 report2;
	private Report3 report3;
	private Report4 report4;
	private Report5 report5;
	public ReportHead getHead() {
		return head;
	}
	public void setHead(ReportHead head) {
		this.head = head;
	}
	public Report1 getReport1() {
		return report1;
	}
	public void setReport1(Report1 report1) {
		this.report1 = report1;
	}
	public Report2 getReport2() {
		return report2;
	}
	public void setReport2(Report2 report2) {
		this.report2 = report2;
	}
	public Report3 getReport3() {
		return report3;
	}
	public void setReport3(Report3 report3) {
		this.report3 = report3;
	}
	public Report4 getReport4() {
		return report4;
	}
	public void setReport4(Report4 report4) {
		this.report4 = report4;
	}
	public Report5 getReport5() {
		return report5;
	}
	public void setReport5(Report5 report5) {
		this.report5 = report5;
	}
	
}
class ReportHead{
	private String pbcCode;
	private String source;
	private String year;
	private String financeNumber;
	private String financeTypeCode;
	private String zbr;
	private String phone;
	private String tbrq;
	public String getPbcCode() {
		return pbcCode;
	}
	public void setPbcCode(String pbcCode) {
		this.pbcCode = pbcCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getFinanceNumber() {
		return financeNumber;
	}
	public void setFinanceNumber(String financeNumber) {
		this.financeNumber = financeNumber;
	}
	public String getFinanceTypeCode() {
		return financeTypeCode;
	}
	public void setFinanceTypeCode(String financeTypeCode) {
		this.financeTypeCode = financeTypeCode;
	}
	public String getZbr() {
		return zbr;
	}
	public void setZbr(String zbr) {
		this.zbr = zbr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTbrq() {
		return tbrq;
	}
	public void setTbrq(String tbrq) {
		this.tbrq = tbrq;
	}
	
}
class Report1{
	private Biaozhu1 biaozhu;
	private List<Row1> row;

	public List<Row1> getRow() {
		return row;
	}

	public void setRow(List<Row1> row) {
		this.row = row;
	}

	public Biaozhu1 getBiaozhu() {
		return biaozhu;
	}

	public void setBiaozhu(Biaozhu1 biaozhu) {
		this.biaozhu = biaozhu;
	}

}
class Biaozhu1{
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
class Row1{
	private String zdmc;
	private String zynr;
	private String zdbm;
	private String zdsj;
	private String xgwh;
	public String getZdmc() {
		return zdmc;
	}
	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}
	public String getZynr() {
		return zynr;
	}
	public void setZynr(String zynr) {
		this.zynr = zynr;
	}
	public String getZdbm() {
		return zdbm;
	}
	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}
	public String getZdsj() {
		return zdsj;
	}
	public void setZdsj(String zdsj) {
		this.zdsj = zdsj;
	}
	public String getXgwh() {
		return xgwh;
	}
	public void setXgwh(String xgwh) {
		this.xgwh = xgwh;
	}
	
}
class Report2{
	private List<Row2> row;

	public List<Row2> getRow() {
		return row;
	}

	public void setRow(List<Row2> row) {
		this.row = row;
	}
}
class Row2{
	private String jgmc;
	private String unitfzrxm;
	private String unitfzrzw;
	private String unitfzrdh;
	private String bmfzrxm;
	private String bmfzrdh;
	private String zzrs;
	private String jzrs;
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getUnitfzrxm() {
		return unitfzrxm;
	}
	public void setUnitfzrxm(String unitfzrxm) {
		this.unitfzrxm = unitfzrxm;
	}
	public String getUnitfzrzw() {
		return unitfzrzw;
	}
	public void setUnitfzrzw(String unitfzrzw) {
		this.unitfzrzw = unitfzrzw;
	}
	public String getUnitfzrdh() {
		return unitfzrdh;
	}
	public void setUnitfzrdh(String unitfzrdh) {
		this.unitfzrdh = unitfzrdh;
	}
	public String getBmfzrxm() {
		return bmfzrxm;
	}
	public void setBmfzrxm(String bmfzrxm) {
		this.bmfzrxm = bmfzrxm;
	}
	public String getBmfzrdh() {
		return bmfzrdh;
	}
	public void setBmfzrdh(String bmfzrdh) {
		this.bmfzrdh = bmfzrdh;
	}
	public String getZzrs() {
		return zzrs;
	}
	public void setZzrs(String zzrs) {
		this.zzrs = zzrs;
	}
	public String getJzrs() {
		return jzrs;
	}
	public void setJzrs(String jzrs) {
		this.jzrs = jzrs;
	}
	
}
class Report3{
	private List<Row3> row;

	public List<Row3> getRow() {
		return row;
	}

	public void setRow(List<Row3> row) {
		this.row = row;
	}
}
class Row3{
	private String hdsj;
	private String xcnr;
	private String cjrs;
	private String xcfs;
	private String ffclfs;
	public String getHdsj() {
		return hdsj;
	}
	public void setHdsj(String hdsj) {
		this.hdsj = hdsj;
	}
	public String getXcnr() {
		return xcnr;
	}
	public void setXcnr(String xcnr) {
		this.xcnr = xcnr;
	}
	public String getCjrs() {
		return cjrs;
	}
	public void setCjrs(String cjrs) {
		this.cjrs = cjrs;
	}
	public String getXcfs() {
		return xcfs;
	}
	public void setXcfs(String xcfs) {
		this.xcfs = xcfs;
	}
	public String getFfclfs() {
		return ffclfs;
	}
	public void setFfclfs(String ffclfs) {
		this.ffclfs = ffclfs;
	}
	
}
class Report4{
	private List<Row4> row;

	public List<Row4> getRow() {
		return row;
	}

	public void setRow(List<Row4> row) {
		this.row = row;
	}
}

class Row4{
	private String hdsj;
	private String pxnr;
	private String pxdx;
	private String cjrs;
	private String pxfs;
	public String getHdsj() {
		return hdsj;
	}
	public void setHdsj(String hdsj) {
		this.hdsj = hdsj;
	}
	public String getPxnr() {
		return pxnr;
	}
	public void setPxnr(String pxnr) {
		this.pxnr = pxnr;
	}
	public String getPxdx() {
		return pxdx;
	}
	public void setPxdx(String pxdx) {
		this.pxdx = pxdx;
	}
	public String getCjrs() {
		return cjrs;
	}
	public void setCjrs(String cjrs) {
		this.cjrs = cjrs;
	}
	public String getPxfs() {
		return pxfs;
	}
	public void setPxfs(String pxfs) {
		this.pxfs = pxfs;
	}
	
}
class Report5{
	private Biaozhu5 biaozhu;
	
	private List<Row5> row;

	public Biaozhu5 getBiaozhu() {
		return biaozhu;
	}

	public void setBiaozhu(Biaozhu5 biaozhu) {
		this.biaozhu = biaozhu;
	}

	public List<Row5> getRow() {
		return row;
	}

	public void setRow(List<Row5> row) {
		this.row = row;
	}
	
}
class Biaozhu5{
	private String value1;
	private String value2;
	private String value3;
	private String value4;
	private String value5;
	private String value6;
	private String value7;
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getValue3() {
		return value3;
	}
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	public String getValue4() {
		return value4;
	}
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	public String getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		this.value5 = value5;
	}
	public String getValue6() {
		return value6;
	}
	public void setValue6(String value6) {
		this.value6 = value6;
	}
	public String getValue7() {
		return value7;
	}
	public void setValue7(String value7) {
		this.value7 = value7;
	}
	

}

class Row5{
	private String sjbmmc;
	private String sjqx;
	private String sjxmmcjzynr;
	private String sjfxdzywt;
	private String wtzgqk;
	public String getSjbmmc() {
		return sjbmmc;
	}
	public void setSjbmmc(String sjbmmc) {
		this.sjbmmc = sjbmmc;
	}
	public String getSjqx() {
		return sjqx;
	}
	public void setSjqx(String sjqx) {
		this.sjqx = sjqx;
	}
	public String getSjxmmcjzynr() {
		return sjxmmcjzynr;
	}
	public void setSjxmmcjzynr(String sjxmmcjzynr) {
		this.sjxmmcjzynr = sjxmmcjzynr;
	}
	public String getSjfxdzywt() {
		return sjfxdzywt;
	}
	public void setSjfxdzywt(String sjfxdzywt) {
		this.sjfxdzywt = sjfxdzywt;
	}
	public String getWtzgqk() {
		return wtzgqk;
	}
	public void setWtzgqk(String wtzgqk) {
		this.wtzgqk = wtzgqk;
	}
	
}