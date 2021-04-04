<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
	<%--绝对路径 --%>
	<a href="http://127.0.0.1:8080/EE_7_MVC_More/myServlet/findUserAllServlet">全部用户显示</a>
	<%--根路径 --%>
	<%-- <a href="/EE_7_MVC_Check/myServlet/FindUserAllPageServlet">全部用户分页显示</a> --%>
	<%--相对路径1,相对于自身 --%>
	<a href="./myServlet/findUserAllServlet">全部用户显示</a>
	<%--基准路径(相对路径2,相对于基准路径basePath) --%>
	<a href="myServlet/FindUserAllPageServlet">全部用户分页显示</a>
	<br>
	<a href="./admin/findUserByNum_single.jsp">由用户Id查询用户</a>
	<br>
	<a href="./admin/findUserByName_Dim.jsp">由用户名字模糊查找用户</a>
	<br>
	<a href="./admin/findUserByNameAndAge_Mul.jsp">由用户名字和年龄查找用户</a>
	<br>
	<a href="./admin/findUserPage_Mul.jsp">由用户名字和年龄分页查找用户</a>
</body>
</html>