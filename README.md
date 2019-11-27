# 1. Spring Boot Sample Project

<!-- TOC -->

- [Spring Boot Sample Project](#spring-boot-sample-project)
    - [多模块spring boot2.0项目搭建](#多模块spring-boot20项目搭建)
        - [创建SpringBoot 2.0项目](#创建springboot-20项目)
        - [创建多模块](#创建多模块)
        - [项目启动](#项目启动)
    - [第一个restful接口](#第一个restful接口)
        - [定义一个restful接口](#定义一个restful接口)
        - [RequestMapping基础用法](#requestmapping基础用法)
        - [RequestMapping处理多个url](#requestmapping处理多个url)
        - [RequestMapping中带参数](#requestmapping中带参数)
        - [RequestMapping中的关键字required, defaultValue](#requestmapping中的关键字required-defaultvalue)
        - [RequestMapping处理各种HTTP方法](#requestmapping处理各种http方法)
        - [RequestMapping通过url获取参数](#requestmapping通过url获取参数)
        - [RequestMapping通过RequestBody来传递参数](#requestmapping通过requestbody来传递参数)
        - [RequestMapping通过RequestBody来传递参数2](#requestmapping通过requestbody来传递参数2)
        - [总结](#总结)
    - [如何在Dao层与数据库打交道](#如何在dao层与数据库打交道)
        - [使用SpringBoot自带的功能快捷的查询数据库数据(未完成，先不看)](#使用springboot自带的功能快捷的查询数据库数据未完成先不看)
        - [使用mybatis插件帮我们自动生成数据库操作语句](#使用mybatis插件帮我们自动生成数据库操作语句)
            - [mybatis自动生成代码插件如何配置使用](#mybatis自动生成代码插件如何配置使用)
            - [如果将这些文件加载到springboot项目中进行使用](#如果将这些文件加载到springboot项目中进行使用)
    - [模板页面使用-第一个模板页面](#模板页面使用-第一个模板页面)
        - [在pom.xml中引入thymeleaf等依赖](#在pomxml中引入thymeleaf等依赖)
        - [关闭thymeleaf缓存](#关闭thymeleaf缓存)
        - [创建第一个模板文件](#创建第一个模板文件)
        - [访问我们的第一个模板页面](#访问我们的第一个模板页面)
    - [模板页面使用-数据库列表展示](#模板页面使用-数据库列表展示)
        - [创建列表展示页面](#创建列表展示页面)
        - [从数据库获取需要的数据](#从数据库获取需要的数据)
        - [浏览列表展示页面](#浏览列表展示页面)
    - [模板页面使用-ajax调用](#模板页面使用-ajax调用)
    - [手动修改maven项目版本号](#手动修改maven项目版本号)
    - [附录](#附录)

<!-- /TOC -->

```text
这是一个spring boot的示例项目，用以展示spring boot之美
```

## 1.1. 多模块spring boot2.0项目搭建

```text
创建一个基于spring boot 2.0的多模块maven项目
```

### 1.1.1. 创建SpringBoot 2.0项目

1. 打开File -> New -> Project...
![创建项目1](./pics/项目搭建/创建项目1.png)
2. 输入包名，项目名 group即为包名 artifact为项目名
![创建项目2](./pics/项目搭建/创建项目2.png)
3. spring boot项目由各种依赖组成，可选一些自己想添加的，也可以不添加，后面我们还可以再添加
![创建项目3](./pics/项目搭建/创建项目3.png)
4. 设置好项目名之后，我们的项目就搭建完成了
![创建项目4](./pics/项目搭建/创建项目4.png)
5. 一开始，项目是长这样的，我们删除红框中的所有文件，只留下.gitignore pom.xml .idea test-one.iml这几个文件
![创建项目5](./pics/项目搭建/创建项目5.png)
6. 最终我们的项目变成了这个样子
记得在pom.xml中如图所示，添加一个打包方式

```text
<packaging>pom</packaging>
```

![创建项目6](./pics/项目搭建/创建项目6.png)

### 1.1.2. 创建多模块

```text
接下来，我们开始创建其它模块，关于java模块怎么划分，
具体可以查看附录中的[java项目分层]这篇文章
```

1. 打开模块创建窗口
![创建项目7](./pics/项目搭建/创建项目7.png)
2. 我们选择建用maven方式创建模块
![创建项目8](./pics/项目搭建/创建项目8.png)
3. 输入模块名
![创建项目9](./pics/项目搭建/创建项目9.png)
4. 确认模块所在目录
![创建项目10](./pics/项目搭建/创建项目10.png)
5. 完成项目创建，模块最终是这样的
![创建项目11](./pics/项目搭建/创建项目11.png)
6. 项目最终成型，按相同方法，创建controller, service, dao, common 等模块
![创建项目12](./pics/项目搭建/创建项目12.png)

### 1.1.3. 项目启动

```text
项目基础架构已经搭建完成了，之后就是将项目跑起来
```

1. 修改项目根pom.xml文件(就是最外面的那个pom文件)，我们另外建了一个controller模块
![创建项目13](./pics/项目搭建/创建项目13.png)

2. 在controller模块的pom文件中添加如下内容，其它文件请参阅项目源码
![创建项目15](./pics/项目搭建/创建项目15.png)

3. 修改main模块的pom.xml文件，添加如下内容
![创建项目13-1](./pics/项目搭建/创建项目13-1.png)

4. 在main模块中添加以下3个文件(具体文件内容请自行查看项目源码)
![创建项目14](./pics/项目搭建/创建项目14.png)

5. 启动项目
![创建项目16](./pics/项目搭建/创建项目16.png)

## 1.2. 第一个restful接口

```text
SpringBoot项目创建完成之后，可以简单的通过几个注解就完成一个restful接口的定义，我们一起来看一下
```

### 1.2.1. 定义一个restful接口

1. 如图，创建一个controller类，并实现一些基础的方法

```text
需要说明的是
application.properties里配置项
#系统名称
server.servlet.context-path = /ts
#sso系统服务地址
server.port = 8889

平常访问链接，需要
http://ip:{server.port}/{server.servlet.context-path}/
某个controller的外层path/方法path

例：
http://localhost:8889/ts/test/getSomething
```

![restful1](pics/第一个restful接口/restful1.png)
2. 我们来尝试一下接口调用
![restful2](pics/第一个restful接口/restful2.png)

### 1.2.2. RequestMapping基础用法

```text
感觉一下图例中的2个链接的结果我们不难发现，
http://localhost:8889/ts/test是404没有定义
http://localhost:8889/ts/test/ 可正常返回结果
```

![restful3](pics/第一个restful接口/restful3.png)

### 1.2.3. RequestMapping处理多个url

```code
    /**
     * http://ip:port/ts/test/
     * http://ip:port/ts/test/get
     * http://ip:port/ts/test/get1
     * http://ip:port/ts/test/get2
     * 
     * @return
     */
    @RequestMapping(path = { "get", "get1", "get2" })
    public String get0() {
        return "OK";
    }
```

### 1.2.4. RequestMapping中带参数

![restful4](pics/第一个restful接口/restful4.png)

### 1.2.5. RequestMapping中的关键字required, defaultValue

![restful5](pics/第一个restful接口/restful5.png)

### 1.2.6. RequestMapping处理各种HTTP方法

```text
常用的HTTP METHOD

后面的method可省略，用GetMapping等代替
```

![restful6](pics/第一个restful接口/restful6.png)

![restful7](pics/第一个restful接口/restful7.png)

### 1.2.7. RequestMapping通过url获取参数

```text
restful接口的精髓在于通过url来获取参数，如

http://ip:port/ts/test/get/userinfo/1

http://ip:port/ts/test/get/userinfo/{userId}

```

![restful8](pics/第一个restful接口/restful8.png)

### 1.2.8. RequestMapping通过RequestBody来传递参数

```text
restful接口可通过http的body来传递参数，如
http://localhost:8889/ts/test/getMomoGifts
```

![restful9](pics/第一个restful接口/restful9.png)

![restful10](pics/第一个restful接口/restful10.png)

### 1.2.9. RequestMapping通过RequestBody来传递参数2

```text
restful接口可通过http的body来传递参数，如
http://localhost:8889/ts/test/getMomoGifts2

这里与上面不一样的地方在于，上面直接将传入的json数据转成了map，我们这个方法将json数据转成一个对象
```

![restful11](pics/第一个restful接口/restful11.png)

![restful12](pics/第一个restful接口/restful12.png)

需要说明的是，json中的key值要与对象中的参数的名字一样才能被识别

```json
{
    "userName":"yandongjun",
    "age":18
}
```

![restful13](pics/第一个restful接口/restful13.png)

### 1.2.10. 总结

```text
本章我们讲了如下内容
1. http有哪些方法
2. 同样的定义可以有不一样的写法，如method = post可替换成直接用PostMapping
3. 可以用url来对参数进行传递
4. RequestBody传递参数时，Key传要与对象中的属性名称一致才可以被识别
```

## 1.3. 如何在Dao层与数据库打交道

```text
本章节，我们地讲解
1. 如何使用SpringBoot自带的功能快捷的查询数据库数据
2. 如何使用mybatis框架帮我们自动生成数据库操作语句并完成查询
3. 如何使用mybatis编写自定义的sql语句
```

### 1.3.1. 使用SpringBoot自带的功能快捷的查询数据库数据(未完成，先不看)

1.首先，我们要在parent模块的pom.xml文件中引入数据库相关的jar包

```text
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.17</version>
</dependency>
```

2.在main模块的application.properties文件中，我们需要配置数据库相关的配置

```text
```

### 1.3.2. 使用mybatis插件帮我们自动生成数据库操作语句

在开始这一章节之前，我们假设已经完成了数据库的创建，表的创建

#### 1.3.2.1. mybatis自动生成代码插件如何配置使用

1.首先，我们在dao层添加一些依赖,先在parent下的pom中进行定义，之后在dao模块进行引用(这里不作赘述，注意版本号)

```text
       <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>provided</scope>
        </dependency>
```

2.其次，我们得把Mybatis自动生成文件的插件引用进来

```text
    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>${mybatis-generator-maven-plugin.version}</version>
                <dependencies>
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>${mysql-driver.version}</version>
                    </dependency>
                </dependencies>

                <configuration>
                    <!-- 大家注意，这里的目录其实就是dao模块下的resources目录 -->
                    <configurationFile>src/main/resources/autogen/generatorConfig.xml</configurationFile>
                    <overwrite>true</overwrite>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

3.接下来，我们添加插件需要使用到的文件 generatorConfig.xml,观察一下上面插件的引用，里面的configuration
配置了这个文件的路径

```text
        <!-- 配置domain类的包名 -->
        <javaModelGenerator targetPackage="com.china.test.sample.tsdao.tsdb.domain"
                            targetProject="src/main/java/"><!-- src/generated/java -->
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- 配置mapper.xml文件的路径 -->
        <sqlMapGenerator targetPackage="tsdb"
                         targetProject="src/main/resources/sqlmap/"> <!-- src/generated/resources -->
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 配置mapper类的包名 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.china.test.sample.tsdao.tsdb.mapper"
                             targetProject="src/main/java/"> <!-- src/generated/java -->
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- 配置要自动生成的表, 后面的domainObjectName就是生成的java类的名称 -->
        <table schema="test" tableName="ts_test" domainObjectName="TsTest">
            <property name="useActualColumnNames" value="true"/>
        </table>
```

4.开始生成文件

```text
4.1 数据库建表，可以使用init.sql文件中的建表语句，也可以使用自己自定义的建表语句
4.2 使用如下方式生成文件(需要在dao模块的根目录下，就是有pom.xml文件的目录下)
mvn mybatis-generator:generate
```

![mybatis](pics/daomybatis插件使用/1.png)

```text
也可以使用idea自带的插件执行, 如下图所示
```

![mybatis](pics/daomybatis插件使用/2.png)

#### 1.3.2.2. 如果将这些文件加载到springboot项目中进行使用

1.先确定自动生成的文件在哪

```text
我们在生成文件之后，大家可以在这3个目录下看到相应的文件
domain类目录
src/main/java/
com.china.test.sample.tsdao.tsdb.domain

mapper类目录
src/main/java/
com.china.test.sample.tsdao.tsdb.mapper

mapper.xml文件目录
src/main/resources/sqlmap/tsdb

如下图
```

![mybatis](pics/daomybatis插件使用/4.png)
![mybatis](pics/daomybatis插件使用/3.png)

2.如何让springboot项目知道这3种文件在哪

```text
我们直接在这里讲述多数据源的添加
具体的配置大家可以查看以下2个类
TsDbConfiguration
Ts2DbConfiguration
```

2.1 在application.properties配置文件中配置数据库信息，如下

```text
不难发现，每个数据库配置都有统一的前缀
spring.datasource.tsdb
spring.datasource.ts2db

他们都有固定的4类属性(还有许多其它数据库属性，自行搜索添加)
jdbc-url
username
password
driver-class
```

```text
 数据库url
spring.datasource.tsdb.jdbc-url=jdbc:mysql://192.168.5.241:3306/test?useSSL=false
# 数据库用户名
spring.datasource.tsdb.username=root
# 数据库密码
spring.datasource.tsdb.password=dashu0701
# 数据库驱动
spring.datasource.tsdb.driver-class-name=com.mysql.jdbc.Driver

# 数据库url
spring.datasource.ts2db.jdbc-url=jdbc:mysql://192.168.5.241:3306/test2?useSSL=false
# 数据库用户名
spring.datasource.ts2db.username=root
# 数据库密码
spring.datasource.ts2db.password=dashu0701
# 数据库驱动
spring.datasource.ts2db.driver-class-name=com.mysql.jdbc.Driver
```

2.2 我们回到TsDbConfiguration类

2.2.1 我们在配置数据源的时候，将配置的前缀加上，数据源就配好了

![mybatis](pics/数据库配置/1.png)

2.2.2 之后我们要关注的是我们的mapper类的配置

![mybatis](pics/数据库配置/2.png)

2.2.3 然后看一下我们的mapper.xml的配置

![mybatis](pics/数据库配置/3.png)

2.2.4 到这我们写一个测试类来测试一下(测试类有2种写法，我们这拿junit方式来作讲解)

```text
查看以下类的实现
TestTsTestWithJunit
```

![mybatis](pics/数据库配置/4.png)

## 1.4. 模板页面使用-第一个模板页面

```text
我们分三步
1 在pom.xml中引入thymeleaf
2 关闭thymeleaf缓存
3 创建第一个模板文件
```

### 1.4.1. 在pom.xml中引入thymeleaf等依赖

```text
在web模块下的pom.xml文件中我们添加如下依赖
 <!-- 在web模块的pom.xml文件中，我们添加依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

在main目录下的pom.xml文件中我们添加如下依赖
<dependency>
    <groupId>com.china.test.sample</groupId>
    <artifactId>ts-web</artifactId>
</dependency>
```

### 1.4.2. 关闭thymeleaf缓存

```text
在application.properties配置文件中我们加入以下配置

# 我们在开发阶段，把缓存去掉，要不我们的页面修改无法实时在我们的浏览器中生效
########################################################
###THYMELEAF (ThymeleafAutoConfiguration)
########################################################
#spring.thymeleaf.prefix=classpath:/templates/
#spring.thymeleaf.suffix=.html
#spring.thymeleaf.mode=HTML5
#spring.thymeleaf.encoding=UTF-8
# ;charset=<encoding> is added
#spring.thymeleaf.content-type=text/html
# set to false for hot refresh
spring.thymeleaf.cache=false
```

### 1.4.3. 创建第一个模板文件

```text
1. 我们的所有模板页面，默认目录在resources/templates/下
我们在web模块的resources目录下创建templates目录

2. 我们创建HelloWorld.html文件，内容如下
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
>
<head>
    <title>Hello World!</title>
</head>
<body>
<h1 th:inline="text">Hello.v.2</h1>
<p th:text="${HelloWorld}"></p>
</body>
</html>

3. 我们在web模块下创建controller类
@Controller
@RequestMapping("/web")
public class HelloWorldController {
    /**
     * 返回html模板.
     */
    @RequestMapping("/HelloWorld")
    public String HelloWorld(Map<String, Object> map) {
        // 这里的HelloWorld是与模板文件中的 ${HelloWorld} 对应的，最后会被这段话替换掉
        map.put("HelloWorld", "这里的HelloWorld是与模板文件中的 ${HelloWorld} 对应的，最后会被这段话的替换掉");
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "/HelloWorld";
    }

}
```

### 1.4.4. 访问我们的第一个模板页面

```text
打开浏览器访问我们的第一个模板页面
http://localhost:8889/ts/web/HelloWorld
```

## 1.5. 模板页面使用-查询

```text
1. 在resources/templates目录中添加ShowTestInfo.html页面
2. 在TsTestController中添加ShowTestInfo方法
```

### 1.5.1. 创建查询展示页面

```text
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>用于展示信息的页面</title>
</head>
<body>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>年龄</td>
    </tr>
    <!--/*@thymesVar id="tsTestVOs" type="java.util.List"*/-->
    <tr th:each="tsTestVO : ${tsTestVOs}">
        <td th:text="${tsTestVO.name}"></td>
        <td th:text="${tsTestVO.extraInfo}"></td>
    </tr>
</table>
</body>
</html>
```

### 1.5.2. 查询数据

```text
1 通过map形式传递页面数据
    /**
     * http://localhost:8889/ts/tsTest/ShowTestInfo
     */
    @RequestMapping("/ShowTestInfo")
    public String ShowTestInfo(Map<String, Object> map) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo();
        map.put("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

2 通过model形式传递页面数据
    /**
     * 使用model，最后SpringBoot会将model转成map(具体可以看接口Model的asMap方法)，和上面的方法一样
     * <p>
     * http://localhost:8889/ts/tsTest/ShowTestInfo2
     */
    @RequestMapping("/ShowTestInfo2")
    public String ShowTestInfo2(Model model) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo();
        model.addAttribute("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }

3 从数据库中获取数据进行传递
    /**
     * 我们从数据库中获取数据并展示
     * <p>
     * 1. 使用service层的方法获取数据
     * <p>
     * 2. service层将获取的结果数据转换成前端展示类TsTestVO(view)
     * <p>
     * 3. service层方法调用dao层方法获取数据
     * <p>
     * 4. dao层其实就是我们的mapper类
     * <p>
     * http://localhost:8889/ts/tsTest/ShowTestInfo3
     */
    @RequestMapping("/ShowTestInfo3")
    public String ShowTestInfo3(Model model) {
        List<TsTestVO> tsTestVOs = tsTestService.getTsTestVOListForShowTestInfo3();
        model.addAttribute("tsTestVOs", tsTestVOs);
        // 这里返回的值是templates目录下的文件名，不要带后文件后缀名
        return "ShowTestInfo";
    }
```

### 1.5.3. 浏览列表展示页面
```text
1. http://localhost:8889/ts/tsTest/ShowTestInfo
2. http://localhost:8889/ts/tsTest/ShowTestInfo2
```
![mybatis](pics/模板页面/1.png)

```text
3. http://localhost:8889/ts/tsTest/ShowTestInfo3
```
![mybatis](pics/模板页面/2.png)


## 1.6. 模板页面使用-增、删、改

```text
1. 创建具有增删改的页面
2. 实现一个删除操作
3. 实现一个添加操作
4. 实现一个修改操作
```

### 1.6.1 创建一个具有增删改的页面

### 1.6.2 实现一个删除操作

### 1.6.3 实现一个添加操作

### 1.6.4 实现一个修改操作

## 1.7. 手动修改maven项目版本号

```text
1、修改版本
　　mvn versions:set -DnewVersion=xxxx
2、回滚版本，提交后不能回滚
　　mvn versions:revert
3、提交版本变更
　　mvn versions:commit
```

## 1.8. 附录

[spring-boot 多模块项目搭建](https://symonlin.github.io/2019/01/15/springboot-1/)

[java项目分层](https://www.jianshu.com/p/9ef2005a0001)
