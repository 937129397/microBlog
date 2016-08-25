create database microblog;
use microblog;
 
--用户
create table users(
	uid int, 
	email varchar(40),  
	password varchar(40),
	nickname varchar(100),
	pic varchar(100),
	telephone varchar(12),
	level int,
	exp int,
	regDate date,
	realname varchar(40),
	sex int,
	birthday varchar(10)
);

drop table users;
select * from users
--关注
create table concern(
	id int primary key ,
	b_uid int,--博主id
	f_uid int,--粉丝id
	note varchar(100),--备注 粉丝对博主的备注
	group_id int --分组 粉丝对博主的分组
)
--微博表
create table blog(
	id bigint primary key ,
	uid int,--发文者 id
	text varchar(300),--博文内容
	pic varchar(1000),--附加图片
	video varchar(1000),
	fdate date,--发文时间
	source bigint--是否为转发 如果为转发 则存来源微博id
)
--评论
create table comment(
	id bigint primary key ,
	blog_id bigint,--微博id
	c_uid int,--评论人id
	text varchar(300)--评论内容
)
--分组名表
create table groups(
	id int primary key,
	name varchar(30) --分组名
)
insert into groups(id,name) values(0,'朋友');
insert into groups(id,name) values(1,'同事');
insert into groups(id,name) values(2,'亲人');
insert into groups(id,name) values(3,'搞笑');
insert into groups(id,name) values(4,'名人明星');

select name from groups limit 1,4

--用户分组表
create table user_group(
	id  int primary key,	
	uid int ,
	group_id int
)

insert into user_group(id,uid,group_id) values(0,0,0);
