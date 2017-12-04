package org.work.web.po;

public class CatalogNewId implements java.io.Serializable {
	//序列号兼容性问题
	private static final long serialVersionUID = 1L;
	/**
	*一级类别id
	**/
	private java.lang.String bfirstid;
	
	public java.lang.String getBfirstid() {
		return bfirstid;
	}

	public void setBfirstid(java.lang.String bfirstid) {
		this.bfirstid = bfirstid;
	}
	/**
	*二级类别id
	**/
	private java.lang.String bsecondid;
	
	public java.lang.String getBsecondid(){
		return bsecondid;
	}
	
	public void setBsecondid(java.lang.String bsecondid){
		this.bsecondid=bsecondid;
	}
	/**
	*三级类别id
	**/
	private java.lang.String bthirdid;
	
	public java.lang.String getBthirdid(){
		return bthirdid;
	}
	
	public void setBthirdid(java.lang.String bthirdid){
		this.bthirdid=bthirdid;
	}

	@Override
	public String toString() {
		return "CatalogNewId [bfirstid=" + bfirstid + ", bsecondid="
				+ bsecondid + ", bthirdid=" + bthirdid + "]";
	}

	public CatalogNewId() {
		super();
	}

	public CatalogNewId(String bfirstid) {
		super();
		this.bfirstid = bfirstid;
	}

	
	
}
