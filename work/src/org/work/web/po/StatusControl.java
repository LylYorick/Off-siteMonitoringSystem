package org.work.web.po;
 /**
 * RATE_STATUS_CONTROL. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class StatusControl  implements java.io.Serializable,Comparable<StatusControl> {
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
	*类型
	**/
	private java.lang.String type;
	
	public java.lang.String getType(){
		return type;
	}
	
	public void setType(java.lang.String type){
		this.type=type;
	}
			
	/**
	*名称
	**/
	private java.lang.String name;
	
	public java.lang.String getName(){
		return name;
	}
	
	public void setName(java.lang.String name){
		this.name=name;
	}
			
	/**
	*开始时间
	**/
	private java.lang.String startTime;
	
	public java.lang.String getStartTime(){
		return startTime;
	}
	
	public void setStartTime(java.lang.String startTime){
		this.startTime=startTime;
	}
			
	/**
	*结束时间
	**/
	private java.lang.String endTime;
	
	public java.lang.String getEndTime(){
		return endTime;
	}
	
	public void setEndTime(java.lang.String endTime){
		this.endTime=endTime;
	}
			
	/**
	*激活状态
	**/
	private java.lang.String activeStatus;
	
	public java.lang.String getActiveStatus(){
		return activeStatus;
	}
	
	public void setActiveStatus(java.lang.String activeStatus){
		this.activeStatus=activeStatus;
	}
			
	/**
	*备注信息
	**/
	private java.lang.String remark;
	
	public java.lang.String getRemark(){
		return remark;
	}
	
	public void setRemark(java.lang.String remark){
		this.remark=remark;
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
		sb.append(", type as type");
		sb.append(", name as name");
		sb.append(", startTime as startTime");
		sb.append(", endTime as endTime");
		sb.append(", activeStatus as activeStatus");
		sb.append(", remark as remark");
		sb.append(" from StatusControl");
		return sb.toString();
	}

	/**
	 * compareTo.
	 * @see java.lang.Comparable#compareTo(StatusControl)
	 */
	public int compareTo(StatusControl o) {
		return this.getId().compareTo(o.getId());
	}
	
}
