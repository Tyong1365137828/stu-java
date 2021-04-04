<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//服务端
//1589132用户
Cookie cookie1 = new Cookie("user1","158913");
Cookie cookie2 = new Cookie("u1_pwd","072731");

//1783195用户
Cookie cookie3 = new Cookie("user2","1783195");
Cookie cookie4 = new Cookie("u2_pwd","tangyong");

//准备Cooie
response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);
response.addCookie(cookie4);

//页面跳转,跳转到客户端(转发、重定向均可),把所有的Cookie带去
response.sendRedirect("request.jsp");

%>
</body>
</html>