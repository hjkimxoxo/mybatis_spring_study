INSERT INTO DEPARTMENT VALUES(1, '영업', 8);
INSERT INTO DEPARTMENT VALUES(2, '기획', 10);
INSERT INTO DEPARTMENT VALUES(3, '개발', 9);
INSERT INTO DEPARTMENT VALUES(4, '총무', 7);

INSERT INTO EMPLOYEE VALUES(4377, '이성래', 1, NULL, 5000000, 2);
INSERT INTO EMPLOYEE VALUES(3426, '박영권', 3, 4377, 3000000, 1);
INSERT INTO EMPLOYEE VALUES(3011, '이수민', 2, 4377, 4000000, 3);
INSERT INTO EMPLOYEE VALUES(3427, '최종철', 5, 3011, 1500000, 3);
INSERT INTO EMPLOYEE VALUES(1003, '조민희', 3, 4377, 3000000, 2);
INSERT INTO EMPLOYEE VALUES(2106, '김창섭', 4, 1003, 2500000, 2);
INSERT INTO EMPLOYEE VALUES(1365, '김상원', 5, 3426, 1500000, 1);

SELECT * FROM DEPARTMENT;