/**
 * 
 */
package com.work.quater;

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
public class Quater extends BaseExport{

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
					+ " WHERE S.YEAR="+getYearString()+" AND S.QUATER="+getQuaterString()+" AND S.REPORTID=R.REPORTID AND R.PRTYPE=2 and s.tel is not null"
					+ " ORDER BY S.OID,R.REPORTID ASC";
			ResultSet rs = stmt.executeQuery(sqlString);
			int i = 0;
			Quater banks = new Quater();
			Bank bank = null;
			List<Bank> banklist = new ArrayList<Bank>();
			while (rs.next()) {
				String name = rs.getString(5);
				String tel = rs.getString(6);
				int total=0;
				int totalbz=0;
				System.out.println(i);
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
						reportHead.setQuarter(getQuaterString());
						reportHead.setSource("0".equals(rs1.getString(25))?"F":"Z");
						reportHead.setTbrq(getYearString()+"-"+Constants.REPORT_LAST_D.get(getQuaterString()));
						reportHead.setPhone("".equals(tel)||tel==null?BCConvert.ToDBC(rs1.getString(30)):BCConvert.ToDBC(tel));
						reportHead.setYear(getYearString());
						reportHead.setZbr("".equals(name)||name==null?BCConvert.ToDBC(rs1.getString(27).trim()):BCConvert.ToDBC(name.trim()));
						bank.setHead(reportHead);
					}
				}
				// if reportid=6
				// sql ="select * from 识别客户表 where id= 报表开关表id"
				// if (list.size()==0) 标注成0报告
				// for(iterator it=list.iterator;it.hasNext());
				//
				if(rs.getInt(4)==6){
					Report6 report6 = new Report6();
					List<Row6> rows = new ArrayList<Row6>();
					sqlString = "select * from IDENTITY_SB where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						for(int j=0;j<rs2.getMetaData().getColumnCount()-2;j++){
							if(j%4==0){
								Row6 row6 = new Row6();
								row6.setKjhd(rs2.getString(j+3));
								row6.setXkh(rs2.getString(j+4));
								row6.setQtqx(rs2.getString(j+5));
								row6.setYcxjy(rs2.getString(j+6));
								rows.add(row6);
							}
						}
						total++;
					}
					if(total==0){
						for(int j=0;j<108;j++){
							if(j%4==0){
								Row6 row6 = new Row6();
								row6.setKjhd("0");
								row6.setXkh("0");
								row6.setQtqx("0");
								row6.setYcxjy("0");
								rows.add(row6);
							}
						}
					}
					report6.setRow(rows);
					bank.setReport6(report6);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==7){
					Report7 report7 = new Report7();
					List<Row7> rows = new ArrayList<Row7>();
					sqlString = "select * from IDENTITY_RSB where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						for(int j=0;j<rs2.getMetaData().getColumnCount()-2;j++){
							if(j%5==0){
								Row7 row7 = new Row7();
								row7.setDgkhsjsyd(rs2.getString(j+3));
								row7.setDgkhzs(rs2.getString(j+4));
								row7.setDskhfjm(rs2.getString(j+5));
								row7.setDskhjm(rs2.getString(j+6));
								row7.setDskhzs(rs2.getString(j+7));
								rows.add(row7);
							}
						}
						total++;
					}
					if(total==0){
						for(int j=0;j<70;j++){
							if(j%5==0){
								Row7 row7 = new Row7();
								row7.setDgkhsjsyd("0");
								row7.setDgkhzs("0");
								row7.setDskhfjm("0");
								row7.setDskhjm("0");
								row7.setDskhzs("0");
								rows.add(row7);
							}
						}
					}
					report7.setRow(rows);
					bank.setReport7(report7);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==8){
					Report8 report8 = new Report8();
					List<Row8> rows = new ArrayList<Row8>();
					sqlString = "select * from IDENTITY_KY where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row8 row8 = new Row8();
						row8.setKhjyxwkys(rs2.getString(6));
						row8.setKhsfkys(rs2.getString(5));
						row8.setXeysycxfwkys(rs2.getString(4));
						row8.setXjywkys(rs2.getString(3));
						rows.add(row8);
						total++;
					}
					if(total==0){
						Row8 row8 = new Row8();
						row8.setKhjyxwkys("0");
						row8.setKhsfkys("0");
						row8.setXeysycxfwkys("0");
						row8.setXjywkys("0");
						rows.add(row8);
					}
					report8.setRow(rows);
					bank.setReport8(report8);
					rs2.close();
					stmt2.close();
				}
				if(rs.getInt(4)==9){
					Report9 report9 = new Report9();
					Biaozhu9 biaozhu = new Biaozhu9();
					List<Row9> rows = new ArrayList<Row9>();
					sqlString = "select * from SUSREPORTFLAG where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						biaozhu.setValue1(rs2.getString(3));
						biaozhu.setValue2(rs2.getString(4));
						biaozhu.setValue3(rs2.getString(5));
						biaozhu.setValue4(rs2.getString(6));
						totalbz++;
					}
					if(totalbz==0){
						biaozhu.setValue1("0");
						biaozhu.setValue2("0");
						biaozhu.setValue3("0");
						biaozhu.setValue4("0");
					}
					sqlString = "select * from SUSREPORT where SWITCHID = "+rs.getInt(1);
					stmt2 = this.getConnection().createStatement();
					rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						for(int j=0;j<rs2.getMetaData().getColumnCount()-2;j++){
							if(j%9==0){
								Row9 row9 = new Row9();
								row9.setDqdwkyjybgfs(rs2.getString(j+3));
								row9.setDqdwkyjybgje(rs2.getString(j+4));
								row9.setDqgrkyjybgfs(rs2.getString(j+5));
								row9.setDqgrkyjybgje(rs2.getString(j+6));
								row9.setGajgfkqk(BCConvert.ToDBC(rs2.getString(j+11).trim()));
								row9.setXddgabgddwkyjybgfs(rs2.getString(j+7));
								row9.setXddgabgddwkyjybgje(rs2.getString(j+8));
								row9.setXddgabgdgrkyjybgfs(rs2.getString(j+9));
								row9.setXddgabgdgrkyjybgje(rs2.getString(j+10));
								rows.add(row9);
							}
						}
						total++;
					}
					if(total==0){
						for(int j=0;j<18;j++){
							if(j%9==0){
								Row9 row9 = new Row9();
								row9.setDqdwkyjybgfs("0");
								row9.setDqdwkyjybgje("0");
								row9.setDqgrkyjybgfs("0");
								row9.setDqgrkyjybgje("0");
								row9.setGajgfkqk("无");
								row9.setXddgabgddwkyjybgfs("0");
								row9.setXddgabgddwkyjybgje("0");
								row9.setXddgabgdgrkyjybgfs("0");
								row9.setXddgabgdgrkyjybgje("0");
								rows.add(row9);
							}
						}
					}
					report9.setBiaozhu(biaozhu);
					report9.setRow(rows);
					bank.setReport9(report9);
					rs2.close();
					stmt2.close();
				}

				if(rs.getInt(4)==10){
					Report10 report10 = new Report10();
					List<Row10> rows = new ArrayList<Row10>();
					sqlString = "select * from BLOWFLAG where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = this.getConnection().createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Biaozhu10 biaozhu = new Biaozhu10();
						Biaozhu10a biaozhu1 = new Biaozhu10a();
						Biaozhu10b biaozhu2 = new Biaozhu10b();
						Biaozhu10c biaozhu3 = new Biaozhu10c();
						biaozhu1.setValue1(rs2.getString(3));
						biaozhu2.setValue1(rs2.getString(4));
						biaozhu2.setValue2(rs2.getString(5));
						biaozhu2.setValue3(rs2.getString(6));
						biaozhu2.setValue4(rs2.getString(7));
						biaozhu3.setValue1(rs2.getString(8));
						biaozhu3.setValue2(rs2.getString(9));
						biaozhu3.setValue3(rs2.getString(10));
						biaozhu3.setValue4(rs2.getString(11));
						biaozhu.setBiaozhu1(biaozhu1);
						biaozhu.setBiaozhu2(biaozhu2);
						biaozhu.setBiaozhu3(biaozhu3);
						report10.setBiaozhu(biaozhu);
						totalbz++;
					}
					if(totalbz==0){
						Biaozhu10 biaozhu = new Biaozhu10();
						Biaozhu10a biaozhu1 = new Biaozhu10a();
						Biaozhu10b biaozhu2 = new Biaozhu10b();
						Biaozhu10c biaozhu3 = new Biaozhu10c();
						biaozhu1.setValue1("0");
						biaozhu2.setValue1("0");
						biaozhu2.setValue2("0");
						biaozhu2.setValue3("0");
						biaozhu2.setValue4("0");
						biaozhu3.setValue1("0");
						biaozhu3.setValue2("0");
						biaozhu3.setValue3("0");
						biaozhu3.setValue4("0");
						biaozhu.setBiaozhu1(biaozhu1);
						biaozhu.setBiaozhu2(biaozhu2);
						biaozhu.setBiaozhu3(biaozhu3);
						report10.setBiaozhu(biaozhu);
					}
					sqlString = "select * from PUBLICS where SWITCHID = "+rs.getInt(1);
					stmt2 = this.getConnection().createStatement();
					rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row10 row10 = new Row10();
						row10.setBxzbm(BCConvert.ToDBC(rs2.getString(3).trim()));
						row10.setXg(BCConvert.ToDBC(null==rs2.getString(6)?"空":rs2.getString(6)));
						row10.setXzdw("公安机关".equals(rs2.getString(7))?"1":"2");
						row10.setXznr(BCConvert.ToDBC(rs2.getString(5).trim()));
						row10.setXzsj(BCConvert.ToDBC(rs2.getString(4).trim()));
						rows.add(row10);
						total++;
						System.out.println(total);
					}
					if(total==0){
						Row10 row10 = new Row10();
						row10.setBxzbm("");
						row10.setXg("");
						row10.setXzdw("");
						row10.setXznr("");
						row10.setXzsj("");
						rows.add(row10);
					}
					report10.setRow(rows);
					bank.setReport10(report10);
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
			xstream.alias("banks", Quater.class);
			xstream.alias("bank", Bank.class);
			xstream.alias("row", Row6.class);
			xstream.alias("row", Row7.class);
			xstream.alias("row", Row8.class);
			xstream.alias("row", Row9.class);
			xstream.alias("row", Row10.class);
			xstream.addImplicitCollection(Quater.class, "banks");
			xstream.addImplicitCollection(Report6.class, "row");
			xstream.addImplicitCollection(Report7.class, "row");
			xstream.addImplicitCollection(Report8.class, "row");
			xstream.addImplicitCollection(Report9.class, "row");
			xstream.addImplicitCollection(Report10.class, "row");
