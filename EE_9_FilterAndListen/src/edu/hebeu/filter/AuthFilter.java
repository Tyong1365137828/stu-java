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

@WebFilter("/admin/success.jsp")//����myServlet���С���½�ɹ�jspҳ�桢ȫ��htmlҳ��
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AuthFilter����������");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AuthFilter������ִ��");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		Object user = servletRequest.getSession().getAttribute("sion_user");
		boolean flag = true;
		if (user == null) {
			flag = false;
		}
		System.out.println(user);
		if (flag) {//flagΪtrue,��ʾ�ǺϷ��û�(���Ǵӵ�ַ�������,��ͨ��)
//			System.out.println(user);
			chain.doFilter(servletRequest, servletResponse);
		} else {
			System.out.println("��ȥ����������");
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/admin/login2.jsp");
			return;
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("AuthFilter����������");
	}

}
