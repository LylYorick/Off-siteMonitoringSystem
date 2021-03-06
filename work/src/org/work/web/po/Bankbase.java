package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Bankbase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Bankbase implements java.io.Serializable {

	// Fields

	private Integer id;
	private Information BOrgInformation;
	private String lineid;
	private String cname;
	private String cid;
	private String ctype;
	private String cnation;
	private String cctype;
	private String ccid;
	private String clegal;
	private String clegaltype;
	private String clegalid;
	private String cperiod;
	private Integer clnum;
	private Double clamt;
	private Integer cfnum;
	private Double cfamt;
	private String cfeature;
	private String cdes;
	private String cmethod;
	private String cother;
	private String cfile;
	private String updatetime;
	private String updateuser;
	private Set bankBaseDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bankbase() {
	}

	/** full constructor */
	public Bankbase(Information BOrgInformation, String lineid, String cname,
			String cid, String ctype, String cnation, String cctype,
			String ccid, String clegal, String clegaltype, String clegalid,
			String cperiod, Integer clnum, Double clamt, Integer cfnum,
			Double cfamt, String cfeature, String cdes, String cmethod,
			String cother, String cfile, String updatetime, String updateuser,
			Set bankBaseDetails) {
		this.BOrgInformation = BOrgInformation;
		this.lineid = lineid;
		this.cname = cname;
		this.cid = cid;
		this.ctype = ctype;
		this.cnation = cnation;
		this.cctype = cctype;
		this.ccid = ccid;
		this.clegal = clegal;
		this.clegaltype = clegaltype;
		this.clegalid = clegalid;
		this.cperiod = cperiod;
		this.clnum = clnum;
		this.clamt = clamt;
		this.cfnum = cfnum;
		this.cfamt = cfamt;
		this.cfeature = cfeature;
		this.cdes = cdes;
		this.cmethod = cmethod;
		this.cother = cother;
		this.cfile = cfile;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.bankBaseDetails = bankBaseDetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCnation() {
		return this.cnation;
	}

	public void setCnation(String cnation) {
		this.cnation = cnation;
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

	public String getCperiod() {
		return this.cperiod;
	}

	public void setCperiod(String cperiod) {
		this.cperiod = cperiod;
	}

	public Integer getClnum() {
		return this.clnum;
	}

	public void setClnum(Integer clnum) {
		this.clnum = clnum;
	}

	public Double getClamt() {
		return this.clamt;
	}

	public void setClamt(Double clamt) {
		this.clamt = clamt;
	}

	public Integer getCfnum() {
		return this.cfnum;
	}

	public void setCfnum(Integer cfnum) {
		this.cfnum = cfnum;
	}

	public Double getCfamt() {
		return this.cfamt;
	}

	public void setCfamt(Double cfamt) {
		this.cfamt = cfamt;
	}

	public String getCfeature() {
		return this.cfeature;
	}

	public void setCfeature(String cfeature) {
		this.cfeature = cfeature;
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

	@JSON(serialize = false)
	public Set getBankBaseDetails() {
		return this.bankBaseDetails;
	}

	public void setBankBaseDetails(Set bankBaseDetails) {
		this.bankBaseDetails = bankBaseDetails;
	}
	@JSON(serialize = false)
	public void getHibernateLazyInitializer(){}
}