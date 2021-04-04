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
		session.setAttribute("testSession", "取到session值了！！！");//当前页面能取到，跳转后也能取到
		//request.getRequestDispatcher("sessionTest.jsp").forward(request,response);//转发，同一次会话，能娶到值
		response.sendRedirect("sessionTest.jsp");//重定向，同一次会话，能娶到值
	%>
	<%=session.getAttribute("testSession")%>
</body>
</html>