package org.work.web.po;
 /**
 * 评级模板表. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class Templet  implements java.io.Serializable,Comparable<Templet> {
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
	*父指标Id
	**/
	private java.lang.Integer parentId;
	
	public java.lang.Integer getParentId(){
		return parentId;
	}
	
	public void setParentId(java.lang.Integer parentId){
		this.parentId=parentId;
	}
			
	/**
	*指标名称
	**/
	private java.lang.String quotaName;
	
	public java.lang.String getQuotaName(){
		return quotaName;
	}
	
	public void setQuotaName(java.lang.String quotaName){
		this.quotaName=quotaName;
	}
			
	/**
	*指标描述
	**/
	private java.lang.String quotaDesc;
	
	public java.lang.String getQuotaDesc(){
		return quotaDesc;
	}
	
	public void setQuotaDesc(java.lang.String quotaDesc){
		this.quotaDesc=quotaDesc;
	}
			
	/**
	*评分标准
	**/
	private java.lang.String standard;
	
	public java.lang.String getStandard(){
		return standard;
	}
	
	public void setStandard(java.lang.String standard){
		this.standard=standard;
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
	*自评理由要求
	**/
	private java.lang.String saRequirement;
	
	public java.lang.String getSaRequirement(){
		return saRequirement;
	}
	
	public void setSaRequirement(java.lang.String saRequirement){
		this.saRequirement=saRequirement;
	}
			
	/**
	*分值
	**/
	private java.lang.Integer score;
	
	public java.lang.Integer getScore(){
		return score;
	}
	
	public void setScore(java.lang.Integer score){
		this.score=score;
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
		sb.append(", rateType as rateType");
		sb.append(", parentId as parentId");
		sb.append(", quotaName as quotaName");
		sb.append(", quotaDesc as quotaDesc");
		sb.append(", standard as standard");
		sb.append(", isSelfassessment as isSelfassessment");
		sb.append(", saRequirement as saRequirement");
		sb.append(", score as score");
		sb.append(" from Templet");
		return sb.toString();
	}

	/**
	 * compareTo.
	 * @see java.lang.Comparable#compareTo(Templet)
	 */
	public int compareTo(Templet o) {
		return this.getId().compareTo(o.getId());
	}
	
}
