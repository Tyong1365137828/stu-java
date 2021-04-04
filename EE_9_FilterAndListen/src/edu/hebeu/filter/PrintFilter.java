package edu.hebeu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * �ṹ������servlet,
 * ���䣺servlet�����ֵܣ�Filter �� Listener �� Servlet
 *
 */
@WebFilter(filterName="PrintFil",urlPatterns="/myServlet/*")//����filterName(��ѡ)��ʾ�ù�����������,urlPatterns(��ѡ)��ʾ���е�myServlet��Ҫ�����˹�����		"/*"��ʾ���ж�Ҫ�����˹�����,"
public class PrintFilter implements Filter{

	/**
	 * ��ʼ��
	 * �����������ִ��
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("PrintFilter����");
	}

	/**
	 * ��������
	 * ���ݱ�Filter��ע�ⷶΧ��ͻ���������ʽ���ִ��
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("PrintFilterִ��");
			
			//1��Ԥ����,����������Դǰ�Ĵ���
			request.setCharacterEncoding("utf-8");//��������Ĵ���
			
			//2��������
			chain.doFilter(request, response);//���������仰�Ͳ���õ�ҳ��
			
			//3������
			
	}

	/**
	 * ����
	 * �����������ִ��
	 */
	@Override
	public void destroy() {
		System.out.println("PrintFilter���٣�����");
	}

	
}
