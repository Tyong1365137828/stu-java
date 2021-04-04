package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
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
 * Servlet implementation class UserServlet1
 */
@WebServlet("/servlet/UserServlet1")
public class UserServlet1 extends BaseServlet {
	private static final long serialVersionUID = 1L;
    	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		//接收参数
//		String methodName=request.getParameter("method12");
//		//判断，执行相应方法
//		if("loginservlet".equals(methodName)){
//			this.loginservlet(request, response);
//		}else if("register".equals(methodName)){
//			this.register(request, response);
//		}else{
//			
//		}
//	}
	
	//登录
	public void loginservlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("utf-8");
		//System.out.println("99999");
		//1.接收前台数据
		String username=request.getParameter("username");
		String pwdd=request.getParameter("pwd");
		String yanvalue=request.getParameter("verifycode");
		String yanzheng=request.getParameter("yanzheng");
		String remember=request.getParameter("remember");
				
		//后台验证用户名
		if(username==null || "".equals(username)){
			request.setAttribute("nameerror", "用户名不能为空（JSP）！");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			return;
		}
		
		//后台验证密码
		if(pwdd==null || "".equals(pwdd)){
			request.setAttribute("pwdnull", "密码不能为空（JSP）！");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			return;
		}
					
		UserService userService=new UserServiceImpl();
		User user=userService.login(username, pwdd);
					
		//3.跳转：成功：success.jsp  失败： login.jsp
		if(user!=null){
			String cname=URLEncoder.encode(username,"utf-8");
			Cookie cookie1=new Cookie("uname",cname);
			Cookie cookie2=new Cookie("upwd",pwdd);
			
			if("yes".equals(remember)){
				cookie1.setMaxAge(60*60*10);
				cookie2.setMaxAge(60*60*10);
			}else{
				cookie1.setMaxAge(0);
				cookie2.setMaxAge(0);
			}
			
			cookie1.setPath(request.getContextPath()+"/");
			cookie2.setPath(request.getContextPath()+"/");
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			//request.setAttribute("uname", username);
			HttpSession session1=request.getSession();
			//session1.setAttribute("uname",username);
			session1.setAttribute("user",user);
			
			//统计网站的访问人数
			//获取之前的访问人数
			ServletContext context=request.getServletContext();
			Integer count2=(Integer)context.getAttribute("count");
			if(count2==null){
				count2=1;
			}else{
				count2++;
			}
			context.setAttribute("count", count2);
			//request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		    response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
		}else{
			//System.out.println("----------");
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}
    
    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//中文乱码解决
		//request.setCharacterEncoding("utf-8");
		//System.out.println("8888");
		//1.接收视图层的表单参数
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Integer age=Integer.parseInt(request.getParameter("age"));
		Double score=Double.parseDouble(request.getParameter("score"));
		Date entrydate=Date.valueOf(request.getParameter("entrydate"));
		String hobby[]=request.getParameterValues("hobby");
		User user=new User(userid, username, password, age, score, entrydate, Arrays.toString(hobby));
		
		//2.调用业务层完成注册操作
		UserService userService=new UserServiceImpl();
		int n=0;
		if(userService.userExist(userid)){
			n=userService.register(user);
			//out.println("注册成功！");
			response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			
		}else{
			//out.println("用户id已经存在！");
			request.setAttribute("error", "用户id已经存在，请重新注册");
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
		}		
				
	}
    
    //多条件查询
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("finUser方法执行");
		//接收参数 
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		Integer age1=null;
		if("".equals(age)){
			age1=null;
		}else{
			age1=Integer.parseInt(age);
		}
		
		System.out.println(username);
		System.out.println(age);
		//处理业务
		UserService userService=new UserServiceImpl();
		List<User> userList=userService.findUser(username,age1);
		
		//跳转页面
		request.setAttribute("userList", userList);
		request.setAttribute("sname", username);
		request.setAttribute("sage", age1);
		request.getRequestDispatcher("/admin/mulfindUser.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			
		
				
	}
}
