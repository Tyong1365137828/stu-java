<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%//Java代码，获取register.jsp页面的值
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//取值以供显示
		String id = request.getParameter("id_name");
		int age = Integer.parseInt(request.getParameter("age_name"));//把取得的值强制转换为int类型
		String[] hobbies = request.getParameterValues("hobbies_name");//数组的显示方法
	%>
	
	<!-- 显示页面 -->
	注册成功，信息如下：<br>
	id号：<%=id %><br>
	年龄：<%=age %><br>
	爱好：
	<%//用于显示爱好
		if(hobbies != null){//如果不为空，即有爱好
			for(String hobby : hobbies){
				out.print(hobby+"&nbsp;&nbsp;&nbsp;&nbsp;");//一个"&nbsp;"表示一个空格
			}
		}else{//否则，即没有选则爱好
			out.print("没有爱好,选择一个自己的爱好吧");
		}
	%>
</body>
</html>