SELECT USER FROM DUAL;

CREATE USER SPRING_MYBATIS IDENTIFIED BY rootroot;

GRANT CONNECT, RESOURCE, CREATE SYNONYM, CREATE VIEW TO SPRING_MYBATIS;

SELECT * FROM DBA_USERS WHERE USERNAME = 'SPRING_MYBATIS';