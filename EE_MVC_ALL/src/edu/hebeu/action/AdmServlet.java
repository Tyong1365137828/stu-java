package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.entity.Administrator;
import edu.hebeu.service.AdmService;
import edu.hebeu.service.impl.AdmServiceImpl;

/**
 * Servlet implementation class AdmServlet
 */
@WebServlet("/myServlet/AdmServlet")
public class AdmServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * ����Ա��¼
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����������post��ʽ�������������
				request.setCharacterEncoding("utf-8");
				
				// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
				String num = request.getParameter("hou_num");
				String pwd = request.getParameter("hou_pwd");
				String rember_flag = request.getParameter("remember");
				
				//2���ж��ǲ��ǺϷ����û�
				AdmService admService = new AdmServiceImpl();
				Administrator administrator = admService.login(num, pwd);
				
				// 3�����ش�����
				if(administrator != null){//������ǿգ����Ϸ�����Ա
					/*��Ϊcookie���ܴ��ݺ��֣����Ҫ���ݺ��֣��ͱ��봦����,�Ѻ���
					���cookie����ʶ��utf-8�룻����һ���˹��̱�֤�����ĵ�¼��ʵ��,��
					�ǲ��ܱ�֤��ס�˻���ʵ��,��Ϊ,���ص����ڵĲ�������,��utf-8����,
					�����Ҫʵ�ּ�ס�˺ţ���Ҫ��cookie���ص����ǰ���utf-8��������,
					�ο�����Ŀ��login.jspҳ��*/
					String cook_encoder_num = URLEncoder.encode(num, "utf-8");
					String cook_encoder_pwd = URLEncoder.encode(pwd, "utf-8");
					
					//1���쿨(��¼�û���������)��������cookie
					Cookie setcook_id = new Cookie("cook_id",cook_encoder_num);
					Cookie setcook_pwd = new Cookie("cook_pwd",cook_encoder_pwd);
					
					//2���趨������Ч���ڣ�����ס���(Ĭ��ֵ��������ر�֮ǰ��Ч;����ر���������Ͳ����ڼ�ס��)
					if("yes".equals(rember_flag)){
						setcook_id.setMaxAge(10*24*60*60);
						setcook_pwd.setMaxAge(10);
					}else{//���򣬼�û��ѡ�м�ס�˻�
						setcook_id.setMaxAge(0);
						setcook_pwd.setMaxAge(0);
					}
					
					//3���趨����ʹ�÷�Χ��������·��
					setcook_id.setPath("/EE_MVC_ALL/");
					setcook_pwd.setPath("/EE_MVC_ALL/");
					
					//4���Ѱ�õĿ����û�����ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
					response.addCookie(setcook_id);
					response.addCookie(setcook_pwd);
					
					//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("sion_adm", administrator);
//					//����ʹ��
//					request.getSession().setAttribute("sion_adm", administrator);
					
					//�ض���
					response.sendRedirect(request.getContextPath()+"/admin_adm/success.jsp");
				}else{//���򣬼�Ϊ�գ����ǺϷ��û�
					request.setAttribute("login_error", "���������û���������");
					//ת��
					request.getRequestDispatcher("/admin_adm/login.jsp").forward(request, response);
				}
	}
	
	/**
	 * ����Ա�˳�
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrator administrator = (Administrator) session.getAttribute("sion_adm");

		if (administrator != null) {
			// ʵ�����¼
			request.removeAttribute("sion_adm");//�˳�֮ǰ��Session������
			request.setAttribute("inform", "IdΪ'" + administrator.getNum() + "'�Ĺ���Ա�ѳɹ��˳�����");
		}
		// ת��
		request.getRequestDispatcher("/admin_adm/login.jsp").forward(request, response);
	}
    
}
