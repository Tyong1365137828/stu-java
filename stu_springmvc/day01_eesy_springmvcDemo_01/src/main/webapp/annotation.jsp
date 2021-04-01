<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/3
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用的注解测试</title>
</head>
<body>
    <h1 style="font-weight: bolder;">这个例子演示测试常用的注解</h1>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@RequestParams注解</h2>
    <a href="annotation/test_request_params?name=test&pwd=072731">@RequestParams注解测试</a>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@RequestBody注解</h2>
    <form action="annotation/test_request_body" method="post">
        姓名：<input type="text" name="username"><br>
        年龄：<input type="text" name="age"><br>
        地址：<input type="text" name="address"><br>
        <input type="submit" value="提交">
    </form>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@PathVariable注解</h2>
    <a href="annotation/test_path_variable/11">@PathVariable注解的测试</a>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@RequestHeader注解</h2>
    <a href="annotation/test_request_header">@RequestHeader注解的测试</a>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@CookieValue注解</h2>
    <a href="annotation/test_cookie_value">@CookieValue注解的测试</a>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@ModelAttribute注解</h2>
    <%--用来测试@ModelAttribute注解的使用，当提交的POJO对象数据不完整时，使用这个注解自动填充某些信息--%>
    <form action="annotation/test_model_attribute" method="post">
        姓名：<input type="text" name="username">
        年龄：<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
    <hr>

    <h2 style="text-align: center; font-weight: bold;">@SessionAttributes注解的引出</h2>
    <a href="annotation/test_session_attribute" style="border-bottom: black dashed 1px">将指定的key=value对先加入的request域，在通过@SessionAttributes注解将request域中指定的key=value对加入到session域中</a>
    <br>
    <a href="annotation/test_get_session" style="border-bottom: black dashed 1px">通过session域中的key获取session域中指定的key=value对信息</a>
    <br>
    <a href="annotation/test_delete_session" style="border-bottom: black dashed 1px">清除session域中的信息</a>
    <hr>

    <br><br><br><br><br><br><br><br><br><br>
</body>
</html>
