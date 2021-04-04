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
		application.setAttribute("testApplication", "取到application值了！！！");//当前页面能取到，跳转后也能取到
		//request.getRequestDispatcher("applicationTest.jsp").forward(request,response);//转发，整个项目有效，能娶到值
		response.sendRedirect("applicationTest.jsp");//重定向，整个项目有效，能娶到值
	%>
	<%=session.getAttribute("testApplication")%>
</body>
</html>