<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/4
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>操作成功页面</title>
</head>
<body>
    <h1>执行成功！！！</h1>
    <%--${requestScope.userKey}--%>
    ${userKey}<br>
    ${userKey.username}<br>
    ${userKey.password}<br>
    ${userKey.age}<br>
</body>
</html>
