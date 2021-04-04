<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><%--展示Session的销毁 --%>
<%
	session.invalidate();//删除当前对象的全部session
	
	//response.sendRedirect("welcom.jsp");//转发
	request.getRequestDispatcher("welcom.jsp").forward(request,response);//重定向
%>

</body>
</html>