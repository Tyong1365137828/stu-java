<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 这个是定义全局变量, 但是作为声明，相当于类里面，不能有单独的语句，只能写方法--%>
<%!
	int count2 = 0;//作为全局变量
	public void countUser(){
		count2++;
	}
%>

<%-- 小脚本，这个作为了局部变量 --%>
<%
	int count1 = 0;//作为局部变量
	count1++;
	countUser();//调用上述的方法
%>

你是第<%=count1%>个访问的人(count1)!<br>
你是第<%=count2%>个访问的人(count2)!<br>
</body>
</html>