package org.work.web.po;


/**
 * po entity. @author MyEclipse Persistence Tools
 */

public class LogInfo  implements java.io.Serializable {


    // Fields    

     private Integer logid;
     private String operatorid;
     private String operatorname;
     private String time;
     private String operatetype;
     private String operatedetail;


    // Constructors

    /** default constructor */
    public LogInfo() {
    }

    
    /** full constructor */
    public LogInfo(String operatorid, String operatorname, String time, String operatetype, String operatedetail) {
        this.operatorid = operatorid;
        this.operatorname = operatorname;
        this.time = time;
        this.operatetype = operatetype;
        this.operatedetail = operatedetail;
    }

   
    // Property accessors

    public Integer getLogid() {
        return this.logid;
    }
    
    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getOperatorid() {
        return this.operatorid;
    }
    
    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getOperatorname() {
        return this.operatorname;
    }
    
    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getOperatetype() {
        return this.operatetype;
    }
    
    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype;
    }

    public String getOperatedetail() {
        return this.operatedetail;
    }
    
    public void setOperatedetail(String operatedetail) {
        this.operatedetail = operatedetail;
    }
   








}