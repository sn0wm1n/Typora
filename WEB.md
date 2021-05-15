# HTML

## html基础语法

### 标签的属性

1.标签的格式

**<标签名>封装的数据</标签名>**

2.标签名大小写不敏感

**3.标签拥有自己的属性**

①基本属性：可以修改简单的样式，bgcolor="red";

②事件属性: 可以设置事件响应后的代码                onclick="alert:('你好');"//javascript提供的警告框函数，可以接受任何参数，参数就是警告框的函数信息

4.标签分为单标签和双标签

```html
</br>   <!--换行-->
</hr>   <!--一条水平线-->
```

双标签就是常见的。

### html书写规范 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">    <!--表示当前页面使用UTF-8字符集,这行是一个标准的注释-->
    <title>标题</title>
</head>
<body>
    hellow
</body>
</html>
```

html标签分为两部分，分别为head和body，

head一般包括三部分，title ，css样式，js代码  

## 常用标签介绍 

#### font标签

```html
<font color="aqua"face="宋体"size="7">hellow<font/>
```

#### 常用的特殊字符

```html
<      &lt;
>      &gt;
空格   &nbsp

```

#### 标题标签

标题标签是h1到h6,

align是用来对齐的标签属性 下面分别是左对齐，居中对齐，右对齐

```html
        <h1 align="left">标题一<h1/>
            <h2 align="center">标题二<h2/>
                <h3 align="right">标题三<h3/>
                    <h4>标题四<h4/>
                        <h5>标题五<h5/>
                            <h6>标题六<h6/>
```

#### 超链接标签

```html
<a href="http://www.baidu.com" target="_self">百度</a>
<a href="http://www.baidu.com" target="_blank">百度</a>
<a href="http://www.baidu.com">百度</a>
<!--                                默认——self-->
```

超链接的标签属性 target  _self是自己变，_blank是创造新的  

target也可以是某个浮动页面的name属性值

#### 列表标签

##### 无序列表

```html
<ul type="none">
                                    <li>赵四</li>
                                    <li>小沈阳</li>
                                    <li>刘能</li>
                                    <li>宋小宝</li>
                                </ul>
```

ul是列表  li是列表项  type列表标签属性可以修改列表项前面的那个点的样式 

##### 有序列表

#### Img标签

web绝对路径：

http：///ip:port/工程名/资源路径

web相对路径：

.	表示当前文件所在的目录

..	表示当前文件的上一级所在的目录

文件名，指当前目录的文件，省略了 ./

```html
 <img src="img/a1.jpg" height="1280"width="1920"/>
```

border 颜色在style属性里面声明，否则会默认为上文font的颜色？？？

#### 表格table

table表格标签

tr是行标签		 		th是表头标签 		td是单元格标签		

cellspacing表格间距属性

b标签会让被套着的字加粗   

可以让某个单元格跨行跨列 

#### iframe标签

能显示一个单独的页面 

iframe标签可以在页面上一小块区域显示一个单独的页面

双标签 

iframe可以和a标签一起用，切换不同的浮动页面	

1.在iframe上面定义一个name属性值，

2.把name属性值给超链接的target属性值

```html
<ul>
    <li><a href="hello.html" target="abc">hello</a></li>
    <li><a href="html2.html" target="abc">html2</a></li>
    <li><a href="html3.html" target="abc">html3</a></li>
