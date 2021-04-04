<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--这里把此jsp文件当作后端处理(使用的是name属性的值)，这种做法是不正确的，但是加入servlet后，
此jsp文件会作为前端，不过相应的此jsp文件中验证身份的这部分代码就会到相应的servlet文件，此jsp文件
想要获取上一个login.jsp文件的值如果还使用后端(name获取)或前端(id获取)的取值方法，就获取不到值了；
这时就要用session技术 --%>

<%--验证的基本3个过程--%>
<%
//1、接收客户端--前台传来的参数
String name=request.getParameter("username");//用户名的值,注意:Parameter内的值和login文件里的name(即组件名)名字一样
String pwd=request.getParameter("userpasswd");//用户的密码
System.out.println(name+"  "+pwd);

//2、验证是不是合法用户(连接数据库jdbc，接口方法认证，返回user!=null)
boolean flag=false;
if((name.indexOf("ty"))>=0&&pwd.equals("1234567")){//用户名含有ty且密码是1234567
	flag=true;
}

//3、处理结果返回给用户，如果是用户，则返回主页;否则，返回登录页面
if(flag){//如果flag是真
	//out.println("登录成功!!!");
	request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
}else{//如果flag是假
	//out.println("登录失败!!!");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</body>
</html>