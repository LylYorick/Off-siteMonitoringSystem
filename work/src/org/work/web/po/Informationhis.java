package org.work.web.po;

/**
 * Informationhis entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Informationhis implements java.io.Serializable {

	// Fields

	private Integer ooid;
	private Catalog BOrgCatalog;
	private Information BOrgInformation;
	private String bname;
	private String baddr;
	private String bbrchnum;
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
	private String bworknum;
	private String blastamt;
	private String blastnet;
	private String bupdatetime;
	private String bupdateuser;

	// Constructors

	/** default constructor */
	public Informationhis() {
	}

	/** full constructor */
	public Informationhis(Catalog BOrgCatalog, Information BOrgInformation,
			String bname, String baddr, String bbrchnum, String blead,
			String bleadpst, String bleadtel, String bdept, String bdeptlead,
			String bdeptleadtel, String bdeptleadphe, String bwork,
			String bworktel, String bworkphe, String bfax, String bworknum,
			String blastamt, String blastnet, String bupdatetime,
			String bupdateuser) {
		this.BOrgCatalog = BOrgCatalog;
		this.BOrgInformation = BOrgInformation;
		this.bname = bname;
		this.baddr = baddr;
		this.bbrchnum = bbrchnum;
		this.blead = blead;
		this.bleadpst = bleadpst;
		this.bleadtel = bleadtel;
		this.bdept = bdept;
		this.bdeptlead = bdeptlead;
		this.bdeptleadtel = bdeptleadtel;
		this.bdeptleadphe = bdeptleadphe;
		this.bwork = bwork;
		this.bworktel = bworktel;
		this.bworkphe = bworkphe;
		this.bfax = bfax;
		this.bworknum = bworknum;
		this.blastamt = blastamt;
		this.blastnet = blastnet;
		this.bupdatetime = bupdatetime;
		this.bupdateuser = bupdateuser;
	}

	// Property accessors

	public Integer getOoid() {
		return this.ooid;
	}

	public void setOoid(Integer ooid) {
		this.ooid = ooid;
	}

	public Catalog getBOrgCatalog() {
		return this.BOrgCatalog;
	}

	public void setBOrgCatalog(Catalog BOrgCatalog) {
		this.BOrgCatalog = BOrgCatalog;
	}

	public Information getBOrgInformation() {
		return this.BOrgInformation;
	}

	public void setBOrgInformation(Information BOrgInformation) {
		this.BOrgInformation = BOrgInformation;
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

	public String getBbrchnum() {
		return this.bbrchnum;
	}

	public void setBbrchnum(String bbrchnum) {
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

	public String getBworknum() {
		return this.bworknum;
	}

	public void setBworknum(String bworknum) {
		this.bworknum = bworknum;
	}

	public String getBlastamt() {
		return this.blastamt;
	}

	public void setBlastamt(String blastamt) {
		this.blastamt = blastamt;
	}

	public String getBlastnet() {
		return this.blastnet;
	}

	public void setBlastnet(String blastnet) {
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

}