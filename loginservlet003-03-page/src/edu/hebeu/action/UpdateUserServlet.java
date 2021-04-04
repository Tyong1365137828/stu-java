package edu.hebeu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/servlet/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//中文乱码解决
		request.setCharacterEncoding("utf-8");
		//让浏览器按照指定的编码格式进行显示
		//response.setCharacterEncoding("utf-8");
		//注意位置，当前servlet的编码格式  
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter out=response.getWriter();
		
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
		int n=userService.updateUser(user);
		//
		if(n>0){
			request.getRequestDispatcher("../servlet/FindAllUserServlet").forward(request, response);
		}else{
			request.setAttribute("error", "更新失败 ");
			request.getRequestDispatcher("../servlet/PreUpdataUserServlet?userid="+userid).forward(request, response);
		}
		
	}

}
