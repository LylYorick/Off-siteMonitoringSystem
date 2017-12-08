package org.work.web.po;
 /**
 * 机构评级明细表. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class RateDetail  implements java.io.Serializable,Comparable<RateDetail> {
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
	*指标id
	**/
	private java.lang.Integer rateId;
	
	public java.lang.Integer getRateId(){
		return rateId;
	}
	
	public void setRateId(java.lang.Integer rateId){
		this.rateId=rateId;
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
	*自评理由
	**/
	private java.lang.String saReason;
	
	public java.lang.String getSaReason(){
		return saReason;
	}
	
	public void setSaReason(java.lang.String saReason){
		this.saReason=saReason;
	}
			
	/**
	*复核拒绝理由
	**/
	private java.lang.String rejectReason;
	
	public java.lang.String getRejectReason(){
		return rejectReason;
	}
	
	public void setRejectReason(java.lang.String rejectReason){
		this.rejectReason=rejectReason;
	}
			
	/**
	*附件（路径）
	**/
	private java.lang.String attachment;
	
	public java.lang.String getAttachment(){
		return attachment;
	}
	
	public void setAttachment(java.lang.String attachment){
		this.attachment=attachment;
	}
			
	/**
	*是否允许自评
	**/
	private java.lang.String isSelfassessment;
	
	public java.lang.String getIsSelfassessment(){
		return isSelfassessment;
	}
	
	public void setIsSelfassessment(java.lang.String isSelfassessment){
		this.isSelfassessment=isSelfassessment;
	}
			
	/**
	*评级得分
	**/
	private java.lang.Integer rankScore;
	
	public java.lang.Integer getRankScore(){
		return rankScore;
	}
	
	public void setRankScore(java.lang.Integer rankScore){
		this.rankScore=rankScore;
	}
			
	/**
	*评级理由
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
		sb.append(", rateId as rateId");
		sb.append(", orgId as orgId");
		sb.append(", year as year");
		sb.append(", saScore as saScore");
		sb.append(", saReason as saReason");
		sb.append(", rejectReason as rejectReason");
		sb.append(", attachment as attachment");
		sb.append(", isSelfassessment as isSelfassessment");
		sb.append(", rankScore as rankScore");
		sb.append(", rankReason as rankReason");
		sb.append(", isOpposition as isOpposition");
		sb.append(" from RateDetail");
		return sb.toString();
	}

	/**
	 * compareTo.
	 * @see java.lang.Comparable#compareTo(RateDetail)
	 */
	public int compareTo(RateDetail o) {
		return this.getId().compareTo(o.getId());
	}
	
}
