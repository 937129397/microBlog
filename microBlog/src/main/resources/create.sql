create database microblog;
use microblog;
 
--用户
create table users(
	uid int primary key, 
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
	birthday varchar(20),
	sign varchar(300)
);

insert into users(uid,email,nickname,password,telephone,sign) 
values(1,'123@qq.com','王大锤','123123','11111111111','长江后浪推前浪，前浪死在沙滩上！');
insert into users(uid,email,nickname,password,telephone,sign) 
values(2,'111@qq.com','王二锤','123123','11111111112','长江后浪推前浪，前浪死在沙滩上！');
insert into users(uid,email,nickname,password,telephone,sign) 
values(3,'122@qq.com','王三锤','123123','11111111113','长江后浪推前浪，前浪死在沙滩上！');

drop table users;
select * from users

insert users(uid) values(0);
--关注
create table concern(
	id int primary key ,
	b_uid int,--博主id
	f_uid int,--粉丝id
	note varchar(100),--备注 粉丝对博主的备注
	group_id int --分组 粉丝对博主的分组
)

select * from concern
insert into concern values(1,1,2,'zz',1);
insert into concern values(2,1,3,'zz',1);


delete from concern where id=1;

select nickname from users where uid=2

select uid,nickname from users where uid in(select f_uid from concern c 
inner join users u on c.b_uid=u.uid where c.b_uid=1)

select count(1) from concern where b_uid=1


select * from concern;
--微博表;
create table blog(
	id bigint primary key ,
	uid int,
	text varchar(300),
	pic varchar(1000),
	video varchar(1000),
	fdate date,
	source bigint
)

insert into blog(id,uid,text) values(1,1,'xxxxx')

select count(1) from blog where uid=1
--评论
create table comment(
	id int primary key ,
	blog_id bigint,
	c_uid int,
	text varchar(300),
	ctime varchar(20) 
)

drop table comment

insert into comment(id) values(0)
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



delete a,b from user_group a,groups b 
where a.group_id=5 and a.group_id=b.id

select * from user_group
select * from groups

select * from user_group where uid=1

select * from user_group inner join groups on user_group.group_id=groups.id where uid=1;

insert into user_group(id,uid,group_id) values(0,0,0);


select *,group_id gid from user_group where uid=1
