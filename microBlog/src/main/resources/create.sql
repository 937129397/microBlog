create database microblog;
use microblog;
 
--用户
create table users(
	uid int, 
	email varchar(40),  --用户名  登录用
	password varchar(40),--密码
	nickname varchar(100),--昵称  可任意改
	pic varchar(100),--头像  存图片 服务器路径字符串
	telephone bigint,--电话
	level int,--用户等级
	exp int,--用户经验
	regDate date,--注册时间
	sex int,--性别 0男1女
	birthday varchar(10),--生日
);

select * from users;
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
	video
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
--用户分组表
create table user_group(
	id  int primary key,	
	uid int ,--用户
	group_id int--分组id
)
