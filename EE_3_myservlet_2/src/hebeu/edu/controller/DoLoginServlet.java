package hebeu.edu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*��̨������Դ�ķ�����
 * 
 * ��servlet��ת���Ǹ�ҳ��
*/

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/servlet/DoLogin2")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
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
		//post�ύ��ʽ����������Ľ������
		request.setCharacterEncoding("utf-8");
		
		//1�����տͻ���--ǰ̨�����Ĳ���
		String name=request.getParameter("username");//�û�����ֵ,ע��:Parameter�ڵ�ֵ��login.jsp�ļ����name(�������)����һ��
		String pwd=request.getParameter("userpasswd");//�û�������
		System.out.println(name+"  "+pwd);

		//2����֤�ǲ��ǺϷ��û�(�������ݿ�jdbc���ӿڷ�����֤������user!=null)
		boolean flag=false;
		if((name.indexOf("ty"))>=0&&pwd.equals("1234567")){//�û�������ty��������1234567
			flag=true;
		}
		
		//3�����������ظ��û���������û����򷵻���ҳ;���򣬷��ص�¼ҳ��
		if(flag){//���flag����
			//out.println("��¼�ɹ�!!!");
			
			//ת��(û�в����µ��������ݹ���ֻ���ڱ�����������Դ���ط��ʣ����ܽ����ͬ����������Դ��������)
			request.setAttribute("loginSuccess��test", name);//ע����loginSuccess.jspҳ����Ⱥ�˳����loginSuccess.jsp�Żḳ�ϴ�ֵ
			request.getRequestDispatcher("/admin/loginSuccess.jsp").forward(request, response);
			
//			�ض�����������վ���ܹ������ͬ����������Դ��������
//			response.sendRedirect("http://www.hebeu.edu.cn/index.html");
		}else{//���flag�Ǽ�
			//out.println("��¼ʧ��!!!");
			//ת��
			request.setAttribute("login��test", "ת���Ṳ�����ݣ�����");//ע����login.jspҳ����Ⱥ�˳����login.jsp֮ǰ�Żḳ�ϴ�ֵ
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			
		}
		//������Դ��һ����ǰ̨���ʣ���һ�����̨����---��ת
		
	}

}
