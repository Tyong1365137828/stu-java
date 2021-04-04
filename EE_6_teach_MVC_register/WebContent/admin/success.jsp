<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.hebeu.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  登录成功！欢迎您：<%=session.getAttribute("user") %>  --%>
 登录成功！欢迎您：
 <%
 User user=(User)session.getAttribute("user");
 out.println(user.getUsername());
 %>
 <a href="../servlet/LogoutServlet">注销</a><br>
 sessionID:<%=session.getId() %><br>
 session的默认最大间隔时间：<%=session.getMaxInactiveInterval() %>
 <%session.setMaxInactiveInterval(10); %>
 <hr>
     当前网站访问总人数：<%=application.getAttribute("count") %>
 <hr>
</body>
</html>