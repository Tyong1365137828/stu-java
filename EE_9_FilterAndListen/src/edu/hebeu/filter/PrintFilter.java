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
 * 结构类似于servlet,
 * 补充：servlet的三兄弟：Filter 、 Listener 、 Servlet
 *
 */
@WebFilter(filterName="PrintFil",urlPatterns="/myServlet/*")//其中filterName(可选)表示该过滤器的名字,urlPatterns(必选)表示所有的myServlet都要经过此过滤器		"/*"表示所有都要经过此过滤器,"
public class PrintFilter implements Filter{

	/**
	 * 初始化
	 * 随服务器启动执行
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("PrintFilter启动");
	}

	/**
	 * 做过滤器
	 * 根据本Filter的注解范围与客户端请求访问进行执行
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("PrintFilter执行");
			
			//1、预处理,访问其他资源前的处理
			request.setCharacterEncoding("utf-8");//中文乱码的处理
			
			//2、传递链
			chain.doFilter(request, response);//如果不加这句话就不会得到页面
			
			//3、后处理
			
	}

	/**
	 * 销毁
	 * 随服务器销毁执行
	 */
	@Override
	public void destroy() {
		System.out.println("PrintFilter销毁！！！");
	}

	
}
