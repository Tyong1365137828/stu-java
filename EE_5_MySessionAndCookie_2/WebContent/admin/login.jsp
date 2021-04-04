<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
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
//前台验证的代码
		function checkIdText() {
		var stuid = document.getElementById("qid").value;//由用户名框的id名"qid"获取其上的值给stuid进行前台验证
		if (stuid == "") {//如果stuid为空
			document.getElementById("iderror").innerHTML = "用户名不能为空！";//给id名为"iderror"的span标签赋此值
			return false;//并给checkIdText()函数返回false
		}
		 return true;//否则，即不为空，checkIdText()函数返回ture
	   }
		function checkPwdText() {
			var stupwd = document.getElementById("qpwd").value;//由密码框的id名"qpwd"获取其上的值给stupwd进行前台验证
			if (stupwd == "") {//如果stupwd为空
				document.getElementById("pwderror").innerHTML = "密码不能为空！";//给id名为"pwderror"的div标签赋此值
				return false;//并给checkPwdText()函数返回false
			}
			return true;//否则，即不为空，checkPwdText()函数返回ture
		}
		function check() {
			var flag1 = checkIdText();//flag1等于checkIdText()函数的标志
			var flag2 = checkPwdText();//flag2等于checkPwdText()函数的标志
			System.out.println("huiewfuihwukrwvkewfhwqjide");
			if (flag1 && flag2) {//flag1和flag2均为true时，即用户名框和密码框均不为空
				return true;//check()函数返回true
			}
			return false;//否则check()函数返回false
		}
	
</script>

</head>
<body>
	<h3>登录界面</h3>
	
	<!-- 把从服务器发来的cookie取出到当前客户端 -->
	<%
	String getcook_stuid="";
	String getcook_stupwd="";
	String check = "";
	
	//1、获取你所有的会员卡，即所有的cookie
	Cookie[]  cookies=request.getCookies();
	
	//2、找到你想要的会员卡，即找到你想要的cookie值，用户名，密码，指定名称的cookie
	for(int i=0;i<cookies.length;i++){/*一个一个的拿出你的会员卡，以进行下面查找需要的会员卡*/
		Cookie cookie=cookies[i];
	
	//进行查找你需要的会员卡
	if("cookid".equals(cookie.getName())){//如果这是你相要的会员卡，即cookie
		getcook_stuid=cookie.getValue();//此时getcook_stuid获得的是utf-8码
		
		//还需要进行解码操作把utf-8码变成中文，然后再通过<input>标签的value属性返回到用户名框
		getcook_stuid=URLDecoder.decode(getcook_stuid, "utf-8");
		
		check="checked";//如果是这个账户，就把"checked"赋值给变量check，而check变成checked在复选框中就是选中状态的意思
	}
	if(cookie.getName().equals("cookpwd")){
		getcook_stupwd=cookie.getValue();//此时getcook_stupwd获得的是utf-8码
		
		//还需要进行解码操作把utf-8码变成中文，然后再通过<input>标签的value属性返回到密码框
		getcook_stupwd=URLDecoder.decode(getcook_stupwd, "utf-8");
		
	}
	
	}
	
	//3、用你的会员卡，即把相应的值放到相应的框，显示给用户
	%>
	
	
	${login_error}<br>
	${inform}<br>
		<!-- 注意和servlet注解的不同 -->
	<form action="myServlet/Login" method="post"
	onsubmit="return check()"><!-- 提交之前对全部(用户名框、密码框)进行验证，true时才可以执行<form action="......" -->
		
													<!-- 使用获得的cookie进行赋值，即实现记住账号密码的必须步骤 -->
		用户名：<input type="text" name="hid" id="qid" value="<%=(getcook_stuid==null?"":getcook_stuid) %>"
		onblur="checkIdText()"> <!-- 实据焦点，对用户名框进行捕捉，然后做出反应 --><%--使用三目运算符value="<%=(getcook_stuid==null?"":getcook_stuid) %>" ，表示如果cookie为空，则value值不会出现null，而是没有显示--%>
		<span id="iderror"></span><!-- 用span方式对用户名框进行信息提示 -->
		<br>
		
														<!-- 使用获得的cookie进行赋值，即实现记住账号密码的必须步骤 -->
		密码：<input type="password" name="hpwd" id="qpwd" value="<%=(getcook_stupwd==null?"":getcook_stupwd) %>"
		onblur="checkPwdText()"><!-- 实据焦点，对密码框进行捕捉，然后做出反应 --><%--使用三目运算符value="<%=(getcook_stuid==null?"":getcook_stuid) %>" ，表示如果cookie为空，则value值不会出现null，而是没有显示--%>
		<div id="pwderror" style="display: inline"></div><!-- 用div方式对密码框进行信息提示 -->
		<br>
		
		<!-- type类型为复选框;name随意起个名字;设置value值为yes,本质是作为一个标记供后台验证是否选中记住账号使用;加入checked表示如果选中 -->
		记住账户<input type="checkbox" name="rember" value="yes"	 <%=check %>><!-- check定义为一个变量，当账号正确后会给它赋值为"checked"，进而进行记住账户操作 -->
		<br>
		
		<input type="submit" value="登录">
	</form>
	
</body>
</html>