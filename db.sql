# class table
create table classes(
                        id bigint primary key auto_increment,
                        class_name varchar(10) not null unique comment 'class name',
                        class_num int not null comment 'class number',
                        create_time datetime comment 'create time',
                        update_time datetime comment 'update time',
                        status tinyint default 0 comment 'status',
                        del_flag tinyint default 0 comment 'delete flag 0-exist 1-delete'
) comment 'class table';


insert into classes values
                        (null,'一年一班',1,now(),now(),0,0),
                        (null,'一年二班',1,now(),now(),0,0);


# student
create table student(
                        id bigint primary key auto_increment comment '主键',
                        name varchar(10) not null comment '姓名',
                        age tinyint not null comment '年龄',
                        email varchar(30) not null unique comment '邮箱',
                        birthday date comment '生日',
                        sex tinyint default 0 comment '性别 0-男 1-女',
                        create_time datetime comment '创建时间',
                        update_time datetime comment '修改时间',
                        status tinyint default 0 comment '状态',
                        del_flag tinyint default 0 comment '删除标志 0-可用 1-删除'
) comment '学生表';

insert into student values
                        (null, '小明',5, '123456@qq.com',now(),1,now(),now(), 0,0),
                        (null, '小红',5, '123486@qq.com',now(),1,now(),now(), 0,0)