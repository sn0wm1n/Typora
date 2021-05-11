# 概念 
好处：长期存储，结构化查询
 DB database  数据库  
 DBMS database management system 库据库管理系统  
常见的有 MySQL Oracle DB2 SQLServer  
 SQL 
structure query language 
结构化查询语言  

 


## 语言以及概览
 **DQL**
select 
 **DML**
insert update delete  

insert into 表名(列名，，，)
values(值，，，)
(值，，，)
(值，，，)
。。。
(值，，，);
**insert into 表名   
set  列名=值 列名=值 列名=值**

修改单表的记录
update 表名
set 列名=值
where 筛选条件

UPDATE my_employees 
SET Last_name='drelxer'
WHERE id=3;
修改多表的纪录
就是后面的语句变成多表连接

删除
方式一
delete from 表名 where 一删就是一行 不加筛选条件就删表的全部
也可以多表删除 多表删除时，delete from之间加被删除内容的表名
因为匹配了多个表匹配到的信息两个表都有，不知道删除哪一个

truncate table 表名；
** **DDL**
create alter drop   
库和表的创建删除修改  

 **DBA 是指数据库管理员**

## 数据库存储数据特点
1-**数据放到表里，表放在库里**  
2-**每个表有唯一的表名**  
3-**表具有一些特性，类似java的类**  
4-**数据库由表组成，表由列组成，数据库中称列为字段，每一列类似于java的属性**  
5-**表中数据按行存储，每一行类似java中的对象**  

## MySQL特点  
 成本低，性能高，易安装  

 **DBMS分为两类**
1-基于共享文件系统——access  
2-基于C/S   client service  ————MySQL。Oracle 。sqlserver   
第二种需要客户服务端，但一般安装数据库是安装服务端，  

## MySQL启动和停止  
用管理员身份打开DOS窗口  输入命令 net stop/start mysql （不区分大小写）  
**登录方式**
-1 打开自带的  只限root用户  
-2 通过cmd  
mysql 【-h主机名 -P端口号】 -u用户名 -p密码  本地的可以不写  
退出：
exit  ctrl+C同时按  

## MySQL常用命令  
show databases;看当前数据库内容 注意分号  
use 数据库名;  进入数据库  
show tables; 查看有哪些表   
show tables from MySQL; 直接查看某个数据库中的表,当前位置不变  
select database(); 返回当前数据库的库名 
```
create table 表名(
    id int,
    name varchar(20));
```
desc 表名;---查看表结构 
select *from 表名; 查看数据  


**查看当前数据库版本  
**select version();
或者在cmd环境下  mysql --version**



## MySQL语法规范  
1.不区分大小写，但建议关键字大写，表名列名小写    
2.每条命令最好用分号结尾  
3.每条命令根据需要缩进换行  
4.注释： 
单行注释：#注释文字  
单行注释：-- 注释文字    ————有空格  
多行注释  /*注释文字   */   

## DQL语言  
Data Query Language    
数据查询  
### 境界一：基础查询  
语法：  
——————select 查询列表  from 表名；  
-特点：——查询列表可以是，表中字段，常量值，表达式 函数  
—————————查询到的表格是虚拟的
** 查询表中的单个字段
SELECT last_name FROM employees;
** 查询表中的多个字段
SELECT last_name,salary,email FROM employees;
** 查询全部字段  
SELECT * FROM employees;  
也可以手动一个一个点，、
SELECT `first_name`,`last_name`,`email`,`phone_number`,`job_id`,`commission_pct`,`commission_pct` FROM employees;  
**# * 键盘上1旁边的`着重号用于把关键字强转成字段  
**# * F12格式化  F9执行  
** 查询常量值  
SELECT 100；  
SELECT john； 
**查询表达式
SELECT 100*98； 
** 查询函数  
SELECT VERSION；  
**起别名  
AS 别名 或者 空格 别名 
查询时作为表头  
当别名容易产生歧义的时候用双引号引起来  
**去重化查询  
SELECT DISTINCT department_id FROM employees;  
** +号的作用  
select 100+90  两个操作数都为数值则做加法运算  
select '123'+22 有一方是字符型，经理转换，转换不成功就算了输出0  
select null+223 有一方为null 结果肯定null  

