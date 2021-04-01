<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/6
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM首页</title>
</head>
<body>
    <form action="account/add" method="post">
        <input type="text" placeholder="请输入要添加的用户姓名..." name="name">
        <input type="text" placeholder="请输入要添加的用户金额.." name="money">
        <input type="submit" value="确认添加">
    </form>
    <hr>
    <a href="account/findAll">查询全部用户</a><br>
    <hr>
</body>
</html>
