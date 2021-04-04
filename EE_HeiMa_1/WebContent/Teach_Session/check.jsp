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
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("unum");
	String pwd = request.getParameter("upwd");
	if(num.equals("test")&&pwd.equals("666")){//如果等于此，表示输入正确，才能使用session存储信息等步骤
		session.setAttribute("setSession_unum", num);
		session.setAttribute("setSession_upwd", pwd);
		
		System.out.println("SessionId等于:"+session.getId());//输出SessionId，与JSESSIONID比较验证是否相等
		
		//服务端(check.jsp页面)产生Cookie，并发送给客户端(welcom.jsp页面)，以使客户端能够取得JSESSIONID，然后与SessionId作比较
		Cookie cookie1 = new Cookie("setCookie_unum",num);//Cookie赋值
		Cookie cookie2 = new Cookie("setCookie_upwd",pwd);//Cookie赋值
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		session.setMaxInactiveInterval(20);//最大非活动时间位20秒
		
		response.sendRedirect("welcom.jsp");//重定向
		//request.getRequestDispatcher("welcom.jsp").forward(request,response);//转发
	}else{
		response.sendRedirect("login.jsp");
	}

%>
</body>
</html>