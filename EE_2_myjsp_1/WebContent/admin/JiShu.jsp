<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--第二节课内容 --%>

<%@ include file="../cat/top.jsp" %><!-- 静态包含，指令标签(指令标签共有3个) -->
<!-- 这个标签是把top.jsp文件的内容和本文件的内容为一体，然后随着本文件变成一个Java文件(故top.jsp文件并没有运行出Java文件) -->
	
	<%!
		int count = 0;
		public int getCount(){
			return count++;
		}
	%>
	
	<!-- (html形式的注释)
	此注释会被执行，仅是不被显示(即在网页上会被显示)
	 -->
	 
	 <%--(jsp形式的注释)
	 此注释不会被执行(即在网页上不会被显示)
	  --%>
	 
访问此数：<%=getCount() %><br>

<!-- 设置间距高度 -->
<div style="height:300px"></div>

<!-- 动态包含，设置网页底部 -->
<jsp:include page="../cat/bottom.jsp"></jsp:include><!-- 包含，动作标签 -->
<!-- 这个是把本文件与bottom.jsp文件分别形成对应的Java文件，然后和为一体 -->

</body>
</html>