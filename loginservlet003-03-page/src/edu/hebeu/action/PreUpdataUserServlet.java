package edu.hebeu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PreUpdataUserServlet
 */
@WebServlet("/servlet/PreUpdataUserServlet")
public class PreUpdataUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdataUserServlet() {
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
		//获取相关参数
		String userid=request.getParameter("userid");
		//调用业务层，查询指定编号的用户
		UserService userService=new UserServiceImpl();
		User user=userService.findUserById(userid);
		//返回用户信息给更新页面：跳转页面
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/userUpdate.jsp").forward(request, response);
	}

}
