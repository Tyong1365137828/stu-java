<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<%@ page import="edu.hebeu.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkName() {
		var username = document.getElementById("user").value;
		if (username == "") {
			document.getElementById("nameerror").innerHTML = "用户名不能为空空空！";
			return false;
		}
		return true;
	}
	function checkPwd() {
		var username = document.getElementById("pwd1").value;
		if (username == "") {
			document.getElementById("pwderror").innerHTML = "密码不能为空！";
			return false;
		}
		return true;
	}

	function checkVarify() {
		
		var yann = document.getElementById("yan1").value;
		if (yann == "") {
			
			document.getElementById("yanerror").innerHTML = "验证码不能为空！";
			return false;
		}
		if (form1.yanzheng.value != form1.verifycode.value) {
			
			document.getElementById("yanerror").innerHTML = "请输入正确的验证码！";
			return false;
		}
		return true;
	}

	function checkForm() {
		var flag1 = checkName();
		var flag2 = checkPwd();
		var flag3 = checkVarify();
		if (flag1 && flag2 && flag3) {
			return true;
		}
		
		return false;
	}
	function resetValue() {
		this.form1.username.value="";
		return false;
	}
	function back(){
		location.href="/_servlet18_mvc_register1/index.jsp";
	}
</script>
</head>
<body>
<h3>请输入用户名和密码</h3>
	<% 
	String username1="";
	User user=new User();
	user=(User)session.getAttribute("user");
	%>
	<%
	String username = "";
	String pwd = "";
	String check = "";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		if ("uname".equals(cookie.getName())) {
			username = cookie.getValue();
			username = URLDecoder.decode(username, "utf-8");
			check ="checked";
		}
		if ("upwd".equals(cookie.getName())) {
			pwd = cookie.getValue();
		}
	}
	}
	%>
	<!-- ${error} -->
	<form name="form1" action="../servlet/LoginServlet001" method="get"
		onsubmit=" return checkForm()">
		用户：<input type="text" name="username" id="user" value="<%=username1%>" onblur="checkName()">
		<span id="nameerror"> 
		  <%
 		  String msg = (String) request.getAttribute("nameerror");
 	      if (msg != null) {
 		  out.println(msg);
 	      }
          %>
		</span><br> 
		密码： <input type="password" name="pwd" id="pwd1" value="<%=pwd%>"
			onblur="checkPwd()">
		<div id="pwderror" style="display: inline">
			<%
			String msg1 = (String) request.getAttribute("pwdnull");
			if(msg1!=null){
			out.println(msg1);
			}
			%>
		</div><br>
		 验证码：<input type="text" name="yanzheng" id="yan1" 
			onblur="checkVarify()">
		<%
			int intsum1 = (int) ((Math.random() * 11) - 1);
			int intsum2 = (int) ((Math.random() * 11) - 1);
			int intsum3 = (int) ((Math.random() * 11) - 1);
			int intsum4 = (int) ((Math.random() * 11) - 1);
			String intsum = intsum1 + "" + intsum2 + intsum3 + intsum4;
		%>
		<input type="hidden" name="verifycode" value="<%=intsum%>"> <span>
			<font size="+1" color="#FF0000"> 
			<img alt="" src="${pageContext.request.contextPath}/num/<%=intsum1%>.gif">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum2%>.gif">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum3%>.gif">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum4%>.gif">
		    </font> 
		    <span id="yanerror"> 
		    <%
 	         String yanzhengmsg = (String) request.getAttribute("yangzhengerror");
 	         if (yanzhengmsg != null) {
 		     out.println(yanzhengmsg);
 	        }
            %>
		   </span></span><br>
	  记住我<input type="checkbox"  name="remember" value="yes" <%=check%>><br>
	  <input type="submit" value="登录">
	  <input type="reset" value="重置"  onclick="resetValue()" >
	  <input type="button" value="返回"  onclick="back()" >
	</form>

</body>
</html>