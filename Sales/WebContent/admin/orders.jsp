<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员页面</title>
<script type="text/javascript">
	function jump_order(size){
		location.href="Order?method=CheckAllOrderPage&size="+size;
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="post" action="Order">
					收货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>订单号</th>
					<th>用户账号</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="pb" items="${orderlist.list}" varStatus="vs">
				<tr>
					<td >${pb.num }</td>
					<td >${pb.user_account }</td>
					<td >${pb.user.name }</td>
					<td>${pb.user.address }</td>
					<td>${pb.note}</td>
					<td><a href="?id=${pb.num }">查看</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				当前:${orderlist.index }/${orderlist.totalPageCount }页
				<c:if test="${orderlist.index>1}"><!-- 当前页不是第一页 -->
					<a href="Order?method=CheckAllOrderPage&index=1&size=${orderlist.size}">首页</a>
					<a href="Order?method=CheckAllOrderPage&index=${orderlist.index-1}&size=${orderlist.size}">上一页</a>
				</c:if>
				<c:if test="${orderlist.index<=1 }"><!-- 当前页是第一页 -->
					<a>当前页是首页</a>&nbsp&nbsp
					${orderlist.setIndex(1)}
				</c:if>
				<c:if test="${orderlist.totalPageCount>orderlist.index }"><!-- 当前页不是最后一页 -->
					<a href="Order?method=CheckAllOrderPage&index=${orderlist.index+1}">下一页</a>
					<a href="Order?method=CheckAllOrderPage&index=${orderlist.totalPageCount}&size=${orderlist.size }">尾页</a>
				</c:if>
				<c:if test="${orderlist.totalPageCount<=orderlist.index }"><!-- 当前页是最后一页 -->
					当前是末页&nbsp&nbsp
					${orderlist.setIndex(orderlist.totalPageCount) }
				</c:if>

			<select onchange="jump_order(this.value)">
				<c:forEach begin="4" end="32" step="4" var="n">
				   <c:if test="${n==orderlist.size }">
				   		<option selected="selected">${n}</option>
				   		</c:if>
				      	<c:if test="${n!=orderlist.size }">
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