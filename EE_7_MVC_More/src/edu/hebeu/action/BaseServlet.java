package edu.hebeu.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码请求格式,解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		// 2.获取方法名
		String methodName = request.getParameter("method");
		System.out.println("methodName=" + methodName + "   this=" + this);
		// 3.根据方法名，调用相应的方法----使用反射
		try {
			// 3.1得到class信息
			Class<? extends BaseServlet> clazz = this.getClass();// 这里的this指的是继承BaseServlet对象
			// 3.2创建对象
			Object obj = clazz.newInstance();
			// 3.3获取方法
			// Method method=clazz.getMethod(methodName, request.getClass(),response.getClass());
			Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			// 3.4调用方法,让方法执行
			method.invoke(obj, request, response);
			// 或者直接method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()方法");
		service(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()方法");
		service(request,response);
	}

	// protected void service(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException ,IOException{
	//
	// }

}
