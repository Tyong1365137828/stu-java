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
<style>
.scroll_div {
	width: 600px;
	height: 62px;
	margin: 0 auto;
	overflow: hidden;
	white-space: nowrap;
	background: red;
}

.scroll_div img {
	width: 120px;
	height: 60px;
	border: 0;
	margin: auto 8px;
	border: 1px #efefef solid;
}

#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul,
	#scroll_begin ul li, #scroll_end ul li {
	display: inline;
}
</style>
<style>
.scroll_div {
	width: 500px;
	height: 100px;
	margin: 0 auto;
	overflow: hidden;
	white-space: nowrap;
	background: red;
}

.scroll_div img {
	width: 120px;
	height: 100px;
	border: 0;
	margin: auto 8px;
	border: 1px #efefef solid;
}

#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul,
	#scroll_begin ul li, #scroll_end ul li {
	display: inline;
}
</style>
</head>
<body>
<form action="myServlet/User?method=UpdateUser" method="post"> -->
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

	<!-- 第三层 -->
	
		<div id="update">

			<div class="biaoti" style="text-align: center;">
				<h2>信息修改</h2>
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
							<input type="radio" value="男" name="sex" style="font-size: 20px;">男
							<input type="radio" value="女" name="sex" style="font-size: 20px;">女
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
						<td style="width: 120px; height: 21px;" align="right"></td>
						<td style="width: 120px; height: 21px;" align="right"><input
							type="submit" value="提交修改"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	
</body>
</html>