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
<title>分页显示符合多条件的用户</title>
<script type="text/javascript">
	function confimDelete(id) {
		var flag = window.confirm("您确认要删除吗？");
		if (flag) {
			window.location.href = "../myServlet/DeleteUserServlet?qian_id="
					+ id;
		}
	}

	function goPag() {
		var n = document.getElemntById("qian_page").value;
		window.location.href = "../myServlet/FindUserMulPageServlet?index=" + n;
	}
	
	function confimUpdate(id) {
		window.location.href = "../myServlet/PreUpdateUserServlet?qian_id="
				+ id;
	}

	function changeSize(size) {
		location.href = "../myServlet/FindUserMulPageServlet?size=" + size;
	}

	function change(index, size) {
		location.href = "../myServlet/FindUserMulPageServlet?index=" + index
				+ "&size=" + size;
	}
	
	function checkName() {
		var username = document.getElementById("qian_name").value;
		if (username == "") {
			document.getElementById("name_error").innerHTML = "姓名输入不能为空！！！";
			return false;
		}
		return true;
	}
	
	function checkAge() {
		var userage = document.getElementById("qian_age").value;
		if (userage == "") {
			document.getElementById("age_error").innerHTML = "年龄输入不能为空！！！";
			return false;
		}
		return true;
	}
	
	function checkForm(){
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
	<form action="myServlet/FindUserMulPageServlet" onsubmit="return checkForm()" method="post">
			<table>
			<tr>
				<%--  <td width="24"><img src="images/1.jpg" width="20" height="18"/></td> --%>
				<td>请输入名字：<input type="text" name="hou_name" size="12"
					id="qian_name" onblur="checkName()" value="${name }"> <span id="name_error">
						<%
							String mesg1 = (String) pageContext.getAttribute("name_error");
							if (mesg1 != null) {
								out.println(mesg1);
							}
						%>
				</span>
				</td>
				<td>请输入年龄>=<input type="text" name="hou_age" size="12"
				id="qian_age" onblur="checkAge()" value="${age }"> <span id="age_error">
						<%
							String mesg2 = (String) pageContext.getAttribute("age_error");
							if (mesg2 != null) {
								out.println(mesg2);
							}
						%>
				</span>	 <input name="submit2" type="submit" value="多条件分页查询">
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
				<td height="20" width="9%" align="center" bgcolor="#EEEEEE">编号</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">姓名</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">年龄</td>
				<td width="9%" align="center" bgcolor="#EEEEEE">操&nbsp;&nbsp;&nbsp;作</td>
			</tr>
			
			<c:forEach items="${pageBean.list }" var="pBList">
			<tr>
				<td bgcolor="#FFFFFF" align="center"><input type="checkbox"
					name="delid" /></td>
				<td width="8%" align="center" bgcolor="#EEEEEE">${pBList.num }</td>
				<td width="8%" align="center" bgcolor="#EEEEEE">${pBList.name }</td>
				<td width="8%" align="center" bgcolor="#EEEEEE">${pBList.age }</td>
				<td align="center" bgcolor="#FFFFFF">
					<%--<a href="../myServlet/PreUpdateUserServlet?qian_id=<%= user.getNum() %>">修改</a>--%>
					<input type="button" value="修改" onclick="confimUpdate(${pBList.num})" />
					<input type="button" value="删除" onclick="confimDelete(${pBList.num})" />
				</td>
			</tr>
			
		</c:forEach>
			
		<tr>
			<td colspan="11" align="center">
			${PageUserMul_null_servlet}<br>
			<c:if test="${pageBean.index > 1 }"><%--如果当前页不是1(不是第一页) --%>
			<a href="myServlet/FindUserMulPageServlet?index=1&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">首页</a>&nbsp&nbsp
			<a href="myServlet/FindUserMulPageServlet?index=${pageBean.index-1 }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">上一页</a>&nbsp&nbsp
			</c:if>
			<c:if test="${pageBean.index <= 1 }"><%--如果当前页是1(是第一页) --%>
			<a>当前是首页</a>&nbsp&nbsp
			</c:if>
			
				<c:if test="${pageBean.totalPageCount > pageBean.index }"><%--如果总页>当前页,即当前页不是最后一页 --%>
				<a href="myServlet/FindUserMulPageServlet?index=${pageBean.index+1 }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">下一页</a>&nbsp&nbsp
				<a href="myServlet/FindUserMulPageServlet?index=${pageBean.totalPageCount }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">末页</a>&nbsp&nbsp
				</c:if>
				<c:if test="${pageBean.totalPageCount <= pageBean.index }"><%--如果总页小于等于当前页,即当前页是最后一页 --%>
				当前是末页&nbsp&nbsp
				</c:if>
				<%--把这些页面数字集合放到上述两个if之后,是为了当要访问的页面不在正确范围时,任然能够把当前index页放在正确的位置 --%>
				<c:forEach
					items="${ pageBean.numbers}" var="pBNum">
					<c:if test="${pBNum == pageBean.index }"><%--如果选择的页面集合是当前页 --%>
						<a href="myServlet/FindUserMulPageServlet?index=${pBNum }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">【${pBNum }】</a>&nbsp&nbsp
					</c:if>
					<c:if test="${pBNum != pageBean.index }"><%--如果选择的页面集合不是当前页 --%>
						<a href="myServlet/FindUserMulPageServlet?index=${pBNum }&size=${pageBean.size }&hou_name=${name }&hou_age=${age }">${pBNum }</a>&nbsp&nbsp
					</c:if>
				</c:forEach>
				
				跳到<input type="text" name="qian_page" value="${pageBean.index }" />页
				<input type="button" value="确认" onclick="goPag()" />
				<input type="button" value="每页7记录" onclick="changeSize(7)" />
			</td>
		</tr>
			
			
		</table>
	
	</form>
</body>
</html>