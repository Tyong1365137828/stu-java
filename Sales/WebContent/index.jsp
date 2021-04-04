<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>喵王首页---浏览</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/public_style/style.css" />
<script type="text/javascript">
function go(biaoshi) {
	var docurl = biaoshi.options[biaoshi.selectedIndex].value;
	if (docurl != "") {
		open(docurl, '_blank'); //打开新页面
		biaoshi.selectedIndex = 0;
		biaoshi.blur();
	}
}
</script>


</head>
<body>

<!-- 第一层 -->
<div id="header" class="wrap" >
	<div class="menu" >
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
			<li><a href="admin/NewFile.jsp">管理员点此</a></li>
		</ul>
	</div>
</div>
<!-- 第二层 -->


<!--第三层 -->
<div id="product">
	<div class="main">

		<!-- 窗口页面 -->
		<div class="side">
			<div class="newss">
				<h2 style="color:red">新公告</h2>
				<ul>
					<c:forEach var="n" items="${nlist}">
						<li><a href="newsSelect2?id=${n.EN_ID }" target="_blank">${n.EN_TITLE }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="spacer"></div>
			
		</div>
		
		<!-- 商品浏览 -->
		<div class="index" style="background:green; color:yellow; height:300px;">
			<h2>热卖推荐</h2>
			<ul class="product">
				<c:forEach var="il" items="${itemslist}">
					<li>
						<dl>
							<dt><a href="selectProductView?id=${il.code }" target="_blank"><img src="images/produce/${il.src }" /></a></dt>
							<dd class="title"><a href="selectProductView?id=${il.code }" target="_blank">${il.name}</a></dd>
							<dd class="price">${il.price }</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="index" style="background:green; color:yellow; height:300px;">
			<h1 align="center" style="font-size:80px">欢迎来到喵王销售网站《测试版》</h1>
		
		</div>
		
	</div>
	
</div>
<!--第三层 -->


</body>
</html>
