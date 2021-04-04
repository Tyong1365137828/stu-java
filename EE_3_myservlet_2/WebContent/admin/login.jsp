<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 前台，即jsp等访问资源的几种方式
1、表单(即<form action="..." method="post">)，提交方式有get和怕post两种提交方式选择，默认是get

2、超链接(即<a href="...">这是一个超链接</a>)，只有get提交方式

3、url地址
 -->
 
	<h3>登录界面</h3>
	<%=request.getAttribute("login的test") %>
	
	<!-- 表单 -->
	<form action="../servlet/DoLogin" method="post"> <%--action(jsp与servlet之间的挂钩)是点击登录按钮后跳转到哪个地方，这里表示的路径是需要执行的servlet文件的urlPatterns(
	即web.xml文件的<url-pattern>urlPatterns的内容</url-pattern>或者@WebServlet(name="",urlPatterns={"路径1","路径2"},loadOnStartup=0/1/2/3/4/5));method默认为get提交(此提交会在浏览器地址栏泄露用户的账号，密码等信息);最好使用post提交 --%>
	用户名:<input type="text" name="username" id="uname"/><br> <%-- name相当于组件的名字，用于后台的使用；id是用于前台的使用，如前台的验证，表单不为空等--%>
	密码:<input type="text" name="userpasswd" id="upasswd"/><br>
	<input type="submit" value="登录"><%--按钮 --%>
	</form>
	
	<!-- 超链接 -->
	<a href="servlet/DoLogin">这是一个超链接</a>
</body>
</html>