** concat（string，string，string，，，）
连接字符串  
**# concat案例  
每个列之间用，隔开，列头显示成OUT_PUT；  

```
#显示所有列，各个列用逗号连接，列头显示成OUT_PUT 
SELECT 
  CONCAT(
    `first_name`,
    ',',
    `last_name`,
    ',',
    `job_id`,
    ',',
    IFNULL(`commission_pct`, 0)
  ) "OUT_PUT"
FROM
  employees ;

```

** SELECT IFNULL(commission_pct, 0)FROM employees ;
判空，为空则返回第二个参数  

### 境界二：条件查询  
语法：
——————SELECT 查询列表 FROM 表名 WHERE 条件;
筛选条件分类；  
-1 条件表达式分类  
    
```
>     <   !=     <>   >=     <=
```

** IFNULL()和ISNULL()
ifnull(被判断得值，返回值)如果不为null返回本身，如过为null返回参数中的返回值  
isnull（被判断得值）如果为null返回1不为null返回0  

-2  逻辑运算符  
and or not  也支持java中的 && || ！  
-3  模糊查询  
like  
between and  
in    
is null
** 举例

```
**# 查询工资高于12000的员工信息
SELECT 
  * 
FROM
  employees 
WHERE salary > 12000 ;
**# 查询部门编号不等于90的员工名和部门编号  
SELECT 
  last_name,
  first_name,
  department_id 
FROM
  employees 
WHERE department_id <> 90 ;
```
** 模糊查询  
**# LIKE 一般配合通配符%使用  
%代表 任意多 个字符包括0个   _代表任意单个字符    
比如  WHERE last_name LIKE '%a%'表示什么位置有a都可以，不区分大小写 
**# LIKE模糊查询 案例
要求查询第三个字符为a的员工名和工资  
```
SELECT 
  last_name,
  salary 
FROM
  employees 
WHERE last_name LIKE '__a%' ;


```
如果需要查询的内容有 % _ 这两个符号，  
就用\转义，MySQL推荐的方式是整个语句后面跟ESCAPE再跟上需要用来转义的关键字  
**# BETWEEN AND 
相当于  WHERE var >= n AND var <= n+20;  
WHERE var BETWEEN n AND n+20;
**# in  
相当于  
WHERE var = n OR var = m OR var = l；
WHERE var in (n,m,l);  
in列表内容类型必须一致或者兼容 比如123和'33'  
**# IS NULL   IS NOT NULL  
因为=判断不了NULL  

**# 安全等于 可以判断 NULL的等于 <=>
<=>  九里铺  

### 境界三：排序查询  
语法：  
**SELECT 查询内容**  
**FROM 表名**  
**【WHERE 筛选条件】**  
**order BY 排序列表 【asc|desc】**   

asc降序 ，desc升序  不写默认降序  
** -1-别名可以用来赋值，给一个表达式别名，这个别名就可以在别的需要表达式的地方用  


** -2-函数也可以 比如说这个姓名长度 length(last_name)可以作为返回值排序  
** -3-在oder by 后面用逗号隔开不同排序列表，先后顺序就是排序优先级  
** -4-除了limit子句以外order by一般是放在最后面的  

### 境界四：常见函数


** 1.单行函数
** 字符函数
1、字符函数  
	**concat拼接**  
多个字符为参数,逗号隔开，返回拼接在一起的结果    
	**substr截取子串**   
substr（str，n）;   substr（str，n，m）;  
两个参数时从头往后从一开始数数到参数位，返回参数位以后的所有内容，包括参数位    
三个参数时返回str第n个到第m个   包括第n和第m个    
    **upper转换成大写**   
-upper('被转换成大写的内容')。。。   
	**lower转换成小写**  
-同上  
	**trim去前后指定的空格和字符**   
