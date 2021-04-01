<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/5
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件首页</title>
</head>
<body>

    <%--使用传统方式实现文件的上传--%>
    <h2>传统方式上传文件</h2>
    <form action="user/file_upload1" method="post" enctype="multipart/form-data">
        请选择上传的文件：<input type="file" name="upload"><br>
        <input type="submit" value="确认上传">
    </form>
    <br>
    <hr>

    <h2>SpringMVC方式实现文件上传</h2>
    <form action="user/file_upload2" method="post" enctype="multipart/form-data">
        请选择上传的文件：<input type="file" name="upload"><br>
        <input type="submit" value="确认上传">
    </form>
    <br>
    <hr>

    <h2>跨服务器上传文件</h2>
    <form action="user/file_upload3" method="post" enctype="multipart/form-data">
        请选择上传的文件：<input type="file" name="upload">
        <input type="submit" value="确认上传">
    </form>

</body>
</html>
