<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	int count1 = 0;
	int count2 = 0;
	
	public void getCount1(){
		count1++;
	}
	public int getCount2(){
		return count2++;
	}
%>

你是第<%=getCount2()%>个访问的人!<br>

</body>
</html>