/*			String xml = xstream.toXML(banks);
			System.out.println(xml);*/
			StringWriter sw = new StringWriter();
			xstream.marshal(banks, new CompactWriter(sw));
			String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+sw.toString();
//			outputStream = new FileOutputStream(this.getPathString());
			File file = new File(this.getPathString());
			try {
				FileUtils.writeStringToFile(file, xml,"UTF-8");
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
	private Report6 report6;
	private Report7 report7;
	private Report8 report8;
	private Report9 report9;
	private Report10 report10;
	public ReportHead getHead() {
		return head;
	}
	public void setHead(ReportHead head) {
		this.head = head;
	}
	public Report6 getReport6() {
		return report6;
	}
	public void setReport6(Report6 report6) {
		this.report6 = report6;
	}
	public Report7 getReport7() {
		return report7;
	}
	public void setReport7(Report7 report7) {
		this.report7 = report7;
	}
	public Report8 getReport8() {
		return report8;
	}
	public void setReport8(Report8 report8) {
		this.report8 = report8;
	}
	public Report9 getReport9() {
		return report9;
	}
	public void setReport9(Report9 report9) {
		this.report9 = report9;
	}
	
	public Report10 getReport10() {
		return report10;
	}
	public void setReport10(Report10 report10) {
		this.report10 = report10;
	}
	
}
class ReportHead{
	private String pbcCode;
	private String source;
	private String year;
	private String quarter;
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
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
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
class Report6{
	private List<Row6> row;

