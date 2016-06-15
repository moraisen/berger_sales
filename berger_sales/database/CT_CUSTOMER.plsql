create or replace PROCEDURE CT_CUSTOMER IS
  v_tabcnt NUMBER;
BEGIN
  SELECT count(*) INTO v_tabcnt
  FROM   ALL_TABLES
  WHERE  TABLE_NAME = 'CUSTOMER' and
         OWNER = USER;

  if v_tabcnt = 0 THEN
    EXECUTE IMMEDIATE 'CREATE TABLE CUSTOMER
                       (
							  CUSTOMER_ID	INTEGER PRIMARY KEY,
							  FIRSTNAME     VARCHAR2(20),
							  CREDIT        DECIMAL(10,2),
						)';
    COMMIT;
  end if;
  END CT_CUSTOMER;