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
@WebServlet("/myServlet/DeleteUserServlet")
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
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("qian_id");
		System.out.println(userid);
		
		UserService userService = new UserServiceImpl();
		try {
			userService.deleteUserByNum(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("deleteUserByNum方法有问题!!!");
			
		}
		//跳转到另一个Servlet
		request.getRequestDispatcher("/myServlet/findUserAllServlet").forward(request, response);//转发
		
	}
}
