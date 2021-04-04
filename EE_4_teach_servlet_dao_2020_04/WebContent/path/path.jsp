<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function jump1(){
    	location.href="http://127.0.0.1:8080/_servlet_dao_2020_04/admin4_path/add.jsp";
    	return;
    }
    function jump2(){
    	location.href="/_servlet_dao_2020_04/admin4_path/add.jsp";
    	return;
    }
    function jump3(){
    	//不准确，慎用
    	
    	location.href="admin4_path/add.jsp";  
    	return;
    }
</script>
</head>
<body>
path.jsp<br>
<%-- 
    当时用户是：<%=request.getAttribute("username") %><br>
    --%>
 
  <!-- 跳页面不一定都是超链接，可以是按钮 -->  
  <input type="button" value="add1.jsp" onclick="jump1()"><br><!-- type是类型；value是给用户显示的信息；onclick表示单击事件 -->
  <input type="button" value="add2.jsp" onclick="jump2()"><br>
  <input type="button" value="add3.jsp" onclick="jump3()"><br>
  <%
  out.print(basePath);
  %>
</body>
</html>