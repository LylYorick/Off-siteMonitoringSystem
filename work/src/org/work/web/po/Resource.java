package org.work.web.po;



/**
 * RESOURCE entity. @author MyEclipse Persistence Tools
 */

public class Resource  implements java.io.Serializable {


    // Fields    

     private String prid;
     private Privilege TPubPrivilege;
     private String prname;
     private Short prismenu;
     private String prurl;
     private String prupdatetime;
     private String prauthor;


    // Constructors

    /** default constructor */
    public Resource() {
    }

	/** minimal constructor */
    public Resource(String prname, Short prismenu) {
        this.prname = prname;
        this.prismenu = prismenu;
    }
    
    /** full constructor */
    public Resource(Privilege TPubPrivilege, String prname, Short prismenu, String prurl, String prupdatetime,String prauthor) {
        this.TPubPrivilege = TPubPrivilege;
        this.prname = prname;
        this.prismenu = prismenu;
        this.prurl = prurl;
        this.prupdatetime = prupdatetime;
        this.prauthor = prauthor;
    }

   
    // Property accessors

    public String getPrid() {
        return this.prid;
    }
    
    public void setPrid(String prid) {
        this.prid = prid;
    }

    public Privilege getTPubPrivilege() {
        return this.TPubPrivilege;
    }
    
    public void setTPubPrivilege(Privilege TPubPrivilege) {
        this.TPubPrivilege = TPubPrivilege;
    }

    public String getPrname() {
        return this.prname;
    }
    
    public void setPrname(String prname) {
        this.prname = prname;
    }

    public Short getPrismenu() {
        return this.prismenu;
    }
    
    public void setPrismenu(Short prismenu) {
        this.prismenu = prismenu;
    }

    public String getPrurl() {
        return this.prurl;
    }
    
    public void setPrurl(String prurl) {
        this.prurl = prurl;
    }

	public String getPrupdatetime() {
		return prupdatetime;
	}

	public void setPrupdatetime(String prupdatetime) {
		this.prupdatetime = prupdatetime;
	}

	public String getPrauthor() {
		return prauthor;
	}

	public void setPrauthor(String prauthor) {
		this.prauthor = prauthor;
	}
   








}