<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.hebeu.entity.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 登录成功！欢迎您："
 <%
 User user=(User)session.getAttribute("sion_user");
 out.println(user.getName());
 %>" 用户<br>
 
 你的ID是:"<%=user.getNum() %>"<br>
 你的爱好是:"<%=user.getHobbies() %>"<br>
 <a href="myServlet/UserServlet?method=Exit">退出登录</a><br>
</body>
</html>