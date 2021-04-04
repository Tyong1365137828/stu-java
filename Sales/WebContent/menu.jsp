<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%--报错的原因:缺少jar包,
在tomcat\webapps\examples\WEB-INF\lib目录下找到这两个jar包,拷贝到本项目的lib文件夹即可--%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>喵王首页</title>
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
<link type="text/css" rel="stylesheet" href="../public_style/style.css" />
<style>
.scroll_div {width:600px; height:62px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:60px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>
<style>
.scroll_div {width:500px; height:100px;margin:0 auto; overflow: hidden; white-space: nowrap; background:#ffffff;}
.scroll_div img {width:120px;height:100px;border: 0;margin: auto 8px; border:1px #efefef solid;}
#scroll_begin, #scroll_end, #scroll_begin ul, #scroll_end ul, #scroll_begin ul li, #scroll_end ul li{display:inline;}
</style>

</head>

<body>
	<div id="header" class="wrap">
		<div id="header">
			<img width="20" src="images/Tiger.jpg">
			喵王商城--测试版
		</div>
		<div class="friend_link">
			
				Hi,你好&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

				<!--  	<select id="year" onchange="go(this)" name="select" style="color:green">
				<option>菜单</option>
				<option value="http://www.163.com">网易</option>
				<option value="https://www.tmall.com/">天猫</option>
			</select>	-->
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

				<c:if test="${empty sion_user }">
					<!-- 如果为空，即是未登录状态 -->
					<a>未登录</a>
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
					<a>已卖商品</a>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					
					<select id="wode" onchange="go(this)" name="select">
						<option>我的</option>
						<option value="myServlet/User?method=FindUserExact&hou_id=${sion_user.account }">我的信息</option>
						<option value="user/register.jsp">我的店铺</option>
						<option value="user/register.jsp">修改信息</option>
					</select>
					
					<a href="myServlet/User?method=ShopCar">购物车</a>
					<a href="myServlet/User?method=Exit">退出</a>
					
				</c:if>
			
		</div>
	</div>
</body>
</html>