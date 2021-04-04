<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.hebeu.entity.User" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function confimDelete(id) {
	var flag=window.confirm("您确认要删除吗？");
	if(flag){
    window.location.href="../myServlet/DeleteUserServlet?qian_id="+id;
	}
}

function confimUpdate(id){
	window.location.href="../myServlet/PreUpdateUserServlet?qian_id="+id;
}

</script>
</head>
<body>
	<%--显示全部用户的页面 --%>
	<table>
		<tr>
			<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
			<td height="20" width="9%" align="center" bgcolor="#EEEEEE">学生编号</td>
			<td width="9%" align="center" bgcolor="#EEEEEE">学生姓名</td>
			<td width="9%" align="center" bgcolor="#EEEEEE">年龄</td>
			<td width="9%" align="center" bgcolor="#EEEEEE">操&nbsp;&nbsp;作</td>
		</tr>

		<%	@SuppressWarnings("unchecked")//下面使用List<>泛型时会报警告,加上这个使警告消除
			List<User> listUser = (List<User>) request.getAttribute("listUserAll_servlet");
			if (listUser != null) {
				for (int i = 0; i < listUser.size(); i++) {
					User user = listUser.get(i);
					System.out.println("i等于"+i);
		%>
		<tr>
			<td bgcolor="#FFFFFF" align="center"><input type="checkbox"
				name="delid" /></td>
			<td width="6%" align="center" bgcolor="#EEEEEE"><%=user.getNum()%></td>
			<td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%=user.getName()%></td>
			<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getAge()%></td>
			<td bgcolor="#FFFFFF" align="center">
			<%--<a href="../myServlet/PreUpdateUserServlet?qian_id=<%= user.getNum() %>">修改</a>--%>
			<input type="button" value="修改" onclick="confimUpdate(<%=user.getNum() %>)"/>
			<input type="button" value="删除" onclick="confimDelete(<%=user.getNum()%>)"/>
			<%-- <input type="button" value="修改" onclick="../myServlet/PreUpdateUserServlet?qian_id=<%=user.getNum()%>"/>--%>
		</tr>

		<%
			}
			} else {
		%>
	</table>
	<%
		out.println("没有用户");//放到这儿是为了使这行字显示到表的下面
		}
	%>
	
</body>
</html>