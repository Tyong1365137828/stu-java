<%@page import="edu.hebeu.po.UserCustom"%>
<%@ page import="java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
	function checkNum() {
		var username = document.getElementById("qian_num").value;
		if (username == "") {
			document.getElementById("numerror").innerHTML = "用户名不能为空！";
			return false;
		} else {
			document.getElementById("numerror").innerHTML = "";
			return true;
		}
	}

	function checkPwd() {
		var username = document.getElementById("qian_pwd").value;
		if (username == "") {
			document.getElementById("pwderror").innerHTML = "密码不能为空！";
			return false;
		} else {
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
		if (form_Userlogin.yanzheng.value != form_Userlogin.verifycode.value) {

			document.getElementById("yanerror").innerHTML = "请输入正确的验证码！";
			return false;
		} else {
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
		} else {
			return false;
		}
	}

	function resetValue() {
		this.form_login.username.value = "";
		return false;
	}

	function back() {
		location.href = "/Sales/index.jsp";
	}

	function register() {
		location.href = "/Sales/user/register.jsp";
	}
</script>

</head>
<body>

	<form name="form_Userlogin" action="myServlet/User?method=Login"
		method="post" onsubmit="return checkForm()">

		<!-- 第一层 -->
		<div id="header" class="wrap">
			<div id="tiger">
				<img src="images/Tiger.jpg" width="50" />
			</div>

			<c:if test="${empty sion_user }">
				<!-- 如果为空，即是未登录状态 -->
				<a style="color: red">未登录</a>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="user/login.jsp">请登录</a>
					|
		<a href="user/register.jsp">注册</a>
			</c:if>
			<c:if test="${not empty sion_user }">
				<!-- 如果不为空，既是登录状态 -->
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a>已买商品</a>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a>卖出的商品</a>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					
		<select id="wode" onchange="go(this)" name="select">
					<option>我的</option>
					<option
						value="myServlet/User?method=FindUserExact&hou_id=${sion_user.account }">我的信息</option>
					<option value="user/register.jsp">我的店铺</option>
					<option
						value="myServlet/User?method=PreUpdateUser&hou_account=${sion_user.account }">修改信息</option>
				</select>
				<a href="">购物车</a>
				<a href="myServlet/User?method=Exit">退出</a>
			</c:if>
		</div>
		<!-- 第一层 -->




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
				<h2>登录界面</h2>

			</div>

			<div class="xianshi" style="text-align: center;">
				<%
					//String username1="";
					UserCustom userCustom = new UserCustom();
					userCustom = (UserCustom) session.getAttribute("user");
				%>
				<%
					String getcook_userId = "";
					String getcook_userPwd = "";
					String check = "";
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						for (int i = 0; i < cookies.length; i++) {
							Cookie cookie = cookies[i];
							if ("cook_userid".equals(cookie.getName())) {
								getcook_userId = cookie.getValue();
								getcook_userId = URLDecoder.decode(getcook_userId, "utf-8");
								check = "checked";
							}
							if ("cook_userpwd".equals(cookie.getName())) {
								getcook_userPwd = cookie.getValue();
								getcook_userPwd = URLDecoder.decode(getcook_userPwd, "utf-8");
							}
						}
					}
				%>
			</div>

			<div class="login" style="text-align:center;">
				${login_error}<br>
				 ${inform}<br> 
				 ${session_register}<br>
				<table style="width:60%; font-size:20px; border-collapse:separate; border-spacing:0px 10px; margin:auto;">
				
				<tr>
					
					<td>账号：
					<input type="text" name="hou_num" id="qian_num" style="font-size:20px;"
					value="<%=(getcook_userId == null ? "" : getcook_userId)%>"
					onblur="checkNum()"> <span id="numerror"> <%
 					String msg = (String) request.getAttribute("numerror");
 					if (msg != null) {
 					out.println(msg);
 					}
 					%></span></td>
				</tr>
				
				<tr>
					<td> 密码：
					<input type="password" name="hou_pwd" id="qian_pwd" style="font-size:20px;"
					value="<%=(getcook_userPwd == null ? "" : getcook_userPwd)%>"
					onblur="checkPwd()">
					<span id="pwderror" style="display: inline">
					<%
						String msg1 = (String) request.getAttribute("pwdnull");
						if (msg1 != null) {
							out.println(msg1);
						}
					%> </span></td>
				</tr>
				
				<tr>
					<td>验证码：
						<input type="text" name="yanzheng" id="qian_yan"  style="font-size:20px;"
						onblur="checkVarify()">
						<%
						int intsum1 = (int) ((Math.random() * 11) - 1);
						int intsum2 = (int) ((Math.random() * 11) - 1);
						int intsum3 = (int) ((Math.random() * 11) - 1);
						int intsum4 = (int) ((Math.random() * 11) - 1);
						String intsum = intsum1 + "" + intsum2 + intsum3 + intsum4;
						%>
						<input type="hidden" name="verifycode" value="<%=intsum%>">
				
						<span> <font size="+1" color="#FF0000"> <img alt=""
						src="${pageContext.request.contextPath}/num/<%=intsum1%>.gif"
						width="20" height="20"> <img alt=""
						src="${pageContext.request.contextPath}/num/<%=intsum2%>.gif"
						width="20" height="20"> <img alt=""
						src="${pageContext.request.contextPath}/num/<%=intsum3%>.gif"
						width="20" height="20"> <img alt=""
						src="${pageContext.request.contextPath}/num/<%=intsum4%>.gif"
						width="20" height="20"></font></span>
						
						<span id="yanerror"> <%
 						String yanzhengmsg = (String) request.getAttribute("yangzhengerror");
 						if (yanzhengmsg != null) {
 						out.println(yanzhengmsg);
 						}
 						%></span> 
 					</td>
					
				</tr>
				
				<tr>
					
					<td><input type="checkbox" name="remember" value="yes" <%=check%>> 记住我
					<input type="submit" value="登录" style="font-size:20px; width:120px; "> 
					<input type="button" value="返回" style="font-size:20px; width:120px; " onclick="back()"></td>
				</tr>
				
				</table>
			</div>

		</div>
	</form>
</body>
</html>