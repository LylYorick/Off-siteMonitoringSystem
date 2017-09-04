package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Insurancebase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Insurancebase implements java.io.Serializable {

	// Fields

	private Integer siid;
	private Information BOrgInformation;
	private String lineid;
	private String cname;
	private String ctype;
	private String cctype;
	private String ccid;
	private String professional;
	private String clegal;
	private String clegaltype;
	private String clegalid;
	private Integer cpnum;
	private String ciname;
	private String citype;
	private String ciid;
	private String crelation;
	private Integer ctotal;
	private String csname;
	private String cstype;
	private String csid;
	private String cfeature;
	private Integer cmnum;
	private Double cfamt;
	private String cdes;
	private String cmethod;
	private String cother;
	private String cfile;
	private String updatetime;
	private String updateuser;
	private String cmtype;
	private String cmcid;
	private String cmname;
	private String cmperiod;
	private String cmsubject;
	private Double cmamt;
	private Double cmpay;
	private String cmmethod;
	private Set bankInsuranceDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Insurancebase() {
	}

	/** full constructor */
	public Insurancebase(Information BOrgInformation, String lineid,
			String cname, String ctype, String cctype, String ccid,
			String professional, String clegal, String clegaltype,
			String clegalid, Integer cpnum, String ciname, String citype,
			String ciid, String crelation, Integer ctotal, String csname,
			String cstype, String csid, String cfeature, Integer cmnum,
			Double cfamt, String cdes, String cmethod, String cother,
			String cfile, String updatetime, String updateuser, String cmtype,
			String cmcid, String cmname, String cmperiod, String cmsubject,
			Double cmamt, Double cmpay, String cmmethod,
			Set bankInsuranceDetails) {
		this.BOrgInformation = BOrgInformation;
		this.lineid = lineid;
		this.cname = cname;
		this.ctype = ctype;
		this.cctype = cctype;
		this.ccid = ccid;
		this.professional = professional;
		this.clegal = clegal;
		this.clegaltype = clegaltype;
		this.clegalid = clegalid;
		this.cpnum = cpnum;
		this.ciname = ciname;
		this.citype = citype;
		this.ciid = ciid;
		this.crelation = crelation;
		this.ctotal = ctotal;
		this.csname = csname;
		this.cstype = cstype;
		this.csid = csid;
		this.cfeature = cfeature;
		this.cmnum = cmnum;
		this.cfamt = cfamt;
		this.cdes = cdes;
		this.cmethod = cmethod;
		this.cother = cother;
		this.cfile = cfile;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.cmtype = cmtype;
		this.cmcid = cmcid;
		this.cmname = cmname;
		this.cmperiod = cmperiod;
		this.cmsubject = cmsubject;
		this.cmamt = cmamt;
		this.cmpay = cmpay;
		this.cmmethod = cmmethod;
		this.bankInsuranceDetails = bankInsuranceDetails;
	}

	// Property accessors

	public Integer getSiid() {
		return this.siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	public Information getBOrgInformation() {
		return this.BOrgInformation;
	}

	public void setBOrgInformation(Information BOrgInformation) {
		this.BOrgInformation = BOrgInformation;
	}

	public String getLineid() {
		return this.lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCctype() {
		return this.cctype;
	}

	public void setCctype(String cctype) {
		this.cctype = cctype;
	}

	public String getCcid() {
		return this.ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getClegal() {
		return this.clegal;
	}

	public void setClegal(String clegal) {
		this.clegal = clegal;
	}

	public String getClegaltype() {
		return this.clegaltype;
	}

	public void setClegaltype(String clegaltype) {
		this.clegaltype = clegaltype;
	}

	public String getClegalid() {
		return this.clegalid;
	}

	public void setClegalid(String clegalid) {
		this.clegalid = clegalid;
	}

	public Integer getCpnum() {
		return this.cpnum;
	}

	public void setCpnum(Integer cpnum) {
		this.cpnum = cpnum;
	}

	public String getCiname() {
		return this.ciname;
	}

	public void setCiname(String ciname) {
		this.ciname = ciname;
	}

	public String getCitype() {
		return this.citype;
	}

	public void setCitype(String citype) {
		this.citype = citype;
	}

	public String getCiid() {
		return this.ciid;
	}

	public void setCiid(String ciid) {
		this.ciid = ciid;
	}

	public String getCrelation() {
		return this.crelation;
	}

	public void setCrelation(String crelation) {
		this.crelation = crelation;
	}

	public Integer getCtotal() {
		return this.ctotal;
	}

	public void setCtotal(Integer ctotal) {
		this.ctotal = ctotal;
	}

	public String getCsname() {
		return this.csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public String getCstype() {
		return this.cstype;
	}

	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	public String getCsid() {
		return this.csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getCfeature() {
		return this.cfeature;
	}

	public void setCfeature(String cfeature) {
		this.cfeature = cfeature;
	}

	public Integer getCmnum() {
		return this.cmnum;
	}

	public void setCmnum(Integer cmnum) {
		this.cmnum = cmnum;
	}

	public Double getCfamt() {
		return this.cfamt;
	}

	public void setCfamt(Double cfamt) {
		this.cfamt = cfamt;
	}

	public String getCdes() {
		return this.cdes;
	}

	public void setCdes(String cdes) {
		this.cdes = cdes;
	}

	public String getCmethod() {
		return this.cmethod;
	}

	public void setCmethod(String cmethod) {
		this.cmethod = cmethod;
	}

	public String getCother() {
		return this.cother;
	}

	public void setCother(String cother) {
		this.cother = cother;
	}

	public String getCfile() {
		return this.cfile;
	}

	public void setCfile(String cfile) {
		this.cfile = cfile;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuser() {
		return this.updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getCmtype() {
		return this.cmtype;
	}

	public void setCmtype(String cmtype) {
		this.cmtype = cmtype;
	}

	public String getCmcid() {
		return this.cmcid;
	}

	public void setCmcid(String cmcid) {
		this.cmcid = cmcid;
	}

	public String getCmname() {
		return this.cmname;
	}

	public void setCmname(String cmname) {
		this.cmname = cmname;
	}

	public String getCmperiod() {
		return this.cmperiod;
	}

	public void setCmperiod(String cmperiod) {
		this.cmperiod = cmperiod;
	}

	public String getCmsubject() {
		return this.cmsubject;
	}

	public void setCmsubject(String cmsubject) {
		this.cmsubject = cmsubject;
	}

	public Double getCmamt() {
		return this.cmamt;
	}

	public void setCmamt(Double cmamt) {
		this.cmamt = cmamt;
	}

	public Double getCmpay() {
		return this.cmpay;
	}

	public void setCmpay(Double cmpay) {
		this.cmpay = cmpay;
	}

	public String getCmmethod() {
		return this.cmmethod;
	}

	public void setCmmethod(String cmmethod) {
		this.cmmethod = cmmethod;
	}

	@JSON(serialize = false)
	public Set getBankInsuranceDetails() {
		return this.bankInsuranceDetails;
	}

	public void setBankInsuranceDetails(Set bankInsuranceDetails) {
		this.bankInsuranceDetails = bankInsuranceDetails;
	}
	@JSON(serialize = false)
	public void getHibernateLazyInitializer(){};
}