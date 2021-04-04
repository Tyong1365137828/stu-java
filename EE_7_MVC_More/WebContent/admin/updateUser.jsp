<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.hebeu.entity.User" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkName(){
	var name = document.getElementById("qian_name").value;
	if(name==""){
		document.getElementById("name_error").innerHTML="名字不可为空";
		return false;
	}else{
		document.getElementById("name_error").innerHTML="";
		return true;
	}
}

function checkPassword(){
	var password = document.getElementById("qian_password").value;
	if(password==""){
		document.getElementById("password_error").innerHTML="密码不可为空";
		return false;
	}else{
		document.getElementById("password_error").innerHTML="";
		return true;
	}
}

function checkAge(){
	var age = document.getElementById("qian_age").value;
	//用来判断输入格式是否符合整数
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if(age==""){
		document.getElementById("age_error").innerHTML="年龄不可为空";
		return false;
	}else if(age.search(re)==-1){//不符合整数类型
		document.getElementById("age_error").innerHTML="年龄格式不规范"
		return false;
	}else{
		document.getElementById("age_error").innerHTML="";
		return true;
	}
}

function checkScore(){
	var score = document.getElementById("qian_score").value;
	if(score==""){
		document.getElementById("score_error").innerHTML="名字不可为空";
		return false;
	}else{
		document.getElementById("score_error").innerHTML="";
		return true;
	}
}

function checkForm(){
	var flag1=checkName();
	var flag2=checkPassword();
	var flag3=checkAge();
	var flag4=checkScore();
	
	if(flag1&flag2&flag3&flag4){
		return true;
	}
	return false;
}

</script>
</head>
<body>
	<%
		User user = (User) request.getAttribute("preUpdate_user");
		application.setAttribute("updateJsp_user", user);
	%>
	<%=user.getNum() %>用户的个人信息
	<form action="../myServlet/UpdateUserServlet" onsubmit="return checkForm()">
		<table>
			<tr>
				<td>账户(不可更改):</td>
				<td><%=user.getNum() %></td>
				<td><input type="hidden" value="账号:"></td>
				<td><input type="hidden" name="hou_num" id="qian_num" value="<%=user.getNum() %>"></td>
				
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="hou_name" id="qian_name" onblur="checkName()" value="<%=user.getName() %>"> <span id="name_error"></span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="hou_passwrod" id="qian_password" onblur="checkPassword()" value="<%=user.getPassword() %>"><span id="password_error"></span></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="hou_age" id="qian_age" onblur="checkAge()" value="<%=user.getAge() %>"> <span id="age_error"></span></td>
			</tr>
			<tr>
				<td>分数:</td>
				<td><input type="text" name="hou_score" id="qian_score" onblur="checkScore()" value="<%=user.getScore() %>"> <span id="score_error"></span></td>
			</tr>
			<tr>
				<td>注册日期(不可更改):</td>
				<td><%=user.getRegisterdate() %></td>
				<td><input type="hidden" value="注册日期"></td>
				<td><input type="hidden" name="hou_registerdate" id="qian_registerdate" onblur="checkRegisterDate()" value="<%=user.getRegisterdate() %>"> <span id="date_error"></span></td>
			</tr>
			<tr>
				<td>爱好:</td>
				<td><input type="checkbox" name="hou_hobby" value="足球">足球
					<input type="checkbox" name="hou_hobby" value="音乐">音乐 
					<input type="checkbox" name="hou_hobby" value="游泳">游泳</td>
			</tr>
			<tr>
				<td valign="top">爱好描述:</td>
				<td colspan="3">
				<textarea name="hobbies"><%=user.getHobbies() %></textarea>
			</tr>
			<tr>
				<td><input name="updateUserSubmit"	type="submit"	value="提交修改信息"></td>
			</tr>
			
		</table>

	</form>
	
</body>
</html>