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
//前台验证的代码
		function checkIdText() {
		var stuid = document.getElementById("qid").value;//由用户名框的id名"qid"获取其上的值给stuid进行前台验证
		if (stuid == "") {//如果stuid为空
			document.getElementById("iderror").innerHTML = "用户名不能为空！";//给id名为"iderror"的span标签赋此值
			return false;//并给checkIdText()函数返回false
		}
		 return true;//否则，即不为空，checkIdText()函数返回ture
	   }
		function checkPwdText() {
			var stupwd = document.getElementById("qpwd").value;//由密码框的id名"qpwd"获取其上的值给stupwd进行前台验证
			if (stupwd == "") {//如果stupwd为空
				document.getElementById("pwderror").innerHTML = "密码不能为空！";//给id名为"pwderror"的div标签赋此值
				return false;//并给checkPwdText()函数返回false
			}
			return true;//否则，即不为空，checkPwdText()函数返回ture
		}
		function check() {
			var flag1 = checkIdText();//flag1等于checkIdText()函数的标志
			var flag2 = checkPwdText();//flag2等于checkPwdText()函数的标志
			if (flag1 && flag2) {//flag1和flag2均为true时，即用户名框和密码框均不为空
				return true;//check()函数返回true
			}
			return false;//否则check()函数返回false
		}
	
</script>

</head>
<body>
	<h3>登录界面</h3>
	
		<!-- 注意和servlet注解的不同 -->
	<form action="servlet/LoginServlet" method="post"
	onsubmit="return check()"><!-- 提交之前对全部(用户名框、密码框)进行验证，true时才可以执行<form action="......" -->
	
		用户名：<input type="text" name="hid" id="qid"
		onblur="checkIdText()"> <!-- 实据焦点，对用户名框进行捕捉，然后做出反应 -->
		<span id="iderror"></span><!-- 用span方式对用户名框进行信息提示 -->
		<br>
		
		密码：<input type="password" name="hpwd" id="qpwd"
		onblur="checkPwdText()"><!-- 实据焦点，对密码框进行捕捉，然后做出反应 -->
		<div id="pwderror" style="display: inline"></div><!-- 用div方式对密码框进行信息提示 -->
		<br>
		
		<input type="submit" value="登录">
	</form>
	
</body>
</html>