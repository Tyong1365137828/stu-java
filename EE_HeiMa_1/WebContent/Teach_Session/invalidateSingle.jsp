<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.removeAttribute("setSession_upwd");//删除某一session，如删除setSession_upwd的session
	
	//response.sendRedirect("welcom.jsp");//重定向
	request.getRequestDispatcher("welcom.jsp").forward(request,response);//转发
	%>
</body>
</html>