-——trim('    string    ')会去掉两边的空格返回string  
-——trim（'a'for'aaaaastraaingaaa'）会去掉两边的a返回straaing，  
	**ltrim去左边空格**  
-——同上吧  
	**rtrim去右边空格**   
-——同上吧  
	**replace替换**  
-——replace(str1,str2,str3)把str1中所有str2替换成str3  
	**lpad用指定的字符左填充**  
-——LPAD('str',n,'str1')  在str字串左边填充n个str1    
	**rpad用指定的字符右填充**  
-——RPAD（）同上  
	**instr返回子串第一次出现的索引**  
-——	instr('str','tr')返回一    
	**length 获取字节个数**  
-——————注意是字节  show variables like '%char%'获取当前使用字符集  

** 数学函数	  
2、数学函数  
	**round 四舍五入**  
-——round(1.65)=2 看十分位，取整四舍五入，负数的时候看绝对值入的时候往更小入    
    round(1.567,2)=1.57 小数点后保留两位  
	**rand 随机数**  
-——
	**floor向下取整**  
-——不解释，注意负数数时不看绝对值，向小的数字为下  
	**ceil向上取整**  
-——不解释，注意负数数时不看绝对值，向大的数子为上  
	**mod取余**  
-——mod（a,b）=a % b  算法是a%b = a-a/b*b 
mod(-10,-3)   
= -10-(-10)/(-3)*(-3)  
= -10-1*(-3)  
= -10-(-3)
= -1  
	**truncate截断**  
-——truncate（1.69999,1）=1.6不考虑后面的位  
** 日期函数  
3、日期函数  
	**now()当前系统日期+时间**  
-——返回当前系统日期和时间  
	**curdate()当前系统日期**    
-——只返回日期不包括时间  
    **Datediff**  
-——datediff(a,b)  日期相差天数   a,b 注意字符  
	**curtime当前系统时间**    
-——只返回时间不包括日期  
	**str_to_date 将字符转换成日期**
str_to_date('1998-04-24','%Y-%m-%d')
-——将指定格式的str转换成日期类型    
	**date_format()将日期转换成字符**
-——date_format(日期类型,'格式')  
    **YEAR(now())**   
    **MONTH(now())**  传入的都是日期类型  
    **MONTHNAME(now())**  
案例  

```
#4、创建存储过程或函数实现传入一个日期，格式化成 xx 年 xx 月 xx 日并返回
DROP PROCEDURE forma;
DELIMITER $
CREATE PROCEDURE forma (IN dat DATETIME,OUT da VARCHAR(50))
BEGIN
SELECT DATE_FORMAT(dat,'%y年%m月%d日') INTO da;
END $

SET @c='';
CALL forma(NOW(),@c);
SELECT @c;

```

** 流程控制函数
4、流程控制函数  
	**if 处理双分支**  
-——if(bool,str1,str2)类似三目运算符第一个值为真就是str1 第一个值为假就是str2  
	**case语句 处理多分支**      结尾必须end     
		情况1：处理等值判断
		case a  
		when b then 值或语句  
		when c then 值或语句  
		when d then 值或语句  
		else 值或语句  
		看后面b，c，d谁和a相等执行谁  
		情况2：处理条件判断  
		case  
		when 条件 then 值或语句  
		when 条件 then 值或语句  
		when 条件 then 值或语句  
		else 值或语句 
		end 
** 其他函数	
5、其他函数  
	version()版本  
	database()当前库  
	user()当前连接用户
	MD5()返回加密值 

** 2.分组函数  
   做统计使用，又称为统计函数聚合函数，组函数  
   二、分组函数

sum 求和
	**max 最大值**  
-——max(salary) 得出这一列的最大值  
	**min 最小值**  
-——同上  
	**avg 平均值**  
-——同上
	**count 计数**  
-——得出这一列一共有多少个数  
特点：  
-1、以上五个分组函数都忽略null值，除了count(*)  
-2、sum和avg一般用于处理数值型  
max、min、count可以处理任何数据类型  
-3、都可以搭配distinct使用，用于统计去重后的结果  
-4、count的参数可以支持：  
-————字段、*、常量值，一般放1 *

