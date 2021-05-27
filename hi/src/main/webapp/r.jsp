
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lcha.dao.BaseDao" %><%--
  Created by IntelliJ IDEA.
  User: Ha
  Date: 2021/5/27
  Time: 7:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span id="title">留言板</span><br>

<form action="a1" method="post">
    <textarea id="tex" name="love"></textarea><br>
    <button id="btn">大按钮</button><br>
    <%
        ArrayList<String> msg = BaseDao.getMsg();
        for (int i = 0; i < msg.size(); i++) {
    %>
    <p><%out.write(msg.get(i));%></p>
    <%}%>
</body>
</html>
