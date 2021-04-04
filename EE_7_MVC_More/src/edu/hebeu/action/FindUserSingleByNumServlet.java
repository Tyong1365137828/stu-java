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
 * Servlet implementation class FindUserByNumServlet
 */
@WebServlet("/myServlet/FindUserSingleByNum")
public class FindUserSingleByNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserSingleByNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNum = request.getParameter("hou_num");
		
		UserService userService = new UserServiceImpl();
		User user = userService.findUserByNum(userNum);
		System.out.println("servlet"+userNum);
		if(user != null){
			request.setAttribute("userSingle_servlet", user);
		}else{
			request.setAttribute("userSingle_null_servlet", "没有找到此用户！！！");
		}
		
		request.getRequestDispatcher("/admin/findUserByNum_single.jsp").forward(request, response);
	}

}
