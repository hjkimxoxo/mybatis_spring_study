SELECT * FROM department ORDER BY DEPTNO;

UPDATE SET DEPTNAME='마케팅', FLOOR=20 WHERE DEPTNO=5; 
DELETE FROM DEPARTMENT WHERE DEPTNO=5;

SELECT EMPNO,EMPNAME,TITLE,MANAGER,SALARY,DNO FROM employee;

SELECT EMPNO,EMPNAME,TITLE,MANAGER,SALARY,DNO FROM EMPLOYEE WHERE EMPNO = 4377;

SELECT * FROM DEPARTMENT;
SELECT * FROM employee;

DELETE FROM department WHERE deptno = 5;
DELETE FROM EMPLOYEE WHERE empno=1004;