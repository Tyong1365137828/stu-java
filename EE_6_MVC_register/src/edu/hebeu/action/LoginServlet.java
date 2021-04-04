package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/myServlet/Login")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 中文乱码解决post方式，设置请求编码
		request.setCharacterEncoding("utf-8");
		
		// 1.接收前台传来的参数，客户端输入的参数
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");
		
		//2、判断是不是合法的用户
		UserService userService = new UserServiceImpl();
		User user = userService.login(userid, userpwd);
		
		// 3、返回处理结果
		if(user != null){//如果不是空，即合法用户
			/*因为cookie不能传递汉字，如果要传递汉字，就必须处理汉字,把汉字
			变成cookie能认识的utf-8码；过程一，此过程保证了中文登录的实现,但
			是不能保证记住账户的实现,因为,返回到框内的不是中文,是utf-8的码,
			如果想要实现记住账号，就要在cookie返回到框的前面把utf-8码变成中文,
			参考本项目的login.jsp页面*/
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");
			
			//1、办卡(记录用户名，密码)，即生成cookie
			Cookie setcook_id = new Cookie("cook_id",cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_pwd",cook_encoder_userpwd);
			
			//2、设定卡的有效周期，即记住多久(默认值是浏览器关闭之前有效;如果关闭浏览器，就不会在记住了)
			if("yes".equals(rember_flag)){
				setcook_id.setMaxAge(10*24*60*60);
				setcook_pwd.setMaxAge(10*24*60*60);
			}else{//否则，即没有选中记住账户
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}
			
			//3、设定卡的使用范围，即访问路径
			setcook_id.setPath("/EE_6_MVC_register/");
			setcook_pwd.setPath("/EE_6_MVC_register/");
			
			//4、把办好的卡给用户，即使用respone给客户端，并在客户端把它存起来
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);
			
			//使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", user);
//			//或者使用
//			request.getSession().setAttribute("sion_user", user);
			
			//重定向
			response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
		}else{//否则，即为空，不是合法用户
			request.setAttribute("login_error", "请检查您的用户名和密码");
			//转发
			request.getRequestDispatcher("/admin/login2.jsp").forward(request, response);
		}
		
	}

}
