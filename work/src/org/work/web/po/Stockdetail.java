package org.work.web.po;

/**
 * Stockdetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Stockdetail implements java.io.Serializable {

	// Fields

	private Long dsid;
	private Stockbase BStockBase;
	private String bname;
	private String stockaccount;
	private String moneyaccount;
	private String payaccount;
	private String trandate;
	private String tranmethod;
	private String ttype;
	private String tid;
	private String currency;
	private Double lamt;
	private Double fmat;
	private String rorp;
	private String rorpmtd;
	private String agname;
	private String agid;
	private String remark;

	// Constructors

	/** default constructor */
	public Stockdetail() {
	}

	/** full constructor */
	public Stockdetail(Stockbase BStockBase, String bname, String stockaccount,
			String moneyaccount, String payaccount, String trandate,
			String tranmethod, String ttype, String tid, String currency,
			Double lamt, Double fmat, String rorp, String agname, String agid,String rorpmtd,
			String remark) {
		this.BStockBase = BStockBase;
		this.bname = bname;
		this.stockaccount = stockaccount;
		this.moneyaccount = moneyaccount;
		this.payaccount = payaccount;
		this.trandate = trandate;
		this.tranmethod = tranmethod;
		this.ttype = ttype;
		this.tid = tid;
		this.currency = currency;
		this.lamt = lamt;
		this.fmat = fmat;
		this.rorp = rorp;
		this.agname = agname;
		this.rorpmtd=rorpmtd;
		this.agid = agid;
		this.remark = remark;
	}

	// Property accessors

	public Long getDsid() {
		return this.dsid;
	}

	public void setDsid(Long dsid) {
		this.dsid = dsid;
	}

	public Stockbase getBStockBase() {
		return this.BStockBase;
	}

	public void setBStockBase(Stockbase BStockBase) {
		this.BStockBase = BStockBase;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getStockaccount() {
		return this.stockaccount;
	}

	public void setStockaccount(String stockaccount) {
		this.stockaccount = stockaccount;
	}

	public String getMoneyaccount() {
		return this.moneyaccount;
	}

	public void setMoneyaccount(String moneyaccount) {
		this.moneyaccount = moneyaccount;
	}

	public String getPayaccount() {
		return this.payaccount;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	public String getTrandate() {
		return this.trandate;
	}

	public void setTrandate(String trandate) {
		this.trandate = trandate;
	}

	public String getTranmethod() {
		return this.tranmethod;
	}

	public void setTranmethod(String tranmethod) {
		this.tranmethod = tranmethod;
	}

	public String getTtype() {
		return this.ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getLamt() {
		return this.lamt;
	}

	public void setLamt(Double lamt) {
		this.lamt = lamt;
	}

	public Double getFmat() {
		return this.fmat;
	}

	public void setFmat(Double fmat) {
		this.fmat = fmat;
	}

	public String getRorp() {
		return this.rorp;
	}

	public void setRorp(String rorp) {
		this.rorp = rorp;
	}

	public String getAgname() {
		return this.agname;
	}

	public void setAgname(String agname) {
		this.agname = agname;
	}

	public String getAgid() {
		return this.agid;
	}

	public void setAgid(String agid) {
		this.agid = agid;
	}

	public String getRemark() {
		return this.remark;
	}

	public String getRorpmtd() {
		return rorpmtd;
	}

	public void setRorpmtd(String rorpmtd) {
		this.rorpmtd = rorpmtd;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}