package org.work.web.po;

import java.util.HashSet;
import java.util.Set;


/**
 * PRIVILEGE entity. @author MyEclipse Persistence Tools
 */

public class Privilege  implements java.io.Serializable {


    // Fields    

	private Privilege parent;
     private Integer pid;
     private String pname;
     private Short pismenu;
     private Integer ppid;
 	private Set children = new HashSet(10);//节点所包含的子节点
     private Set TPubResources = new HashSet(0);
     private Set TPubRoleprivileges = new HashSet(0);


    // Constructors

    /** default constructor */
    public Privilege() {
    }

	/** minimal constructor */
    public Privilege(String pname, Short pismenu, Integer ppid) {
        this.pname = pname;
        this.pismenu = pismenu;
        this.ppid = ppid;
    }
    
    /** full constructor */
    public Privilege(String pname, Short pismenu, Integer ppid, Set TPubResources, Set TPubRoleprivileges) {
        this.pname = pname;
        this.pismenu = pismenu;
        this.ppid = ppid;
        this.TPubResources = TPubResources;
        this.TPubRoleprivileges = TPubRoleprivileges;
    }

   
    // Property accessors

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public Short getPismenu() {
        return this.pismenu;
    }
    
    public void setPismenu(Short pismenu) {
        this.pismenu = pismenu;
    }

    public Integer getPpid() {
        return this.ppid;
    }
    
    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Set getTPubResources() {
        return this.TPubResources;
    }
    
    public void setTPubResources(Set TPubResources) {
        this.TPubResources = TPubResources;
    }

    public Set getTPubRoleprivileges() {
        return this.TPubRoleprivileges;
    }
    
    public void setTPubRoleprivileges(Set TPubRoleprivileges) {
        this.TPubRoleprivileges = TPubRoleprivileges;
    }

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}
   








}