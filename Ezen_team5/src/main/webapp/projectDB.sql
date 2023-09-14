drop database if exists usedtrade;
create database usedtrade;
use usedtrade;

# 회원정보 테이블
drop table if exists memberlist;
create table memberlist(
   mno int auto_increment,            
    mname varchar(30) not null,         -- 이름
    msno varchar(20) unique not null,   -- 주민번호
    mphone varchar(20) unique not null,   -- 전화번호
    memail varchar(50) unique not null,   -- 이메일
    madress varchar(100) not null,      -- 주소
    mid varchar(20) unique not null,   -- 아이디
    mpwd varchar(20) not null,         -- 비빌번호
    mlevel int,                     -- 칭호
    mpoint int,                     -- 포인트
    primary key(mno)
);

# 카테고리
drop table if exists category;
create table category(
   cno int auto_increment,
    cname varchar(30) not null,      -- 카테고리명
    primary key(cno)
);

# 게시판
drop table if exists board;
create table board(
   bno int auto_increment,
    btitle longtext not null,      -- 제목
    bcontent longtext not null,      -- 작성내용
    bdate datetime default now(),   -- 작성일
    bfile longtext,               -- 첨부파일
    mno int,                  -- 작성자
    cno int,                  -- 카테고리
    primary key(bno),
    foreign key( mno ) references memberlist ( mno ),
   foreign key( cno ) references category ( cno )
);

# 중개거래소
drop table if exists emediation;
create table emediation(
   eno int auto_increment,   
   ename varchar(50) not null,      -- 중개거래소분류
    eadress varchar(100) not null,   -- 중개거래소 주소
   elat varchar(30) not null,      -- 위도
    elng varchar(30) not null,      -- 경도
    primary key(eno)
);

# 대분류 물품 카테고리
drop table if exists umaincategory;
create table umaincategory(
   uno int auto_increment,
    uname varchar(50) not null,      -- 대분류 카테고리명
    primary key(uno)
);

# 소분류 물품 카테고리
drop table if exists dsubcategory;
create table dsubcategory(
   dno int auto_increment,
    dname varchar(50) not null,      -- 소분류 카테고리명
    uno int not null,            -- 대분류 카테고리
    primary key(dno),
    foreign key( uno ) references umaincategory ( uno )
);

# 판매물품정보
drop table if exists itemsinfo;
create table itemsinfo(
   ino int auto_increment,
   iprice int not null,               -- 판매가격
    mno int not null,                  -- 판매자
    itrade tinyint not null,            -- 거래방식( 1 배송, 2 대면거래, 3 중개거래 )
    itradeplace varchar(100) not null,      -- 거래장소
    idate datetime default now(),         -- 판매물품 등록일시
    eno int,                        -- 중개소 번호( 중개소거래를 이용할 시 )
    iestate int not null,               -- 거래상태( 0 판매중 1 판매완료 )
    dno int not null,                  -- 소분류 뭂품 카테고리
    isafepayment tinyint not null,         -- 안전결제사용여부( 0 미사용 1 사용 )
    keepstate int not null,               -- 중개거래소 물품 보관 여부
    primary key(ino),
    foreign key( mno ) references memberlist ( mno ),
    foreign key( eno ) references emediation ( eno ),
    foreign key( dno ) references dsubcategory ( dno )
);

# 위/경도 (대면거래)
drop table if exists dpoint;
create table dpoint(
   dno int auto_increment,
   dlat varchar(30) not null,   -- 위도
    dlng varchar(30) not null,   -- 경도
    ino int,
    primary key(dno),
    foreign key(ino) references itemsinfo(ino)
);

# 판매물품 이미지
drop table if exists pimg;
create table pimg(
   pno int auto_increment,
    pimg longtext,         -- 이미지
    ino int,            -- 판매물품
    primary key(pno),
    foreign key(ino) references itemsinfo(ino)
);

# 찜 (판매중인 물품만 해당)
drop table if exists watchitem;
create table watchitem(
   wno int auto_increment,
    mno int not null,               -- 찜한 이용자
    ino int not null,               -- 찜한 물품
    primary key(wno),
   foreign key( mno ) references memberlist ( mno ),
    foreign key( ino ) references itemsinfo ( ino )
);

# 거래내역 (거래완료된 물품만 해당)
drop table if exists tradelog;
create table tradelog(
   tno int auto_increment,
    buyer int not null,            -- 구매자
    tradedate datetime not null,   -- 거래일시
    ino int not null,            -- 거래물품
    primary key(tno),
    foreign key( buyer ) references memberlist ( mno ),
   foreign key( ino ) references itemsinfo ( ino )
);

# 채팅
drop table if exists jchatting;
create table jchatting(
   jno int auto_increment,            
    Caller int,                     -- 발신자
   receiver int,                  -- 수신자
   jcontent longtext,               -- 내용
    jchatdate datetime default now(),   -- 채팅일시
    ino int,                     -- 판매물품
    primary key(jno),
    foreign key( ino ) references itemsinfo ( ino )
);