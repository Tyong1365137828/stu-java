<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.hebeu.entity.Administrator" %>
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
<title>管理员登录成功页面</title>
</head>
<body>
"${sion_adm.num}
"管理员登录成功！<br>欢迎您:"
${sion_adm.name }
"管理员<br>

<a href="myServlet/UserServlet?method=FindMul">查看全部用户信息</a><br>
<a href="myServlet/UserServlet?method=FindMulPage">分页查看全部用户信息</a><br>
<a href="admin_user/findUserByNum_single.jsp">由用户Num查询用户信息</a>

<a href="JianKong">用户连接池查看</a><br>
<a href="myServlet/AdmServlet?method=Exit">退出</a>
</body>
</html>