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
		request.setAttribute("testRequest", "取到request值了！！！");//当前页面能取到，跳转后也能取到
		request.getRequestDispatcher("requestTest.jsp").forward(request,response);//转发，对客户端来说是同一请求，所以能娶到值
		//response.sendRedirect("requestTest.jsp");//重定向，对客户端来说不是同一请求，所以娶不到值
	%>
	<%=request.getAttribute("testRequest")%>
</body>
</html>