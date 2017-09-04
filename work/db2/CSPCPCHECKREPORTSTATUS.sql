
CREATE PROCEDURE CSPCPCHECKREPORTSTATUS ( ) 
  SPECIFIC SQL100908162345819
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
--| ** ObjectName: cspcpCheckReportStatus
--| **
--| ** Description:
--| **      每天检查报表，将超过时间的报表修改为“未上报”''
--| **      
--| */

    DECLARE v_iReturnCode INTEGER;
    
    DECLARE v_iError INTEGER;
    
    DECLARE v_iReportId INTEGER;--报表ID
    
    DECLARE v_iSwichid INTEGER;--报表开关ID
    
    DECLARE v_iYear INTEGER;--年份
    
    DECLARE v_iQuater INTEGER;--季度

    
    DECLARE v_count INTEGER;--计数器
    
    DECLARE v_type INTEGER;--报表类型
    
    DECLARE v_iReportYear INTEGER;
    
    DECLARE v_iReportMonth INTEGER;
    
    DECLARE v_iCursorStatus INTEGER;
    
    DECLARE l_sqlstatus INTEGER;
    
    DECLARE SQLCODE INTEGER DEFAULT 0;
    
    DECLARE l_sqlcode INTEGER DEFAULT 0;


    DECLARE report_cursor CURSOR FOR 
		
    select c.switchid,c.reportid,r.prtype,c.year,c.quater from reportswitch c,report r where c.reportid=r.reportid and c.status=1;
    
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
    FETCH FROM report_cursor INTO v_iSwichid,v_iReportId,v_type,v_iyear,v_iquater;

    SET v_iCursorStatus = l_sqlstatus;

    WHILE v_iCursorStatus = 0 DO

				IF v_type=1 AND days(FCHECKDATE(v_iquater, v_type,v_iyear))<days(current date) THEN
					IF v_iReportId = 1 THEN
						select count(*) into v_count from innercontrol where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 2 THEN
						select count(*) into v_count from organdpost where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 3 THEN
						select count(*) into v_count from active where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 4 THEN
						select count(*) into v_count from train where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 5 THEN
						select count(*) into v_count from Inneraudit where switchid=v_iSwichid;
					END IF;
					IF v_count=0 THEN
							update ReportSwitch set status=2 where switchid=v_iSwichid;
					END IF;
					
			ELSEIF v_type=2 AND days(FCHECKDATE(v_iquater, v_type,v_iyear))<days(current date) THEN
					IF v_iReportId = 6 THEN
						select count(*) into v_count from IDENTITY_SB where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 7 THEN
						select count(*) into v_count from IDENTITY_RSB where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 8 THEN
						select count(*) into v_count from IDENTITY_KY where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 9 THEN
						select count(*) into v_count from susreport where switchid=v_iSwichid;
					END IF;
					IF v_iReportId = 10 THEN
						select count(*) into v_count from publics where switchid=v_iSwichid;
					END IF;
					
						IF v_count=0 THEN
							update ReportSwitch set status=2 where switchid=v_iSwichid;
						END IF;
						
			END IF;
			SET v_count=0;
            FETCH FROM report_cursor INTO v_iSwichid,v_iReportId,v_type,v_iyear,v_iquater;
        SET v_iCursorStatus = l_sqlstatus;
    
    END WHILE ;

    CLOSE report_cursor;

    SET v_iError = l_sqlcode;

    IF v_iError <> 0 THEN 
	ROLLBACK to SAVEPOINT savepoint1;    
    END IF;

END;

#SYNC 20;



-- End of generated script for FRED-DB2-HELPER (db2admin)