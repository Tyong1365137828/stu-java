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

@WebFilter(urlPatterns={"/admin_adm/success.jsp","/admin_user/success.jsp"}) // urlPatterns�ڿ�����jsp��Servlet��html�ȶ����
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
		Object adm = servletRequest.getSession().getAttribute("sion_adm");
		boolean user_flag = true;
		boolean adm_flag = true;
		if (user == null) {
			user_flag = false;
		}
		if (adm == null) {
			adm_flag = false;
		}
		System.out.println("adm=" + adm);
		System.out.println("user=" + user);

		if (user_flag) {// flagΪtrue,��ʾ�ǺϷ��û�(���Ǵӵ�ַ�������,��ͨ��)
			// System.out.println(user);
			chain.doFilter(servletRequest, servletResponse);
		} else if (adm_flag) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			System.out.println("��ȥ����������");
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.jsp");
			return;
		}

	}

	@Override
	public void destroy() {
		System.out.println("AuthFilter����������");
	}

}
