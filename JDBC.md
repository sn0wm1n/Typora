# JDBC

##   WEB技术体系概览

![image-20210509154251990](JDBC.assets/image-20210509154251990.png)

## 第一章-JDBC概述

### java中数据库存取存储技术  

JDBC直接访问数据库  

JDO技术 Java Data Object  

第三方工具O/R工具  如Hibernate，Mybatis等 

JDBC是java访问数据库的基石，JDO，Hibernate，Mybatis只是更好的封装了JDBC  

###  JDBC 介绍

Java DataBase Connectivity  

JDBC为访问不同的数据库提供了统一的途径，为开发者屏蔽了一些细节问题     

**JDBC是sun公司提供的一套用于数据库操作的接口，java程序员只需要面向这个接口编程即可**

不同的数据库厂商，需要针对这套接口，提供不同的实现，不同的实现的集合即为不同的数据库的驱动  

​																————面向接口编程  

![image-20210509163109331](JDBC.assets/image-20210509163109331.png)

## 第二章-获取链接

### interface Driver 概述  

### 快速入门步骤  

主要就是

1.导入驱动jar包  

​		①复制驱动jar包 mysql的 到项目的libs目录下 （没有libs自己建和项目同级别）

​		②右键libs目录--->Add AS Library

2.注册驱动

```java
Class.forName("com.mysql.jdbc.Driver");//mysql5之后可以不写
```

3.获取数据库对象 Connection

```java
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls","root","1234");
```

4.定义SQL

```java
String sql =
        "insert into " +
                "beauty(name,borndate,phone,boyfriend_id)" +
                "values ('周亚拿','1990-3-12','13359902114',2);";
```

5.获取执行sql语句的对象

```java
Statement statement = connection.createStatement();
```

6.执行sql，接收返回结果  

```java
boolean count = statement.execute(sql);
```

7.处理结果 

```java
System.out.println(count);
```

8.释放资源 

```java
statement.close();
connection.close();
```

### 详解步骤中的对象

#### DriverManager 

驱动管理对象 是一个类不是接口  

功能

#####  1-注册驱动 

告诉程序应该使用哪个数据库驱动jar包 

static void registerDriver(Driver driver)  

`Class.forName("com.mysql.jdbc.Driver");`

随着Driver类加载器运行的静态代码块  

```java
static {
    try {
        DriverManager.registerDriver(new Driver());//注册驱动的方法
    } catch (SQLException var1) {
        throw new RuntimeException("Can't register driver!");
    }
}
```

#####  2-获取数据库连接 

```java
//方法
public static Connection getConnection(String url,
    String user, String password)
```

**url：指定连接的路径**  

语法： 

```
JDBC:mysql://ip地址(域名):端口号/数据库名称
例子:jdbc:mysql://localhost:3306/girls","root","1234"
```

细节：如果连接的是本机的服务器，并且mysql服务默认是3306，则url可以简写为：

jdbc:mysql:///数据库名

### Connection对象（接口）

功能

#### 获取执行sql的对象

```java
Statement statement = connection.createStatement();
PreparedStatement preparedStatement = connection.prepareStatement();
```

#### 管理事务

```java
//开启事务
connection.setAutoCommit(false);
//提交事务
connection.commit();
//回滚事务
connection.rollback();
```

### Statement接口

```java
//1.执行任何语句  返回true代表第一个结果是ResultSet对象，返回false代表结果是更新记数或者没有结果  
boolean bool = statement.execute(String sql);
//2.执行DML insert update delete语句,DDL(create,alter,drop)语句,返回值是影响的行数
//也就是   返回值>0   则执行成功
int executeUpdate(String sql);
//3.执行DQL(Select)语句  返回结果集对象
ResultSet executeQuery(String sql):
```

### ResultSet对象

```java
boolean next();//游标向下移动一行
//并且判断这一行有没有数据，有数据返回true
getXxx(参数);//获取数据
	//Xxx代表数据类型  如： int getInt(); String getString(); Double getDouble();
参数具有两种类型 
    当参数为int 代表列的编号， 从1 开始 如： getString(1);
	当参数为String  代表列名 ，  如:  getDouble("balance");
```



