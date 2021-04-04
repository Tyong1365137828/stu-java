package edu.hebeu.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/myServlet/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("hou_num");
		String name=request.getParameter("hou_name");
		String pwd=request.getParameter("hou_passwrod");
		Integer age=Integer.parseInt(request.getParameter("hou_age"));
		Double score=Double.parseDouble(request.getParameter("hou_score"));
		Date registerdate=Date.valueOf(request.getParameter("hou_registerdate"));
		String hobbies[]=request.getParameterValues("hou_hobby");
		
		User user = new User(id,name,pwd,age,score,registerdate,Arrays.toString(hobbies));
		System.out.println(user);
		UserService  userService = new UserServiceImpl();
		int n = 0 ;
		try {
			n = userService.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("updateUser方法有问题!!!");
		}
		
		if(n>0){
			request.getRequestDispatcher("/myServlet/findUserAllServlet").forward(request, response);
		}else{
			request.setAttribute("update_error", "修改失败");
			System.err.println("n等于0,无法删除!!!");
			request.getRequestDispatcher("/myServlet/PreUpdateUserServlet?qian_id="+id).forward(request, response);
		}
	}

}
