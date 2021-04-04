package edu.hebeu.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.dao.impl.StudentDaoImpl;
import edu.hebeu.po.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/myServlet/Login")//ע�����from action����ͬ
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
		doPost(request,response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������post��ʽ�������������
		request.setCharacterEncoding("utf-8");

		
		// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
		String stuid = request.getParameter("hid");
		String stupwd = request.getParameter("hpwd");
		String rember_flag = request.getParameter("rember");
	
		//2���ж��ǲ��ǺϷ����û�
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		System.out.println("���Ƕϵ�");
		Student student = studentDaoImpl.findIdByPassword(stuid,stupwd);
	
		System.out.println(student);//��Student����String toString����,���Կ���ֱ������˶���

		// 3�����ش�����
		if(student != null) {//������ǿգ����Ϸ��û�
			
			/*��Ϊcookie���ܴ��ݺ��֣����Ҫ���ݺ��֣��ͱ��봦����,�Ѻ���
			���cookie����ʶ��utf-8�룻����һ���˹��̱�֤�����ĵ�¼��ʵ��,��
			�ǲ��ܱ�֤��ס�˻���ʵ��,��Ϊ,���ص����ڵĲ�������,��utf-8����,
			�����Ҫʵ�ּ�ס�˺ţ���Ҫ��cookie���ص����ǰ���utf-8��������,
			�ο�����Ŀ��login.jspҳ��*/
			String cook_encoder_stuid=URLEncoder.encode(stuid, "utf-8");
			String cook_encoder_stupwd=URLEncoder.encode(stupwd, "utf-8");
			
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
			
			//cookie�����ɲ���
			//1���쿨(��¼�û���������)��������cookie
			Cookie setcook_id  = new Cookie("cookid", cook_encoder_stuid);//�û���
			Cookie setcook_pwd  = new Cookie("cookpwd", cook_encoder_stupwd);//����
			
			//2���趨������Ч���ڣ�����ס���(Ĭ��ֵ��������ر�֮ǰ��Ч;����ر���������Ͳ����ڼ�ס��)
			if("yes".equals(rember_flag)){//���rember_flag����yes����rember��ֵҲ��yes���ʿ�֪�ͻ���ѡ���˼�ס�˺�
				setcook_id.setMaxAge(10*24*60*60);//ʮ��������ˣ���λ����
				setcook_pwd.setMaxAge(10);//ʮ���������
			}else{//���򣬼�û��ѡ�м�ס�˻�
				setcook_id.setMaxAge(0);//
				setcook_pwd.setMaxAge(0);
			}
//			
			//3���趨����ʹ�÷�Χ��������·��
			setcook_id.setPath("/EE_5_MySessionAndCookie_2/");//���ô�cookie������Ϊ"/5_MySessionAndCookie_2/"��Ŀ�µ�����
			setcook_pwd.setPath("/EE_5_MySessionAndCookie_2/");
//			setcook_id.setPath("/");//���ô�cookie������Ϊ��ǰ�������ϵ�������Դ
//			setcook_id.setDomain("cn.com");//���ô�cookie����Ϊ"cn.com",���������Ա����cookie��ʹ�ã������cookieʹ��һ���򣬱Ƚ�����
			
			//4���Ѱ�õĿ����û�����ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
			response.addCookie(setcook_id);//���ͻ���id
			response.addCookie(setcook_pwd);//���ͻ�������
			
			//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
//			//����ʹ��
//			request.getSession().setAttribute("sionstu", student);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sionstu", student);//���Դ���󣬱����ȵȣ���ŷ�ʽΪ��ֵ��(������--ֵ)�ķ�ʽ���൱��MAP��ʽ������ͬ��list��set�ȷ�ʽ
			
			//�ض���
			response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
			
		}else {//���򣬼�Ϊ�գ����ǺϷ��û�
			
			//ת������һ����������ɣ�����session����Ҳ����
			request.setAttribute("login_error", "����û���������������������룡");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}

	}

}
