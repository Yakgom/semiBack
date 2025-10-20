SELECT * FROM Employee;

INSERT INTO EMPLOYEE (
    EMP_ID,
    EMP_NAME,
    EMP_NO,
    EMAIL,
    PHONE,
    DEPT_CODE,
    JOB_CODE,
    SAL_LEVEL,
    SALARY,
    BONUS,
    MANAGER_ID,
    HIRE_DATE,
    ENT_DATE,
    ENT_YN
) VALUES (
    'E1001',                           -- 사원번호
    '홍길동',                           -- 사원명
    '900101-1234567',                   -- 주민번호
    'hong@test.com',                    -- 이메일
    '010-1234-5678',                    -- 전화번호
    'D001',                             -- 부서코드
    'J002',                             -- 직급코드
    'S3',                               -- 급여등급
    3500000,                            -- 급여
    0.1,                                -- 보너스 (10%)
    'E1000',                            -- 관리자ID
    TO_DATE('2025-08-31', 'YYYY-MM-DD'),-- 입사일자
    NULL,                               -- 퇴사일자 (없으면 NULL)
    'Y'                                 -- 재직여부
);

SELECT sequence_name, min_value, max_value, increment_by, last_number
FROM user_sequences;

SELECT SEQ_EID.nextval FROM dual;

-- 1. 시퀀스 생성
CREATE SEQUENCE SEQ_PLANT_ID
START WITH 1
INCREMENT BY 1
NOCACHE;

DROP SEQUENCE SEQ_PLANT_ID;

-- 2. 테이블 생성
CREATE TABLE TB_PLANT (
    PLANT_ID       NUMBER PRIMARY KEY,
    PLANT_NAME     VARCHAR2(50) NOT NULL UNIQUE,
    PLANT_TYPE     VARCHAR2(30) NOT NULL,
    PLANT_HEIGHT   NUMBER NOT NULL CHECK (PLANT_HEIGHT > 0),
    PLANT_DATE     DATE DEFAULT SYSDATE,
    PLANT_LOCATION VARCHAR2(50)
);

DROP TABLE TB_PLANT;

-- 3. INSERT 예시
INSERT INTO TB_PLANT (PLANT_ID, PLANT_NAME, PLANT_TYPE, PLANT_HEIGHT, PLANT_LOCATION)
VALUES (SEQ_PLANT_ID.nextval, '장미', '실외', 50, '정원');

-- 4. 조회
SELECT 
	   PLANT_ID
	 , PLANT_NAME
	 , PLANT_TYPE
	 , PLANT_HEIGHT
	 , PLANT_DATE
	 , PLANT_LOCATION
FROM TB_PLANT;

-- 음료수 시퀀스 생성
CREATE SEQUENCE SEQ_DRINK_ID
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 테이블 생성
CREATE TABLE TB_VENDING (
    DRINK_ID       NUMBER PRIMARY KEY,                          -- 음료ID (PK)
    DRINK_NAME     VARCHAR2(50) NOT NULL UNIQUE,               -- 음료 이름 (NOT NULL, UNIQUE)
    DRINK_TYPE     VARCHAR2(20) NOT NULL CHECK (DRINK_TYPE IN ('탄산','주스','커피','차','물')), -- 음료 종류 제한
    PRICE          NUMBER(5,0) NOT NULL CHECK (PRICE > 0),     -- 가격 (0 이상)
    STOCK          NUMBER NOT NULL,                             -- 재고
    MANUFACTURE_DT DATE NOT NULL,                               -- 제조일
    EXPIRY_DT      DATE NOT NULL,                                        -- 유통기한 (제약 없음)
    VENDOR         VARCHAR2(50) NOT NULL                       -- 제조사
);

INSERT
  INTO
       TB_VENDING
       (
       DRINK_ID
     , DRINK_NAME
     , DRINK_TYPE
     , PRICE
     , Stock
     , MANUFACTURE_DT
     , EXPIRY_DT
     , VENDOR
       )
VALUES 
       (
       SEQ_DRINK_ID.nextval
     , '코카콜라'
     , '탄산'
     , 1200
     , 10
     , TO_DATE('2025-08-20','YYYY-MM-DD')
     , TO_DATE('2026-04-30','YYYY-MM-DD')
     , '코카콜라 컴퍼니'
       );
 


