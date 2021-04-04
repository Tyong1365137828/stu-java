<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//这是一个复杂的js对象,其格式就是 key:value 的形式
		var student = {
			lastName : "张三",
			age : 18,
			car : {
				pp : "奔驰",
				price : "8000$"
			},
			infos : [ {
				bookName : "西游记",
				price : 38.8
			}, 18, true ]
		}
		
		alert(student.car.pp);//可以看出js对象，属性操作，取值特别方便
		alert(student.infos[2]);//取出true
		//那么如果服务器返回给浏览器的数据是js对象这种样子，浏览器使用js解析就会很方便,
		
		
		alert(student);//这个是直接输出对象，可以看到其输出的结果不是预想到的
		alert("student的类型为"+typeof student);//查看student的类型
		
		var strJSON =JSON.stringify(student)//使用这段话可以将JSON转为JSON字符串
		alert(strJSON);//可以看出已经转成JSON字符串，并输出了我们想要的结果
		alert("strJSON的类型为:"+typeof strJSON)//查看strJSON的类型
		
		
		//因为HTTP只能传输文本，js对象进行传输就要变成字符串！！！
		alert(strJSON.age);//可以看出不能取出值，因为其为string，要想取出值，需要使用下面的代码变成对象
		var student2 = JSON.parse(strJSON);//将JOSN字符串转为JSON对象
		alert("student2的类型为："+typeof student2);
		
	</script>

</body>
</html>