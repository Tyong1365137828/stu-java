package edu.hebeu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.daoimpl.StudentDaoImpl;
import edu.hebeu.po.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/servlet/LoginServlet")//ע�����from action����ͬ
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������post��ʽ
		request.setCharacterEncoding("utf-8");

		
		// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
		String stuid = request.getParameter("hid");
		String stupwd = request.getParameter("hpwd");
	
		//2���ж��ǲ��ǺϷ����û�
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("���Ƕϵ�");
		Student student = studentDaoImpl.findIdByPassword(stuid,stupwd);
	
		System.out.println(student);//��Student����String toString����,���Կ���ֱ������˶���

		// 3�����ش�����
		if(student != null) {//������ǿգ����Ϸ��û�
			
//			request.setAttribute("hid", stuid);/*��hid�����ǩ����stuid��ֵ(��)��
//												��ǰ̨��ʾʹ�ã������������Ǵ���ģ�
//												ǰ̨��ֵ�ǿյģ���������ʾ��hid��stuid��
//												ֵ(��hid���԰�ֵ��stuid������ͬ���ķ�����
//												stuidȴ���ܰѸղŵ�ֵ��hid��������Ϊ���ǲ�
//												��ͬһ����(�������Ŀ��������λ��2��3����)��������Դ������)��
//												��ô��Ҫ��ǰ̨��ʾ�ͱ�����session������
//												��2֮��3֮ǰ����session��������3��ʹ��session��
//												ʹ2��3������Դ�����ﵽǰ̨��ʾ��Ч��
//												*/
			
			//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sionstu", student);//���Դ���󣬱����ȵȣ���ŷ�ʽΪ��ֵ��(������--ֵ)�ķ�ʽ���൱��MAP��ʽ������ͬ��list��set�ȷ�ʽ
			
			//�ض���
			response.sendRedirect(request.getContextPath()+"/admin3/success.jsp");
			
		}else {//���򣬼�Ϊ�գ����ǺϷ��û�
			
			//ת������һ����������ɣ�����session����Ҳ����
			request.setAttribute("error", "����û���������������������룡");
			request.getRequestDispatcher("/admin3/login.jsp").forward(request, response);
		}

	}

}
