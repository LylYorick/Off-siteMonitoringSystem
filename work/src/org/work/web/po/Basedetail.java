package org.work.web.po;

/**
 * Basedetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Basedetail implements java.io.Serializable {

	// Fields

	private Long did;
	private Bankbase BBankBase;
	private String bname;
	private String account;
	private String trandate;
	private String tranmethod;
	private String fid;
	private String rorp;
	private String use;
	private String ooname;
	private String ooid;
	private String otaccount;
	private String ottype;
	private String otid;
	private String otname;
	private String currency;
	private Double lamt;
	private Double fmat;
	private String tid;
	private String agname;
	private String agid;
	private String remark;

	// Constructors

	/** default constructor */
	public Basedetail() {
	}

	/** full constructor */
	public Basedetail(Bankbase BBankBase, String bname, String account,
			String trandate, String tranmethod, String fid, String rorp,
			String use, String ooname, String ooid, String otaccount,
			String ottype, String otid, String otname, String currency,
			Double lamt, Double fmat, String tid, String agname, String agid,
			String remark) {
		this.BBankBase = BBankBase;
		this.bname = bname;
		this.account = account;
		this.trandate = trandate;
		this.tranmethod = tranmethod;
		this.fid = fid;
		this.rorp = rorp;
		this.use = use;
		this.ooname = ooname;
		this.ooid = ooid;
		this.otaccount = otaccount;
		this.ottype = ottype;
		this.otid = otid;
		this.otname = otname;
		this.currency = currency;
		this.lamt = lamt;
		this.fmat = fmat;
		this.tid = tid;
		this.agname = agname;
		this.agid = agid;
		this.remark = remark;
	}

	// Property accessors

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Bankbase getBBankBase() {
		return this.BBankBase;
	}

	public void setBBankBase(Bankbase BBankBase) {
		this.BBankBase = BBankBase;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getRorp() {
		return this.rorp;
	}

	public void setRorp(String rorp) {
		this.rorp = rorp;
	}

	public String getUse() {
		return this.use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getOoname() {
		return this.ooname;
	}

	public void setOoname(String ooname) {
		this.ooname = ooname;
	}

	public String getOoid() {
		return this.ooid;
	}

	public void setOoid(String ooid) {
		this.ooid = ooid;
	}

	public String getOtaccount() {
		return this.otaccount;
	}

	public void setOtaccount(String otaccount) {
		this.otaccount = otaccount;
	}

	public String getOttype() {
		return this.ottype;
	}

	public void setOttype(String ottype) {
		this.ottype = ottype;
	}

	public String getOtid() {
		return this.otid;
	}

	public void setOtid(String otid) {
		this.otid = otid;
	}

	public String getOtname() {
		return this.otname;
	}

	public void setOtname(String otname) {
		this.otname = otname;
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

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}

}