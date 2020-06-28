SHOW DATABASES;
CREATE DATABASE IF NOT EXISTS JAVAWEB;

USE JAVAWEB;

-- ----------------------------------------
DROP TABLE T_MEMBER;
CREATE TABLE IF NOT EXISTS t_member (
	id		varchar(10),
	pw	varchar(10),
	name	varchar(50),
	email varchar(50),
	joinDate datetime default now(),
	primary key(id)
);

-- 회원 정보 추가

insert into t_member
values('han' ,'1212', '한동현', 'dong@naver.com', default);

insert into t_member
values('lee', '1212', '이순신', 'lee@gmail.com', default);

insert into t_member
values('kim', '1212', '김유신', 'kim@web.com', default);

commit;	-- SQL Developer에서 테이블에 회원저보를 추가한 후 반드시 커밋을 해줘야 영구적으로 반영됨

select * from t_member;