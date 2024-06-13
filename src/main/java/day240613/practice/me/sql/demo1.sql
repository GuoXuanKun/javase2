-- 查询语法
/*
select
    字段列表
from
    表名列表
where
    条件列表
group by
    分组字段列表
having
    分组后条件列表
order by
    排序字段列表
limit
    分页参数
*/

show databases;

use mydb1;

-- 学生表
create table students(
                       id int primary key auto_increment comment '主键ID',
                       username    varchar(20)                  not null comment '用户名',
                       password    varchar(32) default '123456' null comment '密码',
                       gender      tinyint unsigned             not null comment '性别, 1=男, 2=女，0=未知',
                       avatar       varchar(300)                 null comment '头像 url',
                       job         tinyint unsigned             null comment '角色/职务。1=班长, 2=助教, 3=组长, 0=其他',
                       enrolled_at   date                         null comment '注册/入学日期',
                       created_at datetime                     not null comment '创建时间',
                       updated_at datetime                     not null comment '修改时间',
                       constraint students_username_uindex unique (username)
) comment '学生表';

-- 学生表演示数据
INSERT INTO students(id, username, password, gender, avatar, job, enrolled_at, created_at, updated_at)
VALUES (1, '王zf', '123xyz098', 1, '1.jpg', 3, '2024-01-01', now(), now()),
       (2, '傅yh', '123xyz098', 1, '2.jpg', 0, '2024-02-03', now(), now()),
       (3, '王jj', '123xyz098', 1, '3.jpg', 0, '2024-02-11', now(), now()),
       (4, '李wh', '123xyz098', 1, '4.jpg', 3, '2024-02-21', now(), now()),
       (5, '江ht', '123xyz098', 1, '5.jpg', 0, '2024-02-05', now(), now()),
       (6, '郭xk', '123xyz098', 1, '6.jpg', 3, '2024-03-05', now(), now()),
       (7, '肖kl', '123xyz098', 1, '7.jpg', 0, '2024-02-01', now(), now()),
       (8, '吴hn', '123xyz098', 1, '8.jpg', 0, '2024-01-09', now(), now()),
       (9, '陈jc', '123xyz098', 1, '9.jpg', 0, '2024-03-11', now(), now()),
       (10, '林lc', '123xyz098', 1, '10.jpg', 3, '2024-01-05', now(), now()),
       (11, '吴jl', '123xyz098', 1, '11.jpg', 0, '2024-02-01', now(), now()),
       (12, '陈rj', '123xyz098', 1, '12.jpg', 0, '2024-01-18', now(), now()),
       (13, '方z', '123xyz098', 1, '13.jpg', 0, '2024-03-01', now(), now()),
       (14, '王wy', '123xyz098', 1, '14.jpg', 0, '2024-01-11', now(), now()),
       (15, '赖xw', '123xyz098', 1, '15.jpg', 0, '2024-02-05', now(), now()),
       (16, '张jj', '123xyz098', 1, '16.jpg', 0, '2024-05-01', now(), now()),
       (17, '叶XX', '123xyz098', 2, '17.jpg', 2, '2024-06-01', now(), now()),
       (18, '赵Y', '123xyz098', 2, '18.jpg', 1, '2024-06-11', now(), now()),
       (19, '钱ZZ', '123xyz098', 2, '19.jpg', 2, '2024-06-12', now(), now()),
       (20, '孙BB', '123xyz098', 1, '20.jpg', null, '2024-06-13', now(), now())
;



-- ====================================> DQL <=======================================

-- select * from students;



--  =================== 基本查询 ======================
-- 1. 查询指定字段 username,enrolled_at 并返回
select username, enrolled_at from students;


-- 2. 查询返回所有字段
-- 2.1 all columns
select id, username, password, gender, avatar, job, enrolled_at, created_at, updated_at from students;


-- 2.2 *
select * from students;


-- 3. 查询所有学生的 username,enrolled_at, 并起别名(姓名、入学日期)
select username as '姓名', enrolled_at as '入学日期' from students;
-- as omit
select username '姓名', enrolled_at '入学日期' from students;


-- 4. 查询学生的职务字段 （角色/职务。1=班长, 2=助教, 3=组长, 0=其他）
select job from students;

/*
-- distinct
select distinct job from students;
 */

-- 5. 查询学生有哪几种职位(不要重复)
select distinct job from students;

--  =================== 条件查询 ======================
-- 1. 查询 姓名 为 孙BB 的学生
select * from students where username='孙BB';
-- 2. 查询在 id小于等于5 的学生信息
select * from students where id<=5;

-- 3. 查询 没有分配职位 的学生信息
/*
-- 判断 null , 用 is null
select * from students where job is null;
 */
select * from students where job is null;
-- 4. 查询 有职位 的学生信息
/*
-- 判断 不是null , 用 is not null
select * from students where job is not null ;
 */
select * from students where job is not null;

-- 5. 查询 密码不等于 '123xyz098' 的学生信息
select * from students where password != '123xyz098';
select * from students where password <> '123xyz098';
-- 6. 查询入学日期 在 '2024-01-01' (包含) 到 '2024-06-01'(包含) 之间的学生信息 -- between ... and ...
/*
select * from students where enrolled_at between '2024-01-01' and '2024-06-01' ;
 */
select * from students where enrolled_at >= '2024-01-01' and enrolled_at <='2024-06-01';

select * from students where enrolled_at between '2024-01-01' and '2024-06-01';
-- 7. 查询 入学时间 在 '2024-01-01' (包含) 到 '2024-06-01'(包含) 之间 且 性别为女 的学生信息
/*
select * from students where (enrolled_at between '2024-01-01' and '2024-06-01') and  gender = 2;
 */
select * from students where enrolled_at between '2024-01-01' and '2024-06-01' and gender=2;

