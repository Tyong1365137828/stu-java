package hebeu.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.*;
/**
 * �û��˳�Servlet
 * 
 * @author 
 */
@WebServlet("/servlet/UserExitServlet")
public class UserExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1599366365079846238L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡsession
		HttpSession session = request.getSession();
		// ��ȡ�û�����
		User user = (User)session.getAttribute("user");
		// �ж��û��Ƿ���Ч
		if(user != null){
			// ��һ�ַ�ʽ�����û��������session(ֻ��session������ɾ���ˣ�id�Ż�����)
			session.removeAttribute("user");
			
			// ������ʾ��Ϣ
			request.setAttribute("info", user.getUsename() + " �ѳɹ��˳���");
			
			//�ڶ��ַ�ʽ��ɾ��������Ϣ������id��
			//session.invalidate();
		}
		// ת����message.jspҳ��
		request.getRequestDispatcher("/admin3/login.jsp").forward(request, response);
	}

}
