package org.work.web.po;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * ROLE entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private String rid;
     private String rname;
     private String rmark;
     /*用户集合*/
     private Set TPubRoleusers = new HashSet(0);
     /*权限集合*/
     private Set TPubRoleprivileges = new HashSet(0);
  
    // Constructors


	/** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String rname) {
        this.rname = rname;
    }
    
    /** full constructor */
    public Role(String rname, String rmark, Set TPubRoleusers, Set TPubRoleprivileges) {
        this.rname = rname;
        this.rmark = rmark;
        this.TPubRoleusers = TPubRoleusers;
        this.TPubRoleprivileges = TPubRoleprivileges;
    }

   
    // Property accessors

    public String getRid() {
        return this.rid;
    }
    
    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return this.rname;
    }
    
    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRmark() {
        return this.rmark;
    }
    
    public void setRmark(String rmark) {
        this.rmark = rmark;
    }

	@JSON(serialize = false)
    public Set getTPubRoleusers() {
        return this.TPubRoleusers;
    }
    
    public void setTPubRoleusers(Set TPubRoleusers) {
        this.TPubRoleusers = TPubRoleusers;
    }
    
	@JSON(serialize = false)
    public Set getTPubRoleprivileges() {
        return this.TPubRoleprivileges;
    }
    
    public void setTPubRoleprivileges(Set TPubRoleprivileges) {
        this.TPubRoleprivileges = TPubRoleprivileges;
    }
   


}