-- 8. 查询 职位是 2 (助教), 3 (组长) 的学生信息 -- orin
select * from students where job=2 or job=3;
select * from students where job in (2, 3);
-- 9. 查询姓名为两个字的学生信息
select * from students where username like '__';
-- 10. 查询姓 '张' 的学生信息
select * from students where username like '张%';
-- 11. 查询姓名中包含 'B' 的学生信息
select * from students where username like '%B%';


-- 练习 : 学生管理列表查询
-- 条件 : username, gender, enrolled_at
/*
select * from students where username like '%张%' and gender = 1 and enrolled_at between '2024-01-01' and '2024-06-01';
 */





--  =================== 排序查询 ======================
-- 1. 根据入学时间, 对学生进行升序排序  -- 排序条件 asc/desc
select id, username, enrolled_at from students order by enrolled_at asc;
/*
select * from students order by enrolled_at asc ; -- 默认升序, asc可以省略的
 */
/*
select * from students order by enrolled_at ;
 */

-- 2. 根据入学时间, 对学生进行降序排序
/*
select * from students order by enrolled_at desc;
 */
select id,username,enrolled_at from students order by enrolled_at desc;

-- 3. 根据 入学时间 对公司的学生进行 升序排序 ， 入学时间相同 , 再按照 ID 进行降序排序
/*
select * from students order by enrolled_at asc , id desc ;
 */
select id,username,enrolled_at from students order by enrolled_at asc, id desc;

-- 练习 : 学生管理列表查询 , 根据最后操作时间, 进行倒序排序
-- 条件 : username , gender , enrolled_at

/*
select * from students where username like '%张%' and gender = 1 and enrolled_at between '2024-01-01' and '2024-06-01' order by updated_at desc;
 */




--  =================== 分页查询 ======================
-- 1. 查询第1页学生数据, 每页展示10条记录 -- index, size
select * from students limit 0, 10;
select * from students limit 10;
/*
select * from students limit 0,10;
 */
-- omit
/*
select * from students limit 10;
 */


-- 2. 查询第2页学生数据, 每页展示10条记录
select * from students limit 10, 10;
/*
select * from students limit 10,10;
 */
-- 公式
/*
公式 : 页码 ---> 起始索引  ------->  起始索引 = (页码 - 1) * 每页记录数
 */




-- 练习 : 学生管理列表查询 , 根据最后操作时间, 进行倒序排序，分页，每页 10 条
-- 条件 : username, gender, enrolled_at

/*
select * from students where username like '%张%' and gender = 1 and enrolled_at between '2024-01-01' and '2024-06-01' order by updated_at desc limit 0,10 ;
 */






--  =================== 分组查询 ======================
-- 聚合函数

-- 1. 统计该基地学生数量 -- count
-- A. count(字段) -- id
select count(id) as c from students;
/*
select count(id) from students;
 */
-- null column
/*
select count(job) from students; -- null值不参与聚合函数运算
 */
select count(job) from students;

-- B. count(*)
/*
select count(*) from students;
 */
select count(*) from students;

-- 2. 统计该基地学生 ID 的平均值
/*
select avg(id) from students;
 */
select avg(id) from students;

-- 3. 统计该基地最早入学的学生的入学日期
/*
select min(enrolled_at) from students;
 */
select min(enrolled_at) 最早入学日期 from students;

-- 4. 统计该基地最近入学的学生的入学日期
/*
select max(enrolled_at) from students;
 */
select max(enrolled_at) 最近入学日期 from students;

-- 5. 统计该基地学生的 ID 之和
/*
select sum(id) from students;
 */
select sum(id) from students;



-- 分组
-- 1. 根据性别分组 , 统计男性和女性学生的数量
/*
select gender, count(*) from students group by gender;
 */
select gender, count(*) from students group by gender;

-- 2. 先查询入学时间在 '2024-02-01' (包含) 以前的学生 , 并对结果根据职位分组 , 获取学生数量大于等于2的职位 -- count
select * from students where enrolled_at <= '2024-06-12';
select job, count(*) from students where enrolled_at <= '2024-06-12' group by job;
select job, count(*) from students where enrolled_at <= '2024-06-12' group by job having count(*) >= 2;
select job, count(*) as c from students where enrolled_at <= '2024-06-12' group by job having c >= 2;
-- step 1
/*
select *  from students where enrolled_at <= '2024-02-01';
 */
-- step 2
/*
select job, count(*)  from students where enrolled_at <= '2024-02-01' group by job;
 */
-- step 3
/*
select job ,count(*)  from students where enrolled_at <= '2024-02-01' group by job having count(*) >= 2;
 */
-- as c
/*
select job ,count(*) as c  from students where enrolled_at <= '2024-02-01' group by job having c >= 2;
 */


-- 男性与女性学生的人数统计 (1 : 男性学生 , 2 : 女性学生)
select gender, count(*) as 人数 from students group by gender;
/*
select gender, count(*) '人数' from students group by gender;
 */
-- 函数: if(条件表达式 , t , f)
/*
select
    if(gender = 1, '男性学生' , '女性学生') '性别',
    count(*) '人数'
from students group by gender;
*/
select if(gender = 1, '男性学生', '女性学生') as 性别, count(*) as 人数 from students group by gender;

-- 学生职位信息 -- count
-- 函数: case when ... then ... when ... then ... else ... end
-- 函数: case ... when ... then ... when ... then ... else ... end
select
    (case when job = 1 then '班长' when job = 2 then '助教' when job = 3 then '组长' when job = 0 then '其他' else '未知' end) '职位',
    count(*)
from students group by job;

select
    (case job when 1 then '班长' when 2 then '助教' when 3 then '组长' when 0 then '其他' else '未知' end) '职位',
    count(*)
from students group by job;































