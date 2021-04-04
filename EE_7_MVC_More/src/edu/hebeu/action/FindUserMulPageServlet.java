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
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class FindUserMulPageServlet
 */
@WebServlet("/myServlet/FindUserMulPageServlet")
public class FindUserMulPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserMulPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------UserServlet的PageAll()方法[");
		
		request.setCharacterEncoding("utf-8");
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

		String name = request.getParameter("hou_name");
		System.out.println("name="+name);
		if(name == null){
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
		
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // 第1个参数
		pageBean.setSize(size); // 第2个参数

		// 调用业务层
		UserService userService = new UserServiceImpl();
		userService.findUserAll(name,age1,pageBean);// 更多的业务交给业务层

		//判断是否为空
		UserService userService2 = new UserServiceImpl();
		List<User> listUser = userService2.findUserMulByNameAndAge(name, age1);
		if (listUser == null || listUser.size() == 0) {// 判断List<>是否为空的方式
			request.setAttribute("PageUserMul_null_servlet", "没有找到符合这些要求的用户");
			System.out.println("空了");
		} else if (listUser != null && !listUser.isEmpty()) {// 判断List<>不为空的方式
//			request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("没空");
		}
		// 跳转
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/admin/findUserPage_Mul.jsp").forward(request, response);
		System.out.println("]----------");
	}

}
