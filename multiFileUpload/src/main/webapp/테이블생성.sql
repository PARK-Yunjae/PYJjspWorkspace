use testdb;
-- drop table myfile;
create table myfile (
    idx int auto_increment primary key,
    title varchar(200) not null,
    cate varchar(100),
    ofile varchar(100) not null,
    sfile varchar(30) not null,
    postdate date not null
);

delete from myfile;
select * from myfile;

alter user 'root@localhost' identified by 'Abcd123@';

alter user 'root'@'localhost' identified with mysql_native_password by 'Abcd123@';