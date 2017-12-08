package org.work.web.po;
 /**
 * 异议表. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class Opposition  implements java.io.Serializable,Comparable<Opposition> {
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
	*机构ID
	**/
	private java.lang.Integer orgId;
	
	public java.lang.Integer getOrgId(){
		return orgId;
	}
	
	public void setOrgId(java.lang.Integer orgId){
		this.orgId=orgId;
	}
			
	/**
	*异议类型
	**/
	private java.lang.String oppType;
	
	public java.lang.String getOppType(){
		return oppType;
	}
	
	public void setOppType(java.lang.String oppType){
		this.oppType=oppType;
	}
			
	/**
	*状态
	**/
	private java.lang.Integer status;
	
	public java.lang.Integer getStatus(){
		return status;
	}
	
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
			
	/**
	*评级总表ID
	**/
	private java.lang.Integer orgRateId;
	
	public java.lang.Integer getOrgRateId(){
		return orgRateId;
	}
	
	public void setOrgRateId(java.lang.Integer orgRateId){
		this.orgRateId=orgRateId;
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
	*期望值
	**/
	private java.lang.String desiredValiue;
	
	public java.lang.String getDesiredValiue(){
		return desiredValiue;
	}
	
	public void setDesiredValiue(java.lang.String desiredValiue){
		this.desiredValiue=desiredValiue;
	}
			
	/**
	*异议理由
	**/
	private java.lang.String oppReason;
	
	public java.lang.String getOppReason(){
		return oppReason;
	}
	
	public void setOppReason(java.lang.String oppReason){
		this.oppReason=oppReason;
	}
			
	/**
	*异议附件
	**/
	private java.lang.String attachment;
	
	public java.lang.String getAttachment(){
		return attachment;
	}
	
	public void setAttachment(java.lang.String attachment){
		this.attachment=attachment;
	}
			
	/**
	*处理结果
	**/
	private java.lang.String dealResult;
	
	public java.lang.String getDealResult(){
		return dealResult;
	}
	
	public void setDealResult(java.lang.String dealResult){
		this.dealResult=dealResult;
	}
			
	/**
	*处理理由
	**/
	private java.lang.String dealReason;
	
	public java.lang.String getDealReason(){
		return dealReason;
	}
	
	public void setDealReason(java.lang.String dealReason){
		this.dealReason=dealReason;
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
		sb.append(", oppType as oppType");
		sb.append(", status as status");
		sb.append(", orgRateId as orgRateId");
		sb.append(", rateId as rateId");
		sb.append(", desiredValiue as desiredValiue");
		sb.append(", oppReason as oppReason");
		sb.append(", attachment as attachment");
		sb.append(", dealResult as dealResult");
		sb.append(", dealReason as dealReason");
		sb.append(" from Opposition");
		return sb.toString();
	}

	/**
	 * compareTo.
	 * @see java.lang.Comparable#compareTo(Opposition)
	 */
	public int compareTo(Opposition o) {
		return this.getId().compareTo(o.getId());
	}
	
}
