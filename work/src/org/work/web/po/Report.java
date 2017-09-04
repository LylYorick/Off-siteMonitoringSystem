package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Report entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Report implements java.io.Serializable {

	// Fields

	private Integer reportid;
	private String rptname;
	private Integer startmonth;
	private Integer startday;
	private Integer endmonth;
	private Integer endday;
	private Integer prtype;
	private String updateuser;
	private String updatetime;
	private Set reportswitchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Report() {
	}

	public Report(Integer reportid, String rptname, Integer startmonth,
			Integer startday, Integer endmonth, Integer endday, Integer prtype,
			String updateuser, String updatetime, Set reportswitchs) {
		this.reportid = reportid;
		this.rptname = rptname;
		this.startmonth = startmonth;
		this.startday = startday;
		this.endmonth = endmonth;
		this.endday = endday;
		this.prtype = prtype;
		this.updateuser = updateuser;
		this.updatetime = updatetime;
		this.reportswitchs = reportswitchs;
	}

	public Integer getReportid() {
		return this.reportid;
	}

	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}

	public String getRptname() {
		return this.rptname;
	}

	public void setRptname(String rptname) {
		this.rptname = rptname;
	}

	public Integer getPrtype() {
		return this.prtype;
	}

	public void setPrtype(Integer prtype) {
		this.prtype = prtype;
	}
	@JSON(serialize = false)
	public Set getReportswitchs() {
		return this.reportswitchs;
	}

	public void setReportswitchs(Set reportswitchs) {
		this.reportswitchs = reportswitchs;
	}

	public Integer getStartmonth() {
		return startmonth;
	}

	public void setStartmonth(Integer startmonth) {
		this.startmonth = startmonth;
	}

	public Integer getStartday() {
		return startday;
	}

	public void setStartday(Integer startday) {
		this.startday = startday;
	}

	public Integer getEndmonth() {
		return endmonth;
	}

	public void setEndmonth(Integer endmonth) {
		this.endmonth = endmonth;
	}

	public Integer getEndday() {
		return endday;
	}

	public void setEndday(Integer endday) {
		this.endday = endday;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public void getHibernateLazyInitializer(){
		
	}
}