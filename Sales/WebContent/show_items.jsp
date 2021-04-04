<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + 
	request.getServerName() + ":" + request.getServerPort() + 
	path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
function jian(){
	var count = parseInt(document.getElementById("count").value);
	if(count>0){
		count--;
	}
	if(count==0){
		count=1;
	}
	document.getElementById("count").value = count;
}
function jia(){
	var count = parseInt(document.getElementById("count").value);
	var stock = parseInt(document.getElementById("save").innerHTML);
	if(count<stock){
		count++;
	}
	document.getElementById("count").value = count;
}
function checkcount(){
	var count = parseInt(document.getElementById("count").value);
	var stock = parseInt(document.getElementById("save").innerHTML);
	if(count>stock){
		alert('库存不足');
		document.getElementById("count").value = stock;
	}
	if(count==0){
		alert('购买数量不能小于1');
		document.getElementById("count").value = 1;
	}
	if(count<0){
		alert('数量非法!!!');
		document.getElementById("count").value = 1;
	}
}

</script>
</head>
<body>

<!-- 第一层 -->
<div id="header" class="wrap">
	<div id="tiger"><img src="images/Tiger.jpg" width="50"/></div>
	
	<c:if test="${empty sion_user }">
		<!-- 如果为空，即是未登录状态 -->
		<a style="color:red">未登录</a>
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
			<option value="myServlet/User?method=FindUserExact&hou_id=${sion_user.account }">我的信息</option>
			<option value="user/register.jsp">我的店铺</option>
			<option value="myServlet/User?method=PreUpdateUser&hou_account=${sion_user.account }">修改信息</option>
		</select>
		<a href="myServlet/User?method=ShopCar">购物车</a>
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
			<li class="last"><input type="text" id="selectname" value="${search_words}" /><a href="javascript:selectname()">搜索</a></li>
		</ul>
	</div>
</div>
<!-- 第二层 -->


<!--第三层 -->
<div id="product">
		
		<!-- 商品浏览 -->
		<div class="hot">
			<h2>商品展示</h2>
			<img src="images/produce/${showitems.src }">
			<p>商城价：<span class="price">￥${showitems.price }.00</span></p>
				<p>邮递方式：<font color="red">顺丰速达</font></p>
				<p>热卖程度：☆☆☆☆☆</p>
				<p>库　存：<span id="save">${showitems.quantity }</span></p>
				<p>购买数量：
				<input type="button" value="  -  " onclick="jian()"/>
				<input align="middle" type="text" value="1" id="count" name="count" onblur="checkcount()"/>
				<input type="button" value="  +  " onclick="jia()"/></p>
			<h2>商品介绍</h2>
			<p>${showitems.evaluate }</p>
			<h2>发货地</h2>
			<p>${showitems.user.address }</p>
		</div>
		
		
</div>
<!--第三层 -->


</body>
</html>