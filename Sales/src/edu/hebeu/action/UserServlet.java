package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.po.User;
import edu.hebeu.po.UserCustom;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/myServlet/User")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * �û���¼Servlet
	 * @throws Exception 
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
		System.err.println("dbfxsdvbhjasghvasghvaSHGJAWSVGHHBJASXHJASHJBkjbsdhjbsdch");
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");

		// 2���ж��ǲ��ǺϷ����û�
		UserService userService = new UserServiceImpl();
		
		UserCustom userCustom= null;
		try {
			userCustom = userService.login(userid, userpwd);
		} catch (Exception e) {
			System.err.println("�û�"+userid+"��¼ʧ��");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		// 3�����ش�����
		if (userCustom != null) {// �ж��������������ǿգ����Ϸ��û�
			
			/*
			 * ��Ϊcookie���ܴ��ݺ��֣����Ҫ���ݺ��֣��ͱ��봦����
			 */
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");

			// ������cookie
			Cookie setcook_id = new Cookie("cook_userid", cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_userpwd", cook_encoder_userpwd);

			// �趨��Ч���ڣ�����ס���(Ĭ��ֵ��������ر�֮ǰ��Ч;����ر���������Ͳ����ڼ�ס��)
			if ("yes".equals(rember_flag)) {
				setcook_id.setMaxAge(10 * 24 * 60 * 60);
				setcook_pwd.setMaxAge(10 * 24 * 60 * 60);
			} else {// ���򣬼�û��ѡ�м�ס�˻�
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}

			// 3���趨ʹ�÷�Χ��������·��
			setcook_id.setPath("/Sales/");
			setcook_pwd.setPath("/Sales/");

			//ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);

			// ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", userCustom);
			// //����ʹ��
			// request.getSession().setAttribute("sion_user", user);

			// �ض���
//			response.sendRedirect(request.getContextPath() + "/product_all.jsp");
			request.getRequestDispatcher("/myServlet/Items?method=ViewAllProduce").forward(request, response);
			
		} else {// ���򣬼�Ϊ�գ����ǺϷ��û�
			request.setAttribute("login_error", "���������û���������");
			// ת��
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}

	}
	
	/**
	 * ��ѯ�û��������Ʒ,��ҳ��ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UserBuyItemsForCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ղ���
		
		String account = request.getParameter("hou_account");
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount(account);
		
		int index = 1;// ��ǰҳ,Ĭ��1
		String sindex = request.getParameter("index");// ����ǰ̨�����Ĳ���,��Ӧ�ĵڼ�ҳ
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// ��ֵ����ǰҳ
		}

		int size = 1;// ��ǰÿҳ�ļ�¼��,Ĭ��1
		String ssize = request.getParameter("size");// ����ǰ̨�����Ĳ���,��Ӧÿҳ�ļ�¼��
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// ��ֵ����ǰÿҳ�ļ�¼��
		}

		System.out.println("��ǰҳ��:" + index);
		System.out.println("��ǰÿҳ�ļ�¼����:" + size);

		PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������
		
		UserService userService = new UserServiceImpl();
		try {
			userService.finduserbuyitems(userCustom, pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("buy_items", pageBean);
		request.getRequestDispatcher("/user/show_buyitems.jsp").forward(request, response);
		
	}
	
	/**
	 * ��ѯ�û��������Ʒ,һҳ��ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void UserBuyItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_account");
		
		UserCustom userCustom = new UserCustom();
		userCustom.setAccount(account);
		
		UserService userService = new UserServiceImpl();
		List<UserCustom> list = null;
		try {
			list = userService.findUserBuyItems(userCustom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("buy_items", list);
		request.getRequestDispatcher("").forward(request, response);
		
		
	}
	
	/**
	 * ɾ���û���Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("hou_account");

		UserService userService = new UserServiceImpl();
		int n = 0;
		User user = new User();
		user.setAccount(userid);
		try {
			n = userService.deleteuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ��ת����һ��Servlet
		if(n>0){//ɾ���ɹ�
			request.setAttribute("delete_success", user.getAccount()+"ɾ���ɹ�");
			request.getRequestDispatcher("/myServlet/User?method=FindMulPage").forward(request, response);// ת��
		}
		else{//����ɾ��ʧ��
			request.setAttribute("delete_error", user.getAccount()+"ɾ��ʧ��");
			request.getRequestDispatcher("/admin/userr.jsp").forward(request, response);// ת��
		}

	}
	
	/**
	 * ע���û�Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("hou_id");
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
	
		if(n>0){	//��ע��ɹ�
			request.getSession().setAttribute("session_user", user);
			request.setAttribute("session_register", "accountΪ"+user.getAccount()+"���û�,����ע��ɹ�������");
			request.getRequestDispatcher("/user/perfect.jsp").forward(request, response);	//ת��
			
		}else if(n<=0){	//�����ɹ�
			request.setAttribute("register_error", "�˺��Ѿ�����,������ע�ᣡ��");
			request.getRequestDispatcher("/user/register.jsp").forward(request, response); //ת��
		}
		
	}
	
	/**
	 * ע��������Ϣ���Ƶ�ҳ���servlet
	 * ���᷵������¼��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PerfectInform(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
		System.out.println("account="+account);
		
		User user = new User(account,pwd,name,birthday,sex,address,tel);	
		System.out.println("user="+user);
		UserService userService = new UserServiceImpl();
		
		try {
			userService.updateuser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user="+user);
		
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}
	
	/**
	 * Ԥ�޸ĵ�servlet�����ڽ�personinform.jsp��ֵ����update.jspҳ��
	 * �������ﲻ�ö�������ʽ�ж���ȷ���
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
		
		request.getRequestDispatcher("/user/update.jsp").forward(request, response);
		
	}

	/**
	 * �޸��û���ϢServlet
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
			request.getRequestDispatcher("/myServlet/User?method=FindUserExact&hou_id="+user.getAccount()).forward(request, response);
		}else{
			request.getRequestDispatcher("/myServlet/User?method=PreUpdateUser&hou_id="+user.getAccount()).forward(request, response);
		}
	}
	
	/**
	 * ��account��ȷ��ѯ�û�,������������ʾ�ڸ�����Ϣҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void FindUserExact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("ascadcahjscghAHghjaGHAXSVGHASXHJASHJ");
		String account = request.getParameter("hou_id");
		
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
		request.getRequestDispatcher("/user/personinform.jsp").forward(request, response);
		
	}
	
	/**
	 * ���ﳵServlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ShopSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    
	/**
	 * ��ҳ��ʾȫ���û�Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void PageViewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ղ���
				int index = 1;// ��ǰҳ,Ĭ��1
				String sindex = request.getParameter("index");// ����ǰ̨�����Ĳ���,��Ӧ�ĵڼ�ҳ
				if (sindex != null && !"".equals(sindex)) {
					index = Integer.parseInt(sindex);// ��ֵ����ǰҳ
				}

				int size = 4;// ��ǰÿҳ�ļ�¼��,Ĭ��4
				String ssize = request.getParameter("size");// ����ǰ̨�����Ĳ���,��Ӧÿҳ�ļ�¼��
				if (ssize != null && !"".equals(ssize)) {
					size = Integer.parseInt(ssize);// ��ֵ����ǰÿҳ�ļ�¼��
				}

				System.out.println("��ǰҳ��:" + index);
				System.out.println("��ǰÿҳ�ļ�¼����:" + size);

				PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
				pageBean.setIndex(index); // ��1������
				pageBean.setSize(size); // ��2������
				
				UserService userService = new UserServiceImpl();
				
				try {
					userService.findalluser(pageBean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().setAttribute("userlist", pageBean);
				request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
				
	}
	
	/**
	 * ������ģ����ѯ�û���ҳ��ʾServlet
	 */
	public void FindMulPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ղ���
		int index = 1;// ��ǰҳ,Ĭ��1
		String sindex = request.getParameter("index");// ����ǰ̨�����Ĳ���,��Ӧ�ĵڼ�ҳ
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);// ��ֵ����ǰҳ
		}

		int size = 5;// ��ǰÿҳ�ļ�¼��,Ĭ��5
		String ssize = request.getParameter("size");// ����ǰ̨�����Ĳ���,��Ӧÿҳ�ļ�¼��
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);// ��ֵ����ǰÿҳ�ļ�¼��
		}

		System.out.println("��ǰҳ��:" + index);
		System.out.println("��ǰÿҳ�ļ�¼����:" + size);

		String name = request.getParameter("hou_name");
		System.out.println("name=" + name);
		if (name == null) {
			name = "";
		}

		System.out.println("name=" + name);
		UserCustom user_MulPage = new UserCustom();
		user_MulPage.setName(name);
		System.out.println("user_MulPage=" + user_MulPage);
		
		PageBean<UserCustom> pageBean = new PageBean<UserCustom>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������
		
		// ����ҵ���
		UserService userService = new UserServiceImpl();
		try {
			userService.findalluser(user_MulPage, pageBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserService userService2 = new UserServiceImpl();
		List<UserCustom> listUser = null;
		try {
			listUser = userService2.findsermul(user_MulPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listUser == null || listUser.size() == 0) {// �ж�List<>�Ƿ�Ϊ�յķ�ʽ
			request.setAttribute("PageUserMul_null_servlet", "û���ҵ�������ЩҪ����û�");
			System.out.println("����");
		} else if (listUser != null && !listUser.isEmpty()) {// �ж�List<>��Ϊ�յķ�ʽ
			// request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("û��");
		}
		
		// ��ת
		// request.setAttribute("userList", user);
		request.setAttribute("name", name);
		
		request.getSession().setAttribute("userlist", pageBean);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
		System.out.println("]----------");
		
	}
	
	
	
	/**
	 * �˳�Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.removeAttribute("sion_user");
		// ת��
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
}
