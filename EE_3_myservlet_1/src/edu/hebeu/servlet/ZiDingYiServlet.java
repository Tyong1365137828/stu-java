package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet/suibianxie")//浏览器的搜索地址以此为准
public class ZiDingYiServlet extends HttpServlet {
	//执行servlet的两种方式
	/*1、配置web.xml
	 * 在</web-app>的上一行输入
 <servlet>
	<servlet-name>运行的servlet类的命名</servlet-name>  注意：这个是命名，和下面的要运行的servlet类名可以不一样，但是最好一样
	<servlet-class>包名.要运行的servlet类名(即要运行的servlet文件在的路径)</servlet-class>  注意：包名.类名(这个类名是创建类(类名.class)的下一级,而不是类名.class)，可以选择类名后进行Copy Quali..拷贝名字，防止输入错误
  </servlet>
  <servlet-mapping>
	<servlet-name>运行的servlet类的命名</servlet-name>	注意：与上面的命名要一样
	<url-pattern>/给要运行的servlet类随便起一个url地址</url-pattern>  注意：这个servlet是个可以随意起的名字，而不是真正的servlet
  </servlet-mapping>

运行的过程：1)、<url-pattern>/给要运行的servlet类随便起一个url地址</url-pattern> ---2)、<servlet-name>运行的servlet类的命名</servlet-name>--
	    3)、<servlet-name>运行的servlet类的命名</servlet-name>--4)、<servlet-class>包名.要运行的servlet类名(即要运行的servlet文件的路径)</servlet-class>
	 * 
	 * 
	 * 
	 * 2、注解方式，在类或者方法的前面加标志
	 * 在类的前面加@WebServlet("/.../...(这里面的路径随便写，注意开头是"/"，注意浏览器的搜索地址以此为准)")
	 * 							
	 * 								//注意开头是"/"
	 * 或者@WebServlet(name="",urlPatterns={"路径1","路径2"},loadOnStartup=0/1/2/3/4/5)
	 * name表示给类起的名字	urlPatterns表示可以访问的路径	loadOnStartup(默认为0)表示启动的先后，越小越先启动，0表示随服务器一起启动
	 * 
	 * */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//在source下选择override/Implement Methods，然后只选择doGet和doPost提交
	//注意：一般get和post内只完善一个就够了，另一个可以直接用代码调用写的那一个
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("第一个servlet");
		System.out.println("第一个servlet的注解方式");
	}


	
}
