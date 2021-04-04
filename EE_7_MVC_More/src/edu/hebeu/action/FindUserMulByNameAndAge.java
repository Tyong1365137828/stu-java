package edu.hebeu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class FindUserMulByNameAndAge
 */
@WebServlet("/myServlet/FindUserDimByNameAndAgeServlet")
public class FindUserMulByNameAndAge extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public void FindUserMul(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("hou_name");
		if(name == null){//名字的合法与否取决于输入是否为空,所以用if...else..也可以
			name = "";
		}
		
		String age = request.getParameter("hou_age");
		Integer age1 = 0;//年龄的合法与否不仅取决于是否为空还有格式的转换等,所以最好用try...catch...
		try{//无论输入是空还是abc等不合法均可变成0,所以最好不要用if...else....,而是用try...catch...
			age1 = Integer.parseInt(age);
		}catch(NumberFormatException e){
			System.err.println("age类型有误,已经默认为0");
		}

		System.out.println("name="+name + "	;age=" + age1);
		// 处理业务
		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findUserMulByNameAndAge(name, age1);

		// 跳转页面
		// request.setAttribute("userList", userList);
		// request.setAttribute("sname", name);
		// request.setAttribute("sage", age1);
		// request.getRequestDispatcher("/admin/find_multiple.jsp").forward(request,
		// response);
		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
			request.setAttribute("listUserMul_null_servlet", "没有找到符合这些要求的用户");
			System.out.println("空了");
		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
			request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("没空");
		}
		request.getRequestDispatcher("/admin/findUserByNameAndAge_Mul.jsp").forward(request,
				response);
	}

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 接收参数
//		String name = request.getParameter("hou_name");
//		String age = request.getParameter("hou_age");
//
//		Integer age1 = null;
//		if ("".equals(age)) {
//			age1 = null;
//		} else {
//			age1 = Integer.parseInt(age);
//		}
//
//		System.out.println(name + "	" + age1);
//		// 处理业务
//		UserService userService = new UserServiceImpl();
//		List<User> listUser = userService.findUserMulByNameAndAge(name, age1);
//
//		// 跳转页面
//		// request.setAttribute("userList", userList);
//		// request.setAttribute("sname", name);
//		// request.setAttribute("sage", age1);
//		// request.getRequestDispatcher("/admin/find_multiple.jsp").forward(request,
//		// response);
//		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
//			request.setAttribute("listUserMul_null_servlet", "没有找到符合这些要求的用户");
//			System.out.println("空了");
//		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
//			request.setAttribute("listUserMul_servlet", listUser);
//			System.out.println("没空");
//		}
//		request.getRequestDispatcher("/EE_7_MVC_Check/WebContent/admin/findUserByNameAndAge_Mul.jsp").forward(request,
//				response);
//
//	}

}
