<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员页面</title>
<script type="text/javascript">
	function jump_items(size){
		location.href="Items?method=PageViewItems&size="+size;
	}

</script>
<link type="text/css" rel="stylesheet" href="../public_style/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo" style="color:green;"><img src="../images/Tiger.jpg" width="40" />真正的喵王</div>
	<div class="help"><a href="../myServlet/Admin?method=Exit">退出</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="../admin/success.jsp">首页</a></li>
			<li><a href="../myServlet/User?method=PageViewUser">用户</a></li>
			<li><a href="../myServlet/Items?method=PageViewItems">商品</a></li>
			<li><a href="../myServlet/Order?method=CheckAllOrderPage">订单</a></li>
			<li class="current"><a href="ordersel">订单</a></li>
		</ul>
	</div>
</div>

<div id="childNav">
	<div class="welcome wrap">
		管理员您好${sion_adm }，欢迎回到管理后台。
	</div>
</div>

<!--第三层 -->
<div id="product">
		
		<!-- 商品浏览 -->
		<div class="biaoti" style="text-align: center;">
			<h2>商品展示</h2>
			<img src="../images/produce/${showitems.src }">
			<p>商城价：<span class="price">￥${showitems.price }.00</span></p>
				<p>热卖程度：☆☆☆☆☆</p>
				<p>库　存：<span id="save">${showitems.quantity }</span></p>
			<h2>商品介绍</h2>
			<p>${showitems.evaluate }</p>
			<h2>发货地</h2>
			<p>${showitems.user.address }</p>
			<p><a href="../myServlet/Items?method=PageViewItems" >返回</a></p>
		</div>
		
		
</div>
<!--第三层 -->

</body>
</html>