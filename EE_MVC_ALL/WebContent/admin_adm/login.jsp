<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.hebeu.entity.Administrator"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>
<script type="text/javascript">
function checkNum() {
	var username = document.getElementById("qian_num").value;
	if (username == "") {
		document.getElementById("numerror").innerHTML = "用户名不能为空空空！";
		return false;
	}else{
		document.getElementById("numerror").innerHTML = "";
		return true;
	}
}
function checkPwd() {
	var username = document.getElementById("qian_pwd").value;
	if (username == "") {
		document.getElementById("pwderror").innerHTML = "密码不能为空！";
		return false;
	}else{
		document.getElementById("pwderror").innerHTML = "";
		return true;
	}
}

function checkVarify() {
	
	var yann = document.getElementById("qian_yan").value;
	if (yann == "") {
		
		document.getElementById("yanerror").innerHTML = "验证码不能为空！";
		return false;
	}
	if (form_Admlogin.yanzheng.value != form_Admlogin.verifycode.value) {
		
		document.getElementById("yanerror").innerHTML = "请输入正确的验证码！";
		return false;
	}
	else{
		document.getElementById("yanerror").innerHTML = "";
		return true;
	}
}

function checkForm() {
	var flag1 = checkNum();
	var flag2 = checkPwd();
	var flag3 = checkVarify();
	if (flag1 && flag2 && flag3) {
		return true;
	}else{
		return false;
	}
}
function resetValue() {
	this.form_login.username.value="";
	return false;
}
function back(){
	location.href="/EE_MVC_ALL/index.jsp";
}
</script>
</head>
<body>
	<h3>请输入用户名和密码</h3>
	<% 
	//String username1="";
	Administrator administrator=new Administrator();
	administrator=(Administrator)session.getAttribute("sion_adm");
	%>
	<%
	String getcook_admId = "";
	String getcook_admPwd = "";
	String check = "";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
	for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		if ("cook_id".equals(cookie.getName())) {
			getcook_admId = cookie.getValue();
			getcook_admId = URLDecoder.decode(getcook_admId, "utf-8");
			check ="checked";
		}
		if ("cook_pwd".equals(cookie.getName())) {
			getcook_admPwd = cookie.getValue();
			getcook_admPwd = URLDecoder.decode(getcook_admPwd,"utf-8");
		}
	}
	}
	%>
	${inform}<br>
	${login_error}<br>
	<form name="form_Admlogin" action="../myServlet/AdmServlet?method=Login" method="post"
		onsubmit="return checkForm()">
		账号：<input type="text" name="hou_num" id="qian_num" value="<%=(getcook_admId == null?"":getcook_admId) %>" onblur="checkNum()">
		<span id="numerror"> 
		  <%
 		  String msg = (String) request.getAttribute("numerror");
 	      if (msg != null) {
 		  out.println(msg);
 	      }
          %>
		</span><br> 
		密码： <input type="password" name="hou_pwd" id="qian_pwd" value="<%=(getcook_admPwd==null?"":getcook_admPwd) %>"
			onblur="checkPwd()">
		<div id="pwderror" style="display: inline">
			<%
			String msg1 = (String) request.getAttribute("pwdnull");
			if(msg1!=null){
			out.println(msg1);
			}
			%>
		</div><br>
		 验证码：<input type="text" name="yanzheng" id="qian_yan" 
			onblur="checkVarify()">
		<%
			int intsum1 = (int) ((Math.random() * 11) - 1);
			int intsum2 = (int) ((Math.random() * 11) - 1);
			int intsum3 = (int) ((Math.random() * 11) - 1);
			int intsum4 = (int) ((Math.random() * 11) - 1);
			String intsum = intsum1 + "" + intsum2 + intsum3 + intsum4;
		%>
		<input type="hidden" name="verifycode" value="<%=intsum %>"> <span>
			<font size="+1" color="#FF0000"> 
			<img alt="" src="${pageContext.request.contextPath}/num/<%=intsum1%>.gif" width="20" height="20">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum2%>.gif" width="20" height="20">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum3%>.gif" width="20" height="20">
			<img alt=""	src="${pageContext.request.contextPath}/num/<%=intsum4%>.gif" width="20" height="20">
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