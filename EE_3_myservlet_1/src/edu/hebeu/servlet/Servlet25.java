package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet25
 */
//@WebServlet("/Servlet25Test")
public class Servlet25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet25() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{/*Servlet初始化,该方法会在Servlet加载并实例化以后执行,即第一次访
											问Servlet时会被执行(且执行一次);可以设置为与服务器一起启动Servlet2.5
											具体方法参照web.xml文件,Servlet2.5版本在web.xml文件中在该Servlet的
											<servlet>标签里写入<load-on-startup>1</load-on-startup>*/
    	System.out.println("Servlet2.5的初始化方法(init())");
    	
    	//通过init()方法获取当前Servlet的初始化参数
    	String Servlet25Value = super.getInitParameter("Servlet25Param");//super表示调用HttpServlet的父类GenericServlet(getInitParameter是在ServletConfig抽象类中,GenericServlet是该抽象类的完成类)
    	System.out.println("当前Servlet2.5的'Servlet25Param'参数的初始值是'"+Servlet25Value+"'");
    	
    	//获取web容器的初始化参数
    	ServletContext servletContext = super.getServletContext();//getServletContext()方法用于获取Servlet的上下文对象,
    	String GlobleValue25Get = servletContext.getInitParameter("ServletAllGloabParam");//getInitParameter()方法用于在当前Servlet范围内获取名为""的参数值(初始化参数)
    	System.out.println("当前Servlet2.5取的web容器的'ServletAllGloabParam'参数的初始值是'"+GlobleValue25Get+"'");
    	
    }
    
  //Servlet的服务Service抽象方法(重点是doGet()和doPost()方法),调用几次则执行几次
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet2.5的Service抽象方法(service())的重点方法(doGet()和doPost())");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Servlet的销毁,在Servers处点击红点结束才会执行这个方法
		public void destroy(){
			System.out.println("Servlet2.5的销毁方法(destroy())");
		}

}
