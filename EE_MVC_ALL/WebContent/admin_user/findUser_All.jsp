<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.hebeu.entity.User" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部显示</title>
<script type="text/javascript">
function confimDelete(id) {
	var flag=window.confirm("您确认要删除吗？");
	if(flag){
    window.location.href="../myServlet/UserServlet?method=Delete&qian_id="+id;
	}
}

function confimUpdate(id){
	window.location.href="../myServlet/PreUpdateUserServlet?qian_id="+id;
}
function checkName() {
	var username = document.getElementById("qian_name").value;
	if (username == "") {
		document.getElementById("name_error").innerHTML = "姓名输入不能为空！！！";
		return false;
	}
	return true;
}

function checkAge() {
	var userage = document.getElementById("qian_age").value;
	if (userage == "") {
		document.getElementById("age_error").innerHTML = "年龄输入不能为空！！！";
		return false;
	}
	return true;
}

function checkForm(){
	var flag1 = checkName();
	var flag2 = checkAge();
	if(flag1||flag2){
		return true
	}
	return false;
}
</script>
</head>
<body>
	<%--显示全部用户的页面 --%>
	<form action="../myServlet/UserServlet?method=FindMul"
		onsubmit="return checkForm()" method="post">
		
		<table>

			<tr>
			
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入名字：<input type="text" name="hou_name" size="12"
					id="qian_name" onblur="checkName()" value="${name }"> <span
					id="name_error"> <%
 	String mesg1 = (String) pageContext.getAttribute("name_error");
 	if (mesg1 != null) {
 		out.println(mesg1);
 	}
 %>
				</span>
				</td>
				<td>请输入年龄>=<input type="text" name="hou_age" size="12"
					id="qian_age" onblur="checkAge()" value="${age }"> <span
					id="age_error"> <%
 	String mesg2 = (String) pageContext.getAttribute("age_error");
 	if (mesg2 != null) {
 		out.println(mesg2);
 	}
 %>
				</span> <input name="submit2" type="submit" value="多条件查询">
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
				@SuppressWarnings("unchecked") //下面使用List<>泛型时会报警告,加上这个使警告消除
				List<User> listUser = (List<User>) request.getAttribute("listUserMul_servlet");
				if (listUser != null) {
					for (int i = 0; i < listUser.size(); i++) {
						User user = listUser.get(i);
						System.out.println("i等于" + i);
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
					<%--<a href="../myServlet/PreUpdateUserServlet?qian_id=<%= user.getNum() %>">修改</a>--%>
					<input type="button" value="修改"
					onclick="confimUpdate(<%=user.getNum()%>)" /> <input type="button"
					value="删除" onclick="confimDelete(<%=user.getNum()%>)" /> <%-- <input type="button" value="修改" onclick="../myServlet/PreUpdateUserServlet?qian_id=<%=user.getNum()%>"/>--%>
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
	</form>
</body>
</html>