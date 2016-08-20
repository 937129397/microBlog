create database microblog;
use microblog;
 
--用户
create table users(
	uid vahchar(20),
	uname varchar(40),
	password varchar(40),
	nickname varchar(100),
	pic varchar(100),
	telephone int,
	level int,
	exp int,
	regDate date,
	realname varchar(40)，
	sex int,
	birthday varchar(10),
);


--关注
create table concern(
	id int primary key auto_increment,
	b_uid varchar(20),
	f_uid varchar(20),
	note varchar(100),
	groupid int 
)

create table blog(
	id bigint primary key auto_increment,
	uid varchar(20),
	text varchar(300),
	pic varchar(1000),
	comment int,
	fdate date,
	source bigint
)

