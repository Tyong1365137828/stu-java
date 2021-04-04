<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 如果提交的jsp文件与本文件同级，则action属性值不用加前缀"/" -->
	<form action="doLogin.jsp" method="post"> <%--默认为get提交(此提交会在浏览器地址栏泄露用户的账号，密码等信息);最好使用post提交 --%>
	用户名:<input type="text" name="username" id="uname"/><br> <%-- name相当于组件的名字；id是为js使用，如前台的验证，表单不为空等--%>
	密码:<input type="text" name="userpasswd" id="upasswd"/><br>
	<input type="submit" value="登录"><%--submit类型的按钮，即提交 --%>
	</form>
</body>
</html>