package org.work.web.po;

/**
 * Insurancedetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Insurancedetail implements java.io.Serializable {

	// Fields

	private Long dssid;
	private Insurancebase BInsuranceBase;
	private Integer ssid;
	private String trandate;
	private String tranmethod;
	private String bname;
	private String iaccount;
	private String currency;
	private Double lamt;
	private Double fmat;
	private String rorpmethod;
	private String rorp;
	private String agname;
	private String agid;
	private String remark;

	// Constructors

	/** default constructor */
	public Insurancedetail() {
	}

	/** full constructor */
	public Insurancedetail(Insurancebase BInsuranceBase, Integer ssid,
			String trandate, String tranmethod, String bname, String iaccount,
			String currency, Double lamt, Double fmat, String rorpmethod,
			String rorp, String agname, String agid, String remark) {
		this.BInsuranceBase = BInsuranceBase;
		this.ssid = ssid;
		this.trandate = trandate;
		this.tranmethod = tranmethod;
		this.bname = bname;
		this.iaccount = iaccount;
		this.currency = currency;
		this.lamt = lamt;
		this.fmat = fmat;
		this.rorpmethod = rorpmethod;
		this.rorp = rorp;
		this.agname = agname;
		this.agid = agid;
		this.remark = remark;
	}

	// Property accessors

	public Long getDssid() {
		return this.dssid;
	}

	public void setDssid(Long dssid) {
		this.dssid = dssid;
	}

	public Insurancebase getBInsuranceBase() {
		return this.BInsuranceBase;
	}

	public void setBInsuranceBase(Insurancebase BInsuranceBase) {
		this.BInsuranceBase = BInsuranceBase;
	}

	public Integer getSsid() {
		return this.ssid;
	}

	public void setSsid(Integer ssid) {
		this.ssid = ssid;
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

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getIaccount() {
		return this.iaccount;
	}

	public void setIaccount(String iaccount) {
		this.iaccount = iaccount;
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

	public String getRorpmethod() {
		return this.rorpmethod;
	}

	public void setRorpmethod(String rorpmethod) {
		this.rorpmethod = rorpmethod;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}

}