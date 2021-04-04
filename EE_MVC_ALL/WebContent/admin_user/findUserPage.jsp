<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%--报错的原因:缺少jar包,
在tomcat\webapps\examples\WEB-INF\lib目录下找到这两个jar包,拷贝到本项目的lib文件夹即可--%>
<%@page import="edu.hebeu.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示全部用户信息</title>
<script type="text/javascript">
	function confimDelete(id) {	//删除前台验证
		var flag = window.confirm("您确认要删除吗？");
		if (flag) {
			window.location.href = "myServlet/UserServlet?method=Delete&qian_id="+ id;
		}
	}

	function confimUpdate(id) {	//更新
		window.location.href = "myServlet/PreUpdateUserServlet?qian_id="
				+ id;
	}

	function go1(p) {//跳转
		//var p = document.getElemntById("page").value;
		var n =${pageBean.totalPageCount};
		if(p>n){
			window.alert("跳转页数超过总页数");
		}else{
			window.location.href="myServlet/UserServlet?method=FindMulPage&index="+p+"&hou_name=${name }&hou_age=${age }";
		}
	}

	function changeSize(size) {	//改变每页记录
		location.href = "myServlet/UserServlet?method=FindMulPage&size="+ size+"&hou_name=${name }&hou_age=${age }";
	}

	function change(index, size) {
		location.href = "../myServlet/UserServlet?method=FindMulPage&index=" + index
				+ "&size=" + size;
	}

	function checkName() {	//name框的前台验证
		var username = document.getElementById("qian_name").value;
		if (username == "") {
			document.getElementById("name_error").innerHTML = "姓名输入不能为空！！！";
			return false;
		}
		return true;
	}
	
	function checkAge() {	//age框的前台验证
		var userage = document.getElementById("qian_age").value;
		if (userage == "") {
			document.getElementById("age_error").innerHTML = "年龄输入不能为空！！！";
			return false;
		}
		return true;
	}
	
	function checkForm(){	//submit提交的前台验证
		var flag1 = checkName();
		var flag2 = checkAge();
		if(flag1||flag2){//任意一个不为空
			return true
		}
		return false;
	}
