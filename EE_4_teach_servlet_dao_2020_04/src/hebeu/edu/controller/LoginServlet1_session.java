package hebeu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import edu.hebeu.dao.impl.UserDaoImpl;
import edu.hebeu.po.User;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/servlet/LoginServlet1_session")
public class LoginServlet1_session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1_session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//中文乱码解决post方式
		request.setCharacterEncoding("utf-8");
		
		//1.接收前台传来的参数，客户端输入的参数
		String username=request.getParameter("username");
		String password=request.getParameter("pwd1");
		System.out.println(username);
		//2.判断是不是合法的用户
		/*
		boolean flag=false;
		if(username.indexOf("gc")>=0||(username.indexOf("工程")>=0)){
			flag=true;
		}
		*/
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		User user=userDaoImpl.findUserByNameAndPassword(username,password);
		
		//3.根据结果回应客户端
		if(user!=null){
			//转发：不能解决不同服务器资源的访问问题
			//request.getRequestDispatcher("/admin2/success.jsp").forward(request, response);
			//request.setAttribute("name", username);
			//重定向
			//response.sendRedirect("http://www.hebeu.edu.cn/index.html");
			//response.sendRedirect("/servlet_2020_03/admin2/success.jsp");
			
			//使用session存储信息
			HttpSession s1=request.getSession();
			s1.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/admin4_path/success.jsp");
		
		}else{
			request.setAttribute("error", "你的用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("/admin3/login.jsp").forward(request, response);
		}
		//访问资源：一方面从jsp访问，二方面从servlet访问资源---跳转
		
	}

}
