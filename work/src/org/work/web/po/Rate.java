package org.work.web.po;
 /**
 * 机构评级总表. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class Rate  implements java.io.Serializable,Comparable<Rate> {
	//序列号兼容性问题
	private static final long serialVersionUID = 1L;
	
	private java.lang.Integer id;
	
	public java.lang.Integer getId(){
		return id;
	}
	
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	
	/**
	*年度
	**/
	private java.lang.String year;
	
	public java.lang.String getYear(){
		return year;
	}
	
	public void setYear(java.lang.String year){
		this.year=year;
	}
			
	/**
	*机构id
	**/
	private java.lang.Integer orgId;
	
	public java.lang.Integer getOrgId(){
		return orgId;
	}
	
	public void setOrgId(java.lang.Integer orgId){
		this.orgId=orgId;
	}
			
	/**
	*机构类型
	**/
	private java.lang.Integer orgType;
	
	public java.lang.Integer getOrgType(){
		return orgType;
	}
	
	public void setOrgType(java.lang.Integer orgType){
		this.orgType=orgType;
	}
			
	/**
	*评级表类型
	**/
	private java.lang.Integer rateType;
	
	public java.lang.Integer getRateType(){
		return rateType;
	}
	
	public void setRateType(java.lang.Integer rateType){
		this.rateType=rateType;
	}
			
	/**
	*状态
	**/
	private java.lang.String status;
	
	public java.lang.String getStatus(){
		return status;
	}
	
	public void setStatus(java.lang.String status){
		this.status=status;
	}
			
	/**
	*自评总分
	**/
	private java.lang.Integer saTatolScore;
	
	public java.lang.Integer getSaTatolScore(){
		return saTatolScore;
	}
	
	public void setSaTatolScore(java.lang.Integer saTatolScore){
		this.saTatolScore=saTatolScore;
	}
			
	/**
	*自评得分
	**/
	private java.lang.Integer saScore;
	
	public java.lang.Integer getSaScore(){
		return saScore;
	}
	
	public void setSaScore(java.lang.Integer saScore){
		this.saScore=saScore;
	}
			
	/**
	*评级等级
	**/
	private java.lang.String rateLevel;
	
	public java.lang.String getRateLevel(){
		return rateLevel;
	}
	
	public void setRateLevel(java.lang.String rateLevel){
		this.rateLevel=rateLevel;
	}
			
	/**
	*评级得分
	**/
	private java.lang.Integer rateScore;
	
	public java.lang.Integer getRateScore(){
		return rateScore;
	}
	
	public void setRateScore(java.lang.Integer rateScore){
		this.rateScore=rateScore;
	}
			
	/**
	*定级等级
	**/
	private java.lang.String rankLevel;
	
	public java.lang.String getRankLevel(){
		return rankLevel;
	}
	
	public void setRankLevel(java.lang.String rankLevel){
		this.rankLevel=rankLevel;
	}
			
	/**
	*定级理由
	**/
	private java.lang.String rankReason;
	
	public java.lang.String getRankReason(){
		return rankReason;
	}
	
	public void setRankReason(java.lang.String rankReason){
		this.rankReason=rankReason;
	}
			
	/**
	*是否有异议
	**/
	private java.lang.String isOpposition;
	
	public java.lang.String getIsOpposition(){
		return isOpposition;
	}
	
	public void setIsOpposition(java.lang.String isOpposition){
		this.isOpposition=isOpposition;
	}
			
	/**
	*监管意见书
	**/
	private java.lang.String opinionBook;
	
	public java.lang.String getOpinionBook(){
		return opinionBook;
	}
	
	public void setOpinionBook(java.lang.String opinionBook){
		this.opinionBook=opinionBook;
	}
			
	/**
	*监管意见书状态
	**/
	private java.lang.String bookStatus;
	
	public java.lang.String getBookStatus(){
		return bookStatus;
	}
	
	public void setBookStatus(java.lang.String bookStatus){
		this.bookStatus=bookStatus;
	}
			
	/**
	*整改报告
	**/
	private java.lang.String rectificationReport;
	
	public java.lang.String getRectificationReport(){
		return rectificationReport;
	}
	
	public void setRectificationReport(java.lang.String rectificationReport){
		this.rectificationReport=rectificationReport;
	}
			
	/**
	*报告类型
	**/
	private java.lang.String reportType;
	
	public java.lang.String getReportType(){
		return reportType;
	}
	
	public void setReportType(java.lang.String reportType){
		this.reportType=reportType;
	}
			
	/**
	*报告路径
	**/
	private java.lang.String reportStatus;
	
	public java.lang.String getReportStatus(){
		return reportStatus;
	}
	
	public void setReportStatus(java.lang.String reportStatus){
		this.reportStatus=reportStatus;
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
	
	/**
	 * toHqlString
	 * 生成HQL初始全字段语句，用于配置设计器数据集时使用
	 */
	public String toHqlString(){
		StringBuffer sb = new StringBuffer();
		sb.append("select id as id");
		sb.append(", year as year");
		sb.append(", orgId as orgId");
		sb.append(", orgType as orgType");
		sb.append(", rateType as rateType");
		sb.append(", status as status");
		sb.append(", saTatolScore as saTatolScore");
		sb.append(", saScore as saScore");
		sb.append(", rateLevel as rateLevel");
		sb.append(", rateScore as rateScore");
		sb.append(", rankLevel as rankLevel");
		sb.append(", rankReason as rankReason");
		sb.append(", isOpposition as isOpposition");
		sb.append(", opinionBook as opinionBook");
		sb.append(", bookStatus as bookStatus");
		sb.append(", rectificationReport as rectificationReport");
		sb.append(", reportType as reportType");
		sb.append(", reportStatus as reportStatus");
		sb.append(" from Rate");
		return sb.toString();
	}

	/**
	 * compareTo.
	 * @see java.lang.Comparable#compareTo(Rate)
	 */
	public int compareTo(Rate o) {
		return this.getId().compareTo(o.getId());
	}
	
}
