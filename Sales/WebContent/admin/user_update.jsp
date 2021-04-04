<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息修改页面</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/public_style/style.css" />

</head>
<body>
<form action="myServlet/Admin?method=UpdateUser" method="post"> -->
	<!-- 第一层 -->
<div id="header" class="wrap">
	<div id="Tiger"><img src="images/Tiger.jpg" width="50px" /></div>
	<div ><a href="../indexSelect">返回前台页面</a></div>
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
	<!-- 第一层 -->


	<!-- 第二层 -->
	<div id="childNav">
	<div style="background:green; color:re">
		管理员您好${sion_adm }，欢迎回到管理后台。
	</div>
</div>
	<!-- 第二层 -->

	<!-- 第三层 -->
	
		<div id="update" class="wrap">

			<div class="biaoti" style="text-align: center;">
				<h2>管理员修改用户界面</h2>
			</div>


			<div class="xianshi" style="text-align: center;">
				<table
					style="width: 60%; font-size: 20px; border-collapse: separate; border-spacing: 0px 10px; margin: auto;">
					<tr>
						<td style="width: 120px; height: 21px;" align="right">账号</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" id="qian_account" style="font-size: 20px;"
							value="${exactuser.account }" disabled></td>
						<td><input type="hidden" name="hou_account"
							value="${exactuser.account }"></td>
						<!-- 能传值！！！ -->
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">用户名</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" name="hou_name" id="qian_name"
							style="font-size: 20px;" value="${exactuser.name }"></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">住址</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" name="hou_address" id="qian_addres"
							style="font-size: 20px;" value="${exactuser.address }"></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">出生日期</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" name="hou_birthday" id="qian_birthday"
							style="font-size: 20px;" value="${exactuserdate }"></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">年龄</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" style="font-size: 20px;" value="${exactuser.age }"
							disabled></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">性别 </td>
						<td style="width: 120px; height: 21px;" align="left">
							<input type="radio" value="男" name="sex" style="font-size: 20px;" ${exactuser.sex =='男' ? "checked" :""}>男
							<input type="radio" value="女" name="sex" style="font-size: 20px;" ${exactuser.sex =='女' ? "checked" :""}>女
						</td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">电话</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="text" name="hou_tel" id="qian_tel" style="font-size: 20px;"
							value="${exactuser.tel }"></td>
					</tr>
					<tr>
						<td style="width: 120px; height: 21px;" align="right">密码</td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="password" name="hou_pwd" id="qian_pwd"
							style="font-size: 20px;" value="${exactuser.password }"></td>
					</tr>

					<tr>
						<td style="width: 120px; height: 21px;" align="left"><a href="myServlet/User?method=FindMulPage">返回</a></td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="submit" value="提交修改"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	
</body>
</html>