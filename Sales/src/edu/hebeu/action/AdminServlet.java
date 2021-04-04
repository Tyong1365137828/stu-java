package edu.hebeu.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.Items;
import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.service.ItemsService;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.ItemsServiceImpl;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/myServlet/Admin")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * 管理员登录
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 中文乱码解决post方式，设置请求编码
				request.setCharacterEncoding("utf-8");
				
				// 1.接收前台传来的参数，客户端输入的参数
				String num = request.getParameter("hou_num");
				String pwd = request.getParameter("hou_pwd");
				
				//2、判断是不是合法的用户
				if(num.equals("1365137828")&&pwd.equals("0727316052")){
					//4、把办好的卡给用户，即使用respone给客户端，并在客户端把它存起来
					
					//使用session技术存储信息，用于重定向(俩次请求)，需要共享资源时使用
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("sion_adm", num);
					
					//重定向
					response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
				}else{//否则，即为空，不是合法用户
					request.setAttribute("login_error", "请检查您的用户名和密码");
					//转发
					request.getRequestDispatcher("/admin/NewFile.jsp").forward(request, response);
				}
	}
	
	/**
	 * 通过code展示商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProductView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		ItemsService itemsService = new ItemsServiceImpl();
		
		Items items = new Items();
		items.setCode(code);
		
		Items items2= new Items();
		try {
			items2 = itemsService.showProduceByCode(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("showitems", items2);
		request.getRequestDispatcher("/admin/items_show.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 模糊展示商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("proname");
		Items items2 = new Items();
		items2.setName(name);
		
		ItemsService itemsService = new ItemsServiceImpl();
		List<Items> list = null;
		try {
			list =itemsService.showProduce(items2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("name="+name);
		System.out.println("items2"+items2);
		System.out.println("模糊商品图片list="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
	}
	
	
	/**
	 * 管理员修改用户信息的操作页面
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
		
		request.getRequestDispatcher("/admin/user_update.jsp").forward(request, response);
	}
	
	
	/**
	 * 管理员修改用户的Servlet
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
			request.getRequestDispatcher("/myServlet/Admin?method=PreUpdateUser&hou_account="+user.getAccount()).forward(request, response);
		}else{
			request.getRequestDispatcher("/myServlet/Admin?method=PreUpdateUser&hou_account="+user.getAccount()).forward(request, response);
		}
	}
	
	
	/**
	 * 注册用户Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_account");
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
			System.out.println("User="+user);
			System.out.println("n="+n);
	
		if(n>0){	//即注册成功
			request.getSession().setAttribute("session_user", user);
			request.setAttribute("session_register", "account为"+user.getAccount()+"的用户,已添加成功！！！");
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);	//转发
			
		}else if(n<=0){	//即不成功
			request.setAttribute("register_error", user.getAccount()+"账号添加失败！！");
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response); //转发
		}
		
	}
	
	/**
	 * 管理员退出
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.removeAttribute("sion_adm");
		// 转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
  
    

}
