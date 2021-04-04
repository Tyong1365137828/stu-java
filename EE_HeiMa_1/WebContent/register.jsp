<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- 如果提交的jsp文件与本文件同级，则action属性值不用加前缀"/" -->
	<form action="show.jsp">
		用户名：<input type="text" name="id_name" /><br>
		年龄：	<input type="text" name="age_name" ><br>
		爱好:<br/>
		<input type="checkbox" name="hobbies_name" value="足球"/>足球<br/>
		<input type="checkbox" name="hobbies_name" value="篮球"/>篮球<br/>
		<input type="checkbox" name="hobbies_name" value="乒乓球"/>乒乓球<br/>
		<input type="checkbox" name="hobbies_name" value="跑步"/>跑步<br/>
		
		<!-- 进行提交 -->
		<input type="submit" value="确认">
	</form>
</body>
</html>