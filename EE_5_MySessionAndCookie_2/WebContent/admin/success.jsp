<%@page import="edu.hebeu.po.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
 
 <%-- 登录成功，欢迎您！<%=request.getAttribute("hid") %><br><!-- 这个hid是获取不到的，要用session技术才能行 --> --%>
 <%-- 登录成功，欢迎您！<%=session.getAttribute("sionstu") %><!-- session取值 --> --%>

<%
//session取对象的一部分值
Student student = (Student)session.getAttribute("sionstu");
out.print("Id号为'"+student.getId()+"'的用户,<br>您的密码是'");//输出id号
out.print(student.getPassword()+"',<br>");//输出密码
%>欢迎您登录此测试页面!!!
<a href="myServlet/Exit">点击注销</a>

<%--
<br>
<!-- jsp取session的特有方式 ，EL表达式-->
${sionstu.id }<br><!-- 注意格式是session的名字.与session关联的po包里的属性 -->
${sionstu.password }<br>
--%>
</body>
</html>