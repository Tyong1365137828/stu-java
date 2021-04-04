<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加用户</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
	function checkaccount(){
		var useraccount = document.getElementById("qian_account").value;
		if (username == "") {
			document.getElementById("accounterror").innerHTML = "用户名不能为空！";
			return false;
		}else{
			document.getElementById("accounterror").innerHTML = "";
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
	function checkForm() {
		var flag1 = checkaccount();
		var flag2 = checkPwd();
		if (flag1 && flag2) {
			return true;
		}else{
			return false;
		}
	}
</script>
</head>

<body>
<form action="myServlet/Admin?method=Insert" method="post" onsubmit="return checkFrom()" >
<div id="header" class="wrap">
	<div id="Tiger"><img src="images/Tiger.jpg" width="50px" /></div>
	<div class="help"><a href="../myServlet/Admin?method=Exit">退出</a></div>
	<div class="navbar"> 
		<ul class="clearfix">
			<li><a href="./admin/success.jsp">首页</a></li>
			<li><a href="./myServlet/User?method=PageViewUser">用户</a></li>
			<li><a href="./myServlet/Items?method=PageViewItems">商品</a></li>
			<li><a href="./myServlet/Order?method=CheckAllOrderPage">订单</a></li>
			<li class="current"><a href="ordersel">订单</a></li>
		</ul>
	</div>
</div>

<div id="childNav">
	<div style="background:green; color:re">
		管理员您好${sion_adm }，欢迎回到管理后台。
	</div>
</div>

<div id="main" class="wrap">
	
	<div class="jaiyonghu" style="text-align: center;">
		<h2>新增用户</h2>
		<div style="text-align: center;">
			${session_register }
			${register_error }
				<table style="width: 60%; font-size: 20px; border-collapse: separate; border-spacing: 0px 10px; margin: auto;">
					<tr>
					
						<td style="width: 120px; height: 21px;" align="right">用户名：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="text" id="qian_account" style="font-size: 20px;" name="hou_account" onblur="checkaccount()" /><span id="accounterror"></span></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">姓名：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="text" style="font-size: 20px;" name="hou_name" id="name"/></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">密码：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="text" style="font-size: 20px;" name="hou_pwd" value="" onblur="checkPwd()" id="qian_pwd"/><span id="pwderror"></span></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">性别：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="radio" name="hou_sex" value="T" checked="checked" />男 <input type="radio" name="hou_sex" value="F" />女</td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">出生日期：</td>
						<td style="width: 120px; height: 21px;" align="left">
							<input type="text" style="font-size: 20px;" name="hou_birthday" id="birthday"/>
						</td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">手机号码：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="text" style="font-size: 20px;" name="hou_tel" value="" id="mobile"/></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">地址：</td>
						<td style="width: 120px; height: 21px;" align="left"><input type="text" style="font-size: 20px;" name="hou_address" value="" id="address"/><span id="sadd"></span></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right"></td>
						<td style="width: 120px; height: 21px;" align="right"><input type="submit" style="font-size: 20px;" value="添加====>" /></td>
					</tr>
				</table>
		
		</div>
	</div>
</div>
	</form>
</body>

</html>

