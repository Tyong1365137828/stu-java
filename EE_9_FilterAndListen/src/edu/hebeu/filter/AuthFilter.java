package edu.hebeu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/admin/success.jsp")//监听myServlet所有、登陆成功jsp页面、全部html页面
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AuthFilter过滤器启动");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AuthFilter过滤器执行");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		Object user = servletRequest.getSession().getAttribute("sion_user");
		boolean flag = true;
		if (user == null) {
			flag = false;
		}
		System.out.println(user);
		if (flag) {//flag为true,表示是合法用户(不是从地址栏进入的,则通过)
//			System.out.println(user);
			chain.doFilter(servletRequest, servletResponse);
		} else {
			System.out.println("回去！！！！！");
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/admin/login2.jsp");
			return;
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("AuthFilter过滤器销毁");
	}

}
