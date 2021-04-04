package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/myServlet/User")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户登录Servlet
	 * @throws Exception 
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.接收前台传来的参数，客户端输入的参数
		System.err.println("dbfxsdvbhjasghvasghvaSHGJAWSVGHHBJASXHJASHJBkjbsdhjbsdch");
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");

		// 2、判断是不是合法的用户
		UserService userService = new UserServiceImpl();
		
		UserCustom userCustom= null;
		try {
			userCustom = userService.login(userid, userpwd);
		} catch (Exception e) {
			System.err.println("用户"+userid+"登录失败");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		// 3、返回处理结果
		if (userCustom != null) {// 判断这个集合如果不是空，即合法用户
			
			/*
			 * 因为cookie不能传递汉字，如果要传递汉字，就必须处理汉字
			 */
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");

			// 即生成cookie
			Cookie setcook_id = new Cookie("cook_userid", cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_userpwd", cook_encoder_userpwd);

			// 设定有效周期，即记住多久(默认值是浏览器关闭之前有效;如果关闭浏览器，就不会在记住了)
			if ("yes".equals(rember_flag)) {
				setcook_id.setMaxAge(10 * 24 * 60 * 60);
				setcook_pwd.setMaxAge(10 * 24 * 60 * 60);
			} else {// 否则，即没有选中记住账户
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}

			// 3、设定使用范围，即访问路径
			setcook_id.setPath("/Sales/");
			setcook_pwd.setPath("/Sales/");

			//使用respone给客户端，并在客户端把它存起来
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);

			// 使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", userCustom);
			// //或者使用
			// request.getSession().setAttribute("sion_user", user);

			// 重定向
//			response.sendRedirect(request.getContextPath() + "/product_all.jsp");
			request.getRequestDispatcher("/myServlet/Items?method=ViewAllProduce").forward(request, response);
			
		} else {// 否则，即为空，不是合法用户
			request.setAttribute("login_error", "请检查您的用户名和密码");
			// 转发
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}

	}
	
	/**
	 * 查询用户购买的商品,分页显示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UserBuyItemsForCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收参数
		
		String account = request.getParameter("hou_account");
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount(account);
		
		int index = 1;// 当前页,默认1
		String sindex = request.getParameter("index");// 接受前台传来的操作,对应的第几页
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// 赋值给当前页
		}

		int size = 1;// 当前每页的记录数,默认1
		String ssize = request.getParameter("size");// 接受前台传来的操作,对应每页的记录数
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// 赋值给当前每页的记录数
		}

		System.out.println("当前页是:" + index);
		System.out.println("当前每页的记录数是:" + size);

		PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数
		
		UserService userService = new UserServiceImpl();
		try {
			userService.finduserbuyitems(userCustom, pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("buy_items", pageBean);
		request.getRequestDispatcher("/user/show_buyitems.jsp").forward(request, response);
		
	}
	
	/**
	 * 查询用户购买的商品,一页显示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UserBuyItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_account");
		
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount(account);
		
		UserService userService = new UserServiceImpl();
		List<UserCustom> list = null;
		try {
			list = userService.findUserBuyItems(userCustom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("buy_items", list);
		request.getRequestDispatcher("").forward(request, response);
		
		
	}
	
	/**
	 * 删除用户的Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("hou_account");

		UserService userService = new UserServiceImpl();
		int n = 0;
		User user = new User();
		user.setAccount(userid);
		try {
			n = userService.deleteuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 跳转到另一个Servlet
		if(n>0){//删除成功
			request.setAttribute("delete_success", user.getAccount()+"删除成功");
			request.getRequestDispatcher("/myServlet/User?method=FindMulPage").forward(request, response);// 转发
		}
		else{//否则，删除失败
			request.setAttribute("delete_error", user.getAccount()+"删除失败");
			request.getRequestDispatcher("/admin/userr.jsp").forward(request, response);// 转发
		}

	}
	
	/**
	 * 注册用户Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_id");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		String sex = request.getParameter("hou_sex");
		String address = request.getParameter("hou_address");
		String tel = request.getParameter("hou_tel");
		Date birthday = null;
		
		try {
			birthday = Date.valueOf(request.getParameter("hou_birthday"));
		} catch (IllegalArgumentException e) {
			birthday = null;
			System.err.println("注册日期格式不对,以默认为null");
			// e.printStackTrace();
		}
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		UserService userService = new UserServiceImpl();
		
		int n = 0;
		
			try {
				n = userService.register(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				System.err.println(account+"用户注册失败！！！");
//				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.err.println(account+"用户注册失败！！！");
			}
			System.out.println("n="+n);
	
		if(n>0){	//即注册成功
			request.getSession().setAttribute("session_user", user);
			request.setAttribute("session_register", "account为"+user.getAccount()+"的用户,您已注册成功！！！");
			request.getRequestDispatcher("/user/perfect.jsp").forward(request, response);	//转发
			
		}else if(n<=0){	//即不成功
			request.setAttribute("register_error", "账号已经存在,请重新注册！！");
			request.getRequestDispatcher("/user/register.jsp").forward(request, response); //转发
		}
		
	}
	
	/**
	 * 注册后进行信息完善的页面的servlet
	 * 最后会返回至登录处
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PerfectInform(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String account = request.getParameter("hou_account");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		String sex = request.getParameter("sex");
		String address = request.getParameter("hou_address");
		String tel = request.getParameter("hou_tel");
		
		Date birthday = null;
		
		try {
			birthday = Date.valueOf(request.getParameter("hou_birthday"));
		} catch (IllegalArgumentException e) {
			birthday = null;
			System.err.println("注册日期格式不对,以默认为null");
			// e.printStackTrace();
		}
		System.out.println("account="+account);
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		System.out.println("user="+user);
		UserService userService = new UserServiceImpl();
		
		try {
			userService.updateuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user="+user);
		
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}
	
	/**
	 * 预修改的servlet，用于将personinform.jsp的值传给update.jsp页面
	 * 所以这里不用对数据形式判断正确与否
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PreUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("PreUpdateUser方法开始！！！");
		String account = request.getParameter("hou_account");
		User user = new User();
		user.setAccount(account);
		
		UserCustom userCustom = new UserCustom() ;	//声明扩展类
		
		UserService userService = new UserServiceImpl();
		try {
			userCustom = userService.personinform(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	//转换为yyyy-mm-dd
		String dateString = formatter.format(userCustom.getBirthday());	//转换
		
		request.getSession().setAttribute("exactuser", userCustom);
		request.getSession().setAttribute("exactuserdate", dateString);
		
		request.getRequestDispatcher("/user/update.jsp").forward(request, response);
		
	}

	/**
	 * 修改用户信息Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("UpdateUser方法开始！！！");
		String account = request.getParameter("hou_account");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		String sex = request.getParameter("sex");
		String address = request.getParameter("hou_address");
		String tel = request.getParameter("hou_tel");
		Date birthday = null;
		
		try {
			birthday = Date.valueOf(request.getParameter("hou_birthday"));
		} catch (IllegalArgumentException e) {
			birthday = null;
			System.err.println("注册日期格式不对,以默认为null");
			// e.printStackTrace();
		}
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		UserService userService = new UserServiceImpl();
		int n = 0;
		
		try {
			n=userService.updateuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.err.println("n===="+n);
		System.out.println("updateUser="+user);
		if(n>0){//修改成功
			request.getRequestDispatcher("/myServlet/User?method=FindUserExact&hou_id="+user.getAccount()).forward(request, response);
		}else{
			request.getRequestDispatcher("/myServlet/User?method=PreUpdateUser&hou_id="+user.getAccount()).forward(request, response);
		}
	}
	
	/**
	 * 由account精确查询用户,借助此用于显示在个人信息页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void FindUserExact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("ascadcahjscghAHghjaGHAXSVGHASXHJASHJ");
		String account = request.getParameter("hou_id");
		
		User user = new User();
		user.setAccount(account);
		
		UserCustom userCustom = new UserCustom() ;	//声明扩展类
		
		UserService userService = new UserServiceImpl();
		try {
			userCustom = userService.personinform(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	//转换为yyyy-mm-dd
		String dateString = formatter.format(userCustom.getBirthday());	//转换
		
		request.getSession().setAttribute("exactuser", userCustom);
		request.getSession().setAttribute("exactuserdate", dateString);
		request.getRequestDispatcher("/user/personinform.jsp").forward(request, response);
		
	}
	
	/**
	 * 购物车Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ShopSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    
	/**
	 * 分页显示全部用户Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PageViewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收参数
				int index = 1;// 当前页,默认1
				String sindex = request.getParameter("index");// 接受前台传来的操作,对应的第几页
				if (sindex != null && !"".equals(sindex)) {
					index = Integer.parseInt(sindex);// 赋值给当前页
				}

				int size = 4;// 当前每页的记录数,默认4
				String ssize = request.getParameter("size");// 接受前台传来的操作,对应每页的记录数
				if (ssize != null && !"".equals(ssize)) {
					size = Integer.parseInt(ssize);// 赋值给当前每页的记录数
				}

				System.out.println("当前页是:" + index);
				System.out.println("当前每页的记录数是:" + size);

				PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
				pageBean.setIndex(index); // 第1个参数
				pageBean.setSize(size); // 第2个参数
				
				UserService userService = new UserServiceImpl();
				
				try {
					userService.findalluser(pageBean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().setAttribute("userlist", pageBean);
				request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
				
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

		System.out.println("name=" + name);
		UserCustom user_MulPage = new UserCustom();
		user_MulPage.setName(name);
		System.out.println("user_MulPage=" + user_MulPage);
		
		PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数
		
		// 调用业务层
		UserService userService = new UserServiceImpl();
		try {
			userService.findalluser(user_MulPage, pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserService userService2 = new UserServiceImpl();
		List<UserCustom> listUser = null;
		try {
			listUser = userService2.findsermul(user_MulPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
			request.setAttribute("PageUserMul_null_servlet", "没有找到符合这些要求的用户");
			System.out.println("空了");
		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
			// request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("没空");
		}
		
		// 跳转
		// request.setAttribute("userList", user);
		request.setAttribute("name", name);
		
		request.getSession().setAttribute("userlist", pageBean);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
		System.out.println("]----------");
		
	}
	
	
	
	/**
	 * 退出Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.removeAttribute("sion_user");
		// 转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
}
