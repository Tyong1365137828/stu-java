package edu.hebeu.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**1.BaseServlet不需要进行配置，是来被继承的
 * 2.BaseServlet可以定义成抽象类，只能被继承，不能直接调用
 * Servlet implementation class BaseServlet
 */
//@WebServlet("/BaseServlet")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//1.解决中文乱码问题
    			request.setCharacterEncoding("utf-8");
    			//2.获取方法名
    			String methodName=request.getParameter("method");
    			//System.out.println(methodName+"   "+this);
    			//3.根据方法名，调用相应的方法----使用反射
    			try {
    				//3.1得到class信息 
    				Class clazz=this.getClass();
    				//3.2创建对象
    				Object obj=clazz.newInstance();
    				//3.3获取方法
    				//Method method=clazz.getMethod(methodName, request.getClass(),response.getClass());
    				Method method=clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
    				//3.4调用方法
    				method.invoke(obj, request,response);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1.解决中文乱码问题
//		request.setCharacterEncoding("utf-8");
//		//2.获取方法名
//		String methodName=request.getParameter("method");
//		//3.根据方法名，调用相应的方法----使用反射
//		try {
//			//3.1得到class信息 
//			Class clazz=this.getClass();
//			//3.2创建对象
//			Object obj=clazz.newInstance();
//			//3.3获取方法
//			//Method method=clazz.getMethod(methodName, request.getClass(),response.getClass());
//			Method method=clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
//			//3.4调用方法
//			method.invoke(obj, request,response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}
