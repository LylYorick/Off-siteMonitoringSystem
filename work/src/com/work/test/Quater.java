/**
 * 
 */
package com.work.test;

import java.util.List;

/**
 * @作者 aps-dux
 * @创建日期 @{date}
 * @版本 绍兴V1.0
 */
public class Quater {

	private List<Bank> banks;

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
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