CREATE FUNCTION CSFCGGETMONTH
 (V_DTNEWDATE TIMESTAMP,
  V_IREPORTTYPE INTEGER
 ) 
  RETURNS SMALLINT
  SPECIFIC SQL051228184205700
  LANGUAGE SQL
  NOT DETERMINISTIC
  READS SQL DATA
  STATIC DISPATCH
  CALLED ON NULL INPUT
  EXTERNAL ACTION
  INHERIT SPECIAL REGISTERS
  BEGIN ATOMIC
    DECLARE v_iMonth INTEGER;
    IF V_IREPORTTYPE = 1 THEN
      SET v_iMonth = MONTH(V_DTNEWDATE);
      IF v_iMonth = 1 THEN
        SET v_iMonth = 12;
      ELSE
        SET v_iMonth = v_iMonth - 2;
      END IF;
    ELSE
      SET v_iMonth = (MONTH(V_DTNEWDATE) + 2 ) / 3;
      IF v_iMonth = 1 THEN
        SET v_iMonth = 4;
      ELSE
        SET v_iMonth = v_iMonth - 2;
      END IF;
    END IF;
    RETURN v_iMonth;
  END;