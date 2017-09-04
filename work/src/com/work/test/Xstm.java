package com.work.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.work.web.constants.Constants;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Xstm {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/*XStream xstream = new XStream(new DomDriver());
		Banks yearReport = new Banks();
		List<Bank> banks = new ArrayList<Bank>();
		Bank bank = new Bank();
		Bank bank1 = new Bank();
		ReportHead reportHead = new ReportHead();
		reportHead.setFinanceNumber("金融机构代码");
		reportHead.setFinanceTypeCode("金融机构类别代码");
		reportHead.setPbcCode("所属人行机构代码");
		reportHead.setPhone("联系电话");
		reportHead.setQuarter("季度");
		reportHead.setSource("数据来源");
		reportHead.setTbrq("填报日期");
		reportHead.setYear("年度");
		reportHead.setZbr("制表人");
		Report6 report6 = new Report6();
		List<Row6> rows = new ArrayList<Row6>();
		Row6 row6 = new Row6();
		row6.setKjhd("跨境汇兑");
		row6.setXkh("新客户");
		row6.setQtqx("其他情形");
		row6.setYcxjy("一次性交易");

		Row6 row61 = new Row6();
		row61.setKjhd("跨境汇兑");
		row61.setXkh("新客户");
		row61.setQtqx("其他情形");
		row61.setYcxjy("一次性交易");
		rows.add(row6);
		rows.add(row61);
		report6.setRow(rows);
		bank.setHead(reportHead);
		bank.setReport6(report6);
		banks.add(bank);
		banks.add(bank1);
		yearReport.setBanks(banks);

		xstream.alias("banks", Banks.class);
		xstream.alias("bank", Bank.class);
		xstream.alias("row", Row6.class);
		xstream.addImplicitCollection(Banks.class, "banks");
		xstream.addImplicitCollection(Report6.class, "row");
		String xml = xstream.toXML(yearReport);
		System.out.println(xml);*/
		Xstm xstm = new Xstm();
		xstm.setPathString("c:"+"\\"+"temp.xml");
		xstm.setQuaterString("3");
		xstm.setYearString("2010");
		xstm.quaterReport();
//		System.out.println(Constants.REPORT_LAST_D.get(xstm.getQuaterString()));
	}

	private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	private static final String DB_URL = "jdbc:db2://localhost:50000/FXQSZ";
	private static final String DB_USER = "db2admin";
	private static final String DB_PASSWORD = "fuckyou";
	private Connection connection;
	private String pathString;
	private String yearString;
	private String quaterString;
	
	public String getYearString() {
		return yearString;
	}
	public void setYearString(String yearString) {
		this.yearString = yearString;
	}
	public String getQuaterString() {
		return quaterString;
	}
	public void setQuaterString(String quaterString) {
		this.quaterString = quaterString;
	}
	public String getPathString() {
		return pathString;
	}
	public void setPathString(String pathString) {
		this.pathString = pathString;
	}
	public void init(){
		try {
			Class.forName(DB_DRIVER);
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Get DB Connection Error!");
		}
	}
	public void close(){
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Close DB Connection Error!");
		}

	}
	/*
	 * 季报： 1.首先查询报表开关表（reportswitch），筛选出季报全部上传的银行。
	 * 2.查询报表开关表，条件：银行id=上面筛选出的银行id，季度=当前季度，年份=当前年份 3.查询报表6的id，关联查询报表6的所有记录
	 * 4.查询报表7的id，关联查询报表6的所有记录.以此类推
	 */

	public void quaterReport() throws IOException {
		init();
		try {
			Statement stmt = connection.createStatement();
			String sqlString = "SELECT S.SWITCHID,S.OID ,R.RPTNAME,R.REPORTID"
					+ " FROM REPORTSWITCH AS S , REPORT AS R"
					+ " WHERE S.YEAR="+getYearString()+" AND S.QUATER="+getQuaterString()+" AND S.REPORTID=R.REPORTID AND R.PRTYPE=2"
					+ " ORDER BY S.OID,R.REPORTID ASC";
			ResultSet rs = stmt.executeQuery(sqlString);
			int i = 0;
			Quater banks = new Quater();
			Bank bank = null;
			List<Bank> banklist = new ArrayList<Bank>();
			while (rs.next()) {
				int total=0;
				if (i % 5 == 0) {
					bank = new Bank();
					sqlString = "select * from B_ORG_INFORMATION as b left join T_PUB_BANKUSER as p on b.oid=p.oid where b.oid = "+rs.getInt(2);
					Statement stmt1 = connection.createStatement();
					ResultSet rs1 = stmt1.executeQuery(sqlString);
					if(rs1.next()){
						ReportHead reportHead = new ReportHead();
						reportHead.setFinanceNumber(rs1.getString(3));
						reportHead.setFinanceTypeCode(rs1.getString(7));
						reportHead.setPbcCode(Constants.PBC_SHENZHENCODE);
						reportHead.setPhone(rs1.getString(29));
						reportHead.setQuarter(getQuaterString());
						reportHead.setSource("F");
						reportHead.setTbrq(getYearString()+"-"+Constants.REPORT_LAST_D.get(getQuaterString()));
						reportHead.setYear(getYearString());
						reportHead.setZbr(rs1.getString(35));
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
					Statement stmt2 = connection.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					if(rs2.getFetchSize()==0){
						Row6 row6 = new Row6();
						row6.setKjhd("");
						row6.setXkh("");
						row6.setQtqx("");
						row6.setYcxjy("");
						rows.add(row6);
					}else{
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
							
						}
					}
					report6.setRow(rows);
					bank.setReport6(report6);
				}
				if(rs.getInt(4)==7){
					Report7 report7 = new Report7();
					List<Row7> rows = new ArrayList<Row7>();
					sqlString = "select * from IDENTITY_RSB where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = connection.createStatement();
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
						Row7 row7 = new Row7();
						row7.setDgkhsjsyd("");
						row7.setDgkhzs("");
						row7.setDskhfjm("");
						row7.setDskhjm("");
						row7.setDskhzs("");
						rows.add(row7);
					}
					report7.setRow(rows);
					bank.setReport7(report7);
				}
				if(rs.getInt(4)==8){
					Report8 report8 = new Report8();
					List<Row8> rows = new ArrayList<Row8>();
					sqlString = "select * from IDENTITY_KY where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = connection.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						Row8 row8 = new Row8();
						row8.setKhjyxwkys(rs2.getString(3));
						row8.setKhsfkys(rs2.getString(4));
						row8.setXeysycxfwkys(rs2.getString(5));
						row8.setXjywkys(rs2.getString(6));
						rows.add(row8);
						total++;
					}
					if(total==0){
						Row8 row8 = new Row8();
						row8.setKhjyxwkys("");
						row8.setKhsfkys("");
						row8.setXeysycxfwkys("");
						row8.setXjywkys("");
						rows.add(row8);
					}
					report8.setRow(rows);
					bank.setReport8(report8);
				}
				if(rs.getInt(4)==9){
					Report9 report9 = new Report9();
					Biaozhu9 biaozhu = new Biaozhu9();
					List<Row9> rows = new ArrayList<Row9>();
					sqlString = "select * from SUSREPORTFLAG where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = connection.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sqlString);
					while (rs2.next()) {
						biaozhu.setValue1(rs2.getString(3));
						biaozhu.setValue2(rs2.getString(4));
						biaozhu.setValue3(rs2.getString(5));
						biaozhu.setValue4(rs2.getString(6));
					}
					sqlString = "select * from SUSREPORT where SWITCHID = "+rs.getInt(1);
					stmt2 = connection.createStatement();
					rs2 = stmt2.executeQuery(sqlString);
					if(rs2.getFetchSize()==0){
						Row9 row9 = new Row9();
						row9.setDqdwkyjybgfs("");
						row9.setDqdwkyjybgje("");
						row9.setDqgrkyjybgfs("");
						row9.setDqgrkyjybgje("");
						row9.setGajgfkqk("");
						row9.setXddgabgddwkyjybgfs("");
						row9.setXddgabgddwkyjybgje("");
						row9.setXddgabgdgrkyjybgfs("");
						row9.setXddgabgdgrkyjybgje("");
						rows.add(row9);
					}else{
						while (rs2.next()) {
							for(int j=0;j<rs2.getMetaData().getColumnCount()-2;j++){
								if(j%9==0){
									Row9 row9 = new Row9();
									row9.setDqdwkyjybgfs(rs2.getString(j+3));
									row9.setDqdwkyjybgje(rs2.getString(j+4));
									row9.setDqgrkyjybgfs(rs2.getString(j+5));
									row9.setDqgrkyjybgje(rs2.getString(j+6));
									row9.setGajgfkqk(rs2.getString(j+7));
									row9.setXddgabgddwkyjybgfs(rs2.getString(j+8));
									row9.setXddgabgddwkyjybgje(rs2.getString(j+9));
									row9.setXddgabgdgrkyjybgfs(rs2.getString(j+10));
									row9.setXddgabgdgrkyjybgje(rs2.getString(j+11));
									rows.add(row9);
								}
							}
						}
					}
					report9.setBiaozhu(biaozhu);
					report9.setRow(rows);
					bank.setReport9(report9);
				}

				if(rs.getInt(4)==10){
					Report10 report10 = new Report10();
					List<Row10> rows = new ArrayList<Row10>();
					sqlString = "select * from BLOWFLAG where SWITCHID = "+rs.getInt(1);
					Statement stmt2 = connection.createStatement();
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
					}
					sqlString = "select * from PUBLICS where SWITCHID = "+rs.getInt(1);
					stmt2 = connection.createStatement();
					rs2 = stmt2.executeQuery(sqlString);
					if(rs2.getFetchSize()==0){
						Row10 row10 = new Row10();
						row10.setBxzbm("");
						row10.setXg("");
						row10.setXzdw("");
						row10.setXznr("");
						row10.setXzsj("");
						rows.add(row10);
					}else{
						while (rs2.next()) {
							Row10 row10 = new Row10();
							row10.setBxzbm(rs2.getString(3));
							row10.setXg(rs2.getString(4));
							row10.setXzdw(rs2.getString(5));
							row10.setXznr(rs2.getString(6));
							row10.setXzsj(rs2.getString(7));
							rows.add(row10);
						}
					}
					report10.setRow(rows);
					bank.setReport10(report10);
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
			String xml="<?xml version=\"1.0\" encoding=\"GB2312\"?>\n"+xstream.toXML(banks);
//			outputStream = new FileOutputStream(this.getPathString());
			File file = new File(this.getPathString());
			FileUtils.writeStringToFile(file, xml);
//			xstream.toXML(banks, outputStream);
			System.out.println("----报文生成成功----");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}
}
