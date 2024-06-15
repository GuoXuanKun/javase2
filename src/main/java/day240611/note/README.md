# Note 240611

## 学习一个东西 一定都要去看官网
- 如果官网 解释的不是很清楚 ,那就先用起来

### Build 的方式
- ![img_3.png](img_3.png)

### Maven
- 官方下载地址 https://maven.apache.org/download.cgi
- ![img.png](img.png)
- 下载验证 是否是原官网的文件
  - ![img_1.png](img_1.png)
- 设置成全局访问
  - 获取 Maven 文件夹下的 bin 的路径 然后去配置环境变量
  - 配置环境变量
  - ![img_2.png](img_2.png)
  - 验证 是否配置成功
    - 打开黑窗口 输入 mvn --version

### 注意 要把 setting.xml 加载进 .m2 文件夹
- 我的位置  C:\Users\Administrator\.m2

### 创建 Build system 为 Maven 的项目
- ![img_5.png](img_5.png)

### 用 Git 创建 SSH 公钥
- ![img_7.png](img_7.png)

### 更改远程仓库的提交路径
- ![img_10.png](img_10.png)

### 依赖仓库
- https://mvnrepository.com/

### 导依赖
- 导 Jsoup
  - ![img_8.png](img_8.png)
  - ![img_9.png](img_9.png)
- 导 发邮件 的依赖
  - 其实只要导一个
  - ![img_11.png](img_11.png)

### GAV
- 注意要在 dependencies 里面导
- 唯一定位
- ![img_4.png](img_4.png)
- ![img_6.png](img_6.png)

### 专业三件套
- 远程代码仓库
- 个人简历
- 个人网站