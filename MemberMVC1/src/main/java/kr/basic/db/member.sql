-- select * from member; -- alt + s=> 쿼리문 실행

-- drop table member;

create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(20) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null,
	unique key(id)
);