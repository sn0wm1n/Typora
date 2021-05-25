# web 错误记载

1.就因为和老师的例子之间，我多套了一层sb的表单标签，就这还记不住表单标签的名字，这单词我估计这辈子都记不住了，

看一眼，，，，，form  form 表单的信息来自于    from    form

2.js循环写的时候写的for（var i ; i < arr.length ; i++） ，，，，自动生成大法好，，，

3.没有新建servlet的原因是，导包要把  Tomcat里面的lib下面servlet-api.jar包也导进来，并且在facet里面设置SourceRoot

# servlet与http的简单介绍  

域名->DNS->ip->服务器  
请求 客户端->服务端  
响应 服务端->客户端  

请求 request 包含uri  /A /B  
响应 response  
由于多个客户端不同的浏览器解析方式等，有了一些个规范。  
HTTP Hyper Test Transfer Protocol  超文本传输协议    
当WebServer 拥有了动态生成页面的applet程序的能力时，，可以把webserver称为容器，可以按照需求返回动态的页面，就是serverlet也就是server applet  
JSP Java server page   
高级框架ssm  

# HTTP协议  
特点：  
-1 简单快速  键值对  K=V  
-2 灵活  json text 都可以，通过属性定义 content-type；  
-3 无连接  连接传输关闭耗时   **HTTP1.1版本之后支持可持续连接**  
-4 无状态  不会保留上次请求的数据  
-5 支持B/S（browser/server）  和  C/S (client/server)   架构  

## 交互原理  
-1 建立连接  三次握手   
-2 发送请求，返回响应   
**-3 关闭连接 四次挥手   前两次确认，服务端收到断开消息同时回应可以断开，且再发一个我也要跟你断开连接  客户端说好  
一对渣男渣女，男的说分手，女的说好，男的转身就走了，女的气不过，说分手应该我来说，我要跟你分手，男的说好。女的也走了**  

## HTTP请求格式 **** 
**请求方法(get)**  [空格] **URL** [空格] **协议版本** 换行符 		 ————>请求行  
头部键：值 回车符  换行符  *n行         							————>请求头  
空行  
请求数据                           													  ————>请求体  

请求体举例   action=login&username=root

#### 格式注解：
请求方法---常见的有GET/POST  
URL--- 统一资源定位符  
协议版本---http1.0 1.1  

请求数据----键值对举例：

host:请求的服务器ip域名  

User-Agent：就是浏览器的信息

accept：接收资源格式 

 accept-encoding 客户端接收的解码格式  

accept-language  

Connection：告诉服务器连接如何处理

​				Keep-Alive  告诉服务器回传数据不要马上关闭

​				Closed 	马上关闭

Content-Type: 表示发送的数据的类型

​			application/x-www-form-urlencoded

​										表示提交的数据格式是：name=value&name=value,然后对其进行url编码

​									url编码是把非英文内容转换为：%xx%xx

​			mutipart/form-data

​										表示多短的姓氏提交数据给服务器（流的形式）		

Connection-length：发送数据（请求体）的长度

Cache-Control 表示应该如何控制缓存，post就是不请求

### GET和POST请求方法的区别  

1.GET请求的参数是直接显示在地址栏的  
POST参数在地址栏不显示  
2.GET安全，POST相对安全   
3.GET请求有长度限制  POST请求没有限制  

## GET请求和POST请求有哪些

### GET请求

1. form标签 method = get 

2. a标签

3. link标签引入css

4. Script标签引入JS文件

5. img标签引入html页面

6. iframe引入html页面

7. 在浏览器地址栏中输入地址后敲回车

### POST请求

1. form method=post



## HTTP响应格式  
**协议版本 空格 状态码 空格 状态码描述（OK） 换行符       ————>状态行   
头部键 ：值 回车符换行符    *n行                  ————>响应头    
空行  
响应数据                                        ————>响应体**  

####  **内容注解：**

#### 格式注解：

**协议版本----http1.1  
状态码----表示请求成功**
**状态码描述-----请求是否成功  
响应头-----举例、 Date日期   Content-length：内容长度。**

