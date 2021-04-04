<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员页面</title>
<link type="text/css" rel="stylesheet" href="../public_style/style.css" />
<!--<style>
.scroll_div {width:600px; height:62px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:60px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>
<style>
.scroll_div {width:500px; height:100px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:100px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>
  -->
</head>
<body>
<div id="header" class="wrap">
	<div id="Tiger" style="color:green;"><img src="../images/Tiger.jpg" width="40" />真正的喵王</div>
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

<div id="3" >
	<div class="success" style="background:yellow; color:red; height:300px;">
		
	</div>
	<div class="success" style="background:green; color:red; height:300px;">
		<h1 align="center" style="font-size:60px">欢迎来到喵王销售网站《测试版》管理员页面</h1>
	</div>

</div>

</body>
</html>