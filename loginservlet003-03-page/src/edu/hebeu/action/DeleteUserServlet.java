package edu.hebeu.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/servlet/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		//三步
		//获取要删除的用户编号
		//int userid=Integer.parseInt(request.getParameter("userid"));
		String userid=request.getParameter("userid");
		System.out.println(userid);
		//调用业务层完成删除操作
		UserService userService=new UserServiceImpl();
		try {
			userService.deleteUser(userid);
			//页面调转(跳到一个servlet )
			request.getRequestDispatcher("/servlet/FindAllUserServlet").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//如果失败，可以跳转到另外的失败页面
		}
		
		
		
	}

}