#### 响应状态码分类描述 ： 
1XX  信息，服务器收到请求，需要请求者继续进行操作  
2XX  成功，操作成功将接受并被处理  
3XX  重定向   需要进一步操作完成请求    
4XX  例如404  客户端错误，请求包含语法错误或无法完成请求  
5XX  服务器操作，服务器在处理请求时发生了错误  

200  OK   ——客户端请求成功
400  BadRequest ——客户端请求语法有误，不被服务器理解  
401  Unauthorized ——请求未经授权  
403  Forbidden ——服务器收到请求但拒绝提供服务  
404  NotFound ———请求的资源不存在  
500  InternalServeError ——服务器发生不可预知的错误  
503  Server Unavaliable ——服务器当前不能处理客户的请求，过段时间可能可以  

## MIME类型说明

概念：MIME是HTTP协议中数据类型

MIME的英文全称是"Multipurpose Internet Mail Extensions"多功能Internet邮件扩充服务。

MIME类型的格式是"大类型/小类型"，并与某一种文件的扩展名相对应



# 01ServeLet之Tomcat 

定义：服务端上一直运行的常服务  
**tomcat组成：**
**————首先是和客户端连接的用于request 和response的两个对象，这两个对象统称server，通过这两个对象访问多个applet（也就是ServeLet），在applet中实现接口类来做具体的事，接口类是一套规范里面有很多需要处理数据用的方法，server会根据信息要求applet实现各个请求，所以他们合起来叫servelet**  

# **tomcat** 
**跟着视频自己写了Tomcat  
基于TCP协议。Socket套接字  
首先主要就是ServerSocket创建好后获取相应的Socket对象，以及Soket对象的输入输出流  
这个输入输出流我们把他具体化为两个请求**Request**和响应**Response**的类，**  
## 先讲响应 **response** 
**response这个类的对象由Socket的输出流为构造参数创建，类中有类成员变量OutputStream， 
也就是说OutputStream就是Socket的输出流，他的写操作会直接进行传输，   
于是response这个类有write()方法（字节流字符流的IO都是read()和write()方法）,  
write()方法中根据传入的String参数改变了响应体中的标签内容以外，就是标准的HTTP响应格式书写的** 

## 再讲请求**request 请求是指处理别人的请求**  
**request类对象也是由Socket的输入流为构造参数创建，  
类中有类成员变量InputStream，这个对象除了了构造函数和读写函数没有方法  
主要功能在构造方法中，整个类就是为了接收到InputStream中需要的信息并且分析然后给出服务器特定的参数———  
事例是通过自身的类成员提供了两个信息**
```
 //请求方法  GET/POST  
    private String requestMethod;  
//请求地址资源定位  URL  
    private String requestUrl;   
```
 **这两个信息中  
 1-请求方法用于传递给所有ServerLet的抽象父亲HttpServerLet，作用下文会讲到  
 2-URL用于给MAP来根据URL（获取到的是整个tomcat工程的路径）获取到相应的ServeLet类，**
##### 这里有疑点就是Socket如何获取到这个路径的？
## 接下来是map类  
**前面讲到request带给我们两个信息的第二个是URL，
map类中只有一个成员变量里就是一个HashMap，并且具体的键值对信息由static申明好  
这样就可以在服务器获得请求时给出相应的ServLet(会调用response())来响应  
当然map中还有get方法，方便被调用获取键值** 

## ServeLet 
  **ServeLet可以有很多个，就是根据请求中的URL被map挑选到的用来根据需要返回特定信息的方法类；  
  所有ServeLet都继承了一个接口HttpServeLet，（下文会讲到，实际用了抽象类）  
  并且ServeLet要重写两个继承方法用于实现 在获得GET 和POST两种请求时的响应  
  案例中就单纯的调用了response的写方法来发送了回应，  
  response来自于接口重写方法中的参数**  

## HttpServeLet
  **就是上文讲到的所有ServeLet的继承的接口，但事实上老师用了抽象类，  
  因为抽象类里面能定义非抽象的能被完整继承的方法Server()提供给ServeLet们使用，  
  这个方法用于判断POST 和GET请求，参数为request和response  
  将request中的GetrequestUrl()方法的返回值与类中静态常量"POST""GET"对比得出   
