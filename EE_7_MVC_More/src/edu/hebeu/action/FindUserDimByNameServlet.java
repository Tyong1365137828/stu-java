package edu.hebeu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindUserDimByNameServlet
 */
@WebServlet("/myServlet/FindUserDimByNameServlet")
public class FindUserDimByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUserDimByNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("hou_name");

		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findDimUserByName(userName);
		if(listUser==null||listUser.size()==0){//判断List<>是否为空的方式
			request.setAttribute("listUserDim_null_servlet", "没有找到符合此要求的用户");
			System.out.println("空了");
		}else if(listUser!=null&&!listUser.isEmpty()){//判断List<>不为空的方式
			request.setAttribute("listUserDim_servlet", listUser);
			System.out.println("没空");
//			System.out.println(listUser);
		}
		request.getRequestDispatcher("/admin/findUserByName_Dim.jsp").forward(request, response);
	}

}
