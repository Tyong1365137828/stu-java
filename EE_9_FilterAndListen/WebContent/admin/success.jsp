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
 <a href="myServlet/Exit">退出登录</a><br>
 
 
 你的SessionId是:<%=session.getId() %><br>
 
 
 <%-- 你是访问当前网站的第<%=application.getAttribute("login_count") %>个用户 --%>
 <%--或者使用 --%><%-- >你是访问当前网站的第${login_count }个用户 --%
 <%--或者使用 --%>你是访问当前网站的第${applicationScope.login_count }个用户<br><%--这个与监听器无关 --%>
 
 
 当前在线人数为:${onlinecount }人<%-- 这个与监听器有关 --%>
</body>
</html>