并且直接执行对应的抽象方法（子类调用的时候就会执行自己重写好的方法）** 
## 具体实现  
**首先创建好ServerSocket对象，通过ServerSocket对象获得Socket对象。  
再通过Socket对象分别获得OutputStream 和 InputStream  
再拿来分别用来创建Request对象和Response对象  
这时通过Request对象的GetRequestUrl来获取到请求中的URL，  
再通过map获得请求的ServerLet对象对应类名  
通过类名用反射来创建对象，  
通过对象来调用Service方法（继承自父类，）
参数就是上面创建好的请求和响应对象  
就这么多了，没看懂结合代码再看十遍**  

# javaWeb

## 概念

java写的browser能访问的就是javaweb程序

### web资源的分类

web资源分为静态和动态资源两种

静态资源：html css js txt mp4视频 jpg图片

动态资源：jsp页面，Servlet程序，asp

## Tomcat课程部分  

Tomcat服务器是一个免费开放源代码的web应用服务器，属于轻量级的应用服务器  

conf 文件夹中的server.xml文件    
Connector标签下设置tomcat  localhost端口 

## 搭建第一个web  
新建项目要选javaEE下面的Web Application  
tomcat 中request 和response都已经有这个对象了
我们实现server就可以了  
mapping配置到web.xml里面 
导入HTTPServer方法  
**projectStructure -> modules -> dependenciess -> 右边家加号，JARs or ，，-> 
找到ServeLet-api**
https://blog.csdn.net/weixin_47564211/article/details/114644217

## servlet

### servlet生命周期

1.执行servlet构造器方法

2.执行init初始化方法——接收到第一次请求时开始产生对象

{初始化方法只有调用了servlet才会初始化，但是可以配置，在相应的servlet 的xml中配置    load on startup   }

init初始化

3.执行service方法

4,执行destroy销毁方法

~~平时实际中写servlet的时候，新建servlet类继承HttpServlet然后重写doget或者do post方法，~~

~~再配置好mapping映射关系，记得在我们配置map三步~~

~~servet标签  servlet-class标签  servlet mapping标签三个标签写全~~ 

### servlet创建方法

右键包名new servlet 然后去直接配置第三步的servlet mapping  

**重写init时一定要加上运行父类init**

## ServletConfig类

**// 1、可以获取 Servlet 程序的别名 servlet-name 的值**

**// 2、获取初始化参数 init-param**

数据来源：？

在相应的页面的servlet的标签里面配置，就在servlet-class后面的位置

**重写init时一定要加上运行父类init**

**// 3、获取 ServletContext 对象**

```java

    <!-- servlet 标签给 Tomcat 配置 Servlet 程序 -->
<servlet>
<!--servlet-name 标签 Servlet 程序起一个别名（一般是类名） -->
<servlet-name>HelloServlet</servlet-name><!--servlet-class 是 Servlet 程序的全类名-->
<servlet-class>com.atguigu.servlet.HelloServlet</servlet-class>
<!--init-param 是初始化参数-->
<init-param>
<!--是参数名-->
<param-name>username</param-name>
<!--是参数值-->
<param-value>root</param-value>
</init-param>
<!--init-param 是初始化参数-->
<init-param>
<!--是参数名-->
<param-name>url</param-name>
<!--是参数值-->
<param-value>jdbc:mysql://localhost:3306/test</param-value>
</init-param>
</servlet>
<!--servlet-mapping 标签给 servlet 程序配置访问地址-->
<servlet-mapping>
<!--servlet-name 标签的作用是告诉服务器，我当前配置的地址给哪个 Servlet 程序使用-->
<servlet-name>HelloServlet</servlet-name>
<!--
    url-pattern 标签配置访问地址 <br/>
            / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径 <br/>
            /hello 表示地址为：http://ip:port/工程路径/hello <br/>
            -->
<url-pattern>/hello</url-pattern>
</servlet-mapping>
    Servlet 中的代码：
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init 初始化方法");
// 1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("HelloServlet 程序的别名是:" + servletConfig.getServletName());
// 2、获取初始化参数 init-param
        System.out.println("初始化参数 username 的值是;" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数 url 的值是;" + servletConfig.getInitParameter("url"));
// 3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());

    }
```

## ServletContext类

### 概念

