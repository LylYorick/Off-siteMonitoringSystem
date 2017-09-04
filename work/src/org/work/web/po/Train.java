package org.work.web.po;



/**
 * Train entity. @author MyEclipse Persistence Tools
 */

public class Train  implements java.io.Serializable {


    // Fields    

     private Long trdid;
     private Reportswitch reportswitch;
     private String trdate;
     private String trcnt;
     private String trobjt;
     private String trnum;
     private String trmethod;


    // Constructors

    /** default constructor */
    public Train() {
    }

    
    /** full constructor */
    public Train(Reportswitch reportswitch, String trdate, String trcnt, String trobjt, String trnum, String trmethod) {
        this.reportswitch = reportswitch;
        this.trdate = trdate;
        this.trcnt = trcnt;
        this.trobjt = trobjt;
        this.trnum = trnum;
        this.trmethod = trmethod;
    }

   
    // Property accessors

    public Long getTrdid() {
        return this.trdid;
    }
    
    public void setTrdid(Long trdid) {
        this.trdid = trdid;
    }


    public Reportswitch getReportswitch() {
		return reportswitch;
	}


	public void setReportswitch(Reportswitch reportswitch) {
		this.reportswitch = reportswitch;
	}


	public String getTrdate() {
        return this.trdate;
    }
    
    public void setTrdate(String trdate) {
        this.trdate = trdate;
    }

    public String getTrcnt() {
        return this.trcnt;
    }
    
    public void setTrcnt(String trcnt) {
        this.trcnt = trcnt;
    }

    public String getTrobjt() {
        return this.trobjt;
    }
    
    public void setTrobjt(String trobjt) {
        this.trobjt = trobjt;
    }

    public String getTrnum() {
        return this.trnum;
    }
    
    public void setTrnum(String trnum) {
        this.trnum = trnum;
    }

    public String getTrmethod() {
        return this.trmethod;
    }
    
    public void setTrmethod(String trmethod) {
        this.trmethod = trmethod;
    }
   








}