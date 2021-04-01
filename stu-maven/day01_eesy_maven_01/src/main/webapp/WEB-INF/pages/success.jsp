<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/7
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>成果页面</title>
</head>
<body>
<form>
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td> ${item.name } </td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td> ${item.price } </td>
        </tr>
        <tr>
            <td>生成日期</td>
            <td> <fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>${item.detail} </td>
        </tr>
    </table>
</form>
${item}
</body>
</html>
