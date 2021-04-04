<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>喵王商城-管理员登录</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
function checkNum() {
	var username = document.getElementById("qian_num").value;
	if (username == "") {
		document.getElementById("numerror").innerHTML = "用户名不能为空！";
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
	location.href="/Sales/index.jsp";
}
</script>
</head>
<body>
	
	${inform}<br>
	${login_error}<br>
	<form id="form_Admlogin" action="myServlet/Admin?method=Login" method="post"
		onsubmit="return checkForm()">
		
		<!-- 第一层 -->
		<div id="header" class="wrap">
			<div id="tiger">
				<img src="images/Tiger.jpg" width="50" />
			</div>

				<a href="index.jsp">退出</a>
		</div>
		
		
		
		<!-- 第二层 -->
		<div id="childNav">
			<div class="wrap">
				<ul class="clearfix">
					<li><a href="myServlet/Items?method=ViewAllProduce">首页</a></li>
					<li class="first"><a href="javascript:searchHot('书籍')">书籍</a></li>
					<li><a href="javascript:searchHot('日用品')">日用品</a></li>
					<li><a href="javascript:searchHot('服饰')">服饰</a></li>
					<li><a href="javascript:searchHot('水果')">水果</a></li>
					<li><a href="javascript:searchHot('电子产品')">电子产品</a></li>
					<li><a href="javascript:searchHot('食品')">食品</a></li>
					<li class="last"><input type="text" id="selectname"
						value="${search_words}" /><a href="javascript:selectname()">搜索</a></li>
				</ul>
			</div>
		</div>
		<!-- 第二层 -->
		
		
		
		<!--第三层 -->

		<div id="user">
			<div class="biaoti" style="text-align: center;">
				<h2>管理员登录界面</h2>

			</div>
			
			<div class="xianshi" style="text-align: center;">
			
			</div>
			
			<div class="login" style="text-align:center;">
				${inform}<br>
				${login_error}<br>
				<table style="width:60%; font-size:20px; border-collapse:separate; border-spacing:0px 10px; margin:auto;">
				<tr>
					<td>账号：<input type="text" name="hou_num" id="qian_num" onblur="checkNum()" style="font-size:20px;">
					<span id="numerror"> 
		 			 <%
 		 			 String msg = (String) request.getAttribute("numerror");
 	  			    if (msg != null) {
 					  out.println(msg);
 	    			  }
         			 %>
					</span> </td>
				</tr>
					
					
				<tr>
					<td>密码： <input type="password" name="hou_pwd" id="qian_pwd" onblur="checkPwd()" style="font-size:20px;">
					<span id="pwderror" style="display: inline">
					<%
					String msg1 = (String) request.getAttribute("pwdnull");
					if(msg1!=null){
					out.println(msg1);
					}
					%>
					</span>
					</td>
				</tr>
				
				
				<tr>
					<td> 验证码：<input type="text" name="yanzheng" id="qian_yan" style="font-size:20px;"
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
		   		 	</font></span>
		   			<span id="yanerror"> 
		   			<%
 	        	 	String yanzhengmsg = (String) request.getAttribute("yangzhengerror");
 	        	 	if (yanzhengmsg != null) {
 		    	 	out.println(yanzhengmsg);
 	      		 	}
           		 	%>
		  			</span> </td>
				</tr>
				
				
				<tr>
					
	  				<td><input type="button" value="返回" style="font-size:20px; width:120px; " onclick="back()" >
	  				<input type="reset" value="重置"  onclick="resetValue()" >
					<input type="submit" value="登录" style="font-size:20px; width:120px; "></td>
				</tr>
				
				</table>
			</div>
		
		
		
		</div>
		
		
				
		</form>

</body>
</html>