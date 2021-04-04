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

<div id="main" class="wrap">
	
	<!-- 当前页 -->
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get">
					卖家：<input type="text" class="text" name="hou_name" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th></th>
					<th>商品编号</th>
					<th>商品名字</th>
					<th>卖家账号</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
				<c:forEach var="pb" items="${itemslist.list}" varStatus="vs">
				<tr>
					<td >${pb.code }</td>
					<td >${pb.name }</td>
					<td >${pb.user_account }</td>
					<td>${pb.price }</td>
					<td>${pb.quantity}</td>
					<td><a href="Admin?method=selectProductView&code=${pb.code }">查看</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				当前:${itemslist.index }/${itemslist.totalPageCount }页
				<c:if test="${itemslist.index>1}"><!-- 当前页不是第一页 -->
					<a href="Items?method=PageViewItems&index=1&size=${itemslist.size}">首页</a>
					<a href="Items?method=PageViewItems&index=${itemslist.index-1}&size=${itemslist.size}">上一页</a>
				</c:if>
				<c:if test="${itemslist.index<=1 }"><!-- 当前页是第一页 -->
					<a>当前页是首页</a>&nbsp&nbsp
					${itemslist.setIndex(1)}
				</c:if>
				<c:if test="${itemslist.totalPageCount>itemslist.index }"><!-- 当前页不是最后一页 -->
					<a href="Items?method=PageViewItems&index=${itemslist.index+1}">下一页</a>
					<a href="Items?method=PageViewItems&index=${itemslist.totalPageCount}&size=${itemslist.size }">尾页</a>
				</c:if>
				<c:if test="${itemslist.totalPageCount<=itemslist.index }"><!-- 当前页是最后一页 -->
					当前是末页&nbsp&nbsp
					${itemslist.setIndex(itemslist.totalPageCount) }
				</c:if>

			<select onchange="jump_items(this.value)">
				<c:forEach begin="4" end="32" step="4" var="n">
				   <c:if test="${n==itemslist.size }">
				   		<option selected="selected">${n}</option>
				   		</c:if>
				      	<c:if test="${n!=itemslist.size }">
				      	<option >${n}</option>
				   </c:if>
				   </c:forEach>
			</select>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
</body>
</html>