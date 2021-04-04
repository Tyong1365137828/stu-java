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
    function confimDelete(id) {
    	var flag=window.confirm("您确认要删除吗？");
    	if(flag){
    		window.location.href="../servlet/DeleteUserServlet?userid="+id;
    	}
		
	}
</script>
</head>
<body>
    <form action="servlet/FindAllUserServlet" method="post">
        <table>
            <tr>
              <td width="24"><img src="images/1.jpg" width="20" height="18"/></td>
             
               <td>     <input type="submit" value="分页查询">     </td>
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
           <c:choose>
            <!-- 如果一个用户也没有怎么办？ -->
            <c:when test="${ empty userList }">
              <tr>
                <td colspan="8">没有用户数据</td>
              </tr>
            </c:when>
          </c:choose>
           
       </table>
   </form>
</body>
</html>