</ul>
```

#### 表单

用来收集信息

#### 还有关于表单的提交和get post请求的关系等知识资料找吧 

# CSS

## css语法规则

link标签用来引入css样式代码 

# JavaScript

## 概述
###### JS 一门运行于解释器的解释性脚本语言
- 运行环境
嵌入浏览器内核的解释器   
NodeJs  
###### js组成三部分
- 一，核心ECMSScrript  
  
- 二，文档对象模型
    有能力和网页对话，如鼠标移动获取之类的
- 三，浏览器对象模型(BOM)
    让JS又能能力和浏览器对话
    ############ 特点
    不用编译，数据决定数据类型
    面向对象
###### 浏览器内核的作用
内容排版引擎剖析html css  
2，脚本引擎解析  JS  

Chrome的Console就是JS代码可以执行的地方
############ 使用位置
- 1，嵌入在元素事件中  
比如点击的时候  把onclick属性放在button的头标签框里面直接让他等于一段JS代码
- 2 ， 嵌入在Script标签中
允许出现在网页的任意位置
- 3， 写在外部脚本文件中**.js
在script头标签中加入一个src属性对应js的文件路径  
注意引入了外部文件的JS标签里面不能写代码  

## JS基本语法元素

大小写敏感  
使用分号表示结束  
sublime text ctrl+/ 注释  

### 变量

内存  
B是Byte  8个bit组成  



赋值

 var 变量名    来声明  
 var 是局部变量 ，不加var默认生成全局变量  

console.log( ) 或者 document.write()   打印

未经初始化的变量是undefined 

命名规则和java一样

### 数据类型函数

typeof()对象放括号里面  typeof 对象跟在后面 
############ NaN
isNaN() 判断是否为数字

** 注意，所有类型和String进行+运算时都会变成String类型

任意类型可以用toString()函数转换为String类型
 pareInt()同样的
 parseFloat（）  
 这类的类型转换有一个特点，遇到相对类型的字符就转换，遇到不对应的类型就叫停  
 比如parseFloat("35.4哈哈哈")就会转换成35.4   
 parseFloat("哈哈哈35.4")则为空，因为一遇到非float的字符他就叫停了  


** Unicode字符，数字，标点组成
汉字开头 \u4e00
汉子结束 \u9fa5
"张".charCodeAt().toString(16)  查看字符张的十六进制的表现形式    
\r 回车  \t 制表符    \n 换行  

### 输入

prompt("请输入")  
括号里面是提示性文字

### 函数

函数内容可以看下面尚硅谷的函数部分比较详细

```
funtion 函数名{
    可执行语句；
    console.log("Hloo");
}
```

### 数组

var arr = new Array();  
var arr = [3,23,5,4,123];  
var arr = ["awd","awdw"];
arr[0]=wdad;  
有混合类型数组，可以通过下标直接访问  
数组缩容 arr.length = 4； 
把arr缩小到4长度  

** 数组的三个不限制
不限制元素类型  
不限制下标  
    获取没定义的会返回undefined不报错  
    修改值，修改的越界了就自动扩容  
    下标不连续的数据称为稀松数组  
不限制长度  

############ 关联数组 也就是Map
新建之后赋值的时候直接把下标里面添加想要的数据类型
用增强for遍历   

## 数组API
1.1 String(arr)  :将arr里面每个元素转换为字符串，用逗号分隔  
固定套路：对数组进行拍照：用于鉴别是否数组被修改过  
1.2 arr.join("连接符") ：将arr中每个元素转为字符串  ，用自定义连接符分隔  
**可以拼接字符串数组**

###### join的固定套路用法
1，chars.join("")->无缝拼接  
 可以用来判断数组是否为空  拼接过后如果为""就是空数组  
2.words.join(" ")->单词拼在一起加了空格就是句子  
3.经常把join用在拼接前后标签

** 拼接和选取
concat();返回一个新数组，由一个数组调用，把括号里的数组或者变量拼接到调用数组的后面， 
var arr4 = arr1.concat();

slice()差不多的用法   切片，两个参数含头不含尾巴 单个参数截取到最后 
**负数表示反向的切片位置**  
** 以上两个函数都不会对原数组造成修改 可以找参数接收
**复制数组可以直接让他等于 arr.slice();**

**############ 造成修改的函数splice**
** 双参数
 删除，arr.splice(开始删除元素的位置,删除元素的个数);  
 返回值delete 临时保存被删除的元素
** 多个参数 ，可以替换可以插入
 和删除同一个逻辑，第二个参数（删除元素的个数）是0的时候，相当于插入，别的元素后移 第三个元素开始就是插入的元素，随便加，替换也就是这个逻辑了

 ############ arr.reverse();翻转数组

 ############arr.sort() 默认把所有元素转换为字符串在排序，问题：只能排列字符串

## DOM查找
DOM -> document object model  
DOM是w3c的标准，中立与平台和语言的接口，它允许程序和脚本动态的访问和更新文档的内容结构和样式。  
对网页进行增删改查操作  

############ 按照id查找
var elem = document.getElementById("id")  
特点-效率非常高  
强调-只能用在document；  
何时-只用于精确查找一个元素  
问题-：不是所有元素都有id

############ 按照标签名查找
var elem = parent.getElementsByTagName("div");  
查找指定parent节点下的所有标签为tag的子节点  

强调： 
1.可用于任意的父元素  
2.不仅查看子节点，而且查完所有子代节点  
3.返回一个动态集合  
 即使只查找一个元素，也返回集合  
必须用[0],取出唯一元素  
        
问题： 不但找直接，而且寻找所有子代

############ 通过name属性查找    name属性在头标签里面定义
document.getElementsByName('name属性值')  
可以返回DOM树中具有指定name属性值的所有子元素集合。  

############ 通过class查找
查找父元素下指定class属性的元素 
var elems = parent.getElemnetsByClassName("class");  
IE9+

############ 通过CSS选择器查找
只找一个元素的话：  
    var elem = parent.querySelector("css选择器");  
    如果选择器匹配了多个，那我们选择一个  
 找多个元素
    var elem = parent.querySelectorAll("css选择器");
    返回非动态集合


## DOM修改
** 核心 DOM
  万能且繁琐  
*1 先获得属性节点对象，在获得结点对象值  
 var attrNode = elem.attributes[下标/属性名]；  
 var attrNode = elem.getAttributeNode(属性名)  

 attrNode.value——属性值  
*2 直接获得属性值  
 var value = elem.getAttribute("属性名")；  
    
** html DOM
  只能html 简单
** 先用简单的，简单的不行再用复杂的
## DOM添加

# JavaScript尚硅谷版本

## JavaScript和Html结合的方式

一种写标签里，一中标签头引入js文件（如下），两种一起的话只执行文件中的

```js
<script type="text/javascript" src="1.js">