	public List<Row6> getRow() {
		return row;
	}

	public void setRow(List<Row6> row) {
		this.row = row;
	}

}
class Row6{
	private String xkh;
	private String ycxjy;
	private String kjhd;
	private String qtqx;
	public String getXkh() {
		return xkh;
	}
	public void setXkh(String xkh) {
		this.xkh = xkh;
	}
	public String getYcxjy() {
		return ycxjy;
	}
	public void setYcxjy(String ycxjy) {
		this.ycxjy = ycxjy;
	}
	public String getKjhd() {
		return kjhd;
	}
	public void setKjhd(String kjhd) {
		this.kjhd = kjhd;
	}
	public String getQtqx() {
		return qtqx;
	}
	public void setQtqx(String qtqx) {
		this.qtqx = qtqx;
	}
	
}
class Report7{
	private List<Row7> row;

	public List<Row7> getRow() {
		return row;
	}

	public void setRow(List<Row7> row) {
		this.row = row;
	}
}
class Row7{
	private String dgkhzs;
	private String dgkhsjsyd;
	private String dskhzs;
	private String dskhjm;
	private String dskhfjm;
	public String getDgkhzs() {
		return dgkhzs;
	}
	public void setDgkhzs(String dgkhzs) {
		this.dgkhzs = dgkhzs;
	}
	public String getDgkhsjsyd() {
		return dgkhsjsyd;
	}
	public void setDgkhsjsyd(String dgkhsjsyd) {
		this.dgkhsjsyd = dgkhsjsyd;
	}
	public String getDskhzs() {
		return dskhzs;
	}
	public void setDskhzs(String dskhzs) {
		this.dskhzs = dskhzs;
	}
	public String getDskhjm() {
		return dskhjm;
	}
	public void setDskhjm(String dskhjm) {
		this.dskhjm = dskhjm;
	}
	public String getDskhfjm() {
		return dskhfjm;
	}
	public void setDskhfjm(String dskhfjm) {
		this.dskhfjm = dskhfjm;
	}
	
}
class Report8{
	private List<Row8> row;

