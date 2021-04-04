<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.hebeu.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
		<table border="1" width="80%" align="center">
			<tr align="center" bgcolor="#EEEEEE">
				<td width="2%">选择</td>
				<td height="20" width="3%">用户编号</td>
				<td width="5%">用户姓名</td>
				<td width="2%">年龄</td>
				<td width="3%">分数</td>
				<td width="4%">入学时间</td>
				<td width="6%">业余爱好</td>
				<td width="10%">操&nbsp;&nbsp;&nbsp;作</td>
			</tr>
			<c:forEach items="${pageBean.list }" var="user" varStatus="vs">
			<tr>		
					<td><input type="checkbox" name="delid" /></td>
					<td>${user.userid }</td>
					<td height="20">${user.username }</td>
					<td>${user['age'] }</td>
					<td>${user["score"] }</td>
					<td>${user.entrydate }</td>
					<td>${user.hobby }</td>
					<td><a href="servlet/DeleteUserServlet?userid=${user.userid }">删除</a>&nbsp;|&nbsp;
						<a href="javascript:confimDelete(${user.userid })">删除2</a>&nbsp;|&nbsp;
						<a href="javascript:void(0)"
						onclick="confimDelete(${user.userid })">删除3</a>&nbsp;|&nbsp; <input
						type="button" value="删除 4" onclick="confimDelete(${user.userid })" />
						<a href="#">修改</a> <a
						href="servlet/PreUpdataUserServlet?userid=${user.userid }">更新</a>
					</td>
					</tr>

				</c:forEach>

		</table>
	
</body>
</html>