</script>
<script>
  alert("jqve?");
</script>
```

## 变量

数值类型：			number

字符串类型：		string

对象类型：			object

布尔类型：			boolean

函数类型：			function

### JavaScript特殊的值：

​	undefined		未定义，所有js变量未被赋予初始值的时候都是undefined

​	null				空值

​	NAN			not a number

### JS中的定义格式

var 变量名 

var 变量名=值

typeof(变量名)

```js
var i;
alert(i);//undefine
alert(typeof(i));//undefine
i=3;
alert(i);//3
alert(typeof(i));//number
i="hahah";
alert(i);//hahah
alert(typeof(i));//string
```

## 关系运算

等于   == 简单的字面值比较

全等于 === 完全的类型都需要一样

例如

var a = 13;

var b = "13";

a==b 为true

a===b 为false

## 逻辑运算

 JS中，0		null		undefined		""(空串)都认为是 false

&& 短路运算，当a和b全为真返回后一个的bool

当a和b有一个为假，返回第一个为假的值

|| 或运算

第一种情况：当表达式全为假的时候，返回

哎呀不说了，就是短路逻辑嘛，什么时候能判断整个表达式的值什么时候就返回

## 数组

（可以看上面的MOOC版本的笔记）

var 数组名 = [];

var 数组名 = [1，‘a’，true];

JS数组不会越界，定义新的会延长数组

数组的遍历

for (var i=0; i < arr.length;i++)

## 函数

```js
function(){
    alert("无参函数被调用了");
}
function(a,b){
    alert("双参函数被调用了");//注意看这里，参数直接写两个自定义变量名，因为类型都是var没必要写
}
//同时需要返回值的语句也不用标明返回啥类型因为都是var
//并且函数可以给名字,上面两个函数可以写成
fun1 = function(){
    alert("无参函数被调用了");
}
fun2 = function(a,b){
    alert("双参函数被调用了");//注意看这里，参数直接写两个自定义变量名，因为类型都是var没必要写
}
//调用的时候也就只需要
fun1();
fun2();//这样

```

JS中函数重载会覆盖上一次的定义

函数中有个arguments隐形参数，在function函数不需要直接定义，但却可以直接来获取所有参数的变量（隐形参数）

可变长参数是一个数组

类似于java中的 (object...args)

访问方法就是在函数内直接使用arguments[0],这样带下标访问  

字符串和数字相加即将会变成字符串的拼接

## 对象

JS两种形式定义对象

Object 形式

var 变量名 = new Object；     **//对象实例(空对象)**

变量名.属性名 = 值； 		     **//定义一个属性**

变量名.函数名 = function(){}	**//定义一个函数**

对象的访问：

​		**变量名.属性/函数名();** 

**{}花括号形式的自定义对象**		

