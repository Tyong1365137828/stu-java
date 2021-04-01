<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/2
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%--isELIgnored="false"：表示不忽略EL表达式--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>入门成功</title>
</head>
<body>
    <h3>入门成果！！！</h3>
    <hr>

    <span style="font-weight: bold; font-size: 26px">request域对象信息：</span>
    ${requestScope}
    <hr>

    <span style="font-weight: bold; font-size: 28px">获取request域中的指定key=value对信息：</span>
    ${requestScope.message}
    <hr>

    <span style="font-weight: bold; font-size: 26px">session域对象信息：</span>
    ${sessionScope}
    <hr>

</body>
</html>
