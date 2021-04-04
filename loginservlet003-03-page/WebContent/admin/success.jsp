<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.hebeu.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  登录成功！欢迎您：<%=session.getAttribute("user") %>  --%>
 登录成功！欢迎您：
 <%
 User user=(User)session.getAttribute("user");
 out.println(user.getUsername());
 %>
 ${user.username }/${sessionScope.user.userid }
 <a href="../servlet/LogoutServlet">注销</a>
<a href="../index.jsp">返回主页面</a>
 <br>
 sessionID:<%=session.getId() %><br>
 session的默认最大间隔时间：<%=session.getMaxInactiveInterval() %>
 <%session.setMaxInactiveInterval(10); %>
 <hr>
     当前网站访问总人数：<%=application.getAttribute("count") %>|${count }|${applicationScope.count }
 <hr>
 <div style="background:#F00;color:#777" height="30" width="20%" align="center" bgcolor="#999999">用户个人信息</div>
  
 <table>
   <tr>
   <td height="6" width="9%" align="center" bgcolor="#999999">用户姓名</td>
   <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getUsername()%></td>
   </tr>
   <tr>
   <td height="6" width="9%" align="center" bgcolor="#999999">用户编号</td>
   <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getUserid()%></td></tr>
    <tr>
   <td width="8%" align="center" bgcolor="#999999">年龄</td>
    <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getAge()%></td> </tr>
     <tr>
   <td width="6%" align="center" bgcolor="#999999">成绩</td>
    <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getScore()%></td> </tr>
    <tr>
   <td width="6%" align="center" bgcolor="#999999">入学时间</td>
    <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getEntrydate()%></td> </tr>
    <tr>
   <td width="6%" align="center" bgcolor="#999999">爱好</td>
    <td height="20" width="9%" align="center" bgcolor="#EEEEEE"><%= user.getHobby()%></td>
   </tr>
 </table>
</body>
</html>