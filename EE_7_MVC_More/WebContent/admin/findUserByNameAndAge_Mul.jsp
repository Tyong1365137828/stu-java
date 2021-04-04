<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="edu.hebeu.entity.User"	pageEncoding="UTF-8"%>
  <%@page import="java.util.*" %><%--List的引用包 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>按name和age多条件查询</title>

<script type="text/javascript">
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
	<form action="../myServlet/FindUserDimByNameAndAgeServlet?method=FindUserMul" onsubmit="return checkForm()" method="post">
		<table>
			<tr>
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入名字：<input type="text" name="hou_name" size="12"
					id="qian_name" onblur="checkName()"> <span id="name_error">
						<%
							String mesg1 = (String) pageContext.getAttribute("name_error");
							if (mesg1 != null) {
								out.println(mesg1);
							}
						%>
				</span>
				</td>
				<td>请输入年龄>=<input type="text" name="hou_age" size="12"
				id="qian_age" onblur="checkAge()"> <span id="age_error">
						<%
							String mesg2 = (String) pageContext.getAttribute("age_error");
							if (mesg2 != null) {
								out.println(mesg2);
							}
						%>
				</span>	 <input name="submit2" type="submit" value="查询">
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE">编号</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">姓名</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">年龄</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">操&nbsp;&nbsp;&nbsp;作</td>
			</tr>
			<%	@SuppressWarnings("unchecked")//下面使用List<>泛型时会报警告,加上这个使警告消除
				List<User> listUser = (List<User>) request.getAttribute("listUserMul_servlet");
				if (listUser != null) {//不能使用List<>的查空方式
					for (int i = 0; i < listUser.size(); i++) {
						User user = listUser.get(i);
						System.out.println("i等于" + i);
			%>
			<tr>
				<td bgcolor="#FFFFFF" align="center"><input type="checkbox"
					name="delid" /></td>
				<td width="6%" align="center" bgcolor="#EEEEEE"><%=user.getNum()%></td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%=user.getName()%></td>
				<td width="9%" align="center" bgcolor="#EEEEEE"><%=user.getAge()%></td>
			</tr>
			<%
				}
				} else {
					System.out.println("JSP空了");
			%>
		</table>
	</form>
	${listUserMul_null_servlet}<br>
	<%
		}
	%>
</body>
</html>