<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/3
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定</title>
</head>
<body>
    <h2 style="text-align: center; font-weight: bolder;">这个例子用来理解SpringMVC的参数绑定</h2>
    <hr>

    <h3 style="text-align: center;">普通类型的参数绑定测试</h3>
    <a href="params/testParams?username=root&password=0727316052">请求参数绑定测试</a>
    <hr>

    <h3 style="text-align: center;">JavaBean类型的参数绑定</h3>
    <%--将数据封装到Account类，该类含有若干个基本数据类型--%>
    <form action="params/save_account">
        <%--注意：name属性值要与封装的JavaBean对象内的属性名一致--%>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>

    <h3 style="text-align: center;">JavaBean-JavaBean类型的参数绑定测试</h3>
    <%--将数据封装到Account类，该类内含一个JavaBean对象--%>
    <form action="params/save_account" method="post">
        <%--注意：name属性值要与封装的JavaBean对象内的属性名一致--%>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="u.uname"><br>
        用户年龄：<input type="text" name="u.age"><br>
        <input type="submit" value="提交">
    </form>
    <hr>

    <h3 style="text-align: center;">JavaBean-集合类型的参数绑定设置</h3>
    <%--吧数据封装到Account类，该类内含List集合和Map集合--%>
    <form action="params/save_account" method="post">
        <%--注意：name属性值要与封装的JavaBean对象内的属性名一致--%>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        金额：<input type="text" name="money"><br>

        <%--这一部分数据封装到List集合--%>
        用户姓名：<input type="text" name="userList[0].uname"><br>
        用户年龄：<input type="text" name="userList[0].age"><br>

        <%--这部分数据封装到Map集合--%>
        用户姓名：<input type="text" name="userMap['mapKey'].uname"><br>
        用户年龄：<input type="text" name="userMap['mapKey'].age"><br>

        <input type="submit">
    </form>
    <hr>

    <h3 style="text-align: center;">JavaBean-集合类型的参数绑定设置</h3>
    <%--用于把数据封装到User类，该类中有一个Date类型的数据，以此引出自定义类型转换器的定义和使用--%>
    <form action="params/save_user">
        姓名：<input type="text" name="uname"><br>
        注册日期：<input type="text" name="registerDate"><br>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
    <hr>

    <h3>验证原生的Servlet某些API</h3>
    <a href="params/servlet">点我</a>


    <br><br><br><br><br><br>
</body>
</html>
