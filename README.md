# Spring Boot Sample Project

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
    - [手动修改maven项目版本号](#手动修改maven项目版本号)
    - [附录](#附录)

<!-- /TOC -->

```text
这是一个spring boot的示例项目，用以展示spring boot之美
```

## 多模块spring boot2.0项目搭建

```text
创建一个基于spring boot 2.0的多模块maven项目
```

### 创建SpringBoot 2.0项目

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

### 创建多模块

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

### 项目启动

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

## 第一个restful接口

```text
SpringBoot项目创建完成之后，可以简单的通过几个注解就完成一个restful接口的定义，我们一起来看一下
```

### 定义一个restful接口

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

### RequestMapping基础用法

```text
感觉一下图例中的2个链接的结果我们不难发现，
http://localhost:8889/ts/test是404没有定义
http://localhost:8889/ts/test/ 可正常返回结果
```

![restful3](pics/第一个restful接口/restful3.png)

### RequestMapping处理多个url

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

### RequestMapping中带参数

![restful4](pics/第一个restful接口/restful4.png)

### RequestMapping中的关键字required, defaultValue

![restful5](pics/第一个restful接口/restful5.png)

### RequestMapping处理各种HTTP方法

```text
常用的HTTP METHOD

后面的method可省略，用GetMapping等代替
```

![restful6](pics/第一个restful接口/restful6.png)

![restful6](pics/第一个restful接口/restful6.png)

## 手动修改maven项目版本号

```text
1、修改版本
　　mvn versions:set -DnewVersion=xxxx
2、回滚版本，提交后不能回滚
　　mvn versions:revert
3、提交版本变更
　　mvn versions:commit
```

## 附录

[spring-boot 多模块项目搭建](https://symonlin.github.io/2019/01/15/springboot-1/)

[java项目分层](https://www.jianshu.com/p/9ef2005a0001)
