package org.work.web.po;

 /**
 * 金融机构类别-新. <br/>
 * @author system
 * @version 1.0
 * Copyright (深圳市雁联计算系统有限公司) 2014,  All Rights Reserved.
 * @since JDK 1.6
 */
public class CatalogNew  implements java.io.Serializable{
	//序列号兼容性问题
	private static final long serialVersionUID = 1L;
	
	private CatalogNewId id;
	
	public CatalogNewId getId() {
		return id;
	}

	public void setId(CatalogNewId id) {
		this.id = id;
	}
	/**
	*一级类别名称
	**/
	private java.lang.String firstCatname;
	
	public java.lang.String getFirstCatname(){
		return firstCatname;
	}
	
	public void setFirstCatname(java.lang.String firstCatname){
		this.firstCatname=firstCatname;
	}
			
			
	/**
	*二级类别名称
	**/
	private java.lang.String secondCatname;
	
	public java.lang.String getSecondCatname(){
		return secondCatname;
	}
	
	public void setSecondCatname(java.lang.String secondCatname){
		this.secondCatname=secondCatname;
	}
			

			
	/**
	*三级类别名称
	**/
	private java.lang.String thirdCatname;
	
	public java.lang.String getThirdCatname(){
		return thirdCatname;
	}
	
	public void setThirdCatname(java.lang.String thirdCatname){
		this.thirdCatname=thirdCatname;
	}

	public CatalogNew(CatalogNewId id) {
		super();
		this.id = id;
	}

	public CatalogNew(CatalogNewId id, String firstCatname) {
		super();
		this.id = id;
		this.firstCatname = firstCatname;
	}

	public CatalogNew() {
		super();
	}

	public CatalogNew(CatalogNewId id, String firstCatname,
			String secondCatname, String thirdCatname) {
		super();
		this.id = id;
		this.firstCatname = firstCatname;
		this.secondCatname = secondCatname;
		this.thirdCatname = thirdCatname;
	}

	@Override
	public String toString() {
		return "CatalogNew [id=" + id + ", firstCatname=" + firstCatname
				+ ", secondCatname=" + secondCatname + ", thirdCatname="
				+ thirdCatname + "]";
	}

	
}
