CREATE PROCEDURE CSPCPCHECKREPORTTOREPORTSWITCH ( ) 
  SPECIFIC SQL100908151702317
  LANGUAGE SQL
  NOT DETERMINISTIC
  CALLED ON NULL INPUT
  MODIFIES SQL DATA
  INHERIT SPECIAL REGISTERS
  BEGIN
    
    DECLARE SQLSTATE CHAR(5) DEFAULT '00000';
    
    DECLARE l_error CHAR(5) DEFAULT '00000';
    
    DECLARE v_trancount INTEGER DEFAULT 0;
    
--| /*
--| ** ObjectName: cspcpCheckReportToReportSwitch
--| **
--| ** Description:
--| **      每天检查报表，抽取到ReportSwitch表中 1
--| **      其中已经当月或当季度报表抽取到开关表中的数据，不会重复的抽取
--| **      
--| */

    DECLARE v_iReturnCode INTEGER;
    
    DECLARE v_iError INTEGER;
    
    DECLARE v_iReportId INTEGER;
    
    DECLARE v_iBankId INTEGER;
    
    DECLARE v_iReportYear INTEGER;
    
    DECLARE v_iReportMonth INTEGER;
    
    DECLARE v_iCursorStatus INTEGER;
    
    DECLARE l_sqlstatus INTEGER;
    
    DECLARE SQLCODE INTEGER DEFAULT 0;
    
    DECLARE l_sqlcode INTEGER DEFAULT 0;


    DECLARE report_cursor CURSOR FOR 
		select * from CSVRetrieveReportSwitchList c1 
			where not exists(select * from ReportSwitch c2 
				where c1.OID = c2.OID and c1.ReportId = c2.ReportId 
				and c1.iReportYear = c2.Year and c1.iReportMonth = c2.QUATER);
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND
        
        SET l_sqlstatus = -1;
    
    DECLARE CONTINUE HANDLER FOR SQLWARNING
        
        SET l_error = SQLSTATE;
    
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
        
        BEGIN
            
            VALUES (SQLSTATE,SQLCODE)
            INTO l_error,
                 l_sqlcode;
            SET l_sqlstatus = -1;
            
            IF SUBSTR(l_error, 1, 1) >= '5'
               AND SUBSTR(l_error, 1, 1) <= '9' THEN 
                
                RESIGNAL;
            
            END IF;
        
        END;

    VALUES (0,0,0)
    INTO v_iReturnCode,
         v_iError,
         v_iCursorStatus;
  

    --设置回滚点
    SAVEPOINT savepoint1 ON ROLLBACK RETAIN CURSORS;

    OPEN report_cursor;

    SET l_sqlstatus = 0;
    FETCH FROM report_cursor INTO v_iReportId, v_iBankId,v_iReportYear,v_iReportMonth;

    SET v_iCursorStatus = l_sqlstatus;

    WHILE v_iCursorStatus = 0 DO

        INSERT INTO ReportSwitch (OID, REPORTID, YEAR, QUATER, UPDATETIME, UPDATEUSER) 
		VALUES (v_iBankId,v_iReportId,v_iReportYear,v_iReportMonth,CURRENT TIMESTAMP ,'system');
        FETCH FROM report_cursor INTO v_iReportId,v_iBankId,v_iReportYear,v_iReportMonth;
        SET v_iCursorStatus = l_sqlstatus;
    
    END WHILE ;

    CLOSE report_cursor;

    SET v_iError = l_sqlcode;

    IF v_iError <> 0 THEN 
	ROLLBACK to SAVEPOINT savepoint1;    
    END IF;

END;



-- End of generated script for FRED-DB2-FXQSZ (db2admin)