<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String XuNiPath=""; %>
<%="当前项目的虚拟路径是'"+application.getContextPath()+"'<br/>" %>
<%
	XuNiPath = application.getContextPath();
%>

<%="当前项目虚拟路径'"+XuNiPath+"'的绝对路径是'"+application.getRealPath(XuNiPath)+"'<br/>" %>
</body>
</html>