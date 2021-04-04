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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员页面</title>
<script type="text/javascript">
	function jump_user(size){
		location.href="User?method=FindMulPage&size="+size+"&hou_name=${name }"+"&index=${userlist.index}";
	}
	
	function confimDelete(id) {	//删除前台验证
		var flag = window.confirm("您确认要删除吗？");
		if (flag) {
			window.location.href = "User?method=Delete&hou_account=${pb.account }"+ id;
		}
	}
</script>
<link type="text/css" rel="stylesheet" href="../public_style/style.css" />
</head>
<body>
<form method="post" action="../myServlet/User?method=FindMulPage">
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

<div id="main" class="wrap">
	
	
	<!-- 当前页 -->
	<div class="main">
		<h2><a href="../admin/user_add.jsp" style="color:red; ">用户添加==></a></h2>
		<h2>用户管理</h2>
		${delete_success }
		${delete_error }
		<div class="manage">
			<div class="search">
				
					姓名：<input type="text" name="hou_name" value="${name }" />
					<label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
					<a href="">测试</a><input type="button" value="查询" onclick="go()">
				
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>帐号</th>
					<th>密码</th>
					<th>姓名</th>
					<th>地址</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
				<c:if test="${empty userlist.list }">
					<tr>
						<td colspan="8" bgcolor="#00FF00">没有用户数据</td>
					</tr>
				</c:if>
				
				<c:if test="${not empty userlist.list }">
				<c:forEach var="pb" items="${userlist.list}" varStatus="vs">
				<tr>
					<td>${pb.account }</td>
					<td>${pb.password }</td>
					<td>${pb.name }</td>
					<td>${pb.address }</td>
					<td>${pb.sex}</td>
					<td>${pb.birthday}</td>
					<td>${pb.age}</td>
					<td><a href="Admin?method=PreUpdateUser&hou_account=${pb.account }">修改</a> 
					<a href="User?method=Delete&hou_account=${pb.account }">删除</a>
					<!--  <input type="button" value="删除" onclick="confimUpdate(${pBList.account})">删除</a>-->
					</td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="pager">
				当前:${userlist.index }/${userlist.totalPageCount }页
				<c:if test="${userlist.index>1}"><!-- 当前页不是第一页 -->
					<a href="User?method=FindMulPage&index=1&size=${userlist.size}&hou_name=${name }">首页</a>
					<a href="User?method=FindMulPage&index=${userlist.index-1}&size=${userlist.size}&hou_name=${name }">上一页</a>
				</c:if>
				<c:if test="${userlist.index<=1 }"><!-- 当前页是第一页 -->
					<a>当前页是首页</a>&nbsp&nbsp
					${userlist.setIndex(1)}
				</c:if>
				<c:if test="${userlist.totalPageCount>userlist.index }"><!-- 当前页不是最后一页 -->
				<a href="User?method=FindMulPage&index=${userlist.index+1}&size=${userlist.size}&hou_name=${name }">下一页</a>
					<!--  <a href="User?method=FindMulPager&index=${userlist.index+1}&size=${userlist.size }&hou_name=${name }">下一页</a>-->
					<a href="User?method=FindMulPage&index=${userlist.totalPageCount}&size=${userlist.size }&hou_name=${name }">尾页</a>
				</c:if>
				<c:if test="${userlist.totalPageCount<=userlist.index }"><!-- 当前页是最后一页 -->
					当前是末页&nbsp&nbsp
					${userlist.setIndex(userlist.totalPageCount) }
				</c:if>
				
				<c:forEach items="${ userlist.numbers}" var="pBNum">
					
						<c:if test="${pBNum == userlist.index }"><%--如果选择的页面集合是当前页 --%>
							<a	href="User?method=FindMulPage&index=${pBNum }&size=${userlist.size }&hou_name=${name }">【${pBNum }】</a>&nbsp&nbsp
						</c:if>
						
						<c:if test="${pBNum != userlist.index }"><%--如果选择的页面集合不是当前页 --%>
							<a	href="User?method=FindMulPage&index=${pBNum }&size=${userlist.size }&hou_name=${name }">${pBNum }</a>&nbsp&nbsp
						</c:if> 
					</c:forEach> 

			<select onchange="jump_user(this.value)">
				<c:forEach begin="4" end="32" step="4" var="n">
				   <c:if test="${n==userlist.size }">
				   		<option selected="selected">${n}</option>
				   		</c:if>
				      	<c:if test="${n!=userlist.size }">
				      	<option >${n}</option>
				   </c:if>
				   </c:forEach>
			</select>
			
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
</form>
</body>
</html>