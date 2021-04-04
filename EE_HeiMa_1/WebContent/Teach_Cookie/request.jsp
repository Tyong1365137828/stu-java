<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//客户端
Cookie[] cookies = request.getCookies();//获取全部Cookie

for(Cookie cookie:cookies){//遍历全部Cookie，取得需要的Cookie
	//如果是user1用户
	//if(cookie.getName().equals("user1")){//如果name值等于user1
	//	out.print("user1用户的num"+cookie.getName()+"-----"+cookie.getValue()+"<br>");//则输出获取Cookie的Name和Value值
	//}
	//if(cookie.getName().equals("u1_pwd")){//如果name值等于u1_pwd
	//	out.print("user1用户的密码"+cookie.getName()+"-----"+cookie.getValue()+"<br>");//则输出获取Cookie的Name和Value值
	//}

	//输出全部Cookie
	out.print("全部的Cookie<br>"+cookie.getName()+"-----"+cookie.getValue()+"<br>");//输出Cookie的Name和Value值
}

%>

</body>
</html>