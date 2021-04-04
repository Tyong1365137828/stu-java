package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/myServlet/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户登录Servlet
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.接收前台传来的参数，客户端输入的参数
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");

		// 2、判断是不是合法的用户
		UserService userService = new UserServiceImpl();
		User user = userService.login(userid, userpwd);

		// 3、返回处理结果
		if (user != null) {// 如果不是空，即合法用户
			/*
			 * 因为cookie不能传递汉字，如果要传递汉字，就必须处理汉字,把汉字
			 * 变成cookie能认识的utf-8码；过程一，此过程保证了中文登录的实现,但
			 * 是不能保证记住账户的实现,因为,返回到框内的不是中文,是utf-8的码,
			 * 如果想要实现记住账号，就要在cookie返回到框的前面把utf-8码变成中文, 参考本项目的login.jsp页面
			 */
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");

			// 1、办卡(记录用户名，密码)，即生成cookie
			Cookie setcook_id = new Cookie("cook_userid", cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_userpwd", cook_encoder_userpwd);

			// 2、设定卡的有效周期，即记住多久(默认值是浏览器关闭之前有效;如果关闭浏览器，就不会在记住了)
			if ("yes".equals(rember_flag)) {
				setcook_id.setMaxAge(10 * 24 * 60 * 60);
				setcook_pwd.setMaxAge(10 * 24 * 60 * 60);
			} else {// 否则，即没有选中记住账户
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}

			// 3、设定卡的使用范围，即访问路径
			setcook_id.setPath("/EE_MVC_ALL/");
			setcook_pwd.setPath("/EE_MVC_ALL/");

			// 4、把办好的卡给用户，即使用respone给客户端，并在客户端把它存起来
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);

			// 使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", user);
			// //或者使用
			// request.getSession().setAttribute("sion_user", user);

			// 重定向
			response.sendRedirect(request.getContextPath() + "/admin_user/success.jsp");
		} else {// 否则，即为空，不是合法用户
			request.setAttribute("login_error", "请检查您的用户名和密码");
			// 转发
			request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);
		}

	}

	/**
	 * 用户注册Servlet
	 */
	public void Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("hou_id");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		Integer age = Integer.parseInt(request.getParameter("hou_age"));
		Double score = Double.parseDouble(request.getParameter("hou_score"));
		Date registerdate = null;
		try {
			registerdate = Date.valueOf(request.getParameter("hou_registerdate"));
		} catch (IllegalArgumentException e) {
			registerdate = null;
			System.err.println("注册日期格式不对,以默认为null");
			// e.printStackTrace();
		}
		String hobbies[] = request.getParameterValues("hou_hobby");

		User user = new User(id, name, pwd, age, score, registerdate, Arrays.toString(hobbies));

		UserService userService = new UserServiceImpl();
		int n=0;
		try {
			n = userService.register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (n > 0) {
			// 使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
			request.getSession().setAttribute("session_user", user);

			//
			// request.getSession().setAttribute("session_user_num",
			// "id为'"+user.getNum()+"'的用户注册成功");//与重定向配合使用
			//// //或者使用
			//// HttpSession httpSession = request.getSession();
			//// httpSession.setAttribute("session_user", user);
			//
			// //重定向
			// response.sendRedirect(request.getContextPath()+"/admin/login.jsp");

			request.setAttribute("session_user_num", "id为'" + user.getNum() + "'的用户注册成功");// 与转发配合使用
			// 转发
			request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);

		} else {
			request.setAttribute("register_error", "id以存在,请输入另一id重新注册!!");

			// 转发
			request.getRequestDispatcher("/admin_user/register.jsp").forward(request, response);
		}
	}

	/**
	 * 退出Servlet
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sion_user");

		if (user != null) {
			// 实现免登录
			request.removeAttribute("sion_user");
			request.setAttribute("inform", "Id为'" + user.getNum() + "'的用户已成功退出！！");
		}
		// 转发
		request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);
	}

	/**
	 * 全部用户显示Servlet,实际上多条件模糊查询Servlet定义以后这个Servlet就没有用了
	 */
	public void FindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findUserAll();

		request.setAttribute("listUserAll_servlet", listUser);
		request.getRequestDispatcher("/admin_user/findUser_All.jsp").forward(request, response);
	}

	/**
	 * 多条件模糊查询用户显示
	 */
	public void FindMul(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("hou_name");
		if (name == null) {// 名字的合法与否取决于输入是否为空,所以用if...else..也可以
			name = "";
		}

		String age = request.getParameter("hou_age");
		Integer age1 = 0;// 年龄的合法与否不仅取决于是否为空还有格式的转换等,所以最好用try...catch...
		try {// 无论输入是空还是abc等不合法均可变成0,所以最好不要用if...else....,而是用try...catch...
			age1 = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			System.err.println("age类型有误,已经默认为0");
		}

		System.out.println("name=" + name + "	;age=" + age1);
		User user_Mul = new User();
		user_Mul.setName(name);
		user_Mul.setAge(age1);

		// 处理业务
		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findUserMul(user_Mul);

		// 跳转页面
		// request.setAttribute("userList", userList);
		// request.setAttribute("sname", name);
		// request.setAttribute("sage", age1);
		// request.getRequestDispatcher("/admin/find_multiple.jsp").forward(request,
		// response);
		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
			request.setAttribute("listUserMul_null_servlet", "没有找到符合这些要求的用户");
			System.out.println("空了");
		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
			request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("没空");
		}
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/admin_user/findUser_All.jsp").forward(request, response);
	}

	/**
	 * 精确查找用户信息Servlet
	 */
	public void FindSingle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userNum = request.getParameter("hou_num");

		User userSingle = new User();
		userSingle.setNum(userNum);
		UserService userService = new UserServiceImpl();
		User user = userService.findUserSingle(userSingle);
		System.out.println("servlet" + userNum);
		if (user != null) {
			request.setAttribute("userSingle_servlet", user);
		} else {
			request.setAttribute("userSingle_null_servlet", "没有找到此用户！！！");
		}
		request.getRequestDispatcher("/admin_user/findUserByNum_single.jsp").forward(request, response);
	}

	/**
	 * 分页显示全部用户Servlet,实际上当多条件分页模糊查询Servlet定义之后这个Servlet就已经没有用了
	 */
	public void FindAllPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------UserServlet的PageAll()方法[");
		// 接收参数
		int index = 1;// 当前页,默认1
		String sindex = request.getParameter("index");// 接受前台传来的操作,对应的第几页
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// 赋值给当前页
		}

		int size = 5;// 当前每页的记录数,默认5
		String ssize = request.getParameter("size");// 接受前台传来的操作,对应每页的记录数
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// 赋值给当前每页的记录数
		}

		System.out.println("当前页是:" + index);
		System.out.println("当前每页的记录数是:" + size);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数

		// 调用业务层
		UserService userService = new UserServiceImpl();
		userService.findUserAll(pageBean);// 更多的业务交给业务层

		// 跳转
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin_user/findUserPage.jsp").forward(request, response);
		System.out.println("]----------");
	}

	/**
	 * 多条件模糊查询用户分页显示Servlet
	 */
	public void FindMulPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收参数
		int index = 1;// 当前页,默认1
		String sindex = request.getParameter("index");// 接受前台传来的操作,对应的第几页
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// 赋值给当前页
		}

		int size = 5;// 当前每页的记录数,默认5
		String ssize = request.getParameter("size");// 接受前台传来的操作,对应每页的记录数
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// 赋值给当前每页的记录数
		}

		System.out.println("当前页是:" + index);
		System.out.println("当前每页的记录数是:" + size);

		String name = request.getParameter("hou_name");
		System.out.println("name=" + name);
		if (name == null) {
			name = "";
		}

		String age = request.getParameter("hou_age");
		Integer age1 = 0;// 年龄的合法与否不仅取决于是否为空还有格式的转换等,所以最好用try...catch...
		try {// 无论输入是空还是abc等不合法均可变成0,所以最好不要用if...else....,而是用try...catch...
			age1 = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			System.err.println("age类型有误,已经默认为0");
		}

		System.out.println("name=" + name + "	;age=" + age1);
		User user_MulPage = new User();
		user_MulPage.setName(name);
		user_MulPage.setAge(age1);
		System.out.println("user_MulPage=" + user_MulPage);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数

		// 调用业务层
		UserService userService = new UserServiceImpl();
		userService.findUserAll(user_MulPage, pageBean);// 更多的业务交给业务层

		// 判断是否为空
		UserService userService2 = new UserServiceImpl();
		List<User> listUser = userService2.findUserMul(user_MulPage);
		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
			request.setAttribute("PageUserMul_null_servlet", "没有找到符合这些要求的用户");
			System.out.println("空了");
		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
			// request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("没空");
		}
		// 跳转
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/admin_user/findUserPage.jsp").forward(request, response);
		System.out.println("]----------");
	}

	public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("qian_id");

		UserService userService = new UserServiceImpl();
		int n = 0;
		try {
			n = userService.deleteUser(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("deleteUser方法有问题!!!");
		}

		// 跳转到另一个Servlet
		if(n>0){//删除成功
			request.getRequestDispatcher("/myServlet/UserServlet?method=FindMulPage").forward(request, response);// 转发
		}
		else{//否则，删除失败
			request.getRequestDispatcher("/admin_user/error.jsp").forward(request, response);// 转发
		}

	}
}
