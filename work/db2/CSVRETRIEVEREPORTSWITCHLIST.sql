CREATE VIEW CSVRETRIEVEREPORTSWITCHLIST
  AS  SELECT a.REPORTID, c.oid,CSFCGGETYEAR(CURRENT TIMESTAMP,0) AS iReportYear , 0 
    AS iReportMonth
  FROM Report a,B_ORG_INFORMATION c
  where a.startday <= DAY(CURRENT TIMESTAMP )
    and a.prtype=1
    and c.ishead='0'
UNION
SELECT a.REPORTID, c.oid,CSFCGGETYEAR(CURRENT TIMESTAMP,1) AS iReportYear , 
    CSFCGGETMONTH(CURRENT TIMESTAMP,2) AS iReportMonth
  FROM Report a,B_ORG_INFORMATION c
  where csfcgCheckStartDay(CURRENT TIMESTAMP , a.startmonth, a.startday) = 1
    and a.prtype=2
    and c.ishead='0';



-- End of generated script for FRED-DB2-FXQSZ (db2admin)