1。是一个接口，表示为Servlet上下文对象

2.**一个web工程，只有一个ServletContext对象实例**

3.ServeletContext是一个域对象

什么是域对象？

和MAP一样存取数据的对象，叫做域对象

这里的域值得是存取数据的操作范围

​					存数据				取数据					删除数据

Map			put（）						get（）			remove（）

域对象		setAttribute（）		getAttribute（）		 remove（）

### 作用

1. 获取web-xml中配置的上下文参数 context-param  在全局都可以使用

2. 获取当前的工程路径，格式：/工程名   

3. 获取工程部署后在服务器上的绝对路径

4. 像MAp一样存取数据

   **23示例**

   ```java
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ServletContext cs = getServletContext();
       //ServletContext cs = getServletConfig().getServletContext();
       String a = cs.getInitParameter("quanju");
       System.out.println("获取工程路径"+cs.getContextPath());
       System.out.println("获取全局变量"+a);
       System.out.println("获取真实路径"+cs.getRealPath("/"));// '/'获取到的是web根目录
   }
   ```

## HttpServletRequest 类 
### a)作用。 
每次只要有请求进入 Tomcat 服务器，Tomcat 服务器就会把请求过来的 HTTP 协议信息解析好封装到 Request 对象中。 然后传递到 service 方法（doGet 和 doPost）中给我们使用。我们可以通过 HttpServletRequest 对象，获取到所有请求的 信息。 
### b)方法 
i. getRequestURI() 获取请求的资源路径 
ii. getRequestURL() 获取请求的统一资源定位符（绝对路径） 
iii. getRemoteHost() 获取客户端的 ip 地址 
iv. getHeader() 获取请求头 
v. getParameter() 获取请求的参数 
vi. getParameterValues() 获取请求的参数（多个值的时候使用） 
vii. getMethod() 获取请求的方式 GET 或 POST viii. setAttribute(key, value); 设置域数据 
ix. getAttribute(key); 获取域数据 
x. getRequestDispatcher() 获取请求转发对象



### POST请求参数乱码问题

req.setCharacterEncoding("UTF-8");//要用在最前面，获取请求参数之前才有效

## 请求的转发

### 概念：

服务器收到资源后，从一个资源跳到另一个资源

### 特点

1.地址栏不变

2.两个资源一次请求

3.共享request域中的数据

4.可以转发到WEB-INF目录下

5，不能访问工程以外的目录

### 用法

RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2"); 

 requestDispatcher.forward(req,resp);

## base标签的作用

base标签放在head标签里面，一个属性是href  用于设置当前页面href跳转的相对路径，解决了上面请求转发不会更改地址栏导致的相对路径有误跳转错误问题

## HTTPServletReponse类

getOutputStream()

getWriter()

这两个流只能用一个，不然会报错

注意response回传汉字会报错，像下面这么做

```java
//response.setCharacterEncoding("UTF-8");
//response.setHeader("Content-Type","text/html;charset=UTF-8");
response.setContentType("text/html;charset=UTF-8");//上面的两步这个方法一步，捞啊
PrintWriter writer = response.getWriter();
writer.write("老哈真帅");
```

## 请求重定向

```java
//response.setStatus(302);
//response.setHeader("Location","http://www.baidu.com");//上面的两步这个方法一步，捞啊
response.sendRedirect("http://www.hao123.com");
```

特点：

1. 浏览器的地址栏发生变化，彻底过去

2. 两次请求

3. 不共享request域中数据

4. 不能访问WEB-INF下的资源

5. 可以访问工程外的资源

## Cookie

2、Cookie 是服务器通知客户端保存键值对的一种技术。 

3、客户端有了 Cookie 后，每次请求都放在请求头里发送给服务器。 

4、每个 Cookie 的大小不能超过 4kb



## Session

接口：HttpSession

Session就是会话，

用来保留登录消息

### 如何创建，获取

创建和获取都是request.getSession()

​	第一次调用是创建，

​	之后就是获取

分辨方法：ifNew() 判断Session是不是刚创建出来的

每一个会话都有一个身份证号，这个ID是唯一的

# 缺的笔记

jsp

EL表达式

JSTL标签库

文件上传下载

Filter

AJAX