package edu.hebeu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.po.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet/LoginServlet")//注意这和from action的异同
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 中文乱码解决post方式
		request.setCharacterEncoding("utf-8");

		
		// 1.接收前台传来的参数，客户端输入的参数
		String stuid = request.getParameter("hid");
		String stupwd = request.getParameter("hpwd");
	
		//2、判断是不是合法的用户
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("下是断点");
		Student student = studentDaoImpl.findIdByPassword(stuid,stupwd);
	
		System.out.println(student);//在Student里有String toString方法,所以可以直接输出此对象

		// 3、返回处理结果
		if(student != null) {//如果不是空，即合法用户
			
//			request.setAttribute("hid", stuid);/*给hid这个标签附上stuid的值(即)，
//												供前台显示使用，但是这样做是错误的，
//												前台的值是空的，并不能显示出hid给stuid的
//												值(即hid可以把值给stuid；但是同样的方法，
//												stuid却不能把刚才的值给hid；这是因为他们不
//												在同一请求(就这个项目而言它们位于2、3请求)，导致资源不共享)。
//												那么想要在前台显示就必须用session技术，
//												在2之后，3之前创建session；在请求3中使用session，
//												使2、3请求资源共享，达到前台显示的效果
//												*/
			
			//使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sionstu", student);//可以存对象，变量等等；存放方式为键值对(变量名--值)的方式，相当于MAP方式，而不同于list，set等方式
			
			//重定向
			response.sendRedirect(request.getContextPath()+"/admin3/success.jsp");
			
		}else {//否则，即为空，不是合法用户
			
			//转发，在一个请求中完成，不用session技术也可以
			request.setAttribute("error", "你的用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("/admin3/login.jsp").forward(request, response);
		}

	}

}
