# Note 240614

## Review

### sql 的注释
- ![img.png](img.png)

### 外键
- ![img_1.png](img_1.png)
- 数据类型要一样
- ![img_2.png](img_2.png)
- 使用 truncate 删除 提醒的报错
  - ![img_4.png](img_4.png)
  - 
### 多表及其关系
- 一对一
 - 例：学生 与 学生证 ...
   - ![img_14.png](img_14.png)
 - Duplicate entry
   - ![img_15.png](img_15.png)
 - 关键字 unique
   - 唯一
     - ![img_3.png](img_3.png)
- 一对多
  - 例：博客 与 评论、班级 与 学生 ...
  - ![img_11.png](img_11.png)
  - 外键约束的两个字段类型不一致导致的问题及解决办法
    - ![img_12.png](img_12.png)
  - 添加外键约束之后的验证
    - ![img_13.png](img_13.png)
- 多对多
  - 例：博客 与 标签、学生 与 课程
  - ![img_16.png](img_16.png)
  - 一个学生可以选多门课，一门课可以被多个学生选
    - ![img_17.png](img_17.png)

### truncate
- 清除所有
  - ![img_5.png](img_5.png)

### constraint  
- 用于定义或强制实施某些规则，以保证数据的准确性和完整性。这些规则被称为约束（Constraints）。约束可以在创建表（CREATE TABLE）或修改表（ALTER TABLE）时定义。
- PRIMARY KEY
  - 主键约束，用于唯一标识表中的每一行。每个表只能有一个主键约束，主键列的值必须是唯一的，不能为 NULL。
- UNIQUE
  - 唯一约束，用于保证列中的所有值都是唯一的。
- FOREIGN KEY
  - 外键约束，用于防止在两个表之间创建无效的数据。这可以确保引用的数据存在于另一个表中。
- CHECK
  - 检查约束，用于限制列中的值的范围。这可以确保列中的数据满足特定的条件。
- NOT NULL
  - 非空约束，用于确保列不能有 NULL 值。

### in
- 在查询的结果的基础上再查
- ![img_6.png](img_6.png)

### JDBC
- Introduces an API for connectivity between the Java applications and a wide range of databases and data sources.
- 目的: 链接各种数据库
- 定义规范与协议
  - 高以下为基
    - 强者只制定规则
- ![img_18.png](img_18.png)
- 细则
  - 查询
    - Connection
    - Statement
    - ResultSet
    - ![img_9.png](img_9.png)
    - 占位符
  - 插入
  - 更新
  - 删除
      - 回滚
      - ![img_10.png](img_10.png)
- 背后隐藏的思想
  乱象 => 统一
  定义规范、标准
  稳定、可扩展
  3.产品、2.服务、1.标准
- 殊途同归：Java 连接数据库与其他方式的本质一致
  - ![img_19.png](img_19.png)

### 注解 @BeforeAll
- 在 Java 中，@BeforeAll 是 JUnit 5 中的一个注解，它用来标记一个方法应该在当前测试类中的所有测试之前执行。与 @BeforeEach 不同的是，@BeforeAll 注解的方法只会被执行一次。
- 这对于一些需要在所有测试开始之前进行的初始化操作非常有用，例如设置静态资源、打开数据库连接等。

### Statement
- 语句
- ![img_8.png](img_8.png)

### Transaction
- ![img_20.png](img_20.png)