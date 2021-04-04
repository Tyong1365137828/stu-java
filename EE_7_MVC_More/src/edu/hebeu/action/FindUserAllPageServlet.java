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
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class FindUserAllPageServlet
 */
@WebServlet("/myServlet/FindUserAllPageServlet")
public class FindUserAllPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUserAllPageServlet() {
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
		System.out.println("--------UserServlet的PageAll()方法[");
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

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数

		// 调用业务层
		UserService userService = new UserServiceImpl();
		userService.findUserAll(pageBean);// 更多的业务交给业务层

		// 跳转
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin/findUserPage_All.jsp").forward(request, response);
		System.out.println("]----------");
	}

}
