<%@page import="edu.hebeu.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%-- 
    登录成功，欢迎您！<%=session.getAttribute("user") %>
 --%>
 登录成功，欢迎您！
 <%
User user=(User)session.getAttribute("user"); 
out.print(user.getUsename());
out.print(",");
out.print(user.getPassword());
%>
<br>
${user.password }<br>
${user.usename }<br>
<a href="http://127.0.0.1:8080/EE_4_teach_servlet_dao_2020_04/servlet/UserExitServlet">注销用户（绝对路径）</a>
<a href="/EE_4_teach_servlet_dao_2020_04/servlet/UserExitServlet1">注销（根路径）</a>
<a href="servlet/UserExitServlet1">注销（基准路径）</a>
</body>
<!-- 跳到show.jsp -->
<a href="http://127.0.0.1:8080/_servlet_dao_2020_04/admin4_path/show.jsp">show.jsp</a><br>
<a href="/EE_4_teach_servlet_dao_2020_04/admin4_path/show.jsp">show.jsp</a><br>
<a href="admin4_path/show.jsp">show.jsp</a><br>
</html>