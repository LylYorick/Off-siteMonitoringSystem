package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

/**
 * PNode entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class PNode implements java.io.Serializable {

	// Fields

	private Integer nid;
	private PFunction PFunction;
	private String NName;
	private Set<PNav> PNavs = new HashSet<PNav>(0);

	// Constructors

	/** default constructor */
	public PNode() {
	}

	/** minimal constructor */
	public PNode(String NName) {
		this.NName = NName;
	}

	/** full constructor */
	public PNode(PFunction PFunction, String NName,Set<PNav> PNavs) {
		this.PFunction = PFunction;
		this.NName = NName;
		this.PNavs = PNavs;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public PFunction getPFunction() {
		return this.PFunction;
	}

	public void setPFunction(PFunction PFunction) {
		this.PFunction = PFunction;
	}

	public String getNName() {
		return this.NName;
	}

	public void setNName(String NName) {
		this.NName = NName;
	}

	public Set<PNav> getPNavs() {
		return this.PNavs;
	}

	public void setPNavs(Set<PNav> PNavs) {
		this.PNavs = PNavs;
	}

}