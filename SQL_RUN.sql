select * from tab;

select * from TEST;

create table TEST(
	ID varchar2(30),
	PW varchar2(30)
)

select DOLL_ID, DOLL_NAME, DOLL_GRADE, DOLL_CLASS
from DOLLS_STORAGE join DOLLS_INFORMATION using(DOLL_ID)
where DOLL_SECNO = 187
	
select DOLL_ID, DOLL_NAME from DOLLS_INFORMATION where DOLL_ID=1
select USER_ID, DOLL_ID, DOLL_SECNO, DOLL_NAME, DOLL_GRADE, DOLL_CLASS, DOLL_LV from DOLLS_STORAGE join DOLLS_INFORMATION using(DOLL_ID) where DOLL_SECNO = 100 order by USER_ID, DOLL_SECNO

ALTER TABLE DOLLS_INFORMATION rename column DOOL_NAME to DOLL_NAME
ALTER TABLE DOLLS_CHOICE
modify DOLL_ID NUMBER(3)

update ACCOUNT set USER_LV = 1 where USER_ID = 'kimmingi'

ALTER TABLE  ADD(resid number(9)); 

SELECT USER_NEEDEXP FROM USEREXP


-- 시퀀스 칼럼을 만든다.
create sequence seq_cust;
-- 시퀀스를 추가할때 .nextvall을 이용해 번호를 자동생성해준다.
insert into emp(id, name) values(seq_cust.nextvall, '이름')

create table TEST_ACCOUNT(
	USER_ID varchar2(30) primary key,
	USER_PW varchar2(30) NOT NULL,
	CREATION_DATE DATE NOT NULL,
	USER_LV NUMBER(3) NOT NULL,
	USER_EXE NUMBER(10) NOT NULL,
	USER_NEEDEXE NUMBER(10) NOT NULL
)

DROP TABLE TEST_DOLLS_INFORMATION;

SELECT * FROM TEST_DOLLS_INFORMATION

create table TEST_DOLLS_INFORMATION(
	DOLL_ID varchar2(3) primary key,
	DOLL_NAME varchar2(100) not null,
	DOLL_GRADE varchar2(1) not null,
	DOLL_CLASS VARCHAR2(3) not null,
	DOLL_HP number(5) not null,
	DOLL_ATK number(4) not null,
	DOLL_HIT number(4) not null,
	DOLL_AVOID number(4) not null,
	DOLL_ATKSPEED number(4) not null,
	DOLL_MOV number(2) not null,
	DOLL_TIME VARCHAR2(10),
	DOLL_MAGAZINE number(2) not null,
	DOLL_ARMOR number(3) not null,
	DOLL_COUNT number not null
)

create table students(
  std_id char(8)  primary key,
  name varchar2(20),
  email varchar2(20)  unique,
  phone varchar(11) not null,
  gender char(1)  check( gender in ('M','F')  ),
  tuition_fee number(9)  check( tuition_fee <=1000000 ),
  major_id number  
  constraint major_id_fk references major(major_id)
)

update RESOURCES set MANPOWER = MANPOWER + 900, AMMUNITON = AMMUNITON + 900, FOOD = FOOD + 900, PARTS = PARTS + 250 where USER_ID = 'mingilab';