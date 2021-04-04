<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.hebeu.entity.User" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精确查询用户信息</title>
<script type="text/javascript">
function confimDelete(id) {
	var flag=window.confirm("您确认要删除吗？");
	if(flag){
    window.location.href="../myServlet/DeleteUserServlet?qian_id="+id;
	}
}
</script>

</head>
<body>
	<%--按照id号精确查询，代表精确查询 --%>
	<form action="../myServlet/UserServlet?method=FindSingle"
		method="post">
		<table>
			<tr>
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入账号：<input type="text" name="hou_num" size="12"
					id="qian_num"> <input name="submit1" type="submit"
					value="查询(单个)">
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE">学生编号</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">学生姓名</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">学生密码</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">年龄</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">分数</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">注册日期</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">爱好</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">操&nbsp;&nbsp;作</td>
			</tr>

			<%
				String userid = "";
				String username = "";
				String age1 = "";
				User user = (User) request.getAttribute("userSingle_servlet");
				if (user != null) {
					userid = user.getNum();
					//out.print(userid);
					username = user.getName();
					int age = user.getAge();
					age1 = String.valueOf(age);
			%>
			<tr>
				<td bgcolor="#FFFFFF" align="center"><input type="checkbox"
					name="delid" /></td>
				<td width="6%" align="center" bgcolor="#EEEEEE"><%=user.getNum()%></td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%=user.getName()%></td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%=user.getPassword()%></td>
				<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getAge()%></td>
				<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getScore()%></td>
				<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getRegisterdate()%></td>
				<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getHobbies()%></td>
				<td bgcolor="#FFFFFF" align="center">
					<%-- <a href="javascript:confimDelete(<%=userid%>)">删除2</a>&nbsp;|&nbsp;--%>
					<%-- <a href="javascript:void(0)" onclick="confimDelete(<%=userid%>)">删除3</a>&nbsp;|&nbsp;--%>
					<input type="button" value="删除 4"
					onclick="confimDelete(<%=userid%>)" /> <a href="#">修改</a> <!-- 一个空链接，有小手形状 -->
				</td>
			</tr>
			<%
				} else {
			%>
		</table>
	</form>
	${userSingle_null_servlet}
	<br>
	<%
		}
	%>
</body>
</html>