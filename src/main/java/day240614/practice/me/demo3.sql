-- 创建班级表
create table if not exists class
(
    id          int primary key auto_increment comment '主键ID',
    name        varchar(50) not null unique comment '班级名',
    description varchar(512) comment '班级描述',
    created_at datetime not null comment '创建时间',
    updated_at datetime not null comment '修改时间'
) comment '班级';

-- 增加外键约束
alter table students
    add constraint students_class_fk
        foreign key (`class_id`) references class (`id`);