create table ts_test
(
	id int auto_increment primary key ,
	userName varchar(32) not null comment '用户名',
	age int default 0 null comment '年龄',
	# 这张表的名字不能重复
	unique ts_test_userName(userName)
)
comment '测试项目测试表';