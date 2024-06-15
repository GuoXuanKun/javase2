# Note 240611

### 之前的第三方包管理方式及问题
- ![img_12.png](img_12.png)
- ![img_13.png](img_13.png)
- 问题 :
  需要自己主动去下载 jar 包，自己添加到项目
  从远程仓库重新 clone 之后，忘记点击 Add as Library
  比如邮件发送需要的 jar 包不止一个、多个版本的匹配问题
  远程仓库除了 Java 源代码，还需要存储 jar 包
  jar 包版本更新的时候，需要重复操作一遍完整过程
  等等...

### 学习一个东西 一定都要去看官网
- 如果官网 解释的不是很清楚 ,那就先用起来

### Build 的方式
- ![img_3.png](img_3.png)

### Maven
- 官方下载地址 https://maven.apache.org/download.cgi
- ![img.png](img.png)
- 下载验证 是否是原官网的文件
  - ![img_1.png](img_1.png)
  - ![img_14.png](img_14.png)
  - ![img_15.png](img_15.png)
- 设置成全局访问
  - 获取 Maven 文件夹下的 bin 的路径 然后去配置环境变量
  - 配置环境变量
  - ![img_2.png](img_2.png)
  - 验证 是否配置成功
    - 打开黑窗口 输入 mvn --version
    - ![img_16.png](img_16.png)
    - ![img_17.png](img_17.png)

### 通过命令行的方式创建 Maven 项目（可以完全脱离 IDEA 编辑器）
- ![img_18.png](img_18.png)
- mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
  - ![img_19.png](img_19.png)
- 镜像加速 setting.xml
  - ![img_20.png](img_20.png)
- 加速后
  - ![img_21.png](img_21.png)
- 打开 pom.xml 截图中的内容修改成匹配自己电脑的 JDK 版本
  - ![img_22.png](img_22.png)
- 执行以下命令
  - cd my-app
    mvn package
    java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
  - ![img_23.png](img_23.png)

### 镜像加速 setting.xml
- 注意 要把 setting.xml 加载进 .m2 文件夹
- 我的位置  C:\Users\Administrator\.m2

### 创建 Build system 为 Maven 的项目
- ![img_24.png](img_24.png)
- ![img_5.png](img_5.png)
- Maven 的理解
  - ![img_25.png](img_25.png)
  - ![img_26.png](img_26.png)

### 在远程创建一个新的仓库存储新创建的 Maven 项目
- ![img_27.png](img_27.png)

### 配置 Gitee 免密登录
- https://help.gitee.com/base/account/SSH%E5%85%AC%E9%92%A5%E8%AE%BE%E7%BD%AE
- 用 Git 创建 SSH 公钥
  - ![img_7.png](img_7.png)
  - ![img_28.png](img_28.png)
- HTTPS -> SSH
  将之前已经 clone 到本地的，关联了 https 协议的仓库改成关联免密登录的 git 协议地址
  - ![img_29.png](img_29.png)

### 更改远程仓库的提交路径
- ![img_10.png](img_10.png)

### 依赖仓库
- https://mvnrepository.com/

### 导依赖
- 导 Jsoup
  - ![img_8.png](img_8.png)
  - ![img_9.png](img_9.png)
  - ![img_30.png](img_30.png)
  - ![img_31.png](img_31.png)
- 导 发邮件 的依赖
  - 其实只要导一个
  - ![img_11.png](img_11.png)
  - ![img_32.png](img_32.png)

### GAV
- 注意要在 dependencies 里面导
- 唯一定位
- ![img_4.png](img_4.png)
- ![img_6.png](img_6.png)

### 专业三件套
- 远程代码仓库
- 个人简历
- 个人网站