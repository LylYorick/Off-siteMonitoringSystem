package org.work.web.po;

/**
 * PNav entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class PNav implements java.io.Serializable {

	// Fields

	private Integer vid;
	private PNode PNode;
	private String vname;
	private String url;

	// Constructors

	/** default constructor */
	public PNav() {
	}

	/** minimal constructor */
	public PNav(String vname,  String url) {
		this.vname = vname;
		this.url = url;
	}

	/** full constructor */
	public PNav(PNode PNode, String vname,  String url) {
		this.PNode = PNode;
		this.vname = vname;
		this.url = url;
	}

	// Property accessors

	public Integer getVid() {
		return this.vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public PNode getPNode() {
		return this.PNode;
	}

	public void setPNode(PNode PNode) {
		this.PNode = PNode;
	}

	public String getVname() {
		return this.vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}