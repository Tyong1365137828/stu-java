<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
add.jsp<br>
<%-- 
    当时用户是：<%=request.getAttribute("username") %><br>
    --%>
<!-- 跳回到success.jsp -->
<form action="/_servlet_dao_2020_04/admin4_path/success.jsp">
    <input type="submit" value="success.jsp">
</form>
</body>
</html>