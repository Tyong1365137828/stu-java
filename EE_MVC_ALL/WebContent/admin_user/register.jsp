<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<script type="text/javascript">
	function checkId(){
		var id = document.getElementById("qian_id").value;
		if(id==""){
			document.getElementById("iderror").innerHTML="id不能为空";
			return false;
		}else{
			document.getElementById("iderror").innerHTML="";	
			return true;
		}
	}
	function checkPassword(){
		var passwd =document.getElementById("qian_pwd").value;
		if(passwd==""){
			document.getElementById("pwderror").innerHTML="密码不能为空";
			return false;
		}else{
			document.getElementById("pwderror").innerHTML="";
			return true;
		}
	}
	function checkRePassword() {
		if (this.form_register.hou_pwd.value != this.form_register.hou_repwd.value) {
			document.getElementById("repassworderror").innerHTML = "密码不一致！";
			return false;
		} else
			document.getElementById("repassworderror").innerHTML = "";
			return true;
	}
	function checkRegisterDate(){
		var regsiterDate = document.getElementById("qian_registerdate").value;
		if(regsiterDate==""){
			document.getElementById("registerDateerror").innerHTML="注册日期不可空";
			return false;
		}else{
			document.getElementById("registerDateerror").innerHTML="";
			return true;
		}
	}
	function checkForm(){
		var flag1 = checkId();
		var flag2 = checkPassword();
		var flag3 = checkRePassword();
		var flag4 = checkRegisterDate();
		if(flag1 && flag2 && flag3 && flag4){
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<h3>用户注册</h3>
	<%
		String error1 = (String) request.getAttribute("register_error");
		if (error1 != null) {
			out.println(error1);
		}		
	%>

	<form name="form_register" action="../myServlet/UserServlet?method=Register" method="post" onsubmit="return checkForm()">
		<table>
			<tr>
				<td>用户ID</td>
				<td><input type="text" name="hou_id" id="qian_id" onblur="checkId()"> <span id="iderror"></span> </td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="hou_name" id="qian_name"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="hou_pwd" id="qian_pwd" onblur="checkPassword()"> <span id="pwderror"></span> </td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="hou_repwd" id="qian_repwd"
					onblur="checkRePassword()"> <span id="repassworderror"></span>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="hou_age" ></td>
			</tr>
			<tr>
				<td>分数</td>
				<td><input type="text" name="hou_score"></td>
			</tr>
			<tr>
				<td>注册时间</td>
				<td><input type="text" name="hou_registerdate" id="qian_registerdate" onblur="checkRegisterDate()" ><span id="registerDateerror"></span></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="checkbox" name="hou_hobby" value="足球">足球
					<input type="checkbox" name="hou_hobby" value="音乐">音乐 
					<input type="checkbox" name="hou_hobby" value="游泳">游泳</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册">
				<input	type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>