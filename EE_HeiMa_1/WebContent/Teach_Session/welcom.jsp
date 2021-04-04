<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎您：
<%
	String getSession_unum = (String)session.getAttribute("setSession_unum");
	String getSession_upwd = (String)session.getAttribute("setSession_upwd");
	//如果没有登录，直接通过地址栏到此页面
	if(getSession_unum==null){
		response.sendRedirect("login.jsp");
	}else{
		out.print(getSession_unum+"<br>");
		out.print(getSession_upwd+"<br>");
		
	}
	//获取JSESSIONID
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("JSESSIONID")){
				System.out.println("JSESSIONID等于:"+cookie.getValue());
			}
		}
%>

<a href="invalidateAll.jsp">注销全部信息</a>
<a href="invalidateSingle.jsp">注销密码信息</a>
</body>
</html>