<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.hebeu.entity.User" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkName() {
		var username = document.getElementById("qian_name").value;
		if (username == "") {
			document.getElementById("name_error").innerHTML = "输入不能为空！！！";
			return false;
		}
		return true;
	}
	
	function checkForm(){
		var flag = checkName();
		if(flag){
			return true
		}
		return false;
	}
</script>

</head>
<body>
	<form action="../myServlet/FindUserDimByNameServlet" onsubmit="return checkForm()">
		<table>
			<tr>
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入名字：<input type="text" name="hou_name" size="12"
					id="qian_name" onblur="checkName()"> <span id="name_error">
						<%
							String mesg = (String) pageContext.getAttribute("name_error");
							if (mesg != null) {
								out.println(mesg);
							}
						%>
				</span> <input name="submit1" type="submit" value="查询(单个)">
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
				List<User> listUser = (List<User>) request.getAttribute("listUserDim_servlet");
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
	${listUserDim_null_servlet}<br>
	<%
		}
	%>
</body>
</html>