</script>
</head>
<body>
	<form action="myServlet/UserServlet?method=FindMulPage"
		onsubmit="return checkForm()" method="post">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td><input type="hidden" id="pageall"><%--用于在删除和更新表后跳转至此页面的标志 --%></td>
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入名字：<input type="text" name="hou_name" size="12" id="qian_name" onblur="checkName()" value="${name }"> 
					<span id="name_error"> 
					<%-- <%
 	String mesg1 = (String) pageContext.getAttribute("name_error");
 	if (mesg1 != null) {
 		out.println(mesg1);
 	}
 	%> --%>
					</span>
				</td>
				<td>请输入年龄>=<input type="text" name="hou_age" size="12" id="qian_age" onblur="checkAge()" value="${age }"> 
					<span id="age_error">
				<%-- <%
 						String mesg2 = (String) pageContext.getAttribute("age_error");
 						if (mesg2 != null) {
 							out.println(mesg2);
 						}
 				%> --%> 
					</span> 
					<input name="submit2" type="submit" value="多条件分页查询">
				</td>
			</tr>
		</table>
		<table border="1" width="80%" align="center">
			<tr align="center" bgcolor="#EEEEEE">
				<td width="2%" align="center" bgcolor="#EEEEEE">选择</td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE">学生编号</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">学生姓名</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">成绩</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">年龄</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">操&nbsp;&nbsp;作</td>
			</tr>
			<!-- 如果一个用户也没有怎么办？ -->
			<c:if test="${ empty pageBean.list }">

				<%-- <c:if test="${userList.size()==0 }">--%>
				<tr>
					<td colspan="8" bgcolor="#00FF00">没有用户数据</td>
				</tr>
			</c:if>
			
			<c:if test="${not empty pageBean.list }"><!-- 如果不为空 -->
				<c:set var="count" value="0"></c:set>
				<c:set var="agelargecount" value="0"></c:set>
				<c:set var="agesmallcount" value="0"></c:set>
				<c:set var="avagescorecount" value="0"></c:set>
				
				<c:forEach items="${pageBean.list }" var="pBList" varStatus="vs">
					<!-- 
					<c:if test="${vs.count%2 == 0}">
						<tr align="center" bgcolor="orange" >
					</c:if>
					<c:if test="${vs.count%2 != 0 }">
						<tr align="center" bgcolor="yellow" >
					</c:if>
					-->
						<c:if test="${pBList.score >= 90}">
							<tr align="center" bgcolor="#00FF00" >
						</c:if>
						<c:if test="${pBList.score <90 && pBList.score>=60}">
							<tr align="center" bgcolor="yellow" >
						</c:if>
						<c:if test="${pBList.score <60}">
							<tr align="center" bgcolor="red" >
						</c:if>
						<td align="center"><input type="checkbox" name="delid" /></td>
						<td width="8%" align="center" >${pBList.num }</td>
						<td width="8%" align="center" >${pBList.name }</td>
						<td width="8%" align="center" >${pBList.score }</td>
						<td width="8%" align="center" >${pBList.age }</td>
						<td align="center" >
						<%--<a href="../myServlet/PreUpdateUserServlet?qian_id=<%= user.getNum() %>">修改</a>--%>
						<input type="button" value="修改" onclick="confimUpdate(${pBList.num})" /> 
						<input type="button" value="删除" onclick="confimDelete(${pBList.num})" />
						</td>
					</tr><!-- 这个tr与前面的判断的<tr>对应，决定要显示什么颜色 -->
				<!-- 2.每循环一次，统计人数，变量的最新值 -->
				<c:set var="count" value="${count+1 }"></c:set>
				<c:if test="${pBList.age>='20' }">
					<c:set var="agelargecount" value="${agelargecount+1 }"></c:set>
				</c:if>
				<c:if test="${pBList.age<'20' }">
					<c:set var="agesmallcount" value="${agesmallcount+1 }"></c:set>
				</c:if>
				<c:set var="avagescore" value="${avagescore+pBList.score }"></c:set>
			</c:forEach>
			<!-- 3.循环结束后，输入统计结果 -->
			<tr>
				<td colspan="8" bgcolor="#00FF00" align="center">总人数：${count }&nbsp;&nbsp;&nbsp;|&nbsp;
					年龄大于20岁的人数有：${agelargecount }&nbsp;&nbsp;&nbsp;|&nbsp;
					年龄小于20岁的人数有：${agesmallcount }&nbsp;&nbsp;&nbsp;|&nbsp;
					平均成绩是：${avagescore/count }
				</td>
			</tr>

			<tr>
				<td colspan="11" align="center">
				
					${PageUserMul_null_servlet}<br>
				
					<c:if test="${pageBean.index > 1 }"><%--如果当前页大于1(不是第一页) --%>
						<a	href="myServlet/UserServlet?method=FindMulPage&index=1&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">首页</a>&nbsp&nbsp
						<a	href="myServlet/UserServlet?method=FindMulPage&index=${pageBean.index-1 }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">上一页</a>&nbsp&nbsp
					</c:if>
					
					<c:if test="${pageBean.index <= 1 }"><%--如果当前页小于等于1(是第一页或不符合正确的页面) --%>
						<a>当前是首页</a>&nbsp&nbsp
						${pageBean.setIndex(1) }
					</c:if>
					
					<c:if test="${pageBean.totalPageCount > pageBean.index }"><%--如果总页>当前页,即当前页不是最后一页 --%>
						<a	href="myServlet/UserServlet?method=FindMulPage&index=${pageBean.index+1 }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">下一页</a>&nbsp&nbsp
						<a	href="myServlet/UserServlet?method=FindMulPage&index=${pageBean.totalPageCount }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">末页</a>&nbsp&nbsp
					</c:if> 
				
					<c:if test="${pageBean.totalPageCount <= pageBean.index }"><%--如果总页小于等于当前页,即当前页是最后一页 --%>
						当前是末页&nbsp&nbsp
						${pageBean.setIndex(pageBean.totalPageCount) }
					</c:if>
					
					<%--把这些页面数字集合放到上述两个if之后,是为了当要访问的页面不在正确范围时,任然能够把当前index页放在正确的位置 --%>
					<c:forEach items="${ pageBean.numbers}" var="pBNum">
					
						<c:if test="${pBNum == pageBean.index }"><%--如果选择的页面集合是当前页 --%>
							<a	href="myServlet/UserServlet?method=FindMulPage&index=${pBNum }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">【${pBNum }】</a>&nbsp&nbsp
						</c:if>
						
						<c:if test="${pBNum != pageBean.index }"><%--如果选择的页面集合不是当前页 --%>
							<a	href="myServlet/UserServlet?method=FindMulPage&index=${pBNum }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">${pBNum }</a>&nbsp&nbsp
						</c:if> 
					</c:forEach> 
					
					跳到
					<input type="text" name="hou_index" width="20px" maxlength="3" size="1" id ="qian_page" />页<!-- 其中,size表示该文本框的长度,maxlength表示最大输入长度 -->
					<input type="button" value="go" onclick="go1(qian_page.value)" />
					
					  每页
				  		<select onchange="changeSize(this.value)" id="qian_size">
				  	   		<c:forEach begin="5" end="30" step="5" var="n">
				    	   		<c:if test="${n==pageBean.size }">
				      	      		<option selected="selected">${n}</option>
				     	   		</c:if>
				      	  		<c:if test="${n!=pageBean.size }">
				        	    	<option >${n}</option>
				      	  		</c:if>
				     		</c:forEach>
				 	 	</select>  
				   	 	记录 
					</td>
				</tr>
			</c:if>
		</table>

	</form>

</body>
</html>