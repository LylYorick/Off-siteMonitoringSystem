package org.work.web.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class Archives implements Serializable {
	private int oid;
	//private Integer bid;
	private CatalogNew catalogNew ;//机构种类对象 
	private String corporationType;//是否是法人机构
	private String bname;//机构名称
	private String bwork;//反洗钱岗位人员
	private String bworktel;//反洗钱岗位人员电话
	private String bworkphe;//反洗钱岗位人员手机
	private BigDecimal blastamt;//上年末度总资产
	private BigDecimal blastnet;//上年度税后净利润
	private String blead;//	反洗钱工作分管领导
	private String bleadtel;//分管领导电话
	private String bdeptlead;//反洗钱部门负责人
	private String bdeptleadtel;//反洗钱部门负责人电话
	private String bdeptleadphe;//反洗钱部门负责人手机
	private String establishTime;//成立时间
	private BigDecimal registeredCapital;//注册资本
	private String registeredArea;//注册地
	private String businessArea;//经营地
	private Integer numberOfBranchOffice;//分支机构数
	private String overseasBranchOffice;//境外分支机构信息
	private String headquarter; //总部所在地
	private Integer numberOfHall;//在深的营业部家数
	private Integer bworknum;//员工人数
	private String bupdatetime;
	private String bupdateuser;
	private String rateType;//评级类型 00-法人金融机构评级表 01-非法人金融机构评级表 ;
	private String shareholder1;//股东信息1
	private BigDecimal rate1;//股东1持股比例
	private String shareholder2;//股东信息2
	private BigDecimal rate2;//股东2持股比例
	private String shareholder3;//股东信息3
	private BigDecimal rate3;//股东3持股比例
	private String shareholder4;//股东信息4
	private BigDecimal rate4 ;//股东4持股比例
	private String shareholder5;//股东信息5
	private BigDecimal rate5;//股东5持股比例
	private String address;//联系地址
	private String responsiblePerson;//机构负责人
	
	
	
	public Archives() {
		super();
		rate1 = new BigDecimal(0);
		rate2 = new BigDecimal(0);
		rate3 = new BigDecimal(0);
		rate4 = new BigDecimal(0);
		rate5 = new BigDecimal(0);
	}
	public Archives(int oid) {
		super();
		this.oid = oid;
	}
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getCorporationType() {
		return corporationType;
	}
	public void setCorporationType(String corporationType) {
		this.corporationType = corporationType;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBlead() {
		return blead;
	}
	public void setBlead(String blead) {
		this.blead = blead;
	}
	public String getBworkphe() {
		return bworkphe;
	}
	public void setBworkphe(String bworkphe) {
		this.bworkphe = bworkphe;
	}
	public String getEstablishTime() {
		return establishTime;
	}
	public void setEstablishTime(String establishTime) {
		this.establishTime = establishTime;
	}
	public String getBdeptlead() {
		return bdeptlead;
	}
	public void setBdeptlead(String bdeptlead) {
		this.bdeptlead = bdeptlead;
	}
	public String getBdeptleadtel() {
		return bdeptleadtel;
	}
	public void setBdeptleadtel(String bdeptleadtel) {
		this.bdeptleadtel = bdeptleadtel;
	}
	public BigDecimal getBlastnet() {
		return blastnet;
	}
	public void setBlastnet(BigDecimal blastnet) {
		this.blastnet = blastnet;
	}
	public String getBworktel() {
		return bworktel;
	}
	public void setBworktel(String bworktel) {
		this.bworktel = bworktel;
	}
	public String getBdeptleadphe() {
		return bdeptleadphe;
	}
	public void setBdeptleadphe(String bdeptleadphe) {
		this.bdeptleadphe = bdeptleadphe;
	}
	public Integer getBworknum() {
		return bworknum;
	}
	public void setBworknum(Integer bworknum) {
		this.bworknum = bworknum;
	}
	public String getBleadtel() {
		return bleadtel;
	}
	public void setBleadtel(String bleadtel) {
		this.bleadtel = bleadtel;
	}
	public String getBupdatetime() {
		return bupdatetime;
	}
	public void setBupdatetime(String bupdatetime) {
		this.bupdatetime = bupdatetime;
	}
	public String getBwork() {
		return bwork;
	}
	public void setBwork(String bwork) {
		this.bwork = bwork;
	}
	public String getRegisteredArea() {
		return registeredArea;
	}
	public void setRegisteredArea(String registeredArea) {
		this.registeredArea = registeredArea;
	}
	public BigDecimal getRegisteredCapital() {
		if (registeredCapital == null) {
			registeredCapital = new BigDecimal(0);
		}
		return registeredCapital;
	}
	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getHeadquarter() {
		return headquarter;
	}
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	public Integer getNumberOfHall() {
		return numberOfHall;
	}
	public void setNumberOfHall(Integer numberOfHall) {
		this.numberOfHall = numberOfHall;
	}
	public String getBupdateuser() {
		return bupdateuser;
	}
	public void setBupdateuser(String bupdateuser) {
		this.bupdateuser = bupdateuser;
	}
	public BigDecimal getBlastamt() {
		return blastamt;
	}
	public void setBlastamt(BigDecimal blastamt) {
		this.blastamt = blastamt;
	}
	public String getOverseasBranchOffice() {
		return overseasBranchOffice;
	}
	public void setOverseasBranchOffice(String overseasBranchOffice) {
		this.overseasBranchOffice = overseasBranchOffice;
	}
	public Integer getNumberOfBranchOffice() {
		return numberOfBranchOffice;
	}
	public void setNumberOfBranchOffice(Integer numberOfBranchOffice) {
		this.numberOfBranchOffice = numberOfBranchOffice;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	
	public CatalogNew getCatalogNew() {
		return catalogNew;
	}
	public void setCatalogNew(CatalogNew catalogNew) {
		this.catalogNew = catalogNew;
	}
	public String getShareholder1() {
		return shareholder1;
	}
	public void setShareholder1(String shareholder1) {
		this.shareholder1 = shareholder1;
	}
	public BigDecimal getRate1() {
		if (rate1 == null) {
			rate1  = new BigDecimal(0);
		}
		return rate1;
	}
	public void setRate1(BigDecimal rate1) {
		this.rate1 = rate1;
	}
	public String getShareholder2() {
		return shareholder2;
	}
	public void setShareholder2(String shareholder2) {
		this.shareholder2 = shareholder2;
	}
	public BigDecimal getRate2() {
		if (rate2 == null) {
			rate2 = new BigDecimal(0);
		}
		return rate2;
	}
	public void setRate2(BigDecimal rate2) {
	
		this.rate2 = rate2;
	}
	public String getShareholder3() {
		return shareholder3;
	}
	public void setShareholder3(String shareholder3) {
		this.shareholder3 = shareholder3;
	}
	public BigDecimal getRate3() {
		if (rate3 == null) {
			rate3 = new BigDecimal(0);
		}
		return rate3;
	}
	public void setRate3(BigDecimal rate3) {
		this.rate3 = rate3;
	}
	public String getShareholder4() {
		return shareholder4;
	}
	public void setShareholder4(String shareholder4) {
		this.shareholder4 = shareholder4;
	}
	public BigDecimal getRate4() {
		if (rate4 == null) {
			rate4 = new BigDecimal(0);
		}
		return rate4;
	}
	public void setRate4(BigDecimal rate4) {
		this.rate4 = rate4;
	}
	public String getShareholder5() {
		return shareholder5;
	}
	public void setShareholder5(String shareholder5) {
		this.shareholder5 = shareholder5;
	}
	public BigDecimal getRate5() {
		if (rate5 == null) {
			rate5 = new BigDecimal(0);
		}
		return rate5;
	}
	public void setRate5(BigDecimal rate5) {
		this.rate5 = rate5;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	
}
