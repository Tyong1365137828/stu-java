package edu.hebeu.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.dao.impl.StudentDaoImpl;
import edu.hebeu.po.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/myServlet/Login")//注意这和from action的异同
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
		doPost(request,response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 中文乱码解决post方式，设置请求编码
		request.setCharacterEncoding("utf-8");

		
		// 1.接收前台传来的参数，客户端输入的参数
		String stuid = request.getParameter("hid");
		String stupwd = request.getParameter("hpwd");
		String rember_flag = request.getParameter("rember");
	
		//2、判断是不是合法的用户
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("下是断点");
		Student student = studentDaoImpl.findIdByPassword(stuid,stupwd);
	
		System.out.println(student);//在Student里有String toString方法,所以可以直接输出此对象

		// 3、返回处理结果
		if(student != null) {//如果不是空，即合法用户
			
			/*因为cookie不能传递汉字，如果要传递汉字，就必须处理汉字,把汉字
			变成cookie能认识的utf-8码；过程一，此过程保证了中文登录的实现,但
			是不能保证记住账户的实现,因为,返回到框内的不是中文,是utf-8的码,
			如果想要实现记住账号，就要在cookie返回到框的前面把utf-8码变成中文,
			参考本项目的login.jsp页面*/
			String cook_encoder_stuid=URLEncoder.encode(stuid, "utf-8");
			String cook_encoder_stupwd=URLEncoder.encode(stupwd, "utf-8");
			
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
			
			//cookie的生成步骤
			//1、办卡(记录用户名，密码)，即生成cookie
			Cookie setcook_id  = new Cookie("cookid", cook_encoder_stuid);//用户名
			Cookie setcook_pwd  = new Cookie("cookpwd", cook_encoder_stupwd);//密码
			
			//2、设定卡的有效周期，即记住多久(默认值是浏览器关闭之前有效;如果关闭浏览器，就不会在记住了)
			if("yes".equals(rember_flag)){//如果rember_flag等于yes，即rember的值也是yes，故可知客户端选择了记住账号
				setcook_id.setMaxAge(10*24*60*60);//十天免输入此，单位是秒
				setcook_pwd.setMaxAge(10);//十秒免输入此
			}else{//否则，即没有选中记住账户
				setcook_id.setMaxAge(0);//
				setcook_pwd.setMaxAge(0);
			}
//			
			//3、设定卡的使用范围，即访问路径
			setcook_id.setPath("/EE_5_MySessionAndCookie_2/");//设置此cookie的区域为"/5_MySessionAndCookie_2/"项目下的所有
			setcook_pwd.setPath("/EE_5_MySessionAndCookie_2/");
//			setcook_id.setPath("/");//设置此cookie的区域为当前服务器上的所有资源
//			setcook_id.setDomain("cn.com");//设置此cookie的域为"cn.com",且这个域可以被多个cookie所使用，即多个cookie使用一个域，比较少用
			
			//4、把办好的卡给用户，即使用respone给客户端，并在客户端把它存起来
			response.addCookie(setcook_id);//给客户端id
			response.addCookie(setcook_pwd);//给客户端密码
			
			//使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
//			//或者使用
//			request.getSession().setAttribute("sionstu", student);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sionstu", student);//可以存对象，变量等等；存放方式为键值对(变量名--值)的方式，相当于MAP方式，而不同于list，set等方式
			
			//重定向
			response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
			
		}else {//否则，即为空，不是合法用户
			
			//转发，在一个请求中完成，不用session技术也可以
			request.setAttribute("login_error", "你的用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}

	}

}
