package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Reportswitch entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Reportswitch implements java.io.Serializable {

	// Fields

	private Integer switchid;
	private Report report;
	private Information BOrgInformation;
	private Integer year;
	private Integer quater;
	private String updatetime;
	private String updateuser;
	private String tel;
	private String isreport;
	private String name;
	private String status;
	private Set susreportflags = new HashSet(0);
	private Set train = new HashSet(0);
	private Set identityKies = new HashSet(0);
	private Set identitySbs = new HashSet(0);
	private Set actives = new HashSet(0);
	private Set organdposts = new HashSet(0);
	private Set innerauditflags = new HashSet(0);
	private Set innercontrols = new HashSet(0);
	private Set susreports = new HashSet(0);
	private Set inneraudits = new HashSet(0);
	private Set innerflags = new HashSet(0);
	private Set publicses = new HashSet(0);
	private Set blowflags = new HashSet(0);
	private Set identityRsbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Reportswitch() {
	}

	/** full constructor */
	public Reportswitch(Report report, Information BOrgInformation,
			Integer year, Integer quater, String updatetime, String updateuser,
			String status, Set susreportflags, Set identityKies,String name,String tel,String isreport,
			Set identitySbs, Set actives, Set organdposts, Set innerauditflags,
			Set innercontrols, Set susreports, Set inneraudits, Set innerflags,Set train,
			Set publicses, Set blowflags, Set identityRsbs) {
		this.report = report;
		this.BOrgInformation = BOrgInformation;
		this.year = year;
		this.quater = quater;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.status = status;
		this.susreportflags = susreportflags;
		this.identityKies = identityKies;
		this.identitySbs = identitySbs;
		this.actives = actives;
		this.organdposts = organdposts;
		this.innerauditflags = innerauditflags;
		this.innercontrols = innercontrols;
		this.susreports = susreports;
		this.inneraudits = inneraudits;
		this.innerflags = innerflags;
		this.publicses = publicses;
		this.train=train;
		this.blowflags = blowflags;
		this.identityRsbs = identityRsbs;
		this.name=name;
		this.tel=tel;
		this.isreport = isreport;
	}

	// Property accessors

	public Integer getSwitchid() {
		return this.switchid;
	}

	public void setSwitchid(Integer switchid) {
		this.switchid = switchid;
	}
	@JSON(serialize = false)
	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Information getBOrgInformation() {
		return this.BOrgInformation;
	}

	public void setBOrgInformation(Information BOrgInformation) {
		this.BOrgInformation = BOrgInformation;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getQuater() {
		return this.quater;
	}

	public void setQuater(Integer quater) {
		this.quater = quater;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JSON(serialize = false)
	public Set getSusreportflags() {
		return this.susreportflags;
	}

	public void setSusreportflags(Set susreportflags) {
		this.susreportflags = susreportflags;
	}
	@JSON(serialize = false)
	public Set getIdentityKies() {
		return this.identityKies;
	}

	public void setIdentityKies(Set identityKies) {
		this.identityKies = identityKies;
	}
	@JSON(serialize = false)
	public Set getIdentitySbs() {
		return this.identitySbs;
	}

	public void setIdentitySbs(Set identitySbs) {
		this.identitySbs = identitySbs;
	}
	@JSON(serialize = false)
	public Set getActives() {
		return this.actives;
	}

	public void setActives(Set actives) {
		this.actives = actives;
	}
	@JSON(serialize = false)
	public Set getOrgandposts() {
		return this.organdposts;
	}

	public void setOrgandposts(Set organdposts) {
		this.organdposts = organdposts;
	}
	@JSON(serialize = false)
	public Set getInnerauditflags() {
		return this.innerauditflags;
	}

	public void setInnerauditflags(Set innerauditflags) {
		this.innerauditflags = innerauditflags;
	}
	@JSON(serialize = false)
	public Set getInnercontrols() {
		return this.innercontrols;
	}

	public void setInnercontrols(Set innercontrols) {
		this.innercontrols = innercontrols;
	}
	@JSON(serialize = false)
	public Set getSusreports() {
		return this.susreports;
	}

	public void setSusreports(Set susreports) {
		this.susreports = susreports;
	}
	@JSON(serialize = false)
	public Set getInneraudits() {
		return this.inneraudits;
	}

	public void setInneraudits(Set inneraudits) {
		this.inneraudits = inneraudits;
	}
	@JSON(serialize = false)
	public Set getInnerflags() {
		return this.innerflags;
	}

	public void setInnerflags(Set innerflags) {
		this.innerflags = innerflags;
	}
	@JSON(serialize = false)
	public Set getPublicses() {
		return this.publicses;
	}

	public void setPublicses(Set publicses) {
		this.publicses = publicses;
	}
	@JSON(serialize = false)
	public Set getBlowflags() {
		return this.blowflags;
	}

	public void setBlowflags(Set blowflags) {
		this.blowflags = blowflags;
	}
	@JSON(serialize = false)
	public Set getIdentityRsbs() {
		return this.identityRsbs;
	}

	public void setIdentityRsbs(Set identityRsbs) {
		this.identityRsbs = identityRsbs;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsreport() {
		return isreport;
	}

	public void setIsreport(String isreport) {
		this.isreport = isreport;
	}

	public Set getTrain() {
		return train;
	}

	public void setTrain(Set train) {
		this.train = train;
	}

}