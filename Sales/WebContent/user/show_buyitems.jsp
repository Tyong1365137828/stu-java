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
<title>用户购买商品记录</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
	
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

		<div id="product">

			<div class="biaoti" style="text-align: center; background:green; color:yellow; height:200px;">
				<h2>购买记录界面</h2>
					
			</div>
	<c:forEach var="pb" items="${buy_items.list }">
		<img src="images/produce/${pb.order_list[0].orderdetail_list[0].items.src }">
		<h2>商品展示</h2>
			<%-- <p>商品名称：$<% out.print("{pb.order_list["); %> 0 <%  out.print("].orderdetail_list["); %>0 <%out.print("].items.name"); %>  }</p>--%>
			<p>商品名称：${pb.order_list[0].orderdetail_list[0].items.name  }</p>
			<p>订单号：${pb.order_list[0].num }</p>
			<p>购买数量${pb.order_list[0].orderdetail_list[0].items_num }</p>
			<h2>收货人${pb.name }</h2>
		</c:forEach>
		
			<%--<c:forEach var="pb" items="${buy_items.list }">
				<c:forEach var="ord" items="pb.order_list">
					<c:forEach var="orl" items="or.orderdetail_list">
						<p>商品名称：${pb.ord[0].orl[0].items.name }</p>--%>
			
		<!-- 购买商品的浏览 -->
		 <div style="text-align: center;background:green; color:yellow; height:200px;">
			<a href="myServlet/Items?method=ViewAllProduce" style="color:red; front-size:80px">返回</a>
		</div>
			

		</div>
	</form>
</body>
</html>