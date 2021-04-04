<%@page import="edu.hebeu.entity.User"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC登录</title>

<script type="text/javascript">

	function checkNum() {//用用户id的前台验证
		var userNum = document.getElementById("qian_num").value;
		if (userNum== "") {//验证用户id是否为空
			document.getElementById("numerror").innerHTML ="用户名不能为空！";
			return false;
		}
		return true;
	}
	
	function checkPwd() {//密码的前台验证
		var userPwd = document.getElementById("qian_pwd").value;
		if (userPwd == "") {//验证密码是否为空
			document.getElementById("pwderror").innerHTML = "密码不能为空！";
			return false;
		}
		return true;
	}
	
	function checkVarify(){
		van yann = document.getElementById("qian_yann").value;
		if (yann == ""){
			document.getElementById("yannerror").innerHTML = "验证码不能为空！";
			return false;
		}
		if(form_login.yanzheng.value != form_login.verifycode.value ){
			document.getElementById("yannerror").innerHTML = "验证码不正确！";
			return false;
		}else{
			return true;
		}
	}

	function checkLogin() {//决定是否能够提交
		var flag1 = checkNum();
		var flag2 = checkPwd();
		var flag3 = checkVarify();
		if (flag1 && flag2 && flag3) {
			return true;
		}
		
		return false;
	}
	function resetValue() {//重置
		this.form_login.hou_num.value="";
		this.form_login.hou_pwd.value="";
		return false;
	}
	function back(){//返回
		location.href="<%=basePath %>";
	}
</script>

</head>
<body>
	<h3>登录界面</h3>
	
	<!-- 把从服务器发来的cookie取出到当前客户端 -->
	<%
	String getcook_userId = "";
	String getcook_userPwd = "";
	String check = "";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		if ("cook_id".equals(cookie.getName())) {
			getcook_userId = cookie.getValue();
			
			//解码
			getcook_userId = URLDecoder.decode(getcook_userId, "utf-8");
			
			check ="checked";
		}
		if ("cook_pwd".equals(cookie.getName())) {
			getcook_userPwd = cookie.getValue();
			
			//解码
			getcook_userPwd = URLDecoder.decode(getcook_userPwd,"utf-8");
		}
	}
	}
	%>
	
	${login_error}<br>
	${inform}<br>
	${session_user_num}<br>
	<form name="form_login" action="myServlet/Login" method="get" 
		onsubmit=" return checkLogin()">
		用户：<input type="text" name="hou_num" id="qian_num" value="<%=(getcook_userId == null?"":getcook_userId) %>"	
		onblur="checkNum()"> 
		<span id="numerror">
		<%
			String msg_num = (String)request.getAttribute("numerror");
			if(msg_num != null){
				out.println(msg_num);
			}
		%>
		</span><br>
		
		密码： <input type="password" name="hou_pwd" id="qian_pwd" value="<%=(getcook_userPwd==null?"":getcook_userPwd) %>" 
		onblur="checkPwd()">
		<div id="pwderror" style="display: inline">
		<%
		String msg_pwd = (String)request.getAttribute("pwderror");
		if(msg_pwd != null){
			out.println(msg_pwd);
		}
		%>
		</div><br>
		 验证码：<input type="text" name="yanzheng" id="qian_yann" 
			onblur="checkVarify()">
		<%//Math.random()表示随机取0-1范围的数,*11-1以后int表示随机取0-9的数
			int intsum1 = (int) ((Math.random() * 11) - 1);
			int intsum2 = (int) ((Math.random() * 11) - 1);
			int intsum3 = (int) ((Math.random() * 11) - 1);
			int intsum4 = (int) ((Math.random() * 11) - 1);
			String intsum = intsum1 + "" + intsum2 + intsum3 + intsum4;
		%>
		<input type="hidden" name="verifycode" value="<%=intsum %>"> <span>
			<font size="+1" color="#FF0000"> 
			<img alt="" src="${pageContext.request.contextPath}/num/<%=intsum1 %>.gif"	width=20	height=20>
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum2 %>.gif"	width=20	height=20>
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum3 %>.gif"	width=20	height=20>
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum4 %>.gif"	width=20	height=20>
		    </font> 
		    <span id="yannerror"> 
		   <%-- 
		    <%
 	         String yanzhengmsg = (String) request.getAttribute("yangzhengerror");
 	         if (yanzhengmsg != null) {
 		     out.println(yanzhengmsg);
 	        }
            %>
           --%>
		   </span></span><br> 
		    
		  记住账户<input type="checkbox"  name="remember" value="yes" <%=check %>><br>
		  
	  	<input type="submit" name="submit_login" value="登录">
	 	 <input type="reset" value="重置"  onclick="resetValue()" >
	  	<input type="button" value="返回"  onclick="back()" >
	</form>
</body>
</html>