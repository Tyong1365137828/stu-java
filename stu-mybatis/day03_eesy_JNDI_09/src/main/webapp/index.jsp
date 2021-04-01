<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="edu.hebeu.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.hebeu.mapper.IUserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>
    JNDI方式配置数据库信息方式的测试页面，刷新页面后查看 后台控制台的打印信息
</h2>

<%--因为jsp页面会经过服务器，又因为JNDI是通过服务器--%>
<%
    // 1.读取配置文件
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 2.创建SqlSessionFactory工厂
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    // 3.使用工厂生产SqlSession对象
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 4.使用动态代理(使用SqlSession创建Dao接口的代理对象)
    IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
    // 5.使用代理对象执行方法
    List<User> userList = iUserDao.selectUserAll();
    for (User user : userList) {
        System.out.println(user);
    }
    // 6.释放资源
    sqlSession.close();
    inputStream.close();
%>
</body>
</html>
