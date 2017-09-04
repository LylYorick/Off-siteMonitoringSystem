package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

/**
 * PFunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class PFunction implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nodename;
	private Set<PNode> PNodes = new HashSet<PNode>(0);

	// Constructors

	/** default constructor */
	public PFunction() {
	}

	/** minimal constructor */
	public PFunction(String nodename) {
		this.nodename = nodename;
	}

	/** full constructor */
	public PFunction(String nodename, Set<PNode> PNodes) {
		this.nodename = nodename;
		this.PNodes = PNodes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNodename() {
		return this.nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public Set<PNode> getPNodes() {
		return this.PNodes;
	}

	public void setPNodes(Set<PNode> PNodes) {
		this.PNodes = PNodes;
	}

}