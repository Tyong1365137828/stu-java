<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="edu.hebeu.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    function confimDelete(id) {
    	var flag=window.confirm("您确认要删除吗？");
    	if(flag){
    		window.location.href="../servlet/DeleteUserServlet?userid="+id;
    	}
		
	}
</script>
</head>
<body>
    <form name=form3 action="servlet/UserServlet1?method=findUser" method="post">
        <table>
            <tr>
              <td width="24"><img src="images/1.jpg" width="20" height="18"/></td>
              <td>
                    <span >姓名：</span>
                    <input name="username" type="text" size="12" value="${sname }">
                    <span >年龄>= ：</span>
                    <input name="age" type="text" size="12" value="${sage }">
                    <input type="submit" value="多条件查询">
                    <a href="index.jsp">返回</a>
              </td>
              </tr>
        </table>
        <table>
            <tr align="center" bgcolor="#EEEEEE">
                <td width="2%">选择</td> 
                <td height="20" width="3%">用户编号</td>
                <td width="5%">用户姓名</td>
                <td width="2%">年龄</td>
                <td width="3%">分数</td>
                <td width="4%">入学时间</td>
                <td width="6%">业余爱好</td>
                <td width="10%">操&nbsp;&nbsp;&nbsp;作</td> 
            </tr>
            <!-- 如果一个用户也没有怎么办？ -->
            <c:if test="${ empty userList }">
          
            <%-- <c:if test="${userList.size()==0 }">--%>
              <tr>
                <td colspan="8" bgcolor="#00FF00">没有用户数据</td>
              </tr>
            </c:if>
            
            <%-- <c:if test="${userList.size()!=0 }">--%>
            <c:if test="${not empty userList }">
            <!-- 1.循环之前定义变量，存储总人数，年龄大于等于20岁的人数，小于20岁的人数 -->
            <c:set var="count" value="0"></c:set>
            <c:set var="agelargecount" value="0"></c:set>
            <c:set var="agesmallcount" value="0"></c:set>
            <c:set var="avagescore" value="0"></c:set>
            
            <c:forEach items="${userList }" var="user" varStatus="vs">
             <c:if test="${vs.count%2==0 }">
             <tr align="center" bgcolor="yellow">
             </c:if>
             <c:if test="${vs.count%2!=0 }">
             <tr align="center" bgcolor="#FFFFFF">
             </c:if>
             <td><input type="checkbox" name="delid"/></td>
             <td>${user.userid }</td> 
             <td height="20" >${user.username }</td>
             <td>${user['age'] }</td>
             <td>${user["score"] }</td>
             <td>${user.entrydate }</td>
             <td>${user.hobby }</td>                
             <td>
                <a href="servlet/DeleteUserServlet?userid=${user.userid }">删除</a>&nbsp;|&nbsp;
                <a href="javascript:confimDelete(${user.userid })">删除2</a>&nbsp;|&nbsp;
                <a href="javascript:void(0)" onclick="confimDelete(${user.userid })">删除3</a>&nbsp;|&nbsp;
                <input type="button" value="删除 4" onclick="confimDelete(${user.userid })"/>
                <a href="#">修改</a>
                <a href="servlet/PreUpdataUserServlet?userid=${user.userid }">更新</a>
             </td>  
           </tr>
           
           <!-- 2.每循环一次，统计人数，变量的最新值 -->
             <c:set var="count" value="${count+1 }"></c:set>
             <c:if test="${user.age>='20' }">
               <c:set var="agelargecount" value="${agelargecount+1 }"></c:set>
             </c:if>
             <c:if test="${user.age<'20' }">
               <c:set var="agesmallcount" value="${agesmallcount+1 }"></c:set>
             </c:if>
             <c:set var="avagescore" value="${avagescore+user.score }"></c:set>
           </c:forEach>
           
           <!-- 3.循环结束后，输入统计结果 -->
           <tr>
             <td colspan="8" bgcolor="#00FF00">
                                       总人数：${count }&nbsp;&nbsp;&nbsp;|&nbsp;  
                                       年龄大于20岁的人数有：${agelargecount }&nbsp;&nbsp;&nbsp;|&nbsp; 
                                       年龄小于20岁的人数有：${agesmallcount }&nbsp;&nbsp;&nbsp;|&nbsp; 
                                       平均成绩是：${avagescore/count }
             </td>
           </tr>
         </c:if>  
        </table>
    </form>
</body>
</html>