	public List<Row8> getRow() {
		return row;
	}

	public void setRow(List<Row8> row) {
		this.row = row;
	}
}
class Row8{
	private String xjywkys;
	private String xeysycxfwkys;
	private String khsfkys;
	private String khjyxwkys;
	public String getXjywkys() {
		return xjywkys;
	}
	public void setXjywkys(String xjywkys) {
		this.xjywkys = xjywkys;
	}
	public String getXeysycxfwkys() {
		return xeysycxfwkys;
	}
	public void setXeysycxfwkys(String xeysycxfwkys) {
		this.xeysycxfwkys = xeysycxfwkys;
	}
	public String getKhsfkys() {
		return khsfkys;
	}
	public void setKhsfkys(String khsfkys) {
		this.khsfkys = khsfkys;
	}
	public String getKhjyxwkys() {
		return khjyxwkys;
	}
	public void setKhjyxwkys(String khjyxwkys) {
		this.khjyxwkys = khjyxwkys;
	}
	
}
class Report9{
	private Biaozhu9 biaozhu;
	
	private List<Row9> row;

	public List<Row9> getRow() {
		return row;
	}

	public void setRow(List<Row9> row) {
		this.row = row;
	}

	public Biaozhu9 getBiaozhu() {
		return biaozhu;
	}

