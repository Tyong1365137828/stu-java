<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getTime(){
		var now1=new Date();
		document.getElementById("time").innerHTML="当前时间1(因为在前台(浏览器)执行，是浏览器的时间，并非服务器的时间):"
		+now1.toLocaleString();
	}
	window.onload=getTime;
</script>
</head>
<body>


<!--小脚本，用来写Java代码，在后台执行  -->
	<%
	Date now2 = new Date();
	System.out.println("当前时间2(服务器时间):"+now2.toLocaleString());//在控制台输出
	out.println("当前时间2(服务器时间):"+now2.toLocaleString());//在浏览器的屏幕显示输出
	Thread.sleep(2000);
	%>
	
	<br>
	当前时间3(不会执行相关的代码，直接输出):now2.toLocaleString()<br>
	
	<!-- 表达式，在后台执行-->>
	当前时间4(服务器时间，可以执行):<%= now2.toLocaleString()%>
	
	<div id="time"></div>
</body>
</html>