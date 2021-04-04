<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
	<!-- <h3>用户注册</h3> -->
	<div style="font-weight: bold;font-size: 18px;" align="center" width="30%" >用户注册
	<a href="../index.jsp" style="font-weight: bold;font-size: 18px;">返回</a>
	</div><br>
	<div height="100"></div>
	<%
		String error1 = (String) request.getAttribute("error");
		if (error1 != null) {
			out.println(error1);
		}
		
		String userid=request.getParameter("userid");
		if(userid==null){
			userid="";
		}
		String username=request.getParameter("username");
		if(username==null){
			username="";
		}
		
		String age=request.getParameter("age");
		if(age==null){
			age="";
		}
	%>
   <div align="center" width="30%">
	<form name="form1" action="../servlet/UserServlet1" method="post">
		<table>
			<tr>
				<td>用户ID</td>
				<td><input type="text" name="userid" value="<%=userid %>"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"  value="<%=username %>"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repwd"
					onblur="checkPassword()"> <span id="passworderror"></span>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" value="<%=age %>"></td>
			</tr>
			<tr>
				<td>分数</td>
				<td><input type="text" name="score"></td>
			</tr>
			<tr>
				<td>入学时间</td>
				<td><input type="text" name="entrydate"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="checkbox" name="hobby" value="sports">体育
					<input type="checkbox" name="hobby" value="music">音乐 <input
					type="checkbox" name="hobby" value="swimming">游泳</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="注册"> 
				<input type="reset" value="重置">
				<input type="hidden" name="method" value="register">
				</td>				
			</tr>
		</table>
	</form>
	</div>
</body>
</html>