	public void setBiaozhu(Biaozhu9 biaozhu) {
		this.biaozhu = biaozhu;
	}
	
}
class Biaozhu9{
	private String value1;
	private String value2;
	private String value3;
	private String value4;
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
	
}
class Row9{
	private String dqdwkyjybgfs;
	private String dqdwkyjybgje;
	private String dqgrkyjybgfs;
	private String dqgrkyjybgje;
	private String xddgabgddwkyjybgfs;
	private String xddgabgddwkyjybgje;
	private String xddgabgdgrkyjybgfs;
	private String xddgabgdgrkyjybgje;
	private String gajgfkqk;
	public String getDqdwkyjybgfs() {
		return dqdwkyjybgfs;
	}
	public void setDqdwkyjybgfs(String dqdwkyjybgfs) {
		this.dqdwkyjybgfs = dqdwkyjybgfs;
	}
	public String getDqdwkyjybgje() {
		return dqdwkyjybgje;
	}
	public void setDqdwkyjybgje(String dqdwkyjybgje) {
		this.dqdwkyjybgje = dqdwkyjybgje;
	}
	public String getDqgrkyjybgfs() {
		return dqgrkyjybgfs;
	}
	public void setDqgrkyjybgfs(String dqgrkyjybgfs) {
		this.dqgrkyjybgfs = dqgrkyjybgfs;
	}
	public String getDqgrkyjybgje() {
		return dqgrkyjybgje;
	}
	public void setDqgrkyjybgje(String dqgrkyjybgje) {
		this.dqgrkyjybgje = dqgrkyjybgje;
	}
	public String getXddgabgddwkyjybgfs() {
		return xddgabgddwkyjybgfs;
	}
	public void setXddgabgddwkyjybgfs(String xddgabgddwkyjybgfs) {
		this.xddgabgddwkyjybgfs = xddgabgddwkyjybgfs;
	}
	public String getXddgabgddwkyjybgje() {
		return xddgabgddwkyjybgje;
	}
	public void setXddgabgddwkyjybgje(String xddgabgddwkyjybgje) {
		this.xddgabgddwkyjybgje = xddgabgddwkyjybgje;
	}
	public String getXddgabgdgrkyjybgfs() {
		return xddgabgdgrkyjybgfs;
	}
	public void setXddgabgdgrkyjybgfs(String xddgabgdgrkyjybgfs) {
		this.xddgabgdgrkyjybgfs = xddgabgdgrkyjybgfs;
	}
	public String getXddgabgdgrkyjybgje() {
		return xddgabgdgrkyjybgje;
	}
	public void setXddgabgdgrkyjybgje(String xddgabgdgrkyjybgje) {
		this.xddgabgdgrkyjybgje = xddgabgdgrkyjybgje;
	}
	public String getGajgfkqk() {
		return gajgfkqk;
	}
	public void setGajgfkqk(String gajgfkqk) {
		this.gajgfkqk = gajgfkqk;
	}
	
}
class Report10{
	private Biaozhu10 biaozhu;
	
	private List<Row10> row;

	public Biaozhu10 getBiaozhu() {
		return biaozhu;
	}

	public void setBiaozhu(Biaozhu10 biaozhu) {
		this.biaozhu = biaozhu;
	}

	public List<Row10> getRow() {
		return row;
	}

	public void setRow(List<Row10> row) {
		this.row = row;
	}
	
}
class Biaozhu10{
	private Biaozhu10a biaozhu1;
	private Biaozhu10b biaozhu2;
	private Biaozhu10c biaozhu3;
	public Biaozhu10a getBiaozhu1() {
		return biaozhu1;
	}
	public void setBiaozhu1(Biaozhu10a biaozhu1) {
		this.biaozhu1 = biaozhu1;
	}
	public Biaozhu10b getBiaozhu2() {
		return biaozhu2;
	}
	public void setBiaozhu2(Biaozhu10b biaozhu2) {
		this.biaozhu2 = biaozhu2;
	}
	public Biaozhu10c getBiaozhu3() {
		return biaozhu3;
	}
	public void setBiaozhu3(Biaozhu10c biaozhu3) {
		this.biaozhu3 = biaozhu3;
	}
	
}
class Biaozhu10a{
	private String value1;

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
}
class Biaozhu10b{
	private String value1;
	private String value2;
	private String value3;
	private String value4;
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
	
}
class Biaozhu10c{
	private String value1;
	private String value2;
	private String value3;
	private String value4;
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
	
}
class Row10{
	private String bxzbm;
	private String xzsj;
	private String xznr;
	private String xg;
	private String xzdw;
	public String getBxzbm() {
		return bxzbm;
	}
	public void setBxzbm(String bxzbm) {
		this.bxzbm = bxzbm;
	}
	public String getXzsj() {
		return xzsj;
	}
	public void setXzsj(String xzsj) {
		this.xzsj = xzsj;
	}
	public String getXznr() {
		return xznr;
	}
	public void setXznr(String xznr) {
		this.xznr = xznr;
	}
	public String getXg() {
		return xg;
	}
	public void setXg(String xg) {
		this.xg = xg;
	}
	public String getXzdw() {
		return xzdw;
	}
	public void setXzdw(String xzdw) {
		this.xzdw = xzdw;
	}
	
}