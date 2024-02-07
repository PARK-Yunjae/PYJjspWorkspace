use board;

create table board(
	no int primary key auto_increment,
	writer varchar(20) not null,
	subject varchar(20) not null,
	contents varchar(1000) not null,
	regDate varchar(30) not null,
	unique key(no)
);

select * from board;

delete from board;

select * from board orders limit 5 offset 10;


insert into board value(null, "a", "a", "a", "2020-02-02");