建议使用 count(*)

可以和distinct搭配使用    
distinct 加在列表前面去重然后参与运算  

**# count()常用方法  
count(列)；列的总个数，忽略null  
count(*);统计所有行数，一个行只要有值不为null就可以被加入  
count(任意常量)；1，'cvxx' 都可以  
**# he分组函数查询的字段要求是by group字段  

### 境界五  分组查询  
语法：    就相当于分组函数本来是根据参数查询所有列出结果，这次是根据分组的列表，给每个含有相同分组列表内容的组合查询一次列出结果  
** select 分组函数，分组的列表       
** from 表  
** 【where 筛选条件】  
** group by 分组的列表
** 【having 分组后筛选】
** 【oder by 子句】

特点：  
1、可以按单个字段分组   
2、和分组函数一同查询的字段最好是分组后的字段   
3、分组筛选  

————————针对的表————--位置————————关键字  
分组前筛选：——-原始表—————--group by的前面——---where    
分组后筛选：——-分组后的结果集——group by的后面———-having     
	
**4、可以按多个字段分组，字段之间用逗号隔开**  
5、可以支持排序  
6、having后可以支持别名  

**# 知识点案例在习题四  

### 境界六 连接查询  又称为多表查询

 ————笛卡尔乘积  多表连接查询

**首先搞明白执行顺序，from->where>group by->select->having->order by **

 select 分组函数，分组的列表       
 from 表  
 【where 筛选条件】  
 group by 分组的列表
 【having 分组后筛选】
 【oder by 子句】

	笛卡尔乘积：如果连接条件省略或无效则会出现
	解决办法：添加上连接条件


​	
一、传统模式下的连接 ：等值连接——非等值连接


	1.等值连接的结果 = 多个表的交集
	2.n表连接，至少需要n-1个连接条件
	3.多个表不分主次，没有顺序要求
	4.一般为表起别名，提高阅读性和性能

二、sql99语法：通过join关键字实现连接

	含义：1999年推出的sql语法
	支持：
	等值连接、非等值连接 （内连接）
	外连接
** 同学们注意了哈，来给大家讲一下内连接外连接，内连接就是根据连接条件获取到的交集，需要连接条件中相等的值才会拿出来
** 外连接中首先是左外连接和右外连接。
** 左外连接left join前面也就是from后面的表为主，根据前面的表中的连接条件获取后面的表有没有相符的，有就接在后面，没有就在后面接个NULL，也就是说后面的表中没有被匹配到的值会丢失  
** 右连接就是把主从表的位置反着写了一下，，
** 全外连接就是在前两种的基础上不抛弃从表中没匹配上的部分，懂我意思吗？（交叉连接就是笛卡尔积）

	交叉连接


​	
** 语法：  ——————————执行顺序
**select 查询列表**  ⑦  
**from 表**   ①  
**【连接类型】join 第二个表**  ②  
。。。  
**on 连接条件(n-1个）**    ③  
**where 分组前筛选**    ④  
**group by 分组字段**  ⑤  
**having 分组后筛选**  ⑥  
**order by 最终排序**  ⑧  


​	
​	
​	select 字段，...
​	from 表1
​	【inner|left outer|right outer|cross】join 表2 on  连接条件
​	【inner|left outer|right outer|cross】join 表3 on  连接条件
​	【where 筛选条件】
​	【group by 分组字段】
​	【having 分组后的筛选条件】
​	【order by 排序的字段或表达式】
​	
​	好处：语句上，连接条件和筛选条件实现了分离，简洁明了！


​	
三、自连接

案例：查询员工名和直接上级的名称

sql99

	SELECT e.last_name,m.last_name
	FROM employees e
	JOIN employees m ON e.`manager_id`=m.`employee_id`;

sql92


	SELECT e.last_name,m.last_name
	FROM employees e,employees m 
	WHERE e.`manager_id`=m.`employee_id`;

### 子查询  
出现在其他语句中的select语句，称为子查询或者类查询  
** 就TM是嵌套，比如查询工资比某人高的，就查salary>( ) 括号里面放一个完整的查询语句，查询的结果是一个人的工资值  
那么 ，where后面跟的是 in 呢 ，需要一列数据   
于是就有了列子查询，后面跟个括号 ，括号里面是查询结果是一列数据的查询语句  

** 多行（单列）操作符 
IN/NOT IN    查后面的括号里面有没有相同的，  
ANY/SOME     查到后面括号有没有值符合条件  
ALL          查到后面括号的值是不是全部都符合条件    



** 两个条件都是相等或者in啥的可以（条件一）（条件二）=（select 条件一j结果  条件二结果）  


### 境界八 分页查询  

select 分组条件   ⑥   
from    表      ①  
【join type】join  ②  
on 连接条件   ③  
group by      ④  
having       ⑤    
order by    ⑦  
limit    ⑧  

### 境界九 联合查询  
** 多条查询语句联合成一条  
当我们查询多个表并且查询信息一致，（
列数一致  
类型最好一致  
）但是没有连接条件  
union  
就好像我们和外国人都一样，属性一致，叫法不一样，但是可以列在一起  
we are the  world  ！  
相同数据会去重  
如果不想去重使用 union all  


## DML语言
Data Manipulate Language   
增删改  
### 插入语句 
语法：   
** 第一种  
**insert into 表名(列名，，，)   
values(值，，，)  
(值，，，)  
(值，，，)  
。。。   
(值，，，);**  

```
INSERT INTO users 
VALUES 
(1,'Rpatel',10),
(2,'Bdancs',10),
(3,'Bbiri',20),
(4,'Cnewman',20),
(5,'Atropebur',40);
```


1.插入的值得类型要与列的类型一致或兼容   

** 第二种  
**insert into 表名   
set  列名=值 列名=值 列名=值**

** 两种区别  
方式一可以**多行**方式二不可以    
方式一支持**子查询**方式二不支持  

### 修改 
** 修改单表的记录
update 表名  
set 列名=值  
where  筛选条件 


```
UPDATE my_employees 
SET Last_name='drelxer'
WHERE id=3;
```

** 修改多表的纪录
就是后面的语句变成多表连接

### 删除 
** 方式一
delete from 表名 where 一删就是一行 不加筛选条件就删表的全部  
也可以多表删除
多表删除时，delete from之间加被删除内容的表名  
因为匹配了多个表匹配到的信息两个表都有，不知道删除哪一个  


```
DELETE users,my_employees FROM
users JOIN my_employees 
ON users.`userid`=my_employees.`Userid`
WHERE users.`userid`='Bbiri';
```

** 方式二
truncate table 表名   一删就是全部  


## DDL语言  
Data Define Language  
数据定义语言  

### 库和表的创建删除修改 
create  
alter  
drop  
### 库的管理 
-1 库的创建  
create database 库名 ;  
create database if not exits 库名; 
-2 库的修改  
alter database books charactor set gbk;
-3 库的删除   
drop database 库名;
drop database if exits 库名;
### 表的管理
** -1 表的创建   
语法   
create table 表名(  
    列名 列的类型 【(长度)约束】,  
    列名 列的类型 【(长度)约束】,  
    ....  
    列名 列的类型 【(长度)约束】  
)   
** **-2  表的修改 **  
①修改列名， 
alter table 表名 **change** column 列名 新列名 列类型；  
②修改列类型【约束条件】  
alter table 表名 **modify** column 列名 新类型  约束条件
③添加新列   
alter table 表名 **add** column 列名 类型 【first|after 字段名 指定跟在谁后面】；   
④删除列     
alter table 表名 **drop** column 列名；  
⑤修改表名   
alter table 表名 **rename** 【to】 新表名；  
⑥复制表   
-1 复制表的结构    
create 表名 like 被复制的表名；  
-2 复制表的一切  
create 表名 select * from 被复制的表名；  
**看！复制的时候后面加了select，那么select就可以筛选，想要只赋值部分结构的话就设置恒不成立的条件**

⑦修改约束条件  

alter table 表名 add constrain 约束条件；

** -3 表的删除  
drop table 表名；

## 常见数据类型  
** 数值型
    整型  
    小数 定点数，浮点数 
** 字符型
    较短的文本  ->char varchar  
    较长的文本 ->text blob  
** 日期型
### 整型
随着字节数不同范围不同   
分为有符号和无符号，有符号的默认多一位符号位，11位
### 小数  
后面的长度限制（D，M）分别是限制总长度和限制小数长度  
### 字符型  
**较短的文本  char varchar**
char固定长度，效率较高，内存占用大一点，大小可以省略默认为一    
varchar可变长度，效率较低，内存占用小一点 大小不能省略  
enum类型  
定义时  
e ENUM('a','b','c')  
插入时就只能插入这些定义时枚举好的内容  
set类型和上面一样，但是一个位置上可以插入多个数值逗号隔开    
insert into 表名 【默认全部参数】values ('a,b,c');  

**较长的文本  text blob**
### 约束  
### 六大约束  
1---primary key 主键，值唯一且非空  
2---foreign key 由别的表关联值决定   
3---default 默认  
4---unique 唯一但是可以为空  
5---not null 非空  
6---check 检查约束 比如性别只能为男女 mysql不支持   

列级约束都支持，外键约束没效果  
表级约束 不支持default，不支持not bull   
**列级约束**  
主键，非空，唯一，默认，   
index索引  
show index from 表名  
会显示所有主键外键unique  信息  
**表级约束**  
语法  
在各个字段的最下面  
开头是 constraint 约束名（主键的约束名随便设置但是会被定死为primary key）  
然后是 约束类型（字段名） 

通用写法  

```sql
create table student(  
    id int primary key,    
    name char(6) not null,  
    seat int unique ,   
    gender char not null,  
    age int default 18,
    major_id int ,
    constraint fk_student_major forein key (major_id) references major(id)
    
);
```
### 级联更新和删除

就是说能让外键真正的受影响，在逐渐被更改或者删除时外键有相应反应  

比如

constraint fk_student_major forein key (major_id) references major(id)

在结尾加上  on update casecade on delete casecade  

或者是




```SQL
#1. 向表 emp2 的 id 列中添加 PRIMARY KEY 约束（my_emp_id_pk）
CREATE TABLE emp2(
	id INT(20),
	NAME CHAR(4)
);
SELECT * FROM emp2;

#添加表级约束
ALTER TABLE emp2 ADD PRIMARY KEY (id) ;

#删除emp2的主键
ALTER TABLE emp2 DROP PRIMARY KEY;

#查看emp2表的键
SHOW INDEX FROM emp2;

#添加列级约束让emp2称为主键
ALTER TABLE emp2 MODIFY COLUMN id INT(20) PRIMARY KEY;

DESC dept2;
SELECT * FROM dept2;
SHOW INDEX FROM dept2;

#2. 向表 dept2 的 id 列中添加 PRIMARY KEY 约束（my_dept_id_pk）
ALTER TABLE dept2 MODIFY COLUMN id INT(7) PRIMARY KEY; 

#3. 向表 emp2 中添加列 dept_id，并在其中定义 FOREIGN KEY 约束，与之相关联的列是
#dept2 表中的 id 列
ALTER TABLE dept2 DROP COLUMN dept_id ;

#新建列
ALTER TABLE emp2 ADD COLUMN dept_id INT;

#删除外键
ALTER TABLE emp2 DROP FOREIGN KEY fk_dept2_emp2;

#添加外键
ALTER TABLE emp2 ADD CONSTRAINT fk_emp2_dept2 FOREIGN KEY (dept_id) REFERENCES dept2(id);

#查看有哪些键
SHOW INDEX FROM emp2; 

```
## 标识列(自增长列)
添加标识列的方法————  
在约束条件后面追加
AUTO_INCREMENT  
步长可以设置 
set auto_increment_increment=n  
-1标识列必须是key  
-2标识列只能有一个  
-3标识列类型只能是数值型  
-4标识列可以手动修改变量来改变起始值和步长  


## TCL语言  
Transaction Control Language  
事务控制语言  
为了保证一组语句能够一起执行，就是说要么都执行，要么都不执行，防止我操作没完全进行引起的逻辑混乱  

**事务的ACID属性**  
A atom  原子性 不可分割的  
C Consistency 一致性 从一个一致性的状态变化到另外一个一致性的状态    
I Isolation 不受其他事物的干扰  ps要靠下面讲的知识点  
D Durability 持久性  

### 事务的创建
** 隐式事务 
增删改 insert  alter  update  
** 显式事务  
定义：事务有明显的开始和停止的标记  
前提：先删除自动提交  set autocommit=0  （写了这个会自动开启事务）  
步骤1-  开启事务    
start transaction;  
步骤2-  编写sql语句 (增删改查)不包括create show drop'  
语句;  
语句;  
...   
步骤3- 结束事务  
-1 提交事务 commit  
or 回滚事务 rollback；  
truncate 不能回滚  

脏读：  
1.a事务读取的b事务更新了但是没有提交的字段，b事务**回滚了**，a读取的内容就是无效的，脏读  
2.不可重复读：  
a事务读取了b事务的字段之后，b事务更新了，a再读的时候b又不一样了，  
3.幻读  
a事务读取的b事务更新了但是没有提交的字段，b事务**插入**了，a读取的内容就是无效的，脏读  
数据库事务的隔离性  
数据库系统必须具有隔离并发运行各个事务的能力，使它们不会相互影响，避免各种并发问题  
### 设置隔离级别  
**显示隔离级别**  
@@tx_isolation  
select @@tx_isolation  
**设置当前mySQL连接的隔离级别 ** 
set transaction isolation level read committed    
**设置数据库系统全局的隔离级别 ** 
set global transaction  isolation level read committed  

** 保存点  
savepoint ap;  
搭配roll back 使用  
rollback to ap；

## 视图 
含义：虚拟表  和普通表一样使用，可以存起来

### 视图的创建
create view  视图名
as  
SELECT *****；

### 视图的修改  
create or replace view 视图名
as
select *****；
方式二  
alter view as  
select *****；  
### 删除视图  
drop view 视图名1，视图名2，视图名3；
### 视图的更新  
insert update delete  
实际上呢， 就是在修改原表  
update table 表名 set 列名=值；
**具备以下特点的视图不允许更新**   
-1 分组函数，distinct，group by，having，union，union all； 
## 变量   
**  系统变量   
```sql
全局变量  
会话变量  
```
**查看所有系统变量**    
SHOW GLOBAL|【session】 VARIABLES    
**查看满足条件的部分系统变量**  
SHOW GLOBAL|【session】 VARIABLES like "%char%";    
**指定的某个系统变量**  
select global|【session】.@@系统变量名;   
**为某个系统变量赋值** 两种方式   
set global | 【session】 系统变量名 = 值;  
set @@global|【session】.系统变量名 = 值；  **不能跨重启**   

** 全局变量和会话变量  
全局变量在每次服务器重启时会为所有的全局变量，赋初值，针对于所有会话（连接）有效，但不能跨重启  
会话变量只在会话内有效  

**  自定义变量 
    用户变量  
    局部变量  
声明，赋值，使用  
**# **用户变量的作用阈针对于当前会话连接有效同于会话变量作用阈**  
**用户变量声明并初始化** **赋值有=和:=**  
    SET @用户变量名=值；  
    或者 SET @用户变量名:=值  
    SELECT @用户变量名:=值   
    
**赋值同上**  这个语句既能赋值又能声明，又能更新   
**赋值自己还有一个方法**  
SELECT 字段 into 变量名 from ****；  结果必须是一个值   
**使用**  
查看用户变量的值 SELECT @用户变量名; 


**# **局部变量声明**  
仅仅在定义他的begin end中有效  

DECLARE 变量名 类型;  
初始化 -> DECLARE 变量名 类型 DEFAULT 值;

**赋值**  
set 变量名=值； 或  
set 变量名:=值； 或  
SELECT @变量名:值；  
方式二  
SELECT 字段 INTO 局部变量名  
FROM 表;  

**使用**  
SELECT 局部变量名  

对比用户变量和局部变量  


案例：----->  
声明两个变量求和并打印  
用户变量


```
SET @a = 10;
SET @b = 20;
SELECT @a+@b;
```





## 存储过程和函数  
类似于java里面的方法     
一组预先编译好的sql语句的集合，理解 成批处理语句    
### 语法  
delimiter $
CREATE PROCEDURE 存储过程名(参数列表)  不传参默认全部参数不用带括号     
begin   
 语句;  **一定一定一定要加分号！**    

end ;    
$
参数列表包含三部分  
—————参数模式    参数名  参数类型  
**举例 IN  stuname  VARCHAR[20]**   

参数模式  
in  这个参数可以作为入口   
out  这个参数可以作为输出->返回值    
intout  这个参数既可以作为入口又可以作为出口   
如果存储过程体只有一句话，begin end 可以忽略  
储存过程体中的每条sql语句结尾必须加分号  
存储过程的结尾可以使用delimiter重新设置  
语法：  
delimiter 结束标记  
案例  
delimiter $  
### 调用语法  
CALL 存储过程(实参列表);  
### 删除语法 
DROP procedure 函数名;  没有括号  
### 查看存储过程  
show create procedure  


## 函数  
存储过程和函数的区别   
函数只能有一个返回，多了少了都不行    
存储过程可以任意，不返回都可以  
存储过程用于数量批量操作，批量更新，  
函数用于获得一个结果  
### 创建语法  
create function 函数名(参数列表) return**s** 返回类型  
begin  
函数体  
end  
**这里的参数列表包含两部分   参数 参数类型**  
**肯定会有return语句，没有会报错**  return值  

### 调用函数  
和系统那些一样  SELECT 函数名 ；  
案例  

```sql
#根据部门名返回该部门的平均工资 
DELIMITER $ 
CREATE FUNCTION av(dename VARCHAR(20))RETURNS DOUBLE
BEGIN
	SET @a=0;
	SELECT AVG(salary) INTO @a
	FROM departments d RIGHT JOIN employees e 
	ON d.department_id=e.department_id
	WHERE d.department_name=dename;
	RETURN @a;
	

END $
SELECT av('IT');
```
### 查看函数  
show create function 函数名；不带括号  
### 删除函数  
drop 函数名；
## 流程控制结构  
### 分支结构
** **-1 IF结构**    
三位运算符   
函数：  
if(a,b,c);  
结构：  

if 条件 then 语句；  
else if 条件 then 语句； 
else if 条件 then 语句；  
else if 条件 then 语句； 
else  语句； 
end if； 
只能放在begin end中  



**-2 case结构**   
①等值运算  
case 值  
when 判断相等的值  then 返回值【或语句加';'】  
when 判断相等的值  then 返回值  【或语句加';'】  
when 判断相等的值  then 返回值  【或语句加';'】  
else 要返回的值  【或语句加';'】  
end  【case】
②多重IF  
case  
when 要判断的条件  then 返回的值  【或语句加';'】  
when 要判断的条件  then 返回的值  【或语句加';'】  
when 要判断的条件  then 返回的值  【或语句加';'】  
else 返回的值  【或语句加';'】  
end  【case】  
CASE既可以作为表达式嵌套，也可以作为独立的语句去使用  
作为独立的语句时必须放在begin end 当中去使用 

**如果没写返回值，所有when还都不满足，返回null**  

** **循环结构**  
**while loop repeat**  
循环控制  
iterate  类似continue  
leave 类似 break;跳出，结束当前的循环  
**while**  
【标签名:】while 循环条件 do  
循环体； 
end while【标签】;  
**loop**  
【标签:】loop 循环体；end loop【标签】；  
**repeat**  
【标签:】repeat  
    循环体；  
until 结束循环的条件  
end repeat 【标签】;






## DCL语言  
Data Control Language  