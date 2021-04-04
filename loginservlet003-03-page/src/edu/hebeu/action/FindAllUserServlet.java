package edu.hebeu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hebeu.entity.User;
import edu.hebeu.service.UserService;
import edu.hebeu.service.impl.UserServiceImpl;
import edu.hebeu.util.PageBean;

/**
 * Servlet implementation class FindAllUserServlet
 */
@WebServlet("/servlet/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUserServlet() {
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
		//1接收参数
		int index=1;//当前面
		String sindex=request.getParameter("index");
		if(sindex!=null&&!"".equals(sindex)){
			index=Integer.parseInt(sindex);
		}
		//System.out.println(index);
		int size=5;//每页显示的记录数
		String ssize=request.getParameter("size");
		if(ssize!=null&&!"".equals(ssize)){
			size=Integer.parseInt(ssize);
		}
		
		//System.out.println(size);
		
		String name=request.getParameter("username");
		if(name==null){
			name="";
		}
		
		String age=request.getParameter("age");
		Integer nage=0;
		try{
			nage=Integer.parseInt(age);
		}catch(NumberFormatException e){
			
		}
		System.out.println(name+",   "+nage);
		
		
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setIndex(index);
		pageBean.setSize(size);
		
		//2调用业务层
		UserService userService=new UserServiceImpl();
		//userService.findUser(pageBean);
		userService.findUser(pageBean,name,nage);
		
		//3跳转
		//request.setAttribute("userList", user);
		request.setAttribute("pageBean", pageBean);
		
		request.setAttribute("sname", name);
		request.setAttribute("sage", age);
		
		request.getRequestDispatcher("/admin/pagefindUser.jsp").forward(request, response);
		//request.getRequestDispatcher("/admin/page.jsp").forward(request, response);
	}

}
