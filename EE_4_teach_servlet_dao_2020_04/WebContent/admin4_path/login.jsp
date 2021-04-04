<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript">
	function checkName() {
		var username = document.getElementById("username").value;
		if (username == "") {
			document.getElementById("nameerror").innerHTML = "用户名不能为空！";
			return false;
		}
		 return true;
	   }
		function checkPwd() {
			var pwd = document.getElementById("pwd2").value;
			if (pwd == "") {
				document.getElementById("pwderror").innerHTML = "密码不能为空！";
				return false;
			}
			return true;
		}
		function checkForm() {
			var flag1 = checkName();
			var flag2 = checkPwd();
			if (flag1 && flag2) {
				return true;
			}
			return false;
		}
	
</script>
</head>
<body>
	<!-- 
  表单：post   get
 超链接：get
 url地址：

 -->
	<h3>登录界面</h3>
	
	<%
	String errormsg=(String)request.getAttribute("error");
	if(errormsg!=null){
		out.print(errormsg);
	}
	%>
	
	<!--  
	<form action="http://127.0.0.1:8080/_servlet_dao_2020_04/servlet/LoginServlet1_session" method="post"
		onsubmit="return checkForm()">
	-->	
	<!--  
	<form action="./servlet/LoginServlet1_session" method="post"
		onsubmit="return checkForm()">
	-->	
	<form action="servlet/LoginServlet1_session" method="post"
		onsubmit="return checkForm()">
		用户名：<input type="text" name="username" id="username" 
			onblur="checkName()"> 
			<span id="nameerror"></span> <br>
		密&nbsp&nbsp&nbsp&nbsp码：<input type="password" name="pwd1" id="pwd2"
			onblur="checkPwd()"> 
			<div id="pwderror" style="display: inline">
			</div><br>
			 
			<input type="submit" value="登录">
	</form>

</body>
</html>