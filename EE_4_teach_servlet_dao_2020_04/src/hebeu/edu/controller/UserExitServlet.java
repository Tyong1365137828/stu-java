package hebeu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.*;
/**
 * 用户退出Servlet
 * 
 * @author 
 */
@WebServlet("/servlet/UserExitServlet")
public class UserExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1599366365079846238L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取session
		HttpSession session = request.getSession();
		// 获取用户对象
		User user = (User)session.getAttribute("user");
		// 判断用户是否有效
		if(user != null){
			// 第一种方式，将用户对象逐出session(只把session的内容删除了，id号还存在)
			session.removeAttribute("user");
			
			// 设置提示信息
			request.setAttribute("info", user.getUsename() + " 已成功退出！");
			
			//第二种方式，删除所有信息，包括id号
			//session.invalidate();
		}
		// 转发到message.jsp页面
		request.getRequestDispatcher("/admin3/login.jsp").forward(request, response);
	}

}
