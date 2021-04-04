package edu.hebeu.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/myServlet/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * �û���¼Servlet
	 */
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.����ǰ̨�����Ĳ������ͻ�������Ĳ���
		String userid = request.getParameter("hou_num");
		String userpwd = request.getParameter("hou_pwd");
		String rember_flag = request.getParameter("remember");

		// 2���ж��ǲ��ǺϷ����û�
		UserService userService = new UserServiceImpl();
		User user = userService.login(userid, userpwd);

		// 3�����ش�����
		if (user != null) {// ������ǿգ����Ϸ��û�
			/*
			 * ��Ϊcookie���ܴ��ݺ��֣����Ҫ���ݺ��֣��ͱ��봦����,�Ѻ���
			 * ���cookie����ʶ��utf-8�룻����һ���˹��̱�֤�����ĵ�¼��ʵ��,��
			 * �ǲ��ܱ�֤��ס�˻���ʵ��,��Ϊ,���ص����ڵĲ�������,��utf-8����,
			 * �����Ҫʵ�ּ�ס�˺ţ���Ҫ��cookie���ص����ǰ���utf-8��������, �ο�����Ŀ��login.jspҳ��
			 */
			String cook_encoder_userid = URLEncoder.encode(userid, "utf-8");
			String cook_encoder_userpwd = URLEncoder.encode(userpwd, "utf-8");

			// 1���쿨(��¼�û���������)��������cookie
			Cookie setcook_id = new Cookie("cook_userid", cook_encoder_userid);
			Cookie setcook_pwd = new Cookie("cook_userpwd", cook_encoder_userpwd);

			// 2���趨������Ч���ڣ�����ס���(Ĭ��ֵ��������ر�֮ǰ��Ч;����ر���������Ͳ����ڼ�ס��)
			if ("yes".equals(rember_flag)) {
				setcook_id.setMaxAge(10 * 24 * 60 * 60);
				setcook_pwd.setMaxAge(10 * 24 * 60 * 60);
			} else {// ���򣬼�û��ѡ�м�ס�˻�
				setcook_id.setMaxAge(0);
				setcook_pwd.setMaxAge(0);
			}

			// 3���趨����ʹ�÷�Χ��������·��
			setcook_id.setPath("/EE_MVC_ALL/");
			setcook_pwd.setPath("/EE_MVC_ALL/");

			// 4���Ѱ�õĿ����û�����ʹ��respone���ͻ��ˣ����ڿͻ��˰���������
			response.addCookie(setcook_id);
			response.addCookie(setcook_pwd);

			// ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("sion_user", user);
			// //����ʹ��
			// request.getSession().setAttribute("sion_user", user);

			// �ض���
			response.sendRedirect(request.getContextPath() + "/admin_user/success.jsp");
		} else {// ���򣬼�Ϊ�գ����ǺϷ��û�
			request.setAttribute("login_error", "���������û���������");
			// ת��
			request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);
		}

	}

	/**
	 * �û�ע��Servlet
	 */
	public void Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("hou_id");
		String name = request.getParameter("hou_name");
		String pwd = request.getParameter("hou_pwd");
		Integer age = Integer.parseInt(request.getParameter("hou_age"));
		Double score = Double.parseDouble(request.getParameter("hou_score"));
		Date registerdate = null;
		try {
			registerdate = Date.valueOf(request.getParameter("hou_registerdate"));
		} catch (IllegalArgumentException e) {
			registerdate = null;
			System.err.println("ע�����ڸ�ʽ����,��Ĭ��Ϊnull");
			// e.printStackTrace();
		}
		String hobbies[] = request.getParameterValues("hou_hobby");

		User user = new User(id, name, pwd, age, score, registerdate, Arrays.toString(hobbies));

		UserService userService = new UserServiceImpl();
		int n=0;
		try {
			n = userService.register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (n > 0) {
			// ʹ��session�����洢��Ϣ�������ض���(��������)����Ҫ������Դʱʹ��
			request.getSession().setAttribute("session_user", user);

			//
			// request.getSession().setAttribute("session_user_num",
			// "idΪ'"+user.getNum()+"'���û�ע��ɹ�");//���ض������ʹ��
			//// //����ʹ��
			//// HttpSession httpSession = request.getSession();
			//// httpSession.setAttribute("session_user", user);
			//
			// //�ض���
			// response.sendRedirect(request.getContextPath()+"/admin/login.jsp");

			request.setAttribute("session_user_num", "idΪ'" + user.getNum() + "'���û�ע��ɹ�");// ��ת�����ʹ��
			// ת��
			request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);

		} else {
			request.setAttribute("register_error", "id�Դ���,��������һid����ע��!!");

			// ת��
			request.getRequestDispatcher("/admin_user/register.jsp").forward(request, response);
		}
	}

	/**
	 * �˳�Servlet
	 */
	public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sion_user");

		if (user != null) {
			// ʵ�����¼
			request.removeAttribute("sion_user");
			request.setAttribute("inform", "IdΪ'" + user.getNum() + "'���û��ѳɹ��˳�����");
		}
		// ת��
		request.getRequestDispatcher("/admin_user/login.jsp").forward(request, response);
	}

	/**
	 * ȫ���û���ʾServlet,ʵ���϶�����ģ����ѯServlet�����Ժ����Servlet��û������
	 */
	public void FindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findUserAll();

		request.setAttribute("listUserAll_servlet", listUser);
		request.getRequestDispatcher("/admin_user/findUser_All.jsp").forward(request, response);
	}

	/**
	 * ������ģ����ѯ�û���ʾ
	 */
	public void FindMul(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("hou_name");
		if (name == null) {// ���ֵĺϷ����ȡ���������Ƿ�Ϊ��,������if...else..Ҳ����
			name = "";
		}

		String age = request.getParameter("hou_age");
		Integer age1 = 0;// ����ĺϷ���񲻽�ȡ�����Ƿ�Ϊ�ջ��и�ʽ��ת����,���������try...catch...
		try {// ���������ǿջ���abc�Ȳ��Ϸ����ɱ��0,������ò�Ҫ��if...else....,������try...catch...
			age1 = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			System.err.println("age��������,�Ѿ�Ĭ��Ϊ0");
		}

		System.out.println("name=" + name + "	;age=" + age1);
		User user_Mul = new User();
		user_Mul.setName(name);
		user_Mul.setAge(age1);

		// ����ҵ��
		UserService userService = new UserServiceImpl();
		List<User> listUser = userService.findUserMul(user_Mul);

		// ��תҳ��
		// request.setAttribute("userList", userList);
		// request.setAttribute("sname", name);
		// request.setAttribute("sage", age1);
		// request.getRequestDispatcher("/admin/find_multiple.jsp").forward(request,
		// response);
		if (listUser == null || listUser.size() == 0) {// �ж�List<>�Ƿ�Ϊ�յķ�ʽ
			request.setAttribute("listUserMul_null_servlet", "û���ҵ�������ЩҪ����û�");
			System.out.println("����");
		} else if (listUser != null && !listUser.isEmpty()) {// �ж�List<>��Ϊ�յķ�ʽ
			request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("û��");
		}
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/admin_user/findUser_All.jsp").forward(request, response);
	}

	/**
	 * ��ȷ�����û���ϢServlet
	 */
	public void FindSingle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userNum = request.getParameter("hou_num");

		User userSingle = new User();
		userSingle.setNum(userNum);
		UserService userService = new UserServiceImpl();
		User user = userService.findUserSingle(userSingle);
		System.out.println("servlet" + userNum);
		if (user != null) {
			request.setAttribute("userSingle_servlet", user);
		} else {
			request.setAttribute("userSingle_null_servlet", "û���ҵ����û�������");
		}
		request.getRequestDispatcher("/admin_user/findUserByNum_single.jsp").forward(request, response);
	}

	/**
	 * ��ҳ��ʾȫ���û�Servlet,ʵ���ϵ���������ҳģ����ѯServlet����֮�����Servlet���Ѿ�û������
	 */
	public void FindAllPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------UserServlet��PageAll()����[");
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

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������

		// ����ҵ���
		UserService userService = new UserServiceImpl();
		userService.findUserAll(pageBean);// �����ҵ�񽻸�ҵ���

		// ��ת
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/admin_user/findUserPage.jsp").forward(request, response);
		System.out.println("]----------");
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

		String age = request.getParameter("hou_age");
		Integer age1 = 0;// ����ĺϷ���񲻽�ȡ�����Ƿ�Ϊ�ջ��и�ʽ��ת����,���������try...catch...
		try {// ���������ǿջ���abc�Ȳ��Ϸ����ɱ��0,������ò�Ҫ��if...else....,������try...catch...
			age1 = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			System.err.println("age��������,�Ѿ�Ĭ��Ϊ0");
		}

		System.out.println("name=" + name + "	;age=" + age1);
		User user_MulPage = new User();
		user_MulPage.setName(name);
		user_MulPage.setAge(age1);
		System.out.println("user_MulPage=" + user_MulPage);

		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setIndex(index); // ��1������
		pageBean.setSize(size); // ��2������

		// ����ҵ���
		UserService userService = new UserServiceImpl();
		userService.findUserAll(user_MulPage, pageBean);// �����ҵ�񽻸�ҵ���

		// �ж��Ƿ�Ϊ��
		UserService userService2 = new UserServiceImpl();
		List<User> listUser = userService2.findUserMul(user_MulPage);
		if (listUser == null || listUser.size() == 0) {// �ж�List<>�Ƿ�Ϊ�յķ�ʽ
			request.setAttribute("PageUserMul_null_servlet", "û���ҵ�������ЩҪ����û�");
			System.out.println("����");
		} else if (listUser != null && !listUser.isEmpty()) {// �ж�List<>��Ϊ�յķ�ʽ
			// request.setAttribute("listUserMul_servlet", listUser);
			System.out.println("û��");
		}
		// ��ת
		// request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/admin_user/findUserPage.jsp").forward(request, response);
		System.out.println("]----------");
	}

	public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("qian_id");

		UserService userService = new UserServiceImpl();
		int n = 0;
		try {
			n = userService.deleteUser(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("deleteUser����������!!!");
		}

		// ��ת����һ��Servlet
		if(n>0){//ɾ���ɹ�
			request.getRequestDispatcher("/myServlet/UserServlet?method=FindMulPage").forward(request, response);// ת��
		}
		else{//����ɾ��ʧ��
			request.getRequestDispatcher("/admin_user/error.jsp").forward(request, response);// ת��
		}

	}
}
