package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/myServlet/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// ����������post��ʽ�������������
		request.setCharacterEncoding("utf-8");
		
		// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");
		
		//2���ж��ǲ��ǺϷ����û�
		UserService userService = new UserServiceImpl();
		User user = userService.login(userid, userpwd);
		
		// 3�����ش�����
		if(user != null){//������ǿգ����Ϸ��û�
			/*��Ϊcookie���ܴ��ݺ��֣����Ҫ���ݺ��֣��ͱ��봦����,�Ѻ���
			���cookie����ʶ��utf-8�룻����һ���˹��̱�֤�����ĵ�¼��ʵ��,��
			�ǲ��ܱ�֤��ס�˻���ʵ��,��Ϊ,���ص����ڵĲ�������,��utf-8����,
			�����Ҫʵ�ּ�ס�˺ţ���Ҫ��cookie���ص����ǰ���utf-8��������,
			�ο�����Ŀ��login.jspҳ��*/
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");
			
			//1���쿨(��¼�û���������)��������cookie
			Cookie setcook_id = new Cookie("cook_id",cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_pwd",cook_encoder_userpwd);
			
			//2���趨������Ч���ڣ�����ס���(Ĭ��ֵ��������ر�֮ǰ��Ч;����ر���������Ͳ����ڼ�ס��)
			if("yes".equals(rember_flag)){
				setcook_id.setMaxAge(10*24*60*60);
				setcook_pwd.setMaxAge(10*24*60*60);
			}else{//���򣬼�û��ѡ�м�ס�˻�
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}
			
			//3���趨����ʹ�÷�Χ��������·��
			setcook_id.setPath("/EE_6_MVC_register/");
			setcook_pwd.setPath("/EE_6_MVC_register/");
			
			//4���Ѱ�õĿ����û�����ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);
			
			//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", user);
//			//����ʹ��
//			request.getSession().setAttribute("sion_user", user);
			
			//�ض���
			response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
		}else{//���򣬼�Ϊ�գ����ǺϷ��û�
			request.setAttribute("login_error", "���������û���������");
			//ת��
			request.getRequestDispatcher("/admin/login2.jsp").forward(request, response);
		}
		
	}

}
