package hebeu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*后台访问资源的方法：
 * 
 * 即servlet跳转到那个页面
*/

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/servlet/DoLogin2")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post提交方式的中文乱码的解决代码
		request.setCharacterEncoding("utf-8");
		
		//1、接收客户端--前台传来的参数
		String name=request.getParameter("username");//用户名的值,注意:Parameter内的值和login.jsp文件里的name(即组件名)名字一样
		String pwd=request.getParameter("userpasswd");//用户的密码
		System.out.println(name+"  "+pwd);

		//2、验证是不是合法用户(连接数据库jdbc，接口方法认证，返回user!=null)
		boolean flag=false;
		if((name.indexOf("ty"))>=0&&pwd.equals("1234567")){//用户名含有ty且密码是1234567
			flag=true;
		}
		
		//3、处理结果返回给用户，如果是用户，则返回主页;否则，返回登录页面
		if(flag){//如果flag是真
			//out.println("登录成功!!!");
			
			//转发(没有产生新的请求，数据共享，只能在本服务器的资源来回访问，不能解决不同服务器的资源访问问题)
			request.setAttribute("loginSuccess的test", name);//注意与loginSuccess.jsp页面的先后顺序，在loginSuccess.jsp才会赋上此值
			request.getRequestDispatcher("/admin/loginSuccess.jsp").forward(request, response);
			
//			重定向至其他网站，能够解决不同服务器的资源访问问题
//			response.sendRedirect("http://www.hebeu.edu.cn/index.html");
		}else{//如果flag是假
			//out.println("登录失败!!!");
			//转发
			request.setAttribute("login的test", "转发会共享数据！！！");//注意与login.jsp页面的先后顺序，在login.jsp之前才会赋上此值
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			
		}
		//访问资源：一方面前台访问，另一方面后台访问---跳转
		
	}

}
