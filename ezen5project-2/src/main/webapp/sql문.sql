drop database if exists Temproject3;
create database Temproject3;
use Temproject3;

drop table if exists sns;
create table sns(
	sno int auto_increment,
	simg longtext not null,
	sid varchar(12) not null,
    scontent text not null,
    spwd varchar(50) not null,
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

# ucheck 	- 0 : 결정x	1 : 좋아요	2 : 싫어요
drop table if exists usercheck;
create table usercheck(
	uno int auto_increment,				-- pk
	uip varchar(30) unique not null,	-- 유저 ip
	ucheck int default 0,				-- 유저 반응
    sno int,
    primary key(uno),
    foreign key (sno) references sns (sno)
);