package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Information entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Information implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Catalog BOrgCatalog;
	private String boid;
	private String bname;
	private String baddr;
	private Integer bbrchnum;
	private String blead;
	private String bleadpst;
	private String bleadtel;
	private String bdept;
	private String bdeptlead;
	private String bdeptleadtel;
	private String bdeptleadphe;
	private String bwork;
	private String bworktel;
	private String bworkphe;
	private String bfax;
	private Integer bworknum;
	private Double blastamt;
	private Double blastnet;
	private String bupdatetime;
	private String bupdateuser;
	private String bmininame;
	private String bcatid;
	private String ishead;
	private String isneed;
	private Set BOrgInformationhises = new HashSet(0);
	private Set BUploads = new HashSet(0);
	private Set BStockBases = new HashSet(0);
	private Set reportswitchs = new HashSet(0);
	private Set BBankBases = new HashSet(0);
	private Set BInsuranceBases = new HashSet(0);
	private Set BAssess = new HashSet(0);

	// Constructors
	@JSON(serialize = false)
	public Set getBAssess() {
		return BAssess;
	}

	public void setBAssess(Set assess) {
		BAssess = assess;
	}

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(Catalog BOrgCatalog, String boid, String bname,
			String baddr, Integer bbrchnum, String blead, String bleadpst,
			String bleadtel, String bdept, String bdeptlead,
			String bdeptleadtel, String bdeptleadphe, String bwork,
			String bworktel, String bworkphe, String bfax, Integer bworknum,
			Double blastamt, Double blastnet, String bupdatetime,
			String bupdateuser, Set BOrgInformationhises, Set BUploads,
			Set BStockBases, Set reportswitchs, Set BBankBases,String ishead,
			Set BInsuranceBases,String bmininame,String bcatid,String isneed) {
		this.BOrgCatalog = BOrgCatalog;
		this.boid = boid;
		this.bname = bname;
		this.baddr = baddr;
		this.ishead = ishead;
		this.bbrchnum = bbrchnum;
		this.blead = blead;
		this.bleadpst = bleadpst;
		this.bcatid = bcatid;
		this.bleadtel = bleadtel;
		this.bdept = bdept;
		this.bdeptlead = bdeptlead;
		this.bdeptleadtel = bdeptleadtel;
		this.bdeptleadphe = bdeptleadphe;
		this.isneed = isneed;
		this.bwork = bwork;
		this.bworktel = bworktel;
		this.bworkphe = bworkphe;
		this.bfax = bfax;
		this.bworknum = bworknum;
		this.blastamt = blastamt;
		this.blastnet = blastnet;
		this.bupdatetime = bupdatetime;
		this.bupdateuser = bupdateuser;
		this.bmininame = bmininame;
		this.BOrgInformationhises = BOrgInformationhises;
		this.BUploads = BUploads;
		this.BStockBases = BStockBases;
		this.reportswitchs = reportswitchs;
		this.BBankBases = BBankBases;
		this.BInsuranceBases = BInsuranceBases;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}
	@JSON(serialize = false)
	public Catalog getBOrgCatalog() {
		return this.BOrgCatalog;
	}

	public void setBOrgCatalog(Catalog BOrgCatalog) {
		this.BOrgCatalog = BOrgCatalog;
	}

	public String getBoid() {
		return this.boid;
	}

	public void setBoid(String boid) {
		this.boid = boid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBaddr() {
		return this.baddr;
	}

	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}

	public Integer getBbrchnum() {
		return this.bbrchnum;
	}

	public void setBbrchnum(Integer bbrchnum) {
		this.bbrchnum = bbrchnum;
	}

	public String getBlead() {
		return this.blead;
	}

	public void setBlead(String blead) {
		this.blead = blead;
	}

	public String getBleadpst() {
		return this.bleadpst;
	}

	public void setBleadpst(String bleadpst) {
		this.bleadpst = bleadpst;
	}

	public String getBleadtel() {
		return this.bleadtel;
	}

	public void setBleadtel(String bleadtel) {
		this.bleadtel = bleadtel;
	}

	public String getBdept() {
		return this.bdept;
	}

	public void setBdept(String bdept) {
		this.bdept = bdept;
	}

	public String getBdeptlead() {
		return this.bdeptlead;
	}

	public void setBdeptlead(String bdeptlead) {
		this.bdeptlead = bdeptlead;
	}

	public String getBdeptleadtel() {
		return this.bdeptleadtel;
	}

	public void setBdeptleadtel(String bdeptleadtel) {
		this.bdeptleadtel = bdeptleadtel;
	}

	public String getBdeptleadphe() {
		return this.bdeptleadphe;
	}

	public void setBdeptleadphe(String bdeptleadphe) {
		this.bdeptleadphe = bdeptleadphe;
	}

	public String getIsneed() {
		return isneed;
	}

	public void setIsneed(String isneed) {
		this.isneed = isneed;
	}

	public String getBwork() {
		return this.bwork;
	}

	public void setBwork(String bwork) {
		this.bwork = bwork;
	}

	public String getBworktel() {
		return this.bworktel;
	}

	public void setBworktel(String bworktel) {
		this.bworktel = bworktel;
	}

	public String getBworkphe() {
		return this.bworkphe;
	}

	public void setBworkphe(String bworkphe) {
		this.bworkphe = bworkphe;
	}

	public String getBfax() {
		return this.bfax;
	}

	public void setBfax(String bfax) {
		this.bfax = bfax;
	}

	public Integer getBworknum() {
		return this.bworknum;
	}

	public void setBworknum(Integer bworknum) {
		this.bworknum = bworknum;
	}

	public Double getBlastamt() {
		return this.blastamt;
	}

	public void setBlastamt(Double blastamt) {
		this.blastamt = blastamt;
	}

	public Double getBlastnet() {
		return this.blastnet;
	}

	public void setBlastnet(Double blastnet) {
		this.blastnet = blastnet;
	}

	public String getBupdatetime() {
		return this.bupdatetime;
	}

	public void setBupdatetime(String bupdatetime) {
		this.bupdatetime = bupdatetime;
	}

	public String getBupdateuser() {
		return this.bupdateuser;
	}

	public void setBupdateuser(String bupdateuser) {
		this.bupdateuser = bupdateuser;
	}
	@JSON(serialize = false)
	public Set getBOrgInformationhises() {
		return this.BOrgInformationhises;
	}

	public void setBOrgInformationhises(Set BOrgInformationhises) {
		this.BOrgInformationhises = BOrgInformationhises;
	}
	@JSON(serialize = false)
	public Set getBUploads() {
		return this.BUploads;
	}

	public void setBUploads(Set BUploads) {
		this.BUploads = BUploads;
	}
	@JSON(serialize = false)
	public Set getBStockBases() {
		return this.BStockBases;
	}

	public void setBStockBases(Set BStockBases) {
		this.BStockBases = BStockBases;
	}
	@JSON(serialize = false)
	public Set getReportswitchs() {
		return this.reportswitchs;
	}

	public void setReportswitchs(Set reportswitchs) {
		this.reportswitchs = reportswitchs;
	}
	@JSON(serialize = false)
	public Set getBBankBases() {
		return this.BBankBases;
	}

	public void setBBankBases(Set BBankBases) {
		this.BBankBases = BBankBases;
	}
	@JSON(serialize = false)
	public Set getBInsuranceBases() {
		return this.BInsuranceBases;
	}

	public void setBInsuranceBases(Set BInsuranceBases) {
		this.BInsuranceBases = BInsuranceBases;
	}
	@JSON(serialize = false)
	public void getHibernateLazyInitializer(){
		
	}
		public String getBmininame() {
		return this.bmininame;
	}

	public void setBmininame(String bmininame) {
		this.bmininame = bmininame;
	}

	public String getBcatid() {
		return bcatid;
	}

	public void setBcatid(String bcatid) {
		this.bcatid = bcatid;
	}

	public String getIshead() {
		return ishead;
	}

	public void setIshead(String ishead) {
		this.ishead = ishead;
	}
}