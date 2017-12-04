package org.work.web.po;

import javax.persistence.Transient;

public class ArchivesHis implements java.io.Serializable{
	//序列号兼容性问题
	private static final long serialVersionUID = 1L;
	
	private java.lang.Integer id;
	
	public java.lang.Integer getId(){
		return id;
	}
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	
	private CatalogNew catalogNew;
	
	
	public CatalogNew getCatalogNew() {
		return catalogNew;
	}
	public void setCatalogNew(CatalogNew catalogNew) {
		this.catalogNew = catalogNew;
	}

	private Archives archives;
	
	public Archives getArchives() {
		return archives;
	}

	public void setArchives(Archives archives) {
		this.archives = archives;
	}
			
	/**
	*CORPORATION_TYPE
	**/
	private java.lang.String corporationType;
	
	public java.lang.String getCorporationType(){
		return corporationType;
	}
	
	public void setCorporationType(java.lang.String corporationType){
		this.corporationType=corporationType;
		//TODO 这个常量最好放到Constant类中取
		if(corporationType.equals("00")){
			this.corporationTypeName = "法人机构";
		}else if(corporationType.equals("01")){
			this.corporationTypeName = "分支机构";
		}
	}
	private java.lang.String corporationTypeName;
	@Transient
	public java.lang.String getCorporationTypeName() {
		return corporationTypeName;
	}

	/**
	*BOID
	**/
	private java.lang.String boid;
	
	public java.lang.String getBoid(){
		return boid;
	}
	
	public void setBoid(java.lang.String boid){
		this.boid=boid;
	}
			
	/**
	*BNAME
	**/
	private java.lang.String bname;
	
	public java.lang.String getBname(){
		return bname;
	}
	
	public void setBname(java.lang.String bname){
		this.bname=bname;
	}
			
	/**
	*BLEAD
	**/
	private java.lang.String blead;
	
	public java.lang.String getBlead(){
		return blead;
	}
	
	public void setBlead(java.lang.String blead){
		this.blead=blead;
	}
			
	/**
	*BWORKPHE
	**/
	private java.lang.String bworkphe;
	
	public java.lang.String getBworkphe(){
		return bworkphe;
	}
	
	public void setBworkphe(java.lang.String bworkphe){
		this.bworkphe=bworkphe;
	}
			
	/**
	*ESTABLISH_TIME
	**/
	private java.lang.String establishTime;
	
	public java.lang.String getEstablishTime(){
		return establishTime;
	}
	
	public void setEstablishTime(java.lang.String establishTime){
		this.establishTime=establishTime;
	}
			
	/**
	*BDEPTLEAD
	**/
	private java.lang.String bdeptlead;
	
	public java.lang.String getBdeptlead(){
		return bdeptlead;
	}
	
	public void setBdeptlead(java.lang.String bdeptlead){
		this.bdeptlead=bdeptlead;
	}
			
	/**
	*BDEPTLEADTEL
	**/
	private java.lang.String bdeptleadtel;
	
	public java.lang.String getBdeptleadtel(){
		return bdeptleadtel;
	}
	
	public void setBdeptleadtel(java.lang.String bdeptleadtel){
		this.bdeptleadtel=bdeptleadtel;
	}
			
	/**
	*BLASTNET
	**/
	private java.lang.String blastnet;
	
	public java.lang.String getBlastnet(){
		return blastnet;
	}
	
	public void setBlastnet(java.lang.String blastnet){
		this.blastnet=blastnet;
	}
			
	/**
	*BWORKTEL
	**/
	private java.lang.String bworktel;
	
	public java.lang.String getBworktel(){
		return bworktel;
	}
	
	public void setBworktel(java.lang.String bworktel){
		this.bworktel=bworktel;
	}
			
	/**
	*BDEPTLEADPHE
	**/
	private java.lang.String bdeptleadphe;
	
	public java.lang.String getBdeptleadphe(){
		return bdeptleadphe;
	}
	
	public void setBdeptleadphe(java.lang.String bdeptleadphe){
		this.bdeptleadphe=bdeptleadphe;
	}
			
	/**
	*BWORKNUM
	**/
	private java.lang.String bworknum;
	
	public java.lang.String getBworknum(){
		return bworknum;
	}
	
	public void setBworknum(java.lang.String bworknum){
		this.bworknum=bworknum;
	}
			
	/**
	*BLEADTEL
	**/
	private java.lang.String bleadtel;
	
	public java.lang.String getBleadtel(){
		return bleadtel;
	}
	
	public void setBleadtel(java.lang.String bleadtel){
		this.bleadtel=bleadtel;
	}
			
	/**
	*BWORK
	**/
	private java.lang.String bwork;
	
	public java.lang.String getBwork(){
		return bwork;
	}
	
	public void setBwork(java.lang.String bwork){
		this.bwork=bwork;
	}
			
	/**
	*BUSINESS_AREA
	**/
	private java.lang.String businessArea;
	
	public java.lang.String getBusinessArea(){
		return businessArea;
	}
	
	public void setBusinessArea(java.lang.String businessArea){
		this.businessArea=businessArea;
	}
			
	/**
	*REGISTERED_AREA
	**/
	private java.lang.String registeredArea;
	
	public java.lang.String getRegisteredArea(){
		return registeredArea;
	}
	
	public void setRegisteredArea(java.lang.String registeredArea){
		this.registeredArea=registeredArea;
	}
			
	/**
	*REGISTERED_CAPITAL
	**/
	private java.lang.String registeredCapital;
	
	public java.lang.String getRegisteredCapital(){
		return registeredCapital;
	}
	
	public void setRegisteredCapital(java.lang.String registeredCapital){
		this.registeredCapital=registeredCapital;
	}
			
	/**
	*HEADQUARTER
	**/
	private java.lang.String headquarter;
	
	public java.lang.String getHeadquarter(){
		return headquarter;
	}
	
	public void setHeadquarter(java.lang.String headquarter){
		this.headquarter=headquarter;
	}
			
	/**
	*OVERSEAS_BRANCH_OFFICE
	**/
	private java.lang.String overseasBranchOffice;
	
	public java.lang.String getOverseasBranchOffice(){
		return overseasBranchOffice;
	}
	
	public void setOverseasBranchOffice(java.lang.String overseasBranchOffice){
		this.overseasBranchOffice=overseasBranchOffice;
	}
			
	/**
	*NUMBER_OF_BRANCH_OFFICE
	**/
	private java.lang.String numberOfBranchOffice;
	
	public java.lang.String getNumberOfBranchOffice(){
		return numberOfBranchOffice;
	}
	
	public void setNumberOfBranchOffice(java.lang.String numberOfBranchOffice){
		this.numberOfBranchOffice=numberOfBranchOffice;
	}
			
	/**
	*NUMBER_OF_HALL
	**/
	private java.lang.String numberOfHall;
	
	public java.lang.String getNumberOfHall(){
		return numberOfHall;
	}
	
	public void setNumberOfHall(java.lang.String numberOfHall){
		this.numberOfHall=numberOfHall;
	}
			
	/**
	*BLASTAMT
	**/
	private java.lang.String blastamt;
	
	public java.lang.String getBlastamt(){
		return blastamt;
	}
	
	public void setBlastamt(java.lang.String blastamt){
		this.blastamt=blastamt;
	}
			
	/**
	*BUPDATEUSER
	**/
	private java.lang.String bupdateuser;
	
	public java.lang.String getBupdateuser(){
		return bupdateuser;
	}
	
	public void setBupdateuser(java.lang.String bupdateuser){
		this.bupdateuser=bupdateuser;
	}
			
	/**
	*BUPDATETIME
	**/
	private java.lang.String bupdatetime;
	
	public java.lang.String getBupdatetime(){
		return bupdatetime;
	}
	
	public void setBupdatetime(java.lang.String bupdatetime){
		this.bupdatetime=bupdatetime;
	}
			
	/**
	*ISHEAD
	**/
	private java.lang.String ishead;
	
	public java.lang.String getIshead(){
		return ishead;
	}
	
	public void setIshead(java.lang.String ishead){
		this.ishead=ishead;
	}
			
	/**
	*ISNEED
	**/
	private java.lang.String isneed;
	
	public java.lang.String getIsneed(){
		return isneed;
	}
	
	public void setIsneed(java.lang.String isneed){
		this.isneed=isneed;
	}
			
	/**
	*BMININAME
	**/
	private java.lang.String bmininame;
	
	public java.lang.String getBmininame(){
		return bmininame;
	}
	
	public void setBmininame(java.lang.String bmininame){
		this.bmininame=bmininame;
	}
			
	/**
	*评级表类型
	**/
	private java.lang.String rateType;
	
	public java.lang.String getRateType(){
		return rateType;
	}
	
	public void setRateType(java.lang.String rateType){
		this.rateType=rateType;
	}
			
	/**
	*SHAREHOLDER1
	**/
	private java.lang.String shareholder1;
	
	public java.lang.String getShareholder1(){
		return shareholder1;
	}
	
	public void setShareholder1(java.lang.String shareholder1){
		this.shareholder1=shareholder1;
	}
			
	/**
	*RATE1
	**/
	private java.lang.String rate1;
	
	public java.lang.String getRate1(){
		return rate1;
	}
	
	public void setRate1(java.lang.String rate1){
		this.rate1=rate1;
	}
			
	/**
	*SHAREHOLDER2
	**/
	private java.lang.String shareholder2;
	
	public java.lang.String getShareholder2(){
		return shareholder2;
	}
	
	public void setShareholder2(java.lang.String shareholder2){
		this.shareholder2=shareholder2;
	}
			
	/**
	*RATE2
	**/
	private java.lang.String rate2;
	
	public java.lang.String getRate2(){
		return rate2;
	}
	
	public void setRate2(java.lang.String rate2){
		this.rate2=rate2;
	}
			
	/**
	*SHAREHOLDER3
	**/
	private java.lang.String shareholder3;
	
	public java.lang.String getShareholder3(){
		return shareholder3;
	}
	
	public void setShareholder3(java.lang.String shareholder3){
		this.shareholder3=shareholder3;
	}
			
	/**
	*RATE3
	**/
	private java.lang.String rate3;
	
	public java.lang.String getRate3(){
		return rate3;
	}
	
	public void setRate3(java.lang.String rate3){
		this.rate3=rate3;
	}
			
	/**
	*SHAREHOLDER4
	**/
	private java.lang.String shareholder4;
	
	public java.lang.String getShareholder4(){
		return shareholder4;
	}
	
	public void setShareholder4(java.lang.String shareholder4){
		this.shareholder4=shareholder4;
	}
			
	/**
	*RATE4
	**/
	private java.lang.String rate4;
	
	public java.lang.String getRate4(){
		return rate4;
	}
	
	public void setRate4(java.lang.String rate4){
		this.rate4=rate4;
	}
			
	/**
	*SHAREHOLDER5
	**/
	private java.lang.String shareholder5;
	
	public java.lang.String getShareholder5(){
		return shareholder5;
	}
	
	public void setShareholder5(java.lang.String shareholder5){
		this.shareholder5=shareholder5;
	}
			
	/**
	*RATE5
	**/
	private java.lang.String rate5;
	
	public java.lang.String getRate5(){
		return rate5;
	}
	
	public void setRate5(java.lang.String rate5){
		this.rate5=rate5;
	}
			
	/**
	*ADDRESS
	**/
	private java.lang.String address;
	
	public java.lang.String getAddress(){
		return address;
	}
	
	public void setAddress(java.lang.String address){
		this.address=address;
	}
			
	/**
	*RESPONSIBLE_PERSON
	**/
	private java.lang.String responsiblePerson;
	
	public java.lang.String getResponsiblePerson(){
		return responsiblePerson;
	}
	
	public void setResponsiblePerson(java.lang.String responsiblePerson){
		this.responsiblePerson=responsiblePerson;
	}
			
		
 			
	/**
	 * toString.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.getId() == null) {
			return "";
		}
		return this.getId() + "";
	}
	
	

}
