<%@ page language="java" import="edu.hebeu.entity.User" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户更新</title>
<script type="text/javascript">
	function checkPassword() {
		if (this.form1.password.value != this.form1.repwd.value) {
			document.getElementById("passworderror").innerHTML = "密码不一致！";
			return false;
		} else {
			document.getElementById("passworderror").innerHTML = "";
		}
		return;
	}
</script>
</head>
<body>
	<!-- <h3>用户更新</h3> -->
	<div style="font-weight: bold;font-size: 18px;" align="center" width="30%" >用户更新
	<a href="../index.jsp" style="font-weight: bold;font-size: 18px;">返回</a>
	</div><br>
	<div height="100"></div>
	
   <div align="center" width="30%">
	<form name="form1" action="../servlet/UpdateUserServlet" method="post">
		<table>
			<tr>
				<td>用户ID</td>
				<%-- 
				<td><input type="text" readonly="readonly" name="userid" value="<%=user.getUserid() %>"></td>
			    --%>
			    <td><input type="hidden" name="userid" value="${requestScope.user.userid }"></span></td>
			    
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"  value="${requestScope.user.username }">${error }</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="${requestScope.user.password }"></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repwd" value="${requestScope.user.password }%>"
					onblur="checkPassword()"> <span id="passworderror"></span>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" value="${requestScope.user.age }"></td>
			</tr>
			<tr>
				<td>分数</td>
				<td><input type="text" name="score" value="${requestScope.user.score }"></td>
			</tr>
			<tr>
				<td>入学时间</td>
				<td><input type="text" name="entrydate" value="${requestScope.user.entrydate }"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="checkbox" name="hobby" value="sports">体育
					<input type="checkbox" name="hobby" value="music">音乐 
					<input type="checkbox" name="hobby" value="swimming">游泳</td>
			</tr>
			<tr>
			    <td valign="top">爱好描述：</td>
			    <td colspan="3">
			    <textarea name="remark">${requestScope.user.hobby }</textarea>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新">
				<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<input type="button" value="返回" onclick="history.back()">
	</div>
</body>
</html>