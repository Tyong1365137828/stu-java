package edu.hebeu.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.Items;
import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.service.ItemsService;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.ItemsServiceImpl;
import edu.hebeu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/myServlet/Admin")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * ����Ա��¼
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����������post��ʽ�������������
				request.setCharacterEncoding("utf-8");
				
				// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
				String num = request.getParameter("hou_num");
				String pwd = request.getParameter("hou_pwd");
				
				//2���ж��ǲ��ǺϷ����û�
				if(num.equals("1365137828")&&pwd.equals("0727316052")){
					//4���Ѱ�õĿ����û�����ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
					
					//ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("sion_adm", num);
					
					//�ض���
					response.sendRedirect(request.getContextPath()+"/admin/success.jsp");
				}else{//���򣬼�Ϊ�գ����ǺϷ��û�
					request.setAttribute("login_error", "���������û���������");
					//ת��
					request.getRequestDispatcher("/admin/NewFile.jsp").forward(request, response);
				}
	}
	
	/**
	 * ͨ��codeչʾ��Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProductView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		ItemsService itemsService = new ItemsServiceImpl();
		
		Items items = new Items();
		items.setCode(code);
		
		Items items2= new Items();
		try {
			items2 = itemsService.showProduceByCode(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("showitems", items2);
		request.getRequestDispatcher("/admin/items_show.jsp").forward(request, response);
		
	}
	
	
	/**
	 * ģ��չʾ��Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SelectProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("proname");
		Items items2 = new Items();
		items2.setName(name);
		
		ItemsService itemsService = new ItemsServiceImpl();
		List<Items> list = null;
		try {
			list =itemsService.showProduce(items2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("name="+name);
		System.out.println("items2"+items2);
		System.out.println("ģ����ƷͼƬlist="+list);
		
		request.setAttribute("itemslist", list);
		request.getRequestDispatcher("/product_all.jsp").forward(request, response);
	}
	
	
	/**
	 * ����Ա�޸��û���Ϣ�Ĳ���ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PreUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("PreUpdateUser������ʼ������");
		String account = request.getParameter("hou_account");
		User user = new User();
		user.setAccount(account);
		
		UserCustom userCustom = new UserCustom() ;	//������չ��
		
		UserService userService = new UserServiceImpl();
		try {
			userCustom = userService.personinform(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	//ת��Ϊyyyy-mm-dd
		String dateString = formatter.format(userCustom.getBirthday());	//ת��
		
		request.getSession().setAttribute("exactuser", userCustom);
		request.getSession().setAttribute("exactuserdate", dateString);
		
		request.getRequestDispatcher("/admin/user_update.jsp").forward(request, response);
	}
	
	
	/**
	 * ����Ա�޸��û���Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("UpdateUser������ʼ������");
		String account = request.getParameter("hou_account");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		String sex = request.getParameter("sex");
		String address = request.getParameter("hou_address");
		String tel = request.getParameter("hou_tel");
		Date birthday = null;
		
		try {
			birthday = Date.valueOf(request.getParameter("hou_birthday"));
		} catch (IllegalArgumentException e) {
			birthday = null;
			System.err.println("ע�����ڸ�ʽ����,��Ĭ��Ϊnull");
			// e.printStackTrace();
		}
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		UserService userService = new UserServiceImpl();
		int n = 0;
		
		try {
			n=userService.updateuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.err.println("n===="+n);
		System.out.println("updateUser="+user);
		if(n>0){//�޸ĳɹ�
			request.getRequestDispatcher("/myServlet/Admin?method=PreUpdateUser&hou_account="+user.getAccount()).forward(request, response);
		}else{
			request.getRequestDispatcher("/myServlet/Admin?method=PreUpdateUser&hou_account="+user.getAccount()).forward(request, response);
		}
	}
	
	
	/**
	 * ע���û�Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_account");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		String sex = request.getParameter("hou_sex");
		String address = request.getParameter("hou_address");
		String tel = request.getParameter("hou_tel");
		Date birthday = null;
		
		try {
			birthday = Date.valueOf(request.getParameter("hou_birthday"));
		} catch (IllegalArgumentException e) {
			birthday = null;
			System.err.println("ע�����ڸ�ʽ����,��Ĭ��Ϊnull");
			// e.printStackTrace();
		}
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		UserService userService = new UserServiceImpl();
		
		int n = 0;
		
			try {
				n = userService.register(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				System.err.println(account+"�û�ע��ʧ�ܣ�����");
//				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.err.println(account+"�û�ע��ʧ�ܣ�����");
			}
			System.out.println("n="+n);
			System.out.println("User="+user);
			System.out.println("n="+n);
	
		if(n>0){	//��ע��ɹ�
			request.getSession().setAttribute("session_user", user);
			request.setAttribute("session_register", "accountΪ"+user.getAccount()+"���û�,����ӳɹ�������");
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response);	//ת��
			
		}else if(n<=0){	//�����ɹ�
			request.setAttribute("register_error", user.getAccount()+"�˺����ʧ�ܣ���");
			request.getRequestDispatcher("/admin/user_add.jsp").forward(request, response); //ת��
		}
		
	}
	
	/**
	 * ����Ա�˳�
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.removeAttribute("sion_adm");
		// ת��
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
  
    

}
