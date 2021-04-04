package edu.hebeu.action;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/myServlet/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String id=request.getParameter("hou_id");
		String name=request.getParameter("hou_name");
		String pwd=request.getParameter("hou_pwd");
		Integer age=Integer.parseInt(request.getParameter("hou_age"));
		Double score=Double.parseDouble(request.getParameter("hou_score"));
		Date registerdate= null;
		try{
			registerdate = Date.valueOf(request.getParameter("hou_registerdate"));
		}catch(IllegalArgumentException e){
			registerdate = null;
			System.err.println("ע�����ڸ�ʽ����,��Ĭ��Ϊnull");
//			e.printStackTrace();
		}
		String hobbies[]=request.getParameterValues("hou_hobby");
		
		User user = new User(id,name,pwd,age,score,registerdate,Arrays.toString(hobbies));
		
		UserService userService =new UserServiceImpl();
		int n = 0;
		try {
			n = userService.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(n>0){
			//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			request.getSession().setAttribute("session_user", user);
			
//			
//			request.getSession().setAttribute("session_user_num", "idΪ'"+user.getNum()+"'���û�ע��ɹ�");//���ض������ʹ��
////			//����ʹ��
////			HttpSession httpSession = request.getSession();
////			httpSession.setAttribute("session_user", user);
//			
//			//�ض���
//			response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			
			request.setAttribute("session_user_num", "idΪ'"+user.getNum()+"'���û�ע��ɹ�");//��ת�����ʹ��
			//ת��
			request.getRequestDispatcher("/admin/login2.jsp").forward(request, response);
			
		}else{
			request.setAttribute("register_error", "id�Դ���,��������һid����ע��!!");
			
			//ת��
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
		}
	}
}
