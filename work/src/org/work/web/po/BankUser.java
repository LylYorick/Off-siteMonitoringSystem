package org.work.web.po;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * BANKUSER entity. @author MyEclipse Persistence Tools
 */

public class BankUser  implements java.io.Serializable {


    // Fields    

     private String buid;
     private String buname;
     private String bupswd;
     private String bumark;
     private String brname;//用户名称
     private String btel;
     private String bmail;
     private String buupdatetime;
     private String buauthor;
     private String bustatus;
     private String loadtime;
     private Information information;
     private Archives archives;
     /*银行用户角色*/
     private Set<Role> TPubRoleusers = new HashSet<Role>(0);
     private Set<Privilege> allprlgs = new HashSet<Privilege>(10);//用于存储该用户拥有的所有权限
     private List menus ;//用户存储用户所拥有的菜单

    // Constructors

    /** default constructor */
    public BankUser() {
    }

	/** minimal constructor */
    public BankUser(String buname, String bupswd) {
        this.buname = buname;
        this.bupswd = bupswd;
    }
    
    /** full constructor */
   
    public BankUser(String buid, String buname, String bupswd, String bumark,
    		String brname, String btel, String bmail, String buupdatetime,
    		String buauthor, String bustatus, String loadtime,
    		Information information, Archives archives,
    		Set<Role> tPubRoleusers, Set<Privilege> allprlgs, List menus) {
    	super();
    	this.buid = buid;
    	this.buname = buname;
    	this.bupswd = bupswd;
    	this.bumark = bumark;
    	this.brname = brname;
    	this.btel = btel;
    	this.bmail = bmail;
    	this.buupdatetime = buupdatetime;
    	this.buauthor = buauthor;
    	this.bustatus = bustatus;
    	this.loadtime = loadtime;
    	this.information = information;
    	this.archives = archives;
    	TPubRoleusers = tPubRoleusers;
    	this.allprlgs = allprlgs;
    	this.menus = menus;
    }
   
    // Property accessors

    public String getBuid() {
        return this.buid;
    }
    

	public void setBuid(String buid) {
        this.buid = buid;
    }

    public String getBuname() {
        return this.buname;
    }
    
    public void setBuname(String buname) {
        this.buname = buname;
    }

    public String getBupswd() {
        return this.bupswd;
    }
    
    public void setBupswd(String bupswd) {
        this.bupswd = bupswd;
    }

    public String getBumark() {
        return this.bumark;
    }
    
    public void setBumark(String bumark) {
        this.bumark = bumark;
    }

	@JSON(serialize = false)
	public Set<Role> getTPubRoleusers() {
		return TPubRoleusers;
	}

	public void setTPubRoleusers(Set<Role> pubRoleusers) {
		TPubRoleusers = pubRoleusers;
	}

	@JSON(serialize = false)
	public Set<Privilege> getAllprlgs() {
		return allprlgs;
	}

	public void setAllprlgs(Set<Privilege> allprlgs) {
		this.allprlgs = allprlgs;
	}

	public List getMenus() {
		return menus;
	}

	public void setMenus(List menus) {
		this.menus = menus;
	}

	public String getBtel() {
		return btel;
	}

	public void setBtel(String btel) {
		this.btel = btel;
	}

	public String getBmail() {
		return bmail;
	}

	public void setBmail(String bmail) {
		this.bmail = bmail;
	}

	public String getBuupdatetime() {
		return buupdatetime;
	}

	public void setBuupdatetime(String buupdatetime) {
		this.buupdatetime = buupdatetime;
	}

	public String getBuauthor() {
		return buauthor;
	}

	public void setBuauthor(String buauthor) {
		this.buauthor = buauthor;
	}

	public String getBustatus() {
		return bustatus;
	}

	public void setBustatus(String bustatus) {
		this.bustatus = bustatus;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}

	public String getLoadtime() {
		return loadtime;
	}

	public void setLoadtime(String loadtime) {
		this.loadtime = loadtime;
	}

	public Archives getArchives() {
		return archives;
	}

	public void setArchives(Archives archives) {
		this.archives = archives;
	}
	
}