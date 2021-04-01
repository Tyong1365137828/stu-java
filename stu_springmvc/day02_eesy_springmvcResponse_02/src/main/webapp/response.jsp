<%--
  Created by IntelliJ IDEA.
  User: 13651
  Date: 2021/3/4
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应测试页面</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#sendBtn").click(function () {
                // alert("按钮被点击了！！！")
                // 发送Ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url: "user/test_ajax", // 设置请求的URL
                    type:"POST", // 请求方式，默认为 "GET"，注意：其他HTTP请求方式，如PUT、DELETE也可以使用，但仅部分浏览器支持
                    contentType: "application/json;charset=UTF-8", // 发送信息至服务器时内容编码类型,默认：application/x-www-form-urlencoded
                    data: '{"username":"136513", "password":"072731", "age": 21}', // 发送至服务器的数据
                    dataType: "json", // 预期服务器返回的数据类型
                    success: function (data) { // 请求成功后的回调函数
                        // data服务端响应的json数据，进行解析
                        alert(data);
                        alert(data.toString());
                        alert("用户名：" + data.username + "; 密码：" + data.password + "; 年龄：" + data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <a href="user/return_string">返回值为String</a><br>
    <hr>

    <a href="user/return_void">返回值为void</a><br>
    <hr>

    <a href="user/return_modelAndView">返回值为ModelAndView(SpringMVC为我们提供的一个对象，该对象可以作为控制器方法的返回值)类型</a><br>
    <hr>

    <a href="user/test_keyWord_to_forward_redirect">通过关键字实现转发或者重定向</a><br>
    <hr>

    <button id="sendBtn">点击发送ajax请求</button><br>
    <hr>

</body>
</html>
