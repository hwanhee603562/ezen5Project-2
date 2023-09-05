drop database if exists Temproject3;
create database Temproject3;
use Temproject3;

drop table if exists sns;
create table sns(
	sno int auto_increment,
	simg longtext not null,
	sid varchar(12) not null,
    scontent text not null,
    spwd varchar(6) not null,
    sdate datetime default now(),
    primary key(sno)
);
use sns;
insert into sns(sid, spwd, simg, scontent) values('azz2258', 'dlm222l', 'dskf', '안녕');
select * from reply;

drop table if exists reply;
create table reply(
	rno int auto_increment,
    rpwd varchar(6) not null,
    rcontent text not null,
    rdate datetime default now(),
    sno int,
    primary key(rno),
    foreign key(sno) references sns(sno) on delete cascade
);