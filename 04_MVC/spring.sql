DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID VARCHAR2(100) PRIMARY KEY,
    PASSWORD VARCHAR2(150) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    ADDRESS VARCHAR2(200) NOT NULL
);
SELECT * FROM MEMBER;

SELECT ID, PASSWORD, NAME, ADDRESS
	 	FROM MEMBER
        WHERE ID LIKE '%u%'
        OR PASSWORD LIKE '%u%'
        OR NAME LIKE '%u%'
        OR ADDRESS LIKE '%u%';
        
CREATE SEQUENCE SEQ_BOARD;
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO NUMBER,
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(2000) NOT NULL,
    WRITER VARCHAR2(50) NOT NULL,
    REGDATE DATE DEFAULT SYSDATE
);
SELECT NO, TITLE, CONTENT, WRITER, REGDATE FROM BOARD;

INSERT INTO BOARD VALUES(1, 'asd', 'asd', 'asd', '2011-12-20');

DELETE FROM BOARD WHERE NO = 1;

SELECT NO, TITLE, CONTENT, WRITER, REGDATE 
		FROM BOARD
        WHERE TITLE LIKE '%t%'
			OR CONTENT LIKE '%t%'
			OR WRITER LIKE '%t%';
UPDATE BOARD S
		TITLE = 't',
		CONTENT = 't',
		REGDATE
		WHERE WRITER = #{writer} AND NO = #{no};
SELECT * FROM BOARD ORDER BY NO DESC;
-- 힌트..!
SELECT NUM, NO, TITLE, WRITER, REGDATE, URL
FROM(
SELECT /*+ INDEX_DESC(BOARD PK_BOARD)*/ ROWNUM NUM, NO, TITLE, WRITER, REGDATE, URL FROM BOARD WHERE ROWNUM <=10
)
WHERE NUM>1;
SELECT ROWNUM NUM, NO, TITLE, CONTENT, FROM BOARD;
INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER)(SELECT SEQ_BOARD.NEXTVAL, TITLE, CONTENT, WRITER FROM BOARD);
COMMIT;
SELECT * FROM BOARD WHERE NO = 17421;
ALTER TABLE BOARD ADD CONSTRAINT PK_BOARD PRIMARY KEY(NO);
ALTER TABLE board ADD url VARCHAR(200);

drop table member;
create table member(
    id varchar2(50) primary key,
    password varchar2(100) not null,
    name varchar2(50) not null,
    address varchar2(200),
    auth varchar2(50) default 'ROLE_MEMBER' not null,
    enabled number(1) default 1 not null
);

SELECT * FROM MEMBER;

create table company (
	vcode varchar2(10) primary key,
	vendor  varchar2(20) not null
);
insert  into company values('10', '삼성');
insert  into company values('20', '애플');
create table Phone(
	num varchar2(10) primary key,
	model varchar2(20) not null,
	price number not null,
	vcode varchar2(10),
   constraint fk_vcode foreign key(vcode) references company(vcode)
);
insert into Phone values('ZF01','Galaxy Z Flip5', 1369000,'10');
insert into Phone values('S918N','Galaxy S23 Ultra', 1479000,'10');
insert into Phone values('IPO02','iPhone 14',1250000,'20');
create table userinfo (
	id varchar(20) primary key,
	pw varchar(20) not null
);
insert into userinfo values('member','member');
insert into userinfo values('admin','admin');
commit;











