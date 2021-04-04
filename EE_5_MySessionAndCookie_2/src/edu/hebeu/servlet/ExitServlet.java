package edu.hebeu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.Student;

/**
 * Servlet implementation class ExitServlet
 */
@WebServlet("/myServlet/Exit")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取Session
		HttpSession session = request.getSession();
		//获取学生对象
		Student student = (Student) session.getAttribute("sionstu");
		//
		if(student != null){
			//这种方式用来实现退出后免登录
			request.removeAttribute("sionstu");
			//提示信息
			request.setAttribute("inform", "Id为'"+student.getId()+"'的用户已成功退出！！");
			
			//这种方式会删掉所有信息，相当于注销卡
//			session.invalidate();
		}
		//转发
		request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
