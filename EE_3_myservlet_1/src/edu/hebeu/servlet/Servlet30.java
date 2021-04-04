package edu.hebeu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B
 */
													//Servlet3.0方式设置初始化启动方式、设置当前Servlet初始参数等方法，但是注意3.0要配置web容器参数时必须就要用web.xml方式(参考Servlet2.5配置web容器方式)
@WebServlet(value="/Servlet30Test",loadOnStartup=1,initParams= {@WebInitParam(name="Servlet30Param",value="Servlet30Value" ) } )
public class Servlet30 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet30() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{/*Servlet初始化,该方法会在Servlet加载并实例化以后执行,即第一次访
		问Servlet时会被执行(且执行一次);可以设置为与服务器一起启动Servlet3.0
		版本在注解内写入value="/servlet名",loadOnStartup=1*/
    	System.out.println("Servlet3.0的初始化方法(init())");
    	
    	//通过init()方法拿到初始化参数(当前的Servlet参数和web容器的参数)
    	String Servlet30Value = super.getInitParameter("Servlet30Param");//super表示调用HttpServlet的父类GenericServlet(getInitParameter是在ServletConfig抽象类中,GenericServlet是该抽象类的完成类)
    	System.out.println("当前Servlet3.0的'Servlet30Param'参数的初始值是'"+Servlet30Value+"'");
    	
    	//获取web容器的初始化参数,
    	ServletContext servletContext = super.getServletContext();//getServletContext()方法用于获取Servlet的上下文对象,
    	String GlobleValue30Get = servletContext.getInitParameter("ServletAllGloabParam");//getInitParameter()方法用于在当前Servlet范围内获取名为""的参数值(初始化参数)
    	System.out.println("当前Servlet3.0取的web容器的'ServletAllGloabParam'参数的初始值是'"+GlobleValue30Get+"'");
    }
    
    //Servlet的服务Service抽象方法(重点是doGet()和doPost()方法),调用几次则执行几次
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3.0的Service抽象方法(service())的重点方法(doGet()和doPost())");
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
		System.out.println("Servlet3.0的销毁方法(destroy())");
	}
	
}
