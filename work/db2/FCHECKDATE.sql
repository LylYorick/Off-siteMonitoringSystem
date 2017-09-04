
CREATE FUNCTION FCHECKDATE
 (V_QUATER INTEGER,
  V_TYPE INTEGER,
  V_YEAR INTEGER
 ) 
  RETURNS DATE
  SPECIFIC SQL100908165616400
  LANGUAGE SQL
  NOT DETERMINISTIC
  READS SQL DATA
  STATIC DISPATCH
  CALLED ON NULL INPUT
  EXTERNAL ACTION
  INHERIT SPECIAL REGISTERS
  BEGIN ATOMIC
    IF v_type=1 THEN
      return cast(rtrim(CHAR(v_year))||'-12-31' as date);
    END IF;
    IF v_type=2 THEN
      IF v_quater=1 THEN
        return cast(rtrim(CHAR(v_year))||'-03-31' as date);
      ELSEIF v_quater=2 THEN
        return cast(rtrim(CHAR(v_year))||'-06-30' as date);
      ELSEIF v_quater=3 THEN
        return cast(rtrim(CHAR(v_year))||'-09-30' as date);
      ELSEIF v_quater=4 THEN
        return cast(rtrim(CHAR(v_year))||'-12-31' as date);
      END IF;
    END IF;
  END;



-- End of generated script for FRED-DB2-HELPER (db2admin)