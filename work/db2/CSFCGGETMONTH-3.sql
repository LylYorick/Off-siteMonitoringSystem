CREATE FUNCTION CSFCGGETMONTH
 (V_IYEAR INTEGER,
  V_IMONTH INTEGER,
  V_IREPORTTYPE INTEGER
 ) 
  RETURNS SMALLINT
  SPECIFIC SQL051228193744200
  LANGUAGE SQL
  NOT DETERMINISTIC
  READS SQL DATA
  STATIC DISPATCH
  CALLED ON NULL INPUT
  EXTERNAL ACTION
  INHERIT SPECIAL REGISTERS
  BEGIN ATOMIC
    DECLARE v_iComMonth INTEGER;
    SET v_iComMonth = v_iMonth;
    IF V_IREPORTTYPE = 1 THEN
      IF v_iComMonth = 1 THEN
        SET v_iComMonth = 12;
      ELSE
        SET v_iComMonth = v_iComMonth - 1;
      END IF;
    ELSE
      SET v_iComMonth = (v_iComMonth + 2 ) / 3;
      IF v_iComMonth = 1 THEN
        SET v_iComMonth = 4;
      ELSE
        SET v_iComMonth = v_iComMonth - 1;
      END IF;
    END IF;
    RETURN